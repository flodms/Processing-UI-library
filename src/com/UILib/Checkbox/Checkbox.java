package UILib;

import processing.core.*;

import java.awt.Color;
import java.lang.Math.*;
import java.util.*;

/**
 * This allows to display a checkbox
 *
 <!-- * @example CheckboxExample  -->
 *
 * (the tag @example followed by the name of an example included in folder 'examples' will
 * automatically include the example in the javadoc.)
 *
 */
public class Checkbox extends Button {
    public boolean isChecked = false;
    PImage tickIcon;
    Checkbox(float x, float y, int w, int h, PApplet parent) {
        super(x,y,w,h,parent);
        tickIcon = parent.loadImage("C:\\Users\\Flo\\Documents\\Code\\Processing-UI-library\\data\\tick-icon.png");
    }

    public void draw() {
        super.draw();
        if(isChecked) { //tick
            parent.imageMode(parent.CENTER);
            parent.image(tickIcon,x,y,w,h);
        }
    }

    public void onClick() {
        if(super.isMouseOver()) isChecked = !isChecked;
    }
}