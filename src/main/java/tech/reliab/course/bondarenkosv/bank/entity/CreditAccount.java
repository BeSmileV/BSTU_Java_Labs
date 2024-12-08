package tech.reliab.course.bondarenkosv.bank.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreditAccount extends BaseEntity<CreditAccount> {
    private int user;
    private int bank;
    private int employee;
    private int paymentAccount;
    private String creditStart;
    private String creditEnd;
    private float creditSum;
    private float monthlyPayment;

    public CreditAccount(
            int user,
            int bank,
            int employee,
            int paymentAccount,
            String creditStart,
            String creditEnd,
            float creditSum,
            float monthlyPayment
    ) {
        this.user = user;
        this.bank = bank;
        this.employee = employee;
        this.paymentAccount = paymentAccount;
        this.creditStart = creditStart;
        this.creditEnd = creditEnd;
        this.creditSum = creditSum;
        this.monthlyPayment = monthlyPayment;
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
                monthlyPayment
        );
        copy.setId(id);
        return copy;
    }
}
