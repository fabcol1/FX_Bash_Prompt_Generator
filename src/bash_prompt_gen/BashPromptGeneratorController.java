package bash_prompt_gen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.TextFlow;

public class BashPromptGeneratorController {

	
	@FXML private TextFlow previewTextFlow;
	
	@FXML protected void handleColorPickerPreview(ActionEvent event) {
		MANAGER.changeTextAreaInnerColor(previewTextFlow, event);
	}

	private static final BashPromptGeneratorManager MANAGER = new BashPromptGeneratorManager();

}
