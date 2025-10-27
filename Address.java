public class Address {
    private String country;
    private String city;
    private String street;
    private int houseNum;

    public Address(String country, String city, String street, int houseNum) {
        setCountry(country);
        setCity(city);
        setStreet(street);
        setHouseNum(houseNum);
    }
    public Address(Address other){
        country = other.country;
        city = other.city;
        street = other.street;
        houseNum = other.houseNum;
    }

    public void setCountry(String country){this.country = country;}
    public void setCity(String city) { this.city = city;}
    public void setStreet(String street){this.street = street;}
    public void setHouseNum(int houseNum){this.houseNum=houseNum;}

    public String getCountry() {return country;}
    public String getCity() {return city;}
    public String getStreet() {return street;}
    public int getHouseNum() {return houseNum;}

    @Override
    public String toString() {
        return "  Address:" + " " + country + ", " + city + ", " + street + ", " + houseNum;
    }
}
