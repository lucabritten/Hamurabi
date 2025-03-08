public class City {

    private String name;
    private int bushels = 2800;
    private int acres = 1000;
    private int inhabitants = 100;
    private int food;
    private int fields;
    private int cityAge;

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
            bushels += amount*7;
            return true;
        }
        return false;
    }

    public void feed(){

    }

    public void plant(){


    }

    public int getAcres(){
        return acres;
    }

    public int getBushels(){
        return bushels;
    }

}
