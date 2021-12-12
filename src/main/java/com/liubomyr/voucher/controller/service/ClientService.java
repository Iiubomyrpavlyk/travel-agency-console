package com.liubomyr.voucher.controller.service;

import com.liubomyr.voucher.database.Database;
import com.liubomyr.voucher.database.schema.tables.records.CustomerRecord;
import com.liubomyr.voucher.model.Client;
import org.jooq.*;

import java.sql.SQLException;

import static com.liubomyr.voucher.database.schema.tables.Customer.CUSTOMER;

public class ClientService implements Service {

    @Override
    public Result<Record> insert(Object client) {

        Result result = null;
        try {
            DSLContext create = Database.getDSLContextInstance();

            result =
                    create
                            .insertInto(CUSTOMER, CUSTOMER.FIRST_NAME, CUSTOMER.LAST_NAME, CUSTOMER.PASSPORT_CODE, CUSTOMER.EMAIL)
                            .values(((Client) client).getFirstName(), ((Client) client).getLastName(), ((Client) client).getPassportCode(), ((Client) client).getEmail())
                            .returningResult(CUSTOMER.CUST_ID).fetch();


        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }

        return result;
    }

    @Override
    public Result<CustomerRecord> select(Condition... conditions) {
        return null;
    }

    @Override
    public Result<Record> delete(Object o) {
        return null;
    }

    @Override
    public Result<Record> update(Object o) {
        return null;
    }
}
