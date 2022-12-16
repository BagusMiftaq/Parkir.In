package com.parkirin.model.request.owner;

import javax.persistence.Column;

public class OwnerRequest {
    private String ownerName;

    private String phone;

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
