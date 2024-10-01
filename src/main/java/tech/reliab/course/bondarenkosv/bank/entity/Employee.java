package main.java.tech.reliab.course.bondarenkosv.bank.entity;

public class Employee extends BaseEntity<Employee> {
    private String fio;
    private String dateOfBirth;
    private String position;
    private int bank;
    private boolean isRemote;
    private int bankOffice;
    private boolean canApplyCredits;
    private float salary;

    public Employee(
            String fio,
            String dateOfBirth,
            String position,
            int bank,
            boolean isRemote,
            int bankOffice,
            boolean canApplyCredits,
            float salary
    ) {
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

    public int getBank() {
        return bank;
    }

    public boolean getIsRemote() {
        return isRemote;
    }

    public int getBankOffice() {
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

    public void setBank(int bank) {
        this.bank = bank;
    }

    public void setIsRemote(boolean isRemote) {
        this.isRemote = isRemote;
    }

    public void setBankOffice(int bankOffice) {
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
        Employee copy = new Employee(
                fio,
                dateOfBirth,
                position,
                bank,
                isRemote,
                bankOffice,
                canApplyCredits,
                salary
        );
        copy.setId(id);
        return copy;
    }

    @Override
    public String toString() {
        return "Employee(" +
                "id=" + id +
                ", fio=" + fio +
                ", dateOfBirth=" + dateOfBirth +
                ", position=" + position +
                ", bank_id=" + bank +
                ", isRemote=" + isRemote +
                ", bankOffice_id=" + bankOffice +
                ", canApplyCredits=" + canApplyCredits +
                ", salary=" + salary +
                ")";
    }
}
