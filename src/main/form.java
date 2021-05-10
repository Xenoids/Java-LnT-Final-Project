package main;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DAO.CustDAO;

public class form extends JFrame implements ActionListener{

	
	
	// Button
	JButton confirmbutton = new JButton("Confirm");
	JButton cancelbutton = new JButton("Back");
	
	// Text Field
	JTextField txtnama = new JTextField();
	
	JTextField txtharga = new JTextField();
	
	
	JTextField txtstok = new JTextField();
	
	
	

	
	// Label
	JLabel labelkode = new JLabel("Input Kode Boba: ");
	JLabel labelnama = new JLabel("Input Nama Boba: ");
	JLabel labelharga = new JLabel("Input Harga Boba: ");
	JLabel labelstok = new JLabel("Input Stok Boba: ");
	JLabel label = new JLabel();
	
	// Image
	ImageIcon gambars = new ImageIcon("./src/boba.jpg");
	


	
	public form() {
		// TODO Auto-generated constructor stub
		JTextFieldValid();
		JTextFieldValid2();
		createframe();
	
	}
	
	public void JTextFieldValid() {
		txtharga.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				String value = txtharga.getText();
				int l = value.length();
				if(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == '\b') {
					txtharga.setEditable(true);
				}
				else {
					txtharga.setEditable(false);
				}
			}
		});
	
	}
	
	public void JTextFieldValid2() {
		txtstok.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				String value = txtstok.getText();
				int l = value.length();
				if(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == '\b') {
					txtstok.setEditable(true);
				}
				else {
					txtstok.setEditable(false);
				}
			}
		});
	
	}

	public void createframe()
	{
		setTitle("Input Data!");
		setSize(300,500);
		getContentPane().setBackground(new Color(135,206,235));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(gambars.getImage());
		setLayout(new GridLayout(0,2));
		createdata();
		setLocation(750,300);
		setVisible(true);
	}
	
	public void createdata()
	{
		// INPUT
		
		// Nama
		add(labelnama);
		add(txtnama);
		
		// Harga
		add(labelharga);
		add(txtharga);
		
		// Stok
		add(labelstok);
		add(txtstok);
		
		// Button
		add(confirmbutton);
		add(cancelbutton);
		
		// TextField Customize
		txtnama.setBackground(new Color(224,255,255));
		txtnama.setForeground(new Color(244,164,96));
		txtnama.setFont(new Font("Quicksand",Font.BOLD,14));

		txtharga.setBackground(new Color(224,255,255));
		txtharga.setForeground(new Color(244,164,96));
		txtharga.setFont(new Font("Quicksand",Font.BOLD,14));
		
		txtstok.setBackground(new Color(224,255,255));
		txtstok.setForeground(new Color(244,164,96));
		txtstok.setFont(new Font("Quicksand",Font.BOLD,14));
		
		// Label Customize
		labelnama.setForeground(new Color(46,139,87));
		labelnama.setFont(new Font("Quicksand",Font.BOLD,14));
		
		labelharga.setForeground(new Color(46,139,87));
		labelharga.setFont(new Font("Quicksand",Font.BOLD,14));
		
		labelstok.setForeground(new Color(46,139,87));
		labelstok.setFont(new Font("Quicksand",Font.BOLD,14));
		
		// Button Customize
		confirmbutton.setBackground(new Color(50,205,50));
		confirmbutton.setForeground(Color.WHITE);
		confirmbutton.setBorder(BorderFactory.createRaisedBevelBorder());
		confirmbutton.setFont(new Font("Quicksand",Font.BOLD,14));
		confirmbutton.setOpaque(true);
		
		cancelbutton.setBackground(new Color(178,34,34));
		cancelbutton.setForeground(Color.WHITE);
		cancelbutton.setBorder(BorderFactory.createRaisedBevelBorder());
		cancelbutton.setFont(new Font("Quicksand",Font.BOLD,14));
		cancelbutton.setOpaque(true);
		
		// Action Listener
		confirmbutton.addActionListener(this);
		cancelbutton.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		if(e.getSource().equals(confirmbutton)) {
			int choice = JOptionPane.showConfirmDialog(confirmbutton, "Apakah Anda Yakin Dengan Data Ini?","Confirm",JOptionPane.YES_NO_OPTION);
			switch(choice){
		
				case JOptionPane.YES_OPTION:
				CustDAO cust = new CustDAO();
				cust.InsertData(txtnama.getText(), txtharga.getText(), txtstok.getText());
				JOptionPane.showMessageDialog(null, "Data telah diinput dengan keterangan:\n"+"Nama Boba: "+txtnama.getText()+"\nHarga Boba: "+txtharga.getText()+"\nStok Boba: "+txtstok.getText()+"\nBerhasil Diinput!","Confirmed",JOptionPane.INFORMATION_MESSAGE);
				
			
				//cust.insertData();
				new main();
				setVisible(false);
				break;
				
				case JOptionPane.NO_OPTION:
				JOptionPane.showMessageDialog(null, "Data tidak jadi diinput!","Canceled",JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);
				new form();
				break;
			}
		}
		else if(e.getSource().equals(cancelbutton)) {
			JOptionPane.showMessageDialog(null, "Kembali ke Menu!","Back To Menu",JOptionPane.INFORMATION_MESSAGE);
			setVisible(false);
			new main();
		}
	}

}
