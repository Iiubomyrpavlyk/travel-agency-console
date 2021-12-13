/*
 * This file is generated by jOOQ.
 */
package com.liubomyr.voucher.database.schema.tables.records;


import com.liubomyr.voucher.database.schema.tables.Voucher;

import java.time.LocalDate;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record10;
import org.jooq.Row10;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class VoucherRecord extends UpdatableRecordImpl<VoucherRecord> implements Record10<Integer, Integer, Integer, LocalDate, LocalDate, Integer, Integer, Integer, Integer, Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>sql4458432.voucher.VOUCHER_ID</code>.
     */
    public void setVoucherId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>sql4458432.voucher.VOUCHER_ID</code>.
     */
    public Integer getVoucherId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>sql4458432.voucher.CUSTOMER_ID</code>.
     */
    public void setCustomerId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>sql4458432.voucher.CUSTOMER_ID</code>.
     */
    public Integer getCustomerId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>sql4458432.voucher.TYPE</code>.
     */
    public void setType(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>sql4458432.voucher.TYPE</code>.
     */
    public Integer getType() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>sql4458432.voucher.ARRIVAL</code>.
     */
    public void setArrival(LocalDate value) {
        set(3, value);
    }

    /**
     * Getter for <code>sql4458432.voucher.ARRIVAL</code>.
     */
    public LocalDate getArrival() {
        return (LocalDate) get(3);
    }

    /**
     * Setter for <code>sql4458432.voucher.DEPARTURE</code>.
     */
    public void setDeparture(LocalDate value) {
        set(4, value);
    }

    /**
     * Getter for <code>sql4458432.voucher.DEPARTURE</code>.
     */
    public LocalDate getDeparture() {
        return (LocalDate) get(4);
    }

    /**
     * Setter for <code>sql4458432.voucher.NUTRITION</code>.
     */
    public void setNutrition(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>sql4458432.voucher.NUTRITION</code>.
     */
    public Integer getNutrition() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>sql4458432.voucher.TRANSPORT</code>.
     */
    public void setTransport(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>sql4458432.voucher.TRANSPORT</code>.
     */
    public Integer getTransport() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>sql4458432.voucher.PAYMENT</code>.
     */
    public void setPayment(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>sql4458432.voucher.PAYMENT</code>.
     */
    public Integer getPayment() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>sql4458432.voucher.HOTEL_ID</code>.
     */
    public void setHotelId(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>sql4458432.voucher.HOTEL_ID</code>.
     */
    public Integer getHotelId() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>sql4458432.voucher.COUNTRY_ID</code>.
     */
    public void setCountryId(Integer value) {
        set(9, value);
    }

    /**
     * Getter for <code>sql4458432.voucher.COUNTRY_ID</code>.
     */
    public Integer getCountryId() {
        return (Integer) get(9);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record10 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row10<Integer, Integer, Integer, LocalDate, LocalDate, Integer, Integer, Integer, Integer, Integer> fieldsRow() {
        return (Row10) super.fieldsRow();
    }

    @Override
    public Row10<Integer, Integer, Integer, LocalDate, LocalDate, Integer, Integer, Integer, Integer, Integer> valuesRow() {
        return (Row10) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Voucher.VOUCHER.VOUCHER_ID;
    }

    @Override
    public Field<Integer> field2() {
        return Voucher.VOUCHER.CUSTOMER_ID;
    }

    @Override
    public Field<Integer> field3() {
        return Voucher.VOUCHER.TYPE;
    }

    @Override
    public Field<LocalDate> field4() {
        return Voucher.VOUCHER.ARRIVAL;
    }

    @Override
    public Field<LocalDate> field5() {
        return Voucher.VOUCHER.DEPARTURE;
    }

    @Override
    public Field<Integer> field6() {
        return Voucher.VOUCHER.NUTRITION;
    }

    @Override
    public Field<Integer> field7() {
        return Voucher.VOUCHER.TRANSPORT;
    }

    @Override
    public Field<Integer> field8() {
        return Voucher.VOUCHER.PAYMENT;
    }

    @Override
    public Field<Integer> field9() {
        return Voucher.VOUCHER.HOTEL_ID;
    }

    @Override
    public Field<Integer> field10() {
        return Voucher.VOUCHER.COUNTRY_ID;
    }

    @Override
    public Integer component1() {
        return getVoucherId();
    }

    @Override
    public Integer component2() {
        return getCustomerId();
    }

    @Override
    public Integer component3() {
        return getType();
    }

    @Override
    public LocalDate component4() {
        return getArrival();
    }

    @Override
    public LocalDate component5() {
        return getDeparture();
    }

    @Override
    public Integer component6() {
        return getNutrition();
    }

    @Override
    public Integer component7() {
        return getTransport();
    }

    @Override
    public Integer component8() {
        return getPayment();
    }

    @Override
    public Integer component9() {
        return getHotelId();
    }

    @Override
    public Integer component10() {
        return getCountryId();
    }

    @Override
    public Integer value1() {
        return getVoucherId();
    }

    @Override
    public Integer value2() {
        return getCustomerId();
    }

    @Override
    public Integer value3() {
        return getType();
    }

    @Override
    public LocalDate value4() {
        return getArrival();
    }

    @Override
    public LocalDate value5() {
        return getDeparture();
    }

    @Override
    public Integer value6() {
        return getNutrition();
    }

    @Override
    public Integer value7() {
        return getTransport();
    }

    @Override
    public Integer value8() {
        return getPayment();
    }

    @Override
    public Integer value9() {
        return getHotelId();
    }

    @Override
    public Integer value10() {
        return getCountryId();
    }

    @Override
    public VoucherRecord value1(Integer value) {
        setVoucherId(value);
        return this;
    }

    @Override
    public VoucherRecord value2(Integer value) {
        setCustomerId(value);
        return this;
    }

    @Override
    public VoucherRecord value3(Integer value) {
        setType(value);
        return this;
    }

    @Override
    public VoucherRecord value4(LocalDate value) {
        setArrival(value);
        return this;
    }

    @Override
    public VoucherRecord value5(LocalDate value) {
        setDeparture(value);
        return this;
    }

    @Override
    public VoucherRecord value6(Integer value) {
        setNutrition(value);
        return this;
    }

    @Override
    public VoucherRecord value7(Integer value) {
        setTransport(value);
        return this;
    }

    @Override
    public VoucherRecord value8(Integer value) {
        setPayment(value);
        return this;
    }

    @Override
    public VoucherRecord value9(Integer value) {
        setHotelId(value);
        return this;
    }

    @Override
    public VoucherRecord value10(Integer value) {
        setCountryId(value);
        return this;
    }

    @Override
    public VoucherRecord values(Integer value1, Integer value2, Integer value3, LocalDate value4, LocalDate value5, Integer value6, Integer value7, Integer value8, Integer value9, Integer value10) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached VoucherRecord
     */
    public VoucherRecord() {
        super(Voucher.VOUCHER);
    }

    /**
     * Create a detached, initialised VoucherRecord
     */
    public VoucherRecord(Integer voucherId, Integer customerId, Integer type, LocalDate arrival, LocalDate departure, Integer nutrition, Integer transport, Integer payment, Integer hotelId, Integer countryId) {
        super(Voucher.VOUCHER);

        setVoucherId(voucherId);
        setCustomerId(customerId);
        setType(type);
        setArrival(arrival);
        setDeparture(departure);
        setNutrition(nutrition);
        setTransport(transport);
        setPayment(payment);
        setHotelId(hotelId);
        setCountryId(countryId);
    }
}
