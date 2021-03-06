// **********************************************************************
//
// Copyright (c) 2003-2018 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.7.1
//
// <auto-generated>
//
// Generated from file `bank.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package Bank;

public class CreditCostPair implements java.lang.Cloneable,
                                       java.io.Serializable
{
    public MoneyAmount nativeCurrencyMoney;

    public MoneyAmount actualCurrencyMoney;

    public CreditCostPair()
    {
        this.nativeCurrencyMoney = new MoneyAmount();
        this.actualCurrencyMoney = new MoneyAmount();
    }

    public CreditCostPair(MoneyAmount nativeCurrencyMoney, MoneyAmount actualCurrencyMoney)
    {
        this.nativeCurrencyMoney = nativeCurrencyMoney;
        this.actualCurrencyMoney = actualCurrencyMoney;
    }

    public boolean equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        CreditCostPair r = null;
        if(rhs instanceof CreditCostPair)
        {
            r = (CreditCostPair)rhs;
        }

        if(r != null)
        {
            if(this.nativeCurrencyMoney != r.nativeCurrencyMoney)
            {
                if(this.nativeCurrencyMoney == null || r.nativeCurrencyMoney == null || !this.nativeCurrencyMoney.equals(r.nativeCurrencyMoney))
                {
                    return false;
                }
            }
            if(this.actualCurrencyMoney != r.actualCurrencyMoney)
            {
                if(this.actualCurrencyMoney == null || r.actualCurrencyMoney == null || !this.actualCurrencyMoney.equals(r.actualCurrencyMoney))
                {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    public int hashCode()
    {
        int h_ = 5381;
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, "::Bank::CreditCostPair");
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, nativeCurrencyMoney);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, actualCurrencyMoney);
        return h_;
    }

    public CreditCostPair clone()
    {
        CreditCostPair c = null;
        try
        {
            c = (CreditCostPair)super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return c;
    }

    public void ice_writeMembers(com.zeroc.Ice.OutputStream ostr)
    {
        MoneyAmount.ice_write(ostr, this.nativeCurrencyMoney);
        MoneyAmount.ice_write(ostr, this.actualCurrencyMoney);
    }

    public void ice_readMembers(com.zeroc.Ice.InputStream istr)
    {
        this.nativeCurrencyMoney = MoneyAmount.ice_read(istr);
        this.actualCurrencyMoney = MoneyAmount.ice_read(istr);
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, CreditCostPair v)
    {
        if(v == null)
        {
            _nullMarshalValue.ice_writeMembers(ostr);
        }
        else
        {
            v.ice_writeMembers(ostr);
        }
    }

    static public CreditCostPair ice_read(com.zeroc.Ice.InputStream istr)
    {
        CreditCostPair v = new CreditCostPair();
        v.ice_readMembers(istr);
        return v;
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, java.util.Optional<CreditCostPair> v)
    {
        if(v != null && v.isPresent())
        {
            ice_write(ostr, tag, v.get());
        }
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, CreditCostPair v)
    {
        if(ostr.writeOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            int pos = ostr.startSize();
            ice_write(ostr, v);
            ostr.endSize(pos);
        }
    }

    static public java.util.Optional<CreditCostPair> ice_read(com.zeroc.Ice.InputStream istr, int tag)
    {
        if(istr.readOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            istr.skip(4);
            return java.util.Optional.of(CreditCostPair.ice_read(istr));
        }
        else
        {
            return java.util.Optional.empty();
        }
    }

    private static final CreditCostPair _nullMarshalValue = new CreditCostPair();

    public static final long serialVersionUID = -769654194L;
}
