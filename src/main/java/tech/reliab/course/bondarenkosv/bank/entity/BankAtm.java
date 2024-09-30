package main.java.tech.reliab.course.bondarenkosv.bank.entity;

public class BankAtm extends BaseEntity {
    private String name;
    private String address;
    private String status;
    private Bank bank;
    private BankOffice bankOffice;
    private Employee employee;
    private boolean canGetMoney;
    private boolean canTakeMoney;
    private float totalMoney;
    private float serviceCost;

    public BankAtm(
            int id,
            String name,
            String address,
            String status,
            Bank bank,
            BankOffice bankOffice,
            Employee employee,
            boolean canGetMoney,
            boolean canTakeMoney,
            float totalMoney,
            float serviceCost
    ) {
        this.id = id;
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
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getStatus() {
        return status;
    }

    public Bank getBank() {
        return bank;
    }

    public BankOffice getBankOffice() {
        return bankOffice;
    }

    public Employee getEmployee() {
        return employee;
    }

    public boolean getIsCanGetMoney() {
        return canGetMoney;
    }

    public boolean getIsCanTakeMoney() {
        return canTakeMoney;
    }

    public float getTotalMoney() {
        return totalMoney;
    }

    public float getServiceCost() {
        return serviceCost;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void setBankOffice(BankOffice bankOffice) {
        this.bankOffice = bankOffice;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setCanGetMoney(boolean canGetMoney) {
        this.canGetMoney = canGetMoney;
    }

    public void setCanTakeMoney(boolean canTakeMoney) {
        this.canTakeMoney = canTakeMoney;
    }

    public void setTotalMoney(float totalMoney) {
        this.totalMoney = totalMoney;
    }

    public void setServiceCost(float serviceCost) {
        this.serviceCost = serviceCost;
    }


    @Override
    public BankAtm copy() {
        return new BankAtm(
                id,
                name,
                address,
                status,
                bank,
                bankOffice,
                employee,
                canGetMoney,
                canTakeMoney,
                totalMoney,
                serviceCost
        );
    }

    public String toString() {
        return "BankAtm(" +
                "id=" + id +
                ", name=" + name +
                ", address=" + address +
                ", status=" + status +
                ", bank=" + bank.toString() +
                ", bankOffice=" + bankOffice.toString() +
                ", employee=" + employee.toString() +
                ", canGetMoney=" + canGetMoney +
                ", canTakeMoney=" + canTakeMoney +
                ", totalMoney=" + totalMoney +
                ", serviceCost=" + serviceCost +
                ")";
    }
}
