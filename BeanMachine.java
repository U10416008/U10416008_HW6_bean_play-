//U10416008�B�N

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.util.*;
import javafx.animation.*;
import javafx.beans.property.*;
import javafx.event.*;
import java.util.*;
import javafx.geometry.*;

public class BeanMachine extends Application {
	int n = 0;
	int i = 0;
	int first = 0;
	int second = 0;
	int third = 0;
	int forth = 0;
	int fifth = 0;
	int sixth = 0;
	int seventh = 0;
	int eighth = 0;
	ArrayList<BallPane> ball = new ArrayList<>();
	Label count = new Label();
	Label sum = new Label("Ball : ");
	Timeline animation;
	//BallPane[] ball = new BallPane[10];
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
	StackPane pane = new StackPane();
	pane.getChildren().add(new DisplayBeanMachine());	
	pane.getChildren().add(count);
	pane.getChildren().add(sum);
	pane.setAlignment(count, Pos.BOTTOM_CENTER);
	pane.setAlignment(sum, Pos.TOP_LEFT);
	pane.setOnMousePressed(e ->{
		ball.add(new BallPane());
		pane.getChildren().add(ball.get(n));
		ball.get(n).requestFocus(); 
		
		n++;
		
		
		if(n == 1){
		animation.play();
		}
		sum.setText("Ball : " + String.valueOf(n));
		
		
	});
	
	animation = new Timeline(
		new KeyFrame(Duration.millis(1000), e -> {if(ball.get(i).getRight() + ball.get(i).getLeft() == 7){
			countBall();
			count.setText("1st: <" +String.valueOf(first) + ">  2nd: <" +String.valueOf(second) + ">  3rd: <" +String.valueOf(third) + ">  4th: <" +String.valueOf(forth)
				+ ">\n  5th: <" +String.valueOf(fifth) + ">  6th: <" +String.valueOf(sixth) + ">  7th: <" +String.valueOf(seventh) + ">  8th: <" +String.valueOf(eighth)+ ">");
			}
		})
	);
	animation.setCycleCount(Timeline.INDEFINITE);
     // Start animation
	
	
	
	
    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 400, 400);
    primaryStage.setTitle("ShowPolygon"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
	
  }
  public void countBall(){
	  switch(ball.get(i).getRight()){
				case 0 : first++;break;
				case 1 : second++;break;
				case 2 : third++;break;
				case 3 : forth++;break;
				case 4 : fifth++;break;
				case 5 : sixth++;break;
				case 6 : seventh++;break;
				case 7 : eighth++;
			}
			i++;
  }
  
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}

class DisplayBeanMachine extends Pane {
  private void paint() {
	  
    // Create a polygon and place polygon to pane
    Polyline polyline = new Polyline();
	Line[] line = new Line[7];
	Circle[] bean = new Circle[28];
	
    //polygon.setFill(Color.WHITE);
    //polygon.setStroke(Color.BLACK);
    ObservableList<Double> list = polyline.getPoints();
    
    double centerX = getWidth() / 2, centerY = getHeight() / 2;
   

    // Add points to the polygon list
    list.add(centerX-10); 
    list.add(centerY-100);
	list.add(centerX-10); 
    list.add(centerY-80);
	list.add(centerX-80); 
    list.add(centerY+110);
	list.add(centerX-80); 
    list.add(centerY+150);
	list.add(centerX+80); 
    list.add(centerY+150);
	list.add(centerX+80); 
    list.add(centerY+110);
	list.add(centerX+10); 
    list.add(centerY-80);
	list.add(centerX+10); 
    list.add(centerY-100);
	for(int i = 0;i <= 6; i++){
		line[i] = new Line(centerX-60 + i*20,centerY+110,centerX-60 + i*20,centerY+150);
		
	}
	for(int i = 0; i <= 27 ; i++){
		bean[i] = new Circle();
		bean[i].setFill(Color.GREEN);
		bean[i].setRadius(5);
	}
    bean[0].setCenterX(centerX);
	bean[0].setCenterY(centerY-62);
	for(int i = 0; i <= 1 ; i++){
		bean[i+1].setCenterX(centerX-10 + i*20);
		bean[i+1].setCenterY(centerY-34);
	}
	for(int i = 0; i <= 2 ; i++){
		bean[i+3].setCenterX(centerX-20 + i*20);
		bean[i+3].setCenterY(centerY-6);
	}
	for(int i = 0; i <= 3 ; i++){
		bean[i+6].setCenterX(centerX-30 + i*20);
		bean[i+6].setCenterY(centerY+22);
	}
	for(int i = 0; i <= 4 ; i++){
		bean[i+10].setCenterX(centerX-40 + i*20);
		bean[i+10].setCenterY(centerY+50);
	}
	for(int i = 0; i <= 5 ; i++){
		bean[i+15].setCenterX(centerX-50 + i*20);
		bean[i+15].setCenterY(centerY+78);
	}
	for(int i = 0; i <= 6 ; i++){
		bean[i+21].setCenterX(centerX-60 + i*20);
		bean[i+21].setCenterY(centerY+106);
	}
    getChildren().clear();
    getChildren().add(polyline); 
	for(int i = 0;i <= 6; i++){
		getChildren().add(line[i]);    
	}
	for(int i = 0; i <= 27 ; i++){
		getChildren().add(bean[i]);
	}
	
  }
  
  @Override
  public void setWidth(double width) {
    super.setWidth(width);
    paint();
  }
  
  @Override
  public void setHeight(double height) {
    super.setHeight(height);
    paint();
  }
  
}