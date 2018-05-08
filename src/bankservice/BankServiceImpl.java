package bankservice;

import Bank.*;
import bank.ExchangeRateServiceThread;
import com.zeroc.Ice.Current;
import com.zeroc.Ice.Identity;
import sr.grpc.gen.Currency;

public class BankServiceImpl implements BankService {
    private final ExchangeRateServiceThread exchangeRateService;

    public BankServiceImpl(ExchangeRateServiceThread exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @Override
    public AccountPrx createAccount(PersonData personData, MoneyAmount monthIncome, Current current) throws UnsupportedCurrency {
        AccountType type = decideAccountType(monthIncome);

        System.out.println("Create user: " + personData.name + " " + personData.lastName + " " + personData.pesel +
                ", account type: " + type);

        return AccountPrx.uncheckedCast(current.adapter.add(
                new AccountImpl(personData, monthIncome, type, exchangeRateService),
                new Identity(personData.pesel, type.name())));
    }

    private AccountType decideAccountType(MoneyAmount monthIncome) throws UnsupportedCurrency {
        if (getMonthIncomeInPln(monthIncome.amount, monthIncome.currency) > 5000) {
            return AccountType.PREMIUM;
        } else {
            return AccountType.STANDARD;
        }
    }

    private double getMonthIncomeInPln(double amount, CurrencyIce currency) throws UnsupportedCurrency {
        Currency c = Currency.valueOf(currency.toString());
        if(!exchangeRateService.getRates().containsKey(c)){
            System.out.println("This bank do not support " + c);
            throw new UnsupportedCurrency();
        }
        return amount * exchangeRateService.getRates().get(c);
    }
}
