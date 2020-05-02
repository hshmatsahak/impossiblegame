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

/** The frame where everything related to the game in Easy mode is contained*/
public class Easy
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

 // Easy class GUI
 private JLabel lblDeath;
 private JFrame f;
 
 /** Constructs the gaming frame and inside that is the game UI and the maze inside (the maze and all actions performed in there is done using using DrawMaze)*/
 public Easy ()
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
  f.setTitle(username + "'s Maze Game");
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
  lbl.setText("MODE: EASY");
  lbl.setFont(new Font("Calibri", Font.BOLD, 25));
  // Level Label
  JLabel lblLevel = new JLabel();
  lblLevel.setForeground(Color.WHITE);
  lblLevel.setText(level + " / 5");
  lblLevel.setFont(new Font("Calibri", Font.BOLD, 25));
  // Death count label
  lblDeath = new JLabel();
  lblDeath.setForeground(Color.WHITE);
  lblDeath.setText("DEATHS:  " + death);
  lblDeath.setFont(new Font("Calibri", Font.BOLD, 25));

  switch (level) // Swith case based on level where header and main frame dimensions are set based on the level
  {
   case 1: // Easy Level 1 header and main frame dimensions
    pnl.setPreferredSize(new Dimension(720, 30));
    lbl.setPreferredSize(new Dimension(120, 30));
    lblLevel.setPreferredSize(new Dimension(35, 30));
    lblDeath.setPreferredSize(new Dimension(150, 30));
    pnl.add(lbl);
    pnl.add(Box.createRigidArea(new Dimension(200, 0)));
    pnl.add(lblLevel);
    pnl.add(Box.createRigidArea(new Dimension(155, 0)));
    pnl.add(lblDeath);
    pnl.add(Box.createRigidArea(new Dimension(15, 0)));
    f.setSize(720, 421);
    break;
    
   case 2: // Easy Level 2 header and main frame dimensions
    pnl.setPreferredSize(new Dimension(497, 30));
    lbl.setPreferredSize(new Dimension(125, 30));
    lblLevel.setPreferredSize(new Dimension(35, 30));
    lblDeath.setPreferredSize(new Dimension(150, 30));
    pnl.add(lbl);
    pnl.add(Box.createRigidArea(new Dimension(75, 0)));
    pnl.add(lblLevel);
    pnl.add(Box.createRigidArea(new Dimension(60, 0)));
    pnl.add(lblDeath);
    pnl.add(Box.createRigidArea(new Dimension(12, 0)));
    f.setSize(497, 550);
    break;
    
   case 3: // Easy Level 3 header and main frame dimensions
    pnl.setPreferredSize(new Dimension(530, 30));
    lbl.setPreferredSize(new Dimension(125, 30));
    lblLevel.setPreferredSize(new Dimension(35, 30));
    lblDeath.setPreferredSize(new Dimension(150, 30));
    pnl.add(lbl);
    pnl.add(Box.createRigidArea(new Dimension(100, 0)));
    pnl.add(lblLevel);
    pnl.add(Box.createRigidArea(new Dimension(75, 0)));
    pnl.add(lblDeath);
    pnl.add(Box.createRigidArea(new Dimension(15, 0)));
    f.setSize(530, 518);
    break;
    
   case 4: // Easy Level 4 header and main frame dimensions
    pnl.setPreferredSize(new Dimension(723, 30));
    lbl.setPreferredSize(new Dimension(125, 30));
    lblLevel.setPreferredSize(new Dimension(35, 30));
    lblDeath.setPreferredSize(new Dimension(150, 30));
    pnl.add(lbl);
    pnl.add(Box.createRigidArea(new Dimension(217, 0)));
    pnl.add(lblLevel);
    pnl.add(Box.createRigidArea(new Dimension(130, 0)));
    pnl.add(lblDeath);
    pnl.add(Box.createRigidArea(new Dimension(10, 0)));
    f.setSize(723, 518);
    break;
    
   case 5: // Easy Level 5 header and main frame dimensions
    pnl.setPreferredSize(new Dimension(723, 30));
    lbl.setPreferredSize(new Dimension(125, 30));
    lblLevel.setPreferredSize(new Dimension(35, 30));
    lblDeath.setPreferredSize(new Dimension(150, 30));
    pnl.add(lbl);
    pnl.add(Box.createRigidArea(new Dimension(220, 0)));
    pnl.add(lblLevel);
    pnl.add(Box.createRigidArea(new Dimension(140, 0)));
    pnl.add(lblDeath);
    pnl.add(Box.createRigidArea(new Dimension(20, 0)));
    f.setSize(723, 518);
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
  f.setResizable(false);
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
  private Timer timer;
  private int level;
  private int coins, columns;
  private boolean playerIsHit = false;
  private boolean checkpoint = false;
  private int[] coins2, coins3, coins4;
  // Transparency values
  private int coinTransparencyVal = 1, coinTransparencyVal1 = 1, coinTransparencyVal2 = 1, coinTransparencyVal3 = 1, coinTransparencyVal4 = 1;
  private float playerTransparencyVal = 1f;
  
  // Easy Level 1 balls positions variables
  private int[] balls_top, balls_bottom;
  private int yballUp = 72;
  private int yballDown = 264;
  private int moveEasy = -3;
  
  // Easy Level 2 ball position variables
  private double angleUp = Math.PI / -2;
  private double angleRight = 0;
  private double angleDown = Math.PI / 2;
  private double angleLeft = Math.PI;
  private int xCircleUp, xCircleDown, xCircleLeft, xCircleRight;
  private int yCircleUp, yCircleDown, yCircleLeft, yCircleRight;
  
  // Easy Level 3 ball position variables
  private int xBallLeft = 72;
  private int xBallRight = 360;
  private int yBall = 72;
  private int yLong = 104, xLong = 168;
  
  // Easy Level 4 ball position variables
  private int xSquare = 72;
  private int ySquare = 72;
  private int xLTop = 328;
  private int yLTop = 232;
  private int xLSide = 488;
  private int yLSide = 328;
  private boolean putitdownonme = false;
  private boolean crossice = false;
  private boolean cross = false;
  private boolean down = false;
  
  // Easy Level 5 ball position variables
  private int xUp1, xUp2, xUp3, xUp4, xUp5, xUp6, xUp7, xUp8;
  private int yUpA, yDownA, yRightA, yLeftA, yUpB, yDownB, yRightB, yLeftB;
  private int yUpC, yDownC, yRightC, yLeftC, yUpD, yDownD, yRightD, yLeftD;
  private int yUp1, yUp2, yUp3, yUp4, yUp5, yUp6, yUp7, yUp8;
  private int xDown1, xDown2, xDown3, xDown4, xDown5, xDown6, xDown7, xDown8;
  private int yDown1, yDown2, yDown3, yDown4, yDown5, yDown6, yDown7, yDown8;
  private int xRight1, xRight2, xRight3, xRight4, xRight5, xRight6, xRight7, xRight8;
  private int yRight1, yRight2, yRight3, yRight4, yRight5, yRight6, yRight7, yRight8;
  private int xLeft1, xLeft2, xLeft3, xLeft4, xLeft5, xLeft6, xLeft7, xLeft8;
  private int yLeft1, yLeft2, yLeft3, yLeft4, yLeft5, yLeft6, yLeft7, yLeft8;
  
  /** Sets up relevant objects, gets the player level, and uses a switch case to setup the balls positions, the coins number and positions, the number of columns in the maze, and the timer speed, also sets up the key listener object (ActionListener method is what causes the visual to be displayed)*/
  public DrawMaze()
  {
   if (isLoad) // Attempt to scan account level file
   {
    try 
    {
     if (!Menu.cheat)
      scanFile = new Scanner(new File("Game Components\\Player Components\\Player Levels\\" + username + "-Level.txt"));
     else
      scanFile = new Scanner(new File("Game Components\\Player Components\\Player Levels\\" + username + "-CheatLevel.txt"));
     level = scanFile.nextInt();
    } catch (FileNotFoundException i) {} // try catch where account level file is scanneds
    isLoad = false;
   } 
   else // If account is new, assings default level
    level = levi.getLevel();

   // Assign objects
   maze = new MazeLayout();
   p = new Player();
   blueBalls = new Obstacle();
   c = new Coin();
   
   switch (level) // Switch case based on level where balls positions, columuns, coin number, coins positions, and timer are setup
   {
    case 1: // Easy Level 1 setup
     balls_top = blueBalls.getTilesUp();
     balls_bottom = blueBalls.getTilesDown();
     columns = 22;
     coins = 1;
     if (Menu.cheat)
      timer = new Timer(50, this);
     else
      timer = new Timer(25, this);
     timer.start();
     break;
    
    case 2: // Easy Level 2 setup
     columns = 15;
     coins = 3;
     coins2 = c.getCoins2();
     if (Menu.cheat)
      timer = new Timer(150, this);
     else
      timer = new Timer(75, this);
     timer.start();
     break;
    
    case 3: // Easy Level 3 setup
     columns = 16;
     coins = 3;
     coins4 = c.getCoins4();
     if (Menu.cheat)
      timer = new Timer(100, this);
     else
      timer = new Timer(50, this);
     timer.start();
     break;
    
    case 4: // Easy Level 4 setup
     columns = 22;
     coins = 1;
     if (Menu.cheat)
      timer = new Timer(100, this);
     else
      timer = new Timer(50, this);
     timer.start();
     break;
    
    case 5: // Easy Level 5 setup
     columns = 22;
     coins = 4;
     coins3 = c.getCoins3();
     if (Menu.cheat)
      timer = new Timer(200, this);
     else
      timer = new Timer(100, this);
     timer.start();
     break;
   } // Switch case based on level where balls positions, columuns, coin number, coins positions, and timer are setup

   addKeyListener(new Move());
   setFocusable(true);
  } // Constructor

  /** Audio when player hits a ball*/
  public void playCollide ()
  {
   try // Attempt to load audio file
   {
    InputStream in = new FileInputStream("Game Components\\Audio Components\\collide.wav");
    // Create an AudioStream object from the input stream.
    AudioStream as = new AudioStream( in );
    AudioPlayer.player.start(as);
   } catch (IOException e) {} // try catch where audio file as played
  } // playCollide

  /** Audio when player hits a coin*/
  public void playCash ()
  {
   try // Attempt to load audio file
   {
    InputStream in = new FileInputStream("Game Components\\Audio Components\\cash.wav");
    AudioStream as = new AudioStream( in );
    AudioPlayer.player.start(as);
   } catch (IOException e) {} // try catch where audio file as played
  } // playCash

  /** Audio when player completes a level*/
  public void playLevel ()
  {
   try // Attempt to load audio file
   {
    InputStream in = new FileInputStream("Game Components\\Audio Components\\levelDone.wav");
    AudioStream as = new AudioStream( in );
    AudioPlayer.player.start(as);
   } catch (IOException e) {} // try catch where audio file as played
  } // playLevel

  /** Tasks performed as time passes (the timer increment is how long between when the actionEvent takes place)*/
  public void actionPerformed(ActionEvent e)
  {
   switch (level) // Switch case based on level where balls undergo motion and coins that should be collected are collected (and graphics are painted)
   {
    case 1: // Easy Level 1 ball motion change and coin collection
     ballsMoving(); // Balls' motion
     // Coin collection based on distance from player position to coin position
     if (collectCoin(c.getCoinX() * 32 + 32, c.getCoinY() * 32 + 16, coinTransparencyVal)) 
      coinTransparencyVal = 0;
     break;
    
    case 2: // Easy Level 2 ball motion change and coin collection
     angleDown += 0.1; // Balls' motion
     angleLeft += 0.1;
     angleUp += 0.1;
     angleRight += 0.1;
     // Coin collection based on distance from player position to coin position
     if (collectCoin(coins2[0] * 32 + 32, coins2[1] * 32 + 16, coinTransparencyVal1))
      coinTransparencyVal1 = 0;
     else if (collectCoin(coins2[2] * 32 + 16, coins2[3] * 32 + 32, coinTransparencyVal2)) 
      coinTransparencyVal2 = 0;
     else if (collectCoin(coins2[4] * 32 + 32, coins2[5] * 32 + 16, coinTransparencyVal3)) 
      coinTransparencyVal3 = 0;
     break;
    
    case 3: // Easy Level 3 ball motion change and coin collection
     breakOut(); // Balls' motion
     loneRanger();
     // Coin collection based on distance from player position to coin position
     if (collectCoin(coins4[0] * 32 + 16, coins4[1] * 32 + 16, coinTransparencyVal1)) 
      coinTransparencyVal1 = 0;
     else if (collectCoin(coins4[2] * 32 + 16, coins4[3] * 32 + 16, coinTransparencyVal2)) 
      coinTransparencyVal2 = 0;
     else if (collectCoin(coins4[4] * 32 + 16, coins4[5] * 32 + 16, coinTransparencyVal3)) 
      coinTransparencyVal3 = 0;
     break;
    
    case 4: // Easy Level 4 ball motion change and coin collection
     squares(); // Balls' motion
     lShape();
     lSide();
     // Coin collection based on distance from player position to coin position
     if (collectCoin(c.getCoinX() * 32 + 16, c.getCoinY() * 32 + 16, coinTransparencyVal)) 
      coinTransparencyVal = 0;
     break;
    
    case 5: // Easy Level 5 ball motion change and coin collection
     angleDown += 0.1; // Balls' motion
     angleLeft += 0.1;
     angleUp += 0.1;
     angleRight += 0.1;
     // Coin collection based on distance from player position to coin position
     if (collectCoin(coins3[0] * 32 + 16, coins3[1] * 32 + 16, coinTransparencyVal1)) 
      coinTransparencyVal1 = 0;
     else if (collectCoin(coins3[2] * 32 + 16, coins3[3] * 32 + 16, coinTransparencyVal2)) 
      coinTransparencyVal2 = 0;
     else if (collectCoin(coins3[4] * 32 + 16, coins3[5] * 32 + 16, coinTransparencyVal3)) 
      coinTransparencyVal3 = 0;
     else if (collectCoin(coins3[6] * 32 + 16, coins3[7] * 32 + 16, coinTransparencyVal4)) 
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
     case 1: // Easy level 1 level reset
      p.setTileX(3);
      p.setTileY(5);
      c.setCoinX(10);
      c.setCoinY(5);
      coins = 1;
      coinTransparencyVal = 1;
      break;
     
     case 2: // Easy level 2 level reset
      p.setTileX(8);
      p.setTileY(2);
      coins = 3;
      coinTransparencyVal1 = 1;
      coinTransparencyVal2 = 1;
      coinTransparencyVal3 = 1;
      break;
     
     case 3: // Easy level 3 level reset
      p.setTileX(3);
      p.setTileY(3);
      coins = 3;
      coinTransparencyVal1 = 1;
      coinTransparencyVal2 = 1;
      coinTransparencyVal3 = 1;
      break;
     
     case 4: // Easy level 4 level reset
      if (!checkpoint) // Checkpoints determine player reset position
      {
       p.setTileX(2);
       p.setTileY(2);
       coins = 1;
       coinTransparencyVal = 1;
      } // if based on checkpoint
      else 
      {
       p.setTileX(10);
       p.setTileY(8);
       coins = 1;
       coinTransparencyVal = 1;
      } // else if checkpoint has not been reached
      break;
      
     case 5: // Easy level 5 level reset
      if (!checkpoint) // Checkpoints determine player reset position
      {
       p.setTileX(2);
       p.setTileY(2);
       coins = 4;
       coinTransparencyVal1 = 1;
       coinTransparencyVal2 = 1;
       coinTransparencyVal3 = 1;
       coinTransparencyVal4 = 1;
      } // if based on checkpoint
      else 
      {
       p.setTileX(16);
       p.setTileY(6);
       coinTransparencyVal1 = 1;
       coinTransparencyVal2 = 1;
       coinTransparencyVal3 = 1;
       coinTransparencyVal4 = 1;
       coins = 3;
      } // else if checkpoint has not been reached
      break;
    } // Switch case based on level where coins and player positions are reset
   } // if statement based on whether cheat is enabled
  } // reset

  /** Performs all necessary procedures to go to the next level (this method is performed in the Move Class when a key is hit that makes the player reach the end of a level)*/
  public void levelComplete()
  {
   switch (level) // Switch case based on level where the previous level frame is disposed and the frame for the next level is created (Creates a new Medium Object)
   {
    case 1: // Easy level 1 level progression
    case 2: // Easy level 2 level progression
    case 3: // Easy level 3 level progression
    case 4: // Easy level 4 level progression
     playLevel ();
     f.setVisible(false);
     f.dispose();
     levelChange();
     new Easy ();
     break;
    case 5: // Easy level 5 level progression
     playLevel ();
     f.setVisible(false);
     f.dispose();
     levelChange();
     Menu.easy = false;
     Menu.medium = true;
     
     Scanner numAccntsFileScnr;
     int numAccounts;
     PrintWriter numGameModeAccntsWriter;
     try // Attempt to change the account number files for the game modes apropriately
     {
      numAccntsFileScnr = new Scanner (new File ("Game Components\\Player Components\\EasyAccountNumber.txt"));
      numAccounts = numAccntsFileScnr.nextInt() - 1;
      numGameModeAccntsWriter = new PrintWriter ("Game Components\\Player Components\\EasyAccountNumber.txt");
      numGameModeAccntsWriter.println(numAccounts);
      numGameModeAccntsWriter.close();

      numAccntsFileScnr = new Scanner (new File ("Game Components\\Player Components\\MediumAccountNumber.txt"));
      numAccounts = numAccntsFileScnr.nextInt() + 1;
      numGameModeAccntsWriter = new PrintWriter ("Game Components\\Player Components\\MediumAccountNumber.txt");
      numGameModeAccntsWriter.println(numAccounts);
      numGameModeAccntsWriter.close();
     } catch (IOException ie) {} // try catch where gae mode files are altered
     new Medium ();
     break;
   } // Switch case based on level where the previous level frame is disposed and the frame for the next level is created (Creates a new Medium Object)
  } // levelComplete

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
  
  /** Easy Level 1 balls motion method*/
  public void ballsMoving()
  {
   if (yballUp == 72 && yballDown == 264)
    moveEasy *= -1;
   yballUp += moveEasy;
   yballDown -= moveEasy;
   if (yballUp == 264 && yballDown == 72)
    moveEasy *= -1;
  } // ballsMoving

  /** Easy Level 3 balls motion method 1*/
  public void breakOut()
  {
   if (xBallLeft < 168 && xBallRight > 264 && yBall == 72) 
   {
    xBallLeft += 4;
    xBallRight -= 4;
   } // if based on ball positions
   if (xBallLeft == 168 && xBallRight == 264 && yBall < 168) 
   {
    xBallLeft = 168;
    xBallRight = 264;
    yBall += 4;
   } // if based on ball positions
   if (yBall == 168 && xBallLeft > 72 && xBallRight < 360) 
   {
    yBall = 168;
    xBallLeft -= 4;
    xBallRight += 4;
   } // if based on ball positions
   if (xBallLeft == 72 && xBallRight == 360 && yBall > 72)
    yBall -= 4;
  } // breakOut

  /** Easy Level 3 balls motion method 2*/
  public void loneRanger()
  {
   if (yLong == 104 && xLong < 264)
    xLong += 4;
   if (xLong == 264 && yLong < 328)
    yLong += 4;
   if (yLong == 328 && xLong > 168)
    xLong -= 4;
   if (xLong == 168 && yLong > 104)
    yLong -= 4;
  } // loneRanger

  /** Easy Level 4 balls motion method 1*/
  public void squares()
  {
   if (ySquare == 72 && xSquare < 104)
    xSquare += 4;
   if (xSquare == 104 && ySquare < 104)
    ySquare += 4;
   if (ySquare == 104 && xSquare > 72)
    xSquare -= 4;
   if (xSquare == 72 && ySquare > 72)
    ySquare -= 4;
  } // squares

  /** Easy Level 4 balls motion method 2*/
  public void lShape()
  {
   if (yLTop == 232 && xLTop < 360 && !crossice)
    xLTop += 4;
   if (xLTop == 360 && yLTop > 136 && !putitdownonme) 
   {
    yLTop -= 4;
    if (yLTop == 136)
     putitdownonme = true;
   } // if based on ball positions
   if (putitdownonme)
   {
    if (yLTop < 232)
     yLTop += 4;
    else if (yLTop == 232) 
    {
     crossice = true;
     putitdownonme = false;
    } // else if based on ball positions
   } // if based on ball positions
   if (xLTop > 328 && crossice)
   {
    xLTop -= 4;
    if (xLTop == 328)
     crossice = false;
   } // if based on ball positions
  } // lShape

  /** Easy Level 4 balls motion method 3*/
  public void lSide()
  {
   if (yLSide == 328 && xLSide < 568 && !cross)
    xLSide += 4;
   if (xLSide == 568 && yLSide < 360 && !down) 
   {
    yLSide += 4;
    if (yLSide == 360)
     down = true;
   } // if based on ball positions
   if (down) 
   {
    if (yLSide > 328)
     yLSide -= 4;
    else if (yLSide == 328) 
    {
     cross = true;
     down = false;
    } // else if based on ball positions
   } // if based on ball positions
   if (xLSide > 488 && cross) 
   {
    xLSide -= 4;
    if (xLSide == 488)
     cross = false;
   } // if based on ball positions
  } // lSide

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
    case 1: // Easy level 1 display and checking for collision
     int xTop;
     int xBottom;
     for (int i = 0; i < blueBalls.getNumBalls(); i++) // Displays each pair of balls going up and down and checks if there is a collision for any
     {
      // Get positions
      xTop = balls_top[i] * 32 + 8;
      xBottom = balls_bottom[i] * 32 + 8;
      // Display balls
      g.drawImage(blueBalls.getBall(), xTop, yballUp, null);
      g.drawImage(blueBalls.getBall(), xBottom, yballDown, null);
      // Check for collision
      if (collision(xTop + 8, yballUp + 8) || collision(xBottom + 8, yballDown + 8))
       playerIsHit = true;
     } // For displays each pair of balls going up and down and checks for a collision for any   
     
     // Display coin based on its transparency
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal));
     g2d.drawImage(c.getCoin(), c.getCoinX() * 32 + 24, c.getCoinY() * 32 + 8, null);
     break;

    case 2: // Easy level 2 display and checking for collision
     for (int i = 0; i < blueBalls.getNumBalls(); i++) // Displays each unit of balls in circular motion and checks if there is a collision for any
     {
      // Get positions
      xCircleUp = (int)(Math.cos(angleUp) * (280 - (160 + 24 * i)) + 288);
      yCircleUp = (int)(Math.sin(angleUp) * (280 - (160 + 24 * i)) + 288);
      xCircleDown = (int)(Math.cos(angleDown) * ((304 + 24 * i) - 280) + 288);
      yCircleDown = (int)(Math.sin(angleDown) * ((304 + 24 * i) - 280) + 288);
      xCircleLeft = (int)(Math.cos(angleLeft) * (280 - (160 + 24 * i)) + 288);
      yCircleLeft = (int)(Math.sin(angleLeft) * (280 - (160 + 24 * i)) + 288);
      xCircleRight = (int)(Math.cos(angleRight) * ((304 + 24 * i) - 280) + 288);
      yCircleRight = (int)(Math.sin(angleRight) * ((304 + 24 * i) - 280) + 288);
      // Display balls
      g.drawImage(blueBalls.getBall(), xCircleUp - 8, yCircleUp - 8, null);
      g.drawImage(blueBalls.getBall(), xCircleDown - 8, yCircleDown - 8, null);
      g.drawImage(blueBalls.getBall(), xCircleLeft - 8, yCircleLeft - 8, null);
      g.drawImage(blueBalls.getBall(), xCircleRight - 8, yCircleRight - 8, null);
      // Check for collision
      if (collision(xCircleUp, yCircleUp) || collision(xCircleDown, yCircleDown) || collision(xCircleRight, yCircleRight) || collision(xCircleLeft, yCircleLeft))
       playerIsHit = true;
     } // For displays each unit of balls in circular motion
     g.drawImage(blueBalls.getBall(), 280, 280, null); // Display center ball    
     
     // Display coins based on their transparency
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal1));
     g2d.drawImage(c.getCoin(), coins2[0] * 32 + 24, coins2[1] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal2));
     g2d.drawImage(c.getCoin(), coins2[2] * 32 + 8, coins2[3] * 32 + 24, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal3));
     g2d.drawImage(c.getCoin(), coins2[4] * 32 + 24, coins2[5] * 32 + 8, null);
     break;
     
    case 3: // Easy level 3 display and checking for collision
     // Display balls (positions already acquired in breakOut method)
     g.drawImage(blueBalls.getBall(), xBallLeft, yBall, null);
     g.drawImage(blueBalls.getBall(), xBallRight, yBall, null);
     g.drawImage(blueBalls.getBall(), xBallLeft, yBall + 96, null);
     g.drawImage(blueBalls.getBall(), xBallLeft, yBall + 192, null);
     g.drawImage(blueBalls.getBall(), xBallRight, yBall + 96, null);
     g.drawImage(blueBalls.getBall(), xBallRight, yBall + 192, null);
     // Check for collision
     if (collision(xBallLeft + 8, yBall + 8) || collision(xBallLeft + 8, yBall + 104) || collision(xBallLeft + 8, yBall + 200) || collision(xBallRight + 8, yBall + 8) || collision(xBallRight + 8, yBall + 104) || collision(xBallRight + 8, yBall + 200) || collision(xLong + 8, yLong + 8))
      playerIsHit = true;
     g.drawImage(blueBalls.getBall(), xLong, yLong, null); // Display ball going in rectangular motion (position already accquired in loneRanger method)
     
     // Display coins based on their transparency
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal1));
     g2d.drawImage(c.getCoin(), coins4[0] * 32 + 8, coins4[1] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal2));
     g2d.drawImage(c.getCoin(), coins4[2] * 32 + 8, coins4[3] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal3));
     g2d.drawImage(c.getCoin(), coins4[4] * 32 + 8, coins4[5] * 32 + 8, null);
     break;
     
    case 4: // Easy level 4 display and checking for collision
     // Display balls (positions already acquired in breakOut method)
     g.drawImage(blueBalls.getBall(), xSquare, ySquare + 64, null);
     g.drawImage(blueBalls.getBall(), xSquare + 128, ySquare + 64, null);
     g.drawImage(blueBalls.getBall(), xSquare, ySquare + 256, null);
     g.drawImage(blueBalls.getBall(), xSquare + 128, ySquare + 256, null);
     g.drawImage(blueBalls.getBall(), xSquare + 256, ySquare, null);
     g.drawImage(blueBalls.getBall(), xSquare + 384, ySquare, null);
     g.drawImage(blueBalls.getBall(), xSquare + 512, ySquare, null);
     g.drawImage(blueBalls.getBall(), xSquare + 384, ySquare + 192, null);
     // Check for collision
     if (collision(xSquare + 8, ySquare + 72) || collision(xSquare + 136, ySquare + 72) || collision(xSquare + 8, ySquare + 264) || collision(xSquare + 136, ySquare + 264) || collision(xSquare + 264, ySquare + 8) || collision(xSquare + 392, ySquare + 8) || collision(xSquare + 520, ySquare + 8) || collision(xSquare + 392, ySquare + 200) || collision(xLTop + 8, yLTop + 8) || collision(xLSide + 8, yLSide + 8))
       playerIsHit = true;
     // Display static balls  
     g.drawImage(blueBalls.getBall(), xLTop, yLTop, null);
     g.drawImage(blueBalls.getBall(), xLSide, yLSide, null);
     g.drawImage(blueBalls.getBall(), 104, 216, null);
     g.drawImage(blueBalls.getBall(), 72, 280, null);
     g.drawImage(blueBalls.getBall(), 152, 328, null);
     g.drawImage(blueBalls.getBall(), 200, 280, null);
     g.drawImage(blueBalls.getBall(), 248, 264, null);
     g.drawImage(blueBalls.getBall(), 104, 216, null);
     g.drawImage(blueBalls.getBall(), 296, 296, null);
     g.drawImage(blueBalls.getBall(), 328, 152, null);
     g.drawImage(blueBalls.getBall(), 104, 216, null);
     g.drawImage(blueBalls.getBall(), 152, 136, null);
     g.drawImage(blueBalls.getBall(), 200, 88, null);
     g.drawImage(blueBalls.getBall(), 280, 104, null);
     g.drawImage(blueBalls.getBall(), 536, 104, null);
     g.drawImage(blueBalls.getBall(), 456, 184, null);
     g.drawImage(blueBalls.getBall(), 456, 344, null);
     // Check for static balls collision
     if (collision(464, 352) || collision(464, 192) || collision(112, 224) || collision(80, 288) || collision(160, 336) || collision(208, 288) || collision(256, 272) || collision(112, 224) || collision(304, 304) || collision(336, 160) || collision(112, 224) || collision(160, 144) || collision(208, 96) || collision(288, 112) || collision(544, 112))
      playerIsHit = true;
     
     // Display coins based on their transparency
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal));
     g2d.drawImage(c.getCoin(), c.getCoinX() * 32 + 8, c.getCoinY() * 32 + 8, null);
     break;
    
    case 5: // Easy level 5 display and checking for collision
     for (int i = 0; i < blueBalls.getNumBalls(); i++) // Displays each ball that is going in relatively tight circular motion (with same directions)
     {
      // Get positions
      xUp1 = (int)(Math.cos(angleUp) * 48 + 192);
      yUp1 = (int)(Math.sin(angleUp) * 48 + 128);
      yUpA = (int)(Math.sin(angleUp) * 48 + 320);
      xDown1 = (int)(Math.cos(angleDown) * 48 + 192);
      yDown1 = (int)(Math.sin(angleDown) * 48 + 128);
      yDownA = (int)(Math.sin(angleDown) * 48 + 320);
      xRight1 = (int)(Math.cos(angleRight) * 48 + 192);
      yRight1 = (int)(Math.sin(angleRight) * 48 + 128);
      yRightA = (int)(Math.sin(angleRight) * 48 + 320);
      xLeft1 = (int)(Math.cos(angleLeft) * 48 + 192);
      yLeft1 = (int)(Math.sin(angleLeft) * 48 + 128);
      yLeftA = (int)(Math.sin(angleLeft) * 48 + 320);
      xUp2 = (int)(Math.cos(angleUp) * 48 + 320);
      yUp2 = (int)(Math.sin(angleUp) * 48 + 128);
      yUpB = (int)(Math.sin(angleUp) * 48 + 320);
      xDown2 = (int)(Math.cos(angleDown) * 48 + 320);
      yDown2 = (int)(Math.sin(angleDown) * 48 + 128);
      yDownB = (int)(Math.sin(angleDown) * 48 + 320);
      xRight2 = (int)(Math.cos(angleRight) * 48 + 320);
      yRight2 = (int)(Math.sin(angleRight) * 48 + 128);
      yRightB = (int)(Math.sin(angleRight) * 48 + 320);
      xLeft2 = (int)(Math.cos(angleLeft) * 48 + 320);
      yLeft2 = (int)(Math.sin(angleLeft) * 48 + 128);
      yLeftB = (int)(Math.sin(angleLeft) * 48 + 320);
      xUp3 = (int)(Math.cos(angleUp) * 48 + 448);
      yUp3 = (int)(Math.sin(angleUp) * 48 + 128);
      yUpC = (int)(Math.sin(angleUp) * 48 + 320);
      xDown3 = (int)(Math.cos(angleDown) * 48 + 448);
      yDown3 = (int)(Math.sin(angleDown) * 48 + 128);
      yDownC = (int)(Math.sin(angleDown) * 48 + 320);
      xRight3 = (int)(Math.cos(angleRight) * 48 + 448);
      yRight3 = (int)(Math.sin(angleRight) * 48 + 128);
      yRightC = (int)(Math.sin(angleRight) * 48 + 320);
      xLeft3 = (int)(Math.cos(angleLeft) * 48 + 448);
      yLeft3 = (int)(Math.sin(angleLeft) * 48 + 128);
      yLeftC = (int)(Math.sin(angleLeft) * 48 + 320);
      xUp4 = (int)(Math.cos(angleUp) * 48 + 576);
      yUp4 = (int)(Math.sin(angleUp) * 48 + 128);
      yUpD = (int)(Math.sin(angleUp) * 48 + 320);
      xDown4 = (int)(Math.cos(angleDown) * 48 + 576);
      yDown4 = (int)(Math.sin(angleDown) * 48 + 128);
      yDownD = (int)(Math.sin(angleDown) * 48 + 320);
      xRight4 = (int)(Math.cos(angleRight) * 48 + 576);
      yRight4 = (int)(Math.sin(angleRight) * 48 + 128);
      yRightD = (int)(Math.sin(angleRight) * 48 + 320);
      xLeft4 = (int)(Math.cos(angleLeft) * 48 + 576);
      yLeft4 = (int)(Math.sin(angleLeft) * 48 + 128);
      yLeftD = (int)(Math.sin(angleLeft) * 48 + 320);
      // Display balls
      g.drawImage(blueBalls.getBall(), xUp1 - 8, yUp1 - 8, null);
      g.drawImage(blueBalls.getBall(), xDown1 - 8, yDown1 - 8, null);
      g.drawImage(blueBalls.getBall(), xRight1 - 8, yRight1 - 8, null);
      g.drawImage(blueBalls.getBall(), xLeft1 - 8, yLeft1 - 8, null);  
      g.drawImage(blueBalls.getBall(), xUp2 - 8, yUp2 - 8, null);
      g.drawImage(blueBalls.getBall(), xDown2 - 8, yDown2 - 8, null);
      g.drawImage(blueBalls.getBall(), xRight2 - 8, yRight2 - 8, null);
      g.drawImage(blueBalls.getBall(), xLeft2 - 8, yLeft2 - 8, null);
      g.drawImage(blueBalls.getBall(), xUp3 - 8, yUp3 - 8, null);
      g.drawImage(blueBalls.getBall(), xDown3 - 8, yDown3 - 8, null);
      g.drawImage(blueBalls.getBall(), xRight3 - 8, yRight3 - 8, null);
      g.drawImage(blueBalls.getBall(), xLeft3 - 8, yLeft3 - 8, null);
      g.drawImage(blueBalls.getBall(), xUp4 - 8, yUp4 - 8, null);
      g.drawImage(blueBalls.getBall(), xDown4 - 8, yDown4 - 8, null);
      g.drawImage(blueBalls.getBall(), xRight4 - 8, yRight4 - 8, null);
      g.drawImage(blueBalls.getBall(), xLeft4 - 8, yLeft4 - 8, null);
      g.drawImage(blueBalls.getBall(), xUp1 - 8, yUpA - 8, null);
      g.drawImage(blueBalls.getBall(), xDown1 - 8, yDownA - 8, null);
      g.drawImage(blueBalls.getBall(), xRight1 - 8, yRightA - 8, null);
      g.drawImage(blueBalls.getBall(), xLeft1 - 8, yLeftA - 8, null);
      g.drawImage(blueBalls.getBall(), xUp2 - 8, yUpB - 8, null);
      g.drawImage(blueBalls.getBall(), xDown2 - 8, yDownB - 8, null);
      g.drawImage(blueBalls.getBall(), xRight2 - 8, yRightB - 8, null);
      g.drawImage(blueBalls.getBall(), xLeft2 - 8, yLeftB - 8, null);
      g.drawImage(blueBalls.getBall(), xUp3 - 8, yUpC - 8, null);
      g.drawImage(blueBalls.getBall(), xDown3 - 8, yDownC - 8, null);
      g.drawImage(blueBalls.getBall(), xRight3 - 8, yRightC - 8, null);
      g.drawImage(blueBalls.getBall(), xLeft3 - 8, yLeftC - 8, null);
      g.drawImage(blueBalls.getBall(), xUp4 - 8, yUpD - 8, null);
      g.drawImage(blueBalls.getBall(), xDown4 - 8, yDownD - 8, null);
      g.drawImage(blueBalls.getBall(), xRight4 - 8, yRightD - 8, null);
      g.drawImage(blueBalls.getBall(), xLeft4 - 8, yLeftD - 8, null); 
      
      // Check for collision
      if (collision(xUp1, yUp1) || collision(xDown1, yDown1) || collision(xRight1, yRight1) || collision(xLeft1, yLeft1) || collision(xUp2, yUp2) || (collision(xDown2, yDown2) || collision(xRight2, yRight2) || collision(xLeft2, yLeft2) || collision(xUp3, yUp3) || collision(xDown3, yDown3) || collision(xRight3, yRight3) || collision(xLeft3, yLeft3) || collision(xUp4, yUp4) || collision(xDown4, yDown4) || collision(xRight4, yRight4) || collision(xLeft4, yLeft4) || collision(xUp1, yUpA) || collision(xDown1, yDownA) || collision(xRight1, yRightA) || collision(xLeft1, yLeftA) || collision(xUp2, yUpB) || collision(xDown2, yDownB) || collision(xLeft2, yLeftB) || collision(xRight2, yRightB) || collision(xUp3, yUpC) || collision(xDown3, yDownC) || collision(xLeft3, yLeftC) || collision(xRight3, yRightC) || collision(xUp4, yUpD) || collision(xDown4, yDownD) || collision(xRight4, yRightD) || collision(xLeft4, yLeftD)))
       playerIsHit = true;
     } // Displays each ball that is going in relatively tight circular motion (with same directions)
     
     // Display coins based on their transparency
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal1));
     g2d.drawImage(c.getCoin(), coins3[0] * 32 + 8, coins3[1] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal2));
     g2d.drawImage(c.getCoin(), coins3[2] * 32 + 8, coins3[3] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal3));
     g2d.drawImage(c.getCoin(), coins3[4] * 32 + 8, coins3[5] * 32 + 8, null);
     g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, coinTransparencyVal4));
     g2d.drawImage(c.getCoin(), coins3[6] * 32 + 8, coins3[7] * 32 + 8, null);
     break;
   } // Switch case based on level where obstacles and coin for corresponding levels are visually displayed (and it checks if the player collided with the ball)
   
   // Display player based on its transparency
   g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, playerTransparencyVal));
   g2d.drawImage(p.getPlayer(), p.getTileX() * 32 + 6, p.getTileY() * 32 + 6, null);
  } // paint
  
  /** Moves the player by registering certain key events */
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
     case 1: // Easy level 1 checks based on player position
      if ((coins == 0) && ((p.getTileX() == 17) && (p.getTileY() >= 4 && p.getTileY() <= 6)))
       levelComplete();
      break;
     
     case 2: // Easy level 2 checks based on player position
      if ((coins == 0) && ((p.getTileX() == 4) && (p.getTileY() == 8 || p.getTileY() == 9)))
       levelComplete();
      break;
     
     case 3: // Easy level 3 checks based on player position
      if ((coins == 0) && (p.getTileX() == 12 && (p.getTileY() == 6 || p.getTileY() == 7)))
       levelComplete();
      break;
     
     case 4: // Easy level 4 checks based on player position
      if ((p.getTileX() == 10 || p.getTileX() == 11) && p.getTileY() == 8)
       checkpoint = true;
      if ((coins == 0) && ((p.getTileX() == 18 || p.getTileX() == 19) && p.getTileY() == 6))
       levelComplete();
      break;
     
     case 5: // Easy level 5 checks based on player position
      if ((p.getTileX() >= 16 && p.getTileX() <= 19) && p.getTileY() == 6)
       checkpoint = true;
      if ((coins == 0) && ((p.getTileX() == 2 || p.getTileX() == 3) && (p.getTileY() == 10 || p.getTileY() == 11)))
       levelComplete();
      break;
    } // switch case based on level where level completion if the user reaches a certain tile and if coins are 0 or if a checkpoint locationis reached
   } // keyPressed
   
   /** If key is released (not used)*/public void keyReleased(KeyEvent e) {}
   /** If key is typed (not used)*/public void keyTyped(KeyEvent e) {}
  } // Move
 } // DrawMaze
} // Easy class