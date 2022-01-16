/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.formation;

/**
 *
 * @author mar
 */
import java.io.Serializable;

public abstract class Compte implements Serializable {
    protected int code;
    protected double solde;
    private  static int nbrCompte=0;

    Compte(){
    }
      Compte(double s){
    code=nbrCompte+1;
    nbrCompte++;
    solde=s;
    }
   
    public void verser(double mt){
    solde+=mt; // solde= solde +mt;
    }
    public void retirer(double mt){
         solde-=mt;
        
    }

    public int getCode() {
        return code;
    }

    public double getSolde() {
        return solde;
    }

    public static int getNbrCompte() {
        return nbrCompte;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }


public void virement( Compte c1,double montont){
    c1.verser(montont);
    this.retirer(montont);
}
 public abstract String afficher();
 
    
  




    
}
