package application;
	
import java.io.IOException;
import java.util.ResourceBundle;

import bash_prompt_gen.BashPromptGeneratorController;
import bash_prompt_gen.BashPromptGeneratorManager;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {

	@Override
	public void start(Stage stage) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../bash_prompt_gen/BashPromptGenerator.fxml"),
				ResourceBundle.getBundle("resources.BashPromptGenerator"));
		
		Parent root = loader.load();
		
		final BashPromptGeneratorController controller = (BashPromptGeneratorController) loader.getController();
		controller.init();			
		
		Scene scene = new Scene(root, 600, 650);
		
        
        stage.setTitle("FX Bash prompt generator");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        
        
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
