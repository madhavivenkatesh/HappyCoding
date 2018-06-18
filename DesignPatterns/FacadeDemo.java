package com.practiceprogramming.designpatterns.structural;
/*
Facade acts as a interface for set of subsystems. Whenever there are multiple interfaces which servers similar kind of
purpose then a facade can be created.
 */

class NONCDB{

    public static String getNONCDBConnection(){
        System.out.println("Connected to NONCDB");
        return "NONCDB";
    }
    public static void generateXML(){
        System.out.println("Generate XML Report for NONCDB");
    }
    public static void generateHTML(){
        System.out.println("Generate HTML report for NONCDB");
    }
}

class CDB{

    public static String getCDBConnection(){
        System.out.println("Connected to CDB");
        return "CDB";
    }
    public static void generateXML(){
        System.out.println("Generate XML Report for CDB");
    }
    public static void generateHTML(){
        System.out.println("Generate HTML report for CDB");
    }
}

class DBConnections{

    public void generateReport(String dbType , String reportType){

        String dbconn = null;
        switch(dbType){
            case "NONCDB":dbconn = NONCDB.getNONCDBConnection();
                          switch(reportType){
                              case "XML":NONCDB.generateXML();
                                         break;
                              case "HTML" : NONCDB.generateHTML();
                                            break;
                          }
                          break;
            case "CDB":dbconn = CDB.getCDBConnection();
                switch(reportType){
                    case "XML":CDB.generateXML();
                        break;
                    case "HTML" : CDB.generateHTML();
                        break;
                }
                break;

        }
    }
}
public class FacadeDemo {
    public static void main(String[] args){
        DBConnections dbconn = new DBConnections();
        dbconn.generateReport("CDB","HTML");
    }
}
