import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.*;
import javafx.scene.*;

import java.util.Random;

public class FunGui extends Application {

    Stage window;
    Scene main, number, quote;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        Label labelMain = new Label("Welcome to the main menu, choose an option");

        //Navigational buttons
        Button buttonNumber = new Button("Go to the number generator");
        Button buttonQuote = new Button("Read a random quote");
        Button returnToMain = new Button("Return to Main");

        //Action buttons
        Button genNumber = new Button("Generate a number between 1 and 1000");
        Button getQuote = new Button("Get a new quote");

        StackPane layout = new StackPane();
    }

    public int getNumber(int a, int b) {
        Random random = new Random();
        int someInt;
        someInt = random.nextInt(a - b + 1) + 1;
        return someInt;
    }
}
