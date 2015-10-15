/* by Hongda Zeng
 *  October 12, 2015
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Main extends Application {

    Random random = new Random();
    Stage window;
    Scene sceneMain, sceneNumber, sceneQuote;
    ArrayList<String> quoteList = new ArrayList<>();
    File quotes = new File("data\\quotes.txt");

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;

        readQuotes();

        Label labelMain = new Label("Welcome to the main menu, choose an option:");
        Label labelNumber1 = new Label("This is a random number generator (1 to 1000)");
        Label labelQuote1 = new Label("This will display a quote");
        labelQuote1.setWrapText(true);


        //Navigational buttons
        Button buttonNumber = new Button("Go to the number generator");
        Button buttonQuote = new Button("Read a random quote");
        Button buttonTime = new Button("See current time");
        Button buttonAbout = new Button("About");
        Button buttonExit = new Button("Exit");

        buttonNumber.setMaxWidth(Double.MAX_VALUE);
        buttonQuote.setMaxWidth(Double.MAX_VALUE);
        buttonTime.setMaxWidth(Double.MAX_VALUE);


        Button returnToMain = new Button("Return to Main");
        Button returnToMain2 = new Button("Return to Main");

        buttonNumber.setOnAction(e -> window.setScene(sceneNumber));
        buttonQuote.setOnAction(e -> window.setScene(sceneQuote));
        buttonAbout.setOnAction(e -> PopupBox.displaySimple("About", "This application is created by" +
                " Hongda Zeng"));
        buttonTime.setOnAction(e -> PopupBox.timeBox());
        buttonExit.setOnAction(e -> closeMe());

        returnToMain.setOnAction(e -> window.setScene(sceneMain));
        returnToMain2.setOnAction(e -> window.setScene(sceneMain));

        //Action buttons
        Button genNumber = new Button("Click to generate a number");
        genNumber.setOnAction(e -> {
            int a = getNumber(1, 1000);
            labelNumber1.setText("You number is : " + a);
        });
        Button getQuote = new Button("Get a new quote");
        getQuote.setOnAction(e -> {
            String newQuote = getQuote();
            labelQuote1.setText(newQuote);
        });

        VBox layoutMain = new VBox(20);
        layoutMain.getChildren().addAll(labelMain, buttonNumber,
                buttonQuote, buttonTime);
        layoutMain.setPadding(new Insets(20, 20, 20, 20));

        HBox layoutBot = new HBox(20);
        layoutBot.getChildren().addAll(buttonAbout, buttonExit);
        layoutBot.setPadding(new Insets(20, 20, 20, 20));
        layoutBot.setAlignment(Pos.CENTER);

        BorderPane mainPane = new BorderPane();
        mainPane.setCenter(layoutMain);
        mainPane.setBottom(layoutBot);
        sceneMain = new Scene(mainPane, 450, 350);

        VBox layoutNumber = new VBox(20);
        layoutNumber.getChildren().addAll(labelNumber1, genNumber, returnToMain);
        layoutNumber.setPadding(new Insets(20, 20, 20, 20));
        sceneNumber = new Scene(layoutNumber, 450, 300);

        VBox layoutQuote = new VBox(20);
        layoutQuote.getChildren().addAll(labelQuote1, getQuote, returnToMain2);
        layoutQuote.setPadding(new Insets(20, 20, 20, 20));
        sceneQuote = new Scene(layoutQuote, 600, 300);

        window.setOnCloseRequest(e -> {
            e.consume();
            closeMe();
        });
        window.setScene(sceneMain);
        window.setTitle("Fun GUI");
        window.show();
    }

    public int getNumber(int b, int a) {
        int someInt;
        someInt = random.nextInt(a - b + 1) + 1;
        return someInt;
    }

    public void readQuotes() {
        try (BufferedReader br = new BufferedReader(new FileReader(quotes))) {
            String line;
            while ((line = br.readLine()) != null) {
                quoteList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getQuote() {
        int numQuote = quoteList.size();
        int ranQuote = random.nextInt(numQuote);
        return quoteList.get(ranQuote);
    }

    public void closeMe() {
        boolean exit = PopupBox.displayConfirmation("Exit?", "Are you sure you want to quit?");
        if (exit) {
            window.close();
        }
    }
}
