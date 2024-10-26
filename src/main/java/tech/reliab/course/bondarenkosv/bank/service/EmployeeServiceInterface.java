package tech.reliab.course.bondarenkosv.bank.service;

import tech.reliab.course.bondarenkosv.bank.entity.Employee;
import tech.reliab.course.bondarenkosv.bank.service.impl.BankOfficeService;
import tech.reliab.course.bondarenkosv.bank.service.impl.BankService;

public interface EmployeeServiceInterface extends BaseServiceInterface<Employee> {
    void initBankService(BankService bankService);

    void initBankOfficeService(BankOfficeService bankOfficeService);

    boolean canApplyCredits(int id);

    Employee create(
            String fio,
            String dateOfBirth,
            String position,
            int bank,
            boolean isRemote,
            int bankOffice,
            boolean canApplyCredits,
            float salary
    );
}
