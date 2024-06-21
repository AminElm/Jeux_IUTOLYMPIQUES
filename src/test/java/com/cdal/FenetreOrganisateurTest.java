package test.java.com.cdal;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import main.java.com.cdal.FenetreOrganisateur;
import main.java.com.cdal.Main;
import main.java.com.cdal.Athlete;
import main.java.com.cdal.Epreuve;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.jupiter.api.Assertions.*;

class FenetreOrganisateurTest extends ApplicationTest {

    private FenetreOrganisateur fenetreOrganisateur;
    private Main app;

    @Override
    public void start(Stage stage) {
        app = new Main();
        fenetreOrganisateur = new FenetreOrganisateur(app);
        Scene scene = new Scene(fenetreOrganisateur, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    @BeforeEach
    void setUp() {
        // Setup can be done in the start method for JavaFX application context
    }

    @Test
    void testInitialisation() {
        assertNotNull(fenetreOrganisateur);
        assertNotNull(fenetreOrganisateur.getApplication());
    }

    @Test
    void testComboBoxEpreuve() {
        ComboBox<Epreuve> comboBoxEpreuve = lookup("#comboBoxEpreuve").query();
        assertNotNull(comboBoxEpreuve);

        // Simulate selecting an item
        clickOn(comboBoxEpreuve).clickOn("100m Sprint");

        // Verify the selected item
        assertEquals("100m Sprint", comboBoxEpreuve.getValue().getNom());
    }

    @Test
    void testComboBoxSport() {
        ComboBox<String> comboBoxSport = lookup("#comboBoxSport").query();
        assertNotNull(comboBoxSport);

        // Simulate selecting an item
        clickOn(comboBoxSport).clickOn("Athlétisme");

        // Verify the selected item
        assertEquals("Athlétisme", comboBoxSport.getValue());
    }

    @Test
    void testBoutonLancerEpreuve() {
        Button boutonLancerEpreuve = lookup("#boutonLancerEpreuve").queryButton();
        assertNotNull(boutonLancerEpreuve);

        // Simulate clicking the button
        clickOn(boutonLancerEpreuve);

        // Verify the action
        // Example:
        // verifyThat(".alert", isVisible());
    }

    @Test
    void testBoutonEnregistrer() {
        Button boutonEnregistrer = lookup("#boutonEnregistrer").queryButton();
        assertNotNull(boutonEnregistrer);

        // Simulate clicking the button
        clickOn(boutonEnregistrer);

        // Verify the action
        // Example:
        // verifyThat(".alert", isVisible());
    }

    @Test
    void testTableView() {
        TableView<Athlete> tableAthlete = lookup("#tableAthlete").query();
        assertNotNull(tableAthlete);

        // Verify the table columns
        assertEquals(5, tableAthlete.getColumns().size());
        assertEquals("Pays", tableAthlete.getColumns().get(0).getText());
        assertEquals("Nom", tableAthlete.getColumns().get(1).getText());
        assertEquals("Prénom", tableAthlete.getColumns().get(2).getText());
        assertEquals("Score", tableAthlete.getColumns().get(3).getText());
        assertEquals("Place", tableAthlete.getColumns().get(4).getText());
    }

    @Test
    void testBoutonInfo() {
        Button boutonInfo = lookup("#boutonInfo").queryButton();
        assertNotNull(boutonInfo);

        // Simulate clicking the button
        clickOn(boutonInfo);
    }
}
