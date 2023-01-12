package com.sanketTest1.test1class1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sanketTest1.test1class1.game.gameRunner;
import com.sanketTest1.test1class1.game.gamingConsole;
import com.sanketTest1.test1class1.game.marioGame;
import com.sanketTest1.test1class1.game.pacmanGame;
import com.sanketTest1.test1class1.game.superContra;


public class App03GameApp {

	public static void main(String[] args) {
		
		// here we basically implemented spring context in our Gaming App.
		
		try(var context=new AnnotationConfigApplicationContext(GamingConfiguration.class)){
		
		context.getBean(gamingConsole.class).up(); // This is also how we can access the bean. And functions of its related interface.

		context.getBean(gameRunner.class).run();
		
		}	
	}
}