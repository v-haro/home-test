package dataDefinition;

public class MyCheckOutData {
    public String fullname;
    public String name_on_card;
    public String email;
    public String credit_card_number;
    public String address;
    public String exp_month;
    public String city;
    public String exp_year;
    public String cvv;
    public String state;
    public String zip;

    @Override
    public String toString() {
        return "MyCheckOutData{" +
                "fullname='" + fullname + '\'' +
                ", name_on_card='" + name_on_card + '\'' +
                ", email='" + email + '\'' +
                ", credit_card_number='" + credit_card_number + '\'' +
                ", address='" + address + '\'' +
                ", exp_month='" + exp_month + '\'' +
                ", city='" + city + '\'' +
                ", exp_year=" + exp_year +
                ", cvv='" + cvv + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
