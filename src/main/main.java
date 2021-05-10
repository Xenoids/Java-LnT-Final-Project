package main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class main extends JFrame implements ActionListener{
	
	// Frame
	JFrame frame = new JFrame();
	
	// Button
	JButton insertbutton = new JButton("Insert Data");
	JButton viewbutton = new JButton("View Data");
	JButton updatebutton = new JButton("Update Data");
	JButton deletebutton = new JButton("Delete Data");
	JButton infobutton = new JButton("Info");
	JButton exitbutton = new JButton("Exit");
	
	//

	
	public main() {
		// TODO Auto-generated constructor stub
		createframe();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new main();
	}
	
	public void createframe()
	{
		// Frame Customize
		frame.setTitle("BobaCool");
		frame.setSize(600,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setResizable(true);
		ImageIcon gambar = new ImageIcon("./src/boba.jpg");
		frame.setIconImage(gambar.getImage());
		frame.getContentPane().setBackground(new Color(255,255,204));
		
		// Create
		createlabel();
		createmenu();
		createdownmenu();
		
		// Pop Up
		frame.setLocation(550,300);
		frame.setVisible(true);
		
	}
	
	public void createlabel()
	{
		JLabel label = new JLabel("Selamat Datang di Program Database BobaCool");
		
		// Label Customize
		label.setHorizontalAlignment(label.CENTER);
		label.setFont(new Font("Quicksand",Font.ITALIC,25));
		label.setForeground(new Color(102,0,153));
		frame.add(label, BorderLayout.NORTH);
	}
	
	public void createmenu()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,2));
		
		// Button Customize
		deletebutton.setBackground(new Color(205,92,92));
		deletebutton.setFont(new Font("Quicksand",Font.PLAIN,40));
		deletebutton.setForeground(new Color(255,160,122));
		deletebutton.setBorder(BorderFactory.createRaisedBevelBorder());
		deletebutton.setOpaque(true);
		
		updatebutton.setBackground(new Color(25,25,112));
		updatebutton.setFont(new Font("Quicksand",Font.PLAIN,40));
		updatebutton.setForeground(new Color(0,191,255));
		updatebutton.setBorder(BorderFactory.createRaisedBevelBorder());
		updatebutton.setOpaque(true);
		
		insertbutton.setBackground(new Color(34,139,34));
		insertbutton.setFont(new Font("Quicksand",Font.PLAIN,40));
		insertbutton.setForeground(new Color(144,238,144));
		insertbutton.setBorder(BorderFactory.createRaisedBevelBorder());
		insertbutton.setOpaque(true);
		
		viewbutton.setBackground(new Color(218,165,32));
		viewbutton.setFont(new Font("Quicksand",Font.PLAIN,40));
		viewbutton.setForeground(new Color(255,215,0));
		viewbutton.setBorder(BorderFactory.createRaisedBevelBorder());
		viewbutton.setOpaque(true);
		
		// Action Listener
		
		insertbutton.addActionListener(this);
		updatebutton.addActionListener(this);
		viewbutton.addActionListener(this);
		deletebutton.addActionListener(this);
		
		// Panel Input
		panel.add(insertbutton);
		panel.add(updatebutton);
		panel.add(viewbutton);
		panel.add(deletebutton);
		
		// Frame Input
		frame.add(panel);
		
		
		
	}
	public void createdownmenu()
	{
		JPanel downpanel = new JPanel();
		downpanel.setLayout(new FlowLayout());
		
		// Button Customize
		infobutton.setBackground(Color.GREEN);
		infobutton.setForeground(Color.WHITE);
		infobutton.setFont(new Font("Quicksand",Font.BOLD,14));
		infobutton.setOpaque(true);
		
		exitbutton.setBackground(Color.RED);
		exitbutton.setForeground(Color.WHITE);
		exitbutton.setFont(new Font("Quicksand",Font.BOLD,14));
		exitbutton.setOpaque(true);
		
		// Panel Input
		downpanel.add(infobutton);
		downpanel.add(exitbutton);
		
		// Frame Input
		frame.add(downpanel,BorderLayout.SOUTH);
		
		// Action Listener
		infobutton.addActionListener(this);
		exitbutton.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(insertbutton)) {
			JOptionPane.showMessageDialog(null, "Data akan diinsert!","Insert",JOptionPane.INFORMATION_MESSAGE);
			new form();
			frame.setVisible(false);
		}
		else if(e.getSource().equals(updatebutton)) {
			JOptionPane.showMessageDialog(null, "Data akan diupdate!","Update",JOptionPane.INFORMATION_MESSAGE);
			new formupdate();
			frame.setVisible(false);
		}
		else if(e.getSource().equals(viewbutton)) {
			JOptionPane.showMessageDialog(null, "Melihat Data dalam bentuk tabel!","View",JOptionPane.INFORMATION_MESSAGE);
			new table();
			frame.setVisible(false);
		}
		else if(e.getSource().equals(deletebutton)) {
			JOptionPane.showMessageDialog(null, "Data akan didelete!","Delete",JOptionPane.INFORMATION_MESSAGE);
			new formdelete();
			frame.setVisible(false);
		}
		else if(e.getSource().equals(infobutton)) {
			JOptionPane.showMessageDialog(null, "=============================\n|   BobaCool Database Program       |   \n=============================\nCreated by : Nicholas Valenthinus Tanoto\nNo. BNCC : 20076\n\nTerima Kasih telah menggunakan Program ini!","Info",JOptionPane.INFORMATION_MESSAGE);
			new main();
			frame.setVisible(false);
		}
		else if(e.getSource().equals(exitbutton)) {
			System.exit(0);
		}
	}

}
