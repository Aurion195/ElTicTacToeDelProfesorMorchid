package View;

import Game.Launcher;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

public class SoloViewController 
{
	private TextField namePlayer ;
	
	@FXML
	void onClickHomeButton()
	{
		Launcher main = Launcher.getInstance();
    	FXMLLoader loader = new FXMLLoader();
    	try {
    		loader.setLocation(getClass().getResource("MenuView.fxml"));
    		//loader.setLocation(getClass().getResource("winner.fxml"));
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
