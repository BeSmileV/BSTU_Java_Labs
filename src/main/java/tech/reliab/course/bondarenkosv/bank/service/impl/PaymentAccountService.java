package tech.reliab.course.bondarenkosv.bank.service.impl;

import tech.reliab.course.bondarenkosv.bank.entity.PaymentAccount;
import tech.reliab.course.bondarenkosv.bank.service.PaymentAccountServiceInterface;

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
    public PaymentAccount create(
            int user,
            int bank
    ) {
        boolean isExistBank = bankService.isExists(bank);
        boolean isExistUser = userService.isExists(user);

        if (!isExistBank || !isExistUser) {
            return null;
        }

        PaymentAccount newEntity = new PaymentAccount(
                user,
                bank,
                0
        );
        newEntity.setId(entityList.size() + 1);
        entityList.add(newEntity);
        return newEntity;
    }
}