public class Passenger {

    private String name;
    private int wallet;

    public Passenger(String name, int wallet) {
        this.name = name;
        this.wallet = wallet;
    }

    public String name() {
        return this.name;
    }

    public int totalCash() {
        return this.wallet;
    }

    public void pay(int price) {
        this.wallet -= price;
    }

}
