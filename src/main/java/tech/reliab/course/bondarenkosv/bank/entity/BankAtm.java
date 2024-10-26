package tech.reliab.course.bondarenkosv.bank.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BankAtm extends BaseEntity<BankAtm> {
    private String name;
    private String address;
    private String status;
    private int bank;
    private int bankOffice;
    private int employee;
    private boolean canGetMoney;
    private boolean canTakeMoney;
    private float totalMoney;
    private float reservedMoney;
    private float serviceCost;

    public BankAtm(
            String name,
            String address,
            String status,
            int bank,
            int bankOffice,
            int employee,
            boolean canGetMoney,
            boolean canTakeMoney,
            float totalMoney,
            float serviceCost,
            float reservedMoney
    ) {
        this.name = name;
        this.address = address;
        this.status = status;
        this.bank = bank;
        this.bankOffice = bankOffice;
        this.employee = employee;
        this.canGetMoney = canGetMoney;
        this.canTakeMoney = canTakeMoney;
        this.totalMoney = totalMoney;
        this.serviceCost = serviceCost;
        this.reservedMoney = reservedMoney;
    }

    @Override
    public BankAtm copy() {
        BankAtm copy = new BankAtm(
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
                reservedMoney
        );
        copy.setId(id);
        return copy;
    }
}
