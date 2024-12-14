import tech.reliab.course.bondarenkosv.bank.entity.*;
import tech.reliab.course.bondarenkosv.bank.service.impl.*;

import java.util.List;

public class Main {
    public static void initDataBase(
            BankService bankService,
            BankOfficeService bankOfficeService,
            EmployeeService employeeService,
            BankAtmService bankAtmService,
            UserService userService,
            PaymentAccountService paymentAccountService
    ) {
        for (int i = 1; i <= 5; i++) {
            Bank bank = bankService.create("Bank " + i);

            for (int j = 1; j <= 2; j++) {
                BankOffice bankOffice = bankOfficeService.create(
                        "Office " + j + " of Bank " + i,
                        "Address " + j,
                        "work",
                        bank.getId(),
                        true,
                        true,
                        true,
                        true,
                        10000 + j * 100,
                        1000 + j * 50
                );

                for (int k = 1; k <= 2; k++) {
                    Employee employee = employeeService.create(
                            "Employee " + k + " of Office " + j + " of Bank " + i,
                            "01.01.2000",
                            "Position " + k,
                            bank.getId(),
                            false,
                            bankOffice.getId(),
                            true,
                            1000 + k * 100
                    );

                    for (int l = 1; l <= 2; l++) {
                        bankAtmService.create(
                                "ATM " + l + " of Office " + j + " of Bank " + i,
                                "Address " + l,
                                "work",
                                bank.getId(),
                                bankOffice.getId(),
                                employee.getId(),
                                true,
                                true,
                                1000 + l * 50,
                                100 + l * 10
                        );
                    }
                }
            }

            for (int m = 1; m <= 5; m++) {
                User user = userService.create(
                        "User " + m + " of Bank " + i,
                        "01.01.1990",
                        "User Address " + m,
                        new int[]{bank.getId()},
                        1000 + m * 100
                );

                paymentAccountService.create(
                        user.getId(),
                        bank.getId()
                );
            }
        }
    }

    public static int selectBank(BankService bankService, float amount) {
        List<Bank> banks = bankService.list();

        if (banks.isEmpty()) {
            return -1;
        }

        int betterOfficeIndex = 0;

        for (int i = 1; i < banks.size(); i++) {
            Bank curBank = banks.get(i);
            Bank betterBank = banks.get(betterOfficeIndex);

            float availableMoney = curBank.getTotalMoney() - curBank.getReservedMoney();

            if (curBank.isActive() &&
                    availableMoney > amount &&
                    curBank.getBankAtmNum() >= betterBank.getBankAtmNum() &&
                    curBank.getEmployeesNum() >= betterBank.getEmployeesNum() &&
                    curBank.getOfficesNum() >= betterBank.getOfficesNum()
            ) {
                betterOfficeIndex = i;
            }
        }

        Bank betterBank = banks.get(betterOfficeIndex);
        float availableMoney = betterBank.getTotalMoney() - betterBank.getReservedMoney();

        if (availableMoney <= amount) {
            return -1;
        }

        return banks.get(betterOfficeIndex).getId();
    }

    public static int selectOffice(BankOfficeService bankOfficeService, int bank, float amount) {
        List<BankOffice> bankOffices = bankOfficeService.list();
        if (bankOffices.isEmpty()) {
            return -1;
        }
        for (BankOffice curBankOffice : bankOffices) {
            float availableMoney = curBankOffice.getTotalMoney() - curBankOffice.getReservedMoney();

            if (curBankOffice.isActive() &&
                    curBankOffice.getBank() == bank &&
                    curBankOffice.isCanAppleCredit() &&
                    curBankOffice.isCanTakeMoney() &&
                    availableMoney >= amount
            ) {
                return curBankOffice.getId();
            }
        }

        return -1;
    }

    public static int selectEmployee(EmployeeService employeeService, int bankOffice) {
        List<Employee> employees = employeeService.list();
        if (employees.isEmpty()) {
            return -1;
        }

        for (Employee curEmployee : employees) {
            if (curEmployee.isActive() && curEmployee.getBankOffice() == bankOffice && curEmployee.isCanApplyCredits()) {
                return curEmployee.getId();
            }
        }
        return -1;
    }


    public static int checkPaymentAccount(PaymentAccountService paymentAccountService, int user) {
        List<PaymentAccount> paymentAccounts = paymentAccountService.list();
        for (PaymentAccount paymentAccount : paymentAccounts) {
            if (paymentAccount.getUser() == user) {
                return paymentAccount.getId();
            }
        }
        return -1;
    }

    public static int selectAtm(BankAtmService bankAtmService, int bank, int bankOffice, float amount) {
        List<BankAtm> bankAtms = bankAtmService.list();

        for (BankAtm curBankAtm : bankAtms) {
            float availableMoney = curBankAtm.getTotalMoney() - curBankAtm.getReservedMoney();
            if (curBankAtm.getBankOffice() == bankOffice && availableMoney >= amount) {
                return curBankAtm.getId();
            }
        }

        for (BankAtm curBankAtm : bankAtms) {
            float availableMoney = curBankAtm.getTotalMoney() - curBankAtm.getReservedMoney();
            if (curBankAtm.getBank() == bank && availableMoney >= amount) {
                return curBankAtm.getId();
            }
        }
        return -1;
    }

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
        paymentAccountService.initBankService(bankService);

        CreditAccountService creditAccountService = new CreditAccountService();
        creditAccountService.init();
        creditAccountService.initBankService(bankService);
        creditAccountService.initUserService(userService);
        creditAccountService.initEmployeeService(employeeService);
        creditAccountService.initPaymentAccountService(paymentAccountService);

        // Инициализация данных
        initDataBase(
                bankService,
                bankOfficeService,
                employeeService,
                bankAtmService,
                userService,
                paymentAccountService
        );

        User user = userService.read(1);
        String creditStart = "01.01.2024";
        String creditEnd = "01.01.2034";
        float monthlyPayment = 100f;
        float amount = 1000f;

        int selectedBank = selectBank(bankService, amount);
        if (selectedBank == -1) {
            System.out.println("Нет банка с достаточным количеством денег");
        }

        int selectOffice = selectOffice(bankOfficeService, selectedBank, amount);
        if (selectedBank == -1) {
            System.out.println("Нет подходящего офиса");
        }

        int selectEmployee = selectEmployee(employeeService, selectOffice);
        if (selectedBank == -1) {
            System.out.println("Нет подходящего сотрудника");
        }

        int paymentAccount = checkPaymentAccount(paymentAccountService, user.getId());
        if (paymentAccount == -1) {
            paymentAccount = paymentAccountService.create(user.getId(), selectedBank).getId();
        }

        float userRating = paymentAccountService.read(paymentAccount).getPercentageRate();
        float bankRating = bankService.read(selectedBank).getPercentageRate();
        if (userRating < 5000 && bankRating > 50) {
            System.out.println("Слишком низкий рейтинг пользователя");
            return;
        }

        CreditAccount creditAccount = creditAccountService.create(
                user.getId(),
                selectedBank,
                selectEmployee,
                paymentAccount,
                creditStart,
                creditEnd,
                amount,
                monthlyPayment
        );
        System.out.println(creditAccount.toString());

        int selectAtm = selectAtm(bankAtmService, selectedBank, selectOffice, amount);
        if (selectAtm == -1) {
            System.out.println("Пока нет доступных банкоматов с нужным количеством денег, обратитесь в банк");
        } else {
            System.out.println(bankAtmService.read(selectAtm).toString());
        }
    }
}
