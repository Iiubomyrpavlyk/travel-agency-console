package com.liubomyr.voucher.controller.command;

import com.liubomyr.voucher.controller.VoucherController;

public class BookCommand implements Command {

    private VoucherController voucher;

    public BookCommand(VoucherController voucher) {
        this.voucher = voucher;
    }

    @Override
    public void execute() {
        voucher.book();
    }
}

