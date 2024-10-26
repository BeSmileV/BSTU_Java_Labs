package tech.reliab.course.bondarenkosv.bank.utils;

import tech.reliab.course.bondarenkosv.bank.consts.BankConsts;
import tech.reliab.course.bondarenkosv.bank.entity.Bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BankUtils {
    static public float generateBankRating() {
        Random random = new Random();
        return random.nextFloat() * BankConsts.MAX_RATING;
    }

    static public float generateBankTotalMoney() {
        Random random = new Random();
        return random.nextFloat() * BankConsts.MAX_TOTAL_MONEY;
    }

    static public float generatePercentageRate(float rating) {
        Random random = new Random();
        return random.nextInt(BankConsts.MAX_PERCENTAGE_RATE / 2 +
                (int) (rating * BankConsts.MAX_PERCENTAGE_RATE / 2));
    }

    static public String bankArrayToString(List<Bank> banks) {
        StringBuilder res = new StringBuilder("Banks[");

        for (Bank bank : banks) {
            res.append(bank.toString()).append(",");
        }

        return res + "]";
    }

    static public List<Bank> copyBankList(List<Bank> banks) {
        List<Bank> res = new ArrayList<Bank>();

        for (Bank bank : banks) {
            res.add(bank.copy());
        }

        return res;
    }
}

