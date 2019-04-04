package View;

import java.awt.Button;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import Game.Launcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

/**
 * Classe permettant de gérer le pseudo d'un joueur en mode HumainVSIa
 * @author MATHIEU Thomas
 * @author GARCIA Jérémy
 *
 */
public class SoloViewController extends ToolsBarController
{
	/**
	 * Text pour le joueur 1
	 */
	@FXML
	private JFXTextField namePlayer ;
	
	/**
	 * Button go
	 */
	@FXML
	private JFXButton ButtonGo ;
	
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
	 * Envoi les nom des joueurs dans le singleton "Main", puis change la vue pour aller dans la vue
	 * HumainVsia
	 */
	@FXML
	public void onClickGetMatch()
	{
		Launcher launcher = Launcher.getInstance() ;
		launcher.setPlayerName00(this.namePlayer.getText());
		launcher.setPLayerName01("Mr Morchid");
		
		Launcher main = Launcher.getInstance();
    	FXMLLoader loader = new FXMLLoader();
    	try {
    		loader.setLocation(getClass().getResource("IAView.fxml"));
    		main.setRootLayout(loader.load());

    		Scene scene = new Scene(main.getRootLayout());
    		main.getPrimaryStage().setScene(scene);
    		main.getPrimaryStage().show();
    	} 
    	catch (Exception e) {
			e.printStackTrace();
		}
	}
}
