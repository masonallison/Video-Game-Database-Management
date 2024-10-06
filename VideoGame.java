/*
 * Written By Mason Allison
 */
public class VideoGame 
{
	private String name;
	private String console;
	
	public VideoGame()
	{
		this.name=this.console="none";
	}
	public VideoGame(String aName,String aConsole)
	{
		this.setName(aName);
		this.setConsole(aConsole);
	}
	public String getName()
	{
		return this.name;
	}
	public String getConsole()
	{
		return this.console;
	}
	public void setName(String aName)
	{
		if(aName != null)
			this.name = aName;
		else
			this.name="none";
	}
	public void setConsole(String aConsole)
	{
		if(aConsole !=null)
			this.console = aConsole;
		else
			this.console = "none";
	}
	public boolean equals(VideoGame aVideoGame)
	{
		return aVideoGame !=null &&
				this.name.equals(aVideoGame.getName()) &&
				this.console.equals(aVideoGame.getConsole());
	}
	public String toString()
	{
		return this.name+"\t"+this.console;
	}
}
