import java.awt.*;
import java.awt.event.InputEvent;

/**
 * Created by Link on 20/08/17.
 */


public class Everwing {

  private Robot robot;

  public Everwing () {
    try {
      this.robot = new Robot();
    } catch(Exception e ) {
      System.out.println(e);
    }

  }

  public void start() throws Exception {
    //this.robot.mouseMove(663, 684);
    this.robot.mouseMove(465, 588);
    this.makeClick();
    Thread.sleep(500);
  }

  public void play() throws Exception {
    while(!this.hasGameFinished()) {
      Thread.sleep(1000);
    }
  }

  private void makeClick() throws Exception {
    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    Thread.sleep(125);
    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
  }

  public void restart() throws Exception {
    //this.robot.mouseMove(625, 751);
    this.robot.mouseMove(396, 666);
    Thread.sleep(125);
    this.makeClick();
    Thread.sleep(500);
  }

  private boolean hasGameFinished() {
    //String color = this.robot.getPixelColor(606, 756).toString();
    //this.robot.mouseMove(396, 666);
    String color = this.robot.getPixelColor(396, 666).toString();
    //System.out.println("The color is " + color);
    return color.equals("java.awt.Color[r=0,g=160,b=232]");
  }

  public void printMouseInfo() {
    Double x = MouseInfo.getPointerInfo().getLocation().getX();
    Double y = MouseInfo.getPointerInfo().getLocation().getY();
    System.out.println("Coordinates: (" + x + "," + y + ")");
    System.out.println(this.robot.getPixelColor( x.intValue(), y.intValue()).toString());

  }

  public static void main(String [] args) {
    Everwing everwing = new Everwing();



    try {
//      Thread.sleep(2000);
//      everwing.printMouseInfo();
      Thread.sleep(2000);
      for(int i = 0; i < 100000; i ++) {
        System.out.println("Iteration " + (i+1));
        everwing.start();
        everwing.play();
        everwing.restart();
      }
    } catch(Exception  e ) {
      System.out.println(e);
    }

  }
}
