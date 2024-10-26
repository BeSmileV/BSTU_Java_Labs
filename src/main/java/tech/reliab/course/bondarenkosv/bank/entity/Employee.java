package tech.reliab.course.bondarenkosv.bank.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
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
}
