import tech.reliab.course.bondarenkosv.bank.entity.*;
import tech.reliab.course.bondarenkosv.bank.service.impl.*;


public class Main {
    public static void main(String[] args) {
        BankService bankService = new BankService();
        bankService.init();

        BankOfficeService bankOfficeService = new BankOfficeService();
        bankOfficeService.init();
        bankOfficeService.initBankService(bankService);

        EmployeeService employeeService = new EmployeeService();
        employeeService.init();
        employeeService.initBankService(bankService);
        employeeService.initBankOfficeService(bankOfficeService);

        BankAtmService bankAtmService = new BankAtmService();
        bankAtmService.init();
        bankAtmService.initBankService(bankService);
        bankAtmService.initBankOfficeService(bankOfficeService);
        bankAtmService.initEmployeeService(employeeService);

        UserService userService = new UserService();
        userService.init();
        userService.initBankService(bankService);

        PaymentAccountService paymentAccountService = new PaymentAccountService();
        paymentAccountService.init();
        paymentAccountService.initUserService(userService);
        paymentAccountService.initBankSerive(bankService);

        CreditAccountService creditAccountService = new CreditAccountService();
        creditAccountService.init();
        creditAccountService.initBankService(bankService);
        creditAccountService.initUserService(userService);
        creditAccountService.initEmployeeService(employeeService);
        creditAccountService.initPaymentAccountService(paymentAccountService);

        Bank bank = bankService.create("Bank 1");
        BankOffice bankOffice = bankOfficeService.create(
                "Bank Office 1",
                "some address",
                "work",
                bank.getId(),
                true,
                true,
                true,
                true,
                10000,
                1000
        );

        Employee employee = employeeService.create(
                "Employee 1",
                "01.01.2000",
                "test position",
                bank.getId(),
                false,
                bankOffice.getId(),
                true,
                1000
        );
        BankAtm bankAtm = bankAtmService.create(
                "Bank Atm 1",
                "some address",
                "work",
                bank.getId(),
                bankOffice.getId(),
                employee.getId(),
                true,
                true,
                1000,
                100
        );
        User user = userService.create(
                "fio",
                "01.01.2000",
                "test address",
                new int[]{bank.getId()},
                1000
        );
        PaymentAccount paymentAccount = paymentAccountService.create(
                user.getId(),
                bank.getId()
        );
        CreditAccount creditAccount = creditAccountService.create(
                user.getId(),
                bank.getId(),
                employee.getId(),
                paymentAccount.getId(),
                "01.01.2024",
                "01.01.2028",
                1000,
                10,
                0.31f
        );

        System.out.println(bank);
        System.out.println(bankOffice);
        System.out.println(employee);
        System.out.println(bankAtm);
        System.out.println(user);
        System.out.println(paymentAccount);
        System.out.println(creditAccount);
    }
}