package com.github.antoinejt.sio2.slam4.heritage;

import java.util.ArrayList;
import java.util.List;

// NOTE: La mauvaise conception vient de l'énoncé de l'exo
public class PileGenerique<T>
{
    /*
     * Tableau contenant les elements de la pile.
     */

    private final List<T> tab;

    /********************************************/

    /*
     * Taille de la pile
     */

    private final int taille;

    /********************************************/

    /*
     * Indice du premier element non occupe dans le tableau.
     */

    private int firstFree;

    /********************************************/

    /*
     * Constructeur
     */

    PileGenerique(int taille)
    {
        this.taille = taille;
        tab = new ArrayList<T>();
        firstFree = 0;
    }

    /********************************************/

    /*
     * Constructeur de copie.
     */

    PileGenerique(PileGenerique other)
    {
        this(other.taille);
        firstFree = other.firstFree;
        for (int i = 0; i < firstFree; i++) {
            tab.set(i, (T) other.tab.get(i));
        }
    }

    /********************************************/

    /*
     * Retourne vrai si et seulement si la pile est vide
     */

    public boolean estVide()
    {
        return firstFree == 0;
    }

    /********************************************/

    /*
     * Retourne vrai si et seulement si la pile est pleine.
     */

    public boolean estPleine()
    {
        return firstFree == taille;
    }

    /**
     * @return******************************************/

    /*
     * Retourne l'element se trouvant au sommet de la pile, -1 si la pile est
     * vide.
     */

    public T sommet()
    {
        if (estVide()){
            return null;
        }
        return tab.get(firstFree - 1);
    }

    /********************************************/

    /*
     * Supprime l'element se trouvant au sommet de la pile, ne fait rien si la
     * pile est vide.
     */

    public void depile()
    {
        if (!estVide()){
            firstFree--;
        }
    }

    /********************************************/

    /*
     * Ajoute data en haut de la pile, ne fait rien si la pile est pleine.
     */

    public void empile(T data)
    {
        if (!estPleine()){
            tab.set(firstFree++, data);
        }
    }

    /********************************************/

    /*
     * Retourne une representation de la pile au format chaine de caracteres.
     */

    public String toString()
    {
        StringBuilder res = new StringBuilder("[");
        for (int i = 0; i < firstFree; i++){
            res.append(" ").append(tab.get(i));
        }
        return res + " ]";
    }

    /********************************************/

    /*
     * Teste le fonctionnement de la pile.
     */

    public static void main(String[] args)
    {
        PileGenerique<Integer> p = new PileGenerique<Integer>(30);
        int i = 0;
        while (!p.estPleine()){
            p.empile(i++);
        }
        System.out.println(p);
        while (!p.estVide())
        {
            System.out.println(p.sommet());
            p.depile();
        }
    }
}
