public class Buyer extends User implements Comparable<Buyer>{
    private Address address;
    private Cart [] allCarts;
    private Cart availableCart;
    private int numOfCartsBought;

    public Buyer(String userName,String password, Address address) {
        super(userName,password);
        setAddress(address);
    }
    public Buyer(Buyer other){
        super(other.userName,other.password);
        address=other.address;
        availableCart = new Cart();
        allCarts = new Cart[1];
        numOfCartsBought = 0;
    }

    public void setAddress(Address address) {
        this.address = new Address(address);
    }
    public void setAvailableCart(Cart availableCart) {
        this.availableCart = availableCart;
    }

    public Address getAddress() {return address;}
    public Cart[] getAllCarts() {return allCarts;}
    public int getNumOfCartsBought() {return numOfCartsBought;}
    public Cart getAvailableCart() {return availableCart;}

    public void buyCart() {
        if (allCarts.length==numOfCartsBought) {
            allCarts = doubleAllCartsArraySize(allCarts);
        }
        availableCart.setDate();
        allCarts[numOfCartsBought] = availableCart;
        numOfCartsBought++;
        availableCart = new Cart();
    }

    private static Cart[] doubleAllCartsArraySize(Cart[] array) {
        Cart[] newArray = new Cart[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        return newArray;
    }

    @Override
    public int compareTo(Buyer buyer) {
        return userName.compareTo(buyer.userName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(userName + ":\n");
        sb.append(address.toString());
        if ( availableCart.getAllProducts()[0]!=null) {
            sb.append("\n  current cart: \n").append(availableCart);
        }else {sb.append("\n  current cart is empty");}
        if (allCarts[0]!=null){
            sb.append("\n  carts history:");
            for (int i = 0; i < numOfCartsBought; i++) {
                sb.append("\n  ").append(i + 1).append(")\n").append(allCarts[i]).append("\n  bought at:").append(allCarts[i].getDate());
            }
        }
        else sb.append("\n  there isn't carts history");
        return sb.toString();
    }
    public String cartHistoryToString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numOfCartsBought; i++) {
            sb.append(i + 1).append(")\n").append(allCarts[i]).append("\n");
        }
        return sb.toString();
    }
}