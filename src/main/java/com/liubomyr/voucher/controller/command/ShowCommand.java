package com.liubomyr.voucher.controller.command;

import com.liubomyr.voucher.controller.VoucherController;

public class ShowCommand implements Command {

    private VoucherController voucher;

    public ShowCommand(VoucherController voucher) {
        this.voucher = voucher;
    }

    public ShowCommand() {}

    @Override
    public void execute() {
        voucher.show();
    }
}
