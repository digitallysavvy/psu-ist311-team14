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
import java.util.Hashtable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import paintapp.Brush.Size;
import paintapp.Brush.Style;
import paintapp.CanvasPanel.Tool;

/**
 *
 * @author Erik, Aldrich, hwf5000
 */

public class Toolbar extends JPanel implements ActionListener, ChangeListener  {
    JToolBar bar;
    JButton eraserTool;
    JButton bucketTool;
    JButton brushTool;
    JSlider sizeSlider;
    JSlider shapeChooser;
    CanvasPanel canvas;
    
    
    
    public Toolbar(CanvasPanel c) {
       super();
       canvas = c;
       
       eraserTool = new JButton("Eraser");
       bucketTool = new JButton("Bucket");
       brushTool = new JButton("Brush");
       sizeSlider = new JSlider(1,3,2);
       shapeChooser = new JSlider(1,3,3);
       bar = new JToolBar();

       
       //Dictionaries to label JSlider with text instead of numerical values
       Hashtable<Integer, JLabel> sizeTable = new Hashtable<>();
       sizeTable.put(1, new JLabel("Small"));
       sizeTable.put(2, new JLabel("Medium"));
       sizeTable.put(3, new JLabel("Large"));

       
       Hashtable<Integer, JLabel> shapeTable = new Hashtable<>();
       shapeTable.put (1, new JLabel("Tall"));
       shapeTable.put (2, new JLabel("Wide"));
       shapeTable.put (3, new JLabel("Square"));
       
       
       sizeSlider.setBorder(BorderFactory.createTitledBorder("Select Brush Size"));
       sizeSlider.setLabelTable(sizeTable);
       sizeSlider.setMajorTickSpacing(1);
       sizeSlider.setPaintTicks(true);
       sizeSlider.setPaintLabels(true);
       sizeSlider.setSnapToTicks(true);
       
       shapeChooser.setBorder(BorderFactory.createTitledBorder("Select Brush Style"));
       shapeChooser.setLabelTable(shapeTable);
       shapeChooser.setMajorTickSpacing(1);
       shapeChooser.setPaintTicks(true);
       shapeChooser.setPaintLabels(true);
       shapeChooser.setSnapToTicks(true);
       
       bar.add((sizeSlider));
       bar.add(brushTool); 
       bar.add(eraserTool);       
       bar.add(bucketTool);
       bar.add(shapeChooser);
   
       bar.setMargin(new Insets(5, 5, 5, 5));
        
       bar.setRollover(true);
        
       bar.setFloatable(false);
        
       sizeSlider.addChangeListener(this);
       brushTool.addActionListener(this);
       eraserTool.addActionListener(this);
       bucketTool.addActionListener(this);
       
       add(bar);
        
        setSize(100,100);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object btn = e.getSource();
        
        if (btn == brushTool) {           
            canvas.tool = Tool.BRUSH;
        }
        else if (btn == eraserTool) {
            canvas.tool = Tool.ERASER;
        }
        
        else if (btn == bucketTool) {
            canvas.tool = Tool.BUCKET;
        }
    
    }
    
    @Override
    public void stateChanged(ChangeEvent ce){
        Object obj = ce.getSource();
        if(obj == sizeSlider){
            Size sz;
            switch(sizeSlider.getValue()){
                case 1:
                    sz = Size.SMALL;
                    break;
                case 3:
                    sz = Size.LARGE;
                    break;
                case 2:
                default:
                    sz = Size.MEDIUM;
                    break;                
            }
            canvas.brush = new Brush(sz, canvas.brush.getStyle(), canvas.brush.getColor());
        }
        if(obj == shapeChooser){
            Style st;
            switch(shapeChooser.getValue()){
                case 1:
                    st = Style.TALL;
                    break;
                case 2:
                    st = Style.WIDE;
                    break;
                case 3:
                default:
                    st = Style.SQUARE;
                    break;               
            }
            canvas.brush = new Brush(canvas.brush.getSize(), st, canvas.brush.getColor());
            
        }
    }

}