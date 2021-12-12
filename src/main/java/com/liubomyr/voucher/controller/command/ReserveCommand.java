package com.liubomyr.voucher.controller.command;

import com.liubomyr.voucher.controller.VoucherController;

public class ReserveCommand implements Command {

    private VoucherController voucher;

    public ReserveCommand(VoucherController voucher) {
        this.voucher = voucher;
    }

    public ReserveCommand() {}

    @Override
    public void execute() {
        voucher.reserve();
    }
}
