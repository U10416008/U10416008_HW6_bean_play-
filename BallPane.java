//U10416008丁杰

import javafx.geometry.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import javafx.event.*;
import java.security.SecureRandom;

public class BallPane extends Pane {
  SecureRandom srand = new SecureRandom();
  int right = 0;
  int left = 0;
  public final double radius = 5;
  private double x = 200, y = radius;
  private double dx = 0.36, dy = 1;
  Circle circle = new Circle(x, y, radius);
  private Timeline animation;
  public BallPane() {
    circle.setFill(Color.BLACK); // Set ball color
    getChildren().add(circle); // Place a ball into this pane
	
    // Create an animation for moving the ball
    animation = new Timeline(
      new KeyFrame(Duration.millis(5), e -> moveBall()));
    animation.setCycleCount(Timeline.INDEFINITE);
    animation.play(); // Start animation
  }
  public int getRight(){
	  return right;
  }
  public int getLeft(){
	  return left;
  }
  public DoubleProperty rateProperty() {
    return animation.rateProperty();
  }
  
  protected void moveBall() {
	int random;
    // Check boundaries
    if(y >= 138-2*radius && y< 328){
		if (y == 138-2*radius ) {
			random = srand.nextInt() % 2 ;
			if(random == 1){
				dx *= -1; 	
			}else{
				dx *= 1; 
			}
			if(dx > 0){
				right++;
			}
			if(dx < 0){
				left++;
			}

		 // Change ball move direction
		}
		if( y == 166 - 2*radius ){
			random = srand.nextInt() % 2 ;
			if(random == 1){
				dx *= -1; 	
			}else{
				dx *= 1; 
			}
			if(dx > 0){
				right++;
			}
			if(dx < 0){
				left++;
			}

		}
		if(y == 194 - 2*radius ){
			random = srand.nextInt() % 2 ;
			if(random == 1){
				dx *= -1; 	
			}else{
				dx *= 1; 
			}
			if(dx > 0){
				right++;
			}
			if(dx < 0){
				left++;
			}

		}
		if(y == 222 - 2*radius){
			random = srand.nextInt() % 2 ;
			if(random == 1){
				dx *= -1; 	
			}else{
				dx *= 1; 
			}
			if(dx > 0){
				right++;
			}
			if(dx < 0){
				left++;
			}

		}
		if(y == 250 - 2*radius){
			random = srand.nextInt() % 2 ;
			if(random == 1){
				dx *= -1; 	
			}else{
				dx *= 1; 
			}
			if(dx > 0){
				right++;
			}
			if(dx < 0){
				left++;
			}

		}
		if(y == 278 - 2*radius ){
			random = srand.nextInt() % 2 ;
			if(random == 1){
				dx *= -1; 	
			}else{
				dx *= 1; 
			}
			if(dx > 0){
				right++;
			}
			if(dx < 0){
				left++;
			}

		}
		if(y == 306 - 2*radius ){
			random = srand.nextInt() % 2 ;
			if(random == 1){
				dx *= -1; 	
			}else{
				dx *= 1; 
			}
			if(dx > 0){
				right++;
			}
			if(dx < 0){
				left++;
			}

		}
		x += dx;
	
	}
	if(y == 350 - radius){
		dy *= 0;
	}
    // Adjust ball position
    //x += dx;
    y += dy;
    circle.setCenterX(x);
    circle.setCenterY(y);
  }
}