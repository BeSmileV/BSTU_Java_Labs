package main.java.tech.reliab.course.bondarenkosv.bank.service;

import main.java.tech.reliab.course.bondarenkosv.bank.entity.User;
import main.java.tech.reliab.course.bondarenkosv.bank.service.impl.BankService;

public interface UserServiceInterface extends BaseServiceInterface<User> {
    void initBankService(BankService bankService);

    User create(
            String fio,
            String dateOfBirth,
            String workAddress,
            int[] banks,
            float monthlyIncome
    );
}
