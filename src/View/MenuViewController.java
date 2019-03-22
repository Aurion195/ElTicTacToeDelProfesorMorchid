package View;

import Game.Launcher;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import sun.launcher.resources.launcher;

public class MenuViewController extends ToolsBarController
{
	private void makeOnFadeOut(String view) 
	{
		Launcher main = Launcher.getInstance();
		FXMLLoader loader = new FXMLLoader();
		try {
			loader.setLocation(getClass().getResource(view));
			main.setRootLayout(loader.load());

			Scene scene = new Scene(main.getRootLayout());
			main.getPrimaryStage().setScene(scene);
			main.getPrimaryStage().show();
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@FXML
	void onClickSoloButton()
	{
		this.makeOnFadeOut("SoloView.fxml");
	}
	
	@FXML
	void onClickMultiButton()
	{
		this.makeOnFadeOut("PlayerConfigView.fxml");
	}
	
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
	public void onClickToolButton()
	{
		super.onClickSettingButton();
	}
}
