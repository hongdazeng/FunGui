import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PopupBox {

    static boolean yesNo;

    public static void displaySimple(String title, String message) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setWidth(300);
        window.setHeight(200);

        Label label = new Label();
        label.setWrapText(true);
        label.setText(message);
        label.setTextAlignment(TextAlignment.CENTER);
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(20);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

    public static void timeBox() {
        Stage window = new Stage();
        GreatDate time = new GreatDate();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Right now it is");
        window.setWidth(250);
        window.setHeight(250);

        Label label = new Label();
        label.setWrapText(true);
        String a = ("" + time.getDate(true) + "\n" + time.getTime());
        label.setText(a);
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> window.close());

        Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction(e -> {
            GreatDate newTime = new GreatDate();
            String b = ("" + newTime.getDate(true) + "\n" + newTime.getTime());
            label.setText(b);
        });

        VBox layout = new VBox(20);
        layout.getChildren().addAll(label, refreshButton, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

    public static boolean displayConfirmation(String title, String message) {

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setWidth(300);
        window.setHeight(250);

        Label label = new Label();
        label.setWrapText(true);
        label.setText(message);
        label.setTextAlignment(TextAlignment.CENTER);
        label.setPadding(new Insets(20, 20, 20, 20));
        Button yesButton = new Button("Yes");
        yesButton.setOnAction(e -> {
            yesNo = true;
            window.close();
        });
        Button noButton = new Button("No");
        noButton.setOnAction(e -> {
            yesNo = false;
            window.close();
        });

        VBox layout = new VBox(20);
        layout.getChildren().addAll(label, yesButton, noButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return yesNo;
    }

}