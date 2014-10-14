/*
 * The MIT License
 *
 * Copyright 2014 Aldrich Fung, Hermes Frangoudis (hwf5000).
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
import java.awt.event.*;

import javax.swing.*;
import java.awt.FlowLayout;



/**
 *
 * @author Aldrich and hwf5000
 */

public class ColorChooser extends JPanel implements ActionListener{
    
    ColorButton red,blue,green,yellow, white, black, pink, magenta, orange, grey;
    CanvasPanel canvas;
    
    public ColorChooser(CanvasPanel c){
        super();
        setLayout(new FlowLayout());
        canvas = c;

        
        red = new ColorButton("Red", Color.RED);
        blue = new ColorButton("Blue", Color.BLUE);
        green = new ColorButton("Green", Color.GREEN);
        yellow = new ColorButton("Yellow", Color.YELLOW);
        white = new ColorButton("White", Color.WHITE);
        black = new ColorButton("black", Color.BLACK);
        pink = new ColorButton("Pink", Color.PINK);
        magenta = new ColorButton("Magenta", Color.MAGENTA);
        orange = new ColorButton("Oragne", Color.ORANGE);
        
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
        add(black);
        add(red);
        add(blue);
        add(green);
        add(yellow);
        add(white);
        add(pink);
        add(magenta);
        add(orange);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       Object obj = e.getSource();
       //whats the point of this graphics object???
       Graphics graphics = getGraphics();
       if(obj == blue){
           if(canvas.brush.color != null){
            canvas.changeColor(Color.BLUE);
            repaint();
           }
       }
       if(obj == red){
           if(canvas.brush.color != null){
            canvas.changeColor(Color.RED);
            repaint();
           }
       }
       if(obj == green){
           if(canvas.brush.color != null){
            canvas.changeColor(Color.GREEN);
            repaint();
           }
       }
       if(obj == yellow){
           if(canvas.brush.color != null){
            canvas.changeColor(Color.YELLOW);
            repaint();
           }
       }
       if(obj == white){
           if(canvas.brush.color != null){
            canvas.changeColor(Color.WHITE);
            repaint();
           }
       }
       if(obj == black){
           if(canvas.brush.color != null){
            canvas.changeColor(Color.BLACK);
            repaint();
           }
       }
       if(obj == pink){
           if(canvas.brush.color != null){
            canvas.changeColor(Color.PINK);
            repaint();
           }
       }
       if(obj == magenta){
           if(canvas.brush.color != null){
            canvas.changeColor(Color.MAGENTA);
            repaint();
           }
       }
       if(obj == orange){
           if(canvas.brush.color != null){
            canvas.changeColor(Color.ORANGE);
            repaint();
           }
       }
    }
}
