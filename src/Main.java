import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Bill oneThousand = new Bill("One Thousand", 1000);
        Bill fiveHundred = new Bill("Five Hundred", 500);
        Bill twoHundred = new Bill("Two Hundred", 200);
        Bill oneHundred = new Bill("One Hundred", 100);
        Bill fifty = new Bill("Fifty", 50);
        Bill twenty = new Bill("Twenty", 20);

        List<Bill> list = new ArrayList<Bill>();

        list.add(oneThousand);
        list.add(fiveHundred);
        list.add(twoHundred);
        list.add(oneHundred);
        list.add(fifty);
        list.add(twenty);

        atmMachine atm = new atmMachine(5000, 4000, list);
        atm.transact(860);
    }
}
