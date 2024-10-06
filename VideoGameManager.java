/*
 * Written By Mason Allison
 */
import java.util.Scanner;
import java.io.*;
public class VideoGameManager 
{
	public static final String DELIM="\t";
	
	private GenLL<VideoGame> videoGame;
	private GenLL<VideoGame> results;
	public VideoGameManager()
	{
		videoGame = new GenLL<VideoGame>();
		results = new GenLL<VideoGame>();
	}
	public void addVideoGame(VideoGame aVideoGame)
	{
		videoGame.add(aVideoGame);
		results.add(aVideoGame);
	}
	public void readVideoGameFile(String aName)
	{
		try
		{
			Scanner fileScanner = new Scanner(new File(aName));
			while(fileScanner.hasNextLine())
			{
				String fileLine = fileScanner.nextLine();
				String[] splitLines = fileLine.split("\t");
				if(splitLines.length!=2)
				{
					continue;
				}
				else
				{
					String name = splitLines[0];
					String console = splitLines[1];
					VideoGame aVideoGame = new VideoGame(name,console);//creates a new instance of a videogame with the strings from the split file
					this.addVideoGame(aVideoGame);//adds the new instance to the linked list
				}
			
			}
			fileScanner.close();
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void WriteVideoGameFile(String fileName, boolean append,GenLL<VideoGame> results)
    {
        if(videoGame == null)//if the file name is null then return
            return;
        try
        {
            PrintWriter fileWriter = new PrintWriter(new FileOutputStream(fileName,append));
            results.reset();
            while(results.hasMore())
            {
                VideoGame aVideoGame = results.getCurrent();
                fileWriter.println(aVideoGame.getName()+DELIM+aVideoGame.getConsole());
                results.gotoNext();
            }
            fileWriter.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
	
	public GenLL<VideoGame> searchGame(String aName, String aConsole)//returns a generic linked list with the type VideoGame
	{
		GenLL<VideoGame> results = new GenLL<VideoGame>();
		for(int i=0;i<videoGame.getSize();i++)
		{
			VideoGame aGame = videoGame.getAt(i);
			boolean nameMatch = aName.equals("*") || aGame.getName().toLowerCase().contains(aName.toLowerCase());
			boolean consoleMatch = aConsole.equals("*") || aGame.getConsole().toLowerCase().contains(aConsole.toLowerCase());
			if(nameMatch && consoleMatch)
			{
				results.add(aGame);
			}
		}
		
		return results;
	}
	public void printResults(GenLL<VideoGame> results) 
	{
		
		for (int i = 0; i < results.getSize(); i++) 
        {
            System.out.println(results.getAt(i).toString());//calls the methods getAt so we can have random access and uses to string to print the data at those nodes
        }
    }
	public void printResultsToFile(GenLL<VideoGame> results, String fileName, boolean append) 
	{
	   try
	   {
		  results.reset();//Starts the list over so it prints the whole list
		  PrintWriter fileWriter = new PrintWriter(new FileOutputStream(fileName,append));
		  for(int i=0;i<results.getSize();i++)
		  {
			  fileWriter.println(results.getAt(i).toString());//prints the results to the file
		  }
	   
	   fileWriter.close();
	   }
	   catch(Exception e) 
	   {
		   e.printStackTrace();
	   }
	}
	public void printVideoGames()
	{
		videoGame.print();
	}
}
