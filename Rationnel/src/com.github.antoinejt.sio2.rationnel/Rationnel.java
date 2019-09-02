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
        if (denominateur == 0){
            throw new IllegalArgumentException("Le dénominateur est égal à 0, or, il est impossible de diviser par 0!");
        }

        int reducedDenominateur = pgcd(numerateur, denominateur);
        int diviseur = denominateur / reducedDenominateur;

        this.numerateur = numerateur / diviseur;
        this.denominateur = reducedDenominateur;
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

    private static int pgcd(int a, int b){
        if (b != 0){
            return pgcd(b, a % b);
        }
        return a;
    }
}
