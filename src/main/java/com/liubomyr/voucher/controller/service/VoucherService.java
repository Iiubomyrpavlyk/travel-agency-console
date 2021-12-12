package com.liubomyr.voucher.controller.service;

import com.liubomyr.voucher.database.Database;


import com.liubomyr.voucher.database.schema.tables.records.VoucherRecord;
import com.liubomyr.voucher.model.Voucher;
import org.jooq.*;

import static com.liubomyr.voucher.database.schema.tables.Nutrition.NUTRITION;
import static com.liubomyr.voucher.database.schema.tables.Transport.TRANSPORT;
import static com.liubomyr.voucher.database.schema.tables.Type.*;

import java.sql.Date;
import java.sql.SQLException;

import static com.liubomyr.voucher.database.schema.tables.Customer.CUSTOMER;
import static com.liubomyr.voucher.database.schema.tables.Voucher.VOUCHER;

public class VoucherService implements Service {

    @Override
    public Result<VoucherRecord> select(Condition... conditions) {

        Result<VoucherRecord> result;
        DSLContext context = null;

        try {
             context = Database.getDSLContextInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        result = context.selectFrom(VOUCHER).where(conditions).fetch();

        return null;
    }

    @Override
    public Result<Record> insert(Object o) {

        Voucher voucher = (Voucher) o;

        Result<Record> insertedClients = new ClientService().insert(voucher.getClient());
        Integer customerID = insertedClients.get(0).get(CUSTOMER.CUST_ID);

        Integer voucherType = new VoucherTypeService().select(TYPE.NAME.eq(voucher.getVoucherType().name())).get(0).getValue(TYPE.TYPE_ID);
        Integer nutrition = new NutritionService().select(NUTRITION.NAME.eq(voucher.getNutrition().name())).get(0).getValue(NUTRITION.NUTRITION_ID);
        Integer transport = new TransportService().select(TRANSPORT.NAME.eq(voucher.getTransport().name())).get(0).getValue(TRANSPORT.TRANSPORT_ID);

        Result result = null;

        try {
            DSLContext create = Database.getDSLContextInstance();

            result = create.insertInto( VOUCHER, VOUCHER.CUSTOMER_ID, VOUCHER.TYPE, VOUCHER.ARRIVAL, VOUCHER.DEPARTURE,
                                        VOUCHER.HOTEL, VOUCHER.COUNTRY, VOUCHER.NUTRITION, VOUCHER.TRANSPORT, VOUCHER.PAYMENT)
                            .values(customerID, voucherType,  new Date(voucher.getArrivalDate().getTime()).toLocalDate(),
                                            new Date(voucher.getDepartureDate().getTime()).toLocalDate(),
                                            voucher.getHotel(), voucher.getCountry(), nutrition, transport, 1)
                    .returningResult(VOUCHER.VOUCHER_ID)
                    .fetch();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
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
