package tech.reliab.course.bondarenkosv.bank.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class User extends BaseEntity<User> {
    private String fio;
    private String dateOfBirth;
    private String workAddress;
    private float monthlyIncome;
    private int[] banks;
    private float creditRating;

    public User(
            String fio,
            String dateOfBirth,
            String workAddress,
            int[] banks,
            float monthlyIncome,
            float creditRating
    ) {
        this.fio = fio;
        this.dateOfBirth = dateOfBirth;
        this.workAddress = workAddress;
        this.banks = banks;
        this.monthlyIncome = monthlyIncome;
        this.creditRating = creditRating;
    }

    @Override
    public User copy() {
        User copy = new User(
                fio,
                dateOfBirth,
                workAddress,
                banks.clone(),
                monthlyIncome,
                creditRating
        );
        copy.setId(id);
        return copy;
    }
}
