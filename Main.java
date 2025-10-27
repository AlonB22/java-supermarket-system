//avia lurie, 315150516,keren calif
//alon berla, 208544064, keren calif
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args)  {
        Manager manager = new Manager();
        Address address1 = new Address("israel", "tel aviv", "cicar hill", 5);
        Address address2 = new Address("israel", "haifa", "hibner", 42);
        Address address3 = new Address("france", "lover", "ner", 2);
        Address address4 = new Address("poland", "almond", "hour", 4);

        Product product1 = new Product("table", 34, Product.eCategory.valueOf("office"));
        Product product2 = new Product("pen", 64.4, Product.eCategory.valueOf("office"));
        Product product3 = new Product("game", 100.1, Product.eCategory.valueOf("children"));
        Product product4 = new Product("microwave", 13.99, Product.eCategory.valueOf("electricity"));
        Product product5 = new Product("chair", 43.90, Product.eCategory.valueOf("office"));
        Product product6 = new Product("skirt", 13, Product.eCategory.valueOf("clothing"));

        Seller seller1 = new Seller("avia", "a");
        Seller seller2 = new Seller("tomer", "a");
        Seller seller3 = new Seller("nori", "a");

        Buyer buyer4 = new Buyer("maya", "asa", address1);
        Buyer buyer5 = new Buyer("bar", "a", address2);
        Buyer buyer6 = new Buyer("itai", "adsf", address3);
        Buyer buyer7 = new Buyer("ron", "a123", address4);

        manager.addSeller(seller1);
        manager.addSeller(seller2);
        manager.addSeller(seller3);

        manager.addBuyer(buyer4);
        manager.addBuyer(buyer5);
        manager.addBuyer(buyer6);
        manager.addBuyer(buyer7);

        manager.getSellerByName(seller1.getUserName()).addProduct(product1);
        manager.getSellerByName(seller1.getUserName()).addProduct(product2);
        manager.getSellerByName(seller3.getUserName()).addProduct(product3);
        manager.getSellerByName(seller1.getUserName()).addProduct(product4);
        manager.getSellerByName(seller2.getUserName()).addProduct(product5);
        manager.getSellerByName(seller3.getUserName()).addProduct(product6);

        manager.getBuyerByName(buyer4.getUserName()).getAvailableCart().addProduct(product1);
        manager.getBuyerByName(buyer5.getUserName()).getAvailableCart().addProduct(product2);
        manager.getBuyerByName(buyer6.getUserName()).getAvailableCart().addProduct(product3);
        manager.getBuyerByName(buyer5.getUserName()).getAvailableCart().addProduct(product4);
        manager.getBuyerByName(buyer5.getUserName()).buyCart();
        manager.getBuyerByName(buyer5.getUserName()).getAvailableCart().addProduct(product4);
        manager.getBuyerByName(buyer6.getUserName()).getAvailableCart().addProduct(product5);
        manager.getBuyerByName(buyer6.getUserName()).getAvailableCart().addProduct(product5);
        manager.getBuyerByName(buyer4.getUserName()).getAvailableCart().addProduct(product6);

        while (true) {
                System.out.print("""
                        press number for choosing:
                        0-exit
                        1-add seller
                        2-add buyer
                        3-add product for seller
                        4-add product for buyer
                        5-pay for Shopping Cart
                        6-buyers details
                        7-sellers details
                        8-products by category
                        9-copy existing cart
                        """);
                Scanner scanner = new Scanner(System.in);
            try {
                int num = scanner.nextInt();
                if (num == 0) {
                    break;
                } else if (num == 1) {
                    System.out.println("Please enter a name:");
                    String name = scanner.next();
                    System.out.println("Please choose password:");
                    String password = scanner.next();
                    Seller seller = new Seller(name, password);
                    while (true) {
                        if (manager.addSeller(seller)) {
                            System.out.println("The seller been added.");
                            break;
                        }
                        System.out.println("The name already exists. Please choose another name.");
                        name = scanner.next();
                        seller.setUserName(name);
                    }
                } else if (num == 2) {
                    System.out.println("Please enter a name:");
                    String name = scanner.next();
                    String password;
                    System.out.println("Please choose password:");
                    password = scanner.next();
                    System.out.println("Please choose country:");
                    String country = scanner.next();
                    System.out.println("Please choose city:");
                    String city = scanner.next();
                    System.out.println("Please choose street:");
                    String street = scanner.next();
                    System.out.println("Please choose house number:");
                    boolean ok = true;
                    int houseNumber = 0;
                    while (ok) {
                        try {
                            houseNumber = scanner.nextInt();
                            ok = false;
                        } catch (InputMismatchException e) {
                            System.out.println("Please enter an integer only");
                            scanner.next();
                        }
                    }
                    Address address = new Address(country, city, street, houseNumber);
                    Buyer buyer = new Buyer(name, password, address);
                    while (true) {
                        if (manager.addBuyer(buyer)) {
                            System.out.println("The buyer been added.");
                            break;
                        }
                        System.out.println("The name already exists. Please choose another name.");
                        name = scanner.next();
                        buyer.setUserName(name);
                    }
                } else if (num == 3) {
                    if (manager.getNumOfSellers() == 0) {
                        System.out.println("there is no sellers yet");
                        continue;
                    }
                    System.out.println("choose seller name from the list:" + manager.sellersNames());
                    String name = scanner.next();
                    if (manager.getSellerByName(name) == null) {
                        System.out.println("seller name didnt found please try again");
                        continue;
                    }
                    System.out.println("product name:");
                    String productName = scanner.next();
                    System.out.println("product price:");
                    boolean ok = true;
                    double price = 0;
                    while (ok) {
                        try {
                            price = scanner.nextDouble();
                            ok = false;
                        } catch (InputMismatchException e) {
                            System.out.println("Please enter an double only");
                            scanner.next();
                        }
                    }
                    System.out.println("do you want to add special package?(type yes/no)");
                    if (scanner.next().equals("yes")) {
                        System.out.println("how much the special package cost?");
                        ok = true;
                        double cost=0;
                        while (ok) {
                            try {
                                cost = scanner.nextDouble();
                                ok = false;
                            } catch (InputMismatchException e) {
                                System.out.println("Please enter an double only");
                                scanner.next();
                            }
                        }
                        price += cost;
                    }
                    System.out.println("chose product category:");
                    System.out.println(Arrays.toString(Product.eCategory.values()));
                    String category = scanner.next();
                    ok = true;
                    while (ok) {
                        try {
                            Product product = new Product(productName, price, Product.eCategory.valueOf(category));
                            ok = false;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Please choose from the category below only");
                            System.out.println(Arrays.toString(Product.eCategory.values()));
                            category = scanner.next();
                        }
                    }
                    Product product = new Product(productName, price, Product.eCategory.valueOf(category));
                    if (manager.getSellerByName(name).addProduct(product)) {
                        System.out.println(product.getName() + " has been added to " + name + " successfully.");
                    } else {
                        System.out.println("The seller already have this product ");
                    }
                } else if (num == 4) {
                    if (manager.getNumOfSellers() + manager.getNumOfBuyers() < 1) {
                        System.out.println("in order to do that its needed to have at least one seller and buyer");
                        continue;
                    }
                    System.out.println("choose buyer name from the list:" + manager.buyersNames());
                    String buyer = scanner.next();
                    if (manager.getBuyerByName(buyer) == null) {
                        System.out.println("buyer name didnt found please try again");
                        continue;
                    }
                    System.out.println("choose seller name from the list:" + manager.sellersNames());
                    String seller = scanner.next();
                    if (manager.getSellerByName(seller) == null) {
                        System.out.println("seller name didnt found please try again");
                        continue;
                    }
                    if (manager.getSellerByName(seller).getAllProducts()[0] == null) {
                        System.out.println("seller doesn't have products for sale");
                        continue;
                    }
                    System.out.println("choose product name from the list:\n" + manager.getSellerByName(seller));
                    String name = scanner.next();
                    if (manager.getSellerByName(seller).getProductByName(name) == null) {
                        System.out.println("product didnt found please try again");
                        continue;
                    }
                    manager.getBuyerByName(buyer).getAvailableCart().addProduct(manager.getSellerByName(seller).getProductByName(name));
                    System.out.println(name + " as been added to " + buyer + " cart successfully.");

                } else if (num == 5) {
                    if (manager.getNumOfBuyers() == 0) {
                        System.out.println("there is no buyers yet");
                        continue;
                    }
                    System.out.println("choose buyer name from the list:" + manager.buyersNames());
                    String buyer = scanner.next();
                    if (manager.getBuyerByName(buyer) == null) {
                        System.out.println("buyer name didnt found please try again");
                        continue;
                    }
                    if (manager.getBuyerByName(buyer).getAvailableCart().getAllProducts()[0] == null) {
                        System.out.println(buyer + " cart is empty please try again");
                        continue;
                    }
                    System.out.println(buyer + " cart has been pursched successfully:\n" + manager.getBuyerByName(buyer).getAvailableCart());
                    manager.getBuyerByName(buyer).buyCart();


                } else if (num == 6) {
                    if (manager.getNumOfBuyers() == 0) {
                        System.out.println("there is no buyers yet");
                    } else {
                        System.out.println("list of all buyers:\n" + manager.buyerstoString());
                    }
                } else if (num == 7) {
                    if (manager.getNumOfSellers() == 0) {
                        System.out.println("there is no sellers yet");
                    } else {
                        System.out.println("list of all sellers:\n" + manager.sellerstoString());
                    }
                } else if (num == 8) {
                    System.out.println("chose product category:");
                    System.out.println(Arrays.toString(Product.eCategory.values()));
                    String category = scanner.next();
                    System.out.println(manager.productByCategory(category));
                } else if (num == 9) {
                    if (manager.getNumOfBuyers() == 0) {
                        System.out.println("there is no buyers yet");
                        continue;
                    }
                    System.out.println("choose buyer name from the list:" + manager.buyersNames());
                    String buyer = scanner.next();
                    if (manager.getBuyerByName(buyer) == null) {
                        System.out.println("buyer name didnt found please try again");
                        continue;
                    }
                    if (manager.getBuyerByName(buyer).getNumOfCartsBought() == 0) {
                        System.out.println("buyer dont have cart history to choose from");
                        continue;
                    }
                    if (manager.getBuyerByName(buyer).getAvailableCart().getAllProducts()[0] != null) {
                        System.out.println("the buyer have products in his cart are you sure you want to replace them?(yes/no)");
                        if (scanner.next().equals("no")) {
                            continue;
                        }
                    }
                    System.out.println("choose the number of the cart from cart history:\n" + manager.getBuyerByName(buyer).cartHistoryToString());
                    boolean ok = true;
                    while (ok) {
                        try {
                            manager.getBuyerByName(buyer).setAvailableCart(manager.getBuyerByName(buyer).getAllCarts()[scanner.nextInt() - 1].clone());
                            System.out.println("the buyer cart changed successfully");
                            ok = false;
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("please choose the number of the cart from cart history only:\n" + manager.getBuyerByName(buyer).cartHistoryToString());
                        } catch (InputMismatchException e) {
                            System.out.println("please choose an integer and from the cart history only:\n" + manager.getBuyerByName(buyer).cartHistoryToString());
                            scanner.next();
                        }
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter an integer between 0-9 only");
                scanner.next();
            } catch (Exception e) {
                System.out.println("something went wrong please try again");
            }
        }
    }
}



