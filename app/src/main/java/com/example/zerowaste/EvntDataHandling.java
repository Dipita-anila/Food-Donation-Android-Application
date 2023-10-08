package com.example.zerowaste;

public class EvntDataHandling {
        String Ename,Eplace,Edate,Efor;

        public EvntDataHandling(){

        }


    public EvntDataHandling(String ename,String eplace,String edate,String efor) {
        Ename = ename;
        Eplace= eplace;
        Edate = edate;
        Efor = efor;
    }

    public String getEname() {
        return Ename;
    }

    public void setEname(String ename) {
        Ename = ename;
    }

    public String getEplace() {
        return Eplace;
    }

    public void setEplace(String eplace) {
        Eplace = eplace;
    }

    public String getEdate() {
        return Edate;
    }

    public void setEdate(String edate) {
        Edate = edate;
    }

    public String getEfor() {
        return Efor;
    }

    public void setEfor(String efor) {
        Efor = efor;
    }
}
