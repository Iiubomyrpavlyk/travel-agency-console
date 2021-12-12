package com.liubomyr.voucher.controller.service;

import com.liubomyr.voucher.database.Database;
import com.liubomyr.voucher.database.schema.tables.records.NutritionRecord;
import org.jooq.*;

import java.sql.SQLException;

import static com.liubomyr.voucher.database.schema.Tables.NUTRITION;

public class NutritionService implements  Service {

    @Override
    public Result<NutritionRecord> select(Condition... conditions) {

        DSLContext create = null;

        try {
            create = Database.getDSLContextInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return create.selectFrom(NUTRITION).where(conditions).fetch();
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
