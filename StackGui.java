package DSProject;



import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StackGui extends Application{
Stage stage;
Scene scene;
int front=0;



StackGui(){
	try {
		start(new Stage() );
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
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		stage=arg0;
		stage.setTitle("Stack");//set stage title
		stage.setHeight(500);//set stage height
	    stage.setWidth(500);//set stage width
	    stage.setResizable(false);//stage not show full screen
		sceneGraph();//invoke scene method that has all element
        stage.show();	//stage show
}

	private void sceneGraph() {
		Text s=new Text();//text for header
		s.setFont(Font.font("verdana",FontWeight.BOLD,FontPosture.ITALIC,50));
		s.setFill(Color.DEEPPINK);//set color 
		s.setText("STACK");
		Button push = new Button("PUSH");
		push.setPrefSize(100, 25);
		Text t = new Text("Enter Number");
		TextField input = new TextField();
		Button pop = new Button("POP");
		pop.setPrefSize(100, 25);
		Button peek = new Button("PEEK");
		peek.setPrefSize(100, 25);
		Button back = new Button("BACK");
		back.setPrefSize(100, 25);
        ListView list = new ListView();
        list.getBorder();
        
       push.setOnAction(new EventHandler<ActionEvent>() {
			
			@SuppressWarnings("unchecked")
			@Override
			public void handle(ActionEvent event) {
				try {
	           String c= input.getText();
 
			if(input.getText().isEmpty()  || !(c.matches("-?\\d+(\\.\\d+)?")) )
					{
			Alert a = new Alert(AlertType.WARNING);
			a.setHeaderText(null);
			a.setContentText("Please Enter Number");
			a.show();
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
      
        pop.setOnAction(new EventHandler<ActionEvent>() {
        	 int front=1;
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
					
				if(list.getItems().isEmpty()) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Alert");
					alert.setHeaderText(null);
					alert.setContentText("Stack is empty");
					alert.show();
				}
				else
					
					list.getItems().remove(0);
				
				System.out.println(front);	
				front++;
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
        peek.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText(null);
				if (list.getItems().isEmpty()) {
					alert.setContentText("Stack has no Data");
					alert.show();
				}
				else {
				alert.setContentText("Stack peek value is "+list.getItems().get(0));
				alert.show();}
			}
		});
		HBox h = new HBox(push,input,pop,peek,back);
		VBox v = new VBox(s,h,list);
		v.setAlignment(Pos.CENTER);
		v.setBackground(new Background(new BackgroundFill(Color.DARKGRAY,CornerRadii.EMPTY,Insets.EMPTY)));
		scene = new Scene(v);
		stage.setScene(scene);
		stage.show();
		
	}
}
