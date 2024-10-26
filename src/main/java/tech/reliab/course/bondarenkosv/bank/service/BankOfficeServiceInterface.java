package tech.reliab.course.bondarenkosv.bank.service;

import tech.reliab.course.bondarenkosv.bank.entity.BankOffice;
import tech.reliab.course.bondarenkosv.bank.service.impl.BankService;

public interface BankOfficeServiceInterface extends BaseServiceInterface<BankOffice> {
    void initBankService(BankService bankService);

    BankOffice create(
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
    );

    boolean addBankAtm(int id);

    boolean reserveMoney(int id, float money);
}
