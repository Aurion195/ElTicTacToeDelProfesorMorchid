package View;

import org.omg.CORBA.PUBLIC_MEMBER;

import Game.Launcher;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

public class SoloViewController extends ToolsBarController
{
	private TextField namePlayer ;
	
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
}
