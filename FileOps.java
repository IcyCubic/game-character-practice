/*
To-do:
Implement check to see if file exists, confirm overwrite.
*/

import java.io.*;
import java.util.*;

public class FileOps{
	private final String s = ",;,"; //separator for fields in the save file
	
	
	public void saveGame(Player p){ //saves the character to a file named according to the character name with fields separated by a comma
		int[] stats = p.getStats();
		
		try{
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(".\\save\\" + p.getName() + ".txt")));
			
			out.print(p.getName() + s + p.getRace() + s + p.getDescription() + s);
			for (int i = 0; i < stats.length; i++){
				if (i == stats.length - 1)
					out.print(stats[i]);
				else
					out.print(stats[i] + s);
			}
	//		out.println(";;;");

			out.close();
		}catch( IOException e){
			System.err.println(e);
		}
		System.out.printf("Character Saved as %s.txt! %n", p.getName());
	}
	
	public Player loadGame(){
		Player loaded = new Player();
		String charname;
		Scanner console = new Scanner(System.in);
		File test;
		
		do {		
			System.out.print("Enter the name of the character you wish to load: ");
			charname = console.nextLine();
			System.out.println();
			test = new File(".\\save\\" + charname + ".txt");
		
			if (test.exists() == false)
				System.out.println("Error: specified character's game file does not exist!");
		} while (!test.exists()); // Repeats until valid file name is obtained.
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(".\\save\\" + charname + ".txt"));
			String[] tokens = in.readLine().split(s); //updated method to stringtokenizer, splits string into parts
			int[] stats = new int[tokens.length - 3]; //stats
				
			loaded.setName(tokens[0]);
			loaded.setRace(tokens[1]);
			loaded.setDescription(tokens[2]);
		
			for (int i = 3; i < tokens.length; i++) //converts stats from string to int
				stats[i-3] = Integer.parseInt(tokens[i]);
		
			loaded.setStats(stats);	
				
		} catch (IOException e) {
			System.err.println(e);
		}
		
		System.out.println("Game loaded!");
		return loaded;
	}
}
