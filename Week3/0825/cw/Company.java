public class Company {
    private String name;
    private double stockPrice;

    public Company(String name, double stockPrice) {
        this.name = name;
        this.stockPrice = stockPrice;
    }

    public String getName() {
        return name;
    }

    public double getStockPrice() {
        return stockPrice;
    }

    public void updateStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
    }

    @Override
    public String toString() {
        return String.format("%s $%.2f", name, stockPrice);
    }
}
