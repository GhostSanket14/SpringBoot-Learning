package com.sanketTest1.test1class1;

import com.sanketTest1.test1class1.game.gameRunner;
import com.sanketTest1.test1class1.game.marioGame;
import com.sanketTest1.test1class1.game.pacmanGame;
import com.sanketTest1.test1class1.game.superContra;

public class App01GameApp {

	public static void main(String[] args) {
	
// ITERATION 1		
//		var MarioGameObj=new marioGame(); // We are using 'var' as it automatically detect datatype. 
//		var SuperContraObj=new superContra();
		
//		var GameRunnerObjMario=new gameRunner(MarioGameObj);
//		GameRunnerObjMario.run();
//		var GameRunnerObjContra=new gameRunner(SuperContraObj);
//		GameRunnerObjContra.run();
		
// ITERATION 2
	
//		marioGame game=new marioGame();
//		superContra game=new superContra();
		pacmanGame game=new pacmanGame();
		gameRunner GameRunnerObj=new gameRunner(game);
		// Here we are wiring/Injecting Dependency 'game' into gameRunner.  
		GameRunnerObj.run();
	}
}