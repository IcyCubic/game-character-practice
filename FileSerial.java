import java.io.*;
import java.util.Scanner;
//import java.util.regex.Pattern;

public class FileSerial{
	private	Scanner console = new Scanner(System.in);

	
	public void exportGame(Player p){
		File test = new File(".\\serial\\" + p.getName() + ".dat");
		String input;
		char overwrite = 'N'; 
		boolean loop = true;	
			
		while (loop == true) {
			if (test.exists()){
				System.out.printf(" *** %s.dat already exists! ***%n", p.getName());
				System.out.print("Do you wish to overwrite the file? (Y/N): ");
				input = console.nextLine();
				System.out.println();
				input = input.toUpperCase();
				overwrite = input.charAt(0);					
				if ((overwrite == 'Y' || overwrite == 'N') && input.length() == 1)
					loop = false;
				else
					System.out.println("Invalid Input!");
			}
			else
				loop = false;
		}
		if (overwrite == 'Y' || !test.exists()){
			try{
				ObjectOutputStream so = new ObjectOutputStream(new FileOutputStream(".\\serial\\" + p.getName() + ".dat"));
				so.writeObject(p);
				so.flush();
				so.close();
			} catch (Exception e){
				e.printStackTrace();
			}
			System.out.printf("Character file exported as: %s.dat! %n", p.getName());
		}
		else {
			System.out.println("Export aborted.");
		}			
	}
	
	public Player importGame(){
		Player temp = null;
		File test;
		String name;

		do {		
			System.out.print("Enter the name of the character you wish to import: ");
			name = console.nextLine();
			System.out.println();
			test = new File(".\\serial\\" + name + ".dat");
		
			if (test.exists() == false)
				System.out.println("Error: specified character's game file does not exist!");
		} while (!test.exists()); // Repeats until valid file name is obtained.

		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(".\\serial\\" + name + ".dat"));
			temp = (Player)in.readObject();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.printf("Character file (%s.dat) was imported!%n", name);
		return temp;		
	}
}
		
