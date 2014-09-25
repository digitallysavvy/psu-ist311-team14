/*
 * The MIT License
 *
 * Copyright 2014 macbook.
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
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import paintapp.Brush.Size;
import paintapp.Brush.Style;

/**
 *
 * @author hwf5000
 */
public class CanvasPanel extends JPanel implements MouseMotionListener {
    
    Brush brush;
    Point[] drawing;
    
    public CanvasPanel(){
        super();
        setBackground(Color.white);
        brush = new Brush(Size.MEDIUM, Style.SQUARE);
        drawing = new Point[100000];
        
        //add listener for mouse movement
        addMouseMotionListener(this);
    }
    
    @Override
    public void paintComponent(Graphics g) 
	{
    	super.paintComponent(g); 
  
        //redraw the users drawing
        for(Point pt : drawing){
            if(drawing.length <= 0){
               g.fillRect((int)pt.getX(), (int) pt.getY(), brush.getHeight(), brush.getWidth()); 
            }
            
        }
    }

    @Override
    public void mouseDragged(MouseEvent evt) {

        //Capture pointer movement
        Point pt = evt.getPoint();
        int index = 0;
        if (drawing.length > 0){
            index = drawing.length;
        }
        drawing[index] = pt;
        Graphics graphics = getGraphics();
        graphics.fillRect((int)pt.getX(), (int) pt.getY(), brush.getHeight(), brush.getWidth());
        
        
    }

    @Override
    public void mouseMoved(MouseEvent evt) {

        
        
    }
    
    
}
