package semugisha;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
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

public class Exam {

	 JFrame frame;
	private JTextField exntxf;
	private JTextField exdtxf;
	private JTextField subtxf;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exam window = new Exam();
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
	public Exam() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("EXAMINATION         FORM     IN       ONLINE            LEARNING                 PLATFORM       ");
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setBounds(100, 100, 1049, 716);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EXAMINATION FOR IS HERE");
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(25, 10, 869, 55);
		frame.getContentPane().add(lblNewLabel);
		
		exntxf = new JTextField();
		exntxf.setColumns(10);
		exntxf.setBounds(45, 263, 347, 40);
		frame.getContentPane().add(exntxf);
		
		JLabel exnlb = new JLabel("ExaminationName");
		exnlb.setFont(new Font("Tahoma", Font.BOLD, 25));
		exnlb.setBounds(45, 213, 347, 40);
		frame.getContentPane().add(exnlb);
		
		exdtxf = new JTextField();
		exdtxf.setColumns(10);
		exdtxf.setBounds(45, 357, 347, 40);
		frame.getContentPane().add(exdtxf);
		
		JLabel exdlb = new JLabel("ExaminationDate");
		exdlb.setFont(new Font("Tahoma", Font.BOLD, 25));
		exdlb.setBounds(45, 307, 347, 40);
		frame.getContentPane().add(exdlb);
		
		subtxf = new JTextField();
		subtxf.setColumns(10);
		subtxf.setBounds(45, 451, 347, 40);
		frame.getContentPane().add(subtxf);
		
		JLabel sublb = new JLabel("Subject");
		sublb.setFont(new Font("Tahoma", Font.BOLD, 25));
		sublb.setBounds(45, 401, 223, 40);
		frame.getContentPane().add(sublb);
		
		JButton Addbtn = new JButton("ADD");
		Addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_learning_platform","root","");
				String sql="INSERT INTO examination(examination_name,examination_date,subject) VALUES(?,?,?)";
				PreparedStatement st=con.prepareStatement(sql);
				
				st.setString(1, exntxf.getText());
				st.setString(2, exdtxf.getText());
				st.setString(3, subtxf.getText());
				JOptionPane.showMessageDialog(Addbtn, "data saved");
				st.executeUpdate();
				con.close();
				st.close();
				
				
			} catch (Exception e2) {
				// TODO: handle exception
			}	
				
				
				
			}
		});
		Addbtn.setBackground(new Color(255, 255, 128));
		Addbtn.setForeground(new Color(0, 128, 255));
		Addbtn.setFont(new Font("Tahoma", Font.BOLD, 22));
		Addbtn.setBounds(48, 515, 164, 43);
		frame.getContentPane().add(Addbtn);
		
		JButton Viewbtn = new JButton("VIEW");
		Viewbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_learning_platform","root","");	
				String query="SELECT * FROM examination";
				java.sql.Statement st=con.createStatement();
				ResultSet rs=st.executeQuery(query);
				java.sql.ResultSetMetaData rsdm=rs.getMetaData();
				
			DefaultTableModel model=(DefaultTableModel)table.getModel();
			int cols=rsdm.getColumnCount();
			String[]colName=new String[cols];
			for(int i=0;i<cols;i++)
				colName[i]=rsdm.getColumnName(i+1);
				
			model.setColumnIdentifiers(colName);
			String ID,ExaminationName,ExaminationDate,Subject;
			while(rs.next()) 
			{
			ID=rs.getString(1);
			ExaminationName=rs.getString(2);
			ExaminationDate=rs.getString(3);
			Subject=rs.getString(4);
			
			String[]row= {ID,ExaminationName,ExaminationDate,Subject};
			model.addRow(row);
				
				
				
			}	
				
				
				
				
				
				
				
				
			} catch (Exception e2) {
				// TODO: handle exception
			}	
				
				
				
			}
		});
		Viewbtn.setForeground(new Color(0, 128, 255));
		Viewbtn.setFont(new Font("Tahoma", Font.BOLD, 22));
		Viewbtn.setBackground(new Color(255, 255, 128));
		Viewbtn.setBounds(222, 515, 164, 43);
		frame.getContentPane().add(Viewbtn);
		
		JButton Updatebtn = new JButton("UPDATE");
		Updatebtn.setForeground(new Color(0, 128, 255));
		Updatebtn.setFont(new Font("Tahoma", Font.BOLD, 22));
		Updatebtn.setBackground(new Color(255, 255, 128));
		Updatebtn.setBounds(48, 578, 164, 43);
		frame.getContentPane().add(Updatebtn);
		
		JButton Cancelbtn = new JButton("CANCEL");
		Cancelbtn.setForeground(new Color(0, 128, 255));
		Cancelbtn.setFont(new Font("Tahoma", Font.BOLD, 22));
		Cancelbtn.setBackground(new Color(255, 255, 128));
		Cancelbtn.setBounds(222, 578, 164, 43);
		frame.getContentPane().add(Cancelbtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(402, 119, 604, 502);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(0, 128, 255));
		scrollPane.setViewportView(table);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home hm=new Home();
				hm.setVisible(true);
				frame.dispose();
				
				
			}
		});
		btnBack.setForeground(new Color(0, 128, 255));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnBack.setBackground(new Color(255, 255, 128));
		btnBack.setBounds(773, 636, 164, 43);
		frame.getContentPane().add(btnBack);
	}

}
