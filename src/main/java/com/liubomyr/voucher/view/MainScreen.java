package com.liubomyr.voucher.view;

import de.codeshelf.consoleui.prompt.ConsolePrompt;
import de.codeshelf.consoleui.prompt.InputResult;
import de.codeshelf.consoleui.prompt.ListResult;
import de.codeshelf.consoleui.prompt.PromtResultItemIF;
import de.codeshelf.consoleui.prompt.builder.ListPromptBuilder;
import de.codeshelf.consoleui.prompt.builder.PromptBuilder;
import org.fusesource.jansi.AnsiConsole;
import org.jooq.Record;
import org.jooq.Result;

import java.io.IOException;
import java.util.*;
import java.util.logging.LogManager;

import static com.liubomyr.voucher.database.schema.tables.Country.COUNTRY;
import static com.liubomyr.voucher.database.schema.tables.Customer.CUSTOMER;
import static com.liubomyr.voucher.database.schema.tables.Hotel.HOTEL;
import static com.liubomyr.voucher.database.schema.tables.Nutrition.NUTRITION;
import static com.liubomyr.voucher.database.schema.tables.Transport.TRANSPORT;
import static com.liubomyr.voucher.database.schema.tables.Type.TYPE;
import static org.fusesource.jansi.Ansi.ansi;

public class MainScreen {

    ConsolePrompt prompt;
    PromptBuilder promptInput;
    PromptBuilder promptItemList;
    final PromptBuilder promptSelectionMenu;

    HashMap<String, ? extends PromtResultItemIF> result;

    static {
        LogManager.getLogManager().reset();
        System.out.println(ansi().eraseScreen().render("\t\t\t\tVOUCHER MANAGEMENT SYSTEM\t\t\t\t\n"));
    }

    public enum SelectionMenuItem {
        BOOK("book"), RESERVE("reserve"), MODIFY("modify"), CANCEL("cancel"), LIST("list"), EXIT("exit");

        private String item;

        SelectionMenuItem(String item) {
            this.item = item;
        }

        static SelectionMenuItem getItem(String item) {
            if (item == null || item.isEmpty())
                throw new IllegalArgumentException();

            SelectionMenuItem values[] = SelectionMenuItem.values();
            for (SelectionMenuItem value: values)
                if (value.item == item)
                    return value;

            return null;
        }
    }


    public MainScreen() {
        AnsiConsole.systemInstall();

        prompt = new ConsolePrompt();
        promptSelectionMenu = initPromptSelectionMenu();
    }

    private PromptBuilder initPromptSelectionMenu() {
        return prompt.getPromptBuilder().createListPrompt()
                .name("selection")
                .message("Select operation...")
                .newItem("book").text("BOOK").add()
                .newItem("reserve").text("RESERVE").add()
                .newItem("modify").text("MODIFY").add()
                .newItem("cancel").text("CANCEL").add()
                .newItem("list").text("SHOW VOUCHERS").add()
                .newItem("exit").text("EXIT").add()
                .addPrompt();
    }

    public SelectionMenuItem showSelectionMenu() {

        try {
            result = prompt.prompt(promptSelectionMenu.build());
        } catch (IOException e) {
            e.printStackTrace();
        }

        SelectionMenuItem.getItem(((ListResult) result.get("selection")).getSelectedId());

        return SelectionMenuItem.getItem(((ListResult) result.get("selection")).getSelectedId());
    }

    public String getItemFromList(String name, String message, Map<String, String> map) {

        if (name == null || name.isEmpty() || message == null || message.isEmpty() || map == null || map.isEmpty())
            throw new IllegalArgumentException();

        ListPromptBuilder listPromptBuilder = prompt.getPromptBuilder()
                .createListPrompt()
                .name(name)
                .message(message);

        for (Map.Entry<String, String> entry: map.entrySet())
            listPromptBuilder.newItem(entry.getKey()).text(entry.getValue()).add();

        promptItemList = listPromptBuilder.addPrompt();

        try {
            result = prompt.prompt(promptItemList.build());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ((ListResult) result.get(name)).getSelectedId();
    }


    public String getInput(String name, String message) {

        promptInput = prompt.getPromptBuilder().createInputPrompt()
                .name(name)
                .message(message)
                .addPrompt();

        try {
            result = prompt.prompt(promptInput.build());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ((InputResult) result.get(name)).getInput();
    }

    public void showCancelMenu() {}

    public void showReserveMenu() {}


    public void showVouchersList(List<String> headers, List<List<String>> result) {

        if (headers == null || headers.isEmpty())
            throw new IllegalArgumentException();

        CommandLineTable table = new CommandLineTable();
        table.setShowVerticalLines(true);

        table.setHeaders(headers);

        for (List<String> record : result)
            table.addRow(record);

        table.print();
    }

    @Deprecated
    public void showVouchersList(Result<?> result) {
        CommandLineTable table = new CommandLineTable();
        table.setShowVerticalLines(true);
        table.setHeaders("name", "surname", "type", "country", "hotel", "transport", "nutrition");

        for (Record record : result)
            table.addRow(record.getValue(CUSTOMER.FIRST_NAME), record.getValue(CUSTOMER.LAST_NAME), record.getValue(TYPE.NAME),
                            record.getValue(COUNTRY.NAME), record.getValue(HOTEL.NAME), record.getValue(TRANSPORT.NAME),
                            record.getValue(NUTRITION.NAME));

        table.print();
    }


    private PromptBuilder initPromptInput(String name, String message) {
        return prompt.getPromptBuilder().createInputPrompt()
                .name(name)
                .message(message)
                .addPrompt();
    }

}

