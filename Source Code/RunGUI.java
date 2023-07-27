import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.Component;

public class RunGUI extends JPanel
{

	private JFrame frame;
	private final JPanel panel,panel1;
	int totBus;
	int totStd;
	Controller c;
	JButton b;
	JLabel ts,tb,aw,tsr,l3,l4,l5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RunGUI window = new RunGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public RunGUI() {
		panel = new JPanel();
		panel1 = new JPanel();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

// Here the First Page will be displayed where textfields will be shown for submission...
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		panel.setVisible(true);

		Image icon = Toolkit.getDefaultToolkit().getImage("F:/BS-CS/BSCS-4/Operating System/OS Project/56.png");
		frame.setIconImage(icon);
		frame.getContentPane().setLayout(null);
		
		ImageIcon i = new ImageIcon("F:/BS-CS/BSCS-4/Operating System/OS Project/4.jpg");
		frame.setContentPane(new JLabel(i));
	
		JLabel l1 = new JLabel("Enter Total Number of Busses");
		l1.setForeground(Color.white);
		l1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		l1.setBounds(172, 153, 400, 40);
		panel.add(l1);
		
		JLabel l2 = new JLabel("Enter Total Number of Students");
		l2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		l2.setForeground(Color.white);
		l2.setBounds(172, 206, 400, 40);
		panel.add(l2);
		
		JTextField textPane = new JTextField();
		textPane.setForeground(new Color(0, 0, 0));
		textPane.setBounds(602, 163, 167, 30);
		textPane.setText("50");
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(textPane);
		
		JTextField textPane_1 = new JTextField();
		textPane_1.setBounds(602, 214, 167, 30);
		textPane_1.setText("1000");
		textPane_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(textPane_1);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnNewButton.setForeground(Color.black);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(680, 265, 100, 37);
		
		panel.add(btnNewButton);
		
				
		panel.setBounds(50,50,1000,450);
		panel.setBackground(new Color(0,0,0,120));
		panel.setLayout(null);
		frame.getContentPane().add(panel);
		
		JButton btnCancel = new JButton("Close");
		btnCancel.setBackground(Color.RED);
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				
			}
		});
		btnCancel.setBounds(632, 313, 100, 37);
		panel.add(btnCancel);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == btnReset)
				{
					textPane.setText("");
					textPane_1.setText("");
					textPane.setBackground(Color.white);
					textPane.setBackground(Color.white);
				}
			}
		});
		btnReset.setForeground(Color.green);
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReset.setBackground(Color.WHITE);
		btnReset.setAlignmentY(1.0f);
		btnReset.setBounds(579, 265, 89, 37);
		panel.add(btnReset);
		
// This is when the user will press the Submit Button
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.setResizable(true);
				
				
				testFinal();
			}
			
			public void testFinal() 
			{
				
				panel.setVisible(false);
				panel1.setVisible(true);
				
			
				 totBus = 0;
				 totStd=0;
				String numBus = textPane.getText();
				String numStudents = textPane_1.getText();
				
				
				textPane.setText("50");
				textPane_1.setText("1000");
				
				
				boolean flag = true;
				try
				{
					 totBus = Integer.parseInt(numBus);
					 totStd = Integer.parseInt(numStudents);
					 
					 if(totStd==0)
					 {
						 JOptionPane.showMessageDialog(frame, "Please Fill the blank of Students");
						 	frame.dispose();
							panel.setVisible(true);
							frame.setVisible(true);
							l1.setVisible(true);
							l2.setVisible(true);
							textPane.setVisible(true);
							textPane_1.setVisible(true);
							textPane.setText("");
							textPane_1.setText("");
							
							btnNewButton.setVisible(true);
						
					 }
					 else
					 {
						 boolean flag1 = false, flag2 = false;
						 		frame.getContentPane().setBackground( Color.white );
								frame.setResizable(true);
								frame.setSize(1050,600);
								
								GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
								GraphicsDevice device = graphics.getDefaultScreenDevice();
								
								ImageIcon i = new ImageIcon("F:/BS-CS/BSCS-4/Operating System/OS Project/back.jpg");
								frame.setContentPane(new JLabel(i));
								
								l3 = new JLabel("Sukkur IBA University");
								l3.setFont(new Font("Tahoma", Font.PLAIN, 40));
								l3.setForeground(Color.white);
								l3.setBounds(450, 40, 500, 50);
								panel1.add(l3);
								
								panel1.setBounds(50,50,1260,630);
								panel1.setBackground(new Color(0,0,0,200));
								panel1.setLayout(null);
								frame.getContentPane().add(panel1);
								
								device.setFullScreenWindow(frame);
								
							
								try {
									 c = new Controller(totBus,totStd);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								
								if(c.busWast>0 || totStd<30)
								{
									tsr = new JLabel("Total Students who ride the bus : "+totStd);
									tsr.setFont(new Font("Tahoma", Font.PLAIN, 25));
									tsr.setForeground(Color.green);
									tsr.setBounds(100, 350, 500, 70);
									panel1.add(tsr);
									
									l4 = new JLabel("The Wastage of Busses : " + c.busWast);
									l4.setFont(new Font("Tahoma", Font.PLAIN, 25));
									l4.setForeground(Color.red);
									l4.setBounds(100, 300, 500, 70);
									panel1.add(l4);
									
									flag1 = true;
									
									 l5 = new JLabel("Busses are not enough as  "+ c.stdRemaining+" Students Left Out");
										l5.setFont(new Font("Tahoma", Font.PLAIN, 25));
										l5.setForeground(Color.red);
										l5.setBounds(100, 350, 900, 70);
										panel1.add(l5);
										l5.setVisible(false);
								}	
								else if(c.busWast==0)
								{
									tsr = new JLabel("Total Students who ride the bus : "+((c.stdRemaining*2)-(c.stdRemaining-totStd)-totStd));
									tsr.setFont(new Font("Tahoma", Font.PLAIN, 25));
									tsr.setForeground(Color.green);
									tsr.setBounds(100, 350, 500, 70);
									panel1.add(tsr);
									
									 l5 = new JLabel("Busses are not enough as  "+ (totStd-c.stdRemaining) + " Students Left Out");
									l5.setFont(new Font("Tahoma", Font.PLAIN, 25));
									l5.setForeground(Color.red);
									l5.setBounds(100, 300, 900, 70);
									panel1.add(l5);
									
									flag2 = true;
									
									l4 = new JLabel("The Wastage of Busses : " + c.busWast);
									l4.setFont(new Font("Tahoma", Font.PLAIN, 25));
									l4.setForeground(Color.red);
									l4.setBounds(100, 300, 500, 70);
									panel1.add(l4);
									l4.setVisible(false);
								
								}
								
								ts = new JLabel("The Total Students at Bus Point are : " + totStd);
								ts.setFont(new Font("Tahoma", Font.PLAIN, 25));
								ts.setForeground(Color.WHITE);
								ts.setBounds(100, 190, 700, 70);
								panel1.add(ts);
								
								tb = new JLabel("The Total Busses Arrived at Buss Point : " + totBus);
								tb.setFont(new Font("Tahoma", Font.PLAIN, 25));
								tb.setForeground(Color.WHITE);
								tb.setBounds(100, 240, 500, 70);
								panel1.add(tb);
								aw = new JLabel("Average Students Wait for Bus is : "+ (c.avgWaiting) +"s");
								aw.setFont(new Font("Tahoma", Font.PLAIN, 25));
								aw.setForeground(Color.ORANGE);
								aw.setBounds(100, 400, 700, 70);
								panel1.add(aw);
								
								
								JButton btnCancel = new JButton("Close");
								btnCancel.setBackground(Color.RED);
								btnCancel.setForeground(Color.WHITE);
								btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 22));
								btnCancel.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
										frame.dispose();
										
									}
								});
								btnCancel.setBounds(10, 11, 90, 30);
								panel1.add(btnCancel);
								
								
								b = new JButton("Home");
								b.setAlignmentY(Component.BOTTOM_ALIGNMENT);
								b.setForeground(Color.BLACK);
								b.setFont(new Font("Tahoma", Font.PLAIN, 35));
								b.setBackground(Color.WHITE);
								b.setBounds(1100, 560, 130, 60);
								panel1.add(b);
								
								b.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
										
										panel1.setVisible(false);
										frame.dispose();
										panel.setVisible(true);
										new RunGUI();
										frame.setVisible(false);
										
										ImageIcon i = new ImageIcon("F:/BS-CS/BSCS-4/Operating System/OS Project/4.jpg");
										frame.setContentPane(new JLabel(i));
										
										frame.setVisible(true);
										frame.getContentPane().add(panel);
										
										l3.setText(null);
										l4.setText(null);
										l5.setText(null);
										ts.setText(null);
										tb.setText(null);
										tsr.setText(null);
										aw.setText(null);
										
									}
									
								});
					}
				}
				catch(Exception e)
				{
					panel.setVisible(false);
					JOptionPane.showMessageDialog(frame,"Please Enter Numeric value");
					frame.dispose();
					panel.setVisible(true);
					frame.setResizable(false);
					frame.setVisible(true);
					l1.setVisible(true);
					l2.setVisible(true);
					textPane.setVisible(true);
					textPane_1.setVisible(true);
					textPane.setText("");
					textPane_1.setText("");
					
					btnNewButton.setVisible(true);
				}
			}
		});
		frame.setBounds(100, 100, 1116, 577);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class Bus 
{
	int id;
	int students;
	static int counter = 0;
	int std = 0;
	Bus(int id, int students) throws InterruptedException
	{
		this.id = id;
		this.students = students;
	}
	public void runBus() throws InterruptedException
	{
		int rnd = (int) (Math.random() * ((30-25)+1))+25;
		int rndTime = (int) (Math.random() * ((3000-0)+1))+0;
		Controller.avgWaiting += rndTime;
		for(int i = 1 ; i<=rnd ; i++)
		{
			// Counter is for counting the number of Students which is used in Controller class
			Student s = new Student(++std);
			counter++;
			if(counter==students)
			{
				break;
			}
			else
			{
				// This is used to count the Total Busses
				Controller.StudentCount++;
			}
		}
	}
}

class Student
{
	int id;
	Student(int id)
	{
		this.id = id;
	}
}
class Controller
{
	static int StudentCount=0;
	int stdRemaining;
	int busWast;
	static double avgWaiting=0;
	int busWastC;
	Controller(int Busses, int Students) throws InterruptedException
	{
		StudentCount=0;
		avgWaiting=0;
		for(int i =1;i<=Busses; i++)
		{
			Bus b = new Bus(i,Students);
			b.runBus();
			int val = Bus.counter;
			if(StudentCount!=Busses && val==Students)
			{
				busWast = Busses - i;
			}
			 if(Busses==1 && i==1)
			{
				busWast=0;
			}
		}
		stdRemaining = Bus.counter;
		avgWaiting = avgWaiting/1000;
		avgWaiting = avgWaiting/Busses;
		Bus.counter=0;
	}
}
