package com.liubomyr.voucher.model;

public class Cost {

    public enum Currency {
        USD("US Dollar"), EUR("Euro"), UAH("Ukrainian Hryvnia"), GBP("British Pound");

        private String currency;

        Currency(String currency) {
            this.currency = currency;
        }

        @Override
        public String toString() {
            return "Currency{" +
                    "currency='" + currency + '\'' +
                    '}';
        }
    }

    private Currency currency;
    private int amount;

    public Cost(Currency currency, int amount) {
        this.currency = currency;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Cost{" +
                "currency=" + currency +
                ", amount=" + amount +
                '}';
    }
}
