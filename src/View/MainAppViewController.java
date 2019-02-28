package View;

import java.util.Vector;

import Game.Game;
import javafx.fxml.FXML;
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
	void onClickListener()
    {
		if(this.Button00.isPressed() && this.casePlayed.elementAt(0))
		{
			this.Button00.setImage((turnPlayer1 ? cercle : croix)) ;
			this.choicePlayeurStrings.set(0, (this.turnPlayer1 ? "x" : "o"));
			this.turnPlayer1 = !this.turnPlayer1 ;
			this.casePlayed.set(0, false) ;
		}
		else if(this.Button01.isPressed() && this.casePlayed.elementAt(1))
		{
			this.Button01.setImage((turnPlayer1 ? cercle : croix)) ;
			this.choicePlayeurStrings.set(1, (this.turnPlayer1 ? "x" : "o"));
			this.turnPlayer1 = !this.turnPlayer1 ;
			this.casePlayed.set(1, false) ;
		}
		else if(this.Button02.isPressed() && this.casePlayed.elementAt(2))
		{
			this.Button02.setImage((turnPlayer1 ? cercle : croix)) ;
			this.choicePlayeurStrings.set(2, (this.turnPlayer1 ? "x" : "o"));
			this.turnPlayer1 = !this.turnPlayer1 ;
			this.casePlayed.set(2, false) ;
		}
		else if(this.Button10.isPressed() && this.casePlayed.elementAt(3))
		{
			this.Button10.setImage((turnPlayer1 ? cercle : croix)) ;
			this.choicePlayeurStrings.set(3, (this.turnPlayer1 ? "x" : "o"));
			this.turnPlayer1 = !this.turnPlayer1 ;
			this.casePlayed.set(3, false) ;
		}
		else if(this.Button11.isPressed() && this.casePlayed.elementAt(4))
		{
			this.Button11.setImage((turnPlayer1 ? cercle : croix)) ;
			this.choicePlayeurStrings.set(4, (this.turnPlayer1 ? "x" : "o"));
			this.turnPlayer1 = !this.turnPlayer1 ;
			this.casePlayed.set(4, false) ;
		}
		else if(this.Button12.isPressed() && this.casePlayed.elementAt(5))
		{
			this.Button12.setImage((turnPlayer1 ? cercle : croix)) ;
			this.choicePlayeurStrings.set(5, (this.turnPlayer1 ? "x" : "o"));
			this.turnPlayer1 = !this.turnPlayer1 ;
			this.casePlayed.set(5, false) ;
		}
		else if(this.Button20.isPressed() && this.casePlayed.elementAt(6))
		{
			this.Button20.setImage((turnPlayer1 ? cercle : croix)) ;
			this.choicePlayeurStrings.set(6, (this.turnPlayer1 ? "x" : "o"));
			this.turnPlayer1 = !this.turnPlayer1 ;
			this.casePlayed.set(6, false) ;
		}
		else if(this.Button21.isPressed() && this.casePlayed.elementAt(7))
		{
			this.Button21.setImage((turnPlayer1 ? cercle : croix)) ;
			this.choicePlayeurStrings.set(7, (this.turnPlayer1 ? "x" : "o"));
			this.turnPlayer1 = !this.turnPlayer1 ;
			this.casePlayed.set(7, false) ;
		}
		else if(this.Button22.isPressed() && this.casePlayed.elementAt(8))
		{
			this.Button22.setImage((turnPlayer1 ? cercle : croix)) ;
			this.choicePlayeurStrings.set(8, (this.turnPlayer1 ? "x" : "o"));
			this.turnPlayer1 = !this.turnPlayer1 ;
			this.casePlayed.set(8, false) ;
		}
		
		if(this.game.win(this.choicePlayeurStrings))
		{
			System.out.println("Ta grosse mere a gagner");	
			
			//On se casse vers une autre view
		}
    }
}
