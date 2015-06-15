package frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

import busninesslogic.AdminBL;
import busninesslogic.InstituteTeacherBL;
import busninesslogic.LoginBL;
import busninesslogic.LoginBLService;
import busninesslogic.SchoolTeacherBL;
import busninesslogic.StudentBL;
import busninesslogic.TeacherBL;
import busninesslogic.TeacherBLService;


public class LoginFrame{
	private JPanel imagePanel;	
	private ImageIcon background;	
	private JFrame LoginFrame;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;	
	private JPanel panel_1;
	private JComboBox  comboBox ;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTextField textField;
	private JTextField textField_1;
	LoginBLService loginBL;
	
	public static void main(String[] args){
        new LoginFrame(new LoginBL());
	}
	
	public LoginFrame(LoginBLService loginBL){
		this.loginBL = loginBL;
		LoginFrame = new JFrame();
		LoginFrame.setSize(600,500);
		LoginFrame.setLocation(400,100);
		LoginFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("ͼ��.jpg"));
		LoginFrame.setTitle("��¼����");
		LoginFrame.getContentPane().setLayout(null);
		LoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LoginFrame.setVisible(true);
		
		background = new ImageIcon("12(3).jpg");		
		 JLabel label = new JLabel(background);			
		 label.setBounds(0, 0, background.getIconWidth(),				
				background.getIconHeight());			
		imagePanel = (JPanel)LoginFrame.getContentPane();	
		imagePanel.setOpaque(false);		
		imagePanel.setLayout(null);	
		
		LoginFrame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));

		
		panel = new JPanel();
		panel.setBounds(0, 0, 584, 100);
		panel.setOpaque(false);
		panel.setBackground(new Color(225,120, 205  ));
		LoginFrame.getContentPane().add(panel);		
		panel.setLayout(null);
		panel.setVisible(true);

		lblNewLabel = new JLabel("��ӭ��¼����ϵͳ");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 32));
		lblNewLabel.setBounds(160, 15, 584, 50);
		panel.add(lblNewLabel);
		lblNewLabel.setVisible(true);
		
		panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBackground(Color.white);
		panel_1.setBounds(0, 100,584, 361);
		LoginFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(true);
		
		lblNewLabel_1 = new JLabel("ѧ��/����");
		lblNewLabel_1.setBounds(158, 45, 115, 45);
		lblNewLabel_1.setFont(new Font("����", Font.BOLD, 16));
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setVisible(true);
		
		textField = new JTextField();
		textField.setBounds(283, 50, 168, 30);
		panel_1.add(textField);
		textField.setColumns(10);
		textField.setVisible(true);
		
		lblNewLabel_2 = new JLabel("����");
		lblNewLabel_2.setBounds(158, 127, 115, 45);
		lblNewLabel_2.setFont(new Font("����", Font.BOLD, 16));
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setVisible(true);

		textField_1 = new JPasswordField();
		textField_1.setBounds(283, 140, 168, 30);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setVisible(true);

		lblNewLabel_3 = new JLabel("�û�����");
		lblNewLabel_3.setBounds(158, 218, 115, 45);
		lblNewLabel_3.setFont(new Font("����", Font.BOLD, 16));
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setVisible(true);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"ѧУ������ʦ", "Ժϵ������ʦ", "�ο���ʦ", "ѧ��","����Ա"}));
		comboBox.setBounds(283, 223, 168, 30);
		panel_1.add(comboBox);
		comboBox.setVisible(true);
		
		btnNewButton = new JButton("��¼");
		btnNewButton.setFont(new Font("����", Font.BOLD, 12));
		btnNewButton.setBounds(185, 300, 80, 30);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new LoginListener());
		btnNewButton.setVisible(true);
		
		btnNewButton_1 = new JButton("ע��");
		btnNewButton_1.setFont(new Font("����", Font.BOLD, 12));
		btnNewButton_1.setBounds(330, 300, 80, 30);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new RegisterListener());
		btnNewButton_1.setVisible(true);
		
		LoginFrame.repaint();
		
	}
	
    class LoginListener implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		if(textField.getText().equals("")&&textField_1.getText().equals("")){
    			JDialog infoDialog = new JDialog();
				infoDialog.setSize(200,100);
				infoDialog.setLocation(600,300);
				infoDialog.setVisible(true);
				JLabel infoLabel = new JLabel("����/ѧ�ţ����벻��Ϊ�գ�");
				infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
				infoLabel.setVisible(true);
				infoDialog.add(infoLabel);
    		}else{
    			if(loginBL.isLogin( (String) comboBox.getSelectedItem(),textField.getText(),textField_1.getText())){
        			LoginFrame.dispose();
        			if(comboBox.getSelectedItem().equals("ѧ��")){
        				new StudentMainFrame(textField.getText(),textField_1.getText(),new StudentBL(),new AdminBL());
        			}else if(comboBox.getSelectedItem().equals("�ο���ʦ")){
        				new TeacherMainFrame(textField.getText(),textField_1.getText(),new TeacherBL());
        			}else if(comboBox.getSelectedItem().equals("Ժϵ������ʦ")){
        				new InstituteTeacherMainFrame(textField.getText(),textField_1.getText(),new InstituteTeacherBL(),new AdminBL());
        			}else if(comboBox.getSelectedItem().equals("ѧУ������ʦ")){
        				new SchoolTeacherMainFrame(textField.getText(),textField_1.getText(),new SchoolTeacherBL(),new AdminBL());
        			}else{
        				new AdminMainFrame(new AdminBL());
        			}
        		}else{
        			JDialog infoDialog = new JDialog();
    				infoDialog.setSize(200,100);
    				infoDialog.setLocation(600,300);
    				infoDialog.setVisible(true);
    				JLabel infoLabel = new JLabel("��Ϣ�������������룡");
    				infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
    				infoLabel.setVisible(true);
    				infoDialog.add(infoLabel);
        		}
    		}
    		
    	}   	
	}
    
    class RegisterListener implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		LoginFrame.dispose();
    		new RegisterFrame();
    	}
    }
}