package semugisha;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
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

public class Student {

	 JFrame frame;
	private JTextField fntxf;
	private JTextField lntxf;
	private JTextField emtxf;
	private JTextField agetxf;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student window = new Student();
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
	public Student() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Dialog", Font.ITALIC, 45));
		frame.setTitle("STUDENT              FORM    IN     LEARNING    PLATFORM");		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setBounds(100, 100, 998, 776);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("STUDENT FORM IS HERE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(92, 0, 790, 68);
		frame.getContentPane().add(lblNewLabel);
		
		fntxf = new JTextField();
		fntxf.setColumns(10);
		fntxf.setBounds(23, 164, 350, 41);
		frame.getContentPane().add(fntxf);
		
		JLabel fnlb = new JLabel("FirstName");
		fnlb.setFont(new Font("Dialog", Font.ITALIC, 45));
		fnlb.setBounds(24, 113, 165, 41);
		frame.getContentPane().add(fnlb);
		
		lntxf = new JTextField();
		lntxf.setColumns(10);
		lntxf.setBounds(22, 269, 351, 41);
		frame.getContentPane().add(lntxf);
		
		JLabel lnlb = new JLabel("LastName");
		lnlb.setFont(new Font("Dialog", Font.ITALIC, 45));
		lnlb.setBounds(23, 218, 165, 41);
		frame.getContentPane().add(lnlb);
		
		emtxf = new JTextField();
		emtxf.setColumns(10);
		emtxf.setBounds(22, 363, 351, 41);
		frame.getContentPane().add(emtxf);
		
		JLabel emlb = new JLabel("Email");
		emlb.setFont(new Font("Dialog", Font.ITALIC, 45));
		emlb.setBounds(23, 312, 165, 41);
		frame.getContentPane().add(emlb);
		
		agetxf = new JTextField();
		agetxf.setColumns(10);
		agetxf.setBounds(23, 457, 350, 41);
		frame.getContentPane().add(agetxf);
		
		JLabel agelb = new JLabel("Age");
		agelb.setFont(new Font("Dialog", Font.ITALIC, 45));
		agelb.setBounds(24, 406, 165, 41);
		frame.getContentPane().add(agelb);
		
		JButton addbtn = new JButton("ADD");
		addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_learning_platform","root","");
				String sql="INSERT INTO student(first_name,last_name,email,age) VALUES(?,?,?,?)";
				PreparedStatement st=con.prepareStatement(sql);
				
				st.setString(1, fntxf.getText());
				st.setString(2, lntxf.getText());
				st.setString(3, emtxf.getText());
				st.setString(4, agetxf.getText());
				JOptionPane.showMessageDialog(addbtn, "data saved!!");
				st.executeUpdate();
				con.close();
				st.close();
				
				
				
			} catch (Exception e2) {
				// TODO: handle exception
			}	
				
				
			}
		});
		addbtn.setFont(new Font("Tahoma", Font.BOLD, 24));
		addbtn.setBackground(new Color(255, 255, 128));
		addbtn.setForeground(new Color(0, 128, 255));
		addbtn.setBounds(40, 528, 148, 41);
		frame.getContentPane().add(addbtn);
		
		JButton viewbtn = new JButton("VIEW");
		viewbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_learning_platform","root","");	
				String query="SELECT * FROM student";
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
		viewbtn.setFont(new Font("Tahoma", Font.BOLD, 24));
		viewbtn.setForeground(new Color(0, 128, 255));
		viewbtn.setBackground(new Color(255, 255, 128));
		viewbtn.setBounds(222, 528, 151, 41);
		frame.getContentPane().add(viewbtn);
		
		JButton Updatebtn = new JButton("UPDATE");
		Updatebtn.setFont(new Font("Tahoma", Font.BOLD, 24));
		Updatebtn.setForeground(new Color(0, 128, 255));
		Updatebtn.setBackground(new Color(255, 255, 128));
		Updatebtn.setBounds(40, 579, 148, 41);
		frame.getContentPane().add(Updatebtn);
		
		JButton Cancelbtn = new JButton("CANCEL");
		Cancelbtn.setFont(new Font("Tahoma", Font.BOLD, 24));
		Cancelbtn.setForeground(new Color(0, 128, 255));
		Cancelbtn.setBackground(new Color(255, 255, 128));
		Cancelbtn.setBounds(222, 579, 151, 41);
		frame.getContentPane().add(Cancelbtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(383, 103, 580, 553);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(0, 128, 255));
		scrollPane.setViewportView(table);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home hm=new Home();
				hm.setVisible(true);
				frame.dispose();
			}
		});
		btnBack.setForeground(new Color(0, 128, 255));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnBack.setBackground(new Color(255, 255, 128));
		btnBack.setBounds(787, 670, 148, 41);
		frame.getContentPane().add(btnBack);
	}
}
