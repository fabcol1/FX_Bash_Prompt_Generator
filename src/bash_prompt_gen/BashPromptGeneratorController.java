package bash_prompt_gen;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextFlow;

public class BashPromptGeneratorController {

	private final BashPromptGeneratorManager manager = null;
	
	@FXML public TextFlow previewTextFlow;
	@FXML public ComboBox<String> fontComboBox;
	
	@FXML protected void handleColorPickerPreview(ActionEvent event) {
		if(manager == null) return;
		manager.changeTextAreaInnerColor(previewTextFlow, event);
	}

	public void init() {
        List<String> families = Font.getFamilies();
        fontComboBox.setItems(FXCollections.observableList(families));		
	}
	
}
