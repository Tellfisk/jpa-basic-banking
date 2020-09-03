package no.hvl.dat250.jpa.basicexample;

import javax.persistence.Embeddable;

@Embeddable
public class Pincode {
    private String pincode;
    private int count;

    public Pincode() {

    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

