package main.java.tech.reliab.course.bondarenkosv.bank.service;

import main.java.tech.reliab.course.bondarenkosv.bank.entity.Bank;

import java.util.ArrayList;
import java.util.List;

import static main.java.tech.reliab.course.bondarenkosv.bank.utils.BankUtils.*;

public class BankService extends BaseService<Bank> {
    public Bank create(String name) {
        Bank bank = new Bank(
                entityList.size() + 1, // id будет заменен в методе create()
                name,
                0,  // officeNum
                0,  // bankAtmNum
                0,  // employeesNum
                0,  // clientNum
                generateBankRating(),
                generateBankTotalMoney(),
                generatePercentageRate(generateBankRating())
        );
        create(bank);  // Используем метод базового класса
        return bank.copy();
    }

    // Можно добавить специфические методы для Bank, если необходимо
}