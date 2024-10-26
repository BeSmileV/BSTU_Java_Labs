package tech.reliab.course.bondarenkosv.bank.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BankOffice extends BaseEntity<BankOffice> {
    private String name;
    private String address;
    private String status;
    private int bank;
    private boolean canHasBankAtm;
    private int numOfBankAtm;
    private boolean canAppleCredit;
    private boolean canGetMoney;
    private boolean canTakeMoney;
    private float totalMoney;
    private float bankOfficeRentCost;
    private float reservedMoney;

    public BankOffice(
            String name,
            String address,
            String status,
            int bank,
            boolean canHasBankAtm,
            int numOfBankAtm,
            boolean canAppleCredit,
            boolean canGetMoney,
            boolean canTakeMoney,
            float totalMoney,
            float bankOfficeRentCost,
            float reservedMoney
    ) {
        this.name = name;
        this.address = address;
        this.status = status;
        this.bank = bank;
        this.canHasBankAtm = canHasBankAtm;
        this.numOfBankAtm = numOfBankAtm;
        this.canAppleCredit = canAppleCredit;
        this.canGetMoney = canGetMoney;
        this.canTakeMoney = canTakeMoney;
        this.totalMoney = totalMoney;
        this.bankOfficeRentCost = bankOfficeRentCost;
        this.reservedMoney = reservedMoney;
    }

    @Override
    public BankOffice copy() {
        BankOffice copy = new BankOffice(
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
                reservedMoney
        );
        copy.setId(id);
        return copy;
    }
}
