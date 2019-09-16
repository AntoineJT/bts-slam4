package com.github.antoinejt.sio2.slam4.heritage;

// NOTE: La mauvaise conception vient de l'énoncé de l'exo
public class Cercle extends Point {
    private float radius;

    public Cercle(float x, float y) {
        super(x, y);
    }

    public Cercle(Point position, float radius){
        this(position.getX(), position.getY());
        this.radius = radius;
    }

    public void setRadius(float radius){
        this.radius = radius;
    }

    public float getRadius() {
        return radius;
    }
}
