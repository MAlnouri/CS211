package Assignments;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Button;
import java.awt.Panel;

public class mapGUI {
	
	mapGUI(String title,String latitude, String longitude,int zoom, int width, int height, int scale, String type, String mark) {
    	
    	JFrame map = new JFrame(title);
       	map.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        map.setSize(width, height);
        map.setLocationRelativeTo(null);
        map.setVisible(true);
        //JPanel p1 = new JPanel();
        //p1.setVisible(false);
        //p1.add(new JButton("1"));
        //map.add(p1);
        
     
        //Button btn = new Button("test");
        //map.add(btn);
        //p1.add(btn);
        
        //JButton Button = new JButton("test");
        //Button.
        //map.add(Button);
        
        try {
        	
    	String imageUrl = "https://maps.googleapis.com/maps/api/staticmap?center=";
        imageUrl+= latitude+ ","+ longitude+ "&zoom=" + zoom + "&size=" + width + "x" + height+"&scale="+zoom+"&maptype="+type+mark;
        
        String destinationFile = "map.jpg";
         
         URL url = new URL(imageUrl);
         InputStream is = url.openStream();
         OutputStream os = new FileOutputStream(destinationFile);
         byte[] b = new byte[2048];
         
         int length;
         while ((length = is.read(b)) != -1) {
    	 	os.write(b, 0, length);
         }
         is.close();
         os.close();
      } catch (IOException e) {
    	  e.printStackTrace();
         System.exit(1);
         }
      
      ImageIcon imageIcon = new ImageIcon((new ImageIcon("map.jpg")).getImage().getScaledInstance(width, height,java.awt.Image.SCALE_SMOOTH));  
      map.add(new JLabel(imageIcon));
      //p1.add(new JLabel(imageIcon));
      map.setVisible(true);
      map.pack();
	}

}
