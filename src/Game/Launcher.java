package Game;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.* ;
import javafx.stage.Stage;
import sun.launcher.resources.launcher;

public class Launcher extends Application 
{

    private Stage primaryStage;
    private AnchorPane rootLayout;
	private static volatile Launcher instance = null;

	public Launcher()
	{
	    super();
	    synchronized(Launcher.class)
	    {
	        if(instance != null) throw new UnsupportedOperationException(
	                getClass()+" is singleton but constructor called more than once");
	        instance = this;
	    }
	}

	public final static Launcher getInstance()
	{
		if(Launcher.instance == null)
		{
			synchronized(Launcher.class)
			{
				if(Launcher.instance == null)
				{
					Launcher.instance = new Launcher();
				}
			}
		}
		return Launcher.instance;
	}
	
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
            loader.setLocation(Launcher.class.getClassLoader().getResource("View/MenuView.fxml"));
            rootLayout = (AnchorPane) loader.load();
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setResizable(false);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    /**
	 * @return the rootLayout
	 */
	public AnchorPane getRootLayout() 
	{
		return rootLayout;
	}

	/**
	 * @param primaryStage the primaryStage to set
	 */
	public void setPrimaryStage(Stage primaryStage) 
	{
		this.primaryStage = primaryStage;
	}

	/**
	 * @param rootLayout the rootLayout to set
	 */
	public void setRootLayout(AnchorPane rootLayout) 
	{
		this.rootLayout = rootLayout;
	}

	/**
	 * @param instance the instance to set
	 */
	public static void setInstance(Launcher instance) 
	{
		Launcher.instance = instance;
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
