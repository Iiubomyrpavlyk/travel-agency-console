package com.liubomyr.voucher.controller;


import com.liubomyr.voucher.controller.command.Command;

public class VoucherInvoker {

    public void executeOperation(Command command) {
        command.execute();
    }
}