package com.makerimages.forklift.render;

import org.lwjgl.util.vector.Vector3f;

public class Camera {
	
	
	
	 //3d vector to store the camera's position in
   public  Vector3f    position    = null;
   //the rotation around the Y axis of the camera
   protected float       yaw         = 0.0f;
   //the rotation around the X axis of the camera
   protected float       pitch       = 0.0f;
   
	
	public Camera() {}
	
	public void init(){};
	
	public void update() {};
	
	public void lookTrough() {};
}
