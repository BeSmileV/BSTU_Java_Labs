package main.java.tech.reliab.course.bondarenkosv.bank.entity;

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

    public int getBank() {
        return bank;
    }

    public int getBankOffice() {
        return bankOffice;
    }

    public int getEmployee() {
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

    public float getReservedMoney() {
        return reservedMoney;
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

    public void setBank(int bank) {
        this.bank = bank;
    }

    public void setBankOffice(int bankOffice) {
        this.bankOffice = bankOffice;
    }

    public void setEmployee(int employee) {
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

    public void setReservedMoney(float reservedMoney) {
        this.reservedMoney = reservedMoney;
    }

    public void setServiceCost(float serviceCost) {
        this.serviceCost = serviceCost;
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

    public String toString() {
        return "BankAtm(" +
                "id=" + id +
                ", name=" + name +
                ", address=" + address +
                ", status=" + status +
                ", bank_id=" + bank +
                ", bankOffice_id=" + bankOffice +
                ", employee_id=" + employee +
                ", canGetMoney=" + canGetMoney +
                ", canTakeMoney=" + canTakeMoney +
                ", totalMoney=" + totalMoney +
                ", serviceCost=" + serviceCost +
                ", reservedMoney=" + reservedMoney +
                ")";
    }
}
