package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.util.Arrays;

public class Main extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {

        // Array of at least 20 ints
        int[] numbers = {18, 16, 1, 13, 8, 19, 2, 9, 14, 3, 20, 10, 17, 4, 11, 5, 6, 7, 12, 15};

        // Label
        Label arrayDetailsLabel = new Label(Arrays.toString(numbers));

        // Image
        Image rulerImage = new Image("file:C:\\dev\\saveFilesHere\\Cool\\ruler.jpg");
        ImageView rulerImageView = new ImageView(rulerImage);
        rulerImageView.setFitWidth(400);
        rulerImageView.setFitHeight(200);
        rulerImageView.preserveRatioProperty();

        // Text
        Text topDescription = new Text("SEARCH BENCHMARKS");
        topDescription.setFont(new Font("Verdana", 20));
        topDescription.setFill(Color.BLACK);

        // Sequential Search controls
        Label sequentialSearchLabel = new Label("Sequential Search:");
        Label sequentialSearchBenchmarksLabel = new Label("");
        HBox sequentialSearchHBox = new HBox(5, sequentialSearchLabel, sequentialSearchBenchmarksLabel);
        sequentialSearchHBox.setAlignment(Pos.CENTER);
        sequentialSearchHBox.setPadding(new Insets(5));

        // Binary Search controls
        Label binarySearchLabel = new Label("Binary Search:");
        Label binarySearchBenchmarksLabel = new Label("");
        HBox binarySearchHBox = new HBox(5, binarySearchLabel, binarySearchBenchmarksLabel);
        binarySearchHBox.setAlignment(Pos.CENTER);
        binarySearchHBox.setPadding(new Insets(5));

        // Search for number
        Label searchForNumberLabel = new Label("Search for number 1-20");
        TextField searchForNumberTextField = new TextField();
        VBox searchForNumberVBox = new VBox(5, searchForNumberLabel, searchForNumberTextField);
        searchForNumberVBox.setAlignment(Pos.CENTER);
        searchForNumberVBox.setPadding(new Insets(5));

        // VBox for Searches
        VBox searchVBox = new VBox(10, arrayDetailsLabel, sequentialSearchHBox, binarySearchHBox, searchForNumberVBox);
        searchVBox.setAlignment(Pos.CENTER);
        searchVBox.setPadding(new Insets(10));

        // Button & Event Handling
        Button searchButton = new Button("Search");
        searchButton.setOnAction(e ->
        {

            int userNumber = Integer.parseInt(searchForNumberTextField.getText());

            // Sequential search & update label
            int sqBenchmark = IntSequentialSearcher.benchmark(numbers, userNumber);
            sequentialSearchBenchmarksLabel.setText(String.valueOf(sqBenchmark));

            // Sort array, Binary search & update label
            IntQuickSorter.quickSort(numbers);
            System.out.println("The sorted array: " + Arrays.toString(numbers));
            int bsBenchmark = IntBinarySearcher.bsBenchmark(numbers, userNumber);
            binarySearchBenchmarksLabel.setText(String.valueOf(bsBenchmark));


        });

        // Main container
        VBox mainContainer = new VBox(10, rulerImageView, topDescription, searchVBox, searchButton );
        mainContainer.setAlignment(Pos.CENTER);
        mainContainer.setPadding(new Insets(10));

        // Scene
        Scene scene = new Scene(mainContainer, 500, 500);

        // Stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("SEARCH BENCHMARKS");
        primaryStage.show();
    }


    public static void main(String[] args)
    {
        launch(args);
    }
}
