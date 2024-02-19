package semugisha;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 912, 582);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		setTitle("WELCOME IN E_LEARNING PLATFORM       SYSTEM");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME HOME PAGE");
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(126, 0, 691, 71);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("LECTURE ");
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Lecture log	=new Lecture();
			log.frame.setVisible(true);
			dispose();
			}
		});
		btnNewButton.setForeground(new Color(0, 128, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.setBounds(0, 58, 165, 64);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			CreateAccount acc=new CreateAccount();
			acc.setVisible(true);
			dispose();
				
				
			}
		});
		btnBack.setForeground(new Color(0, 128, 255));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnBack.setBackground(new Color(128, 255, 255));
		btnBack.setBounds(770, 495, 128, 50);
		contentPane.add(btnBack);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login acc=new Login();
				acc.setVisible(true);
				dispose();
			}
		});
		btnLogout.setForeground(new Color(0, 128, 255));
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnLogout.setBackground(new Color(128, 255, 255));
		btnLogout.setBounds(0, 495, 172, 50);
		contentPane.add(btnLogout);
		
		JButton btnStudent = new JButton("STUDENT");
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student st=new Student();
				st.frame.setVisible(true);
				dispose();
			}
		});
		btnStudent.setForeground(new Color(0, 128, 255));
		btnStudent.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnStudent.setBackground(Color.BLACK);
		btnStudent.setBounds(175, 58, 165, 64);
		contentPane.add(btnStudent);
		
		JButton btnCourse = new JButton("COURSE");
		btnCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Courses co=new Courses();
			co.frame.setVisible(true);
			dispose();
				
				
			}
		});
		btnCourse.setForeground(new Color(0, 128, 255));
		btnCourse.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnCourse.setBackground(Color.BLACK);
		btnCourse.setBounds(353, 58, 165, 64);
		contentPane.add(btnCourse);
		
		JButton btnExamination = new JButton("EXAMINATION");
		btnExamination.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Exam ex=new Exam();
				ex.frame.setVisible(true);
				dispose();
			}
		});
		btnExamination.setForeground(new Color(0, 128, 255));
		btnExamination.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnExamination.setBackground(Color.BLACK);
		btnExamination.setBounds(525, 58, 217, 64);
		contentPane.add(btnExamination);
		
		JButton btnHelp = new JButton("HELP");
		btnHelp.setForeground(new Color(0, 128, 255));
		btnHelp.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnHelp.setBackground(Color.BLACK);
		btnHelp.setBounds(752, 58, 136, 64);
		contentPane.add(btnHelp);
	}

}
