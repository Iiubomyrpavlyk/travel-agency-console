package com.liubomyr.voucher.controller.command;

import com.liubomyr.voucher.controller.VoucherController;

public class CancelCommand implements Command {

    private VoucherController voucher;

    public CancelCommand(VoucherController voucher) {
        this.voucher = voucher;
    }

    @Override
    public void execute() {
        voucher.cancel();
    }
}
