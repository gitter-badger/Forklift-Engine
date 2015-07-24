package com.makerimages.forklift.render;

import com.makerimages.forklift.Forklift;
import com.makerimages.forklift.Main;

import com.sun.javafx.geom.Vec3f;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.*;

import java.nio.ByteBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;


public class FirstPersonCamera extends Camera {

	public FirstPersonCamera(float x, float y, float z) {
		init(x,y,z);
	}

	private void init(float x, float y, float z) {
		glMatrixMode(GL_PROJECTION); 
        glLoadIdentity();
       
        
		gluPerspective(45.0f,(float)Display.getWidth()/(float)Display.getHeight(),0.1f, 100.0f);
		glEnable(GL_DEPTH_TEST);
		glMatrixMode(GL_MODELVIEW);
		
		this.position = new Vector3f(x,y,z);
		
	}
	
	//increment the camera's current yaw rotation
	public void yaw(float amount)
	{
	    //increment the yaw by the amount param
	    yaw += amount;
	}
	 
	//increment the camera's current yaw rotation
	public void pitch(float amount)
	{
	    //increment the pitch by the amount param
	    pitch += amount;
	}
	
	//Movement
	
	public void walkForward(float distance)
	{
	    position.x -= distance * (float)Math.sin(Math.toRadians(yaw));
	    position.z += distance * (float)Math.cos(Math.toRadians(yaw));
	}
	 
	//moves the camera backward relative to its current rotation (yaw)
	public void walkBackwards(float distance)
	{
	    position.x += distance * (float)Math.sin(Math.toRadians(yaw));
	    position.z -= distance * (float)Math.cos(Math.toRadians(yaw));
	}
	 
	//strafes the camera left relitive to its current rotation (yaw)
	public void strafeLeft(float distance)
	{
	    position.x -= distance * (float)Math.sin(Math.toRadians(yaw-90));
	    position.z += distance * (float)Math.cos(Math.toRadians(yaw-90));
	}
	 
	//strafes the camera right relitive to its current rotation (yaw)
	public void strafeRight(float distance)
	{
	    position.x -= distance * (float)Math.sin(Math.toRadians(yaw+90));
	    position.z += distance * (float)Math.cos(Math.toRadians(yaw+90));
	}
	
	@Override
	public void lookTrough() {
		glLoadIdentity();
		glRotatef(pitch, 1.0f, 0.0f, 0.0f);
		glRotatef(yaw, 0.0f,1.0f,0.0f);
		glTranslatef(position.x, position.y,position.z);
	}
	
	
}
