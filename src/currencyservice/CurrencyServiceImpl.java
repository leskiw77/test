package currencyservice;

import io.grpc.stub.StreamObserver;
import sr.grpc.gen.Currency;
import sr.grpc.gen.CurrencyList;
import sr.grpc.gen.CurrencyServiceGrpc.CurrencyServiceImplBase;
import sr.grpc.gen.ExchangeRate;

import java.util.HashMap;
import java.util.Map;

public class CurrencyServiceImpl extends CurrencyServiceImplBase {
    private Map<Currency, Float> exchangeRates = new HashMap<>();

    public CurrencyServiceImpl() {
        exchangeRates.put(Currency.PLN, 1f);
        exchangeRates.put(Currency.EUR, 4.22f);
        exchangeRates.put(Currency.USD, 3.61f);
        exchangeRates.put(Currency.GBP, 4.89f);
    }

    @Override
    public void getExchangeRates(CurrencyList request, StreamObserver<ExchangeRate> responseObserver) {
        try {
            while (true) {
                for (Currency currency : request.getChosenCurrenciesList()) {
                    ExchangeRate exchangeRate = ExchangeRate
                            .newBuilder()
                            .setCurrency(currency)
                            .setRate(exchangeRates.get(currency))
                            .build();
                    responseObserver.onNext(exchangeRate);
                }
                modifyRates();
                Thread.sleep(5000);
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        responseObserver.onCompleted();
    }

    private void modifyRates() {
        for (Currency currency : exchangeRates.keySet()) {
            if (currency != Currency.PLN) {
                float rate = (float) (exchangeRates.get(currency) + (Math.random()-0.5) / 20);
                exchangeRates.put(currency, rate);
            }
        }
    }
}
