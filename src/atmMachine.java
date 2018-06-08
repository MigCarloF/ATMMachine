import java.util.*;

public class atmMachine {

    private int balance;
    private int moneyInMachine;
    private List<Bill> billTypes;

    public atmMachine(int moneyInMachine, int balance, List<Bill> bills){
        this.moneyInMachine = moneyInMachine;
        this.balance = balance;
        this.billTypes = bills;
        Collections.sort(bills, (o1, o2) -> Integer.compare(o2.getAmount(), o1.getAmount())); //sorts the bills according to size
    }

    public Stack<Bill> transact(int amount){
        if (amount > balance) {
            System.out.println("Your account does not have enough balance");
            return null;
        } else if (amount > moneyInMachine) {
            System.out.println("Cannot dispense amount. Machine lacking money");
            return null;
        } else {
            // Checks to see if machine cannot fully dispense
            List<Integer> ignore = new ArrayList<>();
            List<Bill> twoDigitBills = new ArrayList<>();
            for(Bill b : billTypes){
                if(b.getAmount() < 100){
                    twoDigitBills.add(b);
                }
            }
            boolean proceed = true;
            int tAmount = amount % 100;
            if(tAmount == 30 || tAmount == 10){
                proceed = false;
            } else if (((tAmount - (tAmount % 10)) / 10) % 2 == 0) {
                ignore.add(50);
            }
            // proper reduction logic
            if (proceed) {
                //for printing
                Stack<Bill> billTypeStack = new Stack<>();
                Stack<Integer> denominations = new Stack<>();
                int denomination;

                //for the return statement
                Stack<Bill> toDispense = new Stack<>();

                for(Bill b : billTypes){
                    if(amount > 0 && (b.getAmount() != 50 || !ignore.contains(50))){
                        denomination = denominationCounter(b, amount, toDispense);

                        if (denomination > 0) {
                            billTypeStack.push(b);
                            denominations.push(denomination);
                            amount -= (denomination * b.getAmount());
                        }
                    }
                }

                System.out.println("Dispensed:");
                while (!denominations.empty()) {
                    System.out.print(billTypeStack.pop().getName() + ": ");
                    System.out.println(denominations.pop() + "pc(s)");
                }
                System.out.println();
                return toDispense;
            }
        }
        return null;
    }

    private int denominationCounter(Bill b, Integer amount, Stack<Bill> toDispense){
        int denomination = 0;
        while(amount >= b.getAmount()){
            toDispense.push(b);
            amount -= b.getAmount();
            denomination++;
        }
        return denomination;
    }
}