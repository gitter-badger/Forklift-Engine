package com.makerimages.forklift.management;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.json.JSONObject;

import sun.misc.IOUtils;

public class ForkliftSceneManager {
	public ArrayList <ForkliftScene> gameScenes;
	public int active = 0;
	
	public ForkliftSceneManager() {
		gameScenes = new ArrayList <ForkliftScene> ();
		gameScenes.clear();
	}
	
	public void parseToScenes(String sceneRoot) {
		System.out.println("Parsing Scenes to Forklift from "+sceneRoot);
		ArrayList <File> sceneFolders;
		
		File sceneRootDirectory = new File(sceneRoot);
		
		File[] tmp= sceneRootDirectory.listFiles();
		sceneFolders = new ArrayList<File>(Arrays.asList(tmp));
		
		ArrayList <File> nonScenes = new ArrayList<File>();
		
		System.out.println("Found "+sceneFolders.size()+" scene canditates");
		for(File sceneFile : sceneFolders ) {
			if(!sceneFile.isDirectory()) {
				System.err.println(sceneFile.getName()+" Is not a Scene directory, adding to remove list.");
				nonScenes.add(sceneFile);
			}
		}
		
		for(File remove : nonScenes) {
			sceneFolders.remove(remove);
			System.err.println("Removing "+remove.getName()+" from scenes. Is not a DIR.");
		}
		
		System.out.println("Left with "+sceneFolders.size()+" scenes");
		
		for(File sceneFolder : sceneFolders) {
			File sceneDefinition = new File(sceneFolder.getPath()+"/define.scn");
			System.out.println("Parsing "+sceneDefinition.getAbsolutePath());
			String scene ="";
			try {
				Scanner in = new Scanner(new FileReader(sceneDefinition));
				while(in.hasNext()) {
					scene = scene+in.nextLine();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Do scene file -> JSON parsing here
			
			JSONObject sceneObject = new JSONObject(scene);
			gameScenes.add(new ForkliftScene(sceneObject.getString("name"),sceneObject.getInt("camType"),sceneObject.getJSONObject("camPos")));
		}
	}
	
	public void render() {
		gameScenes.get(active).render();
	}
}
