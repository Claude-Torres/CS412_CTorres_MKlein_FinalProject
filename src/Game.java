import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
    char squares[] = new char[9];
    char currentPlayer;
    char gameStatus;

    Game() {
        for(int i = 0; i < 9; i++){
            squares[i] = 'n';
        }

        currentPlayer = 'x';
        gameStatus = 'n';
    }

    String getSquares(){
        String s = "";
        for (int i = 0; i < 9; i++){
            s = s + squares[i];
        }
        return s;
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
        for(int i = 0; i < 9; i++){
            // check each square
            if(squares[i] != 'n'){
                count ++;
                // if something is in the square
                if(i == 0){
                    if(squares[1] == squares[0] && squares[2] == squares[0]){
                        // top row win
                        winner = squares[0];
                    }
                    if(squares[3] == squares[0] && squares[6] == squares[0]){
                        // left column win
                        winner = squares[0];
                    }
                    if(squares[4] == squares[0] && squares[8] == squares[0]){
                        // left diagonal win
                        winner = squares[0];
                    }
                }
                else if(i == 1){
                    if(squares[0] == squares[1] && squares[2] == squares[1]){
                        // top row win
                        winner = squares[1];
                    }
                    if(squares[4] == squares[1] && squares[7] == squares[1]){
                        // middle column win
                        winner = squares[1];
                    }
                }
                else if(i == 2){
                    if(squares[0] == squares[2] && squares[1] == squares[2]){
                        // top row win
                        winner = squares[2];
                    }
                    if(squares[5] == squares[2] && squares[8] == squares[2]){
                        // right column win
                        winner = squares[2];
                    }
                    if(squares[4] == squares[2] && squares[6] == squares[2]){
                        // right diagonal win
                        winner = squares[2];
                    }
                }
                else if(i == 3){
                    if(squares[4] == squares[3] && squares[5] == squares[3]){
                        // middle row win
                        winner = squares[3];
                    }
                    if(squares[0] == squares[3] && squares[6] == squares[3]){
                        // left column win
                        winner = squares[3];
                    }
                }
                else if(i == 6){
                    if(squares[7] == squares[6] && squares[8] == squares[6]){
                        // bottom row win
                        winner = squares[6];
                    }
                    if(squares[0] == squares[6] && squares[3] == squares[6]){
                        // left column win
                        winner = squares[6];
                    }
                    if(squares[4] == squares[6] && squares[2] == squares[6]){
                        // right diagonal win
                        winner = squares[6];
                    }
                }
            }
        }
        if(winner == 'n' && count == 9) // tie
            winner = 't';

        gameStatus = winner;

    }

    boolean isMoveValid(int x){
        return squares[x] == 'n';
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

        int moveInt = 0;
        String sMove = "-1";
        String moveInput;
        StringBuilder moveInputBuilder = new StringBuilder("nnnnnnnnn");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (game.getGameStatus() == 'n') {
            moveInputBuilder = new StringBuilder("");
            moveInputBuilder.append(game.getSquares());

            System.out.println("\nTicTacToe\n");
            System.out.println(game.getCurrentPlayer() + "'s turn!");

            game.displayGameBoard();

            System.out.println("Enter a number 1 - 9: ");
            try {
                sMove = reader.readLine();
                moveInt = Integer.parseInt(String.valueOf(sMove));
            } catch (IOException e) {
                System.out.println("Incorrect Input!");
                continue;
            } catch (NumberFormatException e) {
                System.out.println("Incorrect Input!");
                continue;
            }

            if (moveInt >= 1 && moveInt <= 9) {
                // if valid input
                if (game.isMoveValid(moveInt - 1)) {
                    // make move
                    moveInputBuilder.setCharAt(moveInt - 1, game.currentPlayer);
                    moveInput = moveInputBuilder.toString();

                    game.setSquares(moveInput);
                    game.setGameStatus();
                    if(game.getGameStatus() != 'n'){
                        break;
                    }
                }
                else{
                    // square occupied
                    System.out.println("That square is already occupied!\nTry Again!");
                    continue;
                }

                // change turns
                if (game.getCurrentPlayer() == 'x')
                    game.setCurrentPlayer('o');
                else
                    game.setCurrentPlayer('x');
            }
            else {
                System.out.println("Incorrect Input!");
                continue;
            }
        }
        game.displayGameBoard();

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

