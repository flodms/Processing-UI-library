package UILib;
/** TODO:
 *  change color of text method
 */

import processing.core.*;

import java.awt.Color;
import java.lang.Math.*;
import java.util.*;

/**
 * This allows to display a clickable button
 *
 <!-- * @example ButtonExample  -->
 *
 * (the tag @example followed by the name of an example included in folder 'examples' will
 * automatically include the example in the javadoc.)
 *
 */
public class Button {
    public float x,y;
    public int w,h;
    PApplet parent;

    int color = 255;
    int strokeColor = 0;

    public int cornerRadius = 0;

    public boolean isVisible = true;
    public boolean isAutoDraw = true;

    String text = "";
    Button(float xb,float yb,int wb,int hb, PApplet theParent) {
        x=xb;
        y=yb;
        w=wb;
        h=hb;
        parent = theParent;
    }

    public boolean isPressed() {
        if(Math.abs(parent.mouseX-x)<w/2 && Math.abs(parent.mouseY-y)<h/2 && parent.mousePressed && isVisible) {
            return true;
        } else return false;
    }

    public boolean isMouseOver() {
        if(Math.abs(parent.mouseX-x)<w/2 && Math.abs(parent.mouseY-y)<h/2) {
            return true;
        } else return false;
    }

    public void draw() {
        parent.rectMode(parent.CENTER);
        parent.fill(color);
        parent.stroke(strokeColor);
        parent.rect(x,y,w,h,cornerRadius);
        if(isPressed()) {
            parent.fill(parent.color(150,100));
            parent.rect(x,y,w,h);
        }
        parent.textAlign(parent.CENTER);
        parent.textSize(h-(20*h/100));
        parent.fill(0);
        parent.text(text,x,y+(20*h/100));
    }

    /**
     * Changes the absolute position of the button.
     *
     * @param x
     *               the new X coordinate
     * @param y
     *               the new Y coordinate
     *
     */

    public void setPosition(float x,float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Changes the size of the button.
     *
     * @param width
     *               the new width
     * @param height
     *               the new height
     *
     */

    public void setSize(int width,int height) {
        this.w = width;
        this.h = height;
    }

    /**
     * Changes the color of the button.
     *
     * @param theColor
     *               the new color: use processing's color(r,g,b)
     *
     */

    public void setColor(int theColor) {
        color = theColor;
    }

    /**
     * Changes the color of the button's outline.
     *
     * @param theColor
     *               the new color: use processing's color(r,g,b)
     *
     */

    public void setStrokeColor(int theColor) {
        strokeColor = theColor;
    }

    /**
     * Sets the text to be displayed inside the button
     * @param newText the text
     */
    public void setText(String newText) {this.text=newText;}

    /**
     * Makes the button rounded on the corners
     * @param radius the radius of the round corners
     */
    public void roundCorners(int radius) {this.cornerRadius = radius;}

    /**
     * Returns the background color (color) and the utline color (strokeColor)
     *
     * @return	array of both color ans stroke color: [color,strokeColor]
     *
     */

    public int[] getColors() {
        int[] colors = {color,strokeColor};
        return colors;
    }

    /**
     * sets the button as visible
     */
    public void show() {
        isVisible = true;
    }

    /**
     * sets the button as hidden: not pressable anymore
     */
    public void hide() {
        isVisible = false;
    }

    /**
     * Sets wether the button is drawn automatically or not.
     * Call .draw() to draw manually.
     * Should not be used to hide the button.
     * @param flag true or false
     */
    public void setAutoDraw(boolean flag) {
        isAutoDraw = flag;
    }
}