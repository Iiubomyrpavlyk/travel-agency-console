/*
 * This file is generated by jOOQ.
 */
package com.liubomyr.voucher.database.schema.tables;


import com.liubomyr.voucher.database.schema.Keys;
import com.liubomyr.voucher.database.schema.VoucherAgency;
import com.liubomyr.voucher.database.schema.tables.records.NutritionRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Nutrition extends TableImpl<NutritionRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>voucher_agency.nutrition</code>
     */
    public static final Nutrition NUTRITION = new Nutrition();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<NutritionRecord> getRecordType() {
        return NutritionRecord.class;
    }

    /**
     * The column <code>voucher_agency.nutrition.NUTRITION_ID</code>.
     */
    public final TableField<NutritionRecord, Integer> NUTRITION_ID = createField(DSL.name("NUTRITION_ID"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>voucher_agency.nutrition.NAME</code>.
     */
    public final TableField<NutritionRecord, String> NAME = createField(DSL.name("NAME"), SQLDataType.VARCHAR(2), this, "");

    /**
     * The column <code>voucher_agency.nutrition.description</code>.
     */
    public final TableField<NutritionRecord, String> DESCRIPTION = createField(DSL.name("description"), SQLDataType.VARCHAR(50), this, "");

    private Nutrition(Name alias, Table<NutritionRecord> aliased) {
        this(alias, aliased, null);
    }

    private Nutrition(Name alias, Table<NutritionRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>voucher_agency.nutrition</code> table reference
     */
    public Nutrition(String alias) {
        this(DSL.name(alias), NUTRITION);
    }

    /**
     * Create an aliased <code>voucher_agency.nutrition</code> table reference
     */
    public Nutrition(Name alias) {
        this(alias, NUTRITION);
    }

    /**
     * Create a <code>voucher_agency.nutrition</code> table reference
     */
    public Nutrition() {
        this(DSL.name("nutrition"), null);
    }

    public <O extends Record> Nutrition(Table<O> child, ForeignKey<O, NutritionRecord> key) {
        super(child, key, NUTRITION);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : VoucherAgency.VOUCHER_AGENCY;
    }

    @Override
    public Identity<NutritionRecord, Integer> getIdentity() {
        return (Identity<NutritionRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<NutritionRecord> getPrimaryKey() {
        return Keys.KEY_NUTRITION_PRIMARY;
    }

    @Override
    public Nutrition as(String alias) {
        return new Nutrition(DSL.name(alias), this);
    }

    @Override
    public Nutrition as(Name alias) {
        return new Nutrition(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Nutrition rename(String name) {
        return new Nutrition(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Nutrition rename(Name name) {
        return new Nutrition(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}