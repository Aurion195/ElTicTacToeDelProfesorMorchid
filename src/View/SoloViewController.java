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

public class SoloViewController extends ToolsBarController
{
	@FXML
	private JFXTextField namePlayer ;
	
	@FXML
	private JFXButton ButtonGo ;
	
	@FXML
	public void onClickHomeButton()
	{
		super.onClickHomeButton();
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
	public void onClickGetMatch()
	{
		Launcher launcher = Launcher.getInstance() ;
		launcher.setPlayerName00(this.namePlayer.getText());
		System.out.println(launcher.getPlayer00Name());
		launcher.setPLayerName01("Mr Morchid");
		
		Launcher main = Launcher.getInstance();
    	FXMLLoader loader = new FXMLLoader();
    	try {
    		loader.setLocation(getClass().getResource("MultiView.fxml"));
    		main.setRootLayout(loader.load());

    		Scene scene = new Scene(main.getRootLayout());
    		main.getPrimaryStage().setScene(scene);
    		main.getPrimaryStage().show();
    	} 
    	catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
