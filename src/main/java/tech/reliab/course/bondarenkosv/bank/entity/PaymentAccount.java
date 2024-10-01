package main.java.tech.reliab.course.bondarenkosv.bank.entity;

public class PaymentAccount extends BaseEntity<PaymentAccount> {
    private User user;
    private Bank bank;
    private float amount;

    public PaymentAccount(
            User user,
            Bank bank,
            float amount
    ) {
        this.user = user;
        this.bank = bank;
        this.amount = amount;
    }

    // Getters
    public User getUser() {
        return user;
    }

    public Bank getBank() {
        return bank;
    }

    public float getAmount() {
        return amount;
    }

    // Setters
    public void setUser(User user) {
        this.user = user;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }


    @Override
    public PaymentAccount copy() {
        PaymentAccount copy = new PaymentAccount(
                user.copy(),
                bank.copy(),
                amount
        );
        copy.setId(id);
        return copy;
    }

    @Override
    public String toString() {
        return "PaymentAccount(" +
                "id=" + id +
                ", user=" + user.toString() +
                ", bank=" + bank.toString() +
                ", amount=" + amount +
                ")";
    }
}
