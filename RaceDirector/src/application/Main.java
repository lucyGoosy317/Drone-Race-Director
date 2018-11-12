package application;

/**
 * @author Luziano Reyna/vtk064
 * @author add your names here
 * 
 * 
 * Tasks:
 * (task will be removed once completed, ill be working top-down till finished, please alert me if you are working on 
 * anything via chat)
 * 
 * TODO: Java Doc, video, grade rubric stuff
 * 
 * 
 */
	
import javafx.application.Application;





import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {
	public static Stage stage;

	@Override
	public void start(Stage primaryStage) {
		stage = primaryStage;

		try {
			Parent root = FXMLLoader.load(getClass().getResource("view/MenuStart.fxml"));
			primaryStage.setScene(new Scene(root, 600, 600));
			Main.stage.setResizable(false);
			stage.setTitle("Race Start Menu");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param args will take in array of strings
	 */
	public static void main(String[] args) {
		launch(args);
	}
}