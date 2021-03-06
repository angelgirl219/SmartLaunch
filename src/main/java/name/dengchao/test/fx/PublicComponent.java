package name.dengchao.test.fx;

import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import name.dengchao.test.fx.plugin.Plugin;


public class PublicComponent {

    private static TextField textField;
    private static TextField shade;
    private static Stage primaryStage;
    private static ListView<Plugin> listView;

    public static TextField getTextField() {
        return textField;
    }

    public static void setTextField(TextField textField) {
        PublicComponent.textField = textField;
    }

    public static TextField getShade() {
        return shade;
    }

    public static void setShade(TextField shade) {
        PublicComponent.shade = shade;
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void setPrimaryStage(Stage primaryStage) {
        PublicComponent.primaryStage = primaryStage;
    }

    public static ListView<Plugin> getListView() {
        return listView;
    }

    public static void setListView(ListView<Plugin> listView) {
        PublicComponent.listView = listView;
    }
}
