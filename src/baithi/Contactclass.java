package baithi;

public class Contactclass {
    private String name;
    private String company;
    private String email;
    private String phoneNumber;

    public Contactclass(String name, String company, String email, String phoneNumber) {
        this. name= name;
        this.company = company;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString() {
        return "Name: " + name + ", Company: " + company + ", Email: " + email + ", Phone: " + phoneNumber;
    }

    public String getName() {
        return null;
    }

    public String getPhone() {
        return null;
    }
}
