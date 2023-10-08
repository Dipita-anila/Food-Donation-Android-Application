package com.example.zerowaste;

public class Registration_Data_handling {

    private String registrdName;
    private String registrdEmail;
    private String registrdNumber;
    private String registrdPasswrd;

    public Registration_Data_handling(String registrdName, String registrdEmail, String registrdNumber, String registrdPasswrd) {
        this.registrdName = registrdName;
        this.registrdEmail = registrdEmail;
        this.registrdNumber = registrdNumber;
        this.registrdPasswrd = registrdPasswrd;
    }

    public String getRegistrdName() {
        return registrdName;
    }

    public void setRegistrdName(String registrdName) {
        this.registrdName = registrdName;
    }

    public String getRegistrdEmail() {
        return registrdEmail;
    }

    public void setRegistrdEmail(String registrdEmail) {
        this.registrdEmail = registrdEmail;
    }

    public String getRegistrdNumber() {
        return registrdNumber;
    }

    public void setRegistrdNumber(String registrdNumber) {
        this.registrdNumber = registrdNumber;
    }

    public String getRegistrdPasswrd() {
        return registrdPasswrd;
    }

    public void setRegistrdPasswrd(String registrdPasswrd) {
        this.registrdPasswrd = registrdPasswrd;
    }
}
