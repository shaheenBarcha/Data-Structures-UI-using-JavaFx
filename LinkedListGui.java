package DSProject;
/*package DSlabProject;*/

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LinkedListGui extends Application {
Stage stage;
Scene scene;
LinkedListGui(){
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
		stage.setTitle("LinkedList");
		stage.setHeight(500);
		stage.setWidth(700);
		stage.setResizable(false);
		SceneGraph();
		stage.show();
	}

	private void SceneGraph() {
		// TODO Auto-generated method stub
		Label head = new Label("LinkedList Algorithm");
		head.setFont(Font.font("",FontWeight.BOLD,40));
		head.setTextFill(Color.DEEPPINK);
		Button add = new Button("ADD");
		add.setPrefSize(100, 25);
		TextField input = new TextField();
		Button delete = new Button("DELETE");
		delete.setPrefSize(100, 25);
	    Button search = new Button("SEARCH");
	    search.setPrefSize(100,25);
	    TextField Sinput=new TextField();
	    Button back = new Button("BACK");
	    back.setPrefSize(100,25);
	    FlowPane layout = new FlowPane();
	    ArrayList list= new ArrayList();
		add.setOnAction(new EventHandler<ActionEvent>() {

			@SuppressWarnings("unchecked")
			@Override
			public void handle(ActionEvent event) {
			
				try {
					
				String num = input.getText();
				list.add(num);
				if(num.isEmpty()||!(num.matches("-?\\d+(\\.\\d+)?"))) { 
					Alert alert = new Alert(AlertType.WARNING);
					alert.setHeaderText(null);
                    alert.setContentText("Please Enter Number");
                    alert.show();
				}
				else {

					int numb=Integer.parseInt(input.getText());
				Button b = new Button(num);
				Text text = new Text("->"); 
				b.setPrefSize(100, 25);
				int size=layout.getChildren().size();
				
				if(size==0) {
					layout.getChildren().addAll(b);
				}
				else
				{
					layout.getChildren().addAll(text,b);
				}
				input.clear();
			}}
				catch(Exception e2) {
				}
				}	
		});
		delete.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
				if(layout.getChildren().isEmpty()) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setHeaderText(null);
					alert.setContentText("linked list is empty");
					
					alert.show();
				}
				else
				{
				int first=layout.getChildren().size();
				int second=layout.getChildren().size();
				first--;
				if(first==0&&second==1) {
				layout.getChildren().remove(0);
				list.remove(0);
				
					}
				else {
					layout.getChildren().remove(--first, second);
					list.remove(first);
					}
			}}
				catch(Exception e) {
					System.out.println("");
				}
				
			
			}
		});
		search.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
				String search=Sinput.getText();
				if (search.isEmpty()) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setContentText("Enter your value");
					alert.show();
					
				}
				else if(list.isEmpty()) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setContentText("Linked List is empty");
					alert.show();
				}
				else if(list.contains(search)) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setHeaderText(null);
					alert.setContentText("Your searched value is present in  linked list");
					alert.show();
				}
				else {
					 	Alert alert = new Alert(AlertType.ERROR);
						alert.setHeaderText(null);
						alert.setContentText("Your searched value is not present");
						alert.show();
						}
				Sinput.clear();
				}
		
			
		});
	back.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
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
	HBox hed = new HBox(head);
	hed.setPrefSize(100, 40);
	hed.setAlignment(Pos.CENTER);
		HBox h = new HBox(add,input,delete,search,Sinput,back);
		VBox v = new VBox(hed,h,layout);
		v.setSpacing(20);
		hed.setBackground(new Background(new BackgroundFill(Color.DARKGRAY,CornerRadii.EMPTY,Insets.EMPTY)));

scene = new Scene(v);
stage.setScene(scene);
stage.show();
	}

}
