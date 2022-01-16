/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.formation;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList; 
import java.util.Scanner; 
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import  java.lang.Class;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mar
 */
public class App {
   static ArrayList <Compte> lesComptes = new ArrayList <Compte>();

    public static void main (String[] a) throws FileNotFoundException, IOException, ClassNotFoundException, Exception{
        
File f = new File("/home/mar/comptes.txt");
/*
       FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ob = new ObjectInputStream(fis);
         while (fis.available() > 0) {
            Compte lesComptes = (Compte) ob.readObject();
            System.out.println(lesComptes.afficher());
        }
        ob.close();*/
FirstMuneu();
 
afficher();
       

       


       

    }
    public static void afficher(){
             for(int i=0;i<lesComptes.size();i++)  System.out.println(i+"-"+lesComptes.get(i).afficher());


       }
    
public static  void SaiserCompteSimple() throws ClassNotFoundException, SQLException{
     Database db=new Database();

Scanner input = new Scanner(System.in);
 System.out.println(" Solde ");
 double solde = input.nextDouble();
  System.out.println(" decouvert ");
   double decouvert = input.nextDouble();
  // lesComptes.add(new CompteSimple(solde,decouvert));
  String requet ="INSERT INTO compte (solde,decouvert,typeCompte)VALUES (" +solde +","+decouvert+",'CompteSimple')" ;
  db.miseaJour(requet);

    
}
public static void SaiserCompteEpargne() throws ClassNotFoundException, SQLException{
         Database db=new Database();

Scanner input = new Scanner(System.in);

 System.out.println(" Solde ");
 double solde = input.nextDouble();
  System.out.println(" taux ");
   double taux = input.nextDouble();
  // lesComptes.add(new CompteEpargne(solde,taux));
    String requet ="INSERT INTO compte (solde,taux,typeCompte)VALUES (" +solde +","+taux+",'CompteEpargne')" ;
  db.miseaJour(requet);

    
}
public static void SaiserComptePayant() throws ClassNotFoundException, SQLException{
             Database db=new Database();

        Scanner input = new Scanner(System.in);

    System.out.println(" Solde ");
    double solde = input.nextDouble();
 
  // lesComptes.add(new ComptePayant(solde));
      String requet ="INSERT INTO compte (solde,typeCompte)VALUES (" +solde +",'ComptePayant')" ;
  db.miseaJour(requet);


    
}


public static void FirstMuneu() throws Exception{
    
  
while(true){
    System.out.println("----------------------------------------");
System.out.println("******** Main Menu ******** ");
System.out.println("----------------------------------------");

     System.out.println(" 1-Ajouter Compte  \n 2-Modifier Compte  \n 3-Supprimer Compte \n"
             + " 4-Afficher tous les comptes \n 5-Afficher tous les types de copmtes \n "
             + "6- verser dans un Compte \n 7- retirer un Compte \n 8- virement dans un Compt \n 9- InsertFichier \n 10- lire le fichier 11-Quit ");

     Scanner input = new Scanner(System.in);
   int choix = input.nextInt();

if (choix==12)
    break;


switch (choix) {
    case 1:
        AjouterCompte();
        break;
    case 2:
modfierCompte();       
        break;
    case 3:
        supprimerCompte();
        break;
    case 4:
        afficher1();
        break;
    case 5:
        afficherTypesCopmtes();
        break;
    case 6:
         verserCompte();
        break;
    case 7:
        retirerCompte();
        break;
    case 8:
        virementCompte();
        break;
         case 9:
        InsertFichier();
        break;
    case 10:
       remplirList();
        break;
                
   }} }
public static void AjouterCompte() throws Exception{
  
    System.out.println("Choisissez le type de compte ");

System.out.println("----------------------------------------");
System.out.println(" 1-Compte Simple \n 2-Compte Epargne \n 3-Compte Payant \n 4-Back to maon menu ");
Scanner input = new Scanner(System.in);
int x = input.nextInt();

switch (x) {
   
    case 1:
      SaiserCompteSimple();
        break;
    case 2:
      SaiserCompteEpargne();
        break;
    case 3:
      SaiserComptePayant();
        break;
        case 4:
     FirstMuneu();
     
        break;
   }
    }
public static void modfierCompte() throws ClassNotFoundException, SQLException{
 Database db = new Database();
 String requet;
Compte c;
    System.out.println("enter the code ");  
    Scanner input=new Scanner(System.in);
    int code =input.nextInt();
     c = db.FindCompte(code);
    if(c instanceof CompteSimple){// sous-Casting
        
           System.out.println(" Solde ");
            double solde = input.nextDouble();
            System.out.println(" decouvert ");
            double decouvert = input.nextDouble();
            requet ="UPDATE compte SET solde="+solde+",decouvert="+decouvert+" WHERE code="+code;
            db.miseaJour(requet);
          }
     else if(c instanceof CompteEpargne){// sous-Casting
        System.out.println(" Solde ");
        double solde = input.nextDouble();
        System.out.println(" taux ");
        double taux = input.nextDouble();
            requet ="UPDATE compte SET solde="+solde+",taux="+taux+" WHERE code="+code;
            db.miseaJour(requet);
          }
      else if(c instanceof ComptePayant){// sous-Casting
        System.out.println(" Solde ");
        double solde = input.nextDouble();
        requet ="UPDATE compte SET solde="+solde+"  WHERE code="+code;
            db.miseaJour(requet);    
          }
     else{ System.out.println("ce comte n'exist pas");
     }
          }
public static void supprimerCompte() throws ClassNotFoundException, SQLException{
Database db= new Database();
    System.out.println("Choisir le Code de Compte à supprimer");
    
    Scanner input=new Scanner(System.in);
    
    int choice =input.nextInt();
        if(db.deletData(choice)!=0){
                System.out.println("Compte supprimer  ");

        }else
                           System.out.println("Compte n'exist   ");
 


    
       }


public static void afficherTypesCopmtes() throws Exception{
       Database db = new Database();
    System.out.println("Choisir Compte:\n 1-CompteSimple \n 2-CompteEpargne \n 3-ComptePayant"); 
    Scanner input=new Scanner(System.in);
    int code =input.nextInt();
    
    switch (code) {
    case 1:
    db.fillterComptes("SELECT * FROM compte WHERE typeCompte ='CompteSimple'");
        break;

      case 2:
           db.fillterComptes("SELECT * FROM compte WHERE typeCompte ='CompteEpargne'");

        break;
    case 3:
             db.fillterComptes("SELECT * FROM compte WHERE typeCompte ='ComptePayant'");

           break;
      }

   

}
 

public static void virementCompte(){
    afficher();
    Compte yourAccount;
    Compte otherAccount;
    Scanner input=new Scanner(System.in);
    System.out.println("Shoisissez votre compte");
    int yourAccountcode =input.nextInt();
    
    for( Compte c:lesComptes){
        if(c.getCode()==yourAccountcode){
           
        
    System.out.println("Shoisissez le compte sur lequel vous souhaitez envoyer l'argent");
    int otherAccountcode =input.nextInt();
    for( Compte c2:lesComptes){
        if(c2.getCode()==otherAccountcode){
    System.out.println(" Saisir le montant");
    int solde =input.nextInt();
    
    c.virement(c2, solde);
    return;
}
    }}
        }
        System.out.println("l'un ou les deux compte n'exist pas");

    
}

public static void verserCompte(){
    afficher();
    Scanner input=new Scanner(System.in);
    System.out.println("Shoisissez votre compte");
    int yourAccount =input.nextInt();
    for( Compte c2:lesComptes){
        if(c2.getCode()==yourAccount){
        System.out.println(" Saisir le montant");
        int solde =input.nextInt();
    
        c2.verser(solde);
        return;}
        System.out.println("compte n'exist pas1");

}}
public static void retirerCompte(){
    afficher();
    Scanner input=new Scanner(System.in);
    System.out.println("Shoisissez votre compte");
    int yourAccount =input.nextInt();
    for( Compte c2:lesComptes){
        if(c2.getCode()==yourAccount){
    System.out.println(" Saisir le montant");
    int solde =input.nextInt();
    
    c2.retirer(solde);
        return;}
        System.out.println("compte n'exist pas1");
}
}


public static void InsertFichier(){ 
    File f = new File("/home/mar/comptes.doc");
    try {
        FileOutputStream fos = new FileOutputStream(f);
                ObjectOutputStream ob = new ObjectOutputStream(fos);
               for(Compte c:lesComptes){
                  ob.writeObject(c);
               }
                                 ob.close(); 
    }catch ( FileNotFoundException e){
        e.printStackTrace();
    }catch(IOException ex){
        ex.printStackTrace();
    }
}
 public  static void remplirList() throws Exception {
        File f = new File("/home/mar/comptes.doc");
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ob = new ObjectInputStream(fis);
        while (fis.available() > 0) {
            Compte c1 = (Compte) ob.readObject();
            lesComptes.add(c1);
        }
        ob.close();
    }




/*public void lireFichier(){
    File f = new File("~/Desktop/comptes.doc");
    try{
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ob = new ObjectInputStream(fis);
        while (fis.available() > 0) {
            Compte c1 =  (Compte) ob.readObject();
        
            System.out.println(c1.afficher());
        }
        ob.close();
    }catch ( FileNotFoundException e){
        e.printStackTrace();
    }catch(IOException ex){
        ex.printStackTrace();
    }
        
    }
}
*/

    private static void afficher1() throws SQLException, ClassNotFoundException {
        Database data = new Database();
        data.getData();
    }
}






