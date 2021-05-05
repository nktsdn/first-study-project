package Task8;

import java.util.List;

public class Company {
    private String name;
    private String address;
    private String phone;
    private String inn;
    private String ogrnip;
    private String foundation_date;
    private List<Securities> securities;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getInn() {
        return inn;
    }

    public String getOgrnip() {
        return ogrnip;
    }

    public String getFoundationDate() {
        return foundation_date;
    }

    public List<Securities> getSecurities() {
        return securities;
    }
}
