import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cart implements Cloneable{
    private Product[] cart;
    private String date;
    private int numOfProducts;
    private double totalCost;


    public Cart() {
        cart = new Product[1];
        numOfProducts = 0;
        totalCost = 0;
    }

    public void setDate() {
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        date = ldt.format(dtf);
    }

    public Product[] getAllProducts() {return cart;}
    public int getNumOfProducts() {return numOfProducts;}
    public String getDate() {return date;}

    public void addProduct(Product product) {
        if (cart.length == numOfProducts) {
            cart = doubleCartArraySize(cart);
        }
        cart[numOfProducts] = new Product(product);
        totalCost += product.getPrice();
        numOfProducts++;
        }

    private static Product[] doubleCartArraySize(Product[] array) {
        Product[] newArray = new Product[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        return newArray;
    }

    @Override
    public Cart clone() throws CloneNotSupportedException {
        return (Cart)super.clone();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("  total items = ");
        for (int i = 0; i < numOfProducts; i++) {
            sb.append(cart[i]).append(", ");
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("\n  total price = ").append(totalCost).append("$");
        return sb.toString();
    }
}
