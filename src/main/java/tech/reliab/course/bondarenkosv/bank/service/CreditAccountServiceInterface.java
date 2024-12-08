package tech.reliab.course.bondarenkosv.bank.service;

import tech.reliab.course.bondarenkosv.bank.entity.CreditAccount;
import tech.reliab.course.bondarenkosv.bank.service.impl.BankService;
import tech.reliab.course.bondarenkosv.bank.service.impl.EmployeeService;
import tech.reliab.course.bondarenkosv.bank.service.impl.PaymentAccountService;
import tech.reliab.course.bondarenkosv.bank.service.impl.UserService;

public interface CreditAccountServiceInterface extends BaseServiceInterface<CreditAccount> {
    void initUserService(UserService userService);

    void initBankService(BankService bankService);

    void initEmployeeService(EmployeeService employeeService);

    void initPaymentAccountService(PaymentAccountService paymentAccountService);

    CreditAccount create(
            int user,
            int bank,
            int employee,
            int paymentAccount,
            String creditStart,
            String creditEnd,
            float creditSum,
            float monthlyPayment
    );
}
