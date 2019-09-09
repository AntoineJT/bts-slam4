package com.github.antoinejt.sio2.slam4.rationnel;

public class Main {
    public static void main(String[] args) {
        Rationnel a = new Rationnel(1, 2);
        Rationnel b = new Rationnel(4, 3);

        System.out.println(a);
        System.out.println(b);

        Rationnel c = a.add(b);
        System.out.println(c);

        Rationnel d = a.multiply(b);
        System.out.println(d);

        Rationnel e = a.opposite();
        System.out.println(e);

        Rationnel f = a.divide(b);
        System.out.println(f);

        System.out.println(f.compareTo(e));
    }
}
