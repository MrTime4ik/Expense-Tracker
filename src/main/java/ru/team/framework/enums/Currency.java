package ru.team.framework.enums;

public enum Currency {

    USD("usd"), //Доллар
    EUR("eur"), //Евро
    GBP("gbp"), //Фунт стерлингов
    CHF("chf"), //Швейцарский франк
    CNY("cny"), //Юань
    RUB("rub"), //Рубль
    SEK("sek"), //Шведская крона
    JPY("jpy"); //Японская йена

    private final String currency;

    Currency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public static Currency getCurrency(String currency) {
        for (Currency curr : Currency.values()) {
            if (curr.getCurrency().equals(currency)) {
                return curr;
            }
        }
        return Currency.USD;
    }



}
