package main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import DAO.CustDAO;

public class table extends JFrame implements ActionListener{
	
	//Frame
	JFrame frame = new JFrame();
	
	// Button
	JButton exit = new JButton("Exit");
	
	// Image
	ImageIcon gambars = new ImageIcon("./src/boba.jpg");
	
	// JPanel
	JPanel panel = new JPanel();
	JPanel panel2 = new JPanel();
	
	public table() {
		// TODO Auto-generated constructor stub
		createframe();
	}
	
	public void createframe()
	{
		frame.setTitle("Lihat Data!");
		frame.setSize(600,500);
		createcompo();
		createlabel();
		createtable();
		panel.setBackground(new Color(135,206,235));
		panel2.setBackground(new Color(135,206,235));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(gambars.getImage());
		frame.setLocation(450,300);
		frame.setVisible(true);
	}
	
	public void createlabel()
	{
		JLabel label = new JLabel("Tabel Database BobaCool");
		
		// Label Customize
		label.setHorizontalAlignment(label.CENTER);
		label.setFont(new Font("Quicksand",Font.ITALIC,25));
		label.setForeground(new Color(199,21,133));
		panel2.add(label, BorderLayout.NORTH);
		frame.add(panel2);
	}
	
	public void createtable()
	{
		CustDAO cust = new CustDAO();
		
		
		Vector<String> columns = new Vector<>();
		columns.add("Kode Boba");
		columns.add("Nama Boba");
		columns.add("Harga Boba");
		columns.add("Stok Boba");
		
		JTable table= new JTable(cust.getCustData(),columns) {
			
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
			
			public Dimension getPreferredScrollableViewportSize() {
				  return new Dimension(500, getHeight());
			}
			};
		
		// Table Customize
		//setLayout(new BorderLayout());
		
		table.getTableHeader().setForeground(new Color(47,79,79));
		table.getTableHeader().setFont(new Font("Quicksand",Font.BOLD,14));
		table.getTableHeader().setBackground(new Color(189,183,107));
		table.setFont(new Font("Quicksand",Font.BOLD,14));
		table.setForeground(new Color(205,92,92));
		table.setBackground(new Color(250,250,210));
		table.setAutoResizeMode(HEIGHT);
		JScrollPane sp= new JScrollPane(table);
		
		panel2.add(sp);
		
		table.getTableHeader().setReorderingAllowed(false);
		frame.add(panel2);
	}
	
	public void createcompo()
	{
		exit.addActionListener(this);
		
		// Customize
		exit.setBackground(Color.RED);
		exit.setForeground(Color.WHITE);
		exit.setFont(new Font("Quicksand",Font.BOLD,14));
		exit.setOpaque(true);
		
		
		
		// Input Panel to JFrame
		panel.add(exit);
		frame.add(panel,BorderLayout.SOUTH);
	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(exit)) {
			new main();
			frame.setVisible(false);
		}
	}

}
