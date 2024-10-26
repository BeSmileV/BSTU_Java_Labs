package tech.reliab.course.bondarenkosv.bank.service;

import tech.reliab.course.bondarenkosv.bank.entity.BankAtm;
import tech.reliab.course.bondarenkosv.bank.service.impl.BankOfficeService;
import tech.reliab.course.bondarenkosv.bank.service.impl.BankService;
import tech.reliab.course.bondarenkosv.bank.service.impl.EmployeeService;

public interface BankAtmServiceInterface extends BaseServiceInterface<BankAtm> {
    BankAtm create(
            String name,
            String address,
            String status,
            int bank,
            int bankOffice,
            int employee,
            boolean canGetMoney,
            boolean canTakeMoney,
            float totalMoney,
            float serviceCost
    );

    void initBankService(BankService bankService);

    void initBankOfficeService(BankOfficeService bankOfficeService);

    void initEmployeeService(EmployeeService employeeService);
}
