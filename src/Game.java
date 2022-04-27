import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Character.toUpperCase;
import static java.lang.System.exit;
import static java.lang.Thread.sleep;

@SuppressWarnings({"BusyWait"})
public class Game {
    char[] squares = new char[9];
    char currentPlayer;
    char gameStatus;
    User user;
    static char isHosting = 'u';
    View view;
    static int move = -1;

    Game() {
        for(int i = 0; i < 9; i++){
            squares[i] = 'n';
        }

        currentPlayer = 'x';
        gameStatus = 'n';

        view = new View();

        view.setJoinButtonActionListener(new JoinButtonActionListener());
        view.setHostButtonActionListener(new HostButtonActionListener());
        view.setOneButtonActionListener(new OneButtonActionListener());
        view.setTwoButtonActionListener(new TwoButtonActionListener());
        view.setThreeButtonActionListener(new ThreeButtonActionListener());
        view.setFourButtonActionListener(new FourButtonActionListener());
        view.setFiveButtonActionListener(new FiveButtonActionListener());
        view.setSixButtonActionListener(new SixButtonActionListener());
        view.setSevenButtonActionListener(new SevenButtonActionListener());
        view.setEightButtonActionListener(new EightButtonActionListener());
        view.setNineButtonActionListener(new NineButtonActionListener());
    }

    String getSquares(){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 9; i++){
            s.append(squares[i]);
        }
        return s.toString();
    }

    void setSquares(String s){
        for (int i=0; i<9;i++){
            squares[i] = s.charAt(i);
        }
    }

    char getCurrentPlayer(){
        return currentPlayer;
    }

    void setCurrentPlayer(char x){
        currentPlayer = x;
    }

    char getGameStatus(){
        return gameStatus;
    }

    void setGameStatus(){
        char winner = 'n';
        int count = 0;


        if(squares[1] == squares[0] && squares[2] == squares[0] && squares[0] != 'n'){
            // top row win
            winner = squares[0];
            squares[0] = toUpperCase(squares[0]);
            squares[1] = toUpperCase(squares[0]);
            squares[2] = toUpperCase(squares[0]);
        }
        if(squares[3] == squares[0] && squares[6] == squares[0] && squares[0] != 'n'){
            // left column win
            winner = squares[0];
            squares[0] = toUpperCase(squares[0]);
            squares[3] = toUpperCase(squares[0]);
            squares[6] = toUpperCase(squares[0]);
        }
        if(squares[4] == squares[0] && squares[8] == squares[0] && squares[0] != 'n'){
            // left diagonal win
            winner = squares[0];
            squares[0] = toUpperCase(squares[0]);
            squares[4] = toUpperCase(squares[0]);
            squares[8] = toUpperCase(squares[0]);
        }
        if(squares[4] == squares[1] && squares[7] == squares[1] && squares[1] != 'n'){
            // middle column win
            winner = squares[1];
            squares[1] = toUpperCase(squares[1]);
            squares[4] = toUpperCase(squares[1]);
            squares[7] = toUpperCase(squares[1]);
        }
        if(squares[5] == squares[2] && squares[8] == squares[2] && squares[2] != 'n'){
            // right column win
            winner = squares[2];
            squares[2] = toUpperCase(squares[2]);
            squares[5] = toUpperCase(squares[2]);
            squares[8] = toUpperCase(squares[2]);
        }
        if(squares[4] == squares[2] && squares[6] == squares[2] && squares[2] != 'n'){
            // right diagonal win
            winner = squares[2];
            squares[2] = toUpperCase(squares[2]);
            squares[4] = toUpperCase(squares[2]);
            squares[6] = toUpperCase(squares[2]);
        }
        if(squares[4] == squares[3] && squares[5] == squares[3] && squares[3] != 'n'){
            // middle row win
            winner = squares[3];
            squares[3] = toUpperCase(squares[3]);
            squares[4] = toUpperCase(squares[3]);
            squares[5] = toUpperCase(squares[3]);
        }
        if(squares[7] == squares[6] && squares[8] == squares[6] && squares[6] != 'n'){
            // bottom row win
            winner = squares[6];
            squares[6] = toUpperCase(squares[6]);
            squares[7] = toUpperCase(squares[6]);
            squares[8] = toUpperCase(squares[6]);
        }

        for(int i = 0; i < 9; i++){
            // check each square
            if(squares[i] != 'n'){
                count ++;
            }
        }
        if(winner == 'n' && count == 9) // tie
            winner = 't';

        gameStatus = winner;

    }

    boolean isMoveValid(int x){
        return squares[x] == 'n';
    }

    static class OneButtonActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            move = 0;
        }
    }
    static class TwoButtonActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            move = 1;
        }
    }
    static class ThreeButtonActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            move = 2;
        }
    }
    static class FourButtonActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            move = 3;
        }
    }
    static class FiveButtonActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            move = 4;
        }
    }
    static class SixButtonActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            move = 5;
        }
    }
    static class SevenButtonActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            move = 6;
        }
    }
    static class EightButtonActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            move = 7;
        }
    }
    static class NineButtonActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            move = 8;
        }
    }
    static class HostButtonActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            isHosting = 'y';
        }
    }
    static class JoinButtonActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            isHosting = 'n';
        }
    }

    void displayGameBoard(){
        StringBuilder moveInputBuilder = new StringBuilder(getSquares());

        System.out.println("_______________________________\n");
        System.out.println("     |     |      ");
        System.out.println("  " + moveInputBuilder.charAt(0) + "  |  " + moveInputBuilder.charAt(1) + "  |  " + moveInputBuilder.charAt(2));
        System.out.println("_____|_____|_____ ");
        System.out.println("     |     |      ");
        System.out.println("  " + moveInputBuilder.charAt(3) + "  |  " + moveInputBuilder.charAt(4) + "  |  " + moveInputBuilder.charAt(5));
        System.out.println("_____|_____|_____ ");
        System.out.println("     |     |      ");
        System.out.println("  " + moveInputBuilder.charAt(6) + "  |  " + moveInputBuilder.charAt(7) + "  |  " + moveInputBuilder.charAt(8));
        System.out.println("     |     |      ");
    }

    public static void main(String[] args) {
        Game game = new Game();

        while (isHosting == 'u') {
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (isHosting == 'y'){
            game.view.waiting();
            game.user = new Host();
        }
        else {
            game.view.waiting();
            game.user = new Player();
        }


        String incomingData;
        StringBuilder incomingDataBuilder;
        StringBuilder data;
        StringBuilder moveInputBuilder;

        while (game.getGameStatus() == 'n') {
            if((game.user.getIsHost() && game.getCurrentPlayer() != 'x') || (!game.user.getIsHost() && game.getCurrentPlayer() != 'o')){
                // if not your turn
                game.view.waiting();
                incomingDataBuilder = new StringBuilder();

                System.out.println("Waiting For Other Player...");
                incomingData = game.user.waitForData();

                for(int i = 1; i < 10; i++){
                    incomingDataBuilder.append(incomingData.charAt(i));
                }

                game.setCurrentPlayer(incomingData.charAt(0));
                game.setSquares(incomingDataBuilder.toString());
                game.setGameStatus();

                continue;
            }
            // if your turn
            game.view.updateGame(game.squares, game.getCurrentPlayer(), game.getGameStatus());

            data = new StringBuilder();
            moveInputBuilder = new StringBuilder();
            moveInputBuilder.append(game.getSquares());

            System.out.println("\nTicTacToe\n");
            System.out.println(game.getCurrentPlayer() + "'s turn!");

            game.displayGameBoard();


            while(move == -1){
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (move >= 0 && move <= 8) {
                // if valid input
                if (game.isMoveValid(move)) {
                    // make move
                    moveInputBuilder.setCharAt(move, game.currentPlayer);

                    game.setSquares(moveInputBuilder.toString());
                    move = -1;
                    game.setGameStatus();

                    // change turns
                    if (game.getCurrentPlayer() == 'x')
                        game.setCurrentPlayer('o');
                    else
                        game.setCurrentPlayer('x');

                    if(!game.user.isSocketActive()){
                        System.out.println("Other Player Has Disconnected!\nExiting...");
                        exit(1);
                    }

                    // make data string
                    data.append(game.getCurrentPlayer());
                    data.append(game.getSquares());

                    // send data string
                    game.user.sendData(data.toString());

                    // if game is over
                    if(game.getGameStatus() != 'n'){
                        break;
                    }
                }
                else{
                    // square occupied
                    System.out.println("That square is already occupied!\nTry Again!");
                }


            }
            else {
                System.out.println("Incorrect Input!");
            }
        }
        game.displayGameBoard();
        game.view.updateGame(game.squares, game.getCurrentPlayer(), game.getGameStatus());

        if(game.getGameStatus() == 't'){
            System.out.println("\nThe Game Was a Tie...\n");
        }
        else if(game.getGameStatus() == 'x'){
            System.out.println("\nPlayer 1 (x) Won!!\n");
        }
        else{
            System.out.println("\nPlayer 2 (o) Won!!\n");
        }


    }

}