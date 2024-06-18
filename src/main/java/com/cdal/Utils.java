package main.java.com.cdal;

import javafx.scene.Cursor;

public class Utils {

    // Méthode statique pour changer le curseur
    public static void setCursorOnHover(javafx.scene.Node node, Cursor cursor) {
        node.setOnMouseEntered(event -> node.setCursor(cursor));
    }
}
