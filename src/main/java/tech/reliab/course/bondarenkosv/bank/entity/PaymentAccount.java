package tech.reliab.course.bondarenkosv.bank.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PaymentAccount extends BaseEntity<PaymentAccount> {
    private int user;
    private int bank;
    private float amount;
    private float percentageRate;

    public PaymentAccount(
            int user,
            int bank,
            float amount,
            float percentageRate
    ) {
        this.user = user;
        this.bank = bank;
        this.amount = amount;
        this.percentageRate = percentageRate;
    }

    @Override
    public PaymentAccount copy() {
        PaymentAccount copy = new PaymentAccount(
                user,
                bank,
                amount,
                percentageRate
        );
        copy.setId(id);
        return copy;
    }
}
