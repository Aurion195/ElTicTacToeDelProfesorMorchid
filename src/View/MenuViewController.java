package View;

import Game.Launcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;

public class MenuViewController 
{
	@FXML ImageView ButtonHome ;
	
	@FXML
	void onClickSoloButton(ActionEvent actionEvent)
	{
		Launcher main = Launcher.getInstance();
    	FXMLLoader loader = new FXMLLoader();
    	try {
    		loader.setLocation(getClass().getResource("MainAppView.fxml"));
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
	
	@FXML
	void onClickHomeButton()
	{
		System.out.println("erhrereahreghr");
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
