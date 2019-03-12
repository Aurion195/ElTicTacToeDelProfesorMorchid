package View;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXToggleButton;

import Game.Launcher;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class ToolViewController extends ToolsBarController  implements Initializable
{

	@FXML JFXSlider volume;
	@FXML JFXToggleButton toggleButton ;

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
		try {
		
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		Launcher main = Launcher.getInstance();
		
		
		toggleButton.setOnAction(event -> {
            
            if(toggleButton.isSelected()){
            	main.getMedia().play() ;
            }
            else{
            	main.getMedia().pause() ;
            }
        });

		volume.setValue(main.getMedia().getVolume()*80);
		volume.valueProperty().addListener(new InvalidationListener() {
		
			@Override
			public void invalidated(Observable observable) {


				Launcher main = Launcher.getInstance();
				try {
					main.getMedia().setVolume(volume.getValue()/100);
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			
			
			}
		});


	}



}
