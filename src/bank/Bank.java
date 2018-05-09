package bank;

import bankservice.BankServiceImpl;
import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.Identity;
import com.zeroc.Ice.ObjectAdapter;
import com.zeroc.Ice.Util;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import sr.grpc.gen.Currency;
import sr.grpc.gen.CurrencyServiceGrpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


public class Bank {
    public static final int PORT = 50051;

    private final ManagedChannel channel;
    private final ExchangeRateServiceThread exchangeRateServiceThread;

    public Bank(String host, int port, List<Currency> currencies) {
        channel = ManagedChannelBuilder.forAddress(host, port)
        		.usePlaintext(true)
                .build();

        exchangeRateServiceThread = new ExchangeRateServiceThread(CurrencyServiceGrpc.newBlockingStub(channel), currencies);
        exchangeRateServiceThread.start();
    }

    public static void main(String[] args) throws Exception {
        List<Currency> currencies = askForCurrencies();

        Bank bank = new Bank("localhost", PORT, currencies);
        bank.start();
    }

    public void start() throws InterruptedException {
        startBankService();
        joinBankExchangeRateThread();
//        shutdownCurrencyServerChannel();
    }

    public void shutdownCurrencyServerChannel() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void joinBankExchangeRateThread() {
        try {
            exchangeRateServiceThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void startBankService() {
        Communicator communicator = null;

        try {
            communicator = Util.initialize(new String[0], "config.server");
            ObjectAdapter adapter = communicator.createObjectAdapter("Adapter1");

            BankServiceImpl bankServant = new BankServiceImpl(exchangeRateServiceThread);

            adapter.add(bankServant, new Identity("bank1", "bank"));
            adapter.activate();
            communicator.waitForShutdown();

        } catch (Exception e) {
            System.err.println(e);
        }
        if (communicator != null) {
            try {
                communicator.destroy();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }

    private static List<Currency> askForCurrencies() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Insert currencies, separated with comma. Available currencies: EUR, GBP, USD");
        String line = in.readLine();

        List<Currency> currencies = new ArrayList<>();
        currencies.add(Currency.PLN);

        for (String currency : line.split(",")) {
            currencies.add(Currency.valueOf(currency.trim().toUpperCase()));
        }

        System.out.println("Available currencies: " + currencies.stream()
                .map(Currency::toString)
                .collect(Collectors.joining(", ")));
        return currencies;
    }
}
