package com.example.lab5.entity;
import java.util.Objects;

public class PublishingHouse {

    private int publishingHouseId;
    private String name;
    private String location;
    private String country;

    public PublishingHouse() {
    }
    public PublishingHouse(int publishingHouseId, String name, String location, String country) {
        this.publishingHouseId = publishingHouseId;
        this.name = name;
        this.location = location;
        this.country = country;
    }

    public int getPublishingHouseId() {
        return publishingHouseId;
    }

    public void setPublishingHouseId(int publishingHouseId) {
        this.publishingHouseId = publishingHouseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublishingHouse that = (PublishingHouse) o;
        return publishingHouseId == that.publishingHouseId && Objects.equals(name, that.name) && Objects.equals(location, that.location) && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publishingHouseId, name, location, country);
    }

    @Override
    public String toString() {
        return "PublishingHouse{" +
                "publishingHouseId=" + publishingHouseId +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
