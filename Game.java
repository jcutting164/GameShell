import java.awt.Canvas;


import java.awt.Color;
import java.awt.Graphics;

import java.awt.geom.Ellipse2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;



public class Game extends Canvas implements Runnable{


    /**
     *
     */
    private static final long serialVersionUID  = -1300776496297261616L;


    // height is 960
    public static final float WIDTH = 1200, HEIGHT = 820;

    //temp

    private transient Thread thread;
    private boolean running = false;
    

    private Window window;
    private KeyInput keyInput;


    public Game() {

    	keyInput = new KeyInput(this);

        this.addKeyListener(keyInput);
        window = new Window(WIDTH, HEIGHT, "Battleship", this);



    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }



    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        }catch(Exception e) {
            e.printStackTrace();
        }
    }


    public void run() {

        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        while(running) {
            long now = System.nanoTime();
            delta += (now-lastTime) / ns;
            lastTime = now;
            while(delta >= 1) {
                tick();
                delta--;
            }
            if(running) {
                render();
            }

            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                //System.out.println("FPS: " + frames);
            }
        }
        stop();
    }


    private void tick() {
        try{
            

        }catch(Exception e){
            e.printStackTrace();
        }






    }

   

	private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();


        // renders the board
        Graphics2D g2d = (Graphics2D)g;
        
        
    	g.setColor(Color.black);
    	g.drawRect(860, 100, 256, 96);
    	g.drawRect(861,101,256,96);
    	g.drawRect(862,102,256,96);
    	g.drawRect(863,103,256,96);
        	
    	 g.dispose();
         bs.show();
        	
        	
        	
        }


       

	

    

    
	
	

	public static void main(String[] args) {
        new Game();

    }


}