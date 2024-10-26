package tech.reliab.course.bondarenkosv.bank.service.impl;

import tech.reliab.course.bondarenkosv.bank.entity.BankAtm;
import tech.reliab.course.bondarenkosv.bank.entity.BankOffice;
import tech.reliab.course.bondarenkosv.bank.service.BankAtmServiceInterface;

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

        // Проверка наличия банка, офиса и работника
        boolean isExistsBankEntity = bankService.isExists(bank);
        boolean isExistsBankOfficeEntity = bankOfficeService.isExists(bankOffice);
        boolean isExistsEmployeeEntity = employeeService.isExists(employee);
        if (!isExistsBankEntity || !isExistsBankOfficeEntity || !isExistsEmployeeEntity) {
            return null;
        }

        // Проверка возможности выдачи и взятия денег и попытка зарезервировать деньги
        BankOffice bankOfficeEntity = bankOfficeService.read(bankOffice);
        boolean bankOfficeCanTakeMoney = bankOfficeEntity.isCanTakeMoney();
        boolean bankOfficeCanGetMoney = bankOfficeEntity.isCanGetMoney();
        boolean bankOfficeReservedMoney = bankOfficeService.reserveMoney(bankOffice, totalMoney);
        if (!bankOfficeCanGetMoney && canGetMoney ||
                !bankOfficeCanTakeMoney && canTakeMoney ||
                !bankOfficeReservedMoney) {
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
        entityList.add(newEntity);
        return newEntity.copy();
    }
}
