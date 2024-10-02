package main.java.tech.reliab.course.bondarenkosv.bank.entity;

import java.util.Arrays;

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

    public int[] getBanks() {
        return banks.clone();
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

    public void setBanks(int[] banks) {
        this.banks = banks.clone();
    }

    public void setCreditRating(float creditRating) {
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

    @Override
    public String toString() {
        return "User(" +
                "id=" + id +
                ", fio=" + fio +
                ", dateOfBirth=" + dateOfBirth +
                ", workAddress=" + workAddress +
                ", monthlyIncome=" + monthlyIncome +
                ", banks=" + Arrays.toString(banks) +
                ")";
    }
}
