/** Level class (contains current level)*/
public class Level
{
  private int level; // Current level
  
  /** When the level object is created, sets the level based off which game type was identifeid in the menu.
  When a user chooses their game type, that game type is set to true, otherwise it is false*/
  public Level ()
  {
    if (Menu.easy) 
      level = 1;
    else if (Menu.medium)
      level = 6;
    else if (Menu.hard)
      level = 11;
  } // Constructor
 
  /** Returns the current level*/
  public int getLevel ()
  {
    return level;
  } // getLevel
 
  /** Sets the current level*/
  public void setLevel (int l)
  {
    level = l;
  } // setLevel
} // Level Class