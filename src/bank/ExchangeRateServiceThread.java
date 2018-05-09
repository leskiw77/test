package bank;

import io.grpc.StatusRuntimeException;
import sr.grpc.gen.Currency;
import sr.grpc.gen.CurrencyList;
import sr.grpc.gen.CurrencyServiceGrpc.CurrencyServiceBlockingStub;
import sr.grpc.gen.ExchangeRate;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class ExchangeRateServiceThread extends Thread {
    private final CurrencyServiceBlockingStub currencyServiceBlockingStub;
    private List<Currency> currencies;
    private final Map<Currency, Float> rates = new HashMap<>();

    public ExchangeRateServiceThread(CurrencyServiceBlockingStub currencyServiceBlockingStub, List<Currency> currencies) {
        this.currencyServiceBlockingStub = currencyServiceBlockingStub;
        this.currencies = currencies;
    }

    @Override
    public void run() {
        CurrencyList currencyList = CurrencyList.newBuilder()
                .addAllChosenCurrencies(currencies)
                .build();

        Iterator<ExchangeRate> rates;
        try {
            rates = currencyServiceBlockingStub.getExchangeRates(currencyList);
            while (rates.hasNext()) {
                ExchangeRate rate = rates.next();
                synchronized (this.rates) {
                    updateRatesMap(rate);
                }
            }
        } catch (StatusRuntimeException ex) {
            System.out.println(("RPC failed: "+ ex.getStatus()));
        }
    }

    private void updateRatesMap(ExchangeRate rate) {
        rates.put(rate.getCurrency(), rate.getRate());
        if (rate.getCurrency() != Currency.PLN) {
            System.out.println("Currency updated: " + rate.getCurrency() + " " + rate.getRate());
        }
    }

    public Map<Currency, Float> getRates() {
        synchronized (rates) {
            return rates;
        }
    }
}
