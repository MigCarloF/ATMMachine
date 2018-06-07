import java.util.List;

public class atmMachine {

    private int balance;
    private int moneyInMachine;
    private final int ONETHOUSAND = 1000;
    private final int FIVEHUNDRED = 500;
    private final int TWOHUNDRED = 200;
    private final int ONEHUNDRED = 100;
    private final int FIFTY = 50;
    private final int TWENTY = 20;
    private List<Bill> bills;

    public atmMachine(int moneyInMachine, int balance, List<Bill> bills){
        this.moneyInMachine = moneyInMachine;
        this.balance = balance;
        this.bills = bills;
    }

    public void transact(int amount){
        if (amount > balance) {
            System.out.println("Your account does not have enough balance");
        } else if (amount > moneyInMachine) {
            System.out.println("Cannot dispense amount. Machine lacking money");
        } else {
            // Checks to see if coins will be dispensed
            boolean errCheck = false; //errCheck = false, checks but 20 first
            boolean fail = false;
            int tAmount = amount % 100;
            while (tAmount >= 50) {
                tAmount -= 50;
            }
            while (tAmount >= 20) {
                tAmount -= 20;
            }
            if (tAmount != 0) {
                errCheck = true;
            }

            //considers 60
            if (errCheck) {
                tAmount = amount % 100;
                while (tAmount >= 20) {
                    tAmount -= 20;
                }
                if (tAmount != 0) {
                    System.out.println("Invalid input. Machine does not contain coins");
                    fail = true;
                }
            }
            // proper reduction logic
            if (!fail) {
                int[] denominations = new int[] {0, 0, 0, 0, 0, 0};

                while(amount > 0){
                    if (amount >= ONETHOUSAND){
                        denominations[0]++;
                        amount -= ONETHOUSAND;
                    } else if (amount >= FIVEHUNDRED) {
                        denominations[1]++;
                        amount -= FIVEHUNDRED;
                    } else if (amount >= TWOHUNDRED) {
                        denominations[2]++;
                        amount -= TWOHUNDRED;
                    } else if (amount >= ONEHUNDRED) {
                        denominations[3]++;
                        amount -= ONEHUNDRED;
                    } else if (amount >= FIFTY && !errCheck) {
                        denominations[4]++;
                        amount -= FIFTY;
                    } else if (amount >= TWENTY) {
                        denominations[5]++;
                        amount -= TWENTY;
                    }
                }
                System.out.println("Dispensed:");
                System.out.println("One Thousand: " + denominations[0]);
                System.out.println("Five Hundred: " + denominations[1]);
                System.out.println("Two Hundred: " + denominations[2]);
                System.out.println("One Hundred: " + denominations[3]);
                System.out.println("Fifty: " + denominations[4]);
                System.out.println("Twenty: " + denominations[5]);
            }
        }
    }
}
