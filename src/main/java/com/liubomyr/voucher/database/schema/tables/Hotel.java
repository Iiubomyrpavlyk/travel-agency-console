/*
 * This file is generated by jOOQ.
 */
package com.liubomyr.voucher.database.schema.tables;


import com.liubomyr.voucher.database.schema.Keys;
import com.liubomyr.voucher.database.schema.Sql4458432;
import com.liubomyr.voucher.database.schema.tables.records.HotelRecord;

import java.util.Arrays;
import java.util.List;

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
public class Hotel extends TableImpl<HotelRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>sql4458432.hotel</code>
     */
    public static final Hotel HOTEL = new Hotel();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<HotelRecord> getRecordType() {
        return HotelRecord.class;
    }

    /**
     * The column <code>sql4458432.hotel.ID</code>.
     */
    public final TableField<HotelRecord, Integer> ID = createField(DSL.name("ID"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>sql4458432.hotel.NAME</code>.
     */
    public final TableField<HotelRecord, String> NAME = createField(DSL.name("NAME"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>sql4458432.hotel.COUNTRY_ID</code>.
     */
    public final TableField<HotelRecord, Integer> COUNTRY_ID = createField(DSL.name("COUNTRY_ID"), SQLDataType.INTEGER.nullable(false), this, "");

    private Hotel(Name alias, Table<HotelRecord> aliased) {
        this(alias, aliased, null);
    }

    private Hotel(Name alias, Table<HotelRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>sql4458432.hotel</code> table reference
     */
    public Hotel(String alias) {
        this(DSL.name(alias), HOTEL);
    }

    /**
     * Create an aliased <code>sql4458432.hotel</code> table reference
     */
    public Hotel(Name alias) {
        this(alias, HOTEL);
    }

    /**
     * Create a <code>sql4458432.hotel</code> table reference
     */
    public Hotel() {
        this(DSL.name("hotel"), null);
    }

    public <O extends Record> Hotel(Table<O> child, ForeignKey<O, HotelRecord> key) {
        super(child, key, HOTEL);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Sql4458432.SQL4458432;
    }

    @Override
    public Identity<HotelRecord, Integer> getIdentity() {
        return (Identity<HotelRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<HotelRecord> getPrimaryKey() {
        return Keys.KEY_HOTEL_PRIMARY;
    }

    @Override
    public List<ForeignKey<HotelRecord, ?>> getReferences() {
        return Arrays.asList(Keys.COUNTRY_ID);
    }

    private transient Country _country;

    public Country country() {
        if (_country == null)
            _country = new Country(this, Keys.COUNTRY_ID);

        return _country;
    }

    @Override
    public Hotel as(String alias) {
        return new Hotel(DSL.name(alias), this);
    }

    @Override
    public Hotel as(Name alias) {
        return new Hotel(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Hotel rename(String name) {
        return new Hotel(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Hotel rename(Name name) {
        return new Hotel(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, String, Integer> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}
