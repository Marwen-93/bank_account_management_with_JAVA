/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.formation;

/**
 *
 * @author mar
 */
public class CompteSimple extends Compte {
    private double decouvert;
        CompteSimple(double s,double decouvert ){
            super(s);
            this.decouvert=decouvert;
        }
        CompteSimple(){
            
            }
        
         public void retirer(double mt,double decouvert){
             if ( mt< solde+decouvert){
               solde-=mt;   
             }
             else System.out.println("you can't do this operation");
             
        
        
    } 

    public String afficher() {
        return "Compte Simple{ " + "code= " + code + ", solde= " + solde + " decouvert " +decouvert+ " }";
    }  

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }
    
}
