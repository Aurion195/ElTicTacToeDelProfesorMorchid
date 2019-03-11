package View;

import com.jfoenix.controls.JFXToggleButton;

import Game.Launcher;
import javafx.fxml.FXML;

public class ToolViewController extends ToolsBarController
{
	
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
	public void onClickStopMusicButton()
	{
		Launcher main = Launcher.getInstance();
		main.stopMusic(main.getMedia());
		
	}
	
	
	
	
}
