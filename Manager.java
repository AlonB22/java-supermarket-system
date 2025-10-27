import java.util.Arrays;

public class Manager {
    private Seller [] allSellers;
    private Buyer [] allBuyers;
    private int numOfSellers;
    private int numOfBuyers;

    public Manager(){
        allSellers = new Seller[1];
        allBuyers = new Buyer[1];
        numOfSellers = 0;
        numOfBuyers = 0;
    }

    public Buyer[] getAllBuyers() {return allBuyers;}
    public int getNumOfBuyers() {return numOfBuyers;}
    public Seller[] getAllSellers() {return allSellers;}
    public int getNumOfSellers() {return numOfSellers;}

    public boolean addSeller(Seller seller) {
        if (allSellers.length == numOfSellers) {
            allSellers = doubleSellersArraySize(allSellers);
        }
        for (int i = 0; i < numOfSellers; i++) {
            if (allSellers[i].getUserName().equals(seller.getUserName())) {
                return false;
            }
        }
        allSellers[numOfSellers] = new Seller(seller);
        numOfSellers++;
        return true;
    }
    public boolean addBuyer(Buyer buyer){
        if (allBuyers.length == numOfBuyers){
            allBuyers = doubleBuyersArraySize(allBuyers);
        }
        for (int i = 0; i < numOfBuyers; i++) {
            if (allBuyers[i].getUserName().equals(buyer.getUserName())) {
                return false;
            }
        }
        allBuyers[numOfBuyers] = new Buyer(buyer);
        numOfBuyers++;
        return true;
    }
    public Seller getSellerByName(String name){
        for (int i = 0 ; i < numOfSellers; i++) {
            if (allSellers[i].getUserName().equals(name)) {
                return allSellers[i];
            }
        }
        return null;
    }
    public Buyer getBuyerByName(String name){
        for (int i = 0 ; i < numOfBuyers; i++) {
            if (allBuyers[i].getUserName().equals(name)) {
                return allBuyers[i];
            }
        }
        return null;
    }

    private static Buyer [] doubleBuyersArraySize(Buyer [] array) {
        Buyer[] newArray = new Buyer[ array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        return newArray;
    }
    private static Seller [] doubleSellersArraySize(Seller [] array) {
        Seller[] newArray = new Seller[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        return newArray;
    }

    public String sellerstoString() {
        StringBuilder buffer = new StringBuilder();
        Seller[] newArray = new Seller[numOfSellers];
        System.arraycopy(allSellers, 0, newArray, 0,numOfSellers);
        Arrays.sort(newArray);
        for (int i = 0; i < numOfSellers; i++) {
            buffer.append(i + 1).append("-").append(newArray[i]).append("\n");
        }
        return buffer.toString();
    }
    public  String buyerstoString() {
        StringBuilder sb = new StringBuilder();
        Buyer[] newArray = new Buyer[numOfBuyers];
        System.arraycopy(allBuyers, 0, newArray, 0,numOfBuyers);
        Arrays.sort(newArray);
        for (int i = 0; i < numOfBuyers; i++) {
            sb.append((i + 1)).append("-").append(newArray[i]).append("\n");
        }
        return sb.toString();
    }
    public String sellersNames() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numOfSellers; i++) {
            sb.append("\n").append(i + 1).append(")").append(allSellers[i].getUserName());
        }
        return sb.toString();
    }
    public String buyersNames() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numOfBuyers; i++) {
            sb.append("\n").append(i + 1).append(")").append(allBuyers[i].getUserName());
        }
        return sb.toString();
    }
    public String productByCategory(String category){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numOfSellers; i++) {
            for (int j = 0; j < allSellers[i].getNumOfProducts(); j++) {
                if (allSellers[i].getAllProducts()[j].getCategory().name().equals(category)){
                    sb.append(allSellers[i].getAllProducts()[j]).append("\n");
                }

            }
        }
        if (sb.toString().isEmpty()) { return "there isn't products from "+category+" at all";}
        return sb.toString();
    }
}
