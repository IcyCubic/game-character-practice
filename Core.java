/*
Holiday Side Project - RPG Emulator

Capabilities:
*Interfaced racial profiles (not yet done)
*Capability to save and load
-via text
-via serialization
*Strict(er?) permissions
Creates player Profile
input error filtering

HTML
Homepage
Log in
Profile


Options menu
-Save
-Load
-Export
-Import
-Create
display
loop until quit
*/

public class Core {
	public static void main(String[] args){
		MainMenu main = new MainMenu();
		FileOps fileOps = new FileOps();
		FileSerial serial = new FileSerial();
		CharCreation creator = new CharCreation();
		Player player = null;
		boolean quit = false;
		
		do{
			switch (main.choose()){
				case 'C':
					player = creator.createNew();
					break;		
				case 'D':
					if (player == null) {
						System.out.println("There is nothing to display!");
						break;
					}
					player.display();
					break;		
	  		case 'S':
					fileOps.saveGame(player);
					break;
				case 'L':
					player = fileOps.loadGame();
					break;
				case 'E':
					serial.exportGame(player);
					break;
				case 'I':
					player = serial.importGame();
					break;
				case 'Q':
					quit = true;
					break;		
				default:
					System.out.println("Invalid input! (This should never happen!)");
				}
		} while (quit == false);		
	}
}
