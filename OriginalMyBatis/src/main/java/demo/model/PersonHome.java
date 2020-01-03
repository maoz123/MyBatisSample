package demo.model;

public class PersonHome {
    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String address;

    public String getEmailGb() {
        return emailGb;
    }

    public void setEmailGb(String emailGb) {
        this.emailGb = emailGb;
    }

    private String emailGb;

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    private Home home;
}
