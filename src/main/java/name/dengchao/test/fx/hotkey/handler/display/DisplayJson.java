package name.dengchao.test.fx.hotkey.handler.display;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.scene.control.TextField;
import org.apache.commons.io.IOUtils;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class DisplayJson implements DisplayResult {

    private static TextField textField = new TextField();

    static {
        textField.setLayoutY(55);
        textField.setLayoutX(3);
        textField.setMaxWidth(594);
        textField.setPrefWidth(594);
        textField.setVisible(false);
    }

    @Override
    public void display(InputStream inputStream) {
        try {
            String content = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
            ObjectMapper mapper = new ObjectMapper();
            Object json = mapper.readValue(content, Object.class);
            String indented = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
            textField.setText(indented);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
    }
}
