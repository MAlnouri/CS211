package Assignments;
//for CS211 practice, Winter 2018
//
//Modify this program:
// add abstract or interface class
// read the burger info (name and Cal) from a text file
// change the frame style (size, color, contents, etc)

import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class test {
	public static void main(String[] agrs){
		new franchiseFrame();
	}
}

class Menu{

static ArrayList<String> franchiseList = new ArrayList<String>(); 
static String[] burgerName = new String[] {"inheritance Burger","overriding Burger","constructor Burger"} ; 
static int[] cal = new int[]{260, 305, 500};
static String myFranchise; 
static Double[] price = new Double[3]; 

{
franchiseList.add("Bellevue");
franchiseList.add("Seattle");
franchiseList.add("Everett");
}
}


class franchiseFrame extends Menu {
	 static final int W=800,H=440;//width and height of JFrame
	 private JFrame f; 
	 private JPanel p;
	 private JLabel lab0,lab1; 
	 private JComboBox<String> cb; 
	 private JButton b;
     
	public franchiseFrame(){   // constructor

		f=new JFrame("Welcome to Burger211!");
		f.setSize(W, H);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p=new JPanel();
		p.setBackground(Color.GREEN);
		p.setLayout(null);
		
		lab0 = new JLabel("BURGER211");
		lab0.setBounds(W/5,40,W-20,H/6);
		lab0.setFont(new Font("Serif", Font.PLAIN, 90));

		lab1 = new JLabel("Select Franchise");
   lab1.setBounds(170,130, 400,100);
		lab1.setFont(new Font("Serif", Font.PLAIN, 30));
		lab1.setMinimumSize(new Dimension(100,100));
		
		
		cb=new JComboBox<String>();
   cb.setBounds(170,220,200,40);
		cb.setFont(new Font("Serif", Font.PLAIN, 30));
		cb.setMinimumSize(new Dimension(200,40));

		cb.addItem(franchiseList.get(0));
		cb.addItem(franchiseList.get(1));
		cb.addItem(franchiseList.get(2));
		cb.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent action) {
				if (action.getSource() == cb) {
					myFranchise=((String)cb.getSelectedItem());	
				}}
		});
		
		b=new JButton("Login");
   b.setBounds(420,230,200,30);
		b.setFont(new Font("Serif", Font.PLAIN, 30));
		b.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent action) {
				if (action.getSource() == b) {
					myFranchise=((String)cb.getSelectedItem());
            new PriceFrame();
				}}
		});
		
		f.add(p);
		p.add(lab0);
		p.add(lab1);
		p.add(cb);
		p.add(b);
		f.setVisible(true);
	} 
}

class PriceFrame extends Menu {	 

	static final int W=800,H=600;//width and height of JFrame
	 private JFrame f; 
	 private JPanel p;
	 private JLabel lab1,lab2,lab3,lab4; 
	 private JButton print;
	 private JTextField inputPrice1,inputPrice2,inputPrice3;

public PriceFrame(){//constructor

		f=new JFrame("Franchise:"+myFranchise);
		f.setSize(W, H);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p=new JPanel();
		p.setBackground(Color.WHITE);
		p.setLayout(null);
		
		lab1 = new JLabel("Set Price: " + myFranchise);
		lab1.setBounds(W/12,H/14, W-20, H/4);
		lab1.setFont(new Font("Serif", Font.PLAIN, 40));
		lab1.setMinimumSize(new Dimension(100,100));
		
		lab2 = new JLabel(burgerName[0]);
		lab2.setBounds(50,200,300,70);
		lab2.setFont(new Font("Serif", Font.PLAIN, 35));
		
		lab3 = new JLabel(burgerName[1]);
		lab3.setBounds(50,280,300,70);
		lab3.setFont(new Font("Serif", Font.PLAIN, 35));
		
		lab4 = new JLabel(burgerName[2]);
		lab4.setBounds(50,360,300,70);
		lab4.setFont(new Font("Serif", Font.PLAIN, 35));
		
		inputPrice1=new JTextField(5);
		inputPrice1.setBounds(320,210,250,50);
		inputPrice1.setFont(new Font("Serif", Font.PLAIN, 40));
		
		inputPrice2=new JTextField(5);
		inputPrice2.setBounds(320,290,250,50);
		inputPrice2.setFont(new Font("Serif", Font.PLAIN, 40));
		
		inputPrice3=new JTextField(5);
		inputPrice3.setBounds(320,370,250,50);
		inputPrice3.setFont(new Font("Serif", Font.PLAIN, 40));
		
		
		print=new JButton("PRINT");
   print.setBounds(W-320,H-130,200,50);
		print.setFont(new Font("Serif", Font.PLAIN, 40));
		print.addActionListener(new ActionListener(){
			
			@Override		
			public void actionPerformed(ActionEvent action) {

				if (action.getSource() == print) {
        		if (!inputPrice1.getText().equals("")) { 
						price[0]=Double.parseDouble(inputPrice1.getText());}
					if (!inputPrice2.getText().equals("")) { 
						price[1]=Double.parseDouble(inputPrice2.getText());}
					if (!inputPrice3.getText().equals("")) { 
						price[2]=Double.parseDouble(inputPrice3.getText());} 
             
             f.setVisible(false);            
             new PrintFrame();       
			}}
		});
		
		f.add(p);
		p.add(lab1);
		p.add(lab2);
		p.add(lab3);
		p.add(lab4);
		p.add(inputPrice1);
		p.add(inputPrice2);
		p.add(inputPrice3);
		p.add(print);
		f.setVisible(true);
	}
}

class PrintFrame extends Menu {

	static final int W=800,H=600;//width and height of JFrame
	  private JFrame f; 
  private JPanel p,imageData;
  private JLabel title,pr1,pr2,pr3,note,also,also2;
  private String menuTitle;
      
ImagePanel image1;
ImagePanel image2;
ImagePanel image3;

public PrintFrame(){
   
		f=new JFrame(myFranchise);
		f.setSize(W+220, H);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p=new JPanel();
   
   menuTitle="World's Best Burger - Burger211 "+ myFranchise ;
		title=new JLabel(menuTitle);
		title.setFont(new Font("Serif", Font.PLAIN, 40));
   title.setForeground(Color.RED);
		title.setBounds(80,0,W,H/6);
   
		pr1=new JLabel(burgerName[0] + " : " + cal[0] + "Kcal  "+ "$"+price[0]);
		pr1.setFont(new Font("Serif", Font.PLAIN, 30));
		pr1.setBounds(200,115,W,H/6);
   
		pr2=new JLabel(burgerName[1] + " : " + cal[1] + "Kcal  "+ "$"+price[1]);
		pr2.setFont(new Font("Serif", Font.PLAIN, 30));
		pr2.setBounds(200,250,W,H/6);
   
		pr3=new JLabel(burgerName[2] + " : " + cal[2] + "Kcal  "+ "$"+price[2]);
		pr3.setFont(new Font("Serif", Font.PLAIN, 30));
		pr3.setBounds(200,360,W,H/6);
		p.setLayout(null);
   
   note = new JLabel(" ");
		note.setBounds(200, 470, 500,50);
   note.setForeground(Color.RED);
		note.setFont(new Font("Serif", Font.ITALIC, 25));
   
   also = new JLabel("Customers who ate this burger also ate antidiarrheal");
		//also = new JLabel("Ingredients: flour,bannana,walnuts,sugar(little),baking powder");
   also.setBounds(200, 177, 800,50);
   also.setForeground(Color.RED);
		also.setFont(new Font("Serif", Font.ITALIC, 27));

		// Images
   image1 = new ImagePanel("Burger1.png");
   image2 = new ImagePanel("Burger2.png");
   image3 = new ImagePanel("Burger3.png"); 
   image1.setBounds(50,120,150,100);
   image2.setBounds(50,250,150,100);
   image3.setBounds(50,360,150,100);
	   f.add(image1);
   f.add(image2);
   f.add(image3); 
   
		p.add(title);
		p.add(pr1);
		p.add(pr2);
		p.add(pr3);
   p.add(note);
   p.add(also);

		f.add(p); 
	f.setVisible(true);
	}
}

class ImagePanel extends JPanel {
   Image img;
	
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
       g.drawImage(img, 0, 0, null);
   }
   public ImagePanel(Image img) {
      this.img = img;
      Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
      setPreferredSize(size);
      setMinimumSize(size);
      setMaximumSize(size);
      setSize(size);
      setLayout(null);}
    
   public ImagePanel(String img) {
      this(new ImageIcon(img).getImage());}
}
