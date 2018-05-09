package currencyservice;

import io.grpc.stub.StreamObserver;
import sr.grpc.gen.Currency;
import sr.grpc.gen.CurrencyList;
import sr.grpc.gen.CurrencyServiceGrpc.CurrencyServiceImplBase;
import sr.grpc.gen.ExchangeRate;

import java.util.HashMap;
import java.util.Map;

public class CurrencyServiceImpl extends CurrencyServiceImplBase {
    private final CurrencyRates currencyRates;

    public CurrencyServiceImpl() {
        this.currencyRates = CurrencyRates.getInstance();
    }

    @Override
    public void getExchangeRates(CurrencyList request, StreamObserver<ExchangeRate> responseObserver) {
        try {
            while (true) {
                for (Currency currency : request.getChosenCurrenciesList()) {
                    ExchangeRate exchangeRate = ExchangeRate
                            .newBuilder()
                            .setCurrency(currency)
                            .setRate(currencyRates.getExchangeRates().get(currency))
                            .build();
                    responseObserver.onNext(exchangeRate);
                }
                currencyRates.modifyRates();
                Thread.sleep(5000);
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        responseObserver.onCompleted();
    }
}
