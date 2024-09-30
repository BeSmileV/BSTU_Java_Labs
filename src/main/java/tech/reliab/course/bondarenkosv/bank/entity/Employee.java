package main.java.tech.reliab.course.bondarenkosv.bank.entity;

public class Employee extends BaseEntity {
    private String fio;
    private String dateOfBirth;
    private String position;
    private Bank bank;
    private boolean isRemote;
    private BankOffice bankOffice;
    private boolean canApplyCredits;
    private float salary;

    public Employee(
            int id,
            String fio,
            String dateOfBirth,
            String position,
            Bank bank,
            boolean isRemote,
            BankOffice bankOffice,
            boolean canApplyCredits,
            float salary
    ) {
        this.id = id;
        this.fio = fio;
        this.dateOfBirth = dateOfBirth;
        this.position = position;
        this.bank = bank;
        this.isRemote = isRemote;
        this.bankOffice = bankOffice;
        this.canApplyCredits = canApplyCredits;
        this.salary = salary;
    }

    // Getters
    public String getFio() {
        return fio;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPosition() {
        return position;
    }

    public Bank getBank() {
        return bank;
    }

    public boolean getIsRemote() {
        return isRemote;
    }

    public BankOffice getBankOffice() {
        return bankOffice;
    }

    public boolean getCanApplyCredits() {
        return canApplyCredits;
    }

    public float getSalary() {
        return salary;
    }

    // Setters
    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void setIsRemote(boolean isRemote) {
        this.isRemote = isRemote;
    }

    public void setBankOffice(BankOffice bankOffice) {
        this.bankOffice = bankOffice;
    }

    public void setCanApplyCredits(boolean canApplyCredits) {
        this.canApplyCredits = canApplyCredits;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public Employee copy() {
        return new Employee(
                id,
                fio,
                dateOfBirth,
                position,
                bank,
                isRemote,
                bankOffice,
                canApplyCredits,
                salary
        );
    }

    @Override
    public String toString() {
        return "Employee(" +
                "id=" + id +
                ", fio=" + fio +
                ", dateOfBirth=" + dateOfBirth +
                ", position=" + position +
                ", bank=" + bank.toString() +
                ", isRemote=" + isRemote +
                ", bankOffice=" + bankOffice.toString() +
                ", canApplyCredits=" + canApplyCredits +
                ", salary=" + salary +
                ")";
    }
}
