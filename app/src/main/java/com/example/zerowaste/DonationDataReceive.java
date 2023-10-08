package com.example.zerowaste;

public class DonationDataReceive {

    String uname,umail,ufoodtype,ulocation,utime,uquantity;




    public DonationDataReceive()
    {



    }

    public DonationDataReceive(String uname, String umail, String ufoodtype, String ulocation, String utime, String uquantity) {
        this.uname = uname;
        this.umail = umail;
        this.ufoodtype = ufoodtype;
        this.ulocation = ulocation;
        this.utime = utime;
        this.uquantity = uquantity;
    }


    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUmail() {
        return umail;
    }

    public void setUmail(String umail) {
        this.umail = umail;
    }

    public String getUfoodtype() {
        return ufoodtype;
    }

    public void setUfoodtype(String ufoodtype) {
        this.ufoodtype = ufoodtype;
    }

    public String getUlocation() {
        return ulocation;
    }

    public void setUlocation(String ulocation) {
        this.ulocation = ulocation;
    }

    public String getUtime() {
        return utime;
    }

    public void setUtime(String utime) {
        this.utime = utime;
    }

    public String getUquantity() {
        return uquantity;
    }

    public void setUquantity(String uquantity) {
        this.uquantity = uquantity;
    }
}
