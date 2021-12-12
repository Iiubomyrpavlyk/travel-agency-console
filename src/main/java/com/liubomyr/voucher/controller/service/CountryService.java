package com.liubomyr.voucher.controller.service;

import com.liubomyr.voucher.database.Database;
import com.liubomyr.voucher.database.schema.tables.records.CountryRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;

import java.sql.SQLException;
import static com.liubomyr.voucher.database.schema.tables.Country.COUNTRY;

public class CountryService implements Service {


    @Override
    public Result<CountryRecord> select(Condition... conditions) {

        DSLContext context = null;

        try {
             context = Database.getDSLContextInstance();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return context.selectFrom(COUNTRY).where(conditions).fetch();
    }

    @Override
    public Result<Record> insert(Object o) {
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
