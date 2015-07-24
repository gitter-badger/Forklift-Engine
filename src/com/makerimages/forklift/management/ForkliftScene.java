package com.makerimages.forklift.management;

import org.json.JSONObject;
import static org.lwjgl.opengl.GL11.*;

import com.makerimages.forklift.render.Camera;
import com.makerimages.forklift.render.FirstPersonCamera;

public class ForkliftScene {
	
	public String name;
	private Camera sceneCamera;
	
	public ForkliftScene(String sceneName, int camera_type, JSONObject cameraLocation) {
		this.name = sceneName;
		
		switch(camera_type) {
			case 1:
				this.sceneCamera = new FirstPersonCamera(cameraLocation.getInt("x"),cameraLocation.getInt("y"),cameraLocation.getInt("z"));
		}
	}
	
	public void render() {
		
		this.sceneCamera.lookTrough();

		glBegin(GL_QUADS);    
			glColor3f(1.0f,1.0f,0.0f);           
			glVertex3f( 1.0f, 1.0f,-1.0f);        
			glVertex3f(-1.0f, 1.0f,-1.0f);        
			glVertex3f(-1.0f, 1.0f, 1.0f);
			glVertex3f( 1.0f, 1.0f, 1.0f);  
			glColor3f(1.0f,0.5f,0.0f);            
			glVertex3f( 1.0f,-1.0f, 1.0f);
			glVertex3f(-1.0f,-1.0f, 1.0f);
			glVertex3f(-1.0f,-1.0f,-1.0f);
			glVertex3f( 1.0f,-1.0f,-1.0f);
			glColor3f(1.0f,0.0f,0.0f);
			glVertex3f( 1.0f, 1.0f, 1.0f);
			glVertex3f(-1.0f, 1.0f, 1.0f);
			glVertex3f(-1.0f,-1.0f, 1.0f);
			glVertex3f( 1.0f,-1.0f, 1.0f);
			glColor3f(1.0f,1.0f,0.0f);
			glVertex3f( 1.0f,-1.0f,-1.0f);
			glVertex3f(-1.0f,-1.0f,-1.0f);
			glVertex3f(-1.0f, 1.0f,-1.0f);
			glVertex3f( 1.0f, 1.0f,-1.0f);
			glColor3f(0.0f,0.0f,1.0f);
			glVertex3f(-1.0f, 1.0f, 1.0f);
			glVertex3f(-1.0f, 1.0f,-1.0f);
			glVertex3f(-1.0f,-1.0f,-1.0f);
			glVertex3f(-1.0f,-1.0f, 1.0f);
			glColor3f(1.0f,0.0f,1.0f);
			glVertex3f( 1.0f, 1.0f,-1.0f);
			glVertex3f( 1.0f, 1.0f, 1.0f);
			glVertex3f( 1.0f,-1.0f, 1.0f);
			glVertex3f( 1.0f,-1.0f,-1.0f);
		glEnd();    


	}

}
