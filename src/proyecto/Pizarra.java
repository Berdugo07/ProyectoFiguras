package proyecto;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Pizarra extends JPanel implements MouseListener {

    int[][] mapPixeles = new int[700][500];
    boolean b;
    static int w = 50;
    static int h = 50;
    private ArrayList<Cuadrado> c = new ArrayList<Cuadrado>();
    static int figura;
    int x, y;
    Color color;
    static int contador = 0;

    public Pizarra(Dimension d) {
        setSize(d);
        setPreferredSize(d);
        setVisible(true);
        addMouseListener(this);
    }

    public void setDimension(int w, int h) {

        for (int i =0; i < c.get(mapPixeles[x][y]-1).getW(); i++) {
                for (int j = 0; j < c.get(mapPixeles[x][y]-1).getH(); j++) {
                    mapPixeles[c.get(mapPixeles[x][y]-1).getX() + i +1][c.get(mapPixeles[x][y]-1).getY() + j ] = 0;
                }
        }
        
        for (int i =0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    mapPixeles[c.get(mapPixeles[x][y]-1).getX() + i +1][c.get(mapPixeles[x][y]-1).getY() + j ] =c.get(mapPixeles[x][y]-1).getId() ;
                }
        }
        
        c.get(mapPixeles[x][y] - 1).setH(h);
        c.get(mapPixeles[x][y] - 1).setW(w);
        repaint();
    }

    public void paint(Graphics g) {

        super.paint(g);

        c.forEach((objCir) -> {
            objCir.paintCuadrado(g);
        });

        /*g.fillOval(350, 270, 70, 70);
        int[] vx2 = {500, 550, 450};
        int[] vy2 = {270, 320, 320};
        g.fillPolygon(vx2, vy2, 3);*/
    }

    public String getInfo() {
        String text = "Tipo : Cuadrado"
                + "\n" + "Lado : " + c.get(mapPixeles[x][y] - 1).getW();
        return text;
    }

    public void setFigura(int figura) {
        this.figura = figura;
        b = true;
        System.out.println("esta es la figura" + figura);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void borrar() {

        repaint();
        c.get(mapPixeles[x][y] - 1).setW(0);
        c.get(mapPixeles[x][y] - 1).setH(0);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        while (b) {
            // Se inserta la ubicacion del mouse
            x = e.getX();
            y = e.getY();

            c.add(new Cuadrado(x, y, w, h, color));

            //agregamos el id a las posiciones en las que esta la figura
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    mapPixeles[x + i - 1][y + j - 1] = c.get(c.size() - 1).getId();
                }
            }
            repaint();
            b = false;

        }

        if (mapPixeles[e.getX()][e.getY()] != 0) {
            System.out.println("aqui hay un valor" + mapPixeles[e.getX()][e.getY()]);
            x = e.getX();
            y = e.getY();
            c.get(mapPixeles[e.getX()][e.getY()]-1).setColor(color);
            //repaint();
            System.out.println(mapPixeles[e.getX()][e.getY()] + " valor llenado en la matriz");
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
