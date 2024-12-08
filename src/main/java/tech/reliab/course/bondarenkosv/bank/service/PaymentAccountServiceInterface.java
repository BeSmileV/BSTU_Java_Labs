package tech.reliab.course.bondarenkosv.bank.service;

import tech.reliab.course.bondarenkosv.bank.entity.PaymentAccount;
import tech.reliab.course.bondarenkosv.bank.service.impl.BankService;
import tech.reliab.course.bondarenkosv.bank.service.impl.UserService;

public interface PaymentAccountServiceInterface extends BaseServiceInterface<PaymentAccount> {
    void initBankService(BankService bankService);

    void initUserService(UserService userService);

    void setAmount(int id, float amount);

    PaymentAccount create(
            int user,
            int bank
    );
}
