package tech.reliab.course.bondarenkosv.bank.service;

public interface BankServiceInterface<T> extends BaseServiceInterface<T> {
    T create(String name);

    void addOffice(int id);

    void addAtm(int id);

    void addEmployee(int id);

    void addClient(int id);

    boolean reserveMoney(int id, float money);

    boolean getCredit(int id, float money, float percentageRate);
}
