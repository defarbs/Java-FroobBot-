package froobbot;
import java.util.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class FroobBot extends TheGame {
    public static void main(String[] args) {
        
        FroobBot froob;
        froob = new FroobBot();
        
        froob.introPrompt(100, 30);
        froob.froobMenu();
    }
    public void introPrompt(int width, int height) {
        Scanner reader = new Scanner(System.in);

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setFont(new Font("SansSerif", Font.BOLD, 12));

        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        System.out.println("    ==============================================================================");
        graphics.drawString("FROOB BOT", 10, 20);

        for (int y = 0; y < height; y++) {
            StringBuilder sb = new StringBuilder();
            for (int x = 0; x < width; x++) {

                sb.append(image.getRGB(x, y) == -16777216 ? " " : "$");

            }

            if (sb.toString().trim().isEmpty()) {
                continue;
            }

            System.out.println(sb);
        }
        System.out.println("    ==============================================================================");
                                                                                
        System.out.println("");
        System.out.println("");
        System.out.println("=======================");
        System.out.println("> Hi, what is your name?");
        System.out.println("=======================");
        System.out.println("");
        System.out.print("> My name is: ");
        String userInput1 = reader.nextLine();
        userInput1 = userInput1.replaceAll("\\s+","");
        System.out.println("");

        if (userInput1.equalsIgnoreCase("Froob")) {
            System.out.println("===================================================================");
            System.out.println("> Hello Father. It's nice to see you again. How are you doing today?");
            System.out.println("===================================================================");
            System.out.println("");
            System.out.print("> ");
        } else if (userInput1.equalsIgnoreCase("Nick")) {
            System.out.println("===================================================================");
            System.out.println("> Yo Nick. What's crack a lackin' brudda?");
            System.out.println("===================================================================");
            System.out.println("");
            System.out.print("> ");
        } else if (userInput1.equalsIgnoreCase("Evan")) {
            System.out.println("===================================================================");
            System.out.println("> How's it going, mayn?");
            System.out.println("===================================================================");
            System.out.println("");
            System.out.print("> ");
        } else {
            System.out.println("===================================================================");
            System.out.println("> Hi " + userInput1 + ", how are you doing today?");
            System.out.println("===================================================================");
            System.out.println("");
            System.out.print("> ");
        }
        String userInput2 = reader.nextLine();
        userInput2 = userInput2.replaceAll("\\s+","");
        if (userInput2.equalsIgnoreCase("I'm good") || userInput2.equalsIgnoreCase("I'm great") || userInput2.equalsIgnoreCase("Great") ||
            userInput2.equalsIgnoreCase("Good") || userInput2.equalsIgnoreCase("I'm well") || userInput2.equalsIgnoreCase("I'm alright") ||
            userInput2.equalsIgnoreCase("Pretty good") || userInput2.equalsIgnoreCase("Not bad") || userInput2.equalsIgnoreCase("Decent") ||
            userInput2.equalsIgnoreCase("I'm fine") || userInput2.equalsIgnoreCase("Not much homie")) {


            System.out.println("");
            System.out.println("================================");
            System.out.println("> That's great to hear, " + userInput1 + ".");
            System.out.println("================================");
            System.out.println("");


        } else if (userInput2.equalsIgnoreCase("I'm not doing well") || userInput2.equalsIgnoreCase("Bad") || userInput2.equalsIgnoreCase("Terrible") ||
            userInput2.equalsIgnoreCase("Not good") || userInput2.equalsIgnoreCase("Not so good") || userInput2.equalsIgnoreCase("I'm not doing very well") ||
            userInput2.equalsIgnoreCase("I could be better") || userInput2.equalsIgnoreCase("I've been better") || userInput2.equalsIgnoreCase("Horrible") ||
            userInput2.equalsIgnoreCase("I'm sad") || userInput2.equalsIgnoreCase("I'm upset") || userInput2.equalsIgnoreCase("I'm terrible")) {

            System.out.println("");
            System.out.println("================================");
            System.out.println("> I'm sorry to hear that, " + userInput1 + ".");
            System.out.println("================================");
            System.out.println("");
        }
        else {
            System.out.println("");
            System.out.println("============================================================================");
            System.out.println("> I'm sorry, " + userInput1 + ", I don't know any responses to that answer.");
            System.out.println("============================================================================");
            System.out.println("");
        }
    }
        public void froobMenu() {
            Scanner reader = new Scanner(System.in);
            System.out.println("");
            System.out.println("=======================================");
            System.out.println("> Type 'menu' for a list of Menu options.");
            System.out.println("=======================================");
            System.out.println("");
            System.out.print("> ");
            String userInput3 = reader.nextLine();
            userInput3 = userInput3.replaceAll("\\s+","");
        
            if (!userInput3.equalsIgnoreCase("menu")) {
                do {
                    System.out.println("");
                    System.out.println("> This is not a valid entry.");
                    System.out.println("");
                    System.out.println("> Please enter 'menu' for more options.");
                    System.out.println("");
                    System.out.print("> ");
                    userInput3 = reader.nextLine();
                    userInput3 = userInput3.replaceAll("\\s+","");
                } while (!userInput3.equalsIgnoreCase("menu"));
            }

            int userCommand;

            do {
                if (userInput3.equalsIgnoreCase("menu")) {
                    System.out.println("         ================================");
                    System.out.println("                  Froob Bot Menu");
                    System.out.println("         ================================");
                    System.out.println("> Type a number to select which option you would like:");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("  1. Helpful Information About Froob Bot");
                    System.out.println("  2. Learn About The Developer (aka Froob)");
                    System.out.println("  3. Play a game!");
                    System.out.println("  4. Exit the menu");
                    System.out.println("");
                    System.out.print("> ");
                }
                userCommand = reader.nextInt();

                switch (userCommand) {
                    case 4:
                        System.out.println("> Exiting...");
                        System.exit(0);
                    case 3:
                        System.out.println("");
                        System.out.println("================================");
                        System.out.println("      Starting the game...");
                        System.out.println("================================");
                        System.out.println("");
                        Start(null);
                        break;
                    case 2:
                        System.out.println("");
                        System.out.println("> The developer of Froob Bot is named Drew 'Froob' Farber.\n> He is a 21 year old Junior Developer from Columbus, OH." +
                            "\n> Drew first began developing at the age of 14, and has developed applications in HTML/CSS/Javascript,\n> Java, Python, and C++." +
                            "\n> He also has experience with various Node.JS frameworks, and considers himself an active developer\n> in the development community.");
                        System.out.println("");
                        break;
                    case 1:
                        System.out.println("");
                        System.out.println("> My name is Froob Bot. I keep minimal conversation and also happen to know a couple things." +
                            "\n> I can log your responses and print them out! For example, you just chose " + userCommand +
                            "\n> as your response. (Whoa, creepy).");
                        System.out.println("");
                    default:
                        break;
                }
            } while (userCommand < 5);

            do {
                if (userCommand >= 5) {
                    System.out.println("> This is not valid input. Please enter a number on the menu list!");
                    System.out.println("");
                    System.out.print("> ");
                    froobMenu();
                }
            } while (userCommand >= 5);
        }
    }