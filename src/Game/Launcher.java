package Game;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.media.MediaView;

/**
 * Classe qui permet de lancer l'application -> Singleton
 * @author MATHIEU Thomas
 * @author GARCIA Jérémy
 *
 */
public class Launcher extends Application 
{
	/**
	 * 1er scene
	 */
	private Stage primaryStage;
	
	/**
	 * Scene que l'on va changer 
	 */
	private AnchorPane rootLayout;
	
	/**
	 * Instance unique
	 */
	private static volatile Launcher instance = null;
	
	/**
	 * Lecteur audio
	 */
	private static MediaPlayer mediaPlayer ;
	
	/**
	 * Player 1
	 */
	private Player player00 = new Player("");
	
	/**
	 * Player 2
	 */
	private Player player01 = new Player("");


	/**
	 * Constructeur de la classe
	 */
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

	/**
	 * @return le singleton de Launcher
	 */
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

	/**
	 * Permet de jouer de la music dans le menu
	 */
	public void playMusic()
	{	
		Media sound=new Media(new File("src/Son/Take_On_Me.wav").toURI().toString());
		this.mediaPlayer = new MediaPlayer(sound);
		this.mediaPlayer.play();

		final Label currentlyPlaying = new Label();
		final ProgressBar progress = new ProgressBar();
		final ChangeListener<? super javafx.util.Duration> progressChangeListener = null;




		final StackPane layout = new StackPane();

		// determine the source directory for the playlist (either the first parameter to the program or a 
		final List<String> params = getParameters().getRaw();
		final File dir =  new File("src/Son/");

		if(!dir.exists() && dir.isDirectory()) 
		{
			System.out.println("Cannot find audio source directory: " + dir);
		}

		// create some media players.
		final List<MediaPlayer> players = new ArrayList<MediaPlayer>();
		for(String file : dir.list(new FilenameFilter() 
		{
			@Override public boolean accept(File dir, String name) 
			{
				return name.endsWith(".wav");
			}
		}))

			try {
				players.add(createPlayer((dir + "/" + file)));
			}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (players.isEmpty()) 
		{
			System.out.println("No audio found in " + dir);
			return;
		}

		// play each audio file in turn.

		for (int i = 0; i < players.size(); i++) 
		{
			final MediaPlayer player     = players.get(i);
			final MediaPlayer nextPlayer = players.get((i + 1) % players.size());
			player.setOnEndOfMedia(new Runnable() {
				@Override public void run() {
					player.currentTimeProperty().removeListener(progressChangeListener);

					nextPlayer.play();
				}
			});
		}
	}


	/** 
	 * @return le mediaPlayer
	 * */
	private MediaPlayer createPlayer(String aMediaSrc) 
	{
		final MediaPlayer player = new MediaPlayer(new Media(aMediaSrc));
		player.setOnError(new Runnable() 
		{
			@Override public void run() 
			{
				System.out.println("Media error occurred: " + player.getError());
			}
		});

		return player;
	}



	/**
	 * Permet d'arreter la music
	 * @param mediaPlayer
	 */
	public void stopMusic(MediaPlayer mediaPlayer)
	{  
		mediaPlayer.pause();
	}

	/**
	 * Permet de modifier le volume Audio du player
	 * @param mediaPlayer = lecteur audio ;
	 * @param v = volume ;
	 */
	public void setVolume(MediaPlayer mediaPlayer, double v)
	{  
		mediaPlayer.setVolume(v);
	}

	/**
	 * Lance l'application
	 */
	@Override
	public void start(Stage primaryStage)  
	{
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Morprion");

		this.playMusic();
		initRootLayout();
	}

	/**
	 * Initialize le root layout
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
			scene.getStylesheets().add("View/Style.css");
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

	/**
	 * Main du jeu 
	 */
	public static void main(String[] args) 
	{
		launch(args);
	}

	/**
	 * @return le lecteur audio
	 */
	public MediaPlayer getMedia()
	{
		return this.mediaPlayer ;
	}

	/**
	 * @return le nom du player 1
	 */
	public String getPlayer00Name()
	{
		return this.player00.getName() ;
	}

	/**
	 * @return le nom du player 2
	 */
	public String getPlayer01Name()
	{
		return this.player01.getName() ;
	}

	/**
	 * Permet de changer le nom du joueur 1
	 * @param name = nouveau nom ;
	 */
	public void setPlayerName00(String name)
	{
		this.player00.setName(name) ;
	}

	/**
	 * Permet de changer le nom du joueur 2
	 * @param name = nouveau nom
	 */
	public void setPLayerName01(String name)
	{
		this.player01.setName(name);
	}

}
