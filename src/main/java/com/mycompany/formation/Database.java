/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.formation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mar
 */
public class Database {
    
    
    public void getData() throws SQLException, ClassNotFoundException  {
    Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/formation","root","");
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("SELECT * FROM `compte` ");
        while(rs.next()){
            if(rs.getString("typeCompte").equals("CompteSimple")){
                
            
        System.out.println(  rs.getString("typeCompte")+ " code " +rs.getInt("code")+"   solde  "+rs.getDouble("solde")+ " decouvert "+" "+rs.getDouble("decouvert") );
            }
            else if (rs.getString("typeCompte").equals("CompteEpargne")) {
        System.out.println(  rs.getString("typeCompte")+ " code " +rs.getInt("code")+"   solde  "+rs.getDouble("solde")+ " taux "+" "+rs.getDouble("taux") );
            }
        else if (rs.getString("typeCompte").equals("ComptePayant")) {
        System.out.println(  rs.getString("typeCompte")+ " code " +rs.getInt("code")+"   solde  "+rs.getDouble("solde") );
        }
            }
      
	con.close();

}

public void miseaJour(String requet) throws ClassNotFoundException, SQLException{
     Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/formation","root","");
        Statement st=con.createStatement();
        st.executeUpdate(requet);
     
	con.close();

    
}
public int deletData(int code) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/formation","root","");
        Statement st=con.createStatement();
        int rs=st.executeUpdate("delete  FROM `compte` where code ="+code);
     con.close();
     return rs;
    
}
public Compte FindCompte(int code ) throws ClassNotFoundException, SQLException{
    System.out.println("start FindCompte");
    Compte c;
    Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/formation","root","");
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("SELECT * FROM `compte` WHERE code= "+code);
        if(rs.next()){
            if(rs.getString("typeCompte").equals("CompteSimple")){
                c=new CompteSimple(rs.getDouble("solde"),rs.getDouble("decouvert"));
                
            }
            else if (rs.getString("typeCompte").equals("CompteEpargne")){
                c =new CompteEpargne(rs.getDouble("solde"),rs.getDouble("taux"));
            }
            else{
                c =new ComptePayant(rs.getDouble("solde"));
            }
            return c;
        }
       return null;   
}

public void fillterComptes(String requet) throws ClassNotFoundException, SQLException{
     Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/formation","root","");
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(requet);
        
        while(rs.next()){
            System.out.println( rs.getString("typeCompte"));}
                
              	con.close();
  
}
}