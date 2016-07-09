import processing.core.*
def line = new File("settings").text.split(" ")
def extension = line[0]
def imgSize = line[1] as int

new PApplet(){
  void settings(){
    size imgSize, imgSize
  }
  void setup(){
    textSize width * 0.4
    background 0
    PImage img = loadImage("./load.${extension}")
    image(img, 0, 0, width, height)
    fill 200, 0, 30
    text("5st7", width * 0.1, height * 0.9)
    // for(j in 0..<6){
    //   background 0
    //   PImage anim = loadImage("./wxkIMB0H-/wxkIMB0H-${j}.gif")
    //   image(anim, 0, 0, width, height);
    //   loadPixels()
    //   colp = ""
    //   for(i in pixels){
    //     colp += "${Integer.toHexString((int)red(i)).padLeft(2, "0")}${Integer.toHexString((int)green(i)).padLeft(2, "0")}${Integer.toHexString((int)blue(i)).padLeft(2, "0")}\n"
    //   }
    //   new File("./gifanim/colp-${j}").text = colp
    //   println "end ${j}"
    // }
    loadPixels()
    colp = ""
    for(i in pixels){
      colp += "${Integer.toHexString((int)red(i)).padLeft(2, "0")}${Integer.toHexString((int)green(i)).padLeft(2, "0")}${Integer.toHexString((int)blue(i)).padLeft(2, "0")}\n"
    }
    new File("colp").text = colp
    exit()
  }
}.runSketch()
