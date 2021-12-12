package com.liubomyr.voucher.controller.command;

import com.liubomyr.voucher.controller.VoucherController;

public class ModifyCommand implements Command {

    private VoucherController voucher;

    public ModifyCommand(VoucherController voucher) {
        this.voucher = voucher;
    }

    @Override
    public void execute() {
        voucher.modify();
    }
}






