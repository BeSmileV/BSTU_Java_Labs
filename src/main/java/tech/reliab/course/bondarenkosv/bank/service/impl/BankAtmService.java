package main.java.tech.reliab.course.bondarenkosv.bank.service.impl;

import main.java.tech.reliab.course.bondarenkosv.bank.entity.BankAtm;
import main.java.tech.reliab.course.bondarenkosv.bank.entity.BankOffice;
import main.java.tech.reliab.course.bondarenkosv.bank.service.BankAtmServiceInterface;

public class BankAtmService extends BaseService<BankAtm> implements BankAtmServiceInterface {
    BankService bankService;
    BankOfficeService bankOfficeService;
    EmployeeService employeeService;

    @Override
    public void initBankService(BankService bankService) {
        this.bankService = bankService;
    }

    @Override
    public void initBankOfficeService(BankOfficeService bankOfficeService) {
        this.bankOfficeService = bankOfficeService;
    }

    @Override
    public void initEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public BankAtm create(
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
    ) {
        boolean isExistsBankEntity = bankService.isExists(bank);
        boolean isExistsBankOfficeEntity = bankOfficeService.isExists(bankOffice);
        boolean isExistsEmployeeEntity = employeeService.isExists(employee);

        if (!isExistsBankEntity || !isExistsBankOfficeEntity || !isExistsEmployeeEntity) {
            return null;
        }

        BankOffice bankOfficeEntity = bankOfficeService.read(bankOffice);
        boolean bankOfficeCanTakeMoney = bankOfficeEntity.getCanTakeMoney();
        boolean bankOfficeCanGetMoney = bankOfficeEntity.getCanGetMoney();
        float bankOfficeTotalMoney = bankOfficeEntity.getTotalMoney();
        float bankOfficeReservedMoney = bankOfficeEntity.getReservedMoney();

        if (!bankOfficeCanGetMoney && canGetMoney ||
                !bankOfficeCanTakeMoney && canTakeMoney ||
                totalMoney + bankOfficeReservedMoney > bankOfficeTotalMoney) {
            return null;
        }

        BankAtm newEntity = new BankAtm(
                name,
                address,
                status,
                bank,
                bankOffice,
                employee,
                canGetMoney,
                canTakeMoney,
                totalMoney,
                serviceCost,
                0
        );
        newEntity.setId(entityList.size() + 1);

        return newEntity;
    }
}
