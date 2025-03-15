package domainmodel;
public class Game {

    private City gameCity;
    private UserInterface userInterface;
    private GameConfig gameConfig;

    public Game(UserInterface userInterface){
        this.userInterface = userInterface;
    }

    public void start(){
        gameConfig = new GameConfig(userInterface.getDifficultyLevel());
        gameCity = new City(gameConfig);
        do {
            executeTurn();
        }
        while(gameCity.runTurn());
    }

    public void executeTurn(){
        System.out.println(gameCity);
        int acresToBuy = userInterface.getAcresToBuy();
        gameCity.buy(acresToBuy);

        int acresToSell = userInterface.getAcresToSell();
        gameCity.sell(acresToSell);

        int bushelsToFeed = userInterface.getBushelsToFeed();
        gameCity.feed(bushelsToFeed);

        int bushelsToPlant = userInterface.getBushelsToPlant();
        gameCity.plant(bushelsToPlant);

    }

    public int getPRICE(){
        return City.PRICE;
    }

    public int getREQUIRED_FOOD_PER_PERSON(){
        return gameCity.REQUIRED_FOOD_PER_PERSON;
    }

    public String showStatus(){
        return gameCity.getStatus();
    }
}
