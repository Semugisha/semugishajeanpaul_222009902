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
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Courses {

 JFrame frame;
	private JTextField cntxf;
	private JTextField intxf;
	private JTextField dttxf;
	private JTextField cretxf;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Courses window = new Courses();
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
	public Courses() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("COURSES FORM IN LEARNING PLATFORM");
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setBounds(100, 100, 764, 730);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("COURSE FORM IS HERE");
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(25, 10, 625, 58);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel cnlb = new JLabel("CourseName");
		cnlb.setFont(new Font("Tahoma", Font.BOLD, 18));
		cnlb.setBounds(25, 218, 144, 37);
		frame.getContentPane().add(cnlb);
		
		cntxf = new JTextField();
		cntxf.setColumns(10);
		cntxf.setBounds(25, 258, 333, 38);
		frame.getContentPane().add(cntxf);
		
		intxf = new JTextField();
		intxf.setColumns(10);
		intxf.setBounds(25, 346, 333, 38);
		frame.getContentPane().add(intxf);
		
		JLabel inlb = new JLabel("Instructor");
		inlb.setFont(new Font("Tahoma", Font.BOLD, 18));
		inlb.setBounds(25, 306, 144, 37);
		frame.getContentPane().add(inlb);
		
		JLabel dtlb = new JLabel("DescriptionText");
		dtlb.setFont(new Font("Tahoma", Font.BOLD, 18));
		dtlb.setBounds(25, 397, 183, 37);
		frame.getContentPane().add(dtlb);
		
		dttxf = new JTextField();
		dttxf.setColumns(10);
		dttxf.setBounds(25, 437, 333, 38);
		frame.getContentPane().add(dttxf);
		
		JLabel crelb = new JLabel("Credit");
		crelb.setFont(new Font("Tahoma", Font.BOLD, 18));
		crelb.setBounds(25, 481, 183, 37);
		frame.getContentPane().add(crelb);
		
		cretxf = new JTextField();
		cretxf.setColumns(10);
		cretxf.setBounds(25, 521, 333, 38);
		frame.getContentPane().add(cretxf);
		
		JButton addlb = new JButton("ADD");
		addlb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_learning_platform","root","");
					String sql="INSERT INTO course(course_name,instructor,description_text,credit) VALUES(?,?,?,?)";
					
				PreparedStatement st=con.prepareStatement(sql);
				
				st.setString(1, cntxf.getText());
				st.setString(2,intxf.getText());
				st.setString(3, dttxf.getText());
				st.setString(4, cretxf.getText());
				st.executeUpdate();
				JOptionPane.showMessageDialog(addlb, "Data saved!!");
				
				con.close();
				st.close();
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		addlb.setBackground(new Color(255, 255, 128));
		addlb.setForeground(new Color(0, 128, 255));
		addlb.setFont(new Font("Tahoma", Font.BOLD, 18));
		addlb.setBounds(85, 593, 88, 37);
		frame.getContentPane().add(addlb);
		
		JButton viewbtn = new JButton("VIEW");
		viewbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");	
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_learning_platform","root","");
				java.sql.Statement st=con.createStatement();
				String query="SELECT * FROM course";
				
				ResultSet rs=st.executeQuery(query);
				java.sql.ResultSetMetaData rsdm=rs.getMetaData();
				
			DefaultTableModel model=(DefaultTableModel)table.getModel();
			int cols=rsdm.getColumnCount();
			String[]colName=new String[cols];
			for(int i=0;i<cols;i++)
				colName[i]=rsdm.getColumnName(i+1);
				
			model.setColumnIdentifiers(colName);
			String ID,courseName,instructor,description_text,credit;
			while(rs.next()) 
			{
			ID=rs.getString(1);
			courseName=rs.getString(2);
			instructor=rs.getString(3);
			description_text=rs.getString(4);
			credit=rs.getString(5);
			String[]row= {ID,courseName,instructor,description_text,credit};
			model.addRow(row);
				
				
				
			}	
				
				
				
				
			} catch (Exception e2) {
				// TODO: handle exception
			}	
				
				
				
			}
		});
		viewbtn.setForeground(new Color(0, 128, 255));
		viewbtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		viewbtn.setBackground(new Color(255, 255, 128));
		viewbtn.setBounds(79, 634, 107, 37);
		frame.getContentPane().add(viewbtn);
		
		JButton cancelbtn = new JButton("CANCEL");
		cancelbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			cntxf.setText(null);
			intxf.setText(null);
			dttxf.setText(null);
			cretxf.setText(null);
				
				
			}
		});
		cancelbtn.setForeground(new Color(0, 128, 255));
		cancelbtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		cancelbtn.setBackground(new Color(255, 255, 128));
		cancelbtn.setBounds(240, 635, 118, 37);
		frame.getContentPane().add(cancelbtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(379, 144, 361, 486);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(0, 128, 255));
		scrollPane.setViewportView(table);
		
		JButton Updatebtn = new JButton("UPDATE");
		Updatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_learning_platform","root","");
				String sql="UPDATE course SET course_name=?,instructor=?,description_text=?,credit=? WHERE course_id=?";	
				PreparedStatement st=con.prepareStatement(sql);
				st.setString(1, cntxf.getText());
				st.setString(2,intxf.getText());
				st.setString(3, dttxf.getText());
				st.setString(4, cretxf.getText());
				
				JOptionPane.showMessageDialog(Updatebtn, "Data changed!!");
				st.executeUpdate();
				con.close();
				st.close();
				
				
				
			} catch (Exception e2) {
				// TODO: handle exception
			}	
				
				
			}
		});
		Updatebtn.setForeground(new Color(0, 128, 255));
		Updatebtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		Updatebtn.setBackground(new Color(255, 255, 128));
		Updatebtn.setBounds(241, 587, 118, 37);
		frame.getContentPane().add(Updatebtn);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home hm=new Home();
				hm.setVisible(true);
				frame.dispose();
			}
		});
		btnBack.setForeground(new Color(0, 128, 255));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBackground(new Color(255, 255, 128));
		btnBack.setBounds(616, 645, 134, 48);
		frame.getContentPane().add(btnBack);
	}
}
