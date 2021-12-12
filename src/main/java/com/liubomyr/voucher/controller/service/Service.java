package com.liubomyr.voucher.controller.service;

import com.liubomyr.voucher.database.schema.tables.records.NutritionRecord;
import org.jooq.*;

public interface Service {

    Result<? extends Record> select(Condition... conditions);
    Result<Record> insert(Object o);
    Result<Record> delete(Object o);
    Result<Record> update(Object o);

}
