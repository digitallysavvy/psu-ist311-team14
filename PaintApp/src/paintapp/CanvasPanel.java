/*
 * The MIT License
 *
 * Copyright 2014 Hermes Frangoudis (hwf5000).
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package paintapp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import paintapp.Brush.Size;
import paintapp.Brush.Style;

/**
 *
 * @author hwf5000
 */
public class CanvasPanel extends JPanel implements MouseMotionListener, MouseListener {

    Brush brush;
    ArrayList<PaintPoint> drawing;
    PaintPoint pt;
    Tool tool;

    public enum Tool {

        BRUSH, ERASER, BUCKET
    }

    public CanvasPanel() {
        super();
        setBackground(Color.WHITE);
        brush = new Brush(Size.MEDIUM, Style.SQUARE, Color.BLACK);
        drawing = new ArrayList<>();
        tool = Tool.BRUSH;
        //add listener for mouse movement
        addMouseMotionListener(this);
        addMouseListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        if (!drawing.isEmpty()) {
            for (PaintPoint pt : drawing) {
                g.setColor(pt.brush.getColor());
                g.fillRect((int) pt.getX(), (int) pt.getY(), pt.brush.getHeight(), pt.brush.getWidth());
            }

        }

    }

    @Override
    public void mouseDragged(MouseEvent evt) {

        if (tool == Tool.BRUSH) {
            //Capture pointer movement
            pt = new PaintPoint(evt.getPoint(), brush);
            drawing.add(pt);
            Graphics graphics = getGraphics();
            graphics.setColor(pt.brush.getColor());
            graphics.fillRect((int) pt.getX(), (int) pt.getY(), pt.brush.getHeight(), pt.brush.getWidth());

        }

        if (tool == Tool.ERASER) {
            Brush eraser = new Brush(brush.getSize(), brush.getStyle(), this.getBackground());
            pt = new PaintPoint(evt.getPoint(), eraser);
            drawing.add(pt);
            Graphics graphics = getGraphics();
            graphics.setColor(this.getBackground());
            graphics.fillRect((int) pt.getX(), (int) pt.getY(), pt.brush.getHeight(), pt.brush.getWidth());
        }
 
        repaint();

    }

    @Override
    public void mouseMoved(MouseEvent evt) {

    }
    
    @Override
    public void mouseClicked (MouseEvent evt){
       if (tool == Tool.BUCKET) {
            drawing = new ArrayList<>();
            setBackground(brush.getColor());
        }
       
       if (tool == Tool.BRUSH) {
            //Capture pointer movement
            pt = new PaintPoint(evt.getPoint(), brush);
            drawing.add(pt);
            Graphics graphics = getGraphics();
            graphics.setColor(pt.brush.getColor());
            graphics.fillRect((int) pt.getX(), (int) pt.getY(), pt.brush.getHeight(), pt.brush.getWidth());

        }
       repaint();
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

    //Modify the brush
    public void changeBrush(Size sz, Style st, Color c) {
        brush = new Brush(sz, st, c);
    }

    public void changeColor(Color c) {
        brush = new Brush(brush.size, brush.style, c);
    }
}
