package main.java.tech.reliab.course.bondarenkosv.bank.entity;

public class CreditAccount extends BaseEntity {
    private User user;
    private Bank bank;
    private String creditStart;
    private String creditEnd;
    private int mouthsNum;
    private float creditSum;
    private float monthlyPayment;
    private float percentageRate;
    private int employeeId;
    private PaymentAccount paymentAccount;

    public CreditAccount(
            int id,
            User user,
            Bank bank,
            String creditStart,
            String creditEnd,
            int mouthsNum,
            float creditSum,
            float monthlyPayment,
            float percentageRate,
            int employeeId
    ) {
        this.id = id;
        this.user = user;
        this.bank = bank;
        this.creditStart = creditStart;
        this.creditEnd = creditEnd;
        this.mouthsNum = mouthsNum;
        this.creditSum = creditSum;
        this.monthlyPayment = monthlyPayment;
        this.percentageRate = percentageRate;
        this.employeeId = employeeId;
    }

    // Getters
    public User getUser() {
        return user;
    }

    public Bank getBank() {
        return bank;
    }

    public String getCreditStart() {
        return creditStart;
    }

    public String getCreditEnd() {
        return creditEnd;
    }

    public int getMouthsNum() {
        return mouthsNum;
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

    public int getEmployeeId() {
        return employeeId;
    }

    public PaymentAccount getPaymentAccount() {
        return paymentAccount;
    }

    // Setters
    public void setUser(User user) {
        this.user = user;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void setCreditStart(String creditStart) {
        this.creditStart = creditStart;
    }

    public void setCreditEnd(String creditEnd) {
        this.creditEnd = creditEnd;
    }

    public void setMouthsNum(int mouthsNum) {
        this.mouthsNum = mouthsNum;
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

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setPaymentAccount(PaymentAccount paymentAccount) {
        this.paymentAccount = paymentAccount;
    }


    @Override
    public CreditAccount copy() {
        return new CreditAccount(
                id,
                user,
                bank,
                creditStart,
                creditEnd,
                mouthsNum,
                creditSum,
                monthlyPayment,
                percentageRate,
                employeeId
        );
    }

    @Override
    public String toString() {
        return "CreditAccount(" +
                "id=" + id +
                ", user=" + user.toString() +
                ", bank=" + bank.toString() +
                ", creditStart=" + creditStart +
                ", creditEnd=" + creditEnd +
                ", mouthsNum=" + mouthsNum +
                ", creditSum=" + creditSum +
                ", monthlyPayment=" + monthlyPayment +
                ", percentageRate=" + percentageRate +
                ", employeeId=" + employeeId +
                ", paymentAccount=" + paymentAccount.toString() +
                ")";
    }
}
