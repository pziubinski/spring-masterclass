package pl.training.shop.payments;

import org.javamoney.moneta.FastMoney;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import java.util.Locale;

public class LocalMoney {

    public static FastMoney of(Number number) {

        return FastMoney.of(number, getCurrencyUnit());
    }

    public static FastMoney zero() {
        return FastMoney.zero(getCurrencyUnit());
    }

    private static CurrencyUnit getCurrencyUnit() {
        var locale = Locale.getDefault();
        return Monetary.getCurrency(locale);
    }

}
