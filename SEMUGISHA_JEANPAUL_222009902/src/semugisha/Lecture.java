package semugisha;

import java.awt.EventQueue;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Lecture {

	 JFrame frame;
	private JTextField fntxf;
	private JTextField lntxf;
	private JTextField sptxf;
	private JTextField ematxf;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lecture window = new Lecture();
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
	public Lecture() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setTitle("		LECTURE           FORM     IN OLINE     LEARNING    PLATFORM   SYSTEM");
		frame.setBounds(100, 100, 949, 686);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LECTURE FORM IS HERE");
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(106, 10, 723, 61);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel fnlb = new JLabel("FirstName");
		fnlb.setFont(new Font("Tahoma", Font.ITALIC, 30));
		fnlb.setBounds(12, 194, 199, 41);
		frame.getContentPane().add(fnlb);
		
		fntxf = new JTextField();
		fntxf.setColumns(10);
		fntxf.setBounds(11, 236, 358, 41);
		frame.getContentPane().add(fntxf);
		
		JLabel lnlb = new JLabel("LastName");
		lnlb.setFont(new Font("Tahoma", Font.ITALIC, 30));
		lnlb.setBounds(12, 280, 199, 41);
		frame.getContentPane().add(lnlb);
		
		lntxf = new JTextField();
		lntxf.setColumns(10);
		lntxf.setBounds(11, 322, 358, 41);
		frame.getContentPane().add(lntxf);
		
		JLabel spelb = new JLabel("Specialization");
		spelb.setFont(new Font("Tahoma", Font.ITALIC, 30));
		spelb.setBounds(13, 365, 199, 41);
		frame.getContentPane().add(spelb);
		
		sptxf = new JTextField();
		sptxf.setColumns(10);
		sptxf.setBounds(12, 407, 358, 41);
		frame.getContentPane().add(sptxf);
		
		JLabel emalb = new JLabel("Email");
		emalb.setFont(new Font("Tahoma", Font.ITALIC, 30));
		emalb.setBounds(13, 451, 199, 41);
		frame.getContentPane().add(emalb);
		
		ematxf = new JTextField();
		ematxf.setColumns(10);
		ematxf.setBounds(12, 493, 358, 41);
		frame.getContentPane().add(ematxf);
		
		JButton addbtn = new JButton("ADD");
		addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_learning_platform","root","");
			String sql="INSERT INTO lecture(first_name,last_name,specialization,email) VALUES(?,?,?,?)";
			PreparedStatement st=con.prepareStatement(sql);
			
			st.setString(1, fntxf.getText());
			st.setString(2, lntxf.getText());
			st.setString(3, sptxf.getText());
			st.setString(4, ematxf.getText());
			
			
			JOptionPane.showMessageDialog(addbtn, "data saved");
			st.executeUpdate();
			con.close();
			st.close();
				
				
				
				
				
				
				
				
				
				
				
			} catch (Exception e2) {
				// TODO: handle exception
			}	
				
				
				
			}
		});
		addbtn.setFont(new Font("Tahoma", Font.BOLD, 23));
		addbtn.setForeground(new Color(0, 128, 255));
		addbtn.setBackground(new Color(255, 255, 0));
		addbtn.setBounds(22, 544, 143, 41);
		frame.getContentPane().add(addbtn);
		
		JButton Viewbtn = new JButton("VIEW");
		Viewbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_learning_platform","root","");	
				String query="SELECT * FROM lecture";
				java.sql.Statement st=con.createStatement();
				ResultSet rs=st.executeQuery(query);
				java.sql.ResultSetMetaData rsdm=rs.getMetaData();
				
			DefaultTableModel model=(DefaultTableModel)table.getModel();
			int cols=rsdm.getColumnCount();
			String[]colName=new String[cols];
			for(int i=0;i<cols;i++)
				colName[i]=rsdm.getColumnName(i+1);
				
			model.setColumnIdentifiers(colName);
			String ID,FirstName,LastName,Email,Age;
			while(rs.next()) 
			{
			ID=rs.getString(1);
			FirstName=rs.getString(2);
			LastName=rs.getString(3);
			Email=rs.getString(4);
			Age=rs.getString(5);
			String[]row= {ID,FirstName,LastName,Email,Age};
			model.addRow(row);
				
				
				
			}	
				
				
				
				
				
				
				
				
				
			} catch (Exception e2) {
				// TODO: handle exception
			}	
				
				
				
				
			}
		});
		Viewbtn.setForeground(new Color(0, 128, 255));
		Viewbtn.setFont(new Font("Tahoma", Font.BOLD, 23));
		Viewbtn.setBackground(Color.YELLOW);
		Viewbtn.setBounds(226, 544, 143, 41);
		frame.getContentPane().add(Viewbtn);
		
		JButton updatebtn = new JButton("UPDATE");
		updatebtn.setForeground(new Color(0, 128, 255));
		updatebtn.setFont(new Font("Tahoma", Font.BOLD, 23));
		updatebtn.setBackground(Color.YELLOW);
		updatebtn.setBounds(22, 595, 143, 41);
		frame.getContentPane().add(updatebtn);
		
		JButton exitbtn = new JButton("EXIT");
		exitbtn.setForeground(new Color(0, 128, 255));
		exitbtn.setFont(new Font("Tahoma", Font.BOLD, 23));
		exitbtn.setBackground(Color.YELLOW);
		exitbtn.setBounds(226, 595, 143, 41);
		frame.getContentPane().add(exitbtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(390, 72, 535, 520);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(0, 128, 255));
		scrollPane.setViewportView(table);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Home ho=new Home();
				ho.setVisible(true);
				frame.dispose();	
				
			}
		});
		btnBack.setForeground(new Color(0, 128, 255));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnBack.setBackground(Color.YELLOW);
		btnBack.setBounds(792, 595, 143, 56);
		frame.getContentPane().add(btnBack);
	}
}
