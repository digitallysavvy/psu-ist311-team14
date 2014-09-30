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

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import paintapp.CanvasPanel.Tool;

/**
 *
 * @author Erik and hwf5000
 */

public class Toolbar extends JPanel implements ActionListener {
    JToolBar bar;
    JButton eraser;
    JButton bucket;
    JButton brush;
    CanvasPanel canvas;
    
    public Toolbar(CanvasPanel c) {
       super();
       eraser = new JButton("Eraser");
       bucket = new JButton("Bucket");
       brush = new JButton("Brush");
       canvas = c;
       
       bar = new JToolBar();
        
       bar.add(brush); 
       bar.add(eraser); 
       bar.add(bucket);
        
       bar.setMargin(new Insets(5, 5, 5, 5));
       bar.setRollover(true);
       bar.setFloatable(false);
        
       brush.addActionListener(this);
       eraser.addActionListener(this);
       bucket.addActionListener(this);
       
       add(bar);
        
        setSize(100,100);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object btn = e.getSource();
        
        if (btn == brush) {           
            canvas.tool = Tool.BRUSH;
        }
        else if (btn == eraser) {
            canvas.tool = Tool.ERASER;
        }
        
        else if (btn == bucket) {
            canvas.tool = Tool.BUCKET;
        }
    
    }
}