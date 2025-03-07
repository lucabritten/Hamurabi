public class City {

    private String name;
    private int bushels = 2800;
    private int acres = 1000;
    private int inhabitants = 100;
    private int food;
    private int fields;
    private int cityAge;

    public boolean buy(int amount){
        if(amount*2 < bushels){
            bushels -= amount*2;
            acres += amount;
            return true;
        }
        return false;
    }

    public boolean sell(int amount){

        if(amount < acres){
            acres -= amount;
            bushels += amount*2;
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

}
