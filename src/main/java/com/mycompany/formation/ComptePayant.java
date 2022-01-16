/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.formation;

/**
 *
 * @author mar
 */
public class ComptePayant extends Compte {
     ComptePayant(){
     }
      ComptePayant(double solde){
          super(solde);
     }
         public void verser(double mt){
    solde+=0.95*mt; // solde= solde +mt;
    }
    public void retirer(double mt){
         solde-=(1+0.05)*mt;
        
    }
      
      public String afficher() {
        return "Compte Payant { " + " code : " + code + ", solde :" + solde + " }";
    }  
}
