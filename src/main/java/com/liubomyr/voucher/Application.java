package com.liubomyr.voucher;

import com.liubomyr.voucher.controller.VoucherController;
import com.liubomyr.voucher.controller.VoucherInvoker;
import com.liubomyr.voucher.view.MainScreen;


public class Application {

    private MainScreen screen;

    private VoucherController voucherController;
    private VoucherInvoker invoker;

    Application() {
        invoker = new VoucherInvoker();
        voucherController = new VoucherController();

        screen = new MainScreen();
    }

    public void launch() {
        while (true) {
            switch (screen.showSelectionMenu()) {
                case BOOK:
                    invoker.executeOperation(voucherController::book);
                    break;
                case RESERVE:
                    invoker.executeOperation(voucherController::reserve);
                    break;
                case MODIFY: invoker.executeOperation(voucherController::modify);
                    break;
                case CANCEL: invoker.executeOperation(voucherController::cancel);
                    break;
                case LIST: invoker.executeOperation(voucherController::show);
                    break;
                case EXIT: default: System.exit(0);
            }
        }
    }

}
