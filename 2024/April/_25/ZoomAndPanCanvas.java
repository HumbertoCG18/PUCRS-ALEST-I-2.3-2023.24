package April._25;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import javax.swing.*;
 
/**
 * Canvas displaying a simple drawing: the coordinate-system axes + some points and their coordinates.
 * It is used to demonstrate the Zoom and Pan functionality.
 *
 * @author Sorin Postelnicu
 * @since July 13, 2009
 */
 
public class ZoomAndPanCanvas extends JComponent {
 
    private boolean init = true;

    private ZoomAndPanListener zoomAndPanListener;
    @SuppressWarnings("unused")
    private ListTADPontos listaOriginal;
    private JanelaAplicacao app;
 
    public ZoomAndPanCanvas(JanelaAplicacao app, ListTADPontos lista) {
        this.zoomAndPanListener = new ZoomAndPanListener(this);
        this.addMouseListener(zoomAndPanListener);
        this.addMouseMotionListener(zoomAndPanListener);
        this.addMouseWheelListener(zoomAndPanListener);
        this.app = app;
        this.listaOriginal = lista;
    }
 
    public ZoomAndPanCanvas(int minZoomLevel, int maxZoomLevel, double zoomMultiplicationFactor) {
        this.zoomAndPanListener = new ZoomAndPanListener(this, minZoomLevel, maxZoomLevel, zoomMultiplicationFactor);
        this.addMouseListener(zoomAndPanListener);
        this.addMouseMotionListener(zoomAndPanListener);
        this.addMouseWheelListener(zoomAndPanListener);
    }
 
    public Dimension getPreferredSize() {
        return new Dimension(600, 600);
    }
 
    public void paintComponent(Graphics g1) {
        super.paintComponent(g1);
        Graphics2D g = (Graphics2D) g1;
        if (init) {
            // Initialize the viewport by moving the origin to the center of the window,
            // and inverting the y-axis to point upwards.
            init = false;
            Dimension d = getSize();
            int xc = d.width / 2;
            int yc = d.height / 2;
            g.translate(xc, yc);
            g.scale(1, -1);
            // Save the viewport to be updated by the ZoomAndPanListener
            zoomAndPanListener.setCoordTransform(g.getTransform());
        } else {
            // Restore the viewport after it was updated by the ZoomAndPanListener
            g.setTransform(zoomAndPanListener.getCoordTransform());
        }

        ListTADPontos pontos = app.getSimplified();
        
        Path2D.Double path = new Path2D.Double();        
        Ponto pontoInicio = (Ponto) pontos.get(0);
        path.moveTo(pontoInicio.x,pontoInicio.y);        
        for(int i=1; i<pontos.size()-1; i++) {
            Ponto p = (Ponto) pontos.get(i);
            double x = p.x;
            double y = p.y;
            path.lineTo(x,y);
            // g.drawLine(x,y,x,y);
        }
        path.lineTo(pontoInicio.x,pontoInicio.y);
        Rectangle2D rect = path.getBounds2D();
        //System.out.println(rect);
        //System.out.println(rect.getCenterX());
        //System.out.println(rect.getCenterY());

        AffineTransform t = g.getTransform();
        g.scale(70,70);
        g.translate(-rect.getCenterX(),-rect.getCenterY());

        g.setStroke(new BasicStroke(0.01f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g.draw(path);
        g.setColor(Color.RED);
        for(int i=0; i<pontos.size(); i++) {
            g.fill(new Ellipse2D.Double(pontos.get(i).x,pontos.get(i).y,0.05,0.05));
        }
        g.setTransform(t);

        //g2.setTransform(t);
         
        // Create an "upside-down" font to correct for the inverted y-axis
        //Font font = g.getFont();
        //AffineTransform affineTransform = new AffineTransform();
        //affineTransform.scale(1, -1);
        //g.setFont(font.deriveFont(affineTransform));
    }
 
}
