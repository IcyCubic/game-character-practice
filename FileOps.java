import java.io.*;
import java.util.*;

public class FileOps{
	private final String s = ",;,"; //separator for fields in the save file
	private Scanner console = new Scanner(System.in);
	
	//saves the character to a file named according to the character name with fields separated by a comma
	public void saveGame(Player p){ 
		int[] stats = p.getStats();
		File test = new File(".\\save\\" + p.getName() + ".txt");
		String input;
		char overwrite = 'N'; 
		boolean loop = true;	
			
		while (loop == true) { // Existing file overwrite check
			if (test.exists()){
				System.out.printf(" *** %s.txt already exists! ***%n", p.getName());
				System.out.print("Do you wish to overwrite the file? (Y/N): ");
				input = console.nextLine();
				System.out.println();
				input = input.toUpperCase();
				overwrite = input.charAt(0);					
				if ((overwrite == 'Y' || overwrite == 'N') && input.length() == 1) //valid input check
					loop = false;
				else
					System.out.println("Invalid Input!");
			}
			else
				loop = false;
		}
		
		if (overwrite == 'Y' || !test.exists()){ // overwrite or if file does not already exist
			try{
				PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(".\\save\\" + p.getName() + ".txt")));
			
				out.print(p.getName() + s + p.getRace() + s + p.getDescription() + s);
				for (int i = 0; i < stats.length; i++){
					if (i == stats.length - 1)
						out.print(stats[i]);
					else
						out.print(stats[i] + s);
				}
				out.close();
			}catch( IOException e){
				System.err.println(e);
			}
			System.out.printf("Character Saved as %s.txt! %n", p.getName());
		}
		else
			System.out.println("Save aborted!");
	}
	
	public Player loadGame(){
		Player loaded = new Player();
		String charname;
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
