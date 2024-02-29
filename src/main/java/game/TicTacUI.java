package game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicTacUI extends Application {
    private char[][] board = new char[3][3];
    private char currentPlayer = 'X';
    private Button[][] buttons = new Button[3][3];

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        initializeBoard();

        GridPane gridPane = new GridPane();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Button button = new Button();
                button.setMinSize(100, 100);
                int finalRow = row;
                int finalCol = col;
                button.setOnAction(e -> handleButtonClick(finalRow, finalCol));
                buttons[row][col] = button;
                gridPane.add(button, col, row);
            }
        }

        Scene scene = new Scene(gridPane, 300, 300);

        primaryStage.setTitle("Tic-Tac-Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initializeBoard() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }
    }

    private void handleButtonClick(int row, int col) {
        if (isValidMove(row, col)) {
            buttons[row][col].setText(String.valueOf(currentPlayer));
            board[row][col] = currentPlayer;
            if (checkWinner()) {
                System.out.println("Player " + currentPlayer + " wins!");
                resetGame();
            } else if (isBoardFull()) {
                System.out.println("It's a tie!");
                resetGame();
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        } else {
            System.out.println("Invalid move! Try again.");
        }
    }

    private boolean isValidMove(int row, int col) {
        return board[row][col] == ' ';
    }

    private boolean checkWinner() {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) ||
                    (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)) {
                return true;
            }
        }

        return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }

    private boolean isBoardFull() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private void resetGame() {
        initializeBoard();
        currentPlayer = 'X';
        for (Button[] row : buttons) {
            for (Button button : row) {
                button.setText("");
            }
        }
    }
}
