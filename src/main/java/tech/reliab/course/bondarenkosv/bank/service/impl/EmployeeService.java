package main.java.tech.reliab.course.bondarenkosv.bank.service.impl;

import main.java.tech.reliab.course.bondarenkosv.bank.entity.Employee;
import main.java.tech.reliab.course.bondarenkosv.bank.service.EmployeeServiceInterface;

public class EmployeeService extends BaseService<Employee> implements EmployeeServiceInterface {
    private BankService bankService;
    private BankOfficeService bankOfficeService;

    @Override
    public void initBankService(BankService bankService) {
        this.bankService = bankService;
    }

    @Override
    public void initBankOfficeService(BankOfficeService bankOfficeService) {
        this.bankOfficeService = bankOfficeService;
    }

    @Override
    public Employee create(
            String fio,
            String dateOfBirth,
            String position,
            int bank,
            boolean isRemote,
            int bankOffice,
            boolean canApplyCredits,
            float salary
    ) {
        boolean isExistsBank = bankService.isExists(bank);
        boolean isExistsBankOffice = bankOfficeService.isExists(bankOffice);

        if (!isExistsBank && !isExistsBankOffice) {
            return null;
        }

        boolean canBankOfficeAppleCredit = bankOfficeService.read(bankOffice).getCanAppleCredit();
        if (!canBankOfficeAppleCredit && canApplyCredits) {
            return null;
        }

        Employee newEntity = new Employee(
                fio,
                dateOfBirth,
                position,
                bank,
                isRemote,
                bankOffice,
                canApplyCredits,
                salary
        );
        bankService.addEmployee(bank);
        return newEntity;
    }
}
