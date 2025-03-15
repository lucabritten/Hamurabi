package presentation;

import domainmodel.Game;

public class Codeopolis {

    public static void main(String[] args){

        TextInterface textInterface = new TextInterface();
        Game game = new Game(textInterface);
        textInterface.setGame(game);
        textInterface.showMainMenu();
    }
}
