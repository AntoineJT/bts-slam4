package com.github.antoinejt.sio2.rationnel;

public class Rationnel {
    public enum Comparaison {
        EGAL,
        INFERIEUR,
        SUPERIEUR
    }

    private final int numerateur;
    private final int denominateur;

    public Rationnel(int numerateur, int denominateur) throws IllegalArgumentException {
        this.numerateur = numerateur;
        if (denominateur == 0){
            throw new IllegalArgumentException("Le dénominateur est égal à 0, or, il est impossible de diviser par 0!");
        }
        this.denominateur = denominateur;
    }

    public String toString(){
        return numerateur + "/" + denominateur;
    }

    public Rationnel copy(){
        return new Rationnel(numerateur, denominateur);
    }

    public Rationnel opposite(){
        return new Rationnel(0 - numerateur, denominateur);
    }

    public Rationnel reduce(){
        int nouveauDenominateur = pgcd(numerateur, denominateur);
        int nouveauNumerateur = numerateur / nouveauDenominateur;
        return new Rationnel(nouveauNumerateur, nouveauDenominateur);
    }

    public boolean isPositive(){
        return numerateur * denominateur > 0;
    }

    public Rationnel add(Rationnel other){
        int denominateurCommun = denominateur * other.denominateur;
        int nouveauNumerateur = numerateur * other.denominateur;
        return new Rationnel(denominateurCommun, nouveauNumerateur);
    }

    public Rationnel multiply(Rationnel other){
        int nouveauNumerateur = numerateur * other.numerateur;
        int nouveauDenominateur= denominateur * other.denominateur;
        return new Rationnel(nouveauNumerateur, nouveauDenominateur);
    }

    public Rationnel divide(Rationnel other){
        int nouveauNumerateur = numerateur * other.denominateur;
        int nouveauDenominateur = denominateur * other.numerateur;
        return new Rationnel(nouveauNumerateur, nouveauDenominateur);
    }

    public Comparaison compareTo(Rationnel other){
        Rationnel thisReduced = reduce();
        Rationnel otherReduced = other.reduce();
        int thisSubstracted = thisReduced.numerateur - thisReduced.denominateur;
        int otherSubstracted = otherReduced.numerateur - otherReduced.denominateur;

        if (thisSubstracted > otherSubstracted){
            return Comparaison.SUPERIEUR;
        } else
        if (thisSubstracted < otherSubstracted){
            return Comparaison.INFERIEUR;
        }
        return Comparaison.EGAL;
    }

    /*
    // based on : https://codes-sources.commentcamarche.net/source/61729-pgcd-de-deux-nombres
    // stupid thing, must not be placed here
    private static int pgcd(int a, int b) {
        int reste;

        do {
            reste = a % b;
            a = b;
            b = reste;
        } while(reste != 0);

        return b;
    }
     */

    private static int pgcd(int a, int b){
        if (b != 0){
            return pgcd(b, a % b);
        }
        return a;
    }
}
