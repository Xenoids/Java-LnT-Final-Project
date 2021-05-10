
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


import DAO.CustDAO;

public class formupdate extends JFrame implements ActionListener{
			//Frame
			JFrame frame = new JFrame();
	
			// Panel
			JPanel panel = new JPanel();
			JPanel panel2 = new JPanel();
			
			// Button
			JButton confirmbutton = new JButton("Confirm");
			JButton cancelbutton = new JButton("Back");
			
			// TextField
			JTextField txtkode = new JTextField();
			JTextField txtharga = new JTextField();
			JTextField txtstok = new JTextField();
			
			// Label
			JLabel labelkode = new JLabel("Input Kode Boba : ");
			JLabel labelharga = new JLabel("Input Harga Boba : ");
			JLabel labelstok = new JLabel("Input Stok Boba : ");
			
			// Image
			ImageIcon gambars = new ImageIcon("./src/boba.jpg");
			
			// Customize
			
			
	public formupdate() {
		JTextFieldValid();
		JTextFieldValid2();
		createframes();
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
	
	public void createframes() {
		frame.setTitle("Update Data!");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setIconImage(gambars.getImage());
		GridLayout g1 = new GridLayout(0,2);
		panel2.setLayout(g1);
		panel2.setBackground(new Color(135,206,235));
		panel.setBackground(new Color(135,206,235));
		updatedata();
		frame.setLocation(500,300);
		createlabel();
		createtabs();
		frame.setSize(600,400);
		frame.setVisible(true);
	
	}
	
	public void createlabel() {
		JLabel label = new JLabel("Tabel Database BobaCool");
		
		// Label Customize
		label.setHorizontalAlignment(label.CENTER);
		label.setFont(new Font("Quicksand",Font.ITALIC,25));
		label.setForeground(new Color(199,21,133));
		panel.add(label);
		frame.add(panel);
	}
	
	public void createtabs() {
		CustDAO cust = new CustDAO();
		
		
		Vector<String> columns = new Vector<>();
		columns.add("Kode Boba");
		columns.add("Nama Boba");
		columns.add("Harga Boba");
		columns.add("Stok Boba");
		
		JTable table= new JTable(cust.getCustData(),columns) {
			
			@Override
			public boolean isCellEditable(int row, int column) {
			
				return false;
			}
			public Dimension getPreferredScrollableViewportSize() {
				  return new Dimension(500, getHeight());
			}
			};
		
		table.getTableHeader().setForeground(new Color(47,79,79));
		table.getTableHeader().setFont(new Font("Quicksand",Font.BOLD,14));
		table.getTableHeader().setBackground(new Color(189,183,107));
		table.setFont(new Font("Quicksand",Font.BOLD,14));
		table.setForeground(new Color(205,92,92));
		table.setBackground(new Color(250,250,210));
		table.setAutoResizeMode(HEIGHT);
		JScrollPane sp= new JScrollPane(table);//tabel kita bisa di scroll
		panel.add(sp);
		
		table.getTableHeader().setReorderingAllowed(false);
		frame.add(panel);
		
	}
	
	public void updatedata() {
		// Input
		
		// Kode
		panel2.add(labelkode);
		panel2.add(txtkode);
		
		// Harga
		panel2.add(labelharga);
		panel2.add(txtharga);
		
		// Stok
		panel2.add(labelstok);
		panel2.add(txtstok);
		
		// Button
		panel2.add(confirmbutton);
		panel2.add(cancelbutton);
		
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
		
		// TextField Customize
		txtkode.setBackground(new Color(224,255,255));
		txtkode.setForeground(new Color(244,164,96));
		txtkode.setFont(new Font("Quicksand",Font.BOLD,14));

		txtharga.setBackground(new Color(224,255,255));
		txtharga.setForeground(new Color(244,164,96));
		txtharga.setFont(new Font("Quicksand",Font.BOLD,14));
				
		txtstok.setBackground(new Color(224,255,255));
		txtstok.setForeground(new Color(244,164,96));
	    txtstok.setFont(new Font("Quicksand",Font.BOLD,14));
				
		// Label Customize
		labelkode.setForeground(new Color(46,139,87));
		labelkode.setFont(new Font("Quicksand",Font.BOLD,14));
				
		labelharga.setForeground(new Color(46,139,87));
		labelharga.setFont(new Font("Quicksand",Font.BOLD,14));
				
		labelstok.setForeground(new Color(46,139,87));
		labelstok.setFont(new Font("Quicksand",Font.BOLD,14));
		
		
		// Input Panel
		frame.add(panel2,BorderLayout.NORTH);
		
		// Action Listener
		confirmbutton.addActionListener(this);
		cancelbutton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource().equals(confirmbutton)) {
			int choice = JOptionPane.showConfirmDialog(confirmbutton, "Apakah Anda Yakin Dengan Data Ini?","Confirm",JOptionPane.YES_NO_OPTION);
			switch(choice){
		
				case JOptionPane.YES_OPTION:
				CustDAO cust = new CustDAO();
				cust.UpdateData(txtkode.getText(), txtharga.getText(), txtstok.getText());
				JOptionPane.showMessageDialog(null, "Data telah diupdate dengan keterangan:\n"+"Kode Boba: "+txtkode.getText()+"\nHarga Boba: "+txtharga.getText()+"\nStok Boba: "+txtstok.getText()+"\nBerhasil Diupdate!","Confirmed",JOptionPane.INFORMATION_MESSAGE);
				new main();
				frame.setVisible(false);
				
				break;
				
				case JOptionPane.NO_OPTION:
				JOptionPane.showMessageDialog(null, "Data tidak jadi diupdate!","Canceled",JOptionPane.INFORMATION_MESSAGE);
				frame.setVisible(false);
				new formupdate();
				break;
			}
		}
		else if(e.getSource().equals(cancelbutton)) {
			JOptionPane.showMessageDialog(null, "Kembali ke Menu!","Back To Menu",JOptionPane.INFORMATION_MESSAGE);
			frame.setVisible(false);
			new main();
		}
	}

}
