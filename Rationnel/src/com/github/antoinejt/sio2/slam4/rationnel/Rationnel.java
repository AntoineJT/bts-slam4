package com.github.antoinejt.sio2.slam4.rationnel;

// TODO Fix this broken shit!
// TODO Make some unit tests!
public class Rationnel {
    public enum Comparaison {
        EGAL,
        INFERIEUR,
        SUPERIEUR
    }

    private final int numerateur;
    private final int denominateur;

    public Rationnel(int numerateur, int denominateur) throws IllegalArgumentException {
        if (denominateur == 0){
            throw new IllegalArgumentException("Le dénominateur est égal à 0, or, il est impossible de diviser par 0!");
        }

        int denominateurReduit = pgcd(numerateur, denominateur);
        int diviseur = 1;

        // is this needed?
        if (denominateur != denominateurReduit){
            diviseur = denominateur / denominateurReduit;
        }
        this.numerateur = numerateur / diviseur;
        // TODO Refactor that : what if denominateurReduit equals 1?
        this.denominateur = denominateurReduit;
    }

    @SuppressWarnings("unused")
    public String toString(){
        return numerateur + "/" + denominateur;
    }

    @SuppressWarnings("unused")
    public Rationnel copy(){
        return new Rationnel(numerateur, denominateur);
    }

    @SuppressWarnings("unused")
    public Rationnel opposite(){
        return new Rationnel(0 - numerateur, denominateur);
    }

    @SuppressWarnings("unused")
    public boolean isPositive(){
        return numerateur * denominateur > 0;
    }

    @SuppressWarnings("unused")
    public Rationnel add(Rationnel other){
        int denominateurCommun = denominateur * other.denominateur;
        int nouveauNumerateur = numerateur * other.denominateur;

        return new Rationnel(denominateurCommun, nouveauNumerateur);
    }

    @SuppressWarnings("unused")
    public Rationnel multiply(Rationnel other){
        int nouveauNumerateur = numerateur * other.numerateur;
        int nouveauDenominateur= denominateur * other.denominateur;

        return new Rationnel(nouveauNumerateur, nouveauDenominateur);
    }

    @SuppressWarnings("unused")
    public Rationnel divide(Rationnel other){
        int nouveauNumerateur = numerateur * other.denominateur;
        int nouveauDenominateur = denominateur * other.numerateur;

        return new Rationnel(nouveauNumerateur, nouveauDenominateur);
    }

    @SuppressWarnings("unused")
    public Comparaison compareTo(Rationnel other){
        int thisSubstracted = numerateur - denominateur;
        int otherSubstracted = other.numerateur - other.denominateur;

        if (thisSubstracted > otherSubstracted){
            return Comparaison.SUPERIEUR;
        } else
        if (thisSubstracted < otherSubstracted){
            return Comparaison.INFERIEUR;
        }
        return Comparaison.EGAL;
    }

    private static int pgcd(int a, int b){
        if (b != 0){
            return pgcd(b, a % b);
        }
        return a;
    }
}
