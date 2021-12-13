/*
 * This file is generated by jOOQ.
 */
package com.liubomyr.voucher.database.schema.tables.records;


import com.liubomyr.voucher.database.schema.tables.Currency;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CurrencyRecord extends UpdatableRecordImpl<CurrencyRecord> implements Record3<Integer, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>sql4458432.currency.CURRENCY_ID</code>.
     */
    public void setCurrencyId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>sql4458432.currency.CURRENCY_ID</code>.
     */
    public Integer getCurrencyId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>sql4458432.currency.NAME</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>sql4458432.currency.NAME</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>sql4458432.currency.DESCRIPTION</code>.
     */
    public void setDescription(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>sql4458432.currency.DESCRIPTION</code>.
     */
    public String getDescription() {
        return (String) get(2);
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
    public Row3<Integer, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Integer, String, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Currency.CURRENCY.CURRENCY_ID;
    }

    @Override
    public Field<String> field2() {
        return Currency.CURRENCY.NAME;
    }

    @Override
    public Field<String> field3() {
        return Currency.CURRENCY.DESCRIPTION;
    }

    @Override
    public Integer component1() {
        return getCurrencyId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public String component3() {
        return getDescription();
    }

    @Override
    public Integer value1() {
        return getCurrencyId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public String value3() {
        return getDescription();
    }

    @Override
    public CurrencyRecord value1(Integer value) {
        setCurrencyId(value);
        return this;
    }

    @Override
    public CurrencyRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public CurrencyRecord value3(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public CurrencyRecord values(Integer value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CurrencyRecord
     */
    public CurrencyRecord() {
        super(Currency.CURRENCY);
    }

    /**
     * Create a detached, initialised CurrencyRecord
     */
    public CurrencyRecord(Integer currencyId, String name, String description) {
        super(Currency.CURRENCY);

        setCurrencyId(currencyId);
        setName(name);
        setDescription(description);
    }
}
