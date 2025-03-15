package domainmodel;

public class GameConfig {

    private final int initialInhabitants;
    private final int initialAcres;
    private final int initialBushels;
    private final int maxAcrePrice;
    private final int minAcrePrice;
    private final int bushelsPerInhabitant;
    private final int bushelsPerAcre;
    private final int acrePerInhabitant;
    private final int numberOfYears;
    private final float harvestFactor;
    private final int rateInfestation;
    private final DifficultyLevel level;



    public GameConfig(DifficultyLevel level){
        this.level = level;
        switch(level){
            case DifficultyLevel.EASY:
                this.initialInhabitants = 100;
                this.initialAcres = 1000;
                this.initialBushels = 2800;
                this.maxAcrePrice = 30;
                this.minAcrePrice = 10;
                this.bushelsPerInhabitant = 20;
                this.bushelsPerAcre = 1;
                this.acrePerInhabitant = 10;
                this.numberOfYears = 10;
                this.harvestFactor = 6.0f;
                this.rateInfestation = 10;
                break;

            case DifficultyLevel.MEDIUM:
                this.initialInhabitants = 100;
                this.initialAcres = 900;
                this.initialBushels = 2800;
                this.maxAcrePrice = 35;
                this.minAcrePrice = 15;
                this.bushelsPerInhabitant = 22;
                this.bushelsPerAcre = 1;
                this.acrePerInhabitant = 10;
                this.numberOfYears = 10;
                this.harvestFactor = 5.0f;
                this.rateInfestation = 20;
                break;
            case DifficultyLevel.HARD:
                this.initialInhabitants = 100;
                this.initialAcres = 800;
                this.initialBushels = 2800;
                this.maxAcrePrice = 35;
                this.minAcrePrice = 15;
                this.bushelsPerInhabitant = 24;
                this.bushelsPerAcre = 1;
                this.acrePerInhabitant = 10;
                this.numberOfYears = 10;
                this.harvestFactor = 4.0f;
                this.rateInfestation = 25;
                break;
            default:
                throw new IllegalArgumentException("Unknown difficulty" + level);
        }
    }

    public int getInitialInhabitants(){
        return initialInhabitants;
    }

    public int getInitialAcres(){
        return initialAcres;
    }

    public int getInitialBushels(){
        return initialBushels;
    }

    public int getMaxAcrePrice(){
        return maxAcrePrice;
    }

    public int getMinAcrePrice(){
        return minAcrePrice;
    }

    public int getBushelsPerInhabitant(){
        return bushelsPerInhabitant;
    }

    public int getBushelsPerAcre(){
        return bushelsPerAcre;
    }

    public int getAcrePerInhabitant(){
        return acrePerInhabitant;
    }

    public int getNumberOfYears(){
        return numberOfYears;
    }

    public float getHarvestFactor(){
        return harvestFactor;
    }

    public int getRateInfestation(){
        return rateInfestation;
    }






    public static void main(String[] args){

    }
}
