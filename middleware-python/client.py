import sys

import Ice

import Bank
from Bank import PersonData, MoneyAmount, CurrencyIce, Date

def get_currency_for(currency_string):
    return {
        'PLN': CurrencyIce.PLN,
        'EUR': CurrencyIce.EUR,
        'USD': CurrencyIce.USD,
        'GBP': CurrencyIce.GBP
    }[currency_string]

with Ice.initialize(sys.argv, 'config.client') as communicator:
    base = communicator.propertyToProxy('Bank.Proxy')
    bank = Bank.BankServicePrx.checkedCast(base)
    if not bank:
        raise RuntimeError("Invalid proxy")

    accounts = dict()
    c = None
    while c != 'x':
        print('Choose action: log <guid> - sign in with guid \n'
              '               create - to create new user')

        try:
            c = sys.stdin.readline().strip()
            if c == 'create':
                print("Please provide your first name:")
                first_name = sys.stdin.readline().strip()

                print("Please provide your last name:")
                last_name = sys.stdin.readline().strip()

                print("Please provide your pesel:")
                pesel = sys.stdin.readline().strip()

                print("Please provide your month income <number> <PLN | GBP | EUR | USD> :")
                income = sys.stdin.readline().strip().upper().split(" ")

                try:
                    account = bank.createAccount(PersonData(first_name, last_name, pesel),
                                             MoneyAmount(int(income[0]), get_currency_for(income[1])))
                except Bank.UnsupportedCurrency as e:
                    print('You currency is not supported')
                    continue
                except Bank.AlreadyCreated:
                    print('Duplicated user pesel')
                    continue

                print('You are a {} user, your guid is {}'.format(account.getAccountType(), account.getGuid()))
                accounts[account.getGuid()] = account
            elif c.split(' ')[0].strip() == 'log':
                guid = c.split(' ')[1].strip()

                try:
                    account = bank.getAccountForGuid(guid)
                    print('Logged in')
                except Bank.NoSuchAccount:
                    print('No user with such guid')
                    continue

                print('Choose action: amount - check your account \n'
                      '               loan - take a loan')

                o = sys.stdin.readline().strip()

                if o == 'amount':
                        amount = account.getActualAmount()
                        print(str(amount.amount) + " " + str(amount.currency))

                elif o == 'loan':
                    print("Please provide loan amount <number> <PLN | GBP | EUR | USD> :")
                    money = sys.stdin.readline().strip().upper().split(" ")

                    print("Please specify end date: <day> <month> <year> e.g. 01 03 2019")
                    date = sys.stdin.readline().strip().split(" ")

                    try:
                        amount = int(money[0])
                        currency = get_currency_for(money[1])
                        endDate = Date(int(date[0]), int(date[1]), int(date[2]))
                    except IndexError:
                        print('Wrong input')
                        continue

                    try:
                        creditCost = account.getCreditCost(MoneyAmount(amount, currency), endDate)
                    except Bank.UnsupportedCurrency as e:
                        print('You currency is not supported')
                        continue

                    except Bank.InsufficientAccount as e:
                        print('Insufficient Account')
                        continue

                    print('Credit cost:')
                    print(str(creditCost))

                else:
                    print('Unknown option. Logging off')

        except Ice.Exception as ex:
            print(ex)


