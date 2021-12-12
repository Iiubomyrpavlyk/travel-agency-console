package com.liubomyr.voucher.controller;

import com.liubomyr.voucher.controller.service.*;

import com.liubomyr.voucher.database.Database;
import com.liubomyr.voucher.model.*;
import com.liubomyr.voucher.view.MainScreen;
import org.jooq.DSLContext;
import org.jooq.Result;

import java.sql.SQLException;
import java.util.*;

import static com.liubomyr.voucher.database.schema.Tables.*;
import static com.liubomyr.voucher.database.schema.tables.Voucher.VOUCHER;

public class VoucherController {

    MainScreen screen;

    public VoucherController() {
        screen = new MainScreen();
    }

    public void book() {

        //  init customer from user
        Client client = InputVoucher.inputClient();

        VoucherType voucherType = InputVoucher.inputVoucherType();

        String country = screen.getInput("country", "Enter please a country: ");
        String hotel = screen.getInput("hotel", "Enter please a hotel: ");

        Nutrition nutrition = InputVoucher.inputNutrition();

        Transport transport = InputVoucher.inputTransport();

        Date arrival = InputVoucher.inputDate("arrival");
        Date departure = InputVoucher.inputDate("departure");

        Voucher voucher = new Voucher(client, voucherType, country, hotel, transport, nutrition, arrival, departure);

        Service service = new VoucherService();
        service.insert(voucher);

    }

    @Deprecated
    public void reserve() {
        System.out.println("reserve command");
    }

    public void modify() {
        System.out.println("modify command");
    }
    public void cancel() {
        System.out.println("cancel command");
    }

    public void show() {


        try {
            DSLContext context = Database.getDSLContextInstance();

            Result<?> result =
                    context.select( CUSTOMER.FIRST_NAME, CUSTOMER.LAST_NAME,
                                    TYPE.NAME, VOUCHER.COUNTRY, VOUCHER.HOTEL, NUTRITION.NAME, TRANSPORT.NAME,
                                    VOUCHER.ARRIVAL, VOUCHER.DEPARTURE)
                    .from(VOUCHER)
                    .innerJoin(CUSTOMER)
                    .on(CUSTOMER.CUST_ID.eq(VOUCHER.CUSTOMER_ID))
                    .innerJoin(TYPE)
                    .on(TYPE.TYPE_ID.eq(VOUCHER.TYPE))
                    .innerJoin(NUTRITION)
                    .on(NUTRITION.NUTRITION_ID.eq(VOUCHER.NUTRITION))
                    .innerJoin(TRANSPORT)
                    .on(TRANSPORT.TRANSPORT_ID.eq(VOUCHER.TRANSPORT))
                    .fetch();

            screen.showVouchersList(result);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}


