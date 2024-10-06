/*
 * Written By Mason Allison
 */
import java.util.Scanner;
public class VideoGameManagerFE 
{
	private static Scanner keyboard = new Scanner(System.in);
	private static VideoGameManager videoGameManager = new VideoGameManager();//creates instance of VideoGameManager to access the methods in that class
	private static GenLL<VideoGame> lastSearchResults = new GenLL<VideoGame>();//creates and instance of a linked list
	public static void main(String[] args)
	{
		printGreeting();
		boolean quit = false;
		while(!quit)
		{
			printChoices();
			int choice = keyboard.nextInt();
			keyboard.nextLine();
			switch(choice)
			{
			case 1:
				ReadVideoGameFile();
				break;
			case 2:
				searchDataBase();
				break;
			case 3:
				videoGameManager.printResults(lastSearchResults);
				break;
			case 4:
				saveResultsToFile();
				break;
			case 0:
				quit=true;
				break;
				default:
					System.out.println("Invalid Input");
			}
		}
	}
	public static void printGreeting()
	{
		System.out.println("Welcome to Video Game Database");
	}
	public static void printChoices()
	{
		System.out.println("Enter 1 to load the video game data base\n"
				+ "Enter 2 to search the database\n"
				+ "Enter 3 to print current results to console\n"
				+ "Enter 4 to print current reuslts to file\n"
				+ "Enter 0 to quit");
	}
	public static void ReadVideoGameFile()
	{
		System.out.println("Enter the file name");
		String fileName = keyboard.nextLine();
		videoGameManager.readVideoGameFile(fileName);
	}
	private static void searchDataBase()
	{
		System.out.println("Enter the name of the game or '*' for all");
		String aName = keyboard.nextLine();
		System.out.println("Enter the name of the console or '*' for all");
		String aConsole = keyboard.nextLine();
		GenLL<VideoGame> results = videoGameManager.searchGame(aName, aConsole);
		videoGameManager.printResults(results);
		lastSearchResults = results;//assigns the results linkedlist to a linked list established outside this method so it can be accessed outside this method
	}
	public static void saveResultsToFile()
	{
		System.out.println("Enter the name of the file to save results to");
		String fileName = keyboard.nextLine();
		System.out.println("Do you want to append it? True or false");
		boolean append = keyboard.nextBoolean();
		videoGameManager.WriteVideoGameFile(fileName, append, lastSearchResults);
		
	}
}
