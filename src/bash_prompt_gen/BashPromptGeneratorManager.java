package bash_prompt_gen;

import javafx.event.ActionEvent;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import javafx.scene.text.TextFlow;

public class BashPromptGeneratorManager {
	
//	style="-fx-control-inner-background:#000000; -fx-font-family: Consolas; -fx-highlight-fill: #00ff00; -fx-highlight-text-fill: #000000; -fx-text-fill: #00ff00; "
	    
	/**
	 * Change TextFlow inner background color
	 */
    public void changeTextAreaInnerColor(TextFlow area, ActionEvent event) {
    	event.consume();
    	final Color c = ( (ColorPicker) event.getSource()).getValue();
		area.setStyle("-fx-background-color:" + colorToStringValue(c));
    }
    
    /**
     * Return #RRGGBB format like String created from parameter Color
    */
    private String colorToStringValue(Color c) {
        int r = (int) (255 * c.getRed());
        int g = (int) (255 * c.getGreen());
        int b = (int) (255 * c.getBlue());
        return String.format("#%02x%02x%02x", r, g, b);
    }
    
}
