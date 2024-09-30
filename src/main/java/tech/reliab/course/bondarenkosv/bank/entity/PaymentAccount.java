package main.java.tech.reliab.course.bondarenkosv.bank.entity;

public class PaymentAccount extends BaseEntity {
    private User user;
    private Bank bank;
    private float amount;

    public PaymentAccount(
            int id,
            User user,
            Bank bank,
            float amount
    ) {
        this.id = id;
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
        return new PaymentAccount(
                id,
                user.copy(),
                bank.copy(),
                amount
        );
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
