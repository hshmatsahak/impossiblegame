import java.awt.Image; // Used for creating images
import javax.swing.ImageIcon; // Used for loading images from files

/** Obstacle class (contains the obstacle image, the number of balls at certain levels, and the position of balls on level 1)*/
public class Obstacle
{
  private int numBalls; // Image array of balls
  private Image ball; // Singular ball image
  
  // Level 1 x,y positions of balls
  private int[] tilesUp = {5,7,9,11,13,15}; 
  private int[] tilesDown = {6,8,10,12,14,16};
  
  private int level; // Current level
  
  /** When the obstacle object is created, acquires the obstacle image and sets the obstacles properties based on the level*/
  public Obstacle ()
  {
    ImageIcon img = new ImageIcon ("Game Components\\Visual Components\\ball.png");
    ball = img.getImage ();
    
    if (Menu.easy)  // If the game type is set to easy in the menu (Menu.easy would thus be true), acquires the Easy level
      level = Easy.level;
    
    switch (level) // Assings number of obstacles based on the Easy level
    {
      case 1: // 6 obstacles for level 1
        numBalls = 6; break;
      case 2: // 5 obstacles for level 2
        numBalls = 5; break;
      case 3: // 3 obstacles for level 3
      numBalls = 3; break;
      case 4: // 8 obstacles for level 4
        numBalls = 8; break;		
      case 5: // 1 obstacle for level l5
        numBalls = 1; break;
    } // Switch case based on level
  } // Constructor
  
  /** Returns the number of balls (which is assigned based on the level the constructor acquired)*/
  public int getNumBalls ()
  {
    return numBalls;
  } // getBalls
  
  /** Returns the Level 1 positions of balls in the 1,3,5... columns since they all are balls that are aligned*/
  public int[] getTilesUp ()
  {
    return tilesUp;
  } // getTilesUp
  
  /** Returns the Level 1 positions of balls in the 2,4,6... columns since they all are balls that are aligned*/
  public int[] getTilesDown ()
  {
    return tilesDown;
  } // getTilesDown
  	
  /** Returns the ball image*/
  public Image getBall ()
  {
    return ball;
  } //getBall
} // Obstacle class