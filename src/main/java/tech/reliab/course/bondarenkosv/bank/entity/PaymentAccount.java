package main.java.tech.reliab.course.bondarenkosv.bank.entity;

public class PaymentAccount extends BaseEntity<PaymentAccount> {
    private int user;
    private int bank;
    private float amount;

    public PaymentAccount(
            int user,
            int bank,
            float amount
    ) {
        this.user = user;
        this.bank = bank;
        this.amount = amount;
    }

    // Getters
    public int getUser() {
        return user;
    }

    public int getBank() {
        return bank;
    }

    public float getAmount() {
        return amount;
    }

    // Setters
    public void setUser(int user) {
        this.user = user;
    }

    public void setBank(int bank) {
        this.bank = bank;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }


    @Override
    public PaymentAccount copy() {
        PaymentAccount copy = new PaymentAccount(
                user,
                bank,
                amount
        );
        copy.setId(id);
        return copy;
    }

    @Override
    public String toString() {
        return "PaymentAccount(" +
                "id=" + id +
                ", user=" + user +
                ", bank=" + bank +
                ", amount=" + amount +
                ")";
    }
}
