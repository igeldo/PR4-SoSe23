import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Starter extends Application {
    Model m;
    //View  v;
    Controller c;

    public void start(Stage primaryStage) throws Exception {
        m = new Model();
        //v = new View(primaryStage,m);  nicht sinnvoll, da der view durch FXML dargestellt wird
        Parent ViewFXML = FXMLLoader.load(getClass().getResource("Scene.fxml"));
        Scene scene = new Scene(ViewFXML);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.setTitle("Calculator");
        primaryStage.show();
        // c = new Controller(m);  nicht möglich - Der Controller wird durch FXML erzeugt
        // stattdessen die Controller-Instanz holen und den Model-Verweis per setter() setzen
        FXMLLoader loader= new FXMLLoader(getClass().getResource("Scene.fxml"));
        ViewFXML = loader.load();    // zuerst laden
        c = loader.getController();  // dann Controller-Instanz holen
        c.setM(m);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
