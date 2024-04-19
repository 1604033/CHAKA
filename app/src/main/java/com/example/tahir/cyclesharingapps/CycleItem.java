package com.example.sibbir.cyclesharingapps;

public class CycleItem  {
    String id;
    String phoneNumber;
    String location;

    public CycleItem(String id, String phoneNumber, String location) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
