import main.java.tech.reliab.course.bondarenkosv.bank.entity.Bank;
import main.java.tech.reliab.course.bondarenkosv.bank.service.BankService;

public class Main {
    public static void main(String[] args) {
        BankService bankService = new BankService();

        int id1 = bankService.create("test1").getId();
        int id2 = bankService.create("test2").getId();
        int id3 = bankService.create("test3").getId();

        Bank bank1 = bankService.read(id1);
        System.out.println("read bank : " + bank1);

        bank1.setName("new test1 to test 3");
        bankService.update(id3, bank1);
        System.out.println("update bank : " + bankService.read(id3));

        bankService.delete(id2);

        for (Bank bank : bankService.list()) {
            System.out.println(bank);
        }
    }
}