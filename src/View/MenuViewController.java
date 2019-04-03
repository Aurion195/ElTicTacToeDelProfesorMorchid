package View;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

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

/**
 * Classe permettant de gérer le menu de l'application
 * @author MATHIEU Thomas
 * @author GARCIA Jérémy
 *
 */
public class MenuViewController extends ToolsBarController
{
	/**
	 * Permet de changer de vue
	 * @param view = nouvemme vue que l'on veut ;
	 */
	private void changeView(String view) 
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

	/**
	 * Quand l'utilisaeur voudra jouer sur l'IA, il va cliquer sur le button 
	 * "Solo"
	 */
	@FXML
	void onClickSoloButton()
	{
		String a ;
		
		try {
			int easy, moyen, hard ;
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse("config.xml");
			
			easy = Integer.parseInt(doc.getElementsByTagName("Facile").item(0).getTextContent()) ;
			moyen = Integer.parseInt(doc.getElementsByTagName("Medium").item(0).getTextContent()) ;
			hard = Integer.parseInt(doc.getElementsByTagName("Hard").item(0).getTextContent()) ;
			
			a = (easy == 1 ? "Easy" : moyen == 1 ? "Moyen" : "Hard") ;
			
			File f = new File("src/Sauvegarde/"+a);
			
			if(f.exists())
			{
				this.changeView("SoloView.fxml");
			}
			else
			{
				this.changeView("Ia.fxml");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Quand l'utilisateur voudra jouer contre un ami à lui, il cliquera sur le button 
	 * "Multi"
	 */
	@FXML
	void onClickMultiButton()
	{
		this.changeView("PlayerConfigView.fxml");
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
