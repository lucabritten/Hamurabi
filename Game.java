public class Game {

    private City gameCity;
    private TextInterface textInterface;
    private GameConfig gameConfig;

    public Game(){
        textInterface = new TextInterface(this);
    }

    public void start(){
        gameConfig = new GameConfig(textInterface.getDifficultyLevel());
        gameCity = new City(gameConfig);
        do {
            executeTurn();
        }
        while(gameCity.runTurn());
    }

    public void executeTurn(){
        System.out.println(gameCity);
        int acresToBuy = textInterface.getAcresToBuy();
        gameCity.buy(acresToBuy);

        int acresToSell = textInterface.getAcresToSell();
        gameCity.sell(acresToSell);

        int bushelsToFeed = textInterface.getBushelsToFeed();
        gameCity.feed(bushelsToFeed);

        int bushelsToPlant = textInterface.getBushelsToPlant();
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
