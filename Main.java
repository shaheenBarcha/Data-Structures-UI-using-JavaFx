package DSProject;
/*package DSlabProject;*/

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
Stage stage;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		stage=primaryStage;
		stage.setTitle("DATA STRUCTURES");
		stage.setHeight(500);
		stage.setWidth(700);
		stage.setResizable(true);
		SceneGraph();
		stage.show();
	}

	private void SceneGraph() {
		Text text = new Text("DATA STRUCTURES");
		text.setFont(Font.font("verdana",FontWeight.BOLD,FontPosture.ITALIC,60));
		text.setFill(Color.DEEPPINK);
		Label l = new Label("Choose Algorithm");
		l.setFont(Font.font("verdana",FontWeight.BOLD,40));
		l.setTextFill(Color.BLUEVIOLET);
		RadioButton stack = new RadioButton("STACK");
		stack.setFont(Font.font("verdana",FontWeight.BOLD,30));
		stack.setTextFill(Color.BLACK);
		RadioButton queue = new RadioButton("QUEUE");
		queue.setFont(Font.font("verdana",FontWeight.BOLD,30));
		queue.setTextFill(Color.BLACK);
		RadioButton llist = new RadioButton("LINKED LIST");
		llist.setFont(Font.font("verdana",FontWeight.BOLD,30));
		llist.setTextFill(Color.BLACK);
		llist.setAlignment(Pos.CENTER);
		ToggleGroup tb = new ToggleGroup();
		stack.setToggleGroup(tb);
		queue.setToggleGroup(tb);
		llist.setToggleGroup(tb);
		
		
     stack.setOnAction(new EventHandler<ActionEvent>() {

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		StackGui stak= new StackGui();
		
		stage.close();
     	}
   });
     queue.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			QueueGui que= new QueueGui();
			
			stage.close(); 
		}
	});	
     llist.setOnAction(new EventHandler<ActionEvent>() {
		
		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			LinkedListGui llg =new LinkedListGui();
			
			stage.close();  
		}
	});
	VBox v = new VBox(text,l,stack,queue,llist);
	v.setAlignment(Pos.TOP_CENTER);
	v.setSpacing(20);
    //v.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE,CornerRadii.EMPTY,Insets.EMPTY)));
	v.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, null, null)));
	Scene scene=new Scene(v);
	stage.setScene(scene);
	stage.show();
	}

}
