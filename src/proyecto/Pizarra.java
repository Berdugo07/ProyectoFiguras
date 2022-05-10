package proyecto;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Pizarra extends JPanel implements MouseListener {

    int[][] mapPixeles = new int[700][500];
    boolean b = true;
    static int w = 40;
    static int h = 40;
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

    
    public ArrayList<Cuadrado> getFigura() {
        return c;
    }

    public void setDimension(int w, int h) {
        this.w = w;
        this.h = h;
        c.get(mapPixeles[x][y] - 1).setH(h);
        c.get(mapPixeles[x][y] - 1).setW(w);
        repaint();
    }

    public Cuadrado getDimension() {
        System.out.print(mapPixeles[x][y] - 1);
        return c.get(mapPixeles[x][y] - 1);
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

            //agregamos el id a las posiciones en las que est ala figura
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
