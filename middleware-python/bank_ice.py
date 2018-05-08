# -*- coding: utf-8 -*-
# **********************************************************************
#
# Copyright (c) 2003-2018 ZeroC, Inc. All rights reserved.
#
# This copy of Ice is licensed to you under the terms described in the
# ICE_LICENSE file included in this distribution.
#
# **********************************************************************
#
# Ice version 3.7.1
#
# <auto-generated>
#
# Generated from file `bank.ice'
#
# Warning: do not edit this file.
#
# </auto-generated>
#

from sys import version_info as _version_info_
import Ice, IcePy

# Start of module Bank
_M_Bank = Ice.openModule('Bank')
__name__ = 'Bank'

if 'CurrencyIce' not in _M_Bank.__dict__:
    _M_Bank.CurrencyIce = Ice.createTempClass()
    class CurrencyIce(Ice.EnumBase):

        def __init__(self, _n, _v):
            Ice.EnumBase.__init__(self, _n, _v)

        def valueOf(self, _n):
            if _n in self._enumerators:
                return self._enumerators[_n]
            return None
        valueOf = classmethod(valueOf)

    CurrencyIce.PLN = CurrencyIce("PLN", 0)
    CurrencyIce.EUR = CurrencyIce("EUR", 1)
    CurrencyIce.USD = CurrencyIce("USD", 2)
    CurrencyIce.GBP = CurrencyIce("GBP", 3)
    CurrencyIce._enumerators = { 0:CurrencyIce.PLN, 1:CurrencyIce.EUR, 2:CurrencyIce.USD, 3:CurrencyIce.GBP }

    _M_Bank._t_CurrencyIce = IcePy.defineEnum('::Bank::CurrencyIce', CurrencyIce, (), CurrencyIce._enumerators)

    _M_Bank.CurrencyIce = CurrencyIce
    del CurrencyIce

if 'AccountType' not in _M_Bank.__dict__:
    _M_Bank.AccountType = Ice.createTempClass()
    class AccountType(Ice.EnumBase):

        def __init__(self, _n, _v):
            Ice.EnumBase.__init__(self, _n, _v)

        def valueOf(self, _n):
            if _n in self._enumerators:
                return self._enumerators[_n]
            return None
        valueOf = classmethod(valueOf)

    AccountType.STANDARD = AccountType("STANDARD", 0)
    AccountType.PREMIUM = AccountType("PREMIUM", 1)
    AccountType._enumerators = { 0:AccountType.STANDARD, 1:AccountType.PREMIUM }

    _M_Bank._t_AccountType = IcePy.defineEnum('::Bank::AccountType', AccountType, (), AccountType._enumerators)

    _M_Bank.AccountType = AccountType
    del AccountType

if 'MoneyAmount' not in _M_Bank.__dict__:
    _M_Bank.MoneyAmount = Ice.createTempClass()
    class MoneyAmount(object):
        def __init__(self, amount=0.0, currency=_M_Bank.CurrencyIce.PLN):
            self.amount = amount
            self.currency = currency

        def __eq__(self, other):
            if other is None:
                return False
            elif not isinstance(other, _M_Bank.MoneyAmount):
                return NotImplemented
            else:
                if self.amount != other.amount:
                    return False
                if self.currency != other.currency:
                    return False
                return True

        def __ne__(self, other):
            return not self.__eq__(other)

        def __str__(self):
            return IcePy.stringify(self, _M_Bank._t_MoneyAmount)

        __repr__ = __str__

    _M_Bank._t_MoneyAmount = IcePy.defineStruct('::Bank::MoneyAmount', MoneyAmount, (), (
        ('amount', (), IcePy._t_double),
        ('currency', (), _M_Bank._t_CurrencyIce)
    ))

    _M_Bank.MoneyAmount = MoneyAmount
    del MoneyAmount

if 'Date' not in _M_Bank.__dict__:
    _M_Bank.Date = Ice.createTempClass()
    class Date(object):
        def __init__(self, day=0, month=0, year=0):
            self.day = day
            self.month = month
            self.year = year

        def __hash__(self):
            _h = 0
            _h = 5 * _h + Ice.getHash(self.day)
            _h = 5 * _h + Ice.getHash(self.month)
            _h = 5 * _h + Ice.getHash(self.year)
            return _h % 0x7fffffff

        def __compare(self, other):
            if other is None:
                return 1
            elif not isinstance(other, _M_Bank.Date):
                return NotImplemented
            else:
                if self.day is None or other.day is None:
                    if self.day != other.day:
                        return (-1 if self.day is None else 1)
                else:
                    if self.day < other.day:
                        return -1
                    elif self.day > other.day:
                        return 1
                if self.month is None or other.month is None:
                    if self.month != other.month:
                        return (-1 if self.month is None else 1)
                else:
                    if self.month < other.month:
                        return -1
                    elif self.month > other.month:
                        return 1
                if self.year is None or other.year is None:
                    if self.year != other.year:
                        return (-1 if self.year is None else 1)
                else:
                    if self.year < other.year:
                        return -1
                    elif self.year > other.year:
                        return 1
                return 0

        def __lt__(self, other):
            r = self.__compare(other)
            if r is NotImplemented:
                return r
            else:
                return r < 0

        def __le__(self, other):
            r = self.__compare(other)
            if r is NotImplemented:
                return r
            else:
                return r <= 0

        def __gt__(self, other):
            r = self.__compare(other)
            if r is NotImplemented:
                return r
            else:
                return r > 0

        def __ge__(self, other):
            r = self.__compare(other)
            if r is NotImplemented:
                return r
            else:
                return r >= 0

        def __eq__(self, other):
            r = self.__compare(other)
            if r is NotImplemented:
                return r
            else:
                return r == 0

        def __ne__(self, other):
            r = self.__compare(other)
            if r is NotImplemented:
                return r
            else:
                return r != 0

        def __str__(self):
            return IcePy.stringify(self, _M_Bank._t_Date)

        __repr__ = __str__

    _M_Bank._t_Date = IcePy.defineStruct('::Bank::Date', Date, (), (
        ('day', (), IcePy._t_short),
        ('month', (), IcePy._t_short),
        ('year', (), IcePy._t_int)
    ))

    _M_Bank.Date = Date
    del Date

if 'PersonData' not in _M_Bank.__dict__:
    _M_Bank.PersonData = Ice.createTempClass()
    class PersonData(object):
        def __init__(self, name='', lastName='', pesel=''):
            self.name = name
            self.lastName = lastName
            self.pesel = pesel

        def __hash__(self):
            _h = 0
            _h = 5 * _h + Ice.getHash(self.name)
            _h = 5 * _h + Ice.getHash(self.lastName)
            _h = 5 * _h + Ice.getHash(self.pesel)
            return _h % 0x7fffffff

        def __compare(self, other):
            if other is None:
                return 1
            elif not isinstance(other, _M_Bank.PersonData):
                return NotImplemented
            else:
                if self.name is None or other.name is None:
                    if self.name != other.name:
                        return (-1 if self.name is None else 1)
                else:
                    if self.name < other.name:
                        return -1
                    elif self.name > other.name:
                        return 1
                if self.lastName is None or other.lastName is None:
                    if self.lastName != other.lastName:
                        return (-1 if self.lastName is None else 1)
                else:
                    if self.lastName < other.lastName:
                        return -1
                    elif self.lastName > other.lastName:
                        return 1
                if self.pesel is None or other.pesel is None:
                    if self.pesel != other.pesel:
                        return (-1 if self.pesel is None else 1)
                else:
                    if self.pesel < other.pesel:
                        return -1
                    elif self.pesel > other.pesel:
                        return 1
                return 0

        def __lt__(self, other):
            r = self.__compare(other)
            if r is NotImplemented:
                return r
            else:
                return r < 0

        def __le__(self, other):
            r = self.__compare(other)
            if r is NotImplemented:
                return r
            else:
                return r <= 0

        def __gt__(self, other):
            r = self.__compare(other)
            if r is NotImplemented:
                return r
            else:
                return r > 0

        def __ge__(self, other):
            r = self.__compare(other)
            if r is NotImplemented:
                return r
            else:
                return r >= 0

        def __eq__(self, other):
            r = self.__compare(other)
            if r is NotImplemented:
                return r
            else:
                return r == 0

        def __ne__(self, other):
            r = self.__compare(other)
            if r is NotImplemented:
                return r
            else:
                return r != 0

        def __str__(self):
            return IcePy.stringify(self, _M_Bank._t_PersonData)

        __repr__ = __str__

    _M_Bank._t_PersonData = IcePy.defineStruct('::Bank::PersonData', PersonData, (), (
        ('name', (), IcePy._t_string),
        ('lastName', (), IcePy._t_string),
        ('pesel', (), IcePy._t_string)
    ))

    _M_Bank.PersonData = PersonData
    del PersonData

if 'UnsupportedCurrency' not in _M_Bank.__dict__:
    _M_Bank.UnsupportedCurrency = Ice.createTempClass()
    class UnsupportedCurrency(Ice.UserException):
        def __init__(self):
            pass

        def __str__(self):
            return IcePy.stringifyException(self)

        __repr__ = __str__

        _ice_id = '::Bank::UnsupportedCurrency'

    _M_Bank._t_UnsupportedCurrency = IcePy.defineException('::Bank::UnsupportedCurrency', UnsupportedCurrency, (), False, None, ())
    UnsupportedCurrency._ice_type = _M_Bank._t_UnsupportedCurrency

    _M_Bank.UnsupportedCurrency = UnsupportedCurrency
    del UnsupportedCurrency

if 'InsufficientAccount' not in _M_Bank.__dict__:
    _M_Bank.InsufficientAccount = Ice.createTempClass()
    class InsufficientAccount(Ice.UserException):
        def __init__(self):
            pass

        def __str__(self):
            return IcePy.stringifyException(self)

        __repr__ = __str__

        _ice_id = '::Bank::InsufficientAccount'

    _M_Bank._t_InsufficientAccount = IcePy.defineException('::Bank::InsufficientAccount', InsufficientAccount, (), False, None, ())
    InsufficientAccount._ice_type = _M_Bank._t_InsufficientAccount

    _M_Bank.InsufficientAccount = InsufficientAccount
    del InsufficientAccount

_M_Bank._t_Account = IcePy.defineValue('::Bank::Account', Ice.Value, -1, (), False, True, None, ())

if 'AccountPrx' not in _M_Bank.__dict__:
    _M_Bank.AccountPrx = Ice.createTempClass()
    class AccountPrx(Ice.ObjectPrx):

        def getCreditCost(self, amount, finishDate, context=None):
            return _M_Bank.Account._op_getCreditCost.invoke(self, ((amount, finishDate), context))

        def getCreditCostAsync(self, amount, finishDate, context=None):
            return _M_Bank.Account._op_getCreditCost.invokeAsync(self, ((amount, finishDate), context))

        def begin_getCreditCost(self, amount, finishDate, _response=None, _ex=None, _sent=None, context=None):
            return _M_Bank.Account._op_getCreditCost.begin(self, ((amount, finishDate), _response, _ex, _sent, context))

        def end_getCreditCost(self, _r):
            return _M_Bank.Account._op_getCreditCost.end(self, _r)

        def getActualAmount(self, context=None):
            return _M_Bank.Account._op_getActualAmount.invoke(self, ((), context))

        def getActualAmountAsync(self, context=None):
            return _M_Bank.Account._op_getActualAmount.invokeAsync(self, ((), context))

        def begin_getActualAmount(self, _response=None, _ex=None, _sent=None, context=None):
            return _M_Bank.Account._op_getActualAmount.begin(self, ((), _response, _ex, _sent, context))

        def end_getActualAmount(self, _r):
            return _M_Bank.Account._op_getActualAmount.end(self, _r)

        def getGuid(self, context=None):
            return _M_Bank.Account._op_getGuid.invoke(self, ((), context))

        def getGuidAsync(self, context=None):
            return _M_Bank.Account._op_getGuid.invokeAsync(self, ((), context))

        def begin_getGuid(self, _response=None, _ex=None, _sent=None, context=None):
            return _M_Bank.Account._op_getGuid.begin(self, ((), _response, _ex, _sent, context))

        def end_getGuid(self, _r):
            return _M_Bank.Account._op_getGuid.end(self, _r)

        def getAccountType(self, context=None):
            return _M_Bank.Account._op_getAccountType.invoke(self, ((), context))

        def getAccountTypeAsync(self, context=None):
            return _M_Bank.Account._op_getAccountType.invokeAsync(self, ((), context))

        def begin_getAccountType(self, _response=None, _ex=None, _sent=None, context=None):
            return _M_Bank.Account._op_getAccountType.begin(self, ((), _response, _ex, _sent, context))

        def end_getAccountType(self, _r):
            return _M_Bank.Account._op_getAccountType.end(self, _r)

        @staticmethod
        def checkedCast(proxy, facetOrContext=None, context=None):
            return _M_Bank.AccountPrx.ice_checkedCast(proxy, '::Bank::Account', facetOrContext, context)

        @staticmethod
        def uncheckedCast(proxy, facet=None):
            return _M_Bank.AccountPrx.ice_uncheckedCast(proxy, facet)

        @staticmethod
        def ice_staticId():
            return '::Bank::Account'
    _M_Bank._t_AccountPrx = IcePy.defineProxy('::Bank::Account', AccountPrx)

    _M_Bank.AccountPrx = AccountPrx
    del AccountPrx

    _M_Bank.Account = Ice.createTempClass()
    class Account(Ice.Object):

        def ice_ids(self, current=None):
            return ('::Bank::Account', '::Ice::Object')

        def ice_id(self, current=None):
            return '::Bank::Account'

        @staticmethod
        def ice_staticId():
            return '::Bank::Account'

        def getCreditCost(self, amount, finishDate, current=None):
            raise NotImplementedError("servant method 'getCreditCost' not implemented")

        def getActualAmount(self, current=None):
            raise NotImplementedError("servant method 'getActualAmount' not implemented")

        def getGuid(self, current=None):
            raise NotImplementedError("servant method 'getGuid' not implemented")

        def getAccountType(self, current=None):
            raise NotImplementedError("servant method 'getAccountType' not implemented")

        def __str__(self):
            return IcePy.stringify(self, _M_Bank._t_AccountDisp)

        __repr__ = __str__

    _M_Bank._t_AccountDisp = IcePy.defineClass('::Bank::Account', Account, (), None, ())
    Account._ice_type = _M_Bank._t_AccountDisp

    Account._op_getCreditCost = IcePy.Operation('getCreditCost', Ice.OperationMode.Normal, Ice.OperationMode.Normal, False, None, (), (((), _M_Bank._t_MoneyAmount, False, 0), ((), _M_Bank._t_Date, False, 0)), (), ((), _M_Bank._t_MoneyAmount, False, 0), (_M_Bank._t_UnsupportedCurrency, _M_Bank._t_InsufficientAccount))
    Account._op_getActualAmount = IcePy.Operation('getActualAmount', Ice.OperationMode.Normal, Ice.OperationMode.Normal, False, None, (), (), (), ((), _M_Bank._t_MoneyAmount, False, 0), ())
    Account._op_getGuid = IcePy.Operation('getGuid', Ice.OperationMode.Normal, Ice.OperationMode.Normal, False, None, (), (), (), ((), IcePy._t_string, False, 0), ())
    Account._op_getAccountType = IcePy.Operation('getAccountType', Ice.OperationMode.Normal, Ice.OperationMode.Normal, False, None, (), (), (), ((), _M_Bank._t_AccountType, False, 0), ())

    _M_Bank.Account = Account
    del Account

_M_Bank._t_BankService = IcePy.defineValue('::Bank::BankService', Ice.Value, -1, (), False, True, None, ())

if 'BankServicePrx' not in _M_Bank.__dict__:
    _M_Bank.BankServicePrx = Ice.createTempClass()
    class BankServicePrx(Ice.ObjectPrx):

        def createAccount(self, personData, monthIncome, context=None):
            return _M_Bank.BankService._op_createAccount.invoke(self, ((personData, monthIncome), context))

        def createAccountAsync(self, personData, monthIncome, context=None):
            return _M_Bank.BankService._op_createAccount.invokeAsync(self, ((personData, monthIncome), context))

        def begin_createAccount(self, personData, monthIncome, _response=None, _ex=None, _sent=None, context=None):
            return _M_Bank.BankService._op_createAccount.begin(self, ((personData, monthIncome), _response, _ex, _sent, context))

        def end_createAccount(self, _r):
            return _M_Bank.BankService._op_createAccount.end(self, _r)

        @staticmethod
        def checkedCast(proxy, facetOrContext=None, context=None):
            return _M_Bank.BankServicePrx.ice_checkedCast(proxy, '::Bank::BankService', facetOrContext, context)

        @staticmethod
        def uncheckedCast(proxy, facet=None):
            return _M_Bank.BankServicePrx.ice_uncheckedCast(proxy, facet)

        @staticmethod
        def ice_staticId():
            return '::Bank::BankService'
    _M_Bank._t_BankServicePrx = IcePy.defineProxy('::Bank::BankService', BankServicePrx)

    _M_Bank.BankServicePrx = BankServicePrx
    del BankServicePrx

    _M_Bank.BankService = Ice.createTempClass()
    class BankService(Ice.Object):

        def ice_ids(self, current=None):
            return ('::Bank::BankService', '::Ice::Object')

        def ice_id(self, current=None):
            return '::Bank::BankService'

        @staticmethod
        def ice_staticId():
            return '::Bank::BankService'

        def createAccount(self, personData, monthIncome, current=None):
            raise NotImplementedError("servant method 'createAccount' not implemented")

        def __str__(self):
            return IcePy.stringify(self, _M_Bank._t_BankServiceDisp)

        __repr__ = __str__

    _M_Bank._t_BankServiceDisp = IcePy.defineClass('::Bank::BankService', BankService, (), None, ())
    BankService._ice_type = _M_Bank._t_BankServiceDisp

    BankService._op_createAccount = IcePy.Operation('createAccount', Ice.OperationMode.Normal, Ice.OperationMode.Normal, False, None, (), (((), _M_Bank._t_PersonData, False, 0), ((), _M_Bank._t_MoneyAmount, False, 0)), (), ((), _M_Bank._t_AccountPrx, False, 0), (_M_Bank._t_UnsupportedCurrency,))

    _M_Bank.BankService = BankService
    del BankService

# End of module Bank
