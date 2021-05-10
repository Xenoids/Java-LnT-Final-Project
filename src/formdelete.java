import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.border.MatteBorder;

import DAO.CustDAO;

public class formdelete extends JFrame implements ActionListener{

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
	
	public formdelete() {
		// TODO Auto-generated constructor stub
		createframes();
	}
	
	public void createframes() {
		frame.setTitle("Delete Data!");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setIconImage(gambars.getImage());
		GridLayout g1 = new GridLayout(0,2);
		panel2.setLayout(g1);
		createlabel();
		deletedata();
		frame.setLocation(550,450);
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
		frame.add(panel,BorderLayout.NORTH);
	}
	
	public void deletedata(){
		// Input
		
		// Kode
		panel2.add(labelkode);
		panel2.add(txtkode);
		
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
		
		// Label Customize
		labelkode.setForeground(new Color(46,139,87));
		labelkode.setFont(new Font("Quicksand",Font.BOLD,14));
		
		panel.setBackground(new Color(135,206,235));
		panel2.setBackground(new Color(135,206,235));
		frame.add(panel2,BorderLayout.NORTH);
		
		// Action Listener
		confirmbutton.addActionListener(this);
		cancelbutton.addActionListener(this);
		
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
				// TODO Auto-generated method stub
				return false;
			}
			
			public Dimension getPreferredScrollableViewportSize() {
				  return new Dimension(500, getHeight());
			}
			};
		
		// Table Customize
		//table.setBorder(new MatteBorder(4,4,4,4,Color.BLACK));
		table.getTableHeader().setForeground(new Color(47,79,79));
		table.getTableHeader().setFont(new Font("Quicksand",Font.BOLD,14));
		table.getTableHeader().setBackground(new Color(189,183,107));
		table.setFont(new Font("Quicksand",Font.BOLD,14));
		table.setForeground(new Color(205,92,92));
		table.setBackground(new Color(250,250,210));
		table.setAutoResizeMode(HEIGHT);
		JScrollPane sp= new JScrollPane(table);

		panel.add(sp);
		table.getTableHeader().setReorderingAllowed(false);
		frame.add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(confirmbutton)) {
			int choice = JOptionPane.showConfirmDialog(confirmbutton, "Apakah Anda Yakin ingin menghapus Data Ini?","Confirm",JOptionPane.YES_NO_OPTION);
			switch(choice){
		
				case JOptionPane.YES_OPTION:
				CustDAO cust = new CustDAO();
				cust.DeleteData(txtkode.getText());
				JOptionPane.showMessageDialog(null, "Data telah didelete dengan keterangan:\n"+"Kode Boba: "+txtkode.getText()+"\nBerhasil Didelete!","Confirmed",JOptionPane.INFORMATION_MESSAGE);
				new main();
				frame.setVisible(false);
				
				break;
				
				case JOptionPane.NO_OPTION:
				JOptionPane.showMessageDialog(null, "Data tidak jadi didelete!","Canceled",JOptionPane.INFORMATION_MESSAGE);
				frame.setVisible(false);
				new formdelete();
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
