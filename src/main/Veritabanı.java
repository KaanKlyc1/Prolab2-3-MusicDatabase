package main;

import java.sql.*;


public class Veritabanı {
   
    static String username="root";
    static String password="BloodyHell58";
    static String url="jdbc:mysql://localhost:3306/proje3?zeroDateTimeBehavior=CONVERT_TO_NULL";
    static Connection con = null;
    static Statement stmt = null;
    static PreparedStatement pstmt = null;
    static ResultSet rs = null;
    
    static void bağlantıYap(){
    try{
         con = DriverManager.getConnection(url, username, password);
         if(con!=null){
         System.out.println("Veritabanına bağlanıldı.");
         }
         else
         System.out.println("Veritabanına bağlanılmadı.");
        }catch(Exception e){
           e.printStackTrace();
        }
    
    }
}
