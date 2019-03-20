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

public class PlayerConfigViewController extends ToolsBarController 
{
	
	@FXML private JFXTextField Pseudo00 ;
	@FXML private JFXTextField Pseudo01 ;
	
	@FXML
	public void onClickQuitButton()
	{
		super.onClickQuitButton();
	}
	
	@FXML
	public void onClickHomeButton()
	{
		super.onClickHomeButton();
	}
	
	@FXML
	public void onClickSettingButton()
	{
		super.onClickSettingButton();
	}
	
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
	
	private void envoiPlayer()
	{
		Launcher main = Launcher.getInstance();
		main.setPlayerName00(this.Pseudo00.getText());
		main.setPLayerName01(this.Pseudo01.getText());
	}
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
