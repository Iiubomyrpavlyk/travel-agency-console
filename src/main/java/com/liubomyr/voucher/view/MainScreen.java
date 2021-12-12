package com.liubomyr.voucher.view;

import de.codeshelf.consoleui.elements.ConfirmChoice;
import de.codeshelf.consoleui.prompt.*;
import de.codeshelf.consoleui.prompt.builder.ListPromptBuilder;
import de.codeshelf.consoleui.prompt.builder.PromptBuilder;
import org.fusesource.jansi.AnsiConsole;

import java.io.IOException;
import java.util.*;
import java.util.logging.LogManager;

import static org.fusesource.jansi.Ansi.ansi;

public class MainScreen {

    ConsolePrompt prompt;
    PromptBuilder promptInput;
    PromptBuilder promptItemList;
    PromptBuilder promptConfirmation;
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

    public boolean getConfirmation(String name, String message) {

        promptConfirmation = prompt.getPromptBuilder()
                .createConfirmPromp()
                .name(name)
                .message(message)
                .addPrompt();

        try {
            result = prompt.prompt(promptConfirmation.build());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ((ConfirmResult) result.get(name)).getConfirmed() == ConfirmChoice.ConfirmationValue.YES ? true : false;
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

    private PromptBuilder initPromptInput(String name, String message) {
        return prompt.getPromptBuilder().createInputPrompt()
                .name(name)
                .message(message)
                .addPrompt();
    }

}

