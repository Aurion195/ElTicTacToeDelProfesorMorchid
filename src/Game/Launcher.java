package Game;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.* ;
import javafx.stage.Stage;

public class Launcher extends Application 
{

    private Stage primaryStage;
    private AnchorPane rootLayout;

    @Override
    public void start(Stage primaryStage) 
    {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Morprion");

        initRootLayout();
    }
    
    /**
     * Initializes the root layout.
     */
    public void initRootLayout() 
    {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Launcher.class.getClassLoader().getResource("View/MainAppView.fxml"));
            rootLayout = (AnchorPane) loader.load();
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
           
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

 
    
    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() 
    {
        return primaryStage;
    }

    public static void main(String[] args) 
    {
        launch(args);
    }
}