package main.java.tech.reliab.course.bondarenkosv.bank.service;

import main.java.tech.reliab.course.bondarenkosv.bank.entity.PaymentAccount;
import main.java.tech.reliab.course.bondarenkosv.bank.service.impl.BankService;
import main.java.tech.reliab.course.bondarenkosv.bank.service.impl.UserService;

public interface PaymentAccountServiceInterface extends BaseServiceInterface<PaymentAccount> {
    void initBankSerive(BankService bankService);

    void initUserService(UserService userService);

    PaymentAccount create(
            int user,
            int bank
    );
}
