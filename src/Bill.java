public class Bill {
    private int amount;
    private String name;
    private boolean isTwoDigit;

    public Bill (String name, int amount){
        this.name = name;
        this.amount = amount;

        isTwoDigit = amount < 100;
    }

    public int getAmount(){
        return amount;
    }
    public String getName(){
        return name;
    }
}
