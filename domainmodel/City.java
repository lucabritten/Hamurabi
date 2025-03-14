package domainmodel;

import java.util.Random;

public class City {

    private String name;
    private GameConfig config;
    private int bushels;
    private int acres;
    private int inhabitants;
    private int food;
    private int plantedFields;
    private int cityAge = 1;
    public static final int PRICE = 10;
    public final int REQUIRED_FOOD_PER_PERSON;
    public final float HARVEST_FACTOR;
    public final int MAX_RAT_LOSS;
    private Random random = new Random();

    public City(GameConfig config){
        this.config = config;
        bushels = config.getInitialBushels();
        acres = config.getInitialAcres();
        inhabitants = config.getInitialInhabitants();
        REQUIRED_FOOD_PER_PERSON = config.getBushelsPerInhabitant();
        HARVEST_FACTOR = config.getHarvestFactor();
        MAX_RAT_LOSS = config.getRateInfestation();
    }
    @Override
    public String toString(){
        return "domainmodel.City Status: In the year " + cityAge + " after its foundation, " + inhabitants + " inhabitants live in the town of presentation.Codeopolis. The town owns " + bushels + " bushels of grain and " + acres + " acres of land.";
    }

    public int getAcres(){
        return acres;
    }

    public int getBushels(){
        return bushels;
    }

    public int getFood(){
        return food;
    }

    public int getPlantedFields(){
        return plantedFields;

    }

    public String getStatus(){
        return "> Acres: "+ acres + ",  > Bushels: " + bushels +",  > Inhabitants: " + inhabitants;
    }

    public void setInhabitants(int number){
        if(number >= 0){
            inhabitants = number;
        }

    }

    public boolean buy(int amount){
        if(amount*10 < bushels){
            bushels -= amount*10;
            acres += amount;
            return true;
        }
        return false;
    }

    public boolean sell(int amount){

        if(amount < acres && amount >= 0){
            acres -= amount;
            bushels += amount*10;
            return true;
        }
        return false;
    }

    public boolean feed(int amount){
        if(amount <= bushels){
            bushels -= amount;
            food = amount;
            return true;
        }
        return false;
    }

    public boolean plant(int amount){
        plantedFields = 0;
        if(amount <= inhabitants*10 && amount <= bushels) {
            plantedFields = amount;
            bushels -= amount;
            return true;
        }
        return false;
    }

    public boolean runTurn() {
        int inhabitantsBeforeDeath = inhabitants;
        int deathPeople = 0;

        // Hungertote berechnen
        int maxSurvivors = food / REQUIRED_FOOD_PER_PERSON;
        if (maxSurvivors < inhabitants) {
            deathPeople = inhabitants - maxSurvivors;
            inhabitants = maxSurvivors;
        }
        System.out.format("%d people starved...\n", deathPeople);

        // Einwohnerzuwachs
        int newPeople = 0;
        if (deathPeople < (inhabitantsBeforeDeath * 0.4)) {
            newPeople = (int) (random.nextDouble() * 0.4 * inhabitants);
            inhabitants += newPeople;
        }
        System.out.format("%d people came to the city\n", newPeople);

        // Ernterate (Ernte vervielfachen, aber nicht mehr als 6x)
        int harvestedBushels = (int) ((random.nextDouble() * 0.9 + 0.1) * HARVEST_FACTOR * bushels);
        bushels += harvestedBushels;
        System.out.format("%d Bushels are now in stock\n", bushels);

        // Rattenplage (bis zu 25% der Vorräte)
        int eatenBushels = (int) (random.nextDouble() * (MAX_RAT_LOSS/100) * bushels);
        bushels -= eatenBushels;
        System.out.format("%d bushels were eaten by rats...\n", eatenBushels);

        // Jahr erhöhen
        System.out.format("Round %d of 10.\n", ++cityAge);

        //Bedingungen Sieg/Niederlage prüfen
        if(inhabitants <= 0 || deathPeople > inhabitantsBeforeDeath / 2){
            System.out.println("You lost!");
            return false;
        }
        else if(cityAge == config.getNumberOfYears()){
            System.out.println("Congrats, you made it!");
            return false;
        }
        return true;
    }

}