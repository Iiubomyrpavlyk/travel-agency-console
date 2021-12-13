/*
 * This file is generated by jOOQ.
 */
package com.liubomyr.voucher.database.schema.tables.records;


import com.liubomyr.voucher.database.schema.tables.Country;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CountryRecord extends UpdatableRecordImpl<CountryRecord> implements Record2<Integer, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>sql4458432.country.ID</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>sql4458432.country.ID</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>sql4458432.country.NAME</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>sql4458432.country.NAME</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<Integer, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Country.COUNTRY.ID;
    }

    @Override
    public Field<String> field2() {
        return Country.COUNTRY.NAME;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public CountryRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public CountryRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public CountryRecord values(Integer value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CountryRecord
     */
    public CountryRecord() {
        super(Country.COUNTRY);
    }

    /**
     * Create a detached, initialised CountryRecord
     */
    public CountryRecord(Integer id, String name) {
        super(Country.COUNTRY);

        setId(id);
        setName(name);
    }
}
