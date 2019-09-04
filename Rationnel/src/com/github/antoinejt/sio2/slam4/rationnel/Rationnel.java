package com.github.antoinejt.sio2.slam4.rationnel;

// TODO Make some unit tests! (maybe?)
public class Rationnel {
    public enum Comparaison {
        EGAL,
        INFERIEUR,
        SUPERIEUR
    }

    private final int numerateur;
    private final int denominateur;

    @SuppressWarnings("WeakerAccess")
    public Rationnel(int numerateur, int denominateur) throws IllegalArgumentException {
        if (denominateur == 0){
            throw new IllegalArgumentException("Le dénominateur est égal à 0, or, il est impossible de diviser par 0!");
        }

        int pgcd = pgcd(numerateur, denominateur);

        this.numerateur = numerateur / pgcd;
        this.denominateur = denominateur / pgcd;
    }

    @SuppressWarnings({"unused", "WeakerAccess"})
    public String toString(){
        return numerateur + "/" + denominateur;
    }

    @SuppressWarnings({"unused", "WeakerAccess"})
    public Rationnel copy(){
        return new Rationnel(numerateur, denominateur);
    }

    @SuppressWarnings({"unused", "WeakerAccess"})
    public Rationnel opposite(){
        return new Rationnel(0 - numerateur, denominateur);
    }

    @SuppressWarnings({"unused", "WeakerAccess"})
    public boolean isPositive(){
        return numerateur * denominateur > 0;
    }

    @SuppressWarnings({"unused", "WeakerAccess"})
    public Rationnel add(Rationnel other){
        if (denominateur == other.denominateur){
            int sommeNumerateurs = numerateur + other.numerateur;
            return new Rationnel(sommeNumerateurs, denominateur);
        }

        int nouveauThisNumerateur = numerateur * other.denominateur;
        int nouveauOtherNumerateur = other.numerateur * denominateur;
        int nouveauNumerateur = nouveauThisNumerateur + nouveauOtherNumerateur;
        int denominateurCommun = denominateur * other.denominateur;

        return new Rationnel(nouveauNumerateur, denominateurCommun);
    }

    @SuppressWarnings({"unused", "WeakerAccess"})
    public Rationnel multiply(Rationnel other){
        int nouveauNumerateur = numerateur * other.numerateur;
        int nouveauDenominateur = denominateur * other.denominateur;

        return new Rationnel(nouveauNumerateur, nouveauDenominateur);
    }

    // TODO Do it : here is just a copy of multiply
    @SuppressWarnings({"unused", "WeakerAccess"})
    public Rationnel divide(Rationnel other){
        int nouveauNumerateur = numerateur * other.denominateur;
        int nouveauDenominateur = denominateur * other.numerateur;

        return new Rationnel(nouveauNumerateur, nouveauDenominateur);
    }

    @SuppressWarnings({"unused", "WeakerAccess"})
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
