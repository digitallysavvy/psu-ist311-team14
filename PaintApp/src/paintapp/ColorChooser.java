/*
 * The MIT License
 *
 * Copyright 2014 Aldrich.
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
import java.awt.event.*;

import javax.swing.*;
import java.awt.FlowLayout;



/**
 *
 * @author Aldrich
 */
public class ColorChooser extends JPanel implements ActionListener{
    
    JButton red,blue,green,yellow, white, black, pink, magenta, orange, grey;
    CanvasPanel canvas;
    
    public ColorChooser(CanvasPanel c){
        super();
        setLayout(new FlowLayout());
        this.canvas = c;

        
        red = new JButton("Red");
        blue = new JButton("Blue");
        green = new JButton("Green");
        yellow = new JButton("Yellow");
        white = new JButton("White");
        black = new JButton("Black");
        pink = new JButton("Pink");
        magenta = new JButton("Magenta");
        orange = new JButton("Orange");
        
        //Attaches ActionListener to buttons
        red.addActionListener(this);
        blue.addActionListener(this);
        green.addActionListener(this);
        yellow.addActionListener(this);
        white.addActionListener(this);
        black.addActionListener(this);
        pink.addActionListener(this);
        magenta.addActionListener(this);
        orange.addActionListener(this);
        
        //Add buttons to panel
        add(red);
        add(blue);
        add(green);
        add(yellow);
        add(white);
        add(black);
        add(pink);
        add(magenta);
        add(orange);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       Object obj = e.getSource();
       Graphics graphics = getGraphics();
       if(obj == blue){
           if(canvas.brush.color != null){
            canvas.brush.color = Color.BLUE;
            repaint();
           }
       }
       if(obj == red){
           if(canvas.brush.color != null){
            canvas.brush.color = Color.RED;
            repaint();
           }
       }
       if(obj == green){
           if(canvas.brush.color != null){
            canvas.brush.color = Color.GREEN;
            repaint();
           }
       }
       if(obj == yellow){
           if(canvas.brush.color != null){
            canvas.brush.color = Color.YELLOW;
            repaint();
           }
       }
       if(obj == white){
           if(canvas.brush.color != null){
            canvas.brush.color = Color.WHITE;
            repaint();
           }
       }
       if(obj == black){
           if(canvas.brush.color != null){
            canvas.brush.color = Color.BLACK;
            repaint();
           }
       }
       if(obj == pink){
           if(canvas.brush.color != null){
            canvas.brush.color = Color.PINK;
            repaint();
           }
       }
       if(obj == magenta){
           if(canvas.brush.color != null){
            canvas.brush.color = Color.MAGENTA;
            repaint();
           }
       }
       if(obj == orange){
           if(canvas.brush.color != null){
            canvas.brush.color = Color.ORANGE;
            repaint();
           }
       }
    }
}
