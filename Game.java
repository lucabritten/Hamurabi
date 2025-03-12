public class Game {

    private City gameCity = new City();
    private TextInterface textInterface;

    public Game(){
        textInterface = new TextInterface(this);
    }

    public void start(){

    }

    public int getPRICE(){
        return City.PRICE;
    }

    public int getREQUIRED_FOOD_PER_PERSON(){
        return City.REQUIRED_FOOD_PER_PERSON;
    }

    public boolean buyLand(int amount){
        return gameCity.buy(amount);
    }

    public boolean sellLand(int amount){
        return gameCity.sell(amount);
    }

    public boolean feedPeople(int amount){
        return gameCity.feed(amount);
    }

    public boolean plantBushels(int amount){
        return gameCity.plant(amount);
    }

    public String showStatus(){
        return gameCity.getStatus();
    }

    public boolean nextTurn(){
        return gameCity.runTurn();
    }

}
