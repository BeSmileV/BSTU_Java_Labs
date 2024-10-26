package tech.reliab.course.bondarenkosv.bank.service.impl;

import tech.reliab.course.bondarenkosv.bank.entity.Bank;
import tech.reliab.course.bondarenkosv.bank.service.BankServiceInterface;
import static tech.reliab.course.bondarenkosv.bank.utils.BankUtils.*;

public class BankService extends BaseService<Bank> implements BankServiceInterface<Bank> {
    @Override
    public boolean getCredit(int id, float money, float percentageRate) {
        Bank bank = read(id);
        if (bank.getPercentageRate() < percentageRate) {
            return false;
        }
        return reserveMoney(id, money);
    }

    @Override
    public Bank create(String name) {
        int officeNum = 0;
        int bankAtmNum = 0;
        int employeesNum = 0;
        int clientNum = 0;
        float rating = generateBankRating();
        float totalMoney = generateBankTotalMoney();
        float reservedMoney = 0;
        float percentageRate = generatePercentageRate(rating);

        Bank newEntity = new Bank(
                name,
                officeNum,
                bankAtmNum,
                employeesNum,
                clientNum,
                rating,
                totalMoney,
                reservedMoney,
                percentageRate
        );
        newEntity.setId(entityList.size() + 1);
        entityList.add(newEntity);
        return newEntity.copy();
    }

    @Override
    public void addOffice(int id) {
        Bank bank = this.read(id);
        int oldValue = bank.getOfficesNum();
        bank.setOfficesNum(++oldValue);
        this.update(id, bank);
    }

    @Override
    public void addAtm(int id) {
        Bank bank = this.read(id);
        int oldValue = bank.getBankAtmNum();
        bank.setBankAtmNum(++oldValue);
        this.update(id, bank);
    }

    @Override
    public void addEmployee(int id) {
        Bank bank = this.read(id);
        int oldValue = bank.getEmployeesNum();
        bank.setEmployeesNum(++oldValue);
        this.update(id, bank);
    }

    @Override
    public void addClient(int id) {
        Bank bank = this.read(id);
        int oldValue = bank.getClientsNum();
        bank.setClientsNum(oldValue + 1);
        this.update(id, bank);
    }

    @Override
    public boolean reserveMoney(int id, float money) {
        Bank bank = this.read(id);
        float newValue = bank.getReservedMoney() + money;
        float totalMoney = bank.getTotalMoney();

        if (totalMoney - newValue > 0) {
            bank.setReservedMoney(newValue);
            this.update(id, bank);

            return true;
        }

        return false;
    }
}
