package com.liubomyr.voucher.controller;

import com.liubomyr.voucher.Main;
import com.liubomyr.voucher.controller.service.NutritionService;
import com.liubomyr.voucher.controller.service.Service;
import com.liubomyr.voucher.controller.service.TransportService;
import com.liubomyr.voucher.controller.service.VoucherTypeService;
import com.liubomyr.voucher.database.schema.tables.records.NutritionRecord;
import com.liubomyr.voucher.database.schema.tables.records.TransportRecord;
import com.liubomyr.voucher.database.schema.tables.records.TypeRecord;
import com.liubomyr.voucher.model.*;
import com.liubomyr.voucher.view.MainScreen;
import org.jooq.Condition;
import org.jooq.Record;
import org.jooq.Result;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.liubomyr.voucher.database.schema.tables.Nutrition.NUTRITION;
import static com.liubomyr.voucher.database.schema.tables.Transport.TRANSPORT;
import static com.liubomyr.voucher.database.schema.tables.Type.TYPE;

public class InputVoucher {

    static MainScreen screen;

    static {
        screen = new MainScreen();
    }

    public static Client inputClient() {
        String firstName = screen.getInput("name", "Enter please your name: ");
        String lastName = screen.getInput("surname", "Enter please your surname: ");
        String email = screen.getInput("email", "Enter please your email: ");
        Integer passportCode = Integer.parseInt(screen.getInput("passport code", "Enter please your passport code: "));

        return new Client(firstName, lastName, passportCode, email);
    }

    public static Nutrition inputNutrition() {

        Service service = new NutritionService();
        Result<NutritionRecord> result = (Result<NutritionRecord>) service.select();

        Map<String, String> map = new HashMap<>();

        for (Record record : result)
            map.put(record.getValue(NUTRITION.NAME), record.getValue(NUTRITION.DESCRIPTION));

        String selectedItem = screen.getItemFromList("nutrition", "Which type of nutrition do you prefer? ", map);

        return Nutrition.valueOf(selectedItem.toUpperCase());
    }

    public static VoucherType inputVoucherType() {

        Service service = new VoucherTypeService();

        Result<TypeRecord> result = (Result<TypeRecord>) service.select();

        Map<String, String> map = new HashMap<>();

        for (Record record : result)
            map.put(record.getValue(TYPE.NAME), record.getValue(TYPE.NAME));

        String selectedItem = screen.getItemFromList("voucher type", "Choose a type of voucher: ", map);

        for (VoucherType type: VoucherType.values())
            if (selectedItem.equals(type.name()))
                return type;

        return null;
    }

    public static Date inputDate(String part)  {

        String message = String.format("Enter please date of %s using format dd/mm/yy: ", part);
        String dateFormat = screen.getInput("date", message);

        Date date = null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(dateFormat);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    public static Transport inputTransport() {

        Service service = new TransportService();
        Result<TransportRecord> result = (Result<TransportRecord>) service.select();

        Map<String, String> map = new HashMap<>();

        for (Record record : result)
            map.put(record.getValue(TRANSPORT.NAME), record.getValue(TRANSPORT.NAME));

        String selectedItem = screen.getItemFromList("transport type", "Choose a transport: ", map);

        for (Transport type: Transport.values())
            if (selectedItem.equals(type.name()))
                return type;

        return null;
    }



}
