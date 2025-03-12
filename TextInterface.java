import java.util.InputMismatchException;
import java.util.Scanner;

public class TextInterface {

    //private City city;
    private Game game;
    private Scanner scanner = new Scanner(System.in);

    public TextInterface(Game game){
        this.game = game;
    }

    public void showMainMenu(){
        boolean running = true;
        while(running) {
            System.out.println("----- MAIN MENU -----");
            System.out.println("1) New Game");
            System.out.println("2) Quit");
            System.out.println("Please select an option: ");

            int input = getMenuInput(1,2);
            switch (input){
                case 1:
                    game.start();
                    showGameMenu();
                    break;
                case 2:
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid input.");

            }

        }

    }

    public void showGameMenu() {
        boolean running = true;
        while (running) {
            System.out.println("----- GAME MENU -----");
            System.out.println("1) BUY");
            System.out.println("2) SELL");
            System.out.println("3) FEED");
            System.out.println("4) PLANT");
            System.out.println("5) SHOW STATUS / NEXT YEAR");
            System.out.println("6) QUIT GAME");
            System.out.println("Please select an action: ");

            int input = getMenuInput(1, 6);
            switch (input) {
                case 1:
                    buyMenu();
                    break;
                case 2:
                    sellMenu();
                    break;
                case 3:
                    feedMenu();
                    break;
                case 4:
                    plantMenu();
                    break;
                case 5:
                    running = statusMenu();
                    break;
                case 6:
                    game = null;
                    running = false;
                    break;
            }
        }
    }

    public void buyMenu(){
        System.out.println("----- BUY MENU ------");
        System.out.format("City Status: %s\n", game.showStatus());
        System.out.format("Current price er acres: %d\n", game.getPRICE());
        System.out.println("How many acres would you like to buy?");
        System.out.print("> ");
        int input = getUserInput();
        if(!game.buyLand(input)){
            System.out.println("Arrr, your input was not in range.");
        }
        System.out.format("New Status: %s\n", game.showStatus());



    }

    public void sellMenu(){
        System.out.println("----- SELL MENU ------");
        System.out.format("City Status: %s\n", game.showStatus());
        System.out.format("Current price per acres: %d\n", game.getPRICE());
        System.out.println("How many acres would you like to sell?");
        System.out.print("> ");
        int input = getUserInput();
        if(!game.sellLand(input)){
            System.out.println("Arrr, your input was not in range.");
        }
        System.out.format("New Status: %s\n", game.showStatus());
    }

    public void feedMenu(){
        System.out.println("----- FEED MENU ------");
        System.out.format("City Status: %s\n", game.showStatus());
        System.out.println("How many bushels would you like to feed to your residents");
        System.out.println("Required: " + game.getREQUIRED_FOOD_PER_PERSON() + " per person");
        System.out.print("> ");
        int input = getUserInput();
        if(!game.feedPeople(input)){
            System.out.println("Arrr, your input was not in range.");
        }
        System.out.format("New Status: %s\n", game.showStatus());
    }

    public void plantMenu(){
        System.out.println("----- PLANT MENU ------");
        System.out.format("City Status: %s\n", game.showStatus());
        System.out.println("How many arces of land would you like to plant with seed?");
        System.out.print("> ");
        int input = getUserInput();
        if(!game.plantBushels(input)){
            System.out.println("Arrr, your input was not in range.");
        }
        System.out.format("New Status: %s\n", game.showStatus());
    }

    public boolean statusMenu(){
        System.out.println("----- STATUS MENU ------");
        System.out.format("City Status: %s\n", game.showStatus());
        return game.nextTurn();
    }



    public int getMenuInput(int lowerBorder, int upperBorder) {
        while (true) {
            try {
                int num = scanner.nextInt();
                if (lowerBorder <= num && num <= upperBorder) {
                    return num;
                }
                System.out.format("Invalid input: %d. Please try again:", num);
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Invalid input. Please enter a number.");
            }

        }
    }

    public int getUserInput(){
        while(true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Please enter a number.");
            }
        }
    }

}
