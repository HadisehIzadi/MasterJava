import java.io.Serializable;

public class Subscriber implements Serializable {
    private String fName;
    private String lName;
    private String city;
    private int phone;

    public Subscriber(String fName, String lName, String city, int phone) {
        this.fName = fName;
        this.lName = lName;
        this.city = city;
        this.phone = phone;
    }


    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", city='" + city + '\'' +
                ", phone=" + phone +
                '}';
    }
}
