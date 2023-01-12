package com.sanketTest1.test1class1.game;

public class gameRunner {

// ITERATION 1 - Tight coupling	
//	marioGame game; // This empty is object of class marioGame. we will assign it values below.
//	superContra game1;
//	public gameRunner(marioGame game){
//		this.game=game;
//	}
//	public gameRunner(superContra game){
//		this.game1=game;
//	}	

// ITERATION 2 - Loose coupling
gamingConsole game; // We are creating variables of interface and not objects. (Cant create object if interface)
public gameRunner(gamingConsole game) { //Variable of interface allows us to use classes that have implemented this interface with peace of mind.
	this.game=game;				// Basically object that will be passes will be of class that have implemented this interface.
} // Imagine above like this, this.game=packman;
  // 						  it means this.game is basically a pointer to passed game. 					
  // 				look below comment for clear idea.	
	public void run() {
		System.out.println("Running passed game : "+game);
		game.up();
		game.down();
		game.left();
		game.right();
		// This can be visualized as packman.up(); etc
	}
}