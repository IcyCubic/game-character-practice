import java.io.*;
import java.util.Scanner;

public class FileSerial{
	
	public void exportGame(Player p){
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
	
	public Player importGame(){
		Player temp = null;
		Scanner console = new Scanner(System.in);
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
		
