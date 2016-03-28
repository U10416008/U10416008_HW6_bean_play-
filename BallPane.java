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
  int first = 0;
  int second = 0;
  int third = 0;
  int forth = 0;
  int fifth = 0;
  int sixth = 0;
  int seventh = 0;
  int eighth = 0;
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
      new KeyFrame(Duration.millis(10), e -> moveBall()));
    animation.setCycleCount(Timeline.INDEFINITE);
    animation.play(); // Start animation
  }

  public void play() {
    animation.play();
  }

  public void pause() {
    animation.pause();
  }

  public void increaseSpeed() {
    animation.setRate(animation.getRate() + 0.1);
  }

  public void decreaseSpeed() {
    animation.setRate(
      animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
  }

  public DoubleProperty rateProperty() {
    return animation.rateProperty();
  }
  
  protected void moveBall() {
	int random;
    // Check boundaries
    if(y >= 138-radius && y< 328){
		if (y == 138-2*radius ) {
			random = srand.nextInt() % 2 ;
			if(random == 1){
				dx *= -1; 	
			}else{
				dx *= 1; 
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
		}
		if(y == 194 - 2*radius ){
			random = srand.nextInt() % 2 ;
			if(random == 1){
				dx *= -1; 	
			}else{
				dx *= 1; 
			}
		}
		if(y == 222 - 2*radius){
			random = srand.nextInt() % 2 ;
			if(random == 1){
				dx *= -1; 	
			}else{
				dx *= 1; 
			}
		}
		if(y == 250 - 2*radius){
			random = srand.nextInt() % 2 ;
			if(random == 1){
				dx *= -1; 	
			}else{
				dx *= 1; 
			}
		}
		if(y == 278 - 2*radius ){
			random = srand.nextInt() % 2 ;
			if(random == 1){
				dx *= -1; 	
			}else{
				dx *= 1; 
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