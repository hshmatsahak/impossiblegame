import java.awt.Image; // Used for creating images
import javax.swing.ImageIcon; // Used for loading images from files
import java.io.*; // Used for opening files
import java.util.*; // Used for scanning files

/** MazeLayout class (Contains the maze images in the maze and the file data for the current level's maze)*/
public class MazeLayout
{
  //Initialize variables
  private Scanner in; // File scanner
  private Image floor, wall, zone, barrier; // Relevant images
  private ArrayList <String> MazeLayout = new ArrayList (); // Arraylist of strings containing level data (each row corresponds to each element)
  
  private int level; // Current level
  
  /** When the MazeLayout object is created, acquries the images and gets the file data for the current level*/
  public MazeLayout ()
  {
    //Maze Floor image
    ImageIcon img = new ImageIcon ("Game Components\\Visual Components\\floor.png");
    floor = img.getImage ();
    
    //Maze Wall Image
    img = new ImageIcon ("Game Components\\Visual Components\\wall.png");
    wall = img.getImage ();
    
    //Maze Start-End Zone Image
    img = new ImageIcon ("Game Components\\Visual Components\\zone.png");
    zone = img.getImage ();
  
    //Maze Barrier Image
    img = new ImageIcon ("Game Components\\Visual Components\\barrier.png");
    barrier = img.getImage ();
  
    if (Menu.easy) // If the game type is set to easy in the menu (Menu.easy would thus be true), acquires the Easy level
      level = Easy.level;
    else if (Menu.medium) // If the game type is set to medium in the menu (Menu.medium would thus be true), acquires the Medium level
      level = Medium.level;
    else if (Menu.hard) // If the game type is set to easy in the menu (Menu.hard would thus be true), acquires the Hard level
      level = Hard.level;
  
    //Call files to read, process, and store information from text files
    openFile ();
    readFile ();
    closeFile ();
  } // Constructor
  
  /** Attempt to open file of chosen level*/
  public void openFile ()
  {
    try
    {   
      in = new Scanner (new File ("Game Components\\Levels\\level" + level + ".txt"));
    } // try to open file
    catch (Exception e)
    {
      System.out.println (level);
    } // catch exceptions
  } // openFile
  
  /** Attempt to read file*/
  public void readFile ()
  {
    while (in.hasNext ()) // Assigns each line to each array in the MazeLayout
      MazeLayout.add (in.next ());
  }//end readFile
  
  /** Close level file*/
  public void closeFile ()
  {
    in.close ();
  } // closeFile
  
  /** Returns the floor image*/
  public Image getFloor ()
  {
    return floor;
  } // getFloor
  
  /** Returns the wall image*/
  public Image getWall ()
  {
    return wall;
  } // getWall
  
  /** Returns the zone image*/
  public Image getZone ()
  {
    return zone;
  } // getZone
  
  /** Returns the barrier image*/
  public Image getBarrier ()
  {
    return barrier;
  } // getBarrier

  /** Returns the number of rows in the maze*/
  public int getRow ()
  {
    return MazeLayout.size ();
  } // getRow
  
  /** Returns the letter in a particular row and column (even though this method returns a string, it will still just return a one-lettered string)*/
  public String getMazeTile (int x, int y)
  {
    return MazeLayout.get (y).substring (x, x+1);
  } // getMazeTile
  
  /** Sets the letter in a particular row and column*/
  public void setMazeTile (int x, int y, String c)
  {
    MazeLayout.set (y, MazeLayout.get (y).substring (0,x) + c + MazeLayout.get (y).substring (x+1));
  } // setMazeTile
} // MazeLayout class