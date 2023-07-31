package 游戏;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DouNiuGameGUI extends Application {
    private DouNiuGame game;
    private GridPane gridPane;

    public DouNiuGameGUI() {
        game = new DouNiuGame();
        game.shuffleDeck();
    }

    @Override
    public void start(Stage primaryStage) {
        gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        Button dealButton = new Button("Deal Cards");
        dealButton.setOnAction(e -> dealCards());

        gridPane.add(dealButton, 0, 0);

        Scene scene = new Scene(gridPane, 300, 200);
        primaryStage.setTitle("Dou Niu Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void dealCards() {
        gridPane.getChildren().removeIf(node -> node instanceof Button);

        int numPlayers = 4;
        game.dealCards(numPlayers);

        for (int i = 0; i < numPlayers; i++) {
            Button button = new Button("Player " + (i + 1));
            gridPane.add(button, 0, i + 1);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
