package com.liubomyr.voucher.controller;

import com.liubomyr.voucher.controller.service.Service;
import com.liubomyr.voucher.controller.service.VoucherService;
import com.liubomyr.voucher.database.Database;
import com.liubomyr.voucher.model.*;
import com.liubomyr.voucher.view.MainScreen;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.Select;

import java.sql.SQLException;
import java.util.*;

import static com.liubomyr.voucher.database.schema.tables.Country.COUNTRY;
import static com.liubomyr.voucher.database.schema.tables.Customer.CUSTOMER;
import static com.liubomyr.voucher.database.schema.tables.Hotel.HOTEL;
import static com.liubomyr.voucher.database.schema.tables.Nutrition.NUTRITION;
import static com.liubomyr.voucher.database.schema.tables.Transport.TRANSPORT;
import static com.liubomyr.voucher.database.schema.tables.Type.TYPE;
import static com.liubomyr.voucher.database.schema.tables.Voucher.VOUCHER;

public class VoucherController {

    MainScreen screen;

    public VoucherController() {
        screen = new MainScreen();
    }

    public void book() {

        Client client = InputVoucher.inputClient();
        VoucherType voucherType = InputVoucher.inputVoucherType();
        Country country = InputVoucher.inputCountry();
        Hotel hotel = InputVoucher.inputHotel(country.getID());
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

        class Table {

            Result<?> result;
            List<String> headers = new ArrayList<>();
            List<List<String>> rows;

            {
                headers.add("ID");
                headers.add("FIRST NAME");
                headers.add("LAST NAME");
                headers.add("TYPE");
                headers.add("COUNTRY");
                headers.add("HOTEL");
                headers.add("NUTRITION");
                headers.add("TRANSPORT");
                headers.add("ARRIVAL");
                headers.add("DEPARTURE");
            }

            private Table(Result<?> rows) {
                this.result = rows;
                this.rows = fillRows(result);
            }

            List<List<String>> fillRows(Result<?> result) {
                List<List<String>> rows = new ArrayList<>();
                for (Record record: result) {
                    List<String> row = new ArrayList<>();
                    row.add(String.valueOf(record.getValue(VOUCHER.VOUCHER_ID)));
                    row.add(record.getValue(CUSTOMER.FIRST_NAME));
                    row.add(record.getValue(CUSTOMER.LAST_NAME));
                    row.add(record.getValue(TYPE.NAME));
                    row.add(record.getValue(COUNTRY.NAME));
                    row.add(record.getValue(HOTEL.NAME));
                    row.add(record.getValue(NUTRITION.NAME));
                    row.add(record.getValue(TRANSPORT.NAME));
                    row.add(String.valueOf(record.getValue(VOUCHER.ARRIVAL)));
                    row.add(String.valueOf(record.getValue(VOUCHER.DEPARTURE)));
                    rows.add(row);
                }

                return rows;
            }

            void call() {
                screen.showVouchersList(headers, rows);
            }

            void setRows(Result<?> result) {
                this.result = result;
                this.rows = fillRows(result);
            }

            public List<String> getHeaders() {
                return headers;
            }
        }

        Result<?> result = getOrderedVoucherSelect()
                .fetch();

        Table table = new Table(result);
        table.call();

        while (true) {
            boolean confirmed = screen.getConfirmation("sort", "Do you want to sort a table? ");
            if (!confirmed)
                break;

            int key = 1;
            List<String> headers = table.getHeaders();
            Map<String, String> field = new HashMap<>();
            for (String header : headers)
                field.put(String.valueOf(key++), header);


            Integer orderCond = Integer.parseInt(screen.getItemFromList("order", "Choose a field to order by: ", field));
            System.out.println(orderCond);

            Result<?> result1 = getOrderedVoucherSelect(orderCond)
                    .fetch();

            table.setRows(result1);
            table.call();

        }

    }

    private Select<?> getOrderedVoucherSelect(int... var) {

        DSLContext context = null;

        try {
            context = Database.getDSLContextInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return context.select( VOUCHER.VOUCHER_ID, CUSTOMER.FIRST_NAME, CUSTOMER.LAST_NAME,
                        TYPE.NAME, COUNTRY.NAME, HOTEL.NAME, NUTRITION.NAME, TRANSPORT.NAME,
                        VOUCHER.ARRIVAL, VOUCHER.DEPARTURE)
                .from(VOUCHER)
                .innerJoin(COUNTRY)
                .on(COUNTRY.ID.eq(VOUCHER.COUNTRY_ID))
                .innerJoin(HOTEL)
                .on(HOTEL.ID.eq(VOUCHER.HOTEL_ID))
                .innerJoin(CUSTOMER)
                .on(CUSTOMER.CUST_ID.eq(VOUCHER.CUSTOMER_ID))
                .innerJoin(TYPE)
                .on(TYPE.TYPE_ID.eq(VOUCHER.TYPE))
                .innerJoin(NUTRITION)
                .on(NUTRITION.NUTRITION_ID.eq(VOUCHER.NUTRITION))
                .innerJoin(TRANSPORT)
                .on(TRANSPORT.TRANSPORT_ID.eq(VOUCHER.TRANSPORT))
                .orderBy(var);
    }


}


