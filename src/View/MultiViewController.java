package View;

import java.util.Optional;

import Game.Game;
import Game.Launcher;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class MultiViewController extends ToolsBarController
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
	
	int click = 0 ;
	Image cercle = new Image("Images/perfect-circle_icon-icons.com_53928.png") ;
	Image croix = new Image("Images/1487086345-cross_81577.png") ;
	Image base = new Image("Images/Blanc.png") ;
	Game game = new Game();
	

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
	}
	
}
