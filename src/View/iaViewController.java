package View;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.*;

import IA.IA;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class iaViewController extends ToolsBarController
{

	@FXML private JFXButton apprentissage ;
	@FXML private JFXProgressBar progress ;
	@FXML private Label pourcent ;
	
	@FXML
	public void lancerApprentissage()
	{
		this.apprentissage.setVisible(false);
		this.progress.setVisible(true);
		this.pourcent.setVisible(true);
		
		IA ia = new IA() ;
		ia.apprentissageIA("/home/nas02a/etudiants/inf/uapv1703778/eclipse-workspace/ElTicTacToeDelProfesorMorchid/src/IA/train.txt");
	}
}
