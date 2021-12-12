package com.liubomyr.voucher.controller.service;

import com.liubomyr.voucher.database.Database;
import com.liubomyr.voucher.database.schema.tables.records.TypeRecord;
import org.jooq.*;

import java.sql.SQLException;

import static com.liubomyr.voucher.database.schema.Tables.TYPE;

public class VoucherTypeService implements Service {

    @Override
    public Result<TypeRecord> select(Condition... conditions) {

        DSLContext create = null;

        try {
            create = Database.getDSLContextInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return create.selectFrom(TYPE).where(conditions).fetch();
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
