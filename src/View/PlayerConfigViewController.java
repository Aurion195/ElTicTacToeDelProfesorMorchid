package View;

import javafx.fxml.FXML;

import com.jfoenix.controls.JFXTextField;

import Game.Launcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;

/**
 * Classe permettant de gérer le choix des pseudo
 * @author MATHIEU Thomas
 * @author GARCIA Jérémy
 *
 */
public class PlayerConfigViewController extends ToolsBarController 
{
	/**
	 * Text pour le joueur 0
	 */
	@FXML private JFXTextField Pseudo00 ;
	
	/**
	 * Text pour le joueur 1
	 */
	@FXML private JFXTextField Pseudo01 ;
	
	/**
	 * Quand l'utilisateur va cliquer sur ce button, le système va quitter le jeu
	 */
	@FXML
	public void onClickQuitButton()
	{
		super.onClickQuitButton();
	}
	
	/**
	 * Quand l'utilisateur va cliquer sur ce button, le système va le renvoyer sur le menu principal
	 */
	@FXML
	public void onClickHomeButton()
	{
		super.onClickHomeButton();
	}
	
	/**
	 * Quand l'utilisateur va cliquer sur ce button, le système va l'envoyer dans les options
	 */
	@FXML
	public void onClickSettingButton()
	{
		super.onClickSettingButton();
	}
	
	/**
	 * Fonction permettant de vérifier que les 2 joueur n'ont pas le même pseudo
	 * @return true / false ;
	 */
	private boolean verfiPseudo()
	{
		if(!this.Pseudo00.getText().isEmpty() && !this.Pseudo01.getText().isEmpty())
		{
			if(!this.Pseudo00.getText().equals(this.Pseudo01.getText()))
			{
				return true ;
			}
		}
		
		return false ;
	}
	
	/**
	 * Permet au singleton "Main" de gérer les pseudo choisit et de les changer dans les joueurs
	 */
	private void envoiPlayer()
	{
		Launcher main = Launcher.getInstance();
		main.setPlayerName00(this.Pseudo00.getText());
		main.setPLayerName01(this.Pseudo01.getText());
	}
	
	/**
	 * Quand l'utilisateur va cliquer sur ce button, le système va effectuer une vérification avec this.verifPseudo()
	 * si tout est bon, on change de view et on commence le jeu
	 */
	@FXML
	public void onClickGoButton()
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Erreur !");

		if(this.verfiPseudo())
		{
			this.envoiPlayer() ;
			Launcher main = Launcher.getInstance();
			FXMLLoader loader = new FXMLLoader();
			try {
				loader.setLocation(getClass().getResource("MultiView.fxml"));
				main.setRootLayout(loader.load());

				Scene scene = new Scene(main.getRootLayout());
				main.getPrimaryStage().setScene(scene);
				main.getPrimaryStage().show();
			} 
			catch (Exception e) 
			{
				System.out.println(e.getMessage());
			}
		}
		else 
		{
			alert.setContentText("Vous n'avez pas renseigné les pseudo");
			alert.showAndWait();
		}
	}
}
