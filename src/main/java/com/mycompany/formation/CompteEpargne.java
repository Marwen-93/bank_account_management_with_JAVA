/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.formation;

/**
 *
 * @author mar
 */
public class CompteEpargne extends Compte {
    private double taux;
    CompteEpargne(){
   
}
    
    
CompteEpargne(double s,double taux){
    super(s);
    this.taux=taux;
}
private double calculInteret(){
    return solde*(1+(taux/100));
    
}

    public String afficher() {
        return "Compte Epargne{ Code : " + code+ "Solde : "+solde+" taux : " + taux + "}";
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

  
}
