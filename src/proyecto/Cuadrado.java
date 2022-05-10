
package proyecto;

import java.awt.Color;
import java.awt.Graphics;


public class Cuadrado {
    
    private int x;
    private int y;
    private int w;
    private int h;
    private Color color;
    private static int id;

    /**
     *  (x,y)
     *    |------------| -
     *    |            | |
     *    |            | h 
     *    |            | |
     *    |------------| -
     *          w
     */
    Cuadrado(int x, int y, int w, int h,Color color)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.color=color;
        id++;
        System.out.println(id +"  este es el id");
    }
    
    public void paintCuadrado(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, w, h);    
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }
    
    public int getId(){
        return id;
    }
    
    public Color getColor(){
        return color;
    }
    
    public void setColor(Color color){
        this.color=color;
    }
}