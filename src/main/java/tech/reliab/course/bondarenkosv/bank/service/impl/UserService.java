package tech.reliab.course.bondarenkosv.bank.service.impl;

import tech.reliab.course.bondarenkosv.bank.entity.User;
import tech.reliab.course.bondarenkosv.bank.service.UserServiceInterface;

import static main.java.tech.reliab.course.bondarenkosv.bank.utils.UserUtils.generateUserCreditRating;

public class UserService extends BaseService<User> implements UserServiceInterface {
    BankService bankService;

    @Override
    public void initBankService(BankService bankService) {
        this.bankService = bankService;
    }

    @Override
    public User create(
            String fio,
            String dateOfBirth,
            String workAddress,
            int[] banks,
            float monthlyIncome
    ) {
        for (int bank : banks) {
            if (!bankService.isExists(bank))
                return null;
        }

        for (int bank : banks) {
            bankService.addClient(bank);
        }

        float creditRating = generateUserCreditRating(monthlyIncome);
        User newEntity = new User(
                fio,
                dateOfBirth,
                workAddress,
                banks,
                monthlyIncome,
                creditRating
        );
        newEntity.setId(entityList.size() + 1);
        entityList.add(newEntity);
        return newEntity.copy();
    }
}
