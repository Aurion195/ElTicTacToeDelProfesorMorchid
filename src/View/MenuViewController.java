package View;

import Game.Launcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;

public class MenuViewController extends ToolsBarController
{
	
	@FXML
	void onClickSoloButton()
	{
		Launcher main = Launcher.getInstance();
    	FXMLLoader loader = new FXMLLoader();
    	try {
    		loader.setLocation(getClass().getResource("SoloView.fxml"));
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
	void onClickMultiButton()
	{
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
