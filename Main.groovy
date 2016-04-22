import processing.core.*
def line = new File("settings").text.split(" ")
def extension = line[0]
def imgSize = line[1] as int
new PApplet(){
  void settings(){
    size imgSize, imgSize
  }
  void setup(){
    background 0
    PImage img = loadImage("./load.${extension}")
    image(img, 0, 0, width, height)
    loadPixels()
    colp = ""
    for(i in pixels){
      colp += "${Integer.toHexString((int)red(i)).padLeft(2, "0")}${Integer.toHexString((int)green(i)).padLeft(2, "0")}${Integer.toHexString((int)blue(i)).padLeft(2, "0")}\n"
    }
    // new File("colp").text = colp
    exit()
  }
}.runSketch()
