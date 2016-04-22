import processing.core.*
new PApplet(){
  void settings(){
    size 50, 50
  }
  void setup(){
    background 0
    PImage img = loadImage("./load.jpg")
    image(img, 0, 0, 50, 50)
    loadPixels()
    colp = ""
    for(i in pixels){
      colp += "${Integer.toHexString((int)red(i)).padLeft(2, "0")}${Integer.toHexString((int)green(i)).padLeft(2, "0")}${Integer.toHexString((int)blue(i)).padLeft(2, "0")}\n"
    }
    new File("colp").text = colp
    exit()
  }
}.runSketch()
