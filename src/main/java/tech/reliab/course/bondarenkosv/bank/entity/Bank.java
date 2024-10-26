package tech.reliab.course.bondarenkosv.bank.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class Bank extends BaseEntity<Bank> {
    private String name;
    private int officesNum;
    private int bankAtmNum;
    private int employeesNum;
    private int clientsNum;
    private float rating;
    private float totalMoney;
    private float reservedMoney;
    private float percentageRate;

    public Bank(
            String name,
            int officeNum,
            int bankAtmNum,
            int employeesNum,
            int clientNum,
            float rating,
            float totalMoney,
            float reservedMoney,
            float percentageRate
    ) {
        this.name = name;
        this.officesNum = officeNum;
        this.bankAtmNum = bankAtmNum;
        this.employeesNum = employeesNum;
        this.clientsNum = clientNum;
        this.rating = rating;
        this.totalMoney = totalMoney;
        this.reservedMoney = reservedMoney;
        this.percentageRate = percentageRate;
    }

    @Override
    public Bank copy() {
        Bank copy = new Bank(
                name,
                officesNum,
                bankAtmNum,
                employeesNum,
                clientsNum,
                rating,
                totalMoney,
                reservedMoney,
                percentageRate
        );
        copy.setId(id);
        return copy;
    }
}
