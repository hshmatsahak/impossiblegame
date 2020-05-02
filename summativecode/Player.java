import java.awt.Image; // Used for creating images
import javax.swing.ImageIcon; // Used for loading images from files

/** Player class (contains the player image and the x and y positions of the player)*/
public class Player
{
  private Image player; // Player image
  private int tileX, tileY; // The x,y positions of player
 
  private int level; // Current level
 
  /** When the player object is created, acquires the player image and sets the player position based on the current level*/
  public Player ()
  {
    ImageIcon img = new ImageIcon("Game Components\\Visual Components\\player.png");
    player = img.getImage();
    
    if (Menu.easy) // If the game type is set to easy in the menu (Menu.easy would thus be true), acquires the Easy level
      level = Easy.level;
    else if (Menu.medium) // If the game type is set to medium in the menu (Menu.medium would thus be true), acquires the Medium level
      level = Medium.level;
    else if (Menu.hard) // If the game type is set to easy in the menu (Menu.hard would thus be true), acquires the Hard level
      level = Hard.level;
    
    switch (level) // Assigns the player's starting x and y positions based on the level
    {
      case 1: tileX = 3; tileY = 5; break;
      case 2: tileX = 8; tileY = 2; break;
      case 3: tileX = 3; tileY = 3; break;
      case 4: tileX = 2; tileY = 2; break;
      case 5: tileX = 2; tileY = 2; break;
      case 6: tileX = 8; tileY = 7; break;
      case 7: tileX = 2; tileY = 4; break;
      case 8: tileX = 22; tileY = 8; break;
      case 9: tileX = 10; tileY = 9; break;
      case 10: tileX = 8; tileY = 7; break;
      case 11: tileX = 1; tileY = 6; break;
      case 12: tileX = 7; tileY = 7; break;
      case 13: tileX = 1; tileY = 1; break;
      case 14: tileX = 1; tileY = 1; break;
      case 15: tileX = 1; tileY = 4; break;
    } // Switch case based on level
  } // Constructor
  
  /** Returns the player image*/
  public Image getPlayer ()
  {
    return player;
  } // getPlayer
  
  /** Sets the x position of the player*/
  public void setTileX (int x) 
  {
    tileX = x;
  } // setTileX
  
  /** Sets the y position of the player*/
  public void setTileY (int y)
  {
    tileY = y;
  } // setTileY
  
  /** Gets the x position of the player*/
  public int getTileX()
  {
    return tileX;
  } // getTileX
  
  /** Gets the y position of the player*/
  public int getTileY()
  {
    return tileY;
  } // getTileY
  
  /** Moves the player a given amount in the x and y directions*/
  public void move (int dx, int dy)
  {
    tileX += dx;
    tileY += dy;
  } // move
} // Player class
 