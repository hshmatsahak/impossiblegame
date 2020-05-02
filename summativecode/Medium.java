import java.awt.*; // Used for GUI
import java.awt.event.*; // Used for GUI
import javax.swing.*; // Used for GUI
import java.util.Scanner; // Used for File scanning
import java.io.*; // Used for File I/O
import sun.audio.*; // Used for Audio
import javax.sound.sampled.AudioInputStream; // Used for Audio
import javax.sound.sampled.AudioSystem; // Used for Audio
import javax.sound.sampled.Clip; // Audio
import javax.sound.sampled.LineUnavailableException; // Used for Audio
import javax.sound.sampled.UnsupportedAudioFileException; // Used for Audio

/** The frame where everything related to the game in Medium mode is contained*/
public class Medium
{
 // Components for file reader and writer
 /**File scanner that gets an account's level and deaths*/Scanner scanFile; 
 /**Print writer that edits an account's death file*/PrintWriter outFile;
 // Data fields used in multiple methods
 /**Account username*/static String username = Menu.username;
 /**Level object*/static Level levi = new Level();
 /**Whether account was loaded or not*/static boolean isLoad = Menu.isLoad;
 /**Account's current number of deaths*/public int death;
 /**Account's current level*/static int level;
 
 // Medium class GUI
 private JLabel lblDeath;
 private JFrame f;
 
 /** Constructs the gaming frame and inside that is the game UI and the maze inside (the maze and all actions performed in there is done using using DrawMaze)*/
 public Medium ()
 {
  try // Try where account's level and death files are scanned
  {
   if (!Menu.cheat) // The account being a cheat or not determines the level file name
    scanFile = new Scanner(new File("Game Components\\Player Components\\Player Levels\\" + username + "-Level.txt"));
   else
    scanFile = new Scanner(new File("Game Components\\Player Components\\Player Levels\\" + username + "-CheatLevel.txt"));
   level = scanFile.nextInt();
   Scanner scanFile = new Scanner(new File("Game Components\\Player Components\\Player Deaths\\" + username + "-Death.txt"));
   death = scanFile.nextInt();
  } // Try where account's level and death files are scanned
  catch (FileNotFoundException i) // catch if files can't be scanned
  {
   level = levi.getLevel();
   death = 0;
  } // catch if files can't be scanned
  
  // Create frame
  f = new JFrame();
  f.setTitle("Maze Game");
  // Create main panel
  JPanel canvas = new JPanel();
  canvas.setLayout(new BoxLayout(canvas, BoxLayout.Y_AXIS));
  
  // Create top header of game (has game mode, level, and death count)
  JPanel pnl = new JPanel();
  pnl.setLayout(new BoxLayout(pnl, BoxLayout.X_AXIS));
  pnl.setBackground(Color.BLACK);
  // "MODE: EASY" Label
  JLabel lbl = new JLabel();
  lbl.setForeground(Color.WHITE);
  lbl.setText("MODE: MEDIUM");
  lbl.setFont(new Font("Calibri", Font.BOLD, 25));
  // Level Label
  JLabel lblLevel = new JLabel();
  lblLevel.setForeground(Color.WHITE);
  lblLevel.setText((level - 5) + " / 5");
  lblLevel.setFont(new Font("Calibri", Font.BOLD, 25));
  // Death count label
  lblDeath = new JLabel();
  lblDeath.setForeground(Color.WHITE);
  lblDeath.setText("DEATHS:  " + death);
  lblDeath.setFont(new Font("Calibri", Font.BOLD, 25));

  switch (level)  // Switch case based on level where header and main frame dimensions are set based on the level
  {
   case 6: // Medium Level 1 header and main frame dimensions
    pnl.setPreferredSize(new Dimension(593, 30));
    lbl.setPreferredSize(new Dimension(125, 30));
    lblLevel.setPreferredSize(new Dimension(35, 30));
    lblDeath.setPreferredSize(new Dimension(150, 30));
    pnl.add(lbl);
    pnl.add(Box.createRigidArea(new Dimension(97, 0)));
    pnl.add(lblLevel);
    pnl.add(Box.createRigidArea(new Dimension(97, 0)));
    pnl.add(lblDeath);
    pnl.add(Box.createRigidArea(new Dimension(10, 0)));
    f.setSize(593, 583);
    break;
   
   case 7: // Medium Level 2 header and main frame dimensions
    pnl.setPreferredSize(new Dimension(785, 30));
    lbl.setPreferredSize(new Dimension(125, 30));
    lblLevel.setPreferredSize(new Dimension(35, 30));
    lblDeath.setPreferredSize(new Dimension(150, 30));
    pnl.add(lbl);
    pnl.add(Box.createRigidArea(new Dimension(205, 0)));
    pnl.add(lblLevel);
    pnl.add(Box.createRigidArea(new Dimension(175, 0)));
    pnl.add(lblDeath);
    pnl.add(Box.createRigidArea(new Dimension(15, 0)));
    f.setSize(785, 390);
    break;
   
   case 8: // Medium Level 3 header and main frame dimensions
    pnl.setPreferredSize(new Dimension(785, 30));
    lbl.setPreferredSize(new Dimension(125, 30));
    lblLevel.setPreferredSize(new Dimension(35, 30));
    lblDeath.setPreferredSize(new Dimension(150, 30));
    pnl.add(lbl);
    pnl.add(Box.createRigidArea(new Dimension(205, 0)));
    pnl.add(lblLevel);
    pnl.add(Box.createRigidArea(new Dimension(175, 0)));
    pnl.add(lblDeath);
    pnl.add(Box.createRigidArea(new Dimension(15, 0)));
    f.setSize(785, 390);
    break;
   
   case 9: // Medium Level 4 header and main frame dimensions
    pnl.setPreferredSize(new Dimension(723, 30));
    lbl.setPreferredSize(new Dimension(125, 30));
    lblLevel.setPreferredSize(new Dimension(35, 30));
    lblDeath.setPreferredSize(new Dimension(150, 30));
    pnl.add(lbl);
    pnl.add(Box.createRigidArea(new Dimension(162, 0)));
    pnl.add(lblLevel);
    pnl.add(Box.createRigidArea(new Dimension(152, 0)));
    pnl.add(lblDeath);
    pnl.add(Box.createRigidArea(new Dimension(15, 0)));
    f.setSize(723, 455);
    break;
   
   case 10: // Medium Level 5 header and main frame dimensions
    pnl.setPreferredSize(new Dimension(595, 30));
    lbl.setPreferredSize(new Dimension(125, 30));
    lblLevel.setPreferredSize(new Dimension(35, 30));
    lblDeath.setPreferredSize(new Dimension(150, 30));
    pnl.add(lbl);
    pnl.add(Box.createRigidArea(new Dimension(85, 0)));
    pnl.add(lblLevel);
    pnl.add(Box.createRigidArea(new Dimension(105, 0)));
    pnl.add(lblDeath);
    pnl.add(Box.createRigidArea(new Dimension(15, 0)));
    f.setSize(595, 583);
    break;
  } // Switch case based on level where header and main frame dimensions are based on level

  // Add header to the canvas, add the maze game to the canvas, and add the canvas to the frame, also sets properties
  canvas.add(pnl);
  canvas.setBackground(Color.black);
  canvas.add(new DrawMaze());
  f.add(canvas);
  f.setBackground(Color.black);
  f.setLocationRelativeTo(null);
  f.setVisible(true);
  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 } // Constructor

 /** Panel that contains the maze and everything going on inside it. Also handles the actions undertaken when certain events take place */
 class DrawMaze extends JPanel implements ActionListener
 {
  // Objects in the maze
  private MazeLayout maze;
  private Player p;
  private Obstacle blueBalls;
  private Coin c;
  // Maze properties
  private Timer timer, t;
  private boolean playerIsHit = false;
  private boolean checkpoint = false;
  private int level;
  private int coins, columns;
  private int[] coinsM1, coinsM2, coinsM3, coinsM4, coinsM5;
  // Transparency values
  private float playerTransparencyVal = 1f;
  private int coinTransparencyVal = 1, coinTransparencyVal2 = 1, coinTransparencyVal3 = 1, coinTransparencyVal4 = 1, coinTransparencyVal5 = 1, coinTransparencyVal6 = 1, coinTransparencyVal7 = 1;
  
  // Medium Level 1 balls positions variables
  private int xBallDown = 72;
  private int yBallDown = 136;
  private int yBallUp = 360;
  private int xBallTop = 136;
  private int xBallBottom = 424;
  private int yBallTop = 72;
  private int xBallSmall = 200;
  private int yBallSmallD = 72;
  private int yBallSmallU = 200;
  private int moveVertical = -4;
  private int moveHorizontal = -4;
  private int move = -2;
  private int moveSide = -2;

  // Medium Level 2 balls positions variables
  private int xSquare = 136;
  private int ySquare = 72;

  // Medium Level 3 balls positions variables
  private int xUp = 680;
  private int yUp = 200;
  private int xSide = 552;
  private int ySide = 200;

  // Medium Level 4 balls positions variables
  private int xVUp = 168;
  private int yVUp = 72;
  private int yVDown = 168;
  private int xTop = 40;
  private int yTop = 264;
  private int yBottom = 328;
  private int moveSlowlyDown = -1;
  private int moveSlowlyUp = -1;
  
  // Medium Level 5 balls positions variables
  private int xLeft = 520;
  private int xRight = 40;
  private int moveFastRight = -6;
  private int moveFastLeft = -6;

  /** Sets up relevant objects, gets the player level, and uses a switch case to setup the balls positions, the coins number and positions, the number of columns in the maze, and the timer speed, also sets up the key listener object (ActionListener method is what causes the visual to be displayed)*/
  public DrawMaze()
  {
   if (isLoad) // If account being loaded, attempt to get level 
   {
    try // Attempt to scan account level file
    {
     if (!Menu.cheat)
      scanFile = new Scanner(new File("Game Components\\Player Components\\Player Levels\\" + username + "-Level.txt"));
     else
      scanFile = new Scanner(new File("Game Components\\Player Components\\Player Levels\\" + username + "-CheatLevel.txt"));
     level = scanFile.nextInt();
    } catch (FileNotFoundException i) {} // try catch where account level file is scanned
    isLoad = false;
   } 
   else // If account is new, assings default level
    level = levi.getLevel();
   
   // Assign objects
   maze = new MazeLayout();
   p = new Player();
   blueBalls = new Obstacle();
   c = new Coin();
   
   switch (level)  // Switch case based on level where balls positions, columuns, coin number, coins positions, and timer are setup
   {
    case 6: // Medium Level 1 setup
     columns = 18;
     coins = 4;
     coinsM1 = c.getCoinsM1();
     if (Menu.cheat)
      timer = new Timer(50, this);
     else
      timer = new Timer(25, this);
     timer.start();
     break;
    
    case 7: // Medium Level 2 setup
     columns = 24;
     coins = 4;
     coinsM2 = c.getCoinsM2();
     if (Menu.cheat)
      timer = new Timer(50, this);
     else
      timer = new Timer(25, this);
     timer.start();
     break;
    
    case 8: // Medium Level 3 setup
     columns = 24;
     coins = 7;
     coinsM3 = c.getCoinsM3();
     if (Menu.cheat)
      timer = new Timer(50, this);
     else
      timer = new Timer(25, this);
     timer.start();
     break;
    
    case 9: // Medium Level 4 setup
     columns = 22;
     coins = 4;
     coinsM4 = c.getCoinsM4();
     if (Menu.cheat)
      timer = new Timer(50, this);
     else
      timer = new Timer(25, this);
     timer.start();
     break;
    
    case 10: // Medium Level 5 setup
     columns = 18;
     coins = 4;
     coinsM5 = c.getCoinsM5();
     if (Menu.cheat)
      timer = new Timer(50, this);
     else
      timer = new Timer(25, this);
     timer.start();
     break;
   } // Switch case based on level where balls positions, columuns, coin number, coins positions, and timer are setup
   
   addKeyListener(new Move());
   setFocusable(true);
  } // Constructor

  /** Audio when player hits a ball*/
  public void playCollide ()
  {
   try 
   {
    InputStream in = new FileInputStream("Game Components\\Audio Components\\collide.wav");
    AudioStream as = new AudioStream( in );
    AudioPlayer.player.start(as);
   } catch (IOException e) {}
  } // playCollide

  /** Audio when player hits a coin*/
  public void playCash ()
  {
   try 
   {
    InputStream in = new FileInputStream("Game Components\\Audio Components\\cash.wav");
    AudioStream as = new AudioStream( in );
    AudioPlayer.player.start(as);
   } catch (IOException e) {}
  } // playCash

  /** Audio when player completes a level*/
  public void playLevel ()
  {
   try 
   {
    InputStream in = new FileInputStream("Game Components\\Audio Components\\levelDone.wav");
    AudioStream as = new AudioStream( in );
    AudioPlayer.player.start(as);
   } catch (IOException e) {}
  } // playLevel

  /** Tasks performed as time passes (the timer increment is how long between when the actionEvent takes place)*/
  public void actionPerformed(ActionEvent e)
  {
   switch (level) // Switch case based on level where balls undergo motion and coins that should be collected are collected (and graphics are painted)
   {
    case 6: // Medium Level 1 ball motion change and coin collection
     ballsMoving(); // Balls' motion
     if (collectCoin(coinsM1[0] * 32 + 8, coinsM1[1] * 32 + 8, coinTransparencyVal)) 
      coinTransparencyVal = 0;
     else if (collectCoin(coinsM1[2] * 32 + 8, coinsM1[3] * 32 + 8, coinTransparencyVal2)) 
      coinTransparencyVal2 = 0;
     else if (collectCoin(coinsM1[4] * 32 + 8, coinsM1[5] * 32 + 8, coinTransparencyVal3)) 
      coinTransparencyVal3 = 0;
     else if (collectCoin(coinsM1[6] * 32 + 8, coinsM1[7] * 32 + 8, coinTransparencyVal4)) 
      coinTransparencyVal4 = 0;
     break;
    
    case 7: // Medium Level 2 ball motion change and coin collection
     squares(); // Balls' motion
     if (collectCoin(coinsM2[0] * 32 + 8, coinsM2[1] * 32 + 8, coinTransparencyVal)) 
      coinTransparencyVal = 0;
     else if (collectCoin(coinsM2[2] * 32 + 8, coinsM2[3] * 32 + 8, coinTransparencyVal2)) 
      coinTransparencyVal2 = 0;
     else if (collectCoin(coinsM2[4] * 32 + 8, coinsM2[5] * 32 + 8, coinTransparencyVal3)) 
      coinTransparencyVal3 = 0;
     else if (collectCoin(coinsM2[6] * 32 + 8, coinsM2[7] * 32 + 8, coinTransparencyVal4)) 
      coinTransparencyVal4 = 0;
     break;
    
    case 8: // Medium Level 3 ball motion change and coin collection
     move3(); // Balls' motion
     if (collectCoin(coinsM3[0] * 32 + 8, coinsM3[1] * 32 + 8, coinTransparencyVal)) 
      coinTransparencyVal = 0;
     else if (collectCoin(coinsM3[2] * 32 + 8, coinsM3[3] * 32 + 8, coinTransparencyVal2)) 
      coinTransparencyVal2 = 0;
     else if (collectCoin(coinsM3[4] * 32 + 8, coinsM3[5] * 32 + 8, coinTransparencyVal3)) 
      coinTransparencyVal3 = 0;
     else if (collectCoin(coinsM3[6] * 32 + 8, coinsM3[7] * 32 + 8, coinTransparencyVal4)) 
      coinTransparencyVal4 = 0;
     else if (collectCoin(coinsM3[8] * 32 + 8, coinsM3[9] * 32 + 8, coinTransparencyVal5)) 
      coinTransparencyVal5 = 0;
     else if (collectCoin(coinsM3[10] * 32 + 8, coinsM3[11] * 32 + 8, coinTransparencyVal6)) 
      coinTransparencyVal6 = 0;
     else if (collectCoin(coinsM3[12] * 32 + 8, coinsM3[13] * 32 + 8, coinTransparencyVal7)) 
      coinTransparencyVal7 = 0;
     break;
    
    case 9:  // Medium Level 4 ball motion change and coin collection
     move4(); // Balls' motion
     if (collectCoin(coinsM4[0] * 32 + 8, coinsM4[1] * 32 + 8, coinTransparencyVal)) 
      coinTransparencyVal = 0;
     else if (collectCoin(coinsM4[2] * 32 + 8, coinsM4[3] * 32 + 8, coinTransparencyVal2)) 
      coinTransparencyVal2 = 0;
     else if (collectCoin(coinsM4[4] * 32 + 8, coinsM4[5] * 32 + 8, coinTransparencyVal3)) 
      coinTransparencyVal3 = 0;
     else if (collectCoin(coinsM4[6] * 32 + 8, coinsM4[7] * 32 + 8, coinTransparencyVal4)) 
      coinTransparencyVal4 = 0;
     break;
    
    case 10: // Medium Level 5 ball motion change and coin collection
     move5(); // Balls' motion
     if (collectCoin(coinsM5[0] * 32 + 8, coinsM5[1] * 32 + 8, coinTransparencyVal)) 
      coinTransparencyVal = 0;
     else if (collectCoin(coinsM5[2] * 32 + 8, coinsM5[3] * 32 + 8, coinTransparencyVal2)) 
      coinTransparencyVal2 = 0;
     else if (collectCoin(coinsM5[4] * 32 + 8, coinsM5[5] * 32 + 8, coinTransparencyVal3)) 
      coinTransparencyVal3 = 0;
     else if (collectCoin(coinsM5[6] * 32 + 8, coinsM5[7] * 32 + 8, coinTransparencyVal4)) 
      coinTransparencyVal4 = 0;
     break;
   }  // Switch case based on level where balls undergo motion and coins that should be collected are collected
   if (playerIsHit)
    regenerate();
   repaint();
  } // actionPerformed

  /** Causes the player image to fade out (this action is performed several times in a second after the player is hit due to the ActionListener and the timer associated), resetting the level once the player completely fades out*/
  public void regenerate()
  {
   playerTransparencyVal += -0.1f;
   if (playerTransparencyVal <= 0) // Resets level
    reset();
  } // regenerate

  /** Resets the level (positions and transparency of the player as well as coins)*/
  public void reset()
  {
   playerTransparencyVal = 1; // Reset player transparency
   playCollide (); // Play audio   
   death += 1; // Add to death count
   lblDeath.setText("DEATHS:  " + death);
   playerIsHit = false;
   
   try // Attempt to add death count to account's file
   {
    PrintWriter outFile = new PrintWriter("Game Components\\Player Components\\Player Deaths\\" + username + "-Death.txt");
    outFile.println(death);
    outFile.close();
   } catch (IOException e) {} // try catch where account's death file is updated

   if (!Menu.cheat) // If a cheat account is playing, the maze will not be reset
   {
    switch (level) // Switch case based on level where coins and player positions are reset
    {
     case 6: // Medium level 1 level reset
      p.setTileX(8);
      p.setTileY(7);
      coins = 4;
      coinTransparencyVal = 1;
      coinTransparencyVal2 = 1;
      coinTransparencyVal3 = 1;
      coinTransparencyVal4 = 1;
      break;
      
     case 7: // Medium level 2 level reset
      p.setTileX(2);
      p.setTileY(4);
      coins = 4;
      coinTransparencyVal = 1;
      coinTransparencyVal2 = 1;
      coinTransparencyVal3 = 1;
      coinTransparencyVal4 = 1;
      break;
      
     case 8: // Medium level 3 level reset
      p.setTileX(22);
      p.setTileY(8);
      coins = 7;
      coinTransparencyVal = 1;
      coinTransparencyVal2 = 1;
      coinTransparencyVal3 = 1;
      coinTransparencyVal4 = 1;
      coinTransparencyVal5 = 1;
      coinTransparencyVal6 = 1;
      coinTransparencyVal7 = 1;
      break;
      
     case 9: // Medium level 4 level reset
      p.setTileX(10);
      p.setTileY(9);
      coins = 4;
      coinTransparencyVal = 1;
      coinTransparencyVal2 = 1;
      coinTransparencyVal3 = 1;
      coinTransparencyVal4 = 1;
      break;
      
     case 10: // Medium level 5 level reset
      p.setTileX(8);
      p.setTileY(7);
      coins = 4;
      coinTransparencyVal = 1;
      coinTransparencyVal2 = 1;
      coinTransparencyVal3 = 1;
      coinTransparencyVal4 = 1;
      break;
    } // Switch case based on level where coins and player positions are reset
   } // if statement based on whether cheat is enabled
  } // reset

  /** Performs all necessary procedures to go to the next level (this method is performed in the Move Class when a key is hit that makes the player reach the end of a level)*/
  public void levelComplete()
  {
   switch (level) // Switch case based on level where the previous level frame is disposed and the frame for the next level is created (Creates a new Medium Object)
   {
    case 6: // Medium level 1 level progression
    case 7: // Medium level 2 level progression
    case 8: // Medium level 3 level progression
    case 9: // Medium level 4 level progression
     playLevel ();
     f.setVisible(false);
     f.dispose();
     levelChange();
     new Medium();
     break;
    case 10: // Medium level 5 level progression
     playLevel ();
     f.setVisible(false);
     f.dispose();
     
     Scanner numAccntsFileScnr;
     int numAccounts;
     PrintWriter numGameModeAccntsWriter;
     try // Attempt to change the account number files for the game modes apropriately
     {
      numAccntsFileScnr = new Scanner (new File ("Game Components\\Player Components\\MediumAccountNumber.txt"));
      numAccounts = numAccntsFileScnr.nextInt() - 1;
      numGameModeAccntsWriter = new PrintWriter ("Game Components\\Player Components\\MediumAccountNumber.txt");
      numGameModeAccntsWriter.println(numAccounts);
      numGameModeAccntsWriter.close();

      numAccntsFileScnr = new Scanner (new File ("Game Components\\Player Components\\HardAccountNumber.txt"));
      numAccounts = numAccntsFileScnr.nextInt() + 1;
      numGameModeAccntsWriter = new PrintWriter ("Game Components\\Player Components\\HardAccountNumber.txt");
      numGameModeAccntsWriter.println(numAccounts);
      numGameModeAccntsWriter.close();
     } catch (IOException ie) {} // try catch where gae mode files are altered
     levelChange();
     Menu.medium = false;
     Menu.hard = true;
     new Hard ();
     break;
   } // Switch case based on level where coins and player positions are reset
  } // reset

  /** Increases the level by 1 and records the level on the account's file*/
  public void levelChange()
  {
   levi.setLevel(level + 1);
   try // Attempt to rewerite level value in account's level file
   {
    if (!Menu.cheat) // The account being a cheat or not determines the level file name
     outFile = new PrintWriter("Game Components\\Player Components\\Player Levels\\" + username + "-Level.txt");
    else
     outFile = new PrintWriter("Game Components\\Player Components\\Player Levels\\" + username + "-CheatLevel.txt");
    outFile.println(level + 1);
    outFile.close();
   } catch (IOException i) {} // try catch where level file's value was rewritten
  } // levelChange

  /** Checks if a given coin's X and Y positions are in proximity to the player*/
  public boolean collectCoin(int x, int y, int f)
  {
   if (f == 1) // Only checks if the coin hasn't been collected (it's transparency value would be 0 if it was collected, and 1 if it wasn't collected)
   {
    int xDistance = Math.abs(x - (p.getTileX() * 32 + 16)); // Gets absolute distance of the player x and y points to given coin x and y points
    int yDistance = Math.abs(y - (p.getTileY() * 32 + 16));
    
    // Distance determines whether to decide if the coin has been collected
    if (xDistance > 20)
     return false;
    if (yDistance > 20)
     return false;
    if (xDistance <= 10) 
    {
     if (coins > 0)
      coins -= 1;
     playCash();
     return true;
    } // if based on the X and y distance from the player to the given coin
    if (yDistance <= 10) 
    {
     if (coins > 0)
      coins -= 1;
     playCash();
     return true;
    } // if based on the X and y distance from the player to the given coin
   } // if based on whether the coin hasn't been collected
   return false;
  } // collectCoin

  /** Checks if a given ball's X and Y positions are in proximity to the player*/
  public boolean collision(int x, int y)
  {
   int xDistance = Math.abs(x - (p.getTileX() * 32 + 16)); // Gets absolute distance of the player x and y points to given ball x and y points
   int yDistance = Math.abs(y - (p.getTileY() * 32 + 16));
   // Distance determines whether to decide if the coin has been collected
   if (xDistance > 20)
   return false;
   if (yDistance > 20)
    return false;
   if (xDistance <= 10)
    return true;
   if (yDistance <= 10)
     return true;
   double cornerDistance = Math.sqrt (Math.pow(xDistance - 10, 2) + Math.pow(yDistance - 10, 2));
   if (cornerDistance <= 5)
    return true;
   return false;
  } // collision

  /** Medium Level 1 ball motion method*/
  public void ballsMoving()
  {
   if (yBallDown == 136 && yBallUp == 360)
    moveVertical *= -1;
   if (xBallTop == 136 && xBallBottom == 424)
    moveHorizontal *= -1;
   if (yBallSmallU == 200 && yBallSmallD == 72)
    move *= -1;
   yBallDown += moveVertical;
   yBallUp -= moveVertical;
   xBallTop += moveHorizontal;
   xBallBottom -= moveHorizontal;
   yBallSmallU -= move;
   yBallSmallD += move;
   if (yBallDown == 360 && yBallUp == 136)
    moveVertical *= -1;
   if (xBallTop == 424 && xBallBottom == 136)
    moveHorizontal *= -1;
   if (yBallSmallU == 72 && yBallSmallD == 200)
    move *= -1;
  } // ballsMoving

  /** Medium Level 2 ball motion method*/
  public void squares()
  {
   if (ySquare == 72 && xSquare < 168)
    xSquare += 2;
   if (xSquare == 168 && ySquare < 104)
    ySquare += 2;
   if (ySquare == 104 && xSquare > 136)
    xSquare -= 2;
   if (xSquare == 136 && ySquare > 72)
    ySquare -= 2;
  } // squares

  /** Medium Level 3 ball motion method*/
  public void move3()
  {
   if (yUp == 200)
    move *= -1;
   if (xSide == 552)
    moveSide *= -1;
   yUp -= move;
   xSide += moveSide;
   if (yUp == 40)
    move *= -1;
   if (xSide == 680)
    moveSide *= -1;
  } // move3

  /** Medium Level 4 ball motion method*/
  public void move4()
  {
   if (yVUp == 72)
    moveSlowlyDown *= -1;
   if (yVDown == 168)
    moveSlowlyUp *= -1;
   if (yTop == 264)
    move *= -1;
   if (yBottom == 328)
    moveSide *= -1;
   yVUp += moveSlowlyDown;
   yVDown -= moveSlowlyUp;
   yTop += move;
   yBottom -= moveSide;
   if (yVUp == 136)
    moveSlowlyDown *= -1;
   if (yVDown == 104)
    moveSlowlyUp *= -1;
   if (yTop == 328)
    move *= -1;
   if (yBottom == 264)
    moveSide *= -1;
  } // move4

  /** Medium Level 5 ball motion method*/
  public void move5()
  {
   if (xRight == 40)
    moveFastRight *= -1;
   if (xLeft == 520)
    moveFastLeft *= -1;
   xRight += moveFastRight;
   xLeft -= moveFastLeft;
   if (xRight == 520)
    moveFastRight *= -1;
   if (xLeft == 40)
    moveFastLeft *= -1;
  } // move5

  /** Visually displays the game*/
  public void paint(Graphics g) 
  {
   ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
   Graphics2D g2d = (Graphics2D) g;
   super.paint(g);
   
   for (int y = 0; y < maze.getRow(); y++) // Loop through each row in the text file
   {
    for (int x = 0; x < columns; x++) // Loop through each letter in a row (each row is a string element in the maze array)
    {
      if (maze.getMazeTile(x, y).equals("f")) // If current maze tile is the floor
      g.drawImage(maze.getFloor(), x * 32, y * 32, null);
     else if (maze.getMazeTile(x, y).equals("w")) // If current maze tile is a wall
      g.drawImage(maze.getWall(), x * 32, y * 32, null);
     else if (maze.getMazeTile(x, y).equals("g")) // If current maze tile is a green space 
      g.drawImage(maze.getZone(), x * 32, y * 32, null);
     else if (maze.getMazeTile(x, y).equals("b")) // If current maze tile is a barrier
      g.drawImage(maze.getBarrier(), x * 32, y * 32, null);
    } // for checking each letter of a row of the maze 
   } // for checking each row in the maze

   switch (level) // Switch case based on level where obstacles and coin for corresponding levels are visually displayed (and it checks if the player collided with the ball)
   {
    case 6: // Medium level 1 display and checking for collision
     // Display balls (positions already acquired in ballsMoving method)
     g.drawImage(blueBalls.getBall(), xBallDown, yBallDown, null);
     g.drawImage(blueBalls.getBall(), xBallDown + 32, yBallUp, null);
     g.drawImage(blueBalls.getBall(), xBallDown + 384, yBallUp, null);
     g.drawImage(blueBalls.getBall(), xBallDown + 414, yBallDown, null);
     g.drawImage(blueBalls.getBall(), xBallTop, yBallTop, null);
     g.drawImage(blueBalls.getBall(), xBallBottom, yBallTop + 32, null);
     g.drawImage(blueBalls.getBall(), xBallBottom, yBallTop + 320, null);
     g.drawImage(blueBalls.getBall(), xBallTop, yBallTop + 352, null);
     g.drawImage(blueBalls.getBall(), xBallSmall, yBallSmallD, null);
     g.drawImage(blueBalls.getBall(), xBallSmall + 32, yBallSmallU, null);
     g.drawImage(blueBalls.getBall(), xBallSmall + 128, yBallSmallU, null);
     g.drawImage(blueBalls.getBall(), xBallSmall + 160, yBallSmallD, null);
     g.drawImage(blueBalls.getBall(), xBallSmall, yBallSmallD + 224, null);
     g.drawImage(blueBalls.getBall(), xBallSmall + 32, yBallSmallU + 224, null);
     g.drawImage(blueBalls.getBall(), xBallSmall + 128, yBallSmallD + 224, null);
     g.drawImage(blueBalls.getBall(), xBallSmall + 160, yBallSmallU + 224, null);
     g.drawImage(blueBalls.getBall(), xBallSmall + 128, yBallSmallD + 224, null);
     g.drawImage(blueBalls.getBall(), xBallSmall + 160, yBallSmallU + 224, null);
     // Check for collision
     if (collision(xBallDown, yBallDown) || collision(xBallDown + 32, yBallUp) || collision(xBallDown + 384, yBallUp) || collision(xBallDown + 414, yBallDown) || collision(xBallTop, yBallTop) || collision(xBallBottom, yBallTop + 32) || collision(xBallBottom, yBallTop + 320) || collision(xBallTop, yBallTop + 352) || collision(xBallSmall, yBallSmallD) || collision(xBallSmall + 32, yBallSmallU) || collision(xBallSmall + 128, yBallSmallU) || collision(xBallSmall + 160, yBallSmallD) || collision(xBallSmall, yBallSmallD + 224) || collision(xBallSmall + 32, yBallSmallU + 224) || collision(xBallSmall + 128, yBallSmallD + 224) || collision(xBallSmall + 160, yBallSmallU + 224))
      playerIsHit = true;
     
     // Display the Medium level 1 coins based on their transparency
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal));
     g2d.drawImage(c.getCoin(), coinsM1[0] * 32 + 8, coinsM1[1] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal2));
     g2d.drawImage(c.getCoin(), coinsM1[2] * 32 + 8, coinsM1[3] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal3));
     g2d.drawImage(c.getCoin(), coinsM1[4] * 32 + 8, coinsM1[5] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal4));
     g2d.drawImage(c.getCoin(), coinsM1[6] * 32 + 8, coinsM1[7] * 32 + 8, null);
     break;
     
    case 7: // Medium level 2 display and checking for collision
     // Display balls (positions already acquired in squares method)
     g.drawImage(blueBalls.getBall(), xSquare, ySquare, null);
     g.drawImage(blueBalls.getBall(), xSquare + 64, ySquare, null);
     g.drawImage(blueBalls.getBall(), xSquare + 192, ySquare, null);
     g.drawImage(blueBalls.getBall(), xSquare + 256, ySquare, null);
     g.drawImage(blueBalls.getBall(), xSquare + 320, ySquare, null);
     g.drawImage(blueBalls.getBall(), xSquare + 384, ySquare, null);
     g.drawImage(blueBalls.getBall(), xSquare + 448, ySquare, null);
     g.drawImage(blueBalls.getBall(), xSquare, ySquare + 64, null);
     g.drawImage(blueBalls.getBall(), xSquare + 64, ySquare + 64, null);
     g.drawImage(blueBalls.getBall(), xSquare + 192, ySquare + 64, null);
     g.drawImage(blueBalls.getBall(), xSquare + 256, ySquare + 64, null);
     g.drawImage(blueBalls.getBall(), xSquare + 384, ySquare + 64, null);
     g.drawImage(blueBalls.getBall(), xSquare + 448, ySquare + 64, null);
     g.drawImage(blueBalls.getBall(), xSquare, ySquare + 128, null);
     g.drawImage(blueBalls.getBall(), xSquare + 64, ySquare + 128, null);
     g.drawImage(blueBalls.getBall(), xSquare + 128, ySquare + 128, null);
     g.drawImage(blueBalls.getBall(), xSquare + 192, ySquare + 128, null);
     g.drawImage(blueBalls.getBall(), xSquare + 256, ySquare + 128, null);
     g.drawImage(blueBalls.getBall(), xSquare + 384, ySquare + 128, null);
     g.drawImage(blueBalls.getBall(), xSquare + 448, ySquare + 128, null);
     // Check for collision
     if (collision(xSquare, ySquare) || collision(xSquare + 64, ySquare) || collision(xSquare + 192, ySquare) || collision(xSquare + 256, ySquare) || collision(xSquare + 320, ySquare) || collision(xSquare + 384, ySquare) || collision(xSquare + 448, ySquare) || collision(xSquare, ySquare + 64) || collision(xSquare + 64, ySquare + 64) || collision(xSquare + 192, ySquare + 64) || collision(xSquare + 256, ySquare + 64) || collision(xSquare + 384, ySquare + 64) || collision(xSquare + 448, ySquare + 64) || collision(xSquare, ySquare + 128) || collision(xSquare + 64, ySquare + 128) || collision(xSquare + 128, ySquare + 128) || collision(xSquare + 192, ySquare + 128) || collision(xSquare + 256, ySquare + 128) || collision(xSquare + 384, ySquare + 128) || collision(xSquare + 448, ySquare + 128))
      playerIsHit = true;
     
     // Display coin based on its transparency
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal));
     g2d.drawImage(c.getCoin(), coinsM2[0] * 32 + 8, coinsM2[1] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal2));
     g2d.drawImage(c.getCoin(), coinsM2[2] * 32 + 8, coinsM2[3] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal3));
     g2d.drawImage(c.getCoin(), coinsM2[4] * 32 + 8, coinsM2[5] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal4));
     g2d.drawImage(c.getCoin(), coinsM2[6] * 32 + 8, coinsM2[7] * 32 + 8, null);
     break;
    
    case 8: // Medium level 3 display and checking for collision
     // Display balls (positions already acquired in move3 method)
     g.drawImage(blueBalls.getBall(), xUp, yUp, null);
     g.drawImage(blueBalls.getBall(), xUp - 128, yUp, null);
     g.drawImage(blueBalls.getBall(), xUp - 224, yUp, null);
     g.drawImage(blueBalls.getBall(), xUp - 352, yUp, null);
     g.drawImage(blueBalls.getBall(), xUp - 448, yUp, null);
     g.drawImage(blueBalls.getBall(), xSide, ySide, null);
     g.drawImage(blueBalls.getBall(), xSide, ySide - 96, null);
     g.drawImage(blueBalls.getBall(), xSide - 96, ySide - 64, null);
     g.drawImage(blueBalls.getBall(), xSide - 96, ySide - 160, null);
     g.drawImage(blueBalls.getBall(), xSide - 224, ySide, null);
     g.drawImage(blueBalls.getBall(), xSide - 224, ySide - 96, null);
     g.drawImage(blueBalls.getBall(), xSide - 320, ySide - 64, null);
     g.drawImage(blueBalls.getBall(), xSide - 320, ySide - 160, null);
     // Check for collision
     if (collision(xUp, yUp) || collision(xUp - 128, yUp) || collision(xUp - 224, yUp) || collision(xUp - 352, yUp) || collision(xUp - 448, yUp) || collision(xSide, ySide) || collision(xSide, ySide - 96) || collision(xSide - 96, ySide - 64) || collision(xSide - 96, ySide - 160) || collision(xSide - 224, ySide) || collision(xSide - 224, ySide - 96) || collision(xSide - 320, ySide - 64) || collision(xSide - 320, ySide - 160))
      playerIsHit = true;
     
     // Display coins based on their transparency
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal));
     g2d.drawImage(c.getCoin(), coinsM3[0] * 32 + 8, coinsM3[1] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal2));
     g2d.drawImage(c.getCoin(), coinsM3[2] * 32 + 8, coinsM3[3] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal3));
     g2d.drawImage(c.getCoin(), coinsM3[4] * 32 + 8, coinsM3[5] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal4));
     g2d.drawImage(c.getCoin(), coinsM3[6] * 32 + 8, coinsM3[7] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal5));
     g2d.drawImage(c.getCoin(), coinsM3[8] * 32 + 8, coinsM3[9] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal6));
     g2d.drawImage(c.getCoin(), coinsM3[10] * 32 + 8, coinsM3[11] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal7));
     g2d.drawImage(c.getCoin(), coinsM3[12] * 32 + 8, coinsM3[13] * 32 + 8, null);
     break;

    case 9: // Medium level 4 display and checking for collision
     // Display balls (positions already acquired in move4 method)
     g.drawImage(blueBalls.getBall(), xVUp, yVUp, null);
     g.drawImage(blueBalls.getBall(), xVUp + 32, yVDown, null);
     g.drawImage(blueBalls.getBall(), xVUp + 64, yVUp + 64, null);
     g.drawImage(blueBalls.getBall(), xVUp + 96, yVDown + 64, null);
     g.drawImage(blueBalls.getBall(), xVUp + 128, yVUp + 128, null);
     g.drawImage(blueBalls.getBall(), xVUp + 224, yVUp + 128, null);
     g.drawImage(blueBalls.getBall(), xVUp + 256, yVDown + 64, null);
     g.drawImage(blueBalls.getBall(), xVUp + 288, yVUp + 64, null);
     g.drawImage(blueBalls.getBall(), xVUp + 320, yVDown, null);
     g.drawImage(blueBalls.getBall(), xVUp + 352, yVUp, null);
     g.drawImage(blueBalls.getBall(), xTop, yTop, null);
     g.drawImage(blueBalls.getBall(), xTop + 32, yBottom, null);
     g.drawImage(blueBalls.getBall(), xTop + 64, yTop, null);
     g.drawImage(blueBalls.getBall(), xTop + 96, yBottom, null);
     g.drawImage(blueBalls.getBall(), xTop + 128, yTop, null);
     g.drawImage(blueBalls.getBall(), xTop + 160, yBottom, null);
     g.drawImage(blueBalls.getBall(), xTop + 192, yTop, null);
     g.drawImage(blueBalls.getBall(), xTop + 224, yBottom, null);
     g.drawImage(blueBalls.getBall(), xTop + 384, yBottom, null);
     g.drawImage(blueBalls.getBall(), xTop + 416, yTop, null);
     g.drawImage(blueBalls.getBall(), xTop + 448, yBottom, null);
     g.drawImage(blueBalls.getBall(), xTop + 480, yTop, null);
     g.drawImage(blueBalls.getBall(), xTop + 512, yBottom, null);
     g.drawImage(blueBalls.getBall(), xTop + 544, yTop, null);
     g.drawImage(blueBalls.getBall(), xTop + 576, yBottom, null);
     g.drawImage(blueBalls.getBall(), xTop + 608, yTop, null);
     // Check for collision
     if (collision(xVUp, yVUp) || collision(xVUp + 32, yVDown) || collision(xVUp + 64, yVUp + 64) || collision(xVUp + 96, yVDown + 64) || collision(xVUp + 128, yVUp + 128) || collision(xVUp + 224, yVUp + 128) || collision(xVUp + 256, yVDown + 64) || collision(xVUp + 288, yVUp + 64) || collision(xVUp + 320, yVDown) || collision(xVUp + 352, yVUp) || collision(xTop, yTop) || collision(xTop + 32, yBottom) || collision(xTop + 64, yTop) || collision(xTop + 96, yBottom) || collision(xTop + 128, yTop) || collision(xTop + 160, yBottom) || collision(xTop + 192, yTop) || collision(xTop + 224, yBottom) || collision(xTop + 384, yBottom) || collision(xTop + 384, yVUp) || collision(xTop + 416, yTop) || collision(xTop + 448, yBottom) || collision(xTop + 480, yTop) || collision(xTop + 512, yBottom) || collision(xTop + 544, yTop) || collision(xTop + 576, yBottom) || collision(xTop + 608, yTop))
      playerIsHit = true;
     
     // Display coins based on their transparency
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal));
     g2d.drawImage(c.getCoin(), coinsM4[0] * 32 + 8, coinsM4[1] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal2));
     g2d.drawImage(c.getCoin(), coinsM4[2] * 32 + 8, coinsM4[3] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal3));
     g2d.drawImage(c.getCoin(), coinsM4[4] * 32 + 8, coinsM4[5] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal4));
     g2d.drawImage(c.getCoin(), coinsM4[6] * 32 + 8, coinsM4[7] * 32 + 8, null);
     break;
    
    case 10: // Medium level 5 display and checking for collision
     // Display balls (positions already acquired in move5 method)
     g.drawImage(blueBalls.getBall(), 40, 136, null);
     g.drawImage(blueBalls.getBall(), 72, 104, null);
     g.drawImage(blueBalls.getBall(), 104, 72, null);
     g.drawImage(blueBalls.getBall(), 136, 40, null);
     g.drawImage(blueBalls.getBall(), 424, 40, null);
     g.drawImage(blueBalls.getBall(), 456, 72, null);
     g.drawImage(blueBalls.getBall(), 488, 104, null);
     g.drawImage(blueBalls.getBall(), 520, 136, null);
     g.drawImage(blueBalls.getBall(), 40, 360, null);
     g.drawImage(blueBalls.getBall(), 72, 392, null);
     g.drawImage(blueBalls.getBall(), 104, 424, null);
     g.drawImage(blueBalls.getBall(), 136, 456, null);
     g.drawImage(blueBalls.getBall(), 520, 360, null);
     g.drawImage(blueBalls.getBall(), 488, 392, null);
     g.drawImage(blueBalls.getBall(), 456, 424, null);
     g.drawImage(blueBalls.getBall(), 424, 456, null);
     g.drawImage(blueBalls.getBall(), 104, 168, null);
     g.drawImage(blueBalls.getBall(), 136, 136, null);
     g.drawImage(blueBalls.getBall(), 168, 104, null);
     g.drawImage(blueBalls.getBall(), 200, 104, null);
     g.drawImage(blueBalls.getBall(), 232, 104, null);
     g.drawImage(blueBalls.getBall(), 264, 104, null);
     g.drawImage(blueBalls.getBall(), 296, 104, null);
     g.drawImage(blueBalls.getBall(), 328, 104, null);
     g.drawImage(blueBalls.getBall(), 360, 104, null);
     g.drawImage(blueBalls.getBall(), 392, 104, null);
     g.drawImage(blueBalls.getBall(), 424, 136, null);
     g.drawImage(blueBalls.getBall(), 456, 168, null);
     g.drawImage(blueBalls.getBall(), 104, 328, null);
     g.drawImage(blueBalls.getBall(), 136, 360, null);
     g.drawImage(blueBalls.getBall(), 168, 392, null);
     g.drawImage(blueBalls.getBall(), 200, 392, null);
     g.drawImage(blueBalls.getBall(), 232, 392, null);
     g.drawImage(blueBalls.getBall(), 264, 392, null);
     g.drawImage(blueBalls.getBall(), 296, 392, null);
     g.drawImage(blueBalls.getBall(), 328, 392, null);
     g.drawImage(blueBalls.getBall(), 360, 392, null);
     g.drawImage(blueBalls.getBall(), 392, 392, null);
     g.drawImage(blueBalls.getBall(), 424, 360, null);
     g.drawImage(blueBalls.getBall(), 456, 328, null);
     g.drawImage(blueBalls.getBall(), xRight, 40, null);
     g.drawImage(blueBalls.getBall(), xRight, 72, null);
     g.drawImage(blueBalls.getBall(), xRight, 104, null);
     g.drawImage(blueBalls.getBall(), xRight, 136, null);
     g.drawImage(blueBalls.getBall(), xRight, 168, null);
     g.drawImage(blueBalls.getBall(), xLeft, 328, null);
     g.drawImage(blueBalls.getBall(), xLeft, 360, null);
     g.drawImage(blueBalls.getBall(), xLeft, 392, null);
     g.drawImage(blueBalls.getBall(), xLeft, 424, null);
     g.drawImage(blueBalls.getBall(), xLeft, 456, null);
     // Check for collision
     if (collision(40, 136) || collision(72, 104) || collision(104, 72) || collision(136, 40) || collision(424, 40) || collision(456, 72) || collision(488, 104) || collision(520, 136) || collision(40, 360) || collision(72, 392) || collision(104, 424) || collision(136, 456) || collision(520, 360) || collision(488, 392) || collision(456, 424) || collision(424, 456) || collision(104, 168) || collision(136, 136) || collision(168, 104) || collision(200, 104) || collision(232, 104) || collision(264, 104) || collision(296, 104) || collision(328, 104) || (collision(360, 104) || collision(392, 104) || collision(424, 136) || collision(456, 168) || collision(104, 328) || collision(136, 360) || collision(168, 392) || collision(200, 392) || collision(232, 392) || collision(264, 392) || collision(296, 392) || collision(328, 392) || collision(360, 392) || collision(392, 392) || collision(424, 360) || collision(456, 328) || collision(xRight, 40) || collision(xRight, 72) || collision(xRight, 104) || collision(xRight, 136) || collision(xRight, 168) || collision(xLeft, 328) || collision(xLeft, 360) || collision(xLeft, 392) || collision(xLeft, 424) || collision(xLeft, 456)))
      playerIsHit = true;
     
     // Display coins based on their transparency
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal));
     g2d.drawImage(c.getCoin(), coinsM5[0] * 32 + 8, coinsM5[1] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal2));
     g2d.drawImage(c.getCoin(), coinsM5[2] * 32 + 8, coinsM5[3] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal3));
     g2d.drawImage(c.getCoin(), coinsM5[4] * 32 + 8, coinsM5[5] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal4));
     g2d.drawImage(c.getCoin(), coinsM5[6] * 32 + 8, coinsM5[7] * 32 + 8, null);
     break;
   }  // Switch case based on level where obstacles and coin for corresponding levels are visually displayed (and it checks if the player collided with the ball)
   
   // Display player based on its transparency
   g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, playerTransparencyVal));
   g2d.drawImage(p.getPlayer(), p.getTileX() * 32 + 6, p.getTileY() * 32 + 6, null);
  } // paint

  /** Moves the player by registering certain key events*/
  public class Move extends KeyAdapter
  {
   /** Default Constructor performs nothing*/
   Move () {}
   
   /** Moves player in direction of key pressed*/
   public void keyPressed(KeyEvent e)
   {
    int keycode = e.getKeyCode();
    if (!Menu.cheat) // If cheat is disabled, once the player is hit, the key pressing should not have an effect (since the player would be dead)
    {
     if (keycode == KeyEvent.VK_W && playerTransparencyVal == 1f) // W == Up
     {
      if (!maze.getMazeTile(p.getTileX(), p.getTileY() - 1).equals("w") && !maze.getMazeTile(p.getTileX(), p.getTileY() - 1).equals("b")) // Obstructions that would prevent further movement
       p.move(0, -1);
     } // If based on key event and player transparency (player alive is)
     else if (keycode == KeyEvent.VK_S && playerTransparencyVal == 1f) // S == Down
     {
      if (!maze.getMazeTile(p.getTileX(), p.getTileY() + 1).equals("w") && !maze.getMazeTile(p.getTileX(), p.getTileY() + 1).equals("b")) // Obstructions that would prevent further movement
       p.move(0, 1);
     } // If based on key event and player transparency (player alive is)
     else if (keycode == KeyEvent.VK_A && playerTransparencyVal == 1f) // A == Left
     {
      if (!maze.getMazeTile(p.getTileX() - 1, p.getTileY()).equals("w") && !maze.getMazeTile(p.getTileX() - 1, p.getTileY()).equals("b")) // Obstructions that would prevent further movement
       p.move(-1, 0);
     } // If based on key event and player transparency (player alive is)
     else if (keycode == KeyEvent.VK_D && playerTransparencyVal == 1f) // D == Right
     {
      if (!maze.getMazeTile(p.getTileX() + 1, p.getTileY()).equals("w") && !maze.getMazeTile(p.getTileX() + 1, p.getTileY()).equals("b")) // Obstructions that would prevent further movement
       p.move(1, 0);
     } // If based on key event and player transparency (player alive is)
    } // if based on wwhether cheat is enabled
   
    else // If cheat is enabled, the user can move regardless of player death
    {
     if (keycode == KeyEvent.VK_W) // W == Up
     {
      if (!maze.getMazeTile(p.getTileX(), p.getTileY() - 1).equals("w") && !maze.getMazeTile(p.getTileX(), p.getTileY() - 1).equals("b")) // Obstructions that would prevent further movement
       p.move(0, -1);
     } // If based on key event and player transparency (player alive is)
     else if (keycode == KeyEvent.VK_S) // S == Down
     {
      if (!maze.getMazeTile(p.getTileX(), p.getTileY() + 1).equals("w") && !maze.getMazeTile(p.getTileX(), p.getTileY() + 1).equals("b")) // Obstructions that would prevent further movement
       p.move(0, 1);
     } // If based on key event and player transparency (player alive is)
     else if (keycode == KeyEvent.VK_A) // A == Left
     {
      if (!maze.getMazeTile(p.getTileX() - 1, p.getTileY()).equals("w") && !maze.getMazeTile(p.getTileX() - 1, p.getTileY()).equals("b")) // Obstructions that would prevent further movement
       p.move(-1, 0);
     } // If based on key event and player transparency (player alive is) 
     else if (keycode == KeyEvent.VK_D) // D == Right
     {
      if (!maze.getMazeTile(p.getTileX() + 1, p.getTileY()).equals("w") && !maze.getMazeTile(p.getTileX() + 1, p.getTileY()).equals("b")) // Obstructions that would prevent further movement
       p.move(1, 0);
     } // If based on key event and player transparency (player alive is)
    } // else performed if cheat is enabled
    
    switch (level) // switch case based on level where level completion if the user reaches a certain tile and if coins are 0 or if a checkpoint locationis reached
    {
     case 6: // Medium level 1 checks based on player position
      if ((coins == 0) && ((p.getTileX() == 7 || p.getTileX() == 8 || p.getTileX() == 9 || p.getTileX() == 10) && (p.getTileY() == 7 || p.getTileY() == 8))) 
       levelComplete();
      break;
     
     case 7: // Medium level 2 checks based on player position
      if ((coins == 0) && ((p.getTileX() == 20 || p.getTileX() == 21) && (p.getTileY() == 4 || p.getTileY() == 5))) 
       levelComplete();
      break;
     
     case 8: // Medium level 3 checks based on player position
      if ((coins == 0) && (p.getTileX() == 3 && (p.getTileY() == 1 || p.getTileY() == 2))) 
       levelComplete();
      break;
     
     case 9: // Medium level 4 checks based on player position
      if ((coins == 0) && ((p.getTileX() == 9 || p.getTileX() == 10 || p.getTileX() == 11 || p.getTileX() == 12) && (p.getTileY() == 7 || p.getTileY() == 8 || p.getTileY() == 9 || p.getTileY() == 10))) 
       levelComplete();
      break;
     
     case 10: // Medium level 5 checks based on player position
      if ((p.getTileX() >= 16 && p.getTileX() <= 19) && p.getTileY() == 6)
       checkpoint = true;
      if ((coins == 0) && ((p.getTileX() == 8 || p.getTileX() == 9) && (p.getTileY() == 7 || p.getTileY() == 8)))
       levelComplete();
      break;
    } // switch case based on level where level completion if the user reaches a certain tile and if coins are 0 or if a checkpoint locationis reached
   } // keyPressed

   /** If key is released (not used)*/public void keyReleased(KeyEvent e) {}
   /** If key is typed (not used)*/public void keyTyped(KeyEvent e) {}
  } // Move
 } // DrawMaze
} // Medium class