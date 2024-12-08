package tech.reliab.course.bondarenkosv.bank.service.impl;

import tech.reliab.course.bondarenkosv.bank.entity.CreditAccount;
import tech.reliab.course.bondarenkosv.bank.service.CreditAccountServiceInterface;

public class CreditAccountService extends BaseService<CreditAccount> implements CreditAccountServiceInterface {
    UserService userService;
    BankService bankService;
    EmployeeService employeeService;
    PaymentAccountService paymentAccountService;

    @Override
    public void initUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initBankService(BankService bankService) {
        this.bankService = bankService;
    }

    @Override
    public void initEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void initPaymentAccountService(PaymentAccountService paymentAccountService) {
        this.paymentAccountService = paymentAccountService;
    }

    @Override
    public CreditAccount create(
            int user,
            int bank,
            int employee,
            int paymentAccount,
            String creditStart,
            String creditEnd,
            float creditSum,
            float monthlyPayment
    ) {
        // Проверка наличия сущностей
        boolean isExistsUser = userService.isExists(user);
        boolean isExistsBank = bankService.isExists(bank);
        boolean isExistsEmployee = employeeService.isExists(employee);
        boolean isExistsPaymentAccount = paymentAccountService.isExists(paymentAccount);
        if (!(isExistsUser && isExistsBank && isExistsEmployee && isExistsPaymentAccount)) {
            return null;
        }

        // Проверка возможности выдачи кредита работником
        if (!employeeService.canApplyCredits(employee)) {
            System.out.println("Apply credits failed");
            return null;
        }

        // Попытка взять кредит
        boolean reserveMoneyResponse = bankService.getCredit(bank, creditSum, paymentAccountService.list().get(paymentAccount).getPercentageRate());
        if (!reserveMoneyResponse) {
            System.out.println("Reserve credit failed");
            return null;
        }

        paymentAccountService.setAmount(paymentAccount, creditSum);
        CreditAccount newEntity = new CreditAccount(
                user,
                bank,
                employee,
                paymentAccount,
                creditStart,
                creditEnd,
                creditSum,
                monthlyPayment
        );
        newEntity.setId(entityList.size() + 1);
        entityList.add(newEntity);
        return newEntity;
    }
}
