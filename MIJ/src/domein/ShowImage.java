package domein;

import java.awt.*;
import javax.swing.*;

public class ShowImage extends JPanel{
Image image; // Declare a name for our Image object.
Image img;

public ShowImage(){
 super();
 image = Toolkit.getDefaultToolkit().getImage("java_duke.gif");
 img = Toolkit.getDefaultToolkit().getImage("java_duke.png");
}

public void paintComponent(Graphics g){

 // Draw our Image object.
 g.drawImage(image,50,10,200,200, this); // at location 50,10 and 200 wide and high
 g.drawImage(image,100,20,200,200, this);
 g.drawImage(img,150,30,200,200, this);
}

public static void main(String arg[]){
 JFrame frame = new JFrame("ShowImage");
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 frame.setSize(600,400);

 ShowImage panel = new ShowImage();
 frame.setContentPane(panel);
 frame.setVisible(true);
}
}