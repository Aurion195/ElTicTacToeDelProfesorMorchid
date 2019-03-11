package Game;
import javafx.util.Duration;  
import javafx.scene.media.Media;  
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;



import com.sun.media.jfxmediaimpl.platform.Platform;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.* ;
import javafx.scene.media.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;
import sun.launcher.resources.launcher;



public class Launcher extends Application 
{

    private Stage primaryStage;
    private AnchorPane rootLayout;
	private static volatile Launcher instance = null;
	private static AudioClip mediaPlayer ;

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
	
	public void playMusic()
	{
		Media sound=new Media(new File("src/Son/Take_On_Me.wav").toURI().toString());
        this.mediaPlayer=new AudioClip(sound.getSource());
        this.mediaPlayer.setVolume(0.8);
      
        this.mediaPlayer.play();
	}
	
	public void stopMusic(AudioClip mediaPlayer)
	{  
        mediaPlayer.stop();
	}
	
    @Override
    public void start(Stage primaryStage)  
    {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Morprion");
        
        this.playMusic();
       
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
    
    public AudioClip getMedia()
    {
    	return this.mediaPlayer ;
    }
}
