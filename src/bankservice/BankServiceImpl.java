package bankservice;

import Bank.*;
import bank.ExchangeRateServiceThread;
import com.zeroc.Ice.AlreadyRegisteredException;
import com.zeroc.Ice.Current;
import com.zeroc.Ice.Identity;
import sr.grpc.gen.Currency;

import java.util.HashMap;
import java.util.Map;

public class BankServiceImpl implements BankService {
    private final ExchangeRateServiceThread exchangeRateService;
    private final Map<String, AccountPrx> guidAccountMap;

    public BankServiceImpl(ExchangeRateServiceThread exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
        this.guidAccountMap = new HashMap<>();
    }

    @Override
    public AccountPrx createAccount(PersonData personData, MoneyAmount monthIncome, Current current) throws UnsupportedCurrency, AlreadyCreated {
        AccountType type = decideAccountType(monthIncome);

        System.out.println("Create user: " + personData.name + " " + personData.lastName + " " + personData.pesel +
                ", account type: " + type);


        AccountImpl account = new AccountImpl(personData, monthIncome, type, exchangeRateService);

        AccountPrx accountPrx;
        try {
            accountPrx = AccountPrx.uncheckedCast(current.adapter.add(
                    account, new Identity(personData.pesel, "pesel")));
        }catch (AlreadyRegisteredException e){
            System.out.println("User with pesel: " + personData.pesel + " already created");
            throw new AlreadyCreated();
        }
        guidAccountMap.put(account.getGuid(), accountPrx);

        return accountPrx;
    }

    @Override
    public AccountPrx getAccountForGuid(String guid, Current current) throws NoSuchAccount {
        if(guidAccountMap.containsKey(guid)){
            return guidAccountMap.get(guid);
        }else{
            throw new NoSuchAccount();
        }
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
