/*
To-do:
Sanitize user input for invalid characters
*/

import java.util.Scanner;

public class CharCreation{
	
	public Player createNew(){
		Scanner console = new Scanner(System.in);
		Player player = new Player();
		String pName;
		
		System.out.print("Please enter your name: ");
		pName = console.nextLine();
		player.setName(pName);
		System.out.println();
		
		System.out.printf("Please select %s's race: ", pName);
		player.setRace(console.nextLine());
		System.out.println();
		
		System.out.printf("Please enter %s's description: ", pName);
		player.setDescription(console.nextLine());
		System.out.println();
		
		player.genesis();
	//	player.genesis(player);
		player.display();
		
		return player;
	}
}
