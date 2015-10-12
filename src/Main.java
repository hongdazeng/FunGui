import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.*;
import javafx.scene.*;

import java.util.Random;

public class Main extends Application {

    Random random = new Random();
    Stage window;
    Scene scenemain, scenenumber, scenequote;

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

        VBox layoutMain = new VBox(20);
        layoutMain.getChildren().addAll(labelMain, buttonNumber, buttonQuote);
        scenemain = new Scene(layoutMain, 450, 300);

        window.setScene(scenemain);
        window.setTitle("Fun GUI");
        window.show();
    }

    public int getNumber(int a, int b) {
        int someInt;
        someInt = random.nextInt(a - b + 1) + 1;
        return someInt;
    }
}
