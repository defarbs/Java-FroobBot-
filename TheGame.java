//HELPFUL : http://www.javacoffeebreak.com/text-adventure/index.html

package froobbot;

import java.util.*;

public class TheGame {
	
	Scanner myScanner = new Scanner(System.in);
	Scanner enterScanner = new Scanner(System.in);
        
	int playerHP;
        int playerCash;
        int wellCoinCount;
	int choice;
	int monsterHP;
        int silverRing;
        int prizeClaimed = 0;
        int arrows;
        
        String knife = "Knife";
        String longSword = "Long Sword";
        String bow = "Bow";
        String weightedHammer = "Weighted Hammer";
	String playerName;
	String playerWeapon;
        String playerSideArm;
        
	boolean goldKey = false;
       
	public static void Start(String[] args) {

		TheGame dublin;
		dublin = new TheGame();	
		
		dublin.playerSetUp();
                
	}
	
	public void playerSetUp() {
		
		playerHP = 15;
		monsterHP = 15;
                playerCash = 100;

		playerWeapon = knife;

		System.out.println("> Your HP is: "+ playerHP);
		System.out.println("> Your Weapon: "+ playerWeapon);
                System.out.println("> Your Sidearm: (empty)");
                System.out.println("> You currently have $" + playerCash);
		
                System.out.println("");
		System.out.println("> Please enter a username: ");
                System.out.print("> ");
		
		playerName = myScanner.nextLine();
                
                usernameVerify();
	}	
        
        public void usernameVerify() {
            
            System.out.println("");
            System.out.println("You have entered '" + playerName + "' as your username. Is this correct?");
            System.out.println("Note: You will not be able to change this later!");
            System.out.println("");
            System.out.println("1. Yes, this is correct");
            System.out.println("2. No, I want to change it");
            System.out.print("> ");
            
            choice = myScanner.nextInt();
            
            if(choice==1) {
                
                System.out.println("Sounds good, " + playerName + ", let's start the game!");
                System.out.println("");
                
                townGate();
                
            } else if(choice==2) {
                
                System.out.println("");
                System.out.println("> Please enter a new username: ");
                System.out.print("> ");
                
                playerName = myScanner.next();
                
                usernameVerify();
                
            } else {
                
                System.out.println("This is not a valid input! Try again, please.");
                
                usernameVerify();
                
            }
            
        }
	
	public void townGate(){
		
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("> You are at the gate of a town.");
		System.out.println("> A guard is standing in front of you.");
		System.out.println("");
		System.out.println("> What do you want to do?");
		System.out.println("");
		System.out.println("1: Talk to the guard");
		System.out.println("2: Attack the guard");
		System.out.println("3: Leave the town to explore elsewhere");
		System.out.println("\n------------------------------------------------------------------\n");
                System.out.print("> ");

		choice = myScanner.nextInt();
                
		
		if(choice==1){
                    
			if(silverRing==1){
                            
				townEntry();
                                
			} else {
                            
				System.out.println("> Guard: Hello there, stranger. So your name is " + playerName + "? \n> Sorry, but we cannot let a stranger enter our town.");
                                System.out.println("> Press enter to continue.");
                                System.out.print("> ");
                                
				enterScanner.nextLine();
                                
				townGate();
                                
			}
			
		}
                
		else if(choice==2 && playerHP>=2) {
                    
			playerHP = playerHP-1;
                        
			System.out.println("> Guard: Hey, don't be stupid!\n\n> **The guard hit you so hard that you gave up.**\n> (You received 1 damage)\n");
			System.out.println("> Your HP is: " + playerHP);
                        System.out.println("> Press enter to continue.");
                        System.out.print("> ");
                        
			enterScanner.nextLine();
                        
			townGate();
                        
		} else if(choice==2 && playerHP<2) {
                    
                        lowHealthDeath();
                        endingRIP();
                        
                } else if(choice==3){
                    
			crossRoad();
                        
                } else {
                    
			townGate();
                        
		}
                
	}
	
	public void crossRoad(){
            
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("> You are at a crossroad. If you head south, you will go back to the town.\n\n");
		System.out.println("1: Head north");
		System.out.println("2: Head east");
		System.out.println("3: Head south");
		System.out.println("4: Head west");
		System.out.println("\n------------------------------------------------------------------\n");
                System.out.print("> ");
		
		choice = myScanner.nextInt();
		
		if(choice==1){
                    
			north();
		}
                
		else if(choice==2){
                    
			east();
		}
                
		else if(choice==3){
                    
			townGate();
		}
                
		else if(choice==4){
                    
			west();
		}
                
		else{
			crossRoad();
                        
		}
                
	}
	
	public void north(){
            
                if (playerHP == 20) {
                    
                    System.out.println("> Your HP is maxed out! You cannot drink more water.");
                    
                } else {
                    
                    System.out.println("\n------------------------------------------------------------------\n");
                    System.out.println("> There is a river. You drink the water and rest at the riverside.");
                    System.out.println("> Your HP has gained (+1).");
                    
                    playerHP = playerHP + 1;
                    
                }
                
		System.out.println("> Your HP is: " + playerHP);
		System.out.println("\n\n1: Head back to the crossroad");
		System.out.println("\n------------------------------------------------------------------\n");
                System.out.print("> ");
                
		choice = myScanner.nextInt();
		
		if(choice==1){
                    
			crossRoad();
                        
		}
                
                else {
                    
			north();
                        
		}
                
	}
	
	public void east(){
            
            if(playerWeapon.equals(knife)) {
                
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("> You walked into a forest and found a Long Sword!");
                
		playerWeapon = longSword;
                playerSideArm = knife;
                
		System.out.println("> Your Weapon: "+ playerWeapon);
                System.out.println("> Your Sidearm: "+ playerSideArm);
                
            } else {
                
                System.out.println("\n------------------------------------------------------------------\n");
                System.out.println("> You return to the forest, but find nothing lying around. Maybe look elsewhere?");
                
            }
            
		System.out.println("\n\n1: Head back to the crossroad");
		System.out.println("\n------------------------------------------------------------------\n");
                System.out.print("> ");
		
		choice = myScanner.nextInt();
		
		if(choice==1){
                    
			crossRoad();
		}
                
                else {
                    
			east();
                        
		}
                
	}
	
	public void west(){
            
            if(monsterHP>0) {
                
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("> You encounter a goblin guarding a bridge!\n");
		System.out.println("1: Stay and fight");
		System.out.println("2: Run away");
		System.out.println("\n------------------------------------------------------------------\n");
                System.out.print("> ");
		
		choice = myScanner.nextInt();
		
		if(choice==1){
                    
			fightGoblin();
                        
		}
		else if(choice==2){
                    
			crossRoad();
                        
		}
            } else {
                
		System.out.println("The goblin is dead, and you obtained the key! Head south to return to the Town Gate.");
                
                crossRoad();
                
            }
            
	}
	
	public void fightGoblin(){
            
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("> Your HP is: "+ playerHP);
		System.out.println("> Goblin HP: " + monsterHP);
		System.out.println("\n1: Attack");
		System.out.println("2: Run away");
		System.out.println("\n------------------------------------------------------------------\n");
                System.out.print("> ");
		
		choice = myScanner.nextInt();
		
		if(choice==1){
                    
			attack();
                        
		}
		else if(choice==2){
                    
			crossRoad();
                        
		}
                else {
                    
			fightGoblin();
                        
		}
                
	}
	
	public void attack(){
            
		int primaryPlayerDamage = 0;
                int secondaryPlayerDamage = 0;
		
		
		if(playerWeapon.equals(knife) || playerSideArm.equals(longSword)){
                    
			primaryPlayerDamage = new java.util.Random().nextInt(3); 
                        
		}
		else if(playerWeapon.equals(longSword) || playerSideArm.equals(knife)){
                    
			primaryPlayerDamage = new java.util.Random().nextInt(8);
                        
                        
		} else if(playerSideArm.equals(knife) && playerWeapon.equals(longSword)){
                    
                        secondaryPlayerDamage = new java.util.Random().nextInt(3);
                        
                        
                } else if(playerSideArm.equals(longSword) && playerWeapon.equals(knife)){
                    
                        secondaryPlayerDamage = new java.util.Random().nextInt(8);
                        
                }
		
		System.out.println("> You attacked the goblin and dealt " + primaryPlayerDamage + " damage!");
		
		monsterHP = monsterHP - primaryPlayerDamage;
		
		System.out.println("> Goblin HP: " + monsterHP);
		
		if(monsterHP<1){ win(); } else if(monsterHP>0){
                    
			int monsterDamage = 0;
			
			monsterDamage = new java.util.Random().nextInt(4);
			
			System.out.println("> The goblin attacked you and dealt " + monsterDamage + " damage!");
			
			playerHP = playerHP - monsterDamage;
			
			System.out.println("> Player HP: " + playerHP);
			
			if(playerHP<1){ monsterDmgDeath(); } else if(playerHP>0){
                            
				fightGoblin();
                                
			}
                        
		}
	
        }
	
	public void lowHealthDeath(){
            
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("> Your health dropped too low, and you died!");
		System.out.println("\n\n> GAME OVER");
		System.out.println("\n------------------------------------------------------------------\n");
                
	}
        
        public void monsterDmgDeath(){
            
                System.out.println("\n------------------------------------------------------------------\n");
                System.out.println("> You died! Maybe try searching for a better weapon next time?");
                System.out.println("\n\n> GAME OVER");
                System.out.println("\n------------------------------------------------------------------\n");
                
        }
	
	public void win(){
            
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("> You killed the goblin!");
		System.out.println("> The goblin dropped a ring!");
		System.out.println("> You obtained a silver ring!\n\n");
		System.out.println("1: Head east");
		System.out.println("\n------------------------------------------------------------------\n");
                System.out.print("> ");
		
		silverRing = 1;
		
		choice = myScanner.nextInt();
                
		if(choice==1){
                    
			crossRoad();
                        
		}
		else{
                    
			win();
                        
		}
		
	}
        
        public void enterTown() {
            
            System.out.println("> You've entered the town of Dublin. A towny approaches... \n");
            System.out.println("");
            System.out.println("> George the Towny: Welcome to our town, " + playerName + "!");
            System.out.println("> George the Towny: Please take time to explore! ");
            System.out.println("");
            
            townLocations();
            
        }
        
        public void townLocations() {
            
            if(goldKey == true) {
                
                System.out.println("> It would appear you bestow the sacred gold key of the castle.");
                System.out.println("> You may leave for the castle, or continue to venture within the town: ");
                System.out.println("");
                System.out.println("1. Head to the church");
                System.out.println("2. Head to the shop");
                System.out.println("3. Head to the bakery");
                System.out.println("4. Head to the wishing well");
                System.out.println("5. Head to the King's Castle");
                System.out.print("> ");
                
                choice = myScanner.nextInt();
                
                if(choice==1) {
                    
                    goToChurch();
                    
                } else if(choice==2) {
                    
                    goToShop();
                    
                } else if(choice==3) {
                    
                    goToBakery();
                    
                } else if(choice==4) {
                    
                    goToWell();
                    
                } else if(choice==5) {
                    
                    goToCastle();
                    
                } else {
                    
                    System.out.println("> Not a valid choice. Please try again.");
                    System.out.println("");
                    
                    townLocations();
                    
                }
                
            } else {
                
                System.out.println("> Choose a location to venture within the town: ");
                System.out.println("");
                System.out.println("1. Head to the church");
                System.out.println("2. Head to the shop");
                System.out.println("3. Head to the bakery");
                System.out.println("4. Head to the wishing well");
                System.out.println("5. Head to the King's Castle");
                System.out.print("> ");
            
                choice = myScanner.nextInt();
            
                if(choice==1) {
                    
                    goToChurch();
                    
                } else if(choice==2) {
                    
                    goToShop();
                    
                } else if(choice==3) {
                    
                    goToBakery();
                    
                } else if(choice==4) {
                    
                    goToWell();
                    
                } else if(choice==5) {
                    
                    if(goldKey==false) {
                        
                        System.out.println("");
                        System.out.println("You cannot travel here, yet. You are missing a sacred object...");
                        System.out.println("");
                        
                        townLocations();
                        
                    } else if(goldKey==true) {
                        
                        goToCastle();
                        
                    }
                    
                } else {
                    
                    System.out.println("> Not a valid choice. Please try again.");
                    System.out.println("");
                    
                    townLocations();
                    
                }
                
            }
            
        }
        
        public void goToChurch() {
            
            System.out.println("");
            System.out.println("> You arrive at the church. A priest stands out front. \n");
            System.out.println("> Priest Joseph: Greetings, friend. How may I assist you today? \n");
            System.out.println("");
            System.out.println("1. Attack Joseph");
            System.out.println("2. Ask Joseph, 'What is the meaning of life?'");
            System.out.println("3. Ask Joseph about the history of the town");
            System.out.println("4. Return to the Town Gate");
            System.out.print("> ");
            
            choice = myScanner.nextInt();
            
            if(choice==1) {
                
                System.out.println("> You have attacked the Holy Priest of Dublin! You are to be put to death at once!");
                
                lowHealthDeath();
                
            } else if(choice==2) {
                
                System.out.println("> Priest Joseph: Well, " + playerName + ", the meaning of life is determined\nby the assumptions of the one asking the question. \nIf "
                + "the meaning of life seems unclear to you, maybe you should spend time\nre-evaluating your priorities, and then come back to me when you feel\nyou have an answer.");
                
                churchMenu();
                
            } else if(choice==3) {
                
                System.out.println("> Priest Joseph: The town of Dublin was founded in 1793 by Sir Hamilton von Kassich III. \nHe was a noble man, who decided the town would be a lovely " 
                + "place for generations of families to reside.\n The town was once a shallow valley, grazed on by wild boars and other animals.\nIt now has a population consisting of" +
                        " 590 residents. \nIf you prove yourself, maybe you can be dubbed the 591st.");
                
                churchMenu();
                
            } else if(choice==4) {
                
                System.out.println("");
                
                townLocations();
                
            } else {
                
                System.out.println("> Not a valid choice. Please try again.");
                System.out.println("");
                
                churchMenu();
                
            }
            
        }
	
        public void churchMenu() {
            
            System.out.println("");
            System.out.println("1. Attack Joseph");
            System.out.println("2. Ask Joseph, 'What is the meaning of life?'");
            System.out.println("3. Ask Joseph about the history of the town");
            System.out.println("4. Return to the Town Gate");
            System.out.print("> ");
            
            choice = myScanner.nextInt();
            
            if(choice==1) {
                
                System.out.println("> You have attacked the Holy Priest of Dublin! You are to be put to death at once!");
                
                lowHealthDeath();
                
            } else if(choice==2) {
                
                System.out.println("> Priest Joseph: Well, " + playerName + ", the meaning of life is determined by the assumptions of the one asking the question. \n If "
                + "the meaning of life seems unclear to you, maybe you should spend time re-evaluating your priorities, and then come back to me when you feel you have an answer.");
                
                churchMenu();
                
            } else if(choice==3) {
                
                System.out.println("> Priest Joseph: The town of Dublin was founded in 1793 by Sir Hamilton von Kassich III. He was a noble man, who decided the town would be a lovely " 
                + "place for generations of families to reside. The town was once a shallow valley, grazed on by wild boars\nand other animals. It now has a population consisting of" +
                        " 590 residents. If you prove yourself, maybe you can be dubbed the 591st.");
                
                churchMenu();
                
            } else if(choice==4) {
                
                System.out.println("");
                
                townLocations();
                
            } else {
                
                System.out.println("> Not a valid choice. Please try again.");
                System.out.println("");
                
                churchMenu();
                
            }
            
        }        
        
        public void goToShop() {
            
                System.out.println("> Welcome to the Dublin Shop of Trade Goods!");
                System.out.println("> Shopkeeper: Hello there, what can I help you with today?");
                System.out.println("");
                System.out.println("Your current balance is: $" + playerCash);
                System.out.println("");
                
                System.out.println("1. Purchase Bow ($10)");
                System.out.println("2. Purchase Arrows[100] ($10)");
                System.out.println("3. Purchase Weighted Hammer ($25)");
                System.out.println("4. Taunt Shopkeeper");
                System.out.println("5. Attack Shopkeeper");
                System.out.println("6. Return to Town Gate");
                System.out.println("7. Claim Prize");
                System.out.print("> ");
                
                choice = myScanner.nextInt();

                if (choice==1 && playerCash>=10) {
                    
                     if (playerWeapon.equals(bow) || playerSideArm.equals(bow)) {
                         
                        System.out.println("> You already have this weapon equipped!");
                        
                        shopMenu();
                    }
                     
                    playerCash = playerCash - 10;
                    
                    System.out.println("> You have purchased a Bow!");
                    System.out.println("> Your current balance is: $" + playerCash);
                    System.out.println("");
                    
                    System.out.println("> Would you like this to be your primary weapon, or your sidearm?");
                    System.out.println("1. Primary Weapon");
                    System.out.println("2. Sidearm");
                    System.out.print("> ");
                    
                    choice = myScanner.nextInt();
                    
                    if(choice==1) {
                        
                        playerWeapon = bow;
                        
                        System.out.println("Set " + bow + " as Primary Weapon.");
                        
                        shopMenu();
                        
                    } else if(choice==2) {
                        
                        playerSideArm = bow;
                        
                        System.out.println("Set " + bow + " as Sidearm.");
                        
                        shopMenu();
                        
                    }
                    
                } else if(choice==2 && playerCash>=10) {
                    
                    if (arrows>0 && arrows<=100) {
                        
                        System.out.println("");
                        System.out.println("> You already have arrows for your bow!");
                        System.out.println("> Wait until you run out to purchase more.");
                        
                        shopMenu();
                        
                    }
                    
                    playerCash = playerCash - 10;
                    arrows = arrows + 100;
                    
                    System.out.println("");
                    System.out.println("> You have purchased arrows for your bow!");
                    System.out.println("> Your current balance is: $" + playerCash);
                    
                    shopMenu();
                    
                } else if(choice==3 && playerCash>=25) {
                    
                    if (playerWeapon.equals(weightedHammer) || playerSideArm.equals(weightedHammer)) {
                        
                        System.out.println("> You already have this weapon equipped!");
                        
                        shopMenu();
                    }
                    
                    playerCash = playerCash - 25;
                    
                    System.out.println("> You have purchased a Weighted Hammer!");
                    System.out.println("> Your current balance is: $" + playerCash);
                    System.out.println("> Would you like this to be your primary weapon, or your sidearm?");
                    System.out.println("1. Primary Weapon");
                    System.out.println("2. Sidearm");
                    System.out.print("> ");
                    
                    choice = myScanner.nextInt();
                    
                    if(choice==1) {
                        
                        playerWeapon = weightedHammer;
                        
                        System.out.println("Set " + weightedHammer + " as Primary Weapon.");
                        
                        shopMenu();
                        
                    } else if(choice==2) {
                        
                        playerSideArm = weightedHammer;
                        
                        System.out.println("Set " + weightedHammer + " as Sidearm.");
                        
                        shopMenu();
                        
                    }
                    
                } else if(choice==4) {
                    
                    System.out.println("> " + playerName + " taunts the Shopkeeper!");
                    System.out.println("");
                    System.out.println("> Shopkeeper: Keep on running your mouth. See where it gets you.");
                    System.out.println("");
                    
                    shopMenu();
                    
                } else if(choice==5) {
                    
                    System.out.println("> " + playerName + " attacked the Shopkeeper!");
                    System.out.println("");
                    System.out.println("> Shopkeeper: You're going to regret doing such a thing!");
                    
                    playerHP = playerHP - 5;
                    
                    System.out.println("> The Shopkeeper dealt -5 damage to you with a hammer. Treat him nicely, please!");
                    System.out.println("> Your HP is now: " + playerHP);
                    
                    if(playerHP<=0) {
                        
                        lowHealthDeath();
                        
                    } else {
                        
                        shopMenu();
                        
                    }
                    
                } else if(choice==6) {
                    
                    townLocations();
                    
                } else if(choice==7 && wellCoinCount>=5 && prizeClaimed==0) {
                    
                        System.out.println("> You claimed a prize provided by the Wishing Well.");
                        
                        prizeClaimed = 1;
                        playerCash = playerCash + 50;
                        
                        System.out.println("");
                        System.out.println("> The Wishing Well has granted you with $50 for your acts of kindness!");
                        System.out.println("You currently have $" + playerCash);
                        
                        shopMenu();
                        
                } else if(choice==7 && wellCoinCount<5 && prizeClaimed==0) {
                    
                    System.out.println("You cannot claim your prize... yet.");
                    
                    shopMenu();
                    
                } else if(choice==7 && wellCoinCount>=5 && prizeClaimed==1) {
                    
                    System.out.println("You have already claimed your prize! You cannot claim it more than once.");
                    
                    shopMenu();
                    
                } else {
                    
                    System.out.println("Not a valid choice. Please try again.");
                    System.out.println("");
                    
                    shopMenu();
                }
                
                if(choice==1 && playerCash<10) {
                    
                    System.out.println("");
                    System.out.println("You do not have enough money to purchase this item!");
                    System.out.println("Your current balance is: $" + playerCash);
                    
                } else if(choice==2 && playerCash<10) {
                    
                    System.out.println("");
                    System.out.println("You do not have enough money to purchase this item!");
                    System.out.println("Your current balance is: $" + playerCash);
                    
                } else if(choice==3 && playerCash<25) {
                    
                    System.out.println("");
                    System.out.println("You do not have enough money to purchase this item!");
                    System.out.println("Your current balance is: $" + playerCash);
                    
                }
                    
            }
        
        public void shopMenu() {
            
            System.out.println("> Would you like anything else?");
            System.out.println("");
            System.out.println("Your current balance is: $" + playerCash);
            System.out.println("");
            System.out.println("1. Purchase Bow ($10)");
            System.out.println("2. Purchase Arrows[100] ($10)");
            System.out.println("3. Purchase Weighted Hammer ($25)");
            System.out.println("4. Taunt Shopkeeper");
            System.out.println("5. Attack Shopkeeper");
            System.out.println("6. Return to Town Gate");
            System.out.println("7. Claim Prize");
            System.out.print("> ");
            
            choice = myScanner.nextInt();
            
                if(choice==1 && playerCash<10) {
                    
                    System.out.println("");
                    System.out.println("You do not have enough money to purchase this item!");
                    System.out.println("Your current balance is: $" + playerCash);
                
                } else if (choice==1) {
                    
                    if (playerWeapon.equals(bow)) {
                        
                        System.out.println("> You already have this weapon equipped!");
                        
                        shopMenu();
                        
                    }
                    
                    playerCash = playerCash - 10;
                    
                    System.out.println("> You have purchased a Bow!");
                    System.out.println("> Your current balance is: $" + playerCash);
                    System.out.println("");
                    System.out.println("> Would you like this to be your primary weapon, or your sidearm?");
                    System.out.println("1. Primary Weapon");
                    System.out.println("2. Sidearm");
                    System.out.print("> ");
                    
                    choice = myScanner.nextInt();
                    
                    if(choice==1) {
                        
                        playerWeapon = bow;
                        System.out.println("Set " + bow + " as Primary Weapon.");
                        
                        shopMenu();
                        
                    } else if(choice==2) {
                        
                        playerSideArm = bow;
                        System.out.println("Set " + bow + " as Sidearm.");
                        
                        shopMenu();
                        
                    }
                    
                } else if(choice==2 && playerCash<10) {
                    
                    System.out.println("");
                    System.out.println("You do not have enough money to purchase this item!");
                    System.out.println("Your current balance is: $" + playerCash);
                    
                } else if(choice==2) {
                    
                    if (arrows>0 && arrows<=100) {
                        
                        System.out.println("");
                        System.out.println("> You already have arrows for your bow!");
                        System.out.println("> Wait until you run out to purchase more.");
                        
                        shopMenu();
                        
                    }
                    
                    playerCash = playerCash - 10;
                    arrows = arrows + 100;
                    
                    System.out.println("> You have purchased arrows for your bow!");
                    System.out.println("> Your current balance is: $" + playerCash);
                    
                    shopMenu();
                    
                } else if(choice==3 && playerCash<25) {
                    
                        System.out.println("");
                        System.out.println("You do not have enough money to purchase this item!");
                        System.out.println("Your current balance is: $" + playerCash);
                        
                        shopMenu();
                    
                } else if(choice==3) {
                    
                    if (playerWeapon.equals(weightedHammer) || playerSideArm.equals(weightedHammer)) {
                        
                        System.out.println("> You already have this weapon equipped!");
                        
                        shopMenu();
                    }
                    playerCash = playerCash - 25;
                    
                    System.out.println("> You have purchased a Weighted Hammer!");
                    System.out.println("> Your current balance is: $" + playerCash);
                    System.out.println("> Would you like this to be your primary weapon, or your sidearm?");
                    System.out.println("1. Primary Weapon");
                    System.out.println("2. Sidearm");
                    System.out.print("> ");
                    
                    choice = myScanner.nextInt();
                    
                    if(choice==1) {
                        
                        playerWeapon = weightedHammer;
                        
                        System.out.println("Set " + weightedHammer + " as Primary Weapon.");
                        
                        shopMenu();
                        
                    } else if(choice==2) {
                        
                        playerSideArm = weightedHammer;
                        
                        System.out.println("Set " + weightedHammer + " as Sidearm.");
                        
                        shopMenu();
                    }
                    
                } else if(choice==4) {
                    
                    System.out.println("> " + playerName + "taunts the Shopkeeper!");
                    System.out.println("");
                    System.out.println("> Shopkeeper: Keep on running your mouth. See where it gets you.");
                    System.out.println("");
                    
                    shopMenu();
                    
                } else if(choice==5) {
                    
                    System.out.println("> " + playerName + "attacked the Shopkeeper!");
                    System.out.println("");
                    System.out.println("> Shopkeeper: You're going to regret doing such a thing!");
                    
                    playerHP = playerHP - 5;
                    
                    System.out.println("> The Shopkeeper dealt -5 damage to you with a hammer. Treat him nicely, please!");
                    System.out.println("> Your HP is now: " + playerHP);
                    
                    shopMenu();
                    
                } else if(choice==6) {
                    
                    townLocations();
                    
                } else if(choice==7 && wellCoinCount>=5 && prizeClaimed==0) {
                    
                    System.out.println("> You claimed a prize provided by the Wishing Well.");
                    
                    prizeClaimed = 1;
                    playerCash = playerCash + 50;
                    
                    System.out.println("");
                    System.out.println("> The Wishing Well has granted you with $50 for your acts of kindness!");
                    System.out.println("Your current balance is: $" + playerCash);
                    
                    shopMenu();
                    
                } else if(choice==7 && wellCoinCount<5 && prizeClaimed==0) {
                    
                    System.out.println("You cannot claim your prize... yet.");
                    
                    shopMenu();
                    
                } else if(choice==7 && wellCoinCount>=5 && prizeClaimed==1) {
                    
                    System.out.println("You have already claimed your prize! You cannot claim it more than once.");
                    
                    shopMenu();
                    
                } else {
                    
                    System.out.println("Not a valid choice. Please try again.");
                    System.out.println("");
                    
                    shopMenu();
                    
                }
                
        }
        
        public void goToBakery() {
            
            System.out.println("> Welcome to the Dublin Bakery!");
            System.out.println("> Chef: Hello! Nice to see you, " + playerName + ". What can I interest you in today?");
            System.out.println("");
            System.out.println("> Your current HP is: " + playerHP);
            System.out.println("> Your current balance is: $" + playerCash);
            System.out.println("1. Loaf of Bread[+2 HP] ($5)");
            System.out.println("2. Home-cooked Muffin[+3 HP] ($7)");
            System.out.println("3. Fresh Oatmeal Cookie[+5 HP] ($12)");
            System.out.println("4. Golden Apple Pie[+15 HP] ($35)");
            System.out.println("5. Return to Town Gate");
            System.out.println("");
            System.out.print("> ");
            
            choice = myScanner.nextInt();
            
            if(choice==1) {
                
                if(playerHP<=18) {
                    
                    playerHP = playerHP + 2;
                    playerCash = playerCash - 5;
                    
                    System.out.println("> Your HP is now: " + playerHP);
                    System.out.println("> You currently have $" + playerCash);
                    
                    bakeryMenu();
                    
                } else {
                    
                    System.out.println("> Your HP is currently: " + playerHP + "." + " You cannot restore any more health with this item!");
                    
                    bakeryMenu();
                    
                }
                
            } else if(choice==2) {
                
                if(playerHP<=17) {
                    
                    playerHP = playerHP + 3;
                    playerCash = playerCash - 7;
                    
                    System.out.println("> Your HP is now: " + playerHP);
                    System.out.println("> You currently have $" + playerCash);
                    
                    bakeryMenu();
                    
                } else {
                    
                    System.out.println("> Your HP is currently: " + playerHP + "." + " You cannot restore any more health with this item!");
                    
                    bakeryMenu();
                    
                }
                
            } else if(choice==3) {
                
                if(playerHP<=15) {
                    
                    playerHP = playerHP + 5;
                    playerCash = playerCash - 12;
                    
                    System.out.println("> Your HP is now: " + playerHP);
                    System.out.println("> You currently have $" + playerCash);
                    
                    bakeryMenu();
                    
                } else {
                    
                    System.out.println("> Your HP is currently: " + playerHP + "." + " You cannot restore any more health with this item!");
                    
                    bakeryMenu();
                    
                }
                
            } else if(choice==4) {
                
                if(playerHP<=5) {
                    
                    playerHP = playerHP + 15;
                    playerCash = playerCash - 35;
                    
                    System.out.println("> Your HP is now: " + playerHP);
                    System.out.println("> You currently have $" + playerCash);
                    
                    bakeryMenu();
                    
                } else {
                    
                    System.out.println("> Your HP is currently: " + playerHP + "." + " You cannot restore any more health with this item!");
                    
                    bakeryMenu();
                    
                }
                
            } else if(choice==5) {
                
                townLocations();
                
            } else {
                
                System.out.println("Not a valid choice. Please try again.");
                System.out.println("");
                
                bakeryMenu();
                
            }
            
            if(choice==1 && playerCash<5) {
                
                    System.out.println("");
                    System.out.println("You do not have enough money to purchase this item!");
                    System.out.println("Your current balance is: $" + playerCash);
                    
                } else if(choice==2 && playerCash<7) {
                    
                    System.out.println("");
                    System.out.println("You do not have enough money to purchase this item!");
                    System.out.println("Your current balance is: $" + playerCash);
                    
                } else if(choice==3 && playerCash<12) {
                    
                    System.out.println("");
                    System.out.println("You do not have enough money to purchase this item!");
                    System.out.println("Your current balance is: $" + playerCash);
                    
                } else if(choice==3 && playerCash<35) {
                    
                    System.out.println("");
                    System.out.println("You do not have enough money to purchase this item!");
                    System.out.println("Your current balance is: $" + playerCash);
                    
                }
                  
        }
        
        public void bakeryMenu() {
            
            System.out.println("> Would you like anything else?");
            System.out.println("");
            System.out.println("> Your current HP is: " + playerHP);
            System.out.println("> Your current balance is: $" + playerCash);
            System.out.println("1. Loaf of Bread[+2 HP] ($5)");
            System.out.println("2. Home-cooked Muffin[+3 HP] ($7)");
            System.out.println("3. Fresh Oatmeal Cookie[+5 HP] ($12)");
            System.out.println("4. Golden Apple Pie[+15 HP] ($35)");
            System.out.println("5. Return to Town Gate");
            System.out.println("");
            System.out.print("> ");
            
            choice = myScanner.nextInt();
            
            if(choice==1) {
                
                if(playerHP<=18) {
                    
                    playerHP = playerHP + 2;
                    playerCash = playerCash - 5;
                    
                    System.out.println("> Your HP is now: " + playerHP);
                    System.out.println("> You currently have $" + playerCash);
                    
                    bakeryMenu();
                    
                } else {
                    
                    System.out.println("> Your HP is currently: " + playerHP + "." + " You cannot restore any more health with this item!");
                    
                    bakeryMenu();
                    
                }
                
            } else if(choice==2) {
                
                if(playerHP<=17) {
                    
                    playerHP = playerHP + 3;
                    playerCash = playerCash - 7;
                    
                    System.out.println("> Your HP is now: " + playerHP);
                    System.out.println("> You currently have $" + playerCash);
                    
                    bakeryMenu();
                    
                } else {
                    
                    System.out.println("> Your HP is currently: " + playerHP + "." + " You cannot restore any more health with this item!");
                    
                    bakeryMenu();
                    
                }
                
            } else if(choice==3) {
                
                if(playerHP<=15) {
                    
                    playerHP = playerHP + 5;
                    playerCash = playerCash - 12;
                    
                    System.out.println("> Your HP is now: " + playerHP);
                    System.out.println("> You currently have $" + playerCash);
                    
                    bakeryMenu();
                    
                } else {
                    
                    System.out.println("> Your HP is currently: " + playerHP + "." + " You cannot restore any more health with this item!");
                    
                    bakeryMenu();
                    
                }
                
            } else if(choice==4) {
                
                if(playerHP<=5) {
                    
                    playerHP = playerHP + 15;
                    playerCash = playerCash - 35;
                    
                    System.out.println("> Your HP is now: " + playerHP);
                    System.out.println("> You currently have $" + playerCash);
                    
                    bakeryMenu();
                    
                } else {
                    
                    System.out.println("> Your HP is currently: " + playerHP + "." + " You cannot restore any more health with this item!");
                    
                    bakeryMenu();
                    
                }
                
            } else if(choice==5) {
                
                townLocations();
                
            } else {
                
                System.out.println("Not a valid choice. Please try again.");
                System.out.println("");
                
                bakeryMenu();
                
            }
            
            if(choice==1 && playerCash<5) {
                
                    System.out.println("");
                    System.out.println("You do not have enough money to purchase this item!");
                    System.out.println("Your current balance is: $" + playerCash);
                    
                } else if(choice==2 && playerCash<7) {
                    
                    System.out.println("");
                    System.out.println("You do not have enough money to purchase this item!");
                    System.out.println("Your current balance is: $" + playerCash);
                    
                } else if(choice==3 && playerCash<12) {
                    
                    System.out.println("");
                    System.out.println("You do not have enough money to purchase this item!");
                    System.out.println("Your current balance is: $" + playerCash);
                    
                } else if(choice==3 && playerCash<35) {
                    
                    System.out.println("");
                    System.out.println("You do not have enough money to purchase this item!");
                    System.out.println("Your current balance is: $" + playerCash);
                    
                }
            
        }
        
        public void goToWell() {
            
            System.out.println("> You've arrived at the Magical Dublin Wishing Well!");
            System.out.println("> There is a sign in front of it. It reads: ");
            System.out.println("");
            System.out.println("      The well will speak to those who give...");
            System.out.println("      Toss a coin, and the truth shall live...");
            System.out.println("");
            System.out.println("      Toss no coin, you may never know...");
            System.out.println("      If the future is bright, or if your time is low...");
            System.out.println("");
            System.out.println("> Toss a coin into the well? (-$1)");
            System.out.println("");
            System.out.println("1. Yes");
            System.out.println("2. No (Returns to Town Gate)");
            System.out.println("");
            
            choice = myScanner.nextInt();
            
            while(goldKey==false) {
                
                if(choice==1 && playerCash<1) {
                    
                    System.out.println("> You currently have $" + playerCash);
                    System.out.println("> The well cannot accept payment from you, because you are out of money.");
                    System.out.println("> Please come back when you can throw money into the well.");
                    
                } else if(choice==1 && wellCoinCount<1) {
                    
                    wellCoinCount = wellCoinCount + 1;
                    playerCash = playerCash - 1;
                    
                    System.out.println("> You have now tossed " + wellCoinCount + " coin into the well.");
                    System.out.println("> Nothing happened.");
                    System.out.println("");
                    
                    wellMenu();
                    
                } else if(choice==1 && wellCoinCount>=1 && wellCoinCount<3) {
                    
                    wellCoinCount = wellCoinCount - 1;
                    playerCash = playerCash - 1;
                    
                    System.out.println("> You have now tossed " + wellCoinCount + " coins into the well.");
                    System.out.println("> Still, nothing appears to happen.");
                    
                    wellMenu();
                    
                } else if(choice==1 && wellCoinCount<4) {
                    
                    wellCoinCount = wellCoinCount + 1;
                    playerCash = playerCash - 1;
                    
                    System.out.println("> You have now tossed " + wellCoinCount + " coins into the well.");
                    System.out.println("> The ground appears to rumble for a moment...");
                    System.out.println("> The well hisses...");
                    System.out.println("");
                    System.out.println("      The more you pay, the more you will learn...");
                    System.out.println("      A few coins extra, and the truth I'll turn...");
                    System.out.println("");
                    System.out.println("");
                    
                    wellMenu();
                    
                } else if(choice==1 && wellCoinCount>=4 && wellCoinCount<49) {
                    
                    wellCoinCount = wellCoinCount + 1;
                    playerCash = playerCash - 1;
                    
                    System.out.println("> You have now tossed " + wellCoinCount + " coins into the well.\nI wonder what happens at 50?");
                    System.out.println("> The ground shakes even more than usual...");
                    System.out.println("> The well begins to crumble from the outside...");
                    System.out.println("");
                    System.out.println("      You shared your fortune, so I'll gift something wise...");
                    System.out.println("      Return to the shop, to be greeted with a surprise...");
                    System.out.println("");
                    
                    wellMenu();
                    
                } else if(choice==1 && wellCoinCount>=49) {
                    
                    System.out.println("> The ground tremors become unbearable...");
                    System.out.println("> Suddenly, the well collapses entirely...");
                    System.out.println("> Beneath the rubble, you discover something shiny.");
                    System.out.println("> It's the golden key to the castle!");
                    
                    goldKey = true;
                    
                    townLocations();
                    
                } else if(goldKey == true) {
                    
                    System.out.println("> The well has collapsed entirely! It can no longer be used.");
                    
                    townLocations();
                
                } else if(choice==2) {
                    
                    System.out.println("");
                    System.out.println("> Returning to the Town Gate...");
                    System.out.println("");
                    
                    townLocations();
                    
                } else {
                    
                    System.out.println("");
                    System.out.println("Not a valid choice. Please try again.");
                    System.out.println("");
                    
                    wellMenu();
                    
                }
                
            }
            
        }
        
        public void wellMenu() {
            
            while (goldKey == false) {
                
                System.out.println("> Toss another coin into the well? (-$1)");
                System.out.println("");
                System.out.println("1. Yes");
                System.out.println("2. No (Returns to Town Gate)");
                System.out.println("");
                
                choice = myScanner.nextInt();
                
                if(choice==1 && playerCash<1) {
                    
                    System.out.println("> You currently have $" + playerCash);
                    System.out.println("> The well cannot accept payment from you, because you are out of money.");
                    System.out.println("> Please come back when you can throw money into the well.");
                    
                } else if(choice==1 && wellCoinCount < 4) {
                    
                    wellCoinCount = wellCoinCount + 1;
                    playerCash = playerCash - 1;
                    
                    System.out.println("> You have now tossed " + wellCoinCount + " coins into the well.");
                    System.out.println("> The ground appears to rumble for a moment...");
                    System.out.println("> The well hisses...");
                    System.out.println("");
                    System.out.println("      The more you pay, the more you will learn...");
                    System.out.println("      A few coins extra, and the truth I'll turn...");
                    System.out.println("");
                    
                    wellMenu();
                    
                } else if(choice==1 && wellCoinCount==4) {
                    
                    wellCoinCount = wellCoinCount + 1;
                    playerCash = playerCash - 1;
                    
                    System.out.println("> You have now tossed " + wellCoinCount + " coins into the well.\n> I wonder what happens at 50?");
                    System.out.println("> The ground shakes even more than usual...");
                    System.out.println("> The well begins to crumble from the outside...");
                    System.out.println("");
                    System.out.println("      You shared your fortune, so I'll gift you something wise...");
                    System.out.println("      Return to the shop, to be greeted with a surprise...");
                    System.out.println("");
                    
                    wellMenu();
                    
                } else if(choice==1 && wellCoinCount>4 && wellCoinCount<49 && prizeClaimed==0) {
                    
                    wellCoinCount = wellCoinCount + 1;
                    playerCash = playerCash - 1;
                    
                    System.out.println("> You have now tossed " + wellCoinCount + " coins into the well.\n> I wonder what happens at 50?");
                    System.out.println("> Don't forget to claim your prize from the shop!");
                    System.out.println("");
                    System.out.println("> The ground shakes drastically more than previously...");
                    System.out.println("> The well begins to recede into the ground...");
                    System.out.println("");
                    System.out.println("      A fortune of fifty will bear the great key...");
                    System.out.println("      A fortune too low, and such an object, you'll never see...");
                    System.out.println("");
                    
                    wellMenu();
                    
                } else if(choice==1 && wellCoinCount>4 && wellCoinCount<49 && prizeClaimed==1) {
                    
                    wellCoinCount = wellCoinCount + 1;
                    playerCash = playerCash - 1;
                    
                    System.out.println("> You have now tossed " + wellCoinCount + " coins into the well.\n> I wonder what happens at 50?");
                    System.out.println("> The ground shakes drastically more than previously...");
                    System.out.println("> The well begins to recede into the ground...");
                    System.out.println("");
                    System.out.println("      A fortune of fifty will bear the great key...");
                    System.out.println("      A fortune too low, and such an object, you'll never see...");
                    System.out.println("");
                    
                    wellMenu();
                    
                } else if(choice==1 && wellCoinCount==49) {
                    
                    wellCoinCount = wellCoinCount + 1;
                    playerCash = playerCash - 1;
                    
                    System.out.println("> The ground tremors become unbearable...");
                    System.out.println("> Suddenly, the well collapses entirely...");
                    System.out.println("");
                    System.out.println("> Beneath the rubble, you discover something shiny.");
                    System.out.println("> It's the golden key to the castle!");
                    System.out.println("");
                    System.out.println("> You return to the Town Gate to relish your discovery.");
                    
                    goldKey = true;
                    
                    townLocations();
                    
                } else if(goldKey == true && wellCoinCount>49) {
                    
                    System.out.println("> The well has collapsed entirely! It can no longer be used.");
                    
                    townLocations();
                    
                } else if(choice==2) {
                    
                    System.out.println("> Returning to the Town Gate...");
                    System.out.println("");
                    
                    townLocations();
                    
                } else {
                    
                    System.out.println("Not a valid choice. Please try again.");
                    System.out.println("");
                    
                    wellMenu();
                    
                }
                
            }
            
        }
        
	public void townEntry(){
            
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("> Guard: Oh, you killed that goblin!?? Great!");
		System.out.println("> Guard: It seems you are a trustworthy guy. Welcome to our town!");
                System.out.println("");
                
                enterTown();
                
	}
        
        public void goToCastle() {
            
            System.out.println("");
            System.out.println("> You are now on your way to the Castle of King Oliver Caspian.");
            System.out.println("> Your HP is currently: " + playerHP);
            System.out.println("> You currently have $" + playerCash);
            System.out.println("> Your primary weapon is a " + playerWeapon);
            System.out.println("> Your sidearm is a " + playerSideArm + ",\nand you currently have " + arrows + "arrow(s).");
            
            System.out.println("> There's a stream nearby...\n> If you drink from it, your health will regenerate.\n?> Care to reguvinate your health?");
            System.out.println("1. Yes, go to the stream");
            System.out.println("2. No, continue to the Castle");
            
            choice = myScanner.nextInt();
            
            if(choice==1) {
                
                takeADrink();
                
            } else if(choice==2) {
                
                System.out.println("> You walk past the stream, feeling parched, but determined.");
                System.out.println("> As you continue up the path, you notice");
                
            } else {
                
            }
        }
        
        public void takeADrink() {
            
            playerHP = 20;
            
                System.out.println("> Your HP has been restored to " + playerHP + "!");
                System.out.println("> ");
                System.out.println("> 1. Continue walking to the Castle");
                System.out.print("> ");
                
                choice = myScanner.nextInt();
                
                if(choice==1) {
                    
                    // fill in choice here
                } else {
                    
                    System.out.println("");
                    System.out.println("> This is not a valid entry. Try again, please.");
                    
                    takeADrink();
                    
                }
                
        }
        
        public void endingRIP(){
            
		System.out.println("\n\n                       THE END                    ");
		System.out.println("\n------------------------------------------------------------------\n");
                
        }
        
}