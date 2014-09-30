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

/**
 *
 * @author hwf5000
 */
public class Brush {
    
    int height;
    int width;
    Size size;
    Style style;
    Color color;
    
    public enum Size {
        SMALL, MEDIUM, LARGE
    }
    
    public enum Style {
        TALL, WIDE, SQUARE
    }
    
    
    public Brush(Size sz, Style st, Color c){

        //set brush size and style
        size = sz;
        style = st;
        
        //set brush size
        switch(size){
            
            case SMALL:
                height = 5;
                width = 5;
                break;
            
            case LARGE:
                height = 15;
                width = 15;
                break;
                
            case MEDIUM:
            default:
                height = 10;
                width = 10;
                break;
        }  
        
        //set brush style
        switch(style){
            
            case TALL:
                height += 4;
                width -= 4;
                break;
            
            case WIDE:
                height -= 4;
                width += 4;
                break;
            
            case SQUARE:
            default:
                break;
        }
        
        color = c;
        
    }
    
    public int getHeight(){
        return height;
    }
    
    public int getWidth(){
        return width;
    }
    
    public Size getSize(){
        return size;
    }
    
    public Style getStyle(){
        return style;
    }
    
    public Color getColor(){
        return color;
    }
    
}
