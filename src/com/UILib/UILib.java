/**
 * ##library.name##
 * ##library.sentence##
 * ##library.url##
 *
 * Copyright ##copyright## ##author##
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General
 * Public License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA  02111-1307  USA
 * 
 * @author      KDuck
 * @modified    ##date##
 * @version     ##library.prettyVersion## (##library.version##)
 */

package UILib;

import java.util.*;

import processing.core.*;
import static processing.core.PApplet.*;
import static processing.event.MouseEvent.*;
import static processing.event.KeyEvent.*;
import processing.event.*;


/**
 * This is a template class and can be used to start a new processing library or tool.
 * Make sure you rename this class as well as the name of the example package 'template' 
 * to your own library or tool naming convention.
 * 
 <!-- * @example Button/ButtonExample-->
 * 
 * (the tag @example followed by the name of an example included in folder 'examples' will
 * automatically include the example in the javadoc.)
 *
 */

public class UILib {
	
	// parent is a reference to the parent sketch
	PApplet parent;

	List<Button> allButtons = new ArrayList<Button>();
	List<ButtonFunction> allFunctionButtons = new ArrayList<ButtonFunction>();
	List<ButtonImage> allImageButtons = new ArrayList<ButtonImage>();

	List<Checkbox> allCheckboxes = new ArrayList<Checkbox>();

	List<Slider> allSliders = new ArrayList<Slider>();
	List<SliderHandle> allHandleSliders = new ArrayList<SliderHandle>();

	List<Textfield> allTextfields = new ArrayList<Textfield>();

	List<Joystick> allJoysticks = new ArrayList<Joystick>();

	public final static String VERSION = "1.0";
	

	/**
	 * a Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 *
	 * @param theParent
	 *               The parent sketch.
	 */
	public UILib(PApplet theParent) {
		parent = theParent;
		welcome();
		parent.registerMethod("draw", this);
		parent.registerMethod("mouseEvent", this);
		parent.registerMethod("keyEvent", this);
	}

	public void mouseEvent(MouseEvent event) {
		if( event.getAction() == CLICK) {
			//println("click");
		} else if (event.getAction() == MouseEvent.PRESS) {
			for(Textfield tf : allTextfields) {
				if (tf.isVisible ) tf.onClick();
			}
			for(ButtonFunction button : allFunctionButtons) {
				if (button.isVisible ) button.onClick();
			}
			for(Checkbox cb : allCheckboxes) {
				if(cb.isVisible) cb.onClick();
			}
		}
	}

	public void keyEvent(KeyEvent event) {
		if( event.getAction() == KeyEvent.PRESS) {
			for (Textfield tf : allTextfields) {
				if (tf.isVisible ) tf.onKeyPressed(parent.key , parent.keyCode);
			}
		}
	}
	
	private void welcome() {
		System.out.println("UILib initialized");
	}

	public void draw() {
		//parent.rect(100,100,100,100);
		for(Button button : allButtons) {
			if (button.isVisible && button.isAutoDraw) button.draw();
		}
		for(ButtonFunction button : allFunctionButtons) {
			if (button.isVisible && button.isAutoDraw) button.draw();
		}
		for(ButtonImage button : allImageButtons) {
			if (button.isVisible && button.isAutoDraw) button.draw();
		}
		for(Checkbox cb : allCheckboxes) {
			if(cb.isVisible && cb.isAutoDraw) cb.draw();
		}
		for(Slider slider : allSliders) {
			if (slider.isVisible) {
				if(slider.isAutoDraw) slider.draw();
				slider.update();
			}
		}
		for(SliderHandle slider : allHandleSliders) {
			if (slider.isVisible) {
				if(slider.isAutoDraw) slider.draw();
				slider.update();
			}
		}
		for(Textfield tf : allTextfields) {
			if (tf.isVisible && tf.isAutoDraw)tf.draw();
		}
		for(Joystick joy: allJoysticks) {
			if(joy.isVisible) {
				joy.update();
				if(joy.isAutoDraw) joy.draw();
			}
		}
	}

	//==========================================================================================================================//

	/**
	 * Adds a button to the sketch.
	 * The button is drawn from the center.
	 *
	 <!-- * @example ButtonExample -->
	 * @param x
	 *               the X coordinate of the button
	 * @param y
	 *               the Y coordinate of the button
	 * @param w
	 *               the width of the button
	 * @param h
	 *               the height of the button
	 *
	 * @return	the Button created
	 *
	 */
	public Button addButton(float x,float y,int w,int h) {
		Button  b = new Button(x,y,w,h,parent);
		allButtons.add(b);
		return b;
	}


	/**
	 * Adds a button that calls a function to the sketch.
	 * The button is drawn from the center.
	 *
	 <!-- * @example ButtonExample -->
	 * @param x
	 *               the X coordinate of the button
	 * @param y
	 *               the Y coordinate of the button
	 * @param w
	 *               the width of the button
	 * @param h
	 *               the height of the button
	 *
	 * @return	the Button created
	 *
	 */
	public ButtonFunction addButtonFunction(float x,float y,int w,int h,String function) {
		ButtonFunction  b = new ButtonFunction(x,y,w,h,function,parent);
		allFunctionButtons.add(b);
		return b;
	}

	/**
	 * Adds an image acting as a button to the sketch.
	 * The button is drawn from the center.
	 *
	 <!-- * @example ButtonExample -->
	 * @param x
	 *               the X coordinate of the button
	 * @param y
	 *               the Y coordinate of the button
	 * @param w
	 *               the width of the button
	 * @param h
	 *               the height of the button
	 * @param image
	 * 				 the image to draw
	 *
	 * @return	the Button created
	 *
	 */
	public ButtonImage addButtonImage(float x,float y,int w,int h, PImage image) {
		ButtonImage  b = new ButtonImage(x,y,w,h,image,parent);
		allImageButtons.add(b);
		return b;
	}

	/**
	 * Adds a checkbox to the sketch
	 * <!-- * @example CheckboxExample -->
	 * @param x the X coordinate of the Checkbox
	 * @param y the Y coordinate
	 * @param w the width of the Checkbox
	 * @param h the height
	 * @return the Checkbox created
	 */
	public Checkbox addCheckbox(float x,float y, int w, int h) {
		Checkbox cb = new Checkbox(x,y,w,h,parent);
		allCheckboxes.add(cb);
		return cb;
	}

	/**
	 * returns the list of all buttons in the sketch
	 *
	 * @return List<Button>
	 */

	public List<Button> getAllButtons() {
		return allButtons;
	}

	/**
	 * returns the list of all buttons that call a function
	 *
	 * @return List<ButtonFunction>
	 */

	public List<ButtonFunction> getAllFunctionButtons() {
		return allFunctionButtons;
	}

	/**
	 * returns the list of all image buttons in the sketch
	 *
	 * @return List<ButtonImage>
	 */

	public List<ButtonImage> getAllImageButtons() {
		return allImageButtons;
	}


	/**
	 * Adds a slider to the sketch.
	 * The slider is drawn from the top-left corner.
	 *
	 <!-- * @example SliderExample -->
	 * @param x
	 *               the X coordinate of the slider
	 * @param y
	 *               the Y coordinate of the slider
	 * @param w
	 *               the width of the slider
	 * @param h
	 *               the height of the slider
	 *
	 * @return	the Slider created
	 *
	 */
	public Slider addSlider(float x,float y,int w,int h) {
		Slider  s = new Slider(x,y,w,h,parent);
		allSliders.add(s);
		return s;
	}

	/**
	 * Adds a slider with a handle and tick marks to the sketch.
	 * The slider is drawn from the top-left corner.
	 *
	 <!-- * @example SliderExample -->
	 * @param x
	 *               the X coordinate of the slider
	 * @param y
	 *               the Y coordinate of the slider
	 * @param w
	 *               the width of the slider
	 * @param h
	 *               the height of the handle
	 *
	 * @return	the SliderHanlde created
	 *
	 */
	public SliderHandle addSliderHandle(float x,float y,int w,int h) {
		SliderHandle s = new SliderHandle(x,y,w,h,parent);
		allHandleSliders.add(s);
		return s;
	}

	/**
	 * Adds a Textfield to the sketch.
	 * The Textfield is drawn from the top-left corner.
	 *
	 * @param x the X coordinate of the textfield
	 * @param y the Y coordinate of the textfield
	 * @param w the width of the textfield
	 * @param h the height of the textfield
	 * @param defaultContent the default content of the textfield
	 * @return the Textfield created
	 */

	public Textfield addTextfield(float x, float y, float w, float h, String defaultContent) {
		Textfield tf = new Textfield(x,y,w,h,defaultContent,parent);
		allTextfields.add(tf);
		return tf;
	}

	/**
	 * Adds a Joystick to the sketch
	 * @param x the X coordinate
	 * @param y the Y coordinate
	 * @param radius the overall radius of the joystick
	 * @return the joystick created
	 */
	public Joystick addJoystick(float x, float y, float radius) {
		Joystick joy = new Joystick(x,y,radius,parent);
		allJoysticks.add(joy);
		return joy;
	}

	//==================================================================================================================//


	/**
	 * return the version of the library.
	 * 
	 * @return String
	 */
	public static String version() {
		return VERSION;
	}


}

