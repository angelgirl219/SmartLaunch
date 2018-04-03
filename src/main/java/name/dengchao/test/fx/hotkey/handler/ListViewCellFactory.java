package name.dengchao.test.fx.hotkey.handler;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import name.dengchao.test.fx.plugin.Plugin;

public class ListViewCellFactory extends ListCell<Plugin> {

    @Override
    protected void updateItem(Plugin item, boolean empty) {
        super.updateItem(item, empty);
        setPrefHeight(55.0);
        setPadding(new Insets(0, 0, 0, 17));
        if (empty) {
            setGraphic(null);
        } else {
            HBox vBox = new HBox();

            Text name = new Text();
            Text desc = new Text();

            if (vBox.getChildren().size() == 0) {
                vBox.getChildren().add(desc);
                vBox.getChildren().add(name);
                vBox.setAlignment(Pos.CENTER_LEFT);
            }

            desc.setFont(Font.font("Courier New", 22));
            name.setFont(Font.font("Courier New", 17));

            desc.setText(item.getDescription());
            name.setText("『" + item.getName() + "』");

            setGraphic(vBox);
        }
    }


}
