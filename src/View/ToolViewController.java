package View;

import java.net.URL;
import java.util.ResourceBundle;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXToggleButton;

import Game.Launcher;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;

/**
 * Classe permettant de gérer les options du jeu
 * @author MATHIEU Thomas
 * @author GARCIA Jérémy
 *
 */
public class ToolViewController extends ToolsBarController  implements Initializable
{
	/**
	 * Barre de volume que l'utilisateur pourra modifier
	 */
	@FXML JFXSlider volume;
	
	/**
	 * Button permettant activer / desactiver la musique
	 */
	@FXML JFXToggleButton toggleButton ;
	
	/**
	 * RadioButton pour l'IA facile
	 */
	@FXML RadioButton easy ;
	
	/**
	 * radioButton pour l'IA moyen
	 */
	@FXML RadioButton medium ;
	
	/**
	 * RadioButton pour l'IA Hard
	 */
	@FXML RadioButton hard ;
	
	/**
	 * Button pour sauvegarder les options
	 */
	@FXML JFXButton save ;
	
	/**
	 * Button pour enrainer l'IA
	 */
	@FXML JFXButton learn ;
	
	
	/**
	 * Quand l'utilisateur va cliquer sur ce button, le système va quitter le jeu
	 */
	@FXML
	public void onClickQuitButton()
	{
		super.onClickQuitButton();
	}
	
	/**
	 * Quand l'utilisateur va cliquer sur ce button, le système va le renvoyer sur le menu principal
	 */
	@FXML
	public void onClickHomeButton()
	{
		super.onClickHomeButton();
	}
	

	/**
	 * Permet de charger le fichier sauvegarde "Config.xml" qui connait toutes les otpions, cette function va
	 * donc modifier les valeurs définis par défault afin qu'elle coincide avec celle écrit dans le fichier
	 */
	private void uploadSave()
	{
		try {
			int musicOn, soundMusic, easy, medium, hard ;
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse("config.xml");

			musicOn = Integer.parseInt(doc.getElementsByTagName("Music").item(0).getTextContent()) ;
			soundMusic = Math.round(Integer.parseInt(doc.getElementsByTagName("Sound").item(0).getTextContent())) ;
			easy = Integer.parseInt(doc.getElementsByTagName("Facile").item(0).getTextContent()) ;
			medium = Integer.parseInt(doc.getElementsByTagName("Medium").item(0).getTextContent()) ;
			hard = Integer.parseInt(doc.getElementsByTagName("Hard").item(0).getTextContent()) ;

			this.toggleButton.setSelected((musicOn == 0 ? false : true));
			this.volume.setValue(soundMusic) ;
			this.easy.setSelected((easy == 1 ? true : false));
			this.medium.setSelected((medium == 1 ? true : false));
			this.hard.setSelected((hard == 1 ? true : false));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Quand on va aller dans cette vue pour la 1er fois, elle va permettre de gérer le chargement du fichier
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		Launcher main = Launcher.getInstance();
		
		
		this.toggleButton.setOnAction(event -> {
            
            if(this.toggleButton.isSelected()){
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
		
		this.uploadSave() ;
	}

	/**
	 * Quand l'utilisateur clique sur le button Apprentissage, le système va changer de view afin que l'utilisateur
	 * puisse voir l'entrainement et la sauvegarde de l'IA
	 */
	@FXML
	public void learnIA()
	{
		Launcher main = Launcher.getInstance();
		FXMLLoader loader = new FXMLLoader();
		
		try {
			loader.setLocation(getClass().getResource("Ia.fxml"));
			main.setRootLayout(loader.load());

			Scene scene = new Scene(main.getRootLayout());
			main.getPrimaryStage().setScene(scene);
			main.getPrimaryStage().show();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			
		}
	}
	
	/**
	 * Quand l'utilisateur va cliquer sur le button Sauvegarder, le système va récuper les données modifier et l'envoyer dans la fonction
	 * save()
	 */
	@FXML
	public void saveOption()
	{
		System.out.println("Sauvegarde");
		String musicOn = (this.toggleButton.isSelected() ? "1" : "0") ;
		String soundMusic = String.valueOf(Math.round(this.volume.getValue())) ;
		String IAEasy = (this.easy.isSelected() ? "1" : "0") ;
		String IAMedium = (this.medium.isSelected() ? "1" : "0") ;
		String IAHard = (this.hard.isSelected() ? "1" : "0") ;
		
		this.save(musicOn, soundMusic, IAEasy, IAMedium, IAHard) ;
	}
	
	/**
	 * Permet de sauvegarder les données modifier par l'utilisateur
	 * @param musicOn = 1 (on) / 0 (off) ;
	 * @param soundMusic = son music ;
	 * @param IAEasy = 1 (selected) / 0 (non selected) ;
	 * @param IAMedium = 1 (selected) / 0 (non selected) ;
	 * @param IAHard = 1 (selected) / 0 (non selected) ;
	 */
	private void save(String musicOn, String soundMusic, String IAEasy, String IAMedium, String IAHard)
	{
		try {
			
			final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			final DocumentBuilder builder = factory.newDocumentBuilder();
			final Document document= builder.newDocument();
			final Element racine = document.createElement("Config");
			document.appendChild(racine);



			final Element config = document.createElement("Config");
			racine.appendChild(config) ;

			final Element r = document.createElement("Music");
			r.appendChild(document.createTextNode(musicOn));

			final Element b = document.createElement("Sound");
			b.appendChild(document.createTextNode(soundMusic));
			
			final Element tb = document.createElement("Facile");
			tb.appendChild(document.createTextNode(IAEasy));
			
			final Element tb1 = document.createElement("Medium");
			tb1.appendChild(document.createTextNode(IAMedium)) ;
			
			final Element tb2 = document.createElement("Hard");
			tb2.appendChild(document.createTextNode(IAHard));

			config.appendChild(r);
			config.appendChild(b);
			config.appendChild(tb);
			config.appendChild(tb1);
			config.appendChild(tb2);
			
			final TransformerFactory transformerFactory = TransformerFactory.newInstance();
			final Transformer transformer = transformerFactory.newTransformer();
			final DOMSource source = new DOMSource(document);
			final StreamResult sortie = new StreamResult("config.xml");


			transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");

			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

			transformer.transform(source, sortie);
			System.out.println("On sauvegarde bien");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Quand l'utilisateur va cliquer le radioButton "Easy", il va déselectionner les 2 autres
	 */
	@FXML
	public void onClickEasyButton()
	{
		this.easy.setSelected(true);
		this.medium.setSelected(false);
		this.hard.setSelected(false);
	}
	
	/**
	 * Quand l'utilisateur va cliquer le radioButton "Medium", il va déselectionner les 2 autres
	 */
	@FXML
	public void onClickMediumButton()
	{
		this.easy.setSelected(false);
		this.medium.setSelected(true);
		this.hard.setSelected(false);
	}
	
	/**
	 * Quand l'utilisateur va cliquer le radioButton "Hard", il va déselectionner les 2 autres
	 */
	@FXML
	public void onClickHardButton()
	{
		this.easy.setSelected(false);
		this.medium.setSelected(false);
		this.hard.setSelected(true);
	}
	
}
