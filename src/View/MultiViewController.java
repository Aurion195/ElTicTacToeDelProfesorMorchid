package View;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;
import com.sun.org.apache.xpath.internal.operations.Bool;

import Game.Game;
import Game.Launcher;
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
	@FXML private Button player00 ;
	@FXML private Button player01 ;
	
	int click = 0 ;
	Image cercle = new Image("Images/perfect-circle_icon-icons.com_53928.png") ;
	Image croix = new Image("Images/1487086345-cross_81577.png") ;
	Image base = new Image("Images/Blanc.png") ;
	Game game = new Game();
	Image speakerOff=new Image("Images/speakerOff.png");
	Image speakerOn=new Image("Images/speakerOn.png");
	
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		this.displayerPlayer00();
		this.displayPlayer01();
	}
	
	public void displayerPlayer00()
	{
		Launcher launcher = Launcher.getInstance() ;
		this.player00.setText(launcher.getPlayer00Name());
		if(launcher.getPion00().equals("Croix"))
		{
			this.imagePlayer00.setImage(croix);
		}
		else {
			this.imagePlayer00.setImage(cercle);
		}
	}
	
	public void displayPlayer01()
	{
		Launcher launcher = Launcher.getInstance() ;
		this.player01.setText(launcher.getPlayer01Name());
		if(launcher.getPion01().equals("Croix"))
		{
			this.imagePlayer01.setImage(croix);
		}
		else {
			this.imagePlayer01.setImage(cercle);
		}
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
	
	@FXML
	void onClickButton00()
	{
		this.Button00.setDisable(true);
		this.Button00.setImage((this.game.turnPlayer(0) ? cercle : croix)) ;
		this.click++;
		if(this.click > 4 && this.game.win())
		{
			this.win() ;
		}
		else if(this.click == 9)
		{
			this.gameNull() ;
		}
		
	}
	
	@FXML
	void onClickButton01()
	{
		this.Button01.setDisable(true);
		this.Button01.setImage((this.game.turnPlayer(1) ? cercle : croix)) ;
		this.click++;
		if(this.click > 4 && this.game.win())
		{
			this.win() ;
		}
		else if(this.click == 9)
		{
			this.gameNull() ;
		}
	}
	
	@FXML
	void onClickButton02()
	{
		this.Button02.setDisable(true);
		this.Button02.setImage((this.game.turnPlayer(2) ? cercle : croix)) ;
		this.click++;
		if(this.click > 4 && this.game.win())
		{
			this.win() ;
		}
		else if(this.click == 9)
		{
			this.gameNull() ;
		}
	}
	
	@FXML
	void onClickButton10()
	{
		this.Button10.setDisable(true);
		this.Button10.setImage((this.game.turnPlayer(3) ? cercle : croix)) ;
		this.click++;
		if(this.game.win())
		{
			this.win() ;
		}
		else if(this.click == 9)
		{
			this.gameNull() ;
		}
	}
	
	@FXML
	void onClickButton11()
	{
		this.Button11.setDisable(true);
		this.Button11.setImage((this.game.turnPlayer(4) ? cercle : croix)) ;
		this.click++;
		if(this.game.win())
		{
			this.win() ;
		}
		else if(this.click == 9)
		{
			this.gameNull() ;
		}
	}
	
	@FXML
	void onClickButton12()
	{
		this.Button12.setDisable(true);
		this.Button12.setImage((this.game.turnPlayer(5) ? cercle : croix)) ;
		this.click++;
		if(this.click > 4 && this.game.win())
		{
			this.win() ;
		}
		else if(this.click == 9)
		{
			this.gameNull() ;
		}
	}
	
	@FXML
	void onClickButton20()
	{
		this.Button20.setDisable(true);
		this.Button20.setImage((this.game.turnPlayer(6) ? cercle : croix)) ;
		this.click++;
		if(this.click > 4 && this.game.win())
		{
			this.win() ;
		}
		else if(this.click == 9)
		{
			this.gameNull() ;
		}
	}
	
	@FXML
	void onClickButton21()
	{
		this.Button21.setDisable(true);
		this.Button21.setImage((this.game.turnPlayer(7) ? cercle : croix)) ;
		this.click++;
		if(this.click > 4 && this.game.win())
		{
			this.win() ;
		}
		else if(this.click == 9)
		{
			this.gameNull() ;
		}
	}
	
	@FXML
	void onClickButton22()
	{
		this.Button22.setDisable(true);
		this.Button22.setImage((this.game.turnPlayer(8) ? cercle : croix)) ;
		this.click++;
		if(this.click > 4 && this.game.win())
		{
			this.win() ;
		}
		else if(this.click == 9)
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
		
		this.game.erasePion() ;
	}
	@FXML
	public void onClickHomeButton()
	{
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Attention");
		alert.setHeaderText("Voullez-vous vraiment quitter ?");
		ButtonType buttonType = new ButtonType("Non") ;
		
		alert.getButtonTypes().addAll(buttonType) ;
		
		Optional<ButtonType> result = alert.showAndWait();
		if(result.get() != buttonType)
		{
			this.eraseImage() ;
			super.onClickHomeButton();
		}
	}
	
	public void gameNull()
	{
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Fin de la aprtie");
		alert.setHeaderText("Match null ! Personne n'a gagné");
		alert.setContentText("Choose your option.");

		ButtonType buttonTypeOne = new ButtonType("Recommencer");
		ButtonType buttonTypeTwo = new ButtonType("Back");
		ButtonType buttonTypeThree = new ButtonType("Quit");
		ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

		alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeThree, buttonTypeCancel);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == buttonTypeOne)
		{
			this.eraseImage() ;
		}
		else if (result.get() == buttonTypeTwo) 
		{
			// ... user chose "Two"
		} 
		else if (result.get() == buttonTypeThree) 
		{
			// ... user chose "Three"
		}
		else 
		{
			// ... user chose CANCEL or closed the dialog
		}
	}
	
	public void win()
	{
		if(this.game.win())
		{
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Congratulations");
			alert.setHeaderText("Le joueur 'x' à gagner ");
			alert.setContentText("Choose your option.");

			ButtonType buttonTypeOne = new ButtonType("Recommencer");
			ButtonType buttonTypeTwo = new ButtonType("Back");
			ButtonType buttonTypeThree = new ButtonType("Quit");
			ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

			alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeThree, buttonTypeCancel);

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == buttonTypeOne)
			{
				this.eraseImage() ;
			}
			else if (result.get() == buttonTypeTwo) 
			{
				
			} 
			else if (result.get() == buttonTypeThree) 
			{
				// ... user chose "Three"
			}
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
