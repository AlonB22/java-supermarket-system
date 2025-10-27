public class Seller extends User implements Comparable<Seller>{
    private Product[] allProducts;
    private int numOfProducts;

    public Seller(String userName,String password) {
        super(userName,password);
    }
    public Seller(Seller other){
        super(other.userName,other.password);
        allProducts = new Product[1];
        numOfProducts = 0;
    }

    public int getNumOfProducts() {return numOfProducts;}
    public Product[] getAllProducts() {return allProducts;}

    public boolean addProduct(Product product) {
        if (allProducts.length == numOfProducts) {
            allProducts = doubleProductsArraySize(allProducts);
        }
        for (int i = 0; i < numOfProducts; i++) {
            if (allProducts[i].getName().equals(product.getName())) {
                return false;
            }
        }
        allProducts[numOfProducts] = new Product(product);
        numOfProducts++;
        return true;
    }

    private static Product[] doubleProductsArraySize(Product[] array) {
        Product[] newArray = new Product[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        return newArray;
    }

    public Product getProductByName(String name) {
        for (int i =0; i < numOfProducts; i++) {
            if (allProducts[i].getName().equals(name)) {
                return allProducts[i];
            }
        }
        return null;
    }

    @Override
    public int compareTo(Seller seller) {
        if (seller.numOfProducts > numOfProducts){return 1;}
        else if (seller.numOfProducts < numOfProducts){return -1;}
        else return 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(userName + ":");
        if (allProducts[0] == null){
            return userName + " has no products for sale";
        }
        for (int i = 0; i < numOfProducts; i++) {
            sb.append("\n\t").append(i + 1).append(")").append(allProducts[i]);
        }
        return sb.toString();
    }
}