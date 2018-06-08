import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.junit.Assert.*;

public class atmMachineTest {
    List<Bill> list;
    atmMachine atm;

    void setup(){
        Bill oneThousand = new Bill("One Thousand", 1000);
        Bill fiveHundred = new Bill("Five Hundred", 500);
        Bill twoHundred = new Bill("Two Hundred", 200);
        Bill oneHundred = new Bill("One Hundred", 100);
        Bill fifty = new Bill("Fifty", 50);
        Bill twenty = new Bill("Twenty", 20);

        list = new ArrayList<Bill>();

        list.add(oneThousand);
        list.add(twenty);
        list.add(fiveHundred);
        list.add(oneHundred);
        list.add(twoHundred);
        list.add(fifty);

        atm = new atmMachine(50000, 40000, list);
    }

    @Test
    public void transact10() throws Exception {
        setup();
        Stack<Bill> cash = atm.transact(5810);

        assertNull(cash);
    }

    @Test
    public void transactWith20() throws Exception {
        setup();
        Stack<Bill> cash = atm.transact(5820);

        assertEquals(cash.pop().getAmount(), 20);
        assertEquals(cash.pop().getAmount(), 100);
        assertEquals(cash.pop().getAmount(), 200);
        assertEquals(cash.pop().getAmount(), 500);
        assertEquals(cash.pop().getAmount(), 1000);
        assertEquals(cash.pop().getAmount(), 1000);
        assertEquals(cash.pop().getAmount(), 1000);
        assertEquals(cash.pop().getAmount(), 1000);
        assertEquals(cash.pop().getAmount(), 1000);
        assertTrue(cash.isEmpty());
    }

    @Test
    public void transactWith30() throws Exception {
        setup();
        Stack<Bill> cash = atm.transact(5830);

        assertNull(cash);
    }

    @Test
    public void transactWith40() throws Exception {
        setup();
        Stack<Bill> cash = atm.transact(5840);

        assertEquals(cash.pop().getAmount(), 20);
        assertEquals(cash.pop().getAmount(), 20);
        assertEquals(cash.pop().getAmount(), 100);
        assertEquals(cash.pop().getAmount(), 200);
        assertEquals(cash.pop().getAmount(), 500);
        assertEquals(cash.pop().getAmount(), 1000);
        assertEquals(cash.pop().getAmount(), 1000);
        assertEquals(cash.pop().getAmount(), 1000);
        assertEquals(cash.pop().getAmount(), 1000);
        assertEquals(cash.pop().getAmount(), 1000);
        assertTrue(cash.isEmpty());
    }

    @Test
    public void transactWith50() throws Exception {
        setup();
        Stack<Bill> cash = atm.transact(5850);

        assertEquals(cash.pop().getAmount(), 50);
        assertEquals(cash.pop().getAmount(), 100);
        assertEquals(cash.pop().getAmount(), 200);
        assertEquals(cash.pop().getAmount(), 500);
        assertEquals(cash.pop().getAmount(), 1000);
        assertEquals(cash.pop().getAmount(), 1000);
        assertEquals(cash.pop().getAmount(), 1000);
        assertEquals(cash.pop().getAmount(), 1000);
        assertEquals(cash.pop().getAmount(), 1000);
        assertTrue(cash.isEmpty());
    }

    @Test
    public void transactWith60() throws Exception {
        setup();
        Stack<Bill> cash = atm.transact(5860);

        assertEquals(cash.pop().getAmount(), 20);
        assertEquals(cash.pop().getAmount(), 20);
        assertEquals(cash.pop().getAmount(), 20);
        assertEquals(cash.pop().getAmount(), 100);
        assertEquals(cash.pop().getAmount(), 200);
        assertEquals(cash.pop().getAmount(), 500);
        assertEquals(cash.pop().getAmount(), 1000);
        assertEquals(cash.pop().getAmount(), 1000);
        assertEquals(cash.pop().getAmount(), 1000);
        assertEquals(cash.pop().getAmount(), 1000);
        assertEquals(cash.pop().getAmount(), 1000);
        assertTrue(cash.isEmpty());
    }

    @Test
    public void transactWith70() throws Exception {
        setup();
        Stack<Bill> cash = atm.transact(5870);

        assertEquals(cash.pop().getAmount(), 20);
        assertEquals(cash.pop().getAmount(), 50);
        assertEquals(cash.pop().getAmount(), 100);
        assertEquals(cash.pop().getAmount(), 200);
        assertEquals(cash.pop().getAmount(), 500);
        assertEquals(cash.pop().getAmount(), 1000);
        assertEquals(cash.pop().getAmount(), 1000);
        assertEquals(cash.pop().getAmount(), 1000);
        assertEquals(cash.pop().getAmount(), 1000);
        assertEquals(cash.pop().getAmount(), 1000);
        assertTrue(cash.isEmpty());
    }
    @Test
    public void transactWith80() throws Exception {
        setup();
        Stack<Bill> cash = atm.transact(5880);

        assertEquals(cash.pop().getAmount(), 20);
        assertEquals(cash.pop().getAmount(), 20);
        assertEquals(cash.pop().getAmount(), 20);
        assertEquals(cash.pop().getAmount(), 20);
        assertEquals(cash.pop().getAmount(), 100);
        assertEquals(cash.pop().getAmount(), 200);
        assertEquals(cash.pop().getAmount(), 500);
        assertEquals(cash.pop().getAmount(), 1000);
        assertEquals(cash.pop().getAmount(), 1000);
        assertEquals(cash.pop().getAmount(), 1000);
        assertEquals(cash.pop().getAmount(), 1000);
        assertEquals(cash.pop().getAmount(), 1000);
        assertTrue(cash.isEmpty());
    }
    @Test
    public void transactWith90() throws Exception {
        setup();
        Stack<Bill> cash = atm.transact(5890);

        assertEquals(cash.pop().getAmount(), 20);
        assertEquals(cash.pop().getAmount(), 20);
        assertEquals(cash.pop().getAmount(), 50);
        assertEquals(cash.pop().getAmount(), 100);
        assertEquals(cash.pop().getAmount(), 200);
        assertEquals(cash.pop().getAmount(), 500);
        assertEquals(cash.pop().getAmount(), 1000);
        assertEquals(cash.pop().getAmount(), 1000);
        assertEquals(cash.pop().getAmount(), 1000);
        assertEquals(cash.pop().getAmount(), 1000);
        assertEquals(cash.pop().getAmount(), 1000);
        assertTrue(cash.isEmpty());
    }

}