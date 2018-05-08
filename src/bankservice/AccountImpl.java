package bankservice;

import Bank.*;
import bank.ExchangeRateServiceThread;
import com.zeroc.Ice.Current;
import sr.grpc.gen.Currency;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Random;


public class AccountImpl implements Account {
    private final String name;
    private final String lastName;
    private final String pesel;
    private final MoneyAmount monthIncome;
    private final AccountType accountType;
    private final String guid;
    private ExchangeRateServiceThread exchangeRateService;

    public AccountImpl(PersonData data, MoneyAmount monthIncome, AccountType accountType,
                       ExchangeRateServiceThread exchangeRateService) {
        this.name = data.name;
        this.lastName = data.lastName;
        this.pesel = data.pesel;
        this.monthIncome = monthIncome;
        this.accountType = accountType;
        this.exchangeRateService = exchangeRateService;
        //todo: add real guid generator
        this.guid = sillyRandomGuid();
    }

    @Override
    public MoneyAmount getCreditCost(MoneyAmount money, Date finishDate, Current current) throws UnsupportedCurrency, InsufficientAccount {
        if (accountType == AccountType.STANDARD) {
            throw new InsufficientAccount();
        }

        Map<Currency, Float> exchangeRates = exchangeRateService.getRates();

        if(!exchangeRateService.getRates().containsKey(Currency.valueOf(money.currency.toString()))){
            System.out.println("This bank do not support " + money.currency.toString());
            throw new UnsupportedCurrency();
        }

        float rate = exchangeRates.get(Currency.valueOf(money.currency.toString()));

        double creditCost = ((money.amount * 0.01f * monthsToNow(finishDate)) + money.amount) * rate;
        return new MoneyAmount(creditCost, CurrencyIce.PLN);
    }

    @Override
    public MoneyAmount getActualAmount(Current current) {
        return new MoneyAmount(monthIncome.amount, monthIncome.currency);
    }

    @Override
    public String getGuid(Current current) {
        return guid;
    }

    @Override
    public AccountType getAccountType(Current current) {
        return this.accountType;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public MoneyAmount getMonthIncome() {
        return monthIncome;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public String getGuid() {
        return guid;
    }

    private String sillyRandomGuid(){
        Random r = new Random();
        char c = (char)(r.nextInt(26) + 'a');
        return String.valueOf(c);
    }

    private int monthsToNow(Date date){
        LocalDateTime currentDate = LocalDateTime.now();
        int yearDifference = date.year - currentDate.getYear();
        int monthDifference = date.month - currentDate.getMonthValue();
        return monthDifference + yearDifference * 12;
    }
}
