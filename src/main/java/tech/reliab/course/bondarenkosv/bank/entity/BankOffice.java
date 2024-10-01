package main.java.tech.reliab.course.bondarenkosv.bank.entity;

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

    public boolean getIsCanHasBankAtm() {
        return canHasBankAtm;
    }

    public int getNumOfBankAtm() {
        return numOfBankAtm;
    }

    public boolean getCanAppleCredit() {
        return canAppleCredit;
    }

    public boolean getCanGetMoney() {
        return canGetMoney;
    }

    public boolean getCanTakeMoney() {
        return canTakeMoney;
    }

    public float getTotalMoney() {
        return totalMoney;
    }

    public float getReservedMoney() {
        return reservedMoney;
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

    public void setBank(int bank) {
        this.bank = bank;
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

    public void setReservedMoney(float reservedMoney) {
        this.reservedMoney = reservedMoney;
    }


    public void setBankOfficeRentCost(float bankOfficeRentCost) {
        this.bankOfficeRentCost = bankOfficeRentCost;
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

    @Override
    public String toString() {
        return "BankOffice(" +
                "id=" + id +
                ", name=" + name +
                ", address=" + address +
                ", status=" + status +
                ", bank_id=" + bank +
                ", canHasBankAtm=" + canHasBankAtm +
                ", numOfBankAtm=" + numOfBankAtm +
                ", canAppleCredit=" + canAppleCredit +
                ", canGetMoney=" + canGetMoney +
                ", canTakeMoney=" + canTakeMoney +
                ", totalMoney=" + totalMoney +
                ", bankOfficeRentCost=" + bankOfficeRentCost +
                ", reservedMoney=" + reservedMoney +
                ")";
    }
}
