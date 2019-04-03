package View;

import java.net.URL;
import java.util.ResourceBundle;

import Game.Launcher;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public abstract class ToolsBarController 
{
	@FXML
	protected void onClickHomeButton()
	{
		Launcher main = Launcher.getInstance();
		FXMLLoader loader = new FXMLLoader();
		try {
			loader.setLocation(getClass().getResource("MenuView.fxml"));
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
	
	@FXML
	protected void onClickQuitButton()
	{
		System.exit(0);
	}
	
	@FXML
	protected void onClickSettingButton()
	{
		Launcher main = Launcher.getInstance();
		FXMLLoader loader = new FXMLLoader();
		try {
			loader.setLocation(getClass().getResource("ToolView.fxml"));
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
}
