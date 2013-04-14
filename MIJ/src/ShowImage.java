

import java.awt.*;
import javax.swing.*;

public class ShowImage extends JPanel{
Image img;

public ShowImage(){
 super();
 img = Toolkit.getDefaultToolkit().getImage("diagram1.png");
}

public void paintComponent(Graphics g){
 // Teken image
 g.drawImage(img,50,10,200,200, this); // locatie 50, 10 en breedte + hoogte 200 x 200
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