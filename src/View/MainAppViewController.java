package View;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


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
	
	private boolean turnPlayer1 = false ;
	private Vector<Boolean> casePlayed = new Vector<Boolean>();
	
	public MainAppViewController() 
	{
		for(int i = 0 ; i < 9 ; i++)
		{
			this.casePlayed.add(true) ;
		}
	}

	@FXML
	void onClickListener()
    {
		if(this.Button00.isPressed() && this.casePlayed.elementAt(0))
		{
			this.Button00.setImage((turnPlayer1 ? cercle : croix)) ;
			this.turnPlayer1 = !this.turnPlayer1 ;
			this.casePlayed.removeElementAt(0);
			this.casePlayed.insertElementAt(false, 0);
		}
		else if(this.Button01.isPressed() && this.casePlayed.elementAt(1))
		{
			this.Button01.setImage((turnPlayer1 ? cercle : croix)) ;
			this.turnPlayer1 = !this.turnPlayer1 ;
			this.casePlayed.removeElementAt(1);
			this.casePlayed.insertElementAt(false, 1);
		}
		else if(this.Button02.isPressed() && this.casePlayed.elementAt(2))
		{
			this.Button02.setImage((turnPlayer1 ? cercle : croix)) ;
			this.turnPlayer1 = !this.turnPlayer1 ;
			this.casePlayed.removeElementAt(2);
			this.casePlayed.insertElementAt(false, 2);
		}
		else if(this.Button10.isPressed() && this.casePlayed.elementAt(3))
		{
			this.Button10.setImage((turnPlayer1 ? cercle : croix)) ;
			this.turnPlayer1 = !this.turnPlayer1 ;
			this.casePlayed.removeElementAt(3);
			this.casePlayed.insertElementAt(false, 3);
		}
		else if(this.Button11.isPressed() && this.casePlayed.elementAt(4))
		{
			this.Button11.setImage((turnPlayer1 ? cercle : croix)) ;
			this.turnPlayer1 = !this.turnPlayer1 ;
			this.casePlayed.removeElementAt(4);
			this.casePlayed.insertElementAt(false, 4);
		}
		else if(this.Button12.isPressed() && this.casePlayed.elementAt(5))
		{
			this.Button12.setImage((turnPlayer1 ? cercle : croix)) ;
			this.turnPlayer1 = !this.turnPlayer1 ;
			this.casePlayed.removeElementAt(5);
			this.casePlayed.insertElementAt(false, 5);
		}
		else if(this.Button20.isPressed() && this.casePlayed.elementAt(6))
		{
			this.Button20.setImage((turnPlayer1 ? cercle : croix)) ;
			this.turnPlayer1 = !this.turnPlayer1 ;
			this.casePlayed.removeElementAt(6);
			this.casePlayed.insertElementAt(false, 6);
		}
		else if(this.Button21.isPressed() && this.casePlayed.elementAt(7))
		{
			this.Button21.setImage((turnPlayer1 ? cercle : croix)) ;
			this.turnPlayer1 = !this.turnPlayer1 ;
			this.casePlayed.removeElementAt(7);
			this.casePlayed.insertElementAt(false, 7);
		}
		else if(this.Button22.isPressed() && this.casePlayed.elementAt(8))
		{
			this.Button22.setImage((turnPlayer1 ? cercle : croix)) ;
			this.turnPlayer1 = !this.turnPlayer1 ;
			this.casePlayed.removeElementAt(8);
			this.casePlayed.insertElementAt(false, 8);
		}
    }
}
