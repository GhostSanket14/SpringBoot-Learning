package com.sanketTest1.test1class1;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Bean;

import com.sanketTest1.test1class1.game.gameRunner;
import com.sanketTest1.test1class1.game.gamingConsole;
import com.sanketTest1.test1class1.game.marioGame;
import com.sanketTest1.test1class1.game.pacmanGame;

@Configuration
public class GamingConfiguration {
	
	@Bean
	public gamingConsole game() {
		var game=new pacmanGame(); // This is what 'context.getBean(gamingConsole.class).up();' on App03 is using.
		return game; // Basically it accessing up() of packmanGame class.
	}
	@Bean
	@Primary
	public gamingConsole game1() {
		var game=new marioGame(); // This is what 'context.getBean(gamingConsole.class).up();' on App03 is using.
		return game; // Basically it accessing up() of marioGame class.
	}	
	@Bean
	public gameRunner gameRun(gamingConsole gameX) { // Here we are wiring the above bean. As we learn't before here the name 'gamingConsole, is injected/Wired of above function.
		var gameRunner=new gameRunner(gameX); 	// Remember during injection, bean type is considered, not name. Name can be anything. (Also if there are many use @Primary)
		return gameRunner;
	}
}
// This is class for configuring the GamningApp with spring framework.