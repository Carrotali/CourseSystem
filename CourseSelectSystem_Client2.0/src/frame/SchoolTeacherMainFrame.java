package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import busninesslogic.AdminBL;
import busninesslogic.AdminBLService;
import busninesslogic.LoginBL;
import busninesslogic.SchoolTeacherBL;
import busninesslogic.SchoolTeacherBLService;

public class SchoolTeacherMainFrame /*extends MyFrame*/{
	//private ImageIcon background;
	private JFrame SchoolTeacherFrame;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JScrollPane scrollPane;
	private MyButton btnNewButton;
	private MyButton btnNewButton_1;
	private MyButton btnNewButton_2;
	private MyButton btnNewButton_3;
	private MyButton btnNewButton_4;
	private MyButton btnNewButton_5;
	private MyButton btnNewButton_6;
	private JPanel panelNow;
	private JTextField newPasswordField;
	private JTextField newPasswordField1;
	private JTextField newPasswordField2;
	private JTextField textField;
	private JComboBox<String> comboBox;
	private MyTable table;
	public static SchoolTeacherBLService schoolTeacherBL;
    private String ID;
    private String password;
	private AdminBLService adminBL;
	public static void main(String[] args){
        new SchoolTeacherMainFrame("30001","111111",new SchoolTeacherBL(),new AdminBL());
        
	}
	
	@SuppressWarnings("static-access")
	public SchoolTeacherMainFrame(String ID,String password,SchoolTeacherBLService SchoolTeacherBL,AdminBLService adminBL) {
		this.schoolTeacherBL = SchoolTeacherBL;
		this.adminBL= adminBL;
    	this.ID = ID;
    	this.password = password;
		SchoolTeacherFrame = new JFrame();
		SchoolTeacherFrame.setSize(800,500);
		SchoolTeacherFrame.setLocation(300,100);
		SchoolTeacherFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("����Ա.jpg"));
		SchoolTeacherFrame.setTitle("ѧУ������ʦ������");
		SchoolTeacherFrame.getContentPane().setLayout(null);
		SchoolTeacherFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SchoolTeacherFrame.setVisible(true);
		
		panel_2 = new MyPanel();
		panel_2.setBackground(Color.white);
		panel_2.setBounds(0, 0, 80, 80);
		SchoolTeacherFrame.getContentPane().add(panel_2);
		
		panel = new JPanel();
		panel.setBackground(new Color(199, 0, 133 ));
		panel.setBounds(0, 0, 820, 70);
		SchoolTeacherFrame.getContentPane().add(panel);
		panel.setVisible(true);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("��ӭ"+schoolTeacherBL.checkSelfInfor(ID)[1]+"��ʦ��");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("�±�ֱ������ֿ�", Font.PLAIN, 24));
		lblNewLabel.setBounds(80, 10, 425, 45);
		panel.add(lblNewLabel);
		lblNewLabel.setVisible(true);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(199, 0, 133 ));
		panel_1.setForeground(Color.WHITE);
		panel_1.setBounds(0, 70, 170, 400);
		SchoolTeacherFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(true);
		
		btnNewButton = new MyButton("���������ܲ���");
		btnNewButton.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		btnNewButton.setBounds(10, 25, 150, 35);
		btnNewButton.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton.setBackground(new Color(199, 0, 133 ));
		btnNewButton.setForeground(Color.white);
		btnNewButton.setVisible(true);
		btnNewButton.addActionListener(new PublishCourseListener());
		panel_1.add(btnNewButton);
		
		btnNewButton_1 = new MyButton("�鿴��Ժ��ѧ�ƻ�");
		btnNewButton_1.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		btnNewButton_1.setBounds(10, 75, 150, 35);
		btnNewButton_1.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_1.setBackground(new Color(199, 0, 133 ));
		btnNewButton_1.setForeground(Color.white);
		btnNewButton_1.setVisible(true);
		btnNewButton_1.addActionListener(new CheckPlanListener());
		panel_1.add(btnNewButton_1);
		
		btnNewButton_2 = new MyButton("�鿴��ʦͳ����Ϣ");
		btnNewButton_2.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		btnNewButton_2.setBounds(10, 125, 150, 35);
		btnNewButton_2.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_2.setBackground(new Color(199, 0, 133 ));
		btnNewButton_2.setForeground(Color.white);
		btnNewButton_2.setVisible(true);
		btnNewButton_2.addActionListener(new CheckThInfroListener());
		panel_1.add(btnNewButton_2);
		
		btnNewButton_3 = new MyButton("�鿴�γ�ͳ����Ϣ");
		btnNewButton_3.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		btnNewButton_3.setBounds(10, 175, 150, 35);
		btnNewButton_3.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_3.setBackground(new Color(199, 0, 133 ));
		btnNewButton_3.setForeground(Color.white);
		btnNewButton_3.setVisible(true);
		btnNewButton_3.addActionListener(new CheckCoInfroListener());
		panel_1.add(btnNewButton_3);
		
		btnNewButton_4 = new MyButton("�鿴ѧ��ͳ����Ϣ");
		btnNewButton_4.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		btnNewButton_4.setBounds(10, 225, 150, 35);
		btnNewButton_4.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_4.setBackground(new Color(199, 0, 133 ));
		btnNewButton_4.setForeground(Color.white);
		btnNewButton_4.setVisible(true);
		btnNewButton_4.addActionListener(new CheckStInfroListener());
		panel_1.add(btnNewButton_4);
		
		btnNewButton_5 = new MyButton("�޸�����");
		btnNewButton_5.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		btnNewButton_5.setBounds(10, 275, 150, 35);
		btnNewButton_5.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_5.setBackground(new Color(199, 0, 133 ));
		btnNewButton_5.setForeground(Color.white);
		btnNewButton_5.setVisible(true);
		btnNewButton_5.addActionListener(new ChangePasswordListener());
		panel_1.add(btnNewButton_5);
		
		btnNewButton_6 = new MyButton("ע��");
		btnNewButton_6.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		btnNewButton_6.setBounds(10, 325, 150, 35);
		btnNewButton_6.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_6.setBackground(new Color(199, 0, 133 ));
		btnNewButton_6.setForeground(Color.white);
		btnNewButton_6.setVisible(true);
		btnNewButton_6.addActionListener(new LogoutListener());
		panel_1.add(btnNewButton_6);
				
		panelNow = new XPanel();
		panelNow.setBackground(Color.white);
		panelNow.setBounds(170, 70, 614, 400);
		SchoolTeacherFrame.getContentPane().add(panelNow);		
		panelNow.setVisible(true);
		
		SchoolTeacherFrame.repaint();
		
		
	}
	
	//�ƶ������ܲ���
    class MakePolicyListener implements ActionListener{
    	JTextField textField;
    	JTextField textField_1;
    	JTextField textField_2;
    	JTextField textField_3;
    	JTextField textField_4;
    	JTextField textField_5;
    	JTextField textField_6;
    	JTextField textField_7;
    	JTextField textField_8;
    	JTextField textField_9;
    	JTextField textField_10;
    	JTextField textField_11;
    	MyButton policyOKButton;
	    public void actionPerformed(ActionEvent e){
	    	if(adminBL.getAbleToChangePolicy()){
	    		SchoolTeacherFrame.remove(panelNow);
		    	SchoolTeacherFrame.setTitle("ѧУ������ʦ�������������ܲ���");
				JPanel Panel = new JPanel();
				Panel.setSize(614, 400);
				Panel.setLocation(170, 70);
				Panel.setBackground(Color.white);
				Panel.setVisible(true);
	 			Panel.setLayout(null);
		    	
	 			MyButton button = new MyButton("����ͨʶͨ�޿γ�");
				button.setFont(new Font("΢���ź�", Font.PLAIN, 12));
				button.setBounds(0, 0, 315, 23);
				Panel.add(button);
				button.addActionListener(new PublishCourseListener());
				button.setVisible(true);
				
				MyButton button2 = new MyButton("�ƶ������ܲ���");
				button2.setFont(new Font("΢���ź�", Font.PLAIN, 12));
				button2.setBounds(300, 0, 315, 23);
				Panel.add(button2);
				button2.addActionListener(new MakePolicyListener());
				button.setVisible(true);
				
				
				
				JLabel lblNewLabel_1 = new JLabel("ѧ��רҵ�γ�");
				lblNewLabel_1.setFont(new Font("΢���ź�", Font.PLAIN, 16));
				lblNewLabel_1.setBounds(50, 60, 150, 35);
				Panel.add(lblNewLabel_1);
				lblNewLabel_1.setVisible(true);
				
				JLabel lblNewLabel_2 = new JLabel("רҵѡ�޿γ�");
				lblNewLabel_2.setFont(new Font("΢���ź�", Font.PLAIN, 16));
				lblNewLabel_2.setBounds(50, 100, 150, 35);
				Panel.add(lblNewLabel_2);
				lblNewLabel_2.setVisible(true);
				
				JLabel lblNewLabel_3 = new JLabel("��רҵѡ�޿γ�");
				lblNewLabel_3.setFont(new Font("΢���ź�", Font.PLAIN, 16));
				lblNewLabel_3.setBounds(50, 140, 150, 35);
				Panel.add(lblNewLabel_3);
				lblNewLabel_3.setVisible(true);
				
				JLabel lblNewLabel_4 = new JLabel("����ѡ�޿γ�");
				lblNewLabel_4.setFont(new Font("΢���ź�", Font.PLAIN, 16));
				lblNewLabel_4.setBounds(50, 180, 150, 35);
				Panel.add(lblNewLabel_4);
				lblNewLabel_4.setVisible(true);
				
				JLabel lblNewLabel_5 = new JLabel("�ڶ�����");
				lblNewLabel_5.setFont(new Font("΢���ź�", Font.PLAIN, 16));
				lblNewLabel_5.setBounds(50, 220, 150, 35);
				Panel.add(lblNewLabel_5);
				lblNewLabel_5.setVisible(true);
				
				JLabel lblNewLabel_6 = new JLabel("��ҵ�������");
				lblNewLabel_6.setFont(new Font("΢���ź�", Font.PLAIN, 16));
				lblNewLabel_6.setBounds(50, 260, 150, 35);
				Panel.add(lblNewLabel_6);
				lblNewLabel_6.setVisible(true);
				
				JLabel lblNewLabel_7 = new JLabel("����ѧ��");
				lblNewLabel_7.setFont(new Font("΢���ź�", Font.PLAIN, 16));
				lblNewLabel_7.setBounds(220, 30, 150, 35);
				Panel.add(lblNewLabel_7);
				lblNewLabel_7.setVisible(true);
				
				JLabel lblNewLabel_8 = new JLabel("����ѧ��");
				lblNewLabel_8.setFont(new Font("΢���ź�", Font.PLAIN, 16));
				lblNewLabel_8.setBounds(400, 30, 150, 35);
				Panel.add(lblNewLabel_8);
				lblNewLabel_8.setVisible(true);
			
				
				textField = new JTextField();
				textField.setBounds(220, 70, 100, 20);
				Panel.add(textField);
				textField.setColumns(10);
				
				textField_1 = new JTextField();
				textField_1.setBounds(220, 110, 100, 20);
				Panel.add(textField_1);
				textField_1.setColumns(10);
				
				
			    textField_2 = new JTextField();
				textField_2.setBounds(220, 150, 100, 20);
				Panel.add(textField_2);
				textField_2.setColumns(10);
				
				textField_3 = new JTextField();
				textField_3.setBounds(220, 190, 100, 20);
				Panel.add(textField_3);
				textField_3.setColumns(10);
				
				textField_4 = new JTextField();
				textField_4.setBounds(220, 230, 100, 20);
				Panel.add(textField_4);
				textField_4.setColumns(10);
				
				textField_5 = new JTextField();
				textField_5.setBounds(220, 270, 100, 20);
				Panel.add(textField_5);
				textField_5.setColumns(10);
				
				textField_6 = new JTextField();
				textField_6.setBounds(400, 70, 100, 20);
				Panel.add(textField_6);
				textField_6.setColumns(10);
				
				textField_7 = new JTextField();
				textField_7.setBounds(400, 110, 100, 20);
				Panel.add(textField_7);
				textField_7.setColumns(10);
				
				textField_8 = new JTextField();
				textField_8.setBounds(400, 150, 100, 20);
				Panel.add(textField_8);
				textField_8.setColumns(10);
				
				textField_9 = new JTextField();
				textField_9.setBounds(400, 190, 100, 20);
				Panel.add(textField_9);
				textField_9.setColumns(10);
				
				textField_10 = new JTextField();
				textField_10.setBounds(400, 230, 100, 20);
				Panel.add(textField_10);
				textField_10.setColumns(10);
				
				textField_11 = new JTextField();
				textField_11.setBounds(400, 270, 100, 20);
				Panel.add(textField_11);
				textField_11.setColumns(10);
				
				
				policyOKButton = new MyButton("ȷ��");
				policyOKButton.setBounds(205, 320, 93, 33);
				Panel.add(policyOKButton);
				policyOKButton.addActionListener(new policyOkButtonListener());
				
				
				SchoolTeacherFrame.setLayout(null);
				panelNow=Panel;
				SchoolTeacherFrame.add(panelNow);
				SchoolTeacherFrame.repaint();
	    	}else{
	    		new NoticePanel(new String[]{"���ɸ��ģ�"},null,SchoolTeacherFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
	    	}
	    	
	    }
	    
	    
	    class policyOkButtonListener implements ActionListener{
	    	public void actionPerformed(ActionEvent e){
	    		if(textField_1.getText().equals("")||textField_2.getText().equals("")||textField_3.getText().equals("")||
		    			textField_4.getText().equals("")||textField_6.getText().equals("")||textField_7.getText().equals("")||
		    			textField_8.getText().equals("")||textField_9.getText().equals("")||
		    			textField_10.getText().equals("")||textField_11.getText().equals("")||
		    			textField.getText().equals("")){
	    			new NoticePanel(new String[]{"��ܲ��Բ�������"},null,SchoolTeacherFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
		    	}
		    	else {
	    		String[]policy=new String [6];    		
	    		policy[0] = "ѧ��רҵ�γ�;"+textField.getText()+";"+textField_6.getText();
	    		policy[1] = "רҵѡ�޿γ�;"+textField_1.getText()+";"+textField_7.getText();
	    		policy[2] = "��רҵѡ�޿γ�;"+textField_2.getText()+";"+textField_8.getText();
	    		policy[3] = "����ѡ�޿γ�;"+textField_3.getText()+";"+textField_9.getText();
	    		policy[4] = "�ڶ�����;"+textField_4.getText()+";"+textField_10.getText();
	    		policy[5] = "��ҵ�������;"+textField_5.getText()+";"+textField_11.getText();
	    		schoolTeacherBL.publishOverAllPolicy(policy);
	    		policyOKButton.setVisible(false);
	    		SchoolTeacherFrame.remove(policyOKButton);
				SchoolTeacherFrame.repaint();
	    	   }
	    	}
	    }
	    
    }
	    	    
    //����ͨʶͨ�޿γ�
    class PublishCourseListener implements ActionListener{
	    		JTextField textField_1;
	    		JTextField textField_2;
	    		JTextField textField_3;
	    		JTextField textField_4;
	    		JTextField textField_6;
	    		JTextField textField_7;
	    		JTextField textField_8;
	    		JTextField textField_9;
	    		    		
	     public void actionPerformed(ActionEvent e){
	    	    if(adminBL.getAbleToChangePolicy()){
	    	    	SchoolTeacherFrame.remove(panelNow);
			    	SchoolTeacherFrame.setTitle("ѧУ������ʦ�������������ܲ���");
					JPanel Panel = new JPanel();
					Panel.setSize(614, 400);
					Panel.setLocation(170, 70);
					Panel.setBackground(Color.white);
//					Panel.setBackground(new Color(255 ,255, 224 ));
//					Panel.setBorder(new LineBorder(new Color(0, 0, 0)));
					Panel.setVisible(true);
		 			Panel.setLayout(null);
			    	
		 			MyButton button = new MyButton("����ͨʶͨ�޿γ�");
					button.setFont(new Font("΢���ź�", Font.PLAIN, 12));
					button.setBounds(0, 0, 315, 23);
					Panel.add(button);
					button.addActionListener(new PublishCourseListener());
					button.setVisible(true);
					
					MyButton button2 = new MyButton("�ƶ������ܲ���");
					button2.setFont(new Font("΢���ź�", Font.PLAIN, 12));
					button2.setBounds(300, 0, 315, 23);
					Panel.add(button2);
					button2.addActionListener(new MakePolicyListener());
					button.setVisible(true);

				
				JLabel lblNewLabel_1 = new JLabel("ͨʶͨ�޿γ�");
				lblNewLabel_1.setFont(new Font("΢���ź�", Font.PLAIN, 16));
				lblNewLabel_1.setBounds(35, 26, 150, 35);
				Panel.add(lblNewLabel_1);
				lblNewLabel_1.setVisible(true);
				
				String[] columnTitle=new String[] {"���","Ժϵ","����","ѧ��","ѧ��","ʱ��","�ص�","��ʦ"};
				String[][]temp=schoolTeacherBL.checkCourseForAll("");
				for(int i=0;i<temp.length;i++)
					for(int j=0;j<8;j++){
						temp[i][j] = temp[i][j+1];
					}
	  		    table = new MyTable(temp,columnTitle,SchoolTeacherFrame,544,150,false);	

	  		    scrollPane = table.getScrollPane();//�������������
				scrollPane.setBounds(37,55,544,150);
	 		    scrollPane.setVisible(true);
	 		    Panel.add(scrollPane);
		
				//����ͨʶͨ�޿γ�
				JLabel lblNewLabel_21 = new JLabel("�γ̱��");
				lblNewLabel_21.setBounds(60, 230, 100, 15);
				Panel.add(lblNewLabel_21);
				
				JLabel lblNewLabel_3 = new JLabel("����Ժϵ");
				lblNewLabel_3.setBounds(60, 255, 100, 15);
				Panel.add(lblNewLabel_3);
				
				JLabel lblNewLabel = new JLabel("�γ�����");
				lblNewLabel.setBounds(60, 280, 100, 15);
				Panel.add(lblNewLabel);
				
				JLabel lblNewLabel_5 = new JLabel("����ѧ��");
				lblNewLabel_5.setBounds(60, 305, 100, 15);
				Panel.add(lblNewLabel_5);
				
				
				textField_1 = new JTextField();
				textField_1.setBounds(145, 227, 90, 20);
				Panel.add(textField_1);
				textField_1.setColumns(10);
				
			    textField_2 = new JTextField();
				textField_2.setBounds(145, 252, 90, 20);
				Panel.add(textField_2);
				textField_2.setColumns(10);
				
				textField_3 = new JTextField();
				textField_3.setBounds(145, 277, 90, 20);
				Panel.add(textField_3);
				textField_3.setColumns(10);
				
			    textField_4 = new JTextField();
				textField_4.setBounds(145, 302, 90, 20);
				Panel.add(textField_4);
				textField_4.setColumns(10);
				
				
				
				JLabel label_1 = new JLabel("�Ͽ�ѧ��");
				label_1.setBounds(260, 230, 100, 15);
				Panel.add(label_1);
				
				JLabel label_2 = new JLabel("�Ͽ�ʱ��");
				label_2.setBounds(260, 255, 100, 15);
				Panel.add(label_2);
				
				JLabel label_3 = new JLabel("�Ͽεص�");
				label_3.setBounds(260, 280, 100, 15);
				Panel.add(label_3);
				
				JLabel label_4 = new JLabel("�ον�ʦ");
				label_4.setBounds(260, 305, 100, 15);
				Panel.add(label_4);
			
				
				
			    textField_6 = new JTextField();
				textField_6.setBounds(345, 227, 90, 20);
				Panel.add(textField_6);
				textField_6.setColumns(10);
				
				textField_7 = new JTextField();
				textField_7.setBounds(345, 252, 90, 20);
				Panel.add(textField_7);
				textField_7.setColumns(10);
				
				textField_8 = new JTextField();
				textField_8.setBounds(345, 277, 90, 20);
				Panel.add(textField_8);
				textField_8.setColumns(10);
				
				textField_9 = new JTextField();
				textField_9.setBounds(345, 302, 90, 20);
				Panel.add(textField_9);
				textField_9.setColumns(10);
				
				textField_1.setText("");
	     		textField_2.setText("");
	     		textField_3.setText("");
	     		textField_4.setText("");
	     		textField_6.setText("");
	     		textField_7.setText("");
	     		textField_8.setText("");
	     		textField_9.setText("");
				
				MyButton button_5 = new MyButton("ȷ��");
				button_5.setBounds(255, 340, 73, 23);
				Panel.add(button_5);
				button_5.addActionListener(new publishCourseForAllOkButtonListener());
				
				
				SchoolTeacherFrame.setLayout(null);
				panelNow=Panel;
				SchoolTeacherFrame.add(panelNow);
				SchoolTeacherFrame.repaint();
	 			
	    	    }else{
	    	    	new NoticePanel(new String[]{"���ɸ��ģ�"},null,SchoolTeacherFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
	    	    }
	    	    
	    }
	     class publishCourseForAllOkButtonListener implements ActionListener{
	    	public void actionPerformed(ActionEvent e) {
	    	if(textField_1.getText().equals("")||textField_2.getText().equals("")||textField_3.getText().equals("")||
	    			textField_4.getText().equals("")||textField_6.getText().equals("")||textField_7.getText().equals("")||
	    			textField_8.getText().equals("")||textField_9.getText().equals("")){
	    		new NoticePanel(new String[]{"�γ���Ϣ��������"},null,SchoolTeacherFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
	    	}
	    	else {
	    		    
	    			String s = "ͨʶͨ�޿γ�" +";"+ textField_1.getText() +";"+ textField_2.getText() +";"+ textField_3.getText()
	    					 +";"+ textField_4.getText() +";"+ textField_6.getText() +";"+ textField_7.getText() +";"+ textField_8.getText()
	    					  +";"+ textField_9.getText() +";��;��" ;
	    			boolean a = schoolTeacherBL.publishCourseForAll(s);
	//    			System.out.println(a);
	    			if(a==true){
	    				panelNow.remove(scrollPane);
	    				String[] columnTitle=new String[] {"���","Ժϵ","����","ѧ��","ѧ��","ʱ��","�ص�","��ʦ"};
		      	        table = new MyTable(schoolTeacherBL.checkCourseForAll(""),columnTitle,SchoolTeacherFrame,544,150,false);		

		      	        scrollPane = table.getScrollPane();//�������������
		    			scrollPane.setBounds(10, 55, 544, 150);
		     		    scrollPane.setVisible(true);
		     		    panelNow.add(scrollPane);
	     		      textField_1.setText("");
	     		      textField_2.setText("");
	     		      textField_3.setText("");
	     		      textField_4.setText("");
	     		      textField_6.setText("");
	     		      textField_7.setText("");
	     		      textField_8.setText("");
	     		      textField_9.setText("");
	    			}
	    			else{
	    				new NoticePanel(new String[]{"�ÿγ��Ѵ��ڣ�"},null,SchoolTeacherFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
	    			}
	     		
     		    SchoolTeacherFrame.repaint();
	    			
	    	}	
	    	}
	     }
    }
   
    //�鿴Ժϵ��ѧ�ƻ�
    class CheckPlanListener implements ActionListener{
    	JTextField textField;
    	JTextField textField_1;
    	JTextField textField_2;
    	JTextField textField_3;
    	JTextField textField_4;
    	JTextField textField_5;
	    /* (non-Javadoc)
	     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	     */
	    public void actionPerformed(ActionEvent e){
	    	SchoolTeacherFrame.remove(panelNow);
	    	SchoolTeacherFrame.setTitle("ѧУ������ʦ�����鿴��ѧ�ƻ�");
			JPanel Panel = new JPanel();
			Panel.setSize(614, 400);
			Panel.setLocation(170, 70);
			Panel.setBackground(Color.white);
//			Panel.setBackground(new Color(255 ,255, 224 ));
//			Panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			Panel.setVisible(true);
 			Panel.setLayout(null);
 			
 			JLabel lblNewLabel_1 = new JLabel("����Ժϵ");
			lblNewLabel_1.setFont(new Font("΢���ź�", Font.PLAIN, 16));
			lblNewLabel_1.setBounds(20, 10, 100, 35);
			Panel.add(lblNewLabel_1);
			lblNewLabel_1.setVisible(true);
			
			MyButton button = new MyButton("ȷ��");
			button.setFont(new Font("΢���ź�", Font.PLAIN, 12));
			button.setBounds(362, 12, 73, 23);
			Panel.add(button);
			button.setVisible(true);
			button.addActionListener(new CheckInstituteCourseOkButtonListener());
			
			
			String []s={"��ѧԺ","���ѧԺ","�����ϵ","���Ŵ���ѧԺ","��ѧϵ","��ʷѧϵ","��������ѧԺ","��ѧϵ","����ϵ"
			 ,"��ѧϵ","ҽѧԺ","����","����ѧԺ"};		
		    comboBox = new JComboBox<String>(s);
			comboBox.setBounds(150, 10, 100, 25);
			Panel.add(comboBox);
			comboBox.setVisible(true);
			
			
			String[][]row=new String[6][8];
			String[] columnTitle=new String[] {"���","���","����","ѧ��","ѧ��","ʱ��","�ص�","��ʦ"};   
  		    table = new MyTable(row,columnTitle,SchoolTeacherFrame,544,200,false);
	
			scrollPane = table.getScrollPane();//�������������	
			scrollPane.setBounds(37,55,544,200);
 		    scrollPane.setVisible(true);
			Panel.add(scrollPane);
			
			JLabel lblNewLabel_21 = new JLabel("��һ������ѧ��");
			lblNewLabel_21.setBounds(50, 280, 100, 15);
			Panel.add(lblNewLabel_21);
			
			JLabel lblNewLabel_3 = new JLabel("�ڶ�������ѧ��");
			lblNewLabel_3.setBounds(50, 303, 100, 15);
			Panel.add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("����������ѧ��");
			lblNewLabel_4.setBounds(50, 330, 100, 15);
			Panel.add(lblNewLabel_4);
			
		    textField = new JTextField();
			textField.setBounds(165, 277, 55, 20);
			Panel.add(textField);
			textField.setColumns(10);
			
		    textField_1 = new JTextField();
			textField_1.setBounds(165, 303, 55, 20);
			Panel.add(textField_1);
			textField_1.setColumns(10);
			
			textField_2 = new JTextField();
			textField_2.setBounds(165, 330, 55, 20);
			Panel.add(textField_2);
			textField_2.setColumns(10);
			
			JLabel label_1 = new JLabel("����������ѧ��");
			label_1.setBounds(280, 280, 100, 15);
			Panel.add(label_1);
			
			JLabel label_2 = new JLabel("ת������ѧ��");
			label_2.setBounds(280, 303, 100, 15);
			Panel.add(label_2);
			
			JLabel label_3 = new JLabel("ת������ѧ��");
			label_3.setBounds(280, 330, 100, 15);
			Panel.add(label_3);
			
			textField_3 = new JTextField();
			textField_3.setBounds(395, 277,55, 20);
			Panel.add(textField_3);
			textField_3.setColumns(10);
			
			textField_4 = new JTextField();
			textField_4.setBounds(395, 303, 50, 20);
			Panel.add(textField_4);
			textField_4.setColumns(10);
			
			textField_5 = new JTextField();
			textField_5.setBounds(395, 330, 50, 20);
			Panel.add(textField_5);
			textField_5.setColumns(10);
			
			SchoolTeacherFrame.setLayout(null);
			panelNow=Panel;
			SchoolTeacherFrame.add(panelNow);
			SchoolTeacherFrame.repaint();
	    }
	    
	    class CheckInstituteCourseOkButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				panelNow.remove(scrollPane);
				String [] columnNames = {"���","���","����","ѧ��","ѧ��","ʱ��","�ص�","��ʦ"};
				
		
				String[][]temp=schoolTeacherBL.checkInstituteCourse( (String) comboBox.getSelectedItem());
				for(int i=0;i<temp.length;i++)
					for(int j=2;j<8;j++){
						temp[i][j] = temp[i][j+1];
					}
	  		    table = new MyTable(temp,columnNames,SchoolTeacherFrame,544,200,false);		
	  		  				
				scrollPane = table.getScrollPane();
	 		    scrollPane.setBounds(37,55,544,200);
	 		    scrollPane.setVisible(true);
	 		    panelNow.add(scrollPane);
	 		    
	 		    String[]point= schoolTeacherBL.checkInstitutePoint( (String) comboBox.getSelectedItem());//�鿴Ժϵ��ѧ�ƻ�	
	 		   if(point==null){
	 			  textField.setText("");
		 		    textField_1.setText("");
		 		    textField_2.setText("");
		 		    textField_3.setText("");
		 		    textField_4.setText("");
		 		    textField_5.setText("");	

	 		   }
	 		   else{
	 		    textField.setText(point[1]);
	 		    textField_1.setText(point[2]);
	 		    textField_2.setText(point[3]);
	 		    textField_3.setText(point[4]);
	 		    textField_4.setText(point[5]);
	 		    textField_5.setText(point[6]);	
	 		   }
	 		    SchoolTeacherFrame.repaint();
			}	
	    
	    }
	   
    }
    
    //�鿴��ʦ��Ϣ
    class CheckThInfroListener implements ActionListener{
	    public void actionPerformed(ActionEvent e){
	    	SchoolTeacherFrame.remove(panelNow);
	    	SchoolTeacherFrame.setTitle("ѧУ������ʦ�����鿴��ʦ��Ϣ");
			JPanel Panel = new JPanel();
			Panel.setSize(614, 400);
			Panel.setLocation(170, 70);
			Panel.setBackground(Color.white);
//			Panel.setBackground(new Color(255 ,255, 224 ));
			Panel.setVisible(true);
 			Panel.setLayout(null);
 			
 			JLabel lblNewLabel_1 = new JLabel("��ʦ����");
			lblNewLabel_1.setFont(new Font("΢���ź�", Font.PLAIN, 16));
			lblNewLabel_1.setHorizontalAlignment(JLabel.RIGHT);
			lblNewLabel_1.setBounds(20, 12, 100, 30);
			Panel.add(lblNewLabel_1);
			lblNewLabel_1.setVisible(true);
			
			MyButton button = new MyButton("ȷ��");
			button.setFont(new Font("΢���ź�", Font.PLAIN, 12));
			button.setBounds(454, 12, 73, 30);
			Panel.add(button);
			button.setVisible(true);
			button.addActionListener(new CheckThInforOkButtonListener());
			
		    textField = new JTextField();
			textField.setBounds(150, 12, 100, 30);
			Panel.add(textField);
			textField.setColumns(10);
	    	
  			String[] columnTitle=new String[] {"����","����","Ժϵ","����γ�"};   
  		    table = new MyTable(schoolTeacherBL.checkTeacherInfor(),columnTitle,SchoolTeacherFrame,524,300,3);	
  		    
			scrollPane = table.getScrollPane();//�������������
			scrollPane.setBounds(37, 55, 524, 300);
 		    scrollPane.setVisible(true);
			Panel.add(scrollPane);
			
			SchoolTeacherFrame.setLayout(null);
			panelNow=Panel;
			SchoolTeacherFrame.add(panelNow);
			SchoolTeacherFrame.repaint();
	       }
	    
	    class CheckThInforOkButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				
				 String [] columnNames = {"����","����","Ժϵ","����γ�"};
					 
				String[]temp=schoolTeacherBL.checkTeacherInfor((String)textField.getText());
                if(temp==null){
                	new NoticePanel(new String[]{"�ý�ʦ�����ڣ�"},null,SchoolTeacherFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
               }
               else{
            	panelNow.remove(scrollPane);
				String[][]tmp=new String[1][];				
				tmp[0]=temp;
				table = new MyTable(tmp,columnNames,SchoolTeacherFrame,524,250,false);
				
				scrollPane = table.getScrollPane();
	 		    scrollPane.setBounds(37, 55, 524, 250);
	 		    scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
	 		    scrollPane.setVisible(true);
	 		    panelNow.add(scrollPane);
	 		    SchoolTeacherFrame.repaint();
               }
	 		    
			}
			
	    }
    }
  
    //�鿴ѧ����Ϣ
    class CheckStInfroListener implements ActionListener{
	    public void actionPerformed(ActionEvent e){
	    	SchoolTeacherFrame.remove(panelNow);
	    	SchoolTeacherFrame.setTitle("ѧУ������ʦ�����鿴ѧ����Ϣ");
			JPanel Panel = new JPanel();
			Panel.setSize(614, 400);
			Panel.setLocation(170, 70);
			Panel.setBackground(Color.white);
//			Panel.setBackground(new Color(255 ,255, 224 ));
			Panel.setVisible(true);
 			Panel.setLayout(null);
 			
 			JLabel lblNewLabel_1 = new JLabel("ѧ��ѧ��");
			lblNewLabel_1.setFont(new Font("΢���ź�", Font.PLAIN, 16));
			lblNewLabel_1.setHorizontalAlignment(JLabel.RIGHT);
			lblNewLabel_1.setBounds(20, 12, 100, 30);
			Panel.add(lblNewLabel_1);
			lblNewLabel_1.setVisible(true);
			
			MyButton button = new MyButton("ȷ��");
			button.setFont(new Font("΢���ź�", Font.PLAIN, 12));
			button.setBounds(454, 12, 73, 30);
			Panel.add(button);
			button.setVisible(true);
			button.addActionListener(new CheckStInforOkButtonListener());
			
		    textField = new JTextField();
			textField.setBounds(150, 12, 100, 30);
			Panel.add(textField);
			textField.setColumns(10);
	    	
  			String[] columnTitle=new String[] {"ѧ��","����","Ժϵ","ѧ�ּ�","��ҵ�ʸ����","��ѧ�ʸ�"};
  		    table = new MyTable(schoolTeacherBL.checkStudentInfor(),columnTitle,SchoolTeacherFrame,524,300,false);
  		  
  		    scrollPane = table.getScrollPane();//�������������
			scrollPane.setBounds(37, 55, 524, 300);
 		    scrollPane.setVisible(true);
			Panel.add(scrollPane);

			
			SchoolTeacherFrame.setLayout(null);
			panelNow=Panel;
			SchoolTeacherFrame.add(panelNow);
			SchoolTeacherFrame.repaint();
	    }
	    
	    class CheckStInforOkButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
					 String[]temp=schoolTeacherBL.checkStudentInfor((String)textField.getText());
		                if(temp==null){
		                	new NoticePanel(new String[]{"��ѧ�������ڣ�"},null,SchoolTeacherFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
		               }
		               else{
				panelNow.remove(scrollPane);
				String [] columnNames = {"ѧ��","����","Ժϵ","ѧ�ּ�","��ҵ�ʸ����","��ѧ�ʸ�"};
				
				String[][]tmp=new String[1][];				
				tmp[0]=temp;
				table = new MyTable(tmp,columnNames,SchoolTeacherFrame,524,250,false);
				
				scrollPane = table.getScrollPane();
	 		    scrollPane.setBounds(37, 55, 524, 250);
	 		    scrollPane.setVisible(true);
	 		    panelNow.add(scrollPane);
	 		    SchoolTeacherFrame.repaint();
			  }
			 }
			
	    }
    }
    
    //�鿴ȫУ�γ�
    class CheckCoInfroListener implements ActionListener{
    	JTextArea textArea = new JTextArea();
	    public void actionPerformed(ActionEvent e){  
	    	SchoolTeacherFrame.remove(panelNow);
	    	SchoolTeacherFrame.setTitle("ѧУ������ʦ�����鿴�γ���Ϣ");
	    	JPanel Panel = new JPanel();
			Panel.setBounds(170, 70, 614, 400);
			Panel.setBackground(Color.WHITE);
			Panel.setVisible(true);
 			Panel.setLayout(null);
    		
 			JLabel label = new JLabel("��ע��");
 			label.setFont(new Font("΢���ź�", Font.PLAIN, 14));
 			label.setBounds(37, 270, 100, 30);
 			Panel.add(label);
 			label.setVisible(true);
 			
 			JLabel label2 = new JLabel("˫�������Բ鿴������Ϣ��");
 			label2.setFont(new Font("΢���ź�", Font.PLAIN, 14));
 			label2.setHorizontalAlignment(JLabel.RIGHT);
 			label2.setForeground(new Color(199, 0, 133 ));
 			label2.setBounds(400, 270, 170, 30);
 			Panel.add(label2);
 			label2.setVisible(true);

			textArea = new JTextArea();
			textArea.setBounds(37,300,530,70);
			textArea.setLineWrap(true);
			textArea.setEditable(false);
			textArea.setFont(new Font("΢���ź�", Font.PLAIN, 14));
			textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
			Panel.add(textArea);
			textArea.setVisible(true);
		
			JLabel labelNotice = new JLabel("(�����˽�ʦ���̲ġ��ο���Ŀ��Ϣ)");
			labelNotice.setFont(new Font("΢���ź�", Font.PLAIN, 14));
			labelNotice.setHorizontalAlignment(JLabel.CENTER);
			labelNotice.setBounds(0,368,614,20);
			Panel.add(labelNotice);

  			String[] columnTitle=new String[] {"���","���","Ժϵ","����","ѧ��","ѧ��","ʱ��","�ص�"};
  			
  			String[][]temp=schoolTeacherBL.checkSchoolCourse();
  		    table = new MyTable(temp,columnTitle,SchoolTeacherFrame,544,250,false);
  		    table.setComponent(textArea,1);

		    scrollPane = table.getScrollPane();//�������������
			scrollPane.setBounds(37,10, 544, 250);
 		    scrollPane.setVisible(true);
			Panel.add(scrollPane);
		
			SchoolTeacherFrame.setLayout(null);
			panelNow=Panel;
			SchoolTeacherFrame.add(panelNow);
			SchoolTeacherFrame.repaint();
	    }
	    
	    class CheckSchoolCourseOKButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				String[]temp=schoolTeacherBL.checkSchoolCourse((String)textField.getText());
				
				if(temp==null){
					new NoticePanel(new String[]{"�ÿγ̲����ڣ�"},null,SchoolTeacherFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
			    }
				else{
					panelNow.remove(textArea);
					String infor = Arrays.toString(schoolTeacherBL.checkSchoolCourse((String)textField.getText()));
					textArea = new JTextArea(infor);
					textArea.setBounds(50,320,530,50);
					textArea.setLineWrap(true);
					textArea.setEditable(false);
					textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
					panelNow.add(textArea);
					SchoolTeacherFrame.repaint();
				}
			}
			
	    }
    } 

    	
    class LogoutListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				SchoolTeacherFrame.dispose();
				new LoginFrame(new LoginBL());
			}
  }
  
    class ChangePasswordListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			SchoolTeacherFrame.remove(panelNow);
			SchoolTeacherFrame.setTitle("ѧ��������������");
			JPanel Panel = new YPanel();
			Panel.setBounds(170, 70, 614, 400);
			Panel.setBackground(Color.white);
//			Panel.setBackground(new Color(255 ,255, 224 ));
//			Panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			Panel.setVisible(true);
 			Panel.setLayout(null);
 			
 			JLabel labelOld = new JLabel("������");
			labelOld.setFont(new Font("΢���ź�", Font.PLAIN, 16));
 			labelOld.setBounds(0, 90, 210, 30);
 			labelOld.setForeground(new Color(199, 0, 133));
 			labelOld.setHorizontalAlignment(JLabel.RIGHT);
 			Panel.add(labelOld);
 			labelOld.setVisible(true);
 			
 			JLabel labelOld2 = new JLabel("������");
			labelOld2.setFont(new Font("΢���ź�", Font.PLAIN, 16));
 			labelOld2.setBounds(0, 130, 210, 30);
 			labelOld2.setForeground(new Color(199, 0, 133));
 			labelOld2.setHorizontalAlignment(JLabel.RIGHT);
 			Panel.add(labelOld2);
 			labelOld2.setVisible(true);
 			
			JLabel label = new JLabel("���ٴ����룩������");
			label.setFont(new Font("΢���ź�", Font.PLAIN, 16));
 			label.setBounds(0, 170, 210, 30);
 			label.setForeground(new Color(199, 0, 133));
 			label.setHorizontalAlignment(JLabel.RIGHT);
 			Panel.add(label);
 			label.setVisible(true);
 			
 			
 			
 			newPasswordField = new JPasswordField();
 			newPasswordField.setBounds(230,170,200,30);
 			newPasswordField.setFont(new Font("΢���ź�", Font.PLAIN, 16));
 			newPasswordField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
 			newPasswordField.setOpaque(false);
 			Panel.add(newPasswordField);
 			newPasswordField.setVisible(true);

 			newPasswordField1 = new JPasswordField();
 			newPasswordField1.setBounds(230,130,200,30);
 			newPasswordField1.setFont(new Font("΢���ź�", Font.PLAIN, 16));
 			newPasswordField1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
 			newPasswordField1.setOpaque(false);
 			Panel.add(newPasswordField1);
 			newPasswordField1.setVisible(true);
 			
 			newPasswordField2 = new JPasswordField();
 			newPasswordField2.setBounds(230,90,200,30);
 			newPasswordField2.setFont(new Font("΢���ź�", Font.PLAIN, 16));
 			newPasswordField2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
 			newPasswordField2.setOpaque(false);
 			Panel.add(newPasswordField2);
 			newPasswordField2.setVisible(true);
 			
 			SchoolTeacherFrame.setLayout(null);
			panelNow=Panel;
			SchoolTeacherFrame.add(panelNow);
			SchoolTeacherFrame.repaint();
			
			MyButton OkButton = new MyButton("ȷ��");
 			OkButton.setFont(new Font("΢���ź�", Font.PLAIN, 12));
 			OkButton.setBounds(460, 170, 70, 30);
 			OkButton.addActionListener(new changePasswordOkButtonListener());
 			Panel.add(OkButton);
 			OkButton.setVisible(true);
		}
		class changePasswordOkButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if (!newPasswordField2.getText().equals(password)) {
					// ԭ�������
					new NoticePanel(new String[]{"ԭ�����������"},null,SchoolTeacherFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
					newPasswordField.setText("");
					newPasswordField1.setText("");
					newPasswordField2.setText("");
					return;
				}
				if (!newPasswordField.getText().equals(newPasswordField1.getText())) {
					// �������벻ͬ
					new NoticePanel(new String[]{"�������벻��ͬ��"},null,SchoolTeacherFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
					newPasswordField.setText("");
					newPasswordField1.setText("");
					newPasswordField2.setText("");
					return;
				}
				if(!newPasswordField.getText().equals("") && !newPasswordField1.getText().equals("") && !newPasswordField2.getText().equals("")){
					schoolTeacherBL.changePassword(ID, newPasswordField.getText());
					new NoticePanel(new String[]{"�����Ѹ��£�"},null,SchoolTeacherFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
					newPasswordField.setText("");
					newPasswordField1.setText("");
					newPasswordField2.setText("");
				}else{
					new NoticePanel(new String[]{"���벻��Ϊ�գ�"},null,SchoolTeacherFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
					newPasswordField.setText("");
					newPasswordField1.setText("");
					newPasswordField2.setText("");
				}
			}
				
			}
    }

} 
