package View;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Vector;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;
import com.sun.org.apache.xpath.internal.operations.Bool;

import Game.Game;
import Game.Launcher;
import IA.Coup;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;


public class MultiViewController extends ToolsBarController implements Initializable
{
	
	@FXML private ImageView Button00;
	@FXML private ImageView Button01;
	@FXML private ImageView Button02;
	@FXML private ImageView Button10;
	@FXML private ImageView Button11;
	@FXML private ImageView Button12;
	@FXML private ImageView Button20;
	@FXML private ImageView Button21;
	@FXML private ImageView Button22;
	@FXML private ImageView Speaker;
	@FXML private ImageView imagePlayer00 ;
	@FXML private ImageView imagePlayer01 ;
	@FXML public Rectangle rectangle00 ;
	@FXML public Rectangle rectangle01 ;
	@FXML public Rectangle rectangle02 ;
	@FXML public Rectangle rectangle03 ;
	@FXML public Rectangle rectangle04 ;
	@FXML public Rectangle rectangle05 ;
	@FXML public Rectangle rectangle06 ;
	@FXML public Rectangle rectangle07 ;
	@FXML private Button player00 ;
	@FXML private Button player01 ;
	
	int click = 0 ;
	Image cercle = new Image("Images/Circle.png") ;
	Image croix = new Image("Images/Cross.png") ;
	Image base = new Image("Images/Blanc.png") ;
	Game game = new Game();
	Image speakerOff = new Image("Images/speakerOff.png");
	Image speakerOn = new Image("Images/speakerOn.png");
	Vector<Coup> listJoueur1 = new Vector<Coup>() ;
	Vector<Coup> listJoueur2 = new Vector<Coup>() ;
	
	Launcher launcher = Launcher.getInstance() ;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		this.displayerPlayer00();
		this.displayPlayer01();
		this.alertJoueur1();
	}
	
	public void alertJoueur1()
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Début du jeu !");
		alert.setHeaderText(null);
		alert.setContentText("Le joueur " + launcher.getPlayer00Name() + " commence");
		alert.showAndWait();
	}
	
	public void alertJoueur2()
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Début du jeu !");
		alert.setHeaderText(null);
		alert.setContentText("Le joueur " + launcher.getPlayer01Name() + " commence");
		alert.showAndWait();
	}

	public void displayerPlayer00()
	{
		this.player00.setText(launcher.getPlayer00Name());
		this.imagePlayer00.setImage(croix);
	}
	
	public void displayPlayer01()
	{
		this.player01.setText(launcher.getPlayer01Name());
		this.imagePlayer01.setImage(cercle);
	}
	
	@FXML
	public void onClickQuitButton()
	{
		super.onClickQuitButton();
	}
	
	@FXML
	public void onClickSetttingButton()
	{
		super.onClickSettingButton();
	}
	
	private void annimationLine(Rectangle rectangle)
	{
		final TranslateTransition translateAnimation = new TranslateTransition(Duration.seconds(1), rectangle); 
		translateAnimation.setCycleCount(TranslateTransition.INDEFINITE); 
		translateAnimation.setAutoReverse(true); 
		translateAnimation.setByX(70); 
		translateAnimation.setByY(0); 
		translateAnimation.setInterpolator(Interpolator.LINEAR);
		translateAnimation.play();
	}
	 
	
	private void annimationVerticale(Rectangle rectangle)
	{
		final TranslateTransition translateAnimation = new TranslateTransition(Duration.seconds(1), rectangle); 
		translateAnimation.setCycleCount(TranslateTransition.INDEFINITE); 
		translateAnimation.setAutoReverse(true); 
		translateAnimation.setByX(0); 
		translateAnimation.setByY(70); 
		 
		translateAnimation.setInterpolator(Interpolator.LINEAR);
		translateAnimation.play();
	}
	
	

	private void annimationDiagonale(Rectangle rectangle)
	{
		final TranslateTransition translateAnimation = new TranslateTransition(Duration.seconds(1), rectangle); 
		translateAnimation.setCycleCount(TranslateTransition.INDEFINITE); 
		translateAnimation.setAutoReverse(true); 
		translateAnimation.setByX(70); 
		translateAnimation.setByY(70); 
		translateAnimation.setInterpolator(Interpolator.LINEAR);
		translateAnimation.play();
	}
	public void afficheTrait(int a)
	{
		switch(a) {
		case 1:
			this.rectangle00.setVisible(true);
			this.annimationLine(rectangle00);
			break;
		case 2:
			this.rectangle01.setVisible(true);
			this.annimationLine(rectangle01);
			break ;
		case 3:
			this.rectangle02.setVisible(true);
			this.annimationLine(rectangle02);
			break ;
		case 4:
			this.rectangle03.setVisible(true);
			this.annimationVerticale(rectangle03);
			break ;
		case 5:
			this.rectangle04.setVisible(true);
			this.annimationVerticale(rectangle04);
			break ;
		case 6:
			this.rectangle05.setVisible(true);
			this.annimationVerticale(rectangle05);
			break ;
		case 7:
			this.rectangle06.setVisible(true);
			this.annimationDiagonale(rectangle06);
			break ;
		case 8:
			this.rectangle07.setVisible(true);
			this.annimationDiagonale(rectangle07);
			break ;
		default:
			break;
		}
	}
	@FXML
	void onClickButton00()
	{
		Coup coups = new Coup() ;
		coups.setIn(this.game.getPlateau());
		this.Button00.setDisable(true);
		this.Button00.setImage((this.game.turnPlayer(0) ? cercle : croix)) ;
		coups.setOut(this.game.getPlateau());
		if(this.game.turnPlayer1) this.listJoueur1.add(coups) ;
		else this.listJoueur2.add(coups) ;
		this.click++;
		if(this.click > 4)
		{
			int a = this.game.win() ;
			if(a != -1)
			{
				if(this.game.turnPlayer1) this.game.saveCoup(listJoueur1);
				else this.game.saveCoup(listJoueur2);
				this.afficheTrait(a) ;
				this.win() ;
				return ;
			}
		}
		if(this.click == 9)
		{
			this.gameNull() ;
		}
		
	}
	
	@FXML
	void onClickButton01()
	{
		Coup coups = new Coup() ;
		coups.setIn(this.game.getPlateau());
		this.Button01.setDisable(true);
		this.Button01.setImage((this.game.turnPlayer(1) ? cercle : croix)) ;
		coups.setOut(this.game.getPlateau());
		if(this.game.turnPlayer1) this.listJoueur1.add(coups) ;
		else this.listJoueur2.add(coups) ;
		this.click++;
		if(this.click > 4)
		{
			int a = this.game.win() ;
			if(a != -1)
			{
				if(!this.game.turnPlayer1) this.game.saveCoup(listJoueur2);
				else this.game.saveCoup(listJoueur1);
				this.afficheTrait(a) ;
				this.win() ;
				return ;
			}
		}
		if(this.click == 9)
		{
			this.gameNull() ;
		}
	}
	
	@FXML
	void onClickButton02()
	{
		Coup coups = new Coup() ;
		coups.setIn(this.game.getPlateau());
		this.Button02.setDisable(true);
		this.Button02.setImage((this.game.turnPlayer(2) ? cercle : croix)) ;
		coups.setOut(this.game.getPlateau());
		if(this.game.turnPlayer1) this.listJoueur1.add(coups) ;
		else this.listJoueur2.add(coups) ;
		this.click++;
		if(this.click > 4)
		{
			int a = this.game.win() ;
			if(a != -1)
			{
				if(!this.game.turnPlayer1) this.game.saveCoup(listJoueur2);
				else this.game.saveCoup(listJoueur1); 
				this.afficheTrait(a) ;
				this.win() ;
				return ;
			}
		}
		if(this.click == 9)
		{
			this.gameNull() ;
		}
	}
	
	@FXML
	void onClickButton10()
	{
		Coup coups = new Coup() ;
		coups.setIn(this.game.getPlateau());
		this.Button10.setDisable(true);
		this.Button10.setImage((this.game.turnPlayer(3) ? cercle : croix)) ;
		coups.setOut(this.game.getPlateau());
		if(this.game.turnPlayer1) this.listJoueur1.add(coups) ;
		else this.listJoueur2.add(coups) ;
		this.click++;
		if(this.click > 4)
		{
			int a = this.game.win() ;
			if(a != -1)
			{
				if(!this.game.turnPlayer1) this.game.saveCoup(listJoueur2);
				else this.game.saveCoup(listJoueur1);
				this.afficheTrait(a) ;
				this.win() ;
				return ;
			}
		}
		if(this.click == 9)
		{
			this.gameNull() ;
		}
	}
	
	@FXML
	void onClickButton11()
	{
		Coup coups = new Coup() ;
		coups.setIn(this.game.getPlateau());
		this.Button11.setDisable(true);
		this.Button11.setImage((this.game.turnPlayer(4) ? cercle : croix)) ;
		coups.setOut(this.game.getPlateau());
		if(this.game.turnPlayer1) this.listJoueur1.add(coups) ;
		else this.listJoueur2.add(coups) ;
		this.click++;
		if(this.click > 4)
		{
			int a = this.game.win() ;
			if(a != -1)
			{
				if(!this.game.turnPlayer1) this.game.saveCoup(listJoueur2);
				else this.game.saveCoup(listJoueur1);
				this.afficheTrait(a) ;
				this.win() ;
				return ;
			}
		}
		if(this.click == 9)
		{
			this.gameNull() ;
		}
	}
	
	@FXML
	void onClickButton12()
	{
		Coup coups = new Coup() ;
		coups.setIn(this.game.getPlateau());
		this.Button12.setDisable(true);
		this.Button12.setImage((this.game.turnPlayer(5) ? cercle : croix)) ;
		coups.setOut(this.game.getPlateau());
		if(this.game.turnPlayer1) this.listJoueur1.add(coups) ;
		else this.listJoueur2.add(coups) ;
		this.click++;
		if(this.click > 4)
		{
			int a = this.game.win() ;
			if(a != -1)
			{
				if(!this.game.turnPlayer1) this.game.saveCoup(listJoueur2);
				else this.game.saveCoup(listJoueur1);
				this.afficheTrait(a) ;
				this.win() ;
				return ;
			}
		}
		if(this.click == 9)
		{
			this.gameNull() ;
		}
	}
	
	@FXML
	void onClickButton20()
	{
		Coup coups = new Coup() ;
		coups.setIn(this.game.getPlateau());
		this.Button20.setDisable(true);
		this.Button20.setImage((this.game.turnPlayer(6) ? cercle : croix)) ;
		coups.setOut(this.game.getPlateau());
		if(this.game.turnPlayer1) this.listJoueur1.add(coups) ;
		else this.listJoueur2.add(coups) ;
		this.click++;
		if(this.click > 4)
		{
			int a = this.game.win() ;
			if(a != -1)
			{
				if(!this.game.turnPlayer1) this.game.saveCoup(listJoueur2);
				else this.game.saveCoup(listJoueur1); 
				this.afficheTrait(a) ;
				this.win() ;
				return ;
			}
		}
		if(this.click == 9)
		{
			this.gameNull() ;
		}
	}
	
	@FXML
	void onClickButton21()
	{
		Coup coups = new Coup() ;
		coups.setIn(this.game.getPlateau());
		this.Button21.setDisable(true);
		this.Button21.setImage((this.game.turnPlayer(7) ? cercle : croix)) ;
		coups.setOut(this.game.getPlateau());
		if(this.game.turnPlayer1) this.listJoueur1.add(coups) ;
		else this.listJoueur2.add(coups) ;
		this.click++;
		if(this.click > 4)
		{
			int a = this.game.win() ;
			if(a != -1)
			{
				if(!this.game.turnPlayer1) this.game.saveCoup(listJoueur2);
				else this.game.saveCoup(listJoueur1);
				this.afficheTrait(a) ;
				this.win() ;
				return ;
			}
		}
		if(this.click == 9)
		{
			this.gameNull() ;
		}
	}
	
	@FXML
	void onClickButton22()
	{
		Coup coups = new Coup() ;
		coups.setIn(this.game.getPlateau());
		this.Button22.setDisable(true);
		this.Button22.setImage((this.game.turnPlayer(8) ? cercle : croix)) ;
		coups.setOut(this.game.getPlateau());
		if(this.game.turnPlayer1) this.listJoueur1.add(coups) ;
		else this.listJoueur2.add(coups) ;
		this.click++;
		if(this.click > 4)
		{
			int a = this.game.win() ;
			if(a != -1)
			{
				if(!this.game.turnPlayer1) this.game.saveCoup(listJoueur2);
				else this.game.saveCoup(listJoueur1); 
				this.afficheTrait(a) ;
				this.win() ;
				return ;
			}
		}
		if(this.click == 9)
		{
			this.gameNull() ;
		}
	}
	
	void eraseImage()
	{
		this.click = 0;
		this.Button00.setDisable(false);
		this.Button01.setDisable(false);
		this.Button02.setDisable(false);
		this.Button10.setDisable(false);
		this.Button11.setDisable(false);
		this.Button12.setDisable(false);
		this.Button20.setDisable(false);
		this.Button21.setDisable(false);
		this.Button22.setDisable(false);
		
		this.Button00.setImage(this.base);
		this.Button01.setImage(this.base);
		this.Button02.setImage(this.base);
		this.Button10.setImage(this.base);
		this.Button11.setImage(this.base);
		this.Button12.setImage(this.base);
		this.Button20.setImage(this.base);
		this.Button21.setImage(this.base);
		this.Button22.setImage(this.base);
		
		this.rectangle00.setVisible(false);
		this.rectangle01.setVisible(false);
		this.rectangle02.setVisible(false);
		this.rectangle03.setVisible(false);
		this.rectangle04.setVisible(false);
		this.rectangle05.setVisible(false);
		this.rectangle06.setVisible(false);
		this.rectangle07.setVisible(false);
		
		this.game.erasePion() ;
	}
	@FXML
	public void onClickHomeButton()
	{
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Attention");
		alert.setHeaderText("Voullez-vous vraiment quitter ?");
		
		ButtonType buttonTypeOne = new ButtonType("Non");
		ButtonType buttonTypeThree = new ButtonType("Quit");
		
		alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeThree);
		Optional<ButtonType> result = alert.showAndWait();
		
		if(result.get() == buttonTypeThree)
		{
			this.eraseImage() ;
			super.onClickHomeButton();
		}
		else 
		{
		
		}
	}
	
	public void gameNull()
	{
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Fin de la aprtie");
		alert.setHeaderText("Match null ! Personne n'a gagné");
		alert.setContentText("Choose your option.");

		ButtonType buttonTypeOne = new ButtonType("Recommencer");
		ButtonType buttonTypeThree = new ButtonType("Quit");

		alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeThree);
		Optional<ButtonType> result = alert.showAndWait();
		
		if(result.get() == buttonTypeOne)
		{
			this.eraseImage();
			if(this.game.turnPlayer1)
			{
				this.alertJoueur1();
			}
			else {
				this.alertJoueur2();
			}
		}
		else 
		{
			this.makeOnFadeOut();
		}

	}
	
	private void makeOnFadeOut() 
	{
		Launcher laucher = Launcher.getInstance() ;
		FadeTransition fadeTransition = new FadeTransition() ;
		fadeTransition.setDuration(Duration.millis(1000));
		fadeTransition.setNode(laucher.getRootLayout());
		fadeTransition.setFromValue(1);
		fadeTransition.setToValue(0);
		fadeTransition.play();
		fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				FXMLLoader loader = new FXMLLoader();
				try {
					loader.setLocation(getClass().getResource("MenuView.fxml"));
					launcher.setRootLayout(loader.load());

					Scene scene = new Scene(launcher.getRootLayout());
					launcher.getPrimaryStage().setScene(scene);
					launcher.getPrimaryStage().show();
				} 
				catch (Exception e) 
				{
					System.out.println(e.getMessage());
				}
			}
		});
	}
	
	public void win()
	{
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Congratulations");
		String tmpString = "" ;

		if(!this.game.turnPlayer1) tmpString = launcher.getPlayer00Name() ;
		else tmpString = launcher.getPlayer01Name() ;

		alert.setHeaderText("Le joueur " + tmpString +" à gagner ");
		alert.setContentText("Choose your option.");

		ButtonType buttonTypeOne = new ButtonType("Recommencer");
		ButtonType buttonTypeThree = new ButtonType("Quit");

		alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeThree);
		Optional<ButtonType> result = alert.showAndWait();

		if(result.get() == buttonTypeOne)
		{
			
			this.eraseImage();
			if(this.game.turnPlayer1)
			{
				this.alertJoueur1();
			}
			else {
				this.alertJoueur2();
			}
		}
		else 
		{
			this.makeOnFadeOut();
		}
	}
	
	@FXML
	 void onClickStopMusic()
	{
		Launcher launcher = Launcher.getInstance();
		 Status status =launcher.getMedia().getStatus(); 
         if (status == status.PLAYING) { 
		
        	 launcher.getMedia().pause(); 
        	 this.Speaker.setImage(speakerOff);
        
         }
         else {
        	 

        	 launcher.getMedia().play(); 
        	 this.Speaker.setImage(speakerOn);
        	 
         }
	}
}
