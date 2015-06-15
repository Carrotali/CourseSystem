package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import busninesslogic.LoginBL;
import busninesslogic.LoginBLService;

public class RegisterFrame {
	private JPanel imagePanel;	
	private ImageIcon background;	
	private JFrame RegisterFrame;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JPanel panel_1;
	private JComboBox  comboBox ;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	LoginBLService loginBL;
	public static void main(String[] args){
        new RegisterFrame();
	}
	
	public RegisterFrame() {
		RegisterFrame = new JFrame();
		RegisterFrame.setSize(600,500);
		RegisterFrame.setLocation(400,100);
		RegisterFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("图标.jpg"));
		RegisterFrame.setTitle("注册界面");
		RegisterFrame.getContentPane().setLayout(null);
		RegisterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		RegisterFrame.setVisible(true);
		background = new ImageIcon("12(3).jpg");		
		JLabel label = new JLabel(background);			
		label.setBounds(0, 0, background.getIconWidth(),				
				background.getIconHeight());			
		imagePanel = (JPanel)RegisterFrame.getContentPane();	
		imagePanel.setOpaque(false);		
		imagePanel.setLayout(null);	
		
		RegisterFrame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));

		
		panel = new JPanel();
		panel.setBounds(0, 0, 584, 100);
		panel.setOpaque(false);
		panel.setBackground(new Color(225,120, 205  ));
		RegisterFrame.getContentPane().add(panel);		
		panel.setLayout(null);
		panel.setVisible(true);

		lblNewLabel = new JLabel("注册教务系统账号");
		lblNewLabel.setFont(new Font("楷体", Font.BOLD, 32));
		lblNewLabel.setBounds(160, 15, 584, 50);
		panel.add(lblNewLabel);
		lblNewLabel.setVisible(true);
		
		panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBackground(Color.white);
		panel_1.setBounds(0, 100,584, 361);
		RegisterFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(true);
		
		lblNewLabel_1 = new JLabel("学号/工号");
		lblNewLabel_1.setBounds(28, 30, 120, 45);
		lblNewLabel_1.setFont(new Font("楷体", Font.BOLD, 16));
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setVisible(true);
		
		textField = new JTextField();
		textField.setBounds(133, 37,100, 25);
		panel_1.add(textField);
		textField.setColumns(10);
		textField.setVisible(true);
		
		lblNewLabel_3 = new JLabel("姓名");
		lblNewLabel_3.setBounds(310, 30, 115, 45);
		lblNewLabel_3.setFont(new Font("楷体", Font.BOLD, 16));
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setVisible(true);

		textField_2 = new JTextField();
		textField_2.setBounds(415, 37, 100, 25);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setVisible(true);
		
		lblNewLabel_2 = new JLabel("密码");
		lblNewLabel_2.setBounds(28, 112, 115, 45);
		lblNewLabel_2.setFont(new Font("楷体", Font.BOLD, 16));
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setVisible(true);

		textField_1 = new JPasswordField();
		textField_1.setBounds(133, 119,100, 25);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setVisible(true);
		
		lblNewLabel_5= new JLabel("确认密码");
		lblNewLabel_5.setBounds(310, 112, 115, 45);
		lblNewLabel_5.setFont(new Font("楷体", Font.BOLD, 16));
		panel_1.add(lblNewLabel_5);
		lblNewLabel_5.setVisible(true);

		textField_3 = new JPasswordField();
		textField_3.setBounds(415, 119, 100, 25);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setVisible(true);
		
		

		lblNewLabel_4 = new JLabel("用户类型");
		lblNewLabel_4.setBounds(28, 195, 115, 45);
		lblNewLabel_4.setFont(new Font("楷体", Font.BOLD, 16));
		panel_1.add(lblNewLabel_4);
		lblNewLabel_4.setVisible(true);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "任课老师","学校教务处老师", "院系教务处老师", "学生"}));
		comboBox.setBounds(133, 202, 100, 30);
		panel_1.add(comboBox);
		comboBox.setVisible(true);
		
		
		lblNewLabel_3 = new JLabel("院系");
		lblNewLabel_3.setBounds(310, 195, 115, 45);
		lblNewLabel_3.setFont(new Font("楷体", Font.BOLD, 16));
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setVisible(true);

		textField_4 = new JTextField();
		textField_4.setBounds(415, 195, 100, 25);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		textField_4.setVisible(true);
		
		lblNewLabel_4 = new JLabel("注册说明"); 
		lblNewLabel_4.setBounds(310, 215, 115, 45);
		lblNewLabel_4.setForeground(new Color(65, 105 ,225  ));
		lblNewLabel_4.setFont(new Font("楷体", Font.BOLD, 13));
		panel_1.add(lblNewLabel_4);
		lblNewLabel_4.setVisible(true);
		
		lblNewLabel_4 = new JLabel("若用户类型为学校教务处老师，");
		lblNewLabel_4.setBounds(310, 230, 300, 45);
		lblNewLabel_4.setForeground(new Color(65, 105 ,225  ));
		lblNewLabel_4.setFont(new Font("楷体", Font.BOLD, 13));
		panel_1.add(lblNewLabel_4);
		lblNewLabel_4.setVisible(true);
		lblNewLabel_4 = new JLabel("则不需要填写院系");
		lblNewLabel_4.setBounds(310, 245, 300, 45);
		lblNewLabel_4.setForeground(new Color(65, 105 ,225  ));
		lblNewLabel_4.setFont(new Font("楷体", Font.BOLD, 13));
		panel_1.add(lblNewLabel_4);

		
		btnNewButton = new JButton("注册");
		btnNewButton.setFont(new Font("楷体", Font.BOLD, 12));
		btnNewButton.setBounds(150, 300, 100, 30);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new RegisterListener());
		btnNewButton.setVisible(true);
		
		btnNewButton_1 = new JButton("登陆");
		btnNewButton_1.setFont(new Font("楷体", Font.BOLD, 12));
		btnNewButton_1.setBounds(300, 300, 100, 30);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new LoginListener());
		btnNewButton_1.setVisible(true);
		
		RegisterFrame.repaint();
		
	}
	
    class RegisterListener implements ActionListener{
    	boolean isRegister = true;
    	public void actionPerformed(ActionEvent e){
    		String id = textField.getText();
    		String password = textField_1.getText();
    		String password2 = textField_3.getText();
    		String name = textField_2.getText();
    		String institute = textField_4.getText();
    		String role = (String) comboBox.getSelectedItem();
    		loginBL = new LoginBL();
    		
    if(password.equals(password2)){
    	//用户类型为学校教务处老师
    	if(role.equals("学校教务处老师")){
    		if(textField.getText().equals("")||textField_1.getText().equals("")||textField_2.getText().equals("")  	
    				||textField_3.getText().equals("")){
    			JDialog infoDialog = new JDialog();
				infoDialog.setSize(200,100);
				infoDialog.setLocation(600,300);
				infoDialog.setVisible(true);
				JLabel infoLabel = new JLabel("信息不完整，请重新填写！");
				infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
				infoLabel.setVisible(true);
				infoDialog.add(infoLabel);
    		}else{  			
    			isRegister=loginBL.register(role, id, name,password,"");
    			if(isRegister){
    	    		RegisterFrame.dispose();
    	    		new LoginFrame(new LoginBL());
    	    	}else{
    	    		JDialog infoDialog = new JDialog();
    				infoDialog.setSize(200,100);
    				infoDialog.setLocation(600,300);
    				infoDialog.setVisible(true);
    				JLabel infoLabel = new JLabel("该用户已存在，请重新注册！");
    				infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
    				infoLabel.setVisible(true);
    				infoDialog.add(infoLabel);
    	    	}
    		}
    	}else{
    		if(textField.getText().equals("")||textField_1.getText().equals("")||textField_2.getText().equals("")  	
    				||textField_3.getText().equals("")||textField_4.getText().equals("")){
    			JDialog infoDialog = new JDialog();
				infoDialog.setSize(200,100);
				infoDialog.setLocation(600,300);
				infoDialog.setVisible(true);
				JLabel infoLabel = new JLabel("信息不完整，请重新填写！");
				infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
				infoLabel.setVisible(true);
				infoDialog.add(infoLabel);
    		}else{
    	     	isRegister=loginBL.register(role, id, name,password,institute);	
    	     	if(isRegister){
    	    		RegisterFrame.dispose();
    	    		new LoginFrame(new LoginBL());
    	    	}else{
    	    		JDialog infoDialog = new JDialog();
    				infoDialog.setSize(200,100);
    				infoDialog.setLocation(600,300);
    				infoDialog.setVisible(true);
    				JLabel infoLabel = new JLabel("该用户已存在，请重新注册！");
    				infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
    				infoLabel.setVisible(true);
    				infoDialog.add(infoLabel);
    	    	}
    		}
    	}    
    }else {//密码不同
    		JDialog infoDialog = new JDialog();
			infoDialog.setSize(200,100);
			infoDialog.setLocation(600,300);
			infoDialog.setVisible(true);
			JLabel infoLabel = new JLabel("两次密码不相同，请重新输入！");
			infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
			infoLabel.setVisible(true);
			infoDialog.add(infoLabel);
    	}
	}
}
    
    class LoginListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			RegisterFrame.dispose();
    		new LoginFrame(new LoginBL());
		}
    	
    }
}