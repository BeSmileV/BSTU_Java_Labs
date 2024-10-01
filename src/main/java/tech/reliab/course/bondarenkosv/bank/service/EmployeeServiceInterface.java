package main.java.tech.reliab.course.bondarenkosv.bank.service;

import main.java.tech.reliab.course.bondarenkosv.bank.entity.Employee;
import main.java.tech.reliab.course.bondarenkosv.bank.service.impl.BankOfficeService;
import main.java.tech.reliab.course.bondarenkosv.bank.service.impl.BankService;

public interface EmployeeServiceInterface extends BaseServiceInterface<Employee> {
    void initBankService(BankService bankService);

    void initBankOfficeService(BankOfficeService bankOfficeService);

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
