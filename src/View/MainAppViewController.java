package View;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class MainAppViewController
{
	@FXML
    private ImageView Button00;

	Image image = new Image("Images/perfect-circle_icon-icons.com_53928.png") ;
	
	@FXML
	void touch()
    {
		Button00.setImage(image);
		System.out.println("nrjgrer");
		
		
    }
}
