package tech.reliab.course.bondarenkosv.bank.service.impl;

import tech.reliab.course.bondarenkosv.bank.entity.BankOffice;
import tech.reliab.course.bondarenkosv.bank.service.BankOfficeServiceInterface;

public class BankOfficeService extends BaseService<BankOffice> implements BankOfficeServiceInterface {
    private BankService bankService;

    @Override
    public void initBankService(BankService bankService) {
        this.bankService = bankService;
    }

    @Override
    public boolean addBankAtm(int id) {
        BankOffice bankOffice = this.read(id);

        if (bankOffice.isCanHasBankAtm()) {
            bankOffice.setNumOfBankAtm(bankOffice.getNumOfBankAtm() + 1);
            return true;
        }

        return false;
    }

    @Override
    public boolean reserveMoney(int id, float money) {
        BankOffice bankOffice = this.read(id);

        float totalMoney = bankOffice.getTotalMoney();
        float reservedMoney = bankOffice.getReservedMoney();
        if (bankOffice == null || (totalMoney - reservedMoney < money)) {
            return false;
        }

        bankOffice.setReservedMoney(reservedMoney + money);
        this.update(id, bankOffice);
        return true;
    }

    @Override
    public BankOffice create(
            String name,
            String address,
            String status,
            int bank,
            boolean canHasBankAtm,
            boolean canAppleCredit,
            boolean canGetMoney,
            boolean canTakeMoney,
            float totalMoney,
            float bankOfficeRentCost
    ) {
        boolean isExistsBank = bankService.isExists(bank);

        // Проверка наличия банка
        if (!isExistsBank) {
            return null;
        }

        // Резервирование денег в банке
        boolean reserveStatus = bankService.reserveMoney(bank, totalMoney);
        if (!reserveStatus) {
            return null;
        }

        int numOfBankAtm = 0;
        BankOffice newEntity = new BankOffice(
                name,
                address,
                status,
                bank,
                canHasBankAtm,
                numOfBankAtm,
                canAppleCredit,
                canGetMoney,
                canTakeMoney,
                totalMoney,
                bankOfficeRentCost,
                0
        );
        newEntity.setId(entityList.size() + 1);
        entityList.add(newEntity);
        return newEntity.copy();
    }
}
