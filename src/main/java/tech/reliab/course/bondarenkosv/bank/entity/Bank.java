package main.java.tech.reliab.course.bondarenkosv.bank.entity;

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

    // Getters
    public String getName() {
        return name;
    }

    public int getOfficesNum() {
        return officesNum;
    }

    public int getBankAtmNum() {
        return bankAtmNum;
    }

    public int getEmployeesNum() {
        return employeesNum;
    }

    public int getClientsNum() {
        return clientsNum;
    }

    public float getRating() {
        return rating;
    }

    public float getTotalMoney() {
        return totalMoney;
    }

    public float getReservedMoney() {
        return reservedMoney;
    }

    public float getPercentageRate() {
        return percentageRate;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setOfficesNum(int officesNum) {
        this.officesNum = officesNum;
    }

    public void setBankAtmNum(int bankAtmNum) {
        this.bankAtmNum = bankAtmNum;
    }

    public void setEmployeesNum(int employeesNum) {
        this.employeesNum = employeesNum;
    }

    public void setClientsNum(int clientsNum) {
        this.clientsNum = clientsNum;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setTotalMoney(float totalMoney) {
        this.totalMoney = totalMoney;
    }

    public void setReservedMoney(float reservedMoney) {
        this.reservedMoney = reservedMoney;
    }

    public void setPercentageRate(float percentageRate) {
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

    @Override
    public String toString() {
        return "Bank(" +
                "id=" + id +
                "; name=" + name +
                "; officeNum=" + officesNum +
                "; bankAtmNum=" + bankAtmNum +
                "; employeesNum=" + employeesNum +
                "; clientNum=" + clientsNum +
                "; rating=" + rating +
                "; totalMoney=" + totalMoney +
                "; reservedMoney=" + reservedMoney +
                "; percentageRate=" + percentageRate +
                ")";
    }
}
