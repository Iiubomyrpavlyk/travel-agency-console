/*
 * This file is generated by jOOQ.
 */
package com.liubomyr.voucher.database.schema.tables.records;


import com.liubomyr.voucher.database.schema.tables.Hotel;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class HotelRecord extends UpdatableRecordImpl<HotelRecord> implements Record3<Integer, String, Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>sql4458432.hotel.ID</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>sql4458432.hotel.ID</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>sql4458432.hotel.NAME</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>sql4458432.hotel.NAME</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>sql4458432.hotel.COUNTRY_ID</code>.
     */
    public void setCountryId(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>sql4458432.hotel.COUNTRY_ID</code>.
     */
    public Integer getCountryId() {
        return (Integer) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, String, Integer> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Integer, String, Integer> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Hotel.HOTEL.ID;
    }

    @Override
    public Field<String> field2() {
        return Hotel.HOTEL.NAME;
    }

    @Override
    public Field<Integer> field3() {
        return Hotel.HOTEL.COUNTRY_ID;
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
    public Integer component3() {
        return getCountryId();
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
    public Integer value3() {
        return getCountryId();
    }

    @Override
    public HotelRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public HotelRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public HotelRecord value3(Integer value) {
        setCountryId(value);
        return this;
    }

    @Override
    public HotelRecord values(Integer value1, String value2, Integer value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached HotelRecord
     */
    public HotelRecord() {
        super(Hotel.HOTEL);
    }

    /**
     * Create a detached, initialised HotelRecord
     */
    public HotelRecord(Integer id, String name, Integer countryId) {
        super(Hotel.HOTEL);

        setId(id);
        setName(name);
        setCountryId(countryId);
    }
}
