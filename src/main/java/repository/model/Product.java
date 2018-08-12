package repository.model;

public class Product {

    private Integer id;
    private String name;
    private String value;
    private String duration;
    private String platform;
    private String country;
    private Brand brand;

    public Product(Integer id, String name, String value, String duration, String platform, String country, Brand brand) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.duration = duration;
        this.platform = platform;
        this.country = country;
        this.brand = brand;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
