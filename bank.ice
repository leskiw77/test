#ifndef BANK_ICE
#define BANK_ICE

module Bank
{
  enum CurrencyIce { PLN, EUR, USD, GBP }

  enum AccountType {STANDARD, PREMIUM }

  struct MoneyAmount {
    double amount;
    CurrencyIce currency;
  }

  struct Date {
    short day;
    short month;
    int year;
  }

  struct PersonData {
    string name;
    string lastName;
    string pesel;
  }

  exception UnsupportedCurrency{}

  exception InsufficientAccount{}

  interface Account {
    MoneyAmount getCreditCost(MoneyAmount amount, Date finishDate) throws UnsupportedCurrency, InsufficientAccount;
    MoneyAmount getActualAmount();
    string getGuid();
    AccountType getAccountType();
  }

  interface BankService {
    Account* createAccount(PersonData personData, MoneyAmount monthIncome) throws UnsupportedCurrency;
  };
};

#endif