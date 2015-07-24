package com.makerimages.forklift;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.*;

import com.makerimages.forklift.management.ForkliftSceneManager;

import java.nio.ByteBuffer;
 
import static org.lwjgl.opengl.GL11.*;

 

public class Forklift {
	

	private String title;
	public int WIDTH, HEIGHT;
	
	public static ForkliftSceneManager sceneManager;
	
	public Forklift(String title, int width, int height) {
		this.title = title;
		this.WIDTH = width;
		this.HEIGHT = height;
		
		this.sceneManager = new ForkliftSceneManager();
			
		
	}
	
	public void init() {
		try {
			Display.setDisplayMode(new DisplayMode(this.WIDTH,this.HEIGHT));
			Display.setTitle(this.title);
			Display.create();
			
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
        this.sceneManager.parseToScenes("data/scenes");
        loop();
	}
	
	private void loop() {
		
		while (!Display.isCloseRequested()) {
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			this.sceneManager.render();
             
            Display.update();
            Display.sync(60);
        }
         
        Display.destroy();
		
	}
}
