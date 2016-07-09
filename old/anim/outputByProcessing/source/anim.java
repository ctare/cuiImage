import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class anim extends PApplet {

PImage[] img = new PImage[6];
public void setup(){
  
  String basepath = "./wxkIMB0H-/wxkIMB0H-";
  for(int i = 0; i < img.length; i++){
    img[i] = loadImage(basepath + i + ".gif");
  }
}

public void draw(){
}
  public void settings() {  size(50, 50); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "anim" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
