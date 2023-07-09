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

public class shoot extends PApplet {

PImage img1,img2,img3,img4,img5,img6;
PShape osprey,earth,mars,moon,rockon;



public void setup(){
	
  img1 =loadImage("meisai.jpg");
  img2=loadImage("universe.png");
  img3=loadImage("earth.png");
  img4=loadImage("moon.png");
  img5=loadImage("mars.png");
  img6=loadImage("rockon.png");
	noStroke();
	
  camera(width/2,height/2-100,240,width/2,height/2-100,199,0,1,0);
  for(int i=0;i<10;i++) b[i]=new Bullet();
	for(int i=0;i<7;i++) e[i]=new Enemy();
	for(int i=0;i<7;i++) eb[i]=new EBullet(i);
	//making osprey bullet, enemy and enemies bullet
	}



public void drawospreybody(){
	pushMatrix();
		osprey=createShape(BOX,150,70,50);
  	osprey.setTexture(img1);
    shape(osprey);
    	pushMatrix();
      	translate(0,40);
        osprey=createShape(BOX,50,10,300);
        osprey.setTexture(img1);
        shape(osprey);
        translate(0,0,150);
        osprey=createShape(BOX,80,30,30);
        osprey.setTexture(img1);
        shape(osprey);
        translate(0,0,-300);
        shape(osprey);
      popMatrix();
    fill(0,0,0,200);
    translate(-40,0,25);
    box(40,40,1);
    translate(60,0,0);
    box(40,40,1);
    translate(0,0,-50);
    box(40,40,1);
    translate(-60,0,0);
    box(40,40,1);
    fill(255,255,255);
  popMatrix();

  pushMatrix();
  	translate(110,-17.5f);
    osprey=createShape(BOX,75,35,50);
    osprey.setTexture(img1);
    shape(osprey);
    translate(0,35);
    fill(0,0,0,70);
    box(74,34,49);
    fill(255,255,255);
  popMatrix();

  pushMatrix();
		translate(170,-17.5f,12);
    rotateY(PI/6);
    osprey=createShape(BOX,25*2,35,1);
    osprey.setTexture(img1);
    shape(osprey);
  popMatrix();

  pushMatrix();
		translate(170,-17.5f,-12);
    rotateY(-PI/6);
    shape(osprey);
  popMatrix();

	pushMatrix();
		translate(150,0,-25);
  	textureMode(NORMAL);
  		beginShape();
  			texture(img1);
        vertex(0,0,0,0,0); vertex(0,0,50,1,0); vertex(50*sqrt(3)/2,0,25,0.5f,0.5f);
      endShape();

    translate(0,-35);

			beginShape();
				texture(img1);
      	vertex(0,0,0,0,0); vertex(0,0,50,1,0); vertex(50*sqrt(3)/2,0,25,0.5f,0.5f);
    	endShape();

 	popMatrix();


  pushMatrix();
		translate(-75,35,25);

      beginShape();
        texture(img1);
        vertex(0,0,0,0,0); vertex(-42,-15,-12,0.3f,0.3f); vertex(-130,0,-25,0.5f,0.5f); vertex(-42,-15,-38,0.8f,0.3f); vertex(0,0,-50,1,0);
      endShape();

      beginShape();
        texture(img1);
        vertex(0,0,0,0,0); vertex(-42,-15,-12,0.3f,0.3f); vertex(-130,0,-25,0.4f,0);  vertex(0,-34,0,1,0);
      endShape();

		translate(0,0,-50);

			beginShape();
        texture(img1);
        vertex(0,0,0,0,0); vertex(-42,-15,12,0.3f,0.3f); vertex(-130,0,25,0.4f,0); vertex(0,-34,0,1,0);
      endShape();

    translate(0,-34,50);

      beginShape();
        texture(img1);
        vertex(0,0,0,0,0);  vertex(-130,35,-25,0.5f,0.5f);  vertex(0,0,-50,1,0);
      endShape();

	popMatrix();

  pushMatrix();
		translate(-200,34,0);
    osprey=createShape(BOX,25,1,80);
    osprey.setTexture(img1);
    shape(osprey);
    translate(0,0,40);
    osprey=createShape(BOX,50,50,1);
    osprey.setTexture(img1);
    shape(osprey);
    translate(0,0,-80);
    shape(osprey);
	popMatrix();

  }

  public void drawpuropera(){
    fill(0,0,0);
    pushMatrix();
      rotateZ(PI*2/3);
      translate(75,0);
      box(150,10,1);
    popMatrix();
    pushMatrix();
      rotateZ(PI*4/3);
      translate(75,0);
      box(150,10,1);
    popMatrix();
    translate(75,0);
    box(150,10,1);
  }




	  public void drawosprey(float a){
	    drawospreybody();
	    pushMatrix();
	      translate(40,40,150);
	      rotateY(PI/2);
	      rotateZ(a);
	      scale(0.5f);
	      drawpuropera();
	    popMatrix();
	    pushMatrix();
	      translate(40,40,-150);
	      rotateY(PI/2);
	      scale(0.5f);
	      rotateZ(a);
	      drawpuropera();
	    popMatrix();
	  }




	public void makeufo(int rare){
	  pushMatrix();
	    translate(0,7);
	    fill(128,128,0);
	    sphere(19);
			if(rare==1){fill(230,180,34);}
	    else{fill(125,125,125);}
	    translate(0,8);
	    ambient(128,128,128);
	    shininess(7);
	    sphere(20);
	  popMatrix();
	  for(float i=0;i<2*PI;i+=PI/360){
	    pushMatrix();
	      rotateY(i);
	      translate(5,15,-15);
	      box(10,5,20);
	    popMatrix();
	    pushMatrix();
	      rotateY(i);
	      translate(25,15);
				if(rare==1){stroke(230,180,34);}
				else{stroke(125,125,125);}
	      line(0,0,15,-15);
	      noStroke();
	    popMatrix();
	  }
	  for(int i=0;i<7;i++){
	    pushMatrix();
	      ambient(0,0,0);
	      rotateY(2*PI*i/7);
	      translate(0,8,32.7f);
	      rotateX(-PI/4);
	      fill(0,0,0);
	      ellipse(0,0,10,10);
	    popMatrix();
	  }
	}



class Bullet{
	  float r;
		float bx;
		float by;
		float bz;
    int flag=0;
	  Bullet() {
			r=1;
			bx=map(mouseX, 0, width, -125, 125);
			by=map(mouseY, 0, height, -65, 65)-100;
			bz=120;
	  }

	  public void run() {
	    update();
	    display();
	  }

	  public void update() {
			if(death==1){bx=1000000;}
			else{
				if(flag==0){ bx=map(mouseX, 0, width, -125, 125); by=map(mouseY, 0, height, -65, 65)-100; bz=120;}
				else{
					bz-=15;
					if(bz<-500){
						bx=map(mouseX, 0, width, -125, 125);
						by=map(mouseY, 0, height, -65, 65)-100;
						bz=120;
						changeflag(0);
					}
				}
			}
	  }
    public int getflag(){
      return flag;
    }
    public void changeflag(int x){
      flag=x;
    }
		public float getx(){
			return bx;
		}
		public float gety(){
			return by;
		}
		public float getz(){
			return bz;
		}

	  public void display() {
      if(flag==0){
        pushMatrix();
         translate(bx,by,bz);
         fill(0,255,0);
         sphere(r);
        popMatrix();
      }
      else{
        pushMatrix();
         translate(bx,by,bz);
         fill(0,255,0);
         sphere(r);
        popMatrix();
      }
	  }
	}




	class EBullet{
		  float r;
			float bx;
			float by;
			float bz;
			float v;
		  EBullet(int a) {
				r=1;
				bx=e[a].getx();
				by=e[a].gety();
				bz=e[a].getz();;
				v=random(6);
		  }

		  public void run(int a) {
		    update(a);
		    display();
		  }
		  public void update(int a){
	        bz+=v;
	        if(bz>170){
						bx=e[a].getx();
						by=e[a].gety();
						bz=e[a].getz();
	      	}
		  }

			public float getx(){
				return bx;
			}
			public float gety(){
				return by;
			}
			public float getz(){
				return bz;
			}
			public float getr(){
				return r;
			}

		  public void display() {
	        pushMatrix();
	         translate(bx,by,bz);
	         fill(255,0,0);
	         sphere(r);
	        popMatrix();
		  }
		}



	class Enemy{
		  float r;
			float ex;
			float ey;
			float ez;
			float sx=200;
			float x;
			float a=random(4);
			float v=PI/10+random(1)*0.1f;
	    int deadflag=0;
			int life=255;
			int direction;
			int rare;
		  Enemy() {
				r=10;
				ey=-165+random(130);
				ez=-10+random(70);
				x=random(1);
				rare=(int)random(30);
				if(rare==1){v=3*(PI+random(1));}
				if(x>0.5f){
					ex=-sx-random(50);
					direction=1;
				}
				else{
					ex=sx+random(50);
					direction=-1;
				}
		  }

		  public void run() {
		    update();
		    display();
		  }

		  public void update() {
				if(deadflag==0){
					if(direction==1){
						ex+=v;
						if(ex>sx){
							reborn();
						}
					}
					else{
						ex-=v;
						if(ex<-sx){
							reborn();
						}
					}
					ey+=a*sin(ex/2);
				}
		  }

			public void dead(){
				if(deadflag==0){
					if(rare==1){score+=100;}
					else{	score+=10;}
					deadflag=1;
					r=1;
				}
			}

			public float getx(){
				return ex;
			}
			public float gety(){
				return ey;
			}
			public float getz(){
				return ez;
			}
			public float getr(){
				return r;
			}

			public void reborn(){
				x=random(1);
				if(x>0.5f){ex=-sx+random(50); direction=1;}
				else{ex=sx-random(50);direction=-1;}
				ey=-165+random(130); ez=-10+random(70); deadflag=0; r=10; life=255;
				v=PI/10+random(1)*0.1f;
				rare=(int)random(30);
				if(rare==1){v=3*(PI+random(1));}
			}


		  public void display() {
	      if(deadflag==0){
	        pushMatrix();
	         translate(ex,ey,ez);
					 rotateX(PI);
	         fill(0,0,255);
					 scale(0.5f);
					 rotateY(theta/2);
					 if(rare==1){makeufo(1);}
					 else{makeufo(0);}

	        popMatrix();
	      }
	      else{
	        pushMatrix();
						life-=2;
						if(r<40){r++;}
						translate(ex,ey,ez-70);
						fill(255,0,0,life);
						sphere(r);
						if(life<0){
							reborn();
						}
	        	popMatrix();
	      }
		  }
		}



float theta=0,etheta=0;
Bullet[] b=new Bullet[10];
EBullet[] eb=new EBullet[7];
Enemy[] e=new Enemy[7];
int bnum=0;
int death=0;
int btime=0;
float life=100;
float ospreyr=0;
int bomulife=255;
float dx,dy;
//Osprey coordinates at the time of death
int score=0;

		public void draw(){
			background(255,0,0);
		  translate(width/2,height/2);

			pushMatrix();
				translate(-138,-233);
				fill(0,255,0);
				box(2*life,10,1);
			popMatrix();

			pushMatrix();
				fill(0,0,0);
				translate(-143,-238,1);
				text("HP",10,10);
			popMatrix();
			pushMatrix();
				translate(138,-233);
				fill(0,255,0);
				box(2*100,10,1);
			popMatrix();
			pushMatrix();
				fill(0,0,0);
				translate(43,-238,1);
				text(score,10,10);
			popMatrix();
		  fill(255,255,255);
		  pushMatrix();
		    translate(0,780);
		    etheta+=PI/10000;
		    earth=createShape(SPHERE,700);
		    earth.setTexture(img3);
		    rotate(etheta);
		    shape(earth);
		  popMatrix();
		  pushMatrix();
		    translate(-250,-300,-200);
		    scale(2);
		    moon=createShape(SPHERE,20);
		    moon.setTexture(img4);
		    rotate(etheta*2);
		    shape(moon);
		  popMatrix();
		  pushMatrix();
		    translate(400,-300,-500);
		    mars=createShape(SPHERE,20);
		    mars.setTexture(img5);
		    rotateY(etheta*2);
		    shape(mars);
		  popMatrix();


		  for(int i=0;i<10;i++){
		    b[i].run();
		  }
		  if(keyPressed &&death==0){//ここ参考にした
		    if(key=='a' &&btime<0){
		      btime=5;
		      if(bnum==10){bnum=0;}
		      b[bnum++].changeflag(1);
		    }
		    btime--;
		  }
		  pushMatrix();
		  translate(-900,-950,-1200);
		  scale(6);
		  image(img2,0,0);
		  popMatrix();
			pushMatrix();
			for(int i=0;i<7;i++){
				e[i].run();
				eb[i].run(i);
			}
			popMatrix();
			pushMatrix();
				translate(map(mouseX, 0, width, -125, 125),map(mouseY, 0, height, -65, 65)-100,25);
				fill(255,255,255);
				rockon=createShape(BOX,20,20,0);
		    rockon.setTexture(img6);
				if(death==0)shape(rockon);
			popMatrix();
			for(int i=0;i<10;i++){
				for(int j=0;j<7;j++){
					if(pow(b[i].getx()-e[j].getx(),2)+pow(b[i].gety()-e[j].gety(),2)+pow(b[i].getz()-e[j].getz(),2)<pow(e[j].getr()+4.5f,2)){e[j].dead(); }
				}
		  }
			for(int i=0;i<7;i++){
				if(pow(eb[i].getx()-map(mouseX, 0, width, -125, 125),2)+pow(eb[i].gety()-map(mouseY, 0, height, -65, 65)+100,2)+pow(eb[i].getz()-120,2)<100 &&death==0){
					life-=5;
					if(life<0 &&life!=-0.001f){life=-0.001f; death=1; dx=map(mouseX, 0, width, -125, 125); dy=map(mouseY, 0, height, -65, 65)-100;}
				}
			}

			pushMatrix();
				if(death==0){translate(map(mouseX, 0, width, -125, 125),map(mouseY, 0, height, -65, 65)-100,120);}
				else{translate(dx,dy,120);}
		    rotateX(PI);
		    rotateY(-PI/2);
				scale(0.1f);
				fill(255,255,255);
				theta+=PI/6;
				if(death==0){drawosprey(theta);}
				else{
					pushMatrix();
						bomulife-=2;
						if(ospreyr<150){ospreyr++;}
						fill(255,0,0,bomulife);
						sphere(ospreyr);
					popMatrix();
				}
			popMatrix();

		}
  public void settings() { 	size(1000, 1000, P3D); 	smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "shoot" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
