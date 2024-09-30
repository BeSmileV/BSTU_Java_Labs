package main.java.tech.reliab.course.bondarenkosv.bank.entity;

public class BankOffice extends BaseEntity {
    private String name;
    private String address;
    private String status;
    private boolean canHasBankAtm;
    private int numOfBankAtm;
    private boolean canAppleCredit;
    private boolean canGetMoney;
    private boolean canTakeMoney;
    private float totalMoney;
    private float bankOfficeRentCost;

    public BankOffice(
            int id,
            String name,
            String address,
            String status,
            boolean canHasBankAtm,
            int numOfBankAtm,
            boolean canAppleCredit,
            boolean canGetMoney,
            boolean canTakeMoney,
            float totalMoney,
            float bankOfficeRentCost
    ) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.status = status;
        this.canHasBankAtm = canHasBankAtm;
        this.numOfBankAtm = numOfBankAtm;
        this.canAppleCredit = canAppleCredit;
        this.canGetMoney = canGetMoney;
        this.canTakeMoney = canTakeMoney;
        this.totalMoney = totalMoney;
        this.bankOfficeRentCost = bankOfficeRentCost;
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

    public boolean getIsCanHasBankAtm() {
        return canHasBankAtm;
    }

    public int getNumOfBankAtm() {
        return numOfBankAtm;
    }

    public boolean getIsCanAppleCredit() {
        return canAppleCredit;
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

    public float getBankOfficeRentCost() {
        return bankOfficeRentCost;
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

    public void setCanHasBankAtm(boolean canHasBankAtm) {
        this.canHasBankAtm = canHasBankAtm;
    }

    public void setNumOfBankAtm(int numOfBankAtm) {
        this.numOfBankAtm = numOfBankAtm;
    }

    public void setCanAppleCredit(boolean canAppleCredit) {
        this.canAppleCredit = canAppleCredit;
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


    public void setBankOfficeRentCost(float bankOfficeRentCost) {
        this.bankOfficeRentCost = bankOfficeRentCost;
    }


    @Override
    public BankOffice copy() {
        return new BankOffice(
                id,
                name,
                address,
                status,
                canHasBankAtm,
                numOfBankAtm,
                canAppleCredit,
                canGetMoney,
                canTakeMoney,
                totalMoney,
                bankOfficeRentCost
        );
    }

    @Override
    public String toString() {
        return "BankOffice(" +
                "id=" + id +
                ", name=" + name +
                ", address=" + address +
                ", status=" + status +
                ", canHasBankAtm=" + canHasBankAtm +
                ", numOfBankAtm=" + numOfBankAtm +
                ", canAppleCredit=" + canAppleCredit +
                ", canGetMoney=" + canGetMoney +
                ", canTakeMoney=" + canTakeMoney +
                ", totalMoney=" + totalMoney +
                ", bankOfficeRentCost=" + bankOfficeRentCost +
                ")";
    }
}
