package demo.model;

import org.apache.ibatis.type.Alias;

@Alias("per")
public class Person {

    public Person()
    {

    }

    public Person(int id, String name ,String address, String emailGb)
    {
        this.id = id;
        this.name = name;
        this.address = address;
        this.emailGb = emailGb;
    }
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

    public int getHomeId() {
        return homeId;
    }

    public void setHomeId(int homeId) {
        this.homeId = homeId;
    }

    private int homeId;


}
