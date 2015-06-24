package frame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.table.DefaultTableCellRenderer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import sun.swing.DefaultLookup;
import frame.InstituteTeacherMainFrame.CheckStlistListener.MyComboBoxUI;
import frame.SchoolManagerMainFrame.ChangePasswordListener.changePasswordOkButtonListener;
import busninesslogic.AdminBL;
import busninesslogic.AdminBLService;
import busninesslogic.LoginBL;
import busninesslogic.SchoolManagerBL;
import busninesslogic.SchoolManagerBLService;

public class SchoolManagerMainFrame {
	private JFrame SchoolManagerFrame;
	private JPanel panel;
	private JPanel Panel;
	private JPanel Panel2;
	private JPanel panel_2;
	private JPanel panel_1;
	private ChartPanel chartPanel;
	private MyTable table;
	private JComboBox comboBox;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private MyButton btnNewButton;
	private MyButton btnNewButton_1;
	private MyButton btnNewButton_2;
	private MyButton btnNewButton_3;
	private JPanel panelNow;
	private JTable courseTable;
	private JTextField newPasswordField;
	private JTextField newPasswordField1;
	private JTextField newPasswordField2;
	private JScrollPane scrollPane;
	private SchoolManagerBLService schoolManagerBL;
	private AdminBLService adminBLService;
	private String ID;
	private String password;

	// ����main����
	public static void main(String[] args) {
		// new SchoolManagerMainFrame();
		new SchoolManagerMainFrame("3001","1",new SchoolManagerBL(),new AdminBL());
	}

	/*
	 * ѧУ����Ա�����湹�캯��)O
	 */
	public SchoolManagerMainFrame(String ID, String password,
			SchoolManagerBLService schoolManagerBL,
			AdminBLService adminBLService) {
		this.schoolManagerBL = schoolManagerBL;
		this.adminBLService = adminBLService;
		this.ID = ID;
		this.password = password;

		SchoolManagerFrame = new JFrame();
		SchoolManagerFrame.setSize(800, 500);
		SchoolManagerFrame.setLocation(300, 100);
		SchoolManagerFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				"����Ա.jpg"));
		SchoolManagerFrame.setTitle("ѧУ����Ա������");
		SchoolManagerFrame.getContentPane().setLayout(null);
		SchoolManagerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SchoolManagerFrame.setVisible(true);

		panel_2 = new MyPanel();
		panel_2.setBackground(Color.white);
		panel_2.setBounds(0, 0, 80, 80);
		SchoolManagerFrame.getContentPane().add(panel_2);

		panel = new JPanel();
		panel.setBackground(new Color(199, 0, 133));
		// panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 0, 820, 70);
		SchoolManagerFrame.getContentPane().add(panel);
		panel.setVisible(true);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("��ӭ" +schoolManagerBL.checkSelfInfor(ID)[1]+ "ѧУ����Ա��");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(Color.white);
		lblNewLabel.setFont(new Font("�±�ֱ������ֿ�", Font.BOLD, 24));
		lblNewLabel.setBounds(80, 10, 425, 45);
		panel.add(lblNewLabel);
		lblNewLabel.setVisible(true);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(199, 0, 133));
		panel_1.setForeground(Color.WHITE);
		// panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(0, 70, 170, 400);
		SchoolManagerFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(true);

		btnNewButton = new MyButton("�鿴ѧУ��ѧ�ƻ�");
		btnNewButton.setFont(new Font("΢���ź�", Font.BOLD, 16));
		btnNewButton.setBounds(10, 25, 150, 35);
		btnNewButton.setBorder(new LineBorder(new Color(199, 0, 133)));
		btnNewButton.setBackground(new Color(199, 0, 133));
		btnNewButton.setForeground(Color.white);
		btnNewButton.setVisible(true);
		btnNewButton.addActionListener(new CheckSchoolPlanListener());
		panel_1.add(btnNewButton);

		btnNewButton_1 = new MyButton("�鿴��Ժѧ���ɼ�");
		btnNewButton_1.setFont(new Font("΢���ź�", Font.BOLD, 16));
		btnNewButton_1.setBounds(10, 75, 150, 35);
		btnNewButton_1.setBorder(new LineBorder(new Color(199, 0, 133)));
		btnNewButton_1.setBackground(new Color(199, 0, 133));
		btnNewButton_1.setForeground(Color.white);
		btnNewButton_1.addActionListener(new CheckScoreListener());
		panel_1.add(btnNewButton_1);
		btnNewButton_1.setVisible(true);

		btnNewButton_2 = new MyButton("�޸�����");
		btnNewButton_2.setFont(new Font("΢���ź�", Font.BOLD, 16));
		btnNewButton_2.setBounds(10, 125, 150, 35);
		btnNewButton_2.setBorder(new LineBorder(new Color(199, 0, 133)));
		btnNewButton_2.setBackground(new Color(199, 0, 133));
		btnNewButton_2.setForeground(Color.white);
		btnNewButton_2.setVisible(true);
		btnNewButton_2.addActionListener(new ChangePasswordListener());
		panel_1.add(btnNewButton_2);

		btnNewButton_3 = new MyButton("ע��");
		btnNewButton_3.setFont(new Font("΢���ź�", Font.BOLD, 16));
		btnNewButton_3.setBounds(10, 175, 150, 35);
		btnNewButton_3.setBorder(new LineBorder(new Color(199, 0, 133)));
		btnNewButton_3.setBackground(new Color(199, 0, 133));
		btnNewButton_3.setForeground(Color.white);
		btnNewButton_3.setVisible(true);
		btnNewButton_3.addActionListener(new LogoutListener());
		panel_1.add(btnNewButton_3);

		panelNow = new XPanel();
		panelNow.setBackground(Color.white);
		panelNow.setBounds(170, 70, 614, 400);
		SchoolManagerFrame.getContentPane().add(panelNow);
		panelNow.setVisible(true);

		chartPanel = new ChartPanel(null);
		SchoolManagerFrame.getContentPane().add(chartPanel);

		Panel2 = new JPanel();
		Panel2.setSize(614, 360);
		Panel2.setLocation(170, 110);
		Panel2.setBackground(Color.white);
		Panel2.setVisible(false);
		Panel2.setLayout(null);
		SchoolManagerFrame.getContentPane().add(Panel2);
		SchoolManagerFrame.repaint();
	}

	/*
	 * �鿴ѧУ��ѧ�ƻ��¼�����
	 */
	class CheckSchoolPlanListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			SchoolManagerFrame.remove(panelNow);
			chartPanel.setVisible(false);
			Panel2.setVisible(false);
			SchoolManagerFrame.setTitle("ѧУ����Ա�����鿴ѧУ��ѧ�ƻ�");
			JPanel Panel = new JPanel();
			Panel.setSize(614, 400);
			Panel.setLocation(170, 70);
			Panel.setBackground(Color.white);
			Panel.setVisible(true);
			Panel.setLayout(null);

			String[] columnTitle = new String[] { "ѧԺ��", "�γ�����", "�γ̺ŷ�Χ",
					"ѧ������", "ѧԺ��ѧ��"};
			table = new MyTable(schoolManagerBL.checkSchoolPlan(), columnTitle,SchoolManagerFrame,524,300,5);
			scrollPane = table.getScrollPane();// �������������
			scrollPane.setBounds(37, 25, 524, 300);
			scrollPane.setVisible(true);
			Panel.add(scrollPane);

			SchoolManagerFrame.setLayout(null);
			panelNow = Panel;
			SchoolManagerFrame.add(panelNow);
			SchoolManagerFrame.repaint();
		}
	}

	/*
	 * �鿴��Ժѧ���ɼ��¼�����
	 */
	class CheckScoreListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			SchoolManagerFrame.remove(panelNow);
			chartPanel.setVisible(false);
			Panel2.setVisible(true);
			SchoolManagerFrame.setTitle("ѧУ����Ա�����鿴��Ժѧ���ɼ�");

			JPanel Panel = new JPanel();
			Panel.setSize(614, 40);
			Panel.setLocation(170, 70);
			Panel.setBackground(Color.white);
			Panel.setVisible(true);
			Panel.setLayout(null);

			JLabel lblNewLabel_1 = new JLabel("Ժϵ");
			lblNewLabel_1.setFont(new Font("΢���ź�", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(60, 5, 100, 35);
			Panel.add(lblNewLabel_1);
			lblNewLabel_1.setVisible(true);

			MyButton button = new MyButton("ȷ��");
			button.setFont(new Font("΢���ź�", Font.BOLD, 12));
			button.setBounds(300, 12, 73, 23);
			Panel.add(button);
			button.setVisible(true);
			button.addActionListener(new CheckInstituteScoreOkButtonListener());

			String[] s = { "��ѧԺ", "���ѧԺ", "�����ϵ", "���Ŵ���ѧԺ", "��ѧϵ", "��ʷѧϵ",
					"��������ѧԺ", "��ѧϵ", "����ϵ", "��ѧϵ", "ҽѧԺ", "����", "����ѧԺ" };
			comboBox = new JComboBox<String>(s);
			comboBox.setFont(new Font("΢���ź�", Font.BOLD, 12));
			comboBox.setBounds(150, 10, 130, 25);
			comboBox.setUI(new MyComboBoxUI());
			Panel.add(comboBox);
			comboBox.setVisible(true);

			SchoolManagerFrame.setLayout(null);
			panelNow = Panel;
			SchoolManagerFrame.add(panelNow);
			SchoolManagerFrame.repaint();
		}

		 class MyComboBoxUI extends BasicComboBoxUI {
		    	/**
		         * Paints the currently selected item.
		         */
		        @SuppressWarnings({ "rawtypes", "unchecked" })
				public void paintCurrentValue(Graphics g,Rectangle bounds,boolean hasFocus) {
		            ListCellRenderer renderer = comboBox.getRenderer();
		            Component c;

		            if ( hasFocus && !isPopupVisible(comboBox) ) {
		                c = renderer.getListCellRendererComponent( listBox,
		                                                           comboBox.getSelectedItem(),
		                                                           -1,
		                                                           true,
		                                                           false );
		            }
		            else {
		                c = renderer.getListCellRendererComponent( listBox,
		                                                           comboBox.getSelectedItem(),
		                                                           -1,
		                                                           false,
		                                                           false );
		                c.setBackground(UIManager.getColor("ComboBox.background"));
		            }
		            c.setFont(comboBox.getFont());
		            if ( hasFocus && !isPopupVisible(comboBox) ) {
		                c.setForeground(new Color(199,0,133));
		                c.setBackground(Color.WHITE);
		            }
		            else {
		                if ( comboBox.isEnabled() ) {
		                    c.setForeground(Color.BLACK);
		                    c.setBackground(Color.WHITE);
		                }
		                else {
		                    c.setForeground(DefaultLookup.getColor(
		                             comboBox, this, "ComboBox.disabledForeground", null));
		                    c.setBackground(DefaultLookup.getColor(
		                             comboBox, this, "ComboBox.disabledBackground", null));
		                }
		            }

		            // Fix for 4238829: should lay out the JPanel.
		            boolean shouldValidate = false;
		            if (c instanceof JPanel)  {
		                shouldValidate = true;
		            }

		            int x = bounds.x, y = bounds.y, w = bounds.width, h = bounds.height;
		            if (padding != null) {
		                x = bounds.x + padding.left;
		                y = bounds.y + padding.top;
		                w = bounds.width - (padding.left + padding.right);
		                h = bounds.height - (padding.top + padding.bottom);
		            }

		            currentValuePane.paintComponent(g,c,comboBox,x,y,w,h,shouldValidate);
		        }
		    
		    }
		 
		class CheckInstituteScoreOkButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				SchoolManagerFrame.remove(chartPanel);
				Panel2.setVisible(false);
				double[]temp=schoolManagerBL.checkInstituteScore( (String)
				 comboBox.getSelectedItem());
				DefaultCategoryDataset dataset = new DefaultCategoryDataset();
				dataset.addValue(temp[0]*100, "ƽ����", "��һ");
				dataset.addValue(temp[1]*100, "�ҿ���", "��һ");
				dataset.addValue(temp[2]*100, "ƽ����", "���");
				dataset.addValue(temp[3]*100, "�ҿ���", "���");
				dataset.addValue(temp[4]*100, "ƽ����", "����");
				dataset.addValue(temp[5]*100, "�ҿ���", "����");
				dataset.addValue(temp[6]*100, "ƽ����", "����");
				dataset.addValue(temp[7]*100, "�ҿ���", "����");

				JFreeChart chart = ChartFactory.createBarChart3D("�ɼ�", // ͼ�����
						"�꼶", // Ŀ¼�����ʾ��ǩ
						"�÷� / �ҿ���", // ��ֵ�����ʾ��ǩ
						dataset, // ���ݼ�
						PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ
						true, // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������false)
						false, // �Ƿ����ɹ���
						false // �Ƿ�����URL����
						);

				// �����￪ʼ
				CategoryPlot plot = chart.getCategoryPlot();// ��ȡͼ���������
				CategoryAxis domainAxis = plot.getDomainAxis(); // ˮƽ�ײ��б�
				domainAxis.setLabelFont(new Font("΢���ź�", Font.BOLD, 14)); // ˮƽ�ײ�����
				domainAxis.setTickLabelFont(new Font("΢���ź�", Font.BOLD, 12)); // ��ֱ����
				ValueAxis rangeAxis = plot.getRangeAxis();// ��ȡ��״
				rangeAxis.setLabelFont(new Font("΢���ź�", Font.BOLD, 15));
				chart.getLegend().setItemFont(new Font("΢���ź�", Font.BOLD, 15));
				chart.getTitle().setFont(new Font("����", Font.BOLD, 20));// ���ñ�������
				// �������������Ȼ�����е�࣬��ֻΪһ��Ŀ�ģ���������������� chartPanel = new

				chartPanel = new ChartPanel(chart);
				chartPanel.setSize(620, 390);
				chartPanel.setLocation(170, 110);
				chartPanel.setBackground(Color.white);
				chartPanel.setVisible(true);
				chartPanel.setLayout(null);
				chartPanel.setFillZoomRectangle(true);
				chartPanel.setMouseWheelEnabled(true);
				chartPanel.setPreferredSize(new Dimension(250, 250));

				SchoolManagerFrame.setLayout(null);
				SchoolManagerFrame.add(chartPanel);
				SchoolManagerFrame.repaint();

			}

		}

	}

	/*
	 * �޸������¼�����
	 */
	class ChangePasswordListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			SchoolManagerFrame.remove(panelNow);
			chartPanel.setVisible(false);
			Panel2.setVisible(false);
			SchoolManagerFrame.setTitle("ѧ��������������");
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
 			
 			SchoolManagerFrame.setLayout(null);
			panelNow=Panel;
			SchoolManagerFrame.add(panelNow);
			SchoolManagerFrame.repaint();
			
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
					new NoticePanel(new String[]{"ԭ�����������"},null,SchoolManagerFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
					newPasswordField.setText("");
					newPasswordField1.setText("");
					newPasswordField2.setText("");
					return;
				}
				if (!newPasswordField.getText().equals(newPasswordField1.getText())) {
					// �������벻ͬ
					new NoticePanel(new String[]{"�������벻��ͬ��"},null,SchoolManagerFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
					newPasswordField.setText("");
					newPasswordField1.setText("");
					newPasswordField2.setText("");
					return;
				}
				if(!newPasswordField.getText().equals("") && !newPasswordField1.getText().equals("") && !newPasswordField2.getText().equals("")){
					schoolManagerBL.changePassword(ID, newPasswordField.getText());
					new NoticePanel(new String[]{"�����Ѹ��£�"},null,SchoolManagerFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
					newPasswordField.setText("");
					newPasswordField1.setText("");
					newPasswordField2.setText("");
				}else{
					new NoticePanel(new String[]{"���벻��Ϊ�գ�"},null,SchoolManagerFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
					newPasswordField.setText("");
					newPasswordField1.setText("");
					newPasswordField2.setText("");
				}
			}
				
			}
    }

	/*
	 * ע���¼�����
	 */
	class LogoutListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			SchoolManagerFrame.dispose();
			new LoginFrame(new LoginBL());
		}
	}
}
