/* Mahmmoud Alnouri
 * SID: 950594013
 * 3/2/2018
 * ArrayLists VS LinkedLists
 * 
*/

package Assignments;

// for Assignment 6 
// CS211, Winter 2018
// This code shows how to use button to draw bar

import java.util. * ;
import javax.swing.*;
import java.awt.*;

public class whichOneFasterSK {

  static ArrayList<Integer> myArray = new ArrayList<>();
  static LinkedList<Integer> myLinked = new LinkedList<>();

  static double startTime, endTime;
  static double timeALadd;   // add() time in second ArrayList
  static double timeLLadd;   // add() time in second LinkedList

public static void main(String[] args) {
  new barFrame(timeALadd);
 }

}


class barFrame {
	 static final int W=1200,H=800;//width and height of JFrame
	 private JFrame f; 
	 private JPanel p;
	 private JLabel lab0,lab1; 
	 private JButton barALadd;
      
    static String[] barTitle = new String[] {"add()","get()","remove()","sort()"} ; 
    static String mainTitle ="ArrayList vs LinkedList"; 
    static int x1, y1, x2, y2, x3, y3, x4, y4;           // x, y coordinate for the 4 operations
    static int timeArrayList = 0;    
  
  
	public barFrame(double timeAL){ // constructor
      
		f=new JFrame("Welcome to ArrayList & LinkedList World!");
		f.setSize(W, H);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p=new JPanel(){
      
      public void paintComponent(Graphics g){
        // Draw what you want to appear on your JPanel here.
       super.paintComponent(g);
       setBackground(Color.WHITE);
        
        // line     
       g.setColor(Color.BLACK);  
       g.drawLine(100, 700, 1000, 700);
       
       // bar 1
       int width = 50;
       int height = (int) (timeAL * 10000);  
       g.setColor(Color.BLACK); 
       g.fillRect(100,700 - height,width,height);    
       
       // bar 2
       width = 50;
       height = 33;  
       g.setColor(Color.BLUE); 
       g.fillRect(200,700 - height,width,height);   
       
       // bar 3
       width = 50;
       height = 4;  
       g.setColor(Color.BLACK); 
       g.fillRect(350,700 - height,width,height);   
       
       // bar 4
       width = 50;
       height = 204;  
       g.setColor(Color.BLUE); 
       g.fillRect(450,700 - height,width,height);   
       
       // bar 5
       width = 50;
       height = 75;  
       g.setColor(Color.BLACK); 
       g.fillRect(600,700 - height,width,height);  
       
       // bar 6
       width = 50;
       height = 36;  
       g.setColor(Color.BLUE); 
       g.fillRect(700,700 - height,width,height);  
       
       // bar 7
       width = 50;
       height = 240;  
       g.setColor(Color.BLACK); 
       g.fillRect(800,700 - height,width,height); 
       
       // bar 8
       width = 50;
       height = 192;  
       g.setColor(Color.BLUE); 
       g.fillRect(900,700 - height,width,height); 
       
       g.setColor(Color.BLUE);
       // string
       g.setFont( new Font( "Serif", Font.BOLD, 30 ));
       String s="add()";
       g.drawString(s, 150, 750);
       
       //string 2
       String s2 ="get()";
       g.drawString(s2, 400,750);
       
       //string 3
       String s3 ="remove()";
       g.drawString(s3, 600,750);
       
       //string 4
       String s4 ="sort()";
       g.drawString(s4, 800,750);
       
       //legend
       g.setFont( new Font( "Serif", Font.BOLD, 30 ));
       String legend2 ="LinkedList = BLUE";
       g.drawString(legend2, 50,300);
       g.setColor(Color.BLACK);
       String legend1 ="ArrayList = BLACK";
       g.drawString(legend1, 50,250);
       
       
       
       //time 1
       g.setFont( new Font( "Serif", Font.BOLD, 20 ));
       String time1 ="0.0026s";
       g.drawString(time1, 100,600);
       //time 3
       String time3 ="0.0001s";
       g.drawString(time3, 350,450);
       //time 5
       String time5 ="0.0025s";
       g.drawString(time5, 600,600);
       //time 7
       String time7 ="0.0079s";
       g.drawString(time7, 800,450);
       
       g.setColor(Color.BLUE);
       //time 2
       String time2 ="0.0011";
       g.drawString(time2, 200,600);
       //time 4
       String time4 ="0.0068s";
       g.drawString(time4, 450,450);
       //time 6
       String time6 ="0.0012s";
       g.drawString(time6, 700,600);
       //time 8
       String time8 ="0.0063s";
       g.drawString(time8, 900,450);
       }
      
   
      
     };

		p.setLayout(null);
		
		lab0 = new JLabel(mainTitle);
		lab0.setBounds(W/5,40,W-20,H/6);
		lab0.setFont(new Font("Serif", Font.PLAIN, 60));

		lab1 = new JLabel(barTitle[0]);
		lab1.setBounds(170,130, 400,100);
		lab1.setFont(new Font("Serif", Font.PLAIN, 30));
		lab1.setMinimumSize(new Dimension(100,100));
		
		
      barALadd=new JButton(""); 
      int t=(int)timeAL/10;   // scale
   //   System.out.println("t= "+t);
      
      barALadd.setBounds(200,300,70,t); // size of the button (bar)
      barALadd.setBackground(Color.RED);
		barALadd.setFont(new Font("Serif", Font.PLAIN, 30));
      		
		f.add(p);
		p.add(lab0);
		p.add(lab1);
		p.add(barALadd);
		f.setVisible(true);
  }
  
  
  
 
  
 }