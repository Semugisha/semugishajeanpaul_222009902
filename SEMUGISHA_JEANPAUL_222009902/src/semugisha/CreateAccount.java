package semugisha;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.x.protobuf.MysqlxNotice.Frame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class CreateAccount extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fntxf;
	private JTextField lntxf;
	private JTextField emtxf;
	private JTextField passtxf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccount frame = new CreateAccount();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CreateAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 912, 607);
		contentPane = new JPanel();
		setTitle("CREATE ACCOUNT     IN E_LEANRNING PLATFORM");
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CREATE ACCOUNT");
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 45));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(74, 0, 734, 55);
		contentPane.add(lblNewLabel);
		
		JLabel fnlb = new JLabel("FirstName");
		fnlb.setForeground(new Color(255, 255, 255));
		fnlb.setFont(new Font("Tahoma", Font.ITALIC, 55));
		fnlb.setBounds(10, 103, 296, 66);
		contentPane.add(fnlb);
		
		fntxf = new JTextField();
		fntxf.setColumns(10);
		fntxf.setBounds(316, 105, 374, 64);
		contentPane.add(fntxf);
		
		JLabel lnlb = new JLabel("LastName");
		lnlb.setForeground(new Color(255, 255, 255));
		lnlb.setFont(new Font("Tahoma", Font.ITALIC, 55));
		lnlb.setBounds(10, 186, 296, 64);
		contentPane.add(lnlb);
		
		lntxf = new JTextField();
		lntxf.setColumns(10);
		lntxf.setBounds(316, 189, 374, 66);
		contentPane.add(lntxf);
		
		JLabel emlb = new JLabel("Email");
		emlb.setForeground(new Color(255, 255, 255));
		emlb.setFont(new Font("Tahoma", Font.ITALIC, 55));
		emlb.setBounds(10, 267, 296, 72);
		contentPane.add(emlb);
		
		emtxf = new JTextField();
		emtxf.setColumns(10);
		emtxf.setBounds(316, 272, 374, 72);
		contentPane.add(emtxf);
		
		JLabel Passtxf = new JLabel("PassWord");
		Passtxf.setForeground(new Color(255, 255, 255));
		Passtxf.setFont(new Font("Tahoma", Font.ITALIC, 55));
		Passtxf.setBounds(10, 360, 296, 72);
		contentPane.add(Passtxf);
		
		passtxf = new JTextField();
		passtxf.setColumns(10);
		passtxf.setBounds(316, 362, 374, 70);
		contentPane.add(passtxf);
		
		JButton signupbtn = new JButton("SignUp");
		signupbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_learning_platform","root","");	
				String sql="INSERT INTO siginup(first_name,last_name,email,pass_word)VALUES(?,?,?,?)";
				PreparedStatement st=con.prepareStatement(sql);
				st.setString(1, fntxf.getText());
				st.setString(2, lntxf.getText());
				st.setString(3, emtxf.getText());
				st.setString(4,passtxf.getText());
				JOptionPane.showMessageDialog(signupbtn, "data saved");
				st.executeUpdate();
				con.close();
				st.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}	
				
				
				Login log= new Login();
				log.setVisible(true);
				dispose();
				
			}
		});
		signupbtn.setForeground(new Color(0, 128, 255));
		signupbtn.setFont(new Font("Tahoma", Font.BOLD, 24));
		signupbtn.setBounds(748, 97, 120, 50);
		contentPane.add(signupbtn);
		
		JButton Cancelbtn = new JButton("Cancel");
		Cancelbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fntxf.setText(null);
				lntxf.setText(null);
				emtxf.setText(null);
				passtxf.setText(null);
			}
		});
		Cancelbtn.setForeground(new Color(0, 128, 255));
		Cancelbtn.setFont(new Font("Tahoma", Font.BOLD, 24));
		Cancelbtn.setBounds(748, 169, 120, 50);
		contentPane.add(Cancelbtn);
		
		JButton btnGo = new JButton("GO");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login lo=new Login();
				lo.setVisible(true);
				dispose();	
				
			}
		});
		btnGo.setForeground(new Color(0, 128, 255));
		btnGo.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnGo.setBounds(789, 510, 99, 50);
		contentPane.add(btnGo);
	}
}
