package com.liubomyr.voucher.model;

import com.liubomyr.voucher.view.MainScreen;

public enum Nutrition {
    BB("FB"),     // bad breakfast - is included in price
    HB("HB"),     // half board - includes breakfast and dinner
    FB("FB"),     // full board - breakfast, lunch, dinner
    AL("AL");      // all inclusive

    private String item;

    Nutrition(String item) {
        this.item = item;
    }

    static Nutrition getItem(String item) {
        if (item == null)
            throw new IllegalArgumentException();

        Nutrition values[] = Nutrition.values();
        for (Nutrition value: values)
            if (value.item == item)
                return value;

        return null;
    }

}
