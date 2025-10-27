public class Product {
    public enum eCategory {children, electricity, office ,clothing}
    private eCategory category;
    private static int counter;
    private String name;
    private double price;
    public final int id;

    public Product(String name, double price ,eCategory category){
        setName(name);
        setPrice(price);
        id = ++counter;
        setCategory(category);
    }
    public Product(Product other){
        this.name = other.name;
        this.price = other.price;
        this.id = other.id;
        this.category=other.category;
    }

    public void setCategory(eCategory category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name =name;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {return name;}
    public double getPrice() {return price;}
    public static int getSumOfProducts() {return counter;}
    public eCategory getCategory() {return category;}

    @Override
    public String toString() {
        return name + "-" + price + "$" +"("+id+")";
    }
}
