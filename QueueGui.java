package DSProject;
/*package DSlabProject;*/

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class QueueGui extends Application {
Stage stage;
Scene scene;
int front=0;
QueueGui(){
	try {
		start(new Stage());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		stage=primaryStage;
		stage.setTitle("Queue");
		stage.setHeight(500);
		stage.setWidth(500);
		stage.setResizable(false);
		seneGaraph();
		stage.show();
	}

	private void seneGaraph() {
		// TODO Auto-generated method stub
		Label label = new Label("QUEUE");
		label.setFont(Font.font("verdana",FontWeight.BOLD,FontPosture.ITALIC,50));
		label.setTextFill(Color.DEEPPINK);
		Button enqueue = new Button("ENQUEUE");
		Button dequeue = new Button("DEQUEUE");
		Button back = new Button("BACK");
		back.setPrefSize(100, 25);
		TextField input = new TextField();
		ListView list = new ListView();
	   
		enqueue.setOnAction(new EventHandler<ActionEvent>() {
			
			@SuppressWarnings("unchecked")
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
				try {
				
					String c= input.getText();
				
				if( input.getText().isEmpty() || !(c.matches("-?\\d+(\\.\\d+)?"))) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setHeaderText(null);
					alert.setContentText("First enter number");
				    alert.show();
				}
				else
				{
					int numb=Integer.parseInt(input.getText());	
					String num = input.getText();
					list.getItems().add(0, num);
					front++;
					System.out.println(front);
					input.clear();
				}
				}
				catch(Exception e2) {
				}
				}
		});
		dequeue.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
			if(list.getItems().isEmpty()) 
			{
				Alert a = new Alert(AlertType.WARNING);
				a.setTitle("Alert");
				a.setHeaderText(null);
		        a.setContentText("Queue is empty");
		        a.show();
			}
			else
				{	
					list.getItems().remove(front-1);
					System.out.println(front);	
					front--;
				}
			}
		});
		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Main n = new Main();
				try {
					n.start(new Stage());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				stage.close();
				
			}
		});
		HBox h = new HBox(enqueue,input,dequeue,back);
		VBox v = new VBox(label,h,list);
		v.setAlignment(Pos.CENTER);
		v.setBackground(new Background(new BackgroundFill(Color.DARKGRAY,CornerRadii.EMPTY,Insets.EMPTY)));
		scene=new Scene(v);
        stage.setScene(scene);
        stage.show();
	}

}
