package View;

import java.util.Vector;

import Game.Game;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class MainAppViewController
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

	Image cercle = new Image("Images/perfect-circle_icon-icons.com_53928.png") ;
	Image croix = new Image("Images/1487086345-cross_81577.png") ;
	Game game = new Game();
	
	private boolean turnPlayer1 = false ;
	private Vector<Boolean> casePlayed = new Vector<Boolean>();
	private Vector<String> choicePlayeurStrings = new Vector<String>() ;
	
	public MainAppViewController() 
	{
		for(int i = 0 ; i < 9 ; i++)
		{
			this.casePlayed.add(true) ;
			int j = i ;
			this.choicePlayeurStrings.add(String.valueOf(j)) ;
		}
	}

	@FXML
	void onClickButton00()
	{
		this.Button00.setDisable(true);
		this.Button00.setImage((turnPlayer1 ? cercle : croix)) ;
		this.turnPlayer1 = !this.turnPlayer1 ;
		this.choicePlayeurStrings.set(0, (this.turnPlayer1 ? "x" : "o"));
	}
	
	@FXML
	void onClickButton01()
	{
		this.Button01.setDisable(true);
		this.Button01.setImage((turnPlayer1 ? cercle : croix)) ;
		this.turnPlayer1 = !this.turnPlayer1 ;
		this.choicePlayeurStrings.set(1, (this.turnPlayer1 ? "x" : "o"));
	}
	
	@FXML
	void onClickButton02()
	{
		this.Button02.setDisable(true);
		this.Button02.setImage((turnPlayer1 ? cercle : croix)) ;
		this.turnPlayer1 = !this.turnPlayer1 ;
		this.choicePlayeurStrings.set(2, (this.turnPlayer1 ? "x" : "o"));
	}
	
	@FXML
	void onClickButton10()
	{
		this.Button10.setDisable(true);
		this.Button10.setImage((turnPlayer1 ? cercle : croix)) ;
		this.turnPlayer1 = !this.turnPlayer1 ;
		this.choicePlayeurStrings.set(3, (this.turnPlayer1 ? "x" : "o"));
	}
	
	@FXML
	void onClickButton11()
	{
		this.Button11.setDisable(true);
		this.Button11.setImage((turnPlayer1 ? cercle : croix)) ;
		this.turnPlayer1 = !this.turnPlayer1 ;
		this.choicePlayeurStrings.set(4, (this.turnPlayer1 ? "x" : "o"));
	}
	
	@FXML
	void onClickButton12()
	{
		this.Button12.setDisable(true);
		this.Button12.setImage((turnPlayer1 ? cercle : croix)) ;
		this.turnPlayer1 = !this.turnPlayer1 ;
		this.choicePlayeurStrings.set(5, (this.turnPlayer1 ? "x" : "o"));
	}
	
	@FXML
	void onClickButton20()
	{
		this.Button20.setDisable(true);
		this.Button20.setImage((turnPlayer1 ? cercle : croix)) ;
		this.turnPlayer1 = !this.turnPlayer1 ;
		this.choicePlayeurStrings.set(6, (this.turnPlayer1 ? "x" : "o"));
	}
	
	@FXML
	void onClickButton21()
	{
		this.Button21.setDisable(true);
		this.Button21.setImage((turnPlayer1 ? cercle : croix)) ;
		this.turnPlayer1 = !this.turnPlayer1 ;
		this.choicePlayeurStrings.set(7, (this.turnPlayer1 ? "x" : "o"));
	}
	
	@FXML
	void onClickButton22()
	{
		this.Button22.setDisable(true);
		this.Button22.setImage((turnPlayer1 ? cercle : croix)) ;
		this.turnPlayer1 = !this.turnPlayer1 ;
		this.choicePlayeurStrings.set(8, (this.turnPlayer1 ? "x" : "o"));
	}
	
}
