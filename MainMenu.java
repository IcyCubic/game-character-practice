import java.util.Scanner;

public class MainMenu{
	private Scanner console = new Scanner(System.in);		
	private ArraySorter tool = new ArraySorter();
	private final char[] choices = {'C', 'D', 'S', 'L', 'I', 'E', 'Q'};
	private char pick = 'Z';

	
	public char choose(){
		String input;		
		boolean isValid;

		do {
			isValid = false;
			
			System.out.println();		
			System.out.println("**********************************");
			System.out.println("* 1. (C)reate New Character      *");
			System.out.println("* 2. (D)isplay Character         *");
			System.out.println("*                                *");
			System.out.println("* 3. (S)ave Character            *");
			System.out.println("* 4. (L)oad Character            *");
			System.out.println("*                                *");
			System.out.println("* 5. (I)mport Character          *");
			System.out.println("* 6. (E)xport Character          *");
			System.out.println("*                                *");
			System.out.println("* 7. (Q)uit                      *");
			System.out.println("*                                *");
			System.out.println("**********************************");
			System.out.print("Pick an option (C, D, S, L, I, E, Q): ");
			
			input = console.nextLine();
			System.out.println();

			input = input.toUpperCase();
			pick = input.charAt(0);
			
			if (input.length() != 1 || tool.searchChar(choices, pick) == -1 ) {
				System.out.println("Invalid input, please input a valid choice.\n");
				continue;
			}
			else
				isValid = true;
				
		
		} while (isValid == false);
		
		return pick;
	}
}
