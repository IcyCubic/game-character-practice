import java.io.*;
import java.util.*;

public class Player implements Serializable{
	private String name = "Unknown", race = "Unknown", description = "None Provided.";
	private int age = -1, level = -1, hp = -1, mp = -1, 
				      strength = -1, agility = -1, vitality = -1, intelligence = -1, wisdom = -1, luck = -1;
		
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getRace(){
		return race;
	}
	public void setRace(String race){
		this.race = race;
	}
	public String getDescription(){
		return description;
	}
	public void setDescription(String description){
		this.description = description;
	}
	
	public int[] getStats(){
		int[] stats = {age, level, hp, mp, strength, agility, vitality, intelligence, wisdom, luck};
		return stats;
	}
	public void setStats(int[] stats) throws IOException {
		if (stats.length == 10) {
			age = stats[0];
			level = stats[1];
			hp = stats[2];
			mp = stats[3];
			strength = stats[4];
			agility = stats[5];
			vitality = stats[6];
			intelligence = stats[7];
			wisdom = stats[8];
			luck = stats[9];
		}
		else
			throw new IOException("Invalid stats.");
	}	
	
	public void genesis(){
		Random ran = new Random();
		int sumstats;
	
		do{
			strength = 1 + ran.nextInt(10);
			agility = 1 + ran.nextInt(10);
			vitality = 1 + ran.nextInt(10);
			intelligence = 1 + ran.nextInt(10);
			wisdom = 1 + ran.nextInt(10);
			luck = 1 + ran.nextInt(10);
			sumstats = strength + agility + vitality + intelligence + wisdom + luck;
		} while
(sumstats != 35);	
		
		age = 1 + ran.nextInt(99);
		level = 1;
		hp = (10 * vitality) + (5 * strength) + (2 * ran.nextInt(luck)) + ( age <=35 ? + age : 70-age);
		mp = (7 * intelligence) + (5 * wisdom) + (3 * ran.nextInt(luck)) + ( age < 40 ? + age : 2*age);
	} 
	
	public void display () {
		System.out.println("**************************************************");
		System.out.printf (" Character Name: %s %n", name);
		System.out.printf (" Race: %s  Age: %d %n", race, age);
		System.out.printf (" Description: %s %n", description);
		System.out.println("**************************************************");
		System.out.printf (" Level: %d %n HP: %d  MP: %d %n", level, hp, mp);		
		System.out.println("**************************************************");		
		System.out.printf (" STR: %d  INT: %d %n", strength, intelligence);
		System.out.printf (" AGI: %d  WIS: %d %n", agility, wisdom);
		System.out.printf (" VIT: %d  LUK: %d %n", vitality, luck);


		
	}	
}
