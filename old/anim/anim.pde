PImage[] img = new PImage[6];
void setup(){
  size(50, 50);
  String basepath = "./wxkIMB0H-/wxkIMB0H-";
  for(int i = 0; i < img.length; i++){
    img[i] = loadImage(basepath + i + ".gif");
  }
}

void draw(){
}
