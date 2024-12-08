package tech.reliab.course.bondarenkosv.bank.service.impl;

import tech.reliab.course.bondarenkosv.bank.entity.Employee;
import tech.reliab.course.bondarenkosv.bank.service.EmployeeServiceInterface;

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
    public boolean canApplyCredits(int id) {
        Employee entity = read(id);
        return entity.isCanApplyCredits();
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

        // Проверяем наличие банка и офиса
        if (!isExistsBank && !isExistsBankOffice) {
            return null;
        }

        // Проверяем возможность выдавать кредиты офисом банка
        boolean canBankOfficeAppleCredit = bankOfficeService.read(bankOffice).isCanAppleCredit();
        if (!canBankOfficeAppleCredit && canApplyCredits) {
            return null;
        }

        bankService.addEmployee(bank);
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
        newEntity.setId(entityList.size() + 1);
        entityList.add(newEntity);
        return newEntity.copy();
    }
}
