package main.java.tech.reliab.course.bondarenkosv.bank.entity;

import static main.java.tech.reliab.course.bondarenkosv.bank.utils.BankUtils.*;

public class Bank extends BaseEntity {
    private String name;
    private int officeNum;
    private int bankAtmNum;
    private int employeesNum;
    private int clientNum;
    private float rating;
    private float totalMoney;
    private float percentageRate;

    public Bank(
            int id,
            String name,
            int officeNum,
            int bankAtmNum,
            int employeesNum,
            int clientNum,
            float rating,
            float totalMoney,
            float percentageRate
    ) {
        this.id = id;
        this.name = name;
        this.officeNum = 0;
        this.bankAtmNum = 0;
        this.employeesNum = 0;
        this.clientNum = 0;
        this.rating = generateBankRating();
        this.totalMoney = generateBankTotalMoney();
        this.percentageRate = generatePercentageRate(this.rating);
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getOfficeNum() {
        return officeNum;
    }

    public int getBankAtmNum() {
        return bankAtmNum;
    }

    public int getEmployeesNum() {
        return employeesNum;
    }

    public int getClientNum() {
        return clientNum;
    }

    public float getRating() {
        return rating;
    }

    public float getTotalMoney() {
        return totalMoney;
    }

    public float getPercentageRate() {
        return percentageRate;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setOfficeNum(int officeNum) {
        this.officeNum = officeNum;
    }

    public void setBankAtmNum(int bankAtmNum) {
        this.bankAtmNum = bankAtmNum;
    }

    public void setEmployeesNum(int employeesNum) {
        this.employeesNum = employeesNum;
    }

    public void setClientNum(int clientNum) {
        this.clientNum = clientNum;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setTotalMoney(float totalMoney) {
        this.totalMoney = totalMoney;
    }

    public void setPercentageRate(float percentageRate) {
        this.percentageRate = percentageRate;
    }


    @Override
    public Bank copy() {
        return new Bank(
                id,
                name,
                officeNum,
                bankAtmNum,
                employeesNum,
                clientNum,
                rating,
                totalMoney,
                percentageRate
        );
    }

    @Override
    public String toString() {
        return "Bank(" +
                "id=" + id +
                "; name=" + name +
                "; officeNum=" + officeNum +
                "; bankAtmNum=" + bankAtmNum +
                "; employeesNum=" + employeesNum +
                "; clientNum=" + clientNum +
                "; rating=" + rating +
                "; totalMoney=" + totalMoney +
                "; percentageRate=" + percentageRate +
                ")";
    }
}
