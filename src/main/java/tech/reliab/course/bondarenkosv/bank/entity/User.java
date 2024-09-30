package main.java.tech.reliab.course.bondarenkosv.bank.entity;

import java.util.ArrayList;
import java.util.List;

import static main.java.tech.reliab.course.bondarenkosv.bank.utils.BankUtils.bankArrayToString;
import static main.java.tech.reliab.course.bondarenkosv.bank.utils.BankUtils.copyBankList;
import static main.java.tech.reliab.course.bondarenkosv.bank.utils.UserUtils.generateUserCreditRating;

public class User extends BaseEntity {
    private String fio;
    private String dateOfBirth;
    private String workAddress;
    private float monthlyIncome;
    private List<Bank> banks;
    private float creditRating;

    public User(
            int id,
            String fio,
            String dateOfBirth,
            String workAddress,
            List<Bank> banks,
            float monthlyIncome
    ) {
        this.id = id;
        this.fio = fio;
        this.dateOfBirth = dateOfBirth;
        this.workAddress = workAddress;
        this.banks = banks;
        this.monthlyIncome = monthlyIncome;
        this.creditRating = generateUserCreditRating(this.monthlyIncome);
    }

    // Getters
    public String getFio() {
        return fio;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public float getMonthlyIncome() {
        return monthlyIncome;
    }

    public List<Bank> getBanks() {
        List<Bank> copy = new ArrayList<>();

        for (Bank bank : banks) {
            copy.add(bank.copy());
        }

        return copy;
    }

    public float getCreditRating() {
        return creditRating;
    }

    // Setters
    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    public void setMonthlyIncome(float monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public void setBanks(List<Bank> banks) {
        this.banks = banks;
    }

    public void setCreditRating(float creditRating) {
        this.creditRating = creditRating;
    }


    @Override
    public User copy() {
        return new User(
                id,
                fio,
                dateOfBirth,
                workAddress,
                copyBankList(banks),
                monthlyIncome
        );
    }

    @Override
    public String toString() {
        return "User(" +
                "id=" + id +
                ", fio=" + fio +
                ", dateOfBirth=" + dateOfBirth +
                ", workAddress=" + workAddress +
                ", monthlyIncome=" + monthlyIncome +
                ", banks=" + bankArrayToString(banks) +
                ")";
    }
}
