package main.java.tech.reliab.course.bondarenkosv.bank.entity;

public class CreditAccount extends BaseEntity<CreditAccount> {
    private int user;
    private int bank;
    private int employee;
    private int paymentAccount;
    private String creditStart;
    private String creditEnd;
    private float creditSum;
    private float monthlyPayment;
    private float percentageRate;

    public CreditAccount(
            int user,
            int bank,
            int employee,
            int paymentAccount,
            String creditStart,
            String creditEnd,
            float creditSum,
            float monthlyPayment,
            float percentageRate
    ) {
        this.user = user;
        this.bank = bank;
        this.employee = employee;
        this.paymentAccount = paymentAccount;
        this.creditStart = creditStart;
        this.creditEnd = creditEnd;
        this.creditSum = creditSum;
        this.monthlyPayment = monthlyPayment;
        this.percentageRate = percentageRate;
    }

    // Getters
    public int getUser() {
        return user;
    }

    public int getBank() {
        return bank;
    }

    public String getCreditStart() {
        return creditStart;
    }

    public String getCreditEnd() {
        return creditEnd;
    }

    public float getCreditSum() {
        return creditSum;
    }

    public float getMonthlyPayment() {
        return monthlyPayment;
    }

    public float getPercentageRate() {
        return percentageRate;
    }

    public int getEmployee() {
        return employee;
    }

    public int getPaymentAccount() {
        return paymentAccount;
    }

    // Setters
    public void setUser(int user) {
        this.user = user;
    }

    public void setBank(int bank) {
        this.bank = bank;
    }

    public void setCreditStart(String creditStart) {
        this.creditStart = creditStart;
    }

    public void setCreditEnd(String creditEnd) {
        this.creditEnd = creditEnd;
    }


    public void setCreditSum(float creditSum) {
        this.creditSum = creditSum;
    }

    public void setMonthlyPayment(float monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public void setPercentageRate(float percentageRate) {
        this.percentageRate = percentageRate;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
    }

    public void setPaymentAccount(int paymentAccount) {
        this.paymentAccount = paymentAccount;
    }


    @Override
    public CreditAccount copy() {
        CreditAccount copy = new CreditAccount(
                user,
                bank,
                employee,
                paymentAccount,
                creditStart,
                creditEnd,
                creditSum,
                monthlyPayment,
                percentageRate
        );
        copy.setId(id);
        return copy;
    }

    @Override
    public String toString() {
        return "CreditAccount(" +
                "id=" + id +
                ", user=" + user +
                ", bank=" + bank +
                ", employeeId=" + employee +
                ", paymentAccount=" + paymentAccount +
                ", creditStart=" + creditStart +
                ", creditEnd=" + creditEnd +
                ", creditSum=" + creditSum +
                ", monthlyPayment=" + monthlyPayment +
                ", percentageRate=" + percentageRate +
                ")";
    }
}
