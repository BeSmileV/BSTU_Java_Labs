package main.java.tech.reliab.course.bondarenkosv.bank.service.impl;

import main.java.tech.reliab.course.bondarenkosv.bank.entity.PaymentAccount;
import main.java.tech.reliab.course.bondarenkosv.bank.service.PaymentAccountServiceInterface;

public class PaymentAccountService extends BaseService<PaymentAccount> implements PaymentAccountServiceInterface {
    BankService bankService;
    UserService userService;

    @Override
    public void initBankSerive(BankService bankService) {
        this.bankService = bankService;
    }

    @Override
    public void initUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public PaymentAccount getPaymentAccountByAccountNumber(
            int user,
            int bank
    ) {
        boolean isExsieBank = bankService.isExists(bank);
        boolean isExistUser = userService.isExists(user);

        if (!isExsieBank || !isExistUser) {
            return null;
        }

        PaymentAccount newEntity = new PaymentAccount(
                user,
                bank,
                0
        );
        newEntity.setId(entityList.size() + 1);
        return newEntity;
    }
}
