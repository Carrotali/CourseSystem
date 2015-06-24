package frame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.TableColumn;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import busninesslogic.AdminBL;
import busninesslogic.AdminBLService;
import busninesslogic.InstituteManagerBL;
import busninesslogic.InstituteManagerBLService;
import busninesslogic.LoginBL;

public class InstituteManagerMainFrame {
	private JFrame InstituteManagerFrame;
	private JPanel panel;
	private JPanel Panel;
	private ChartPanel chartPanel;
	private JPanel panel_2;
	private JPanel panel_1;
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
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JPanel panelNow;
	private MyTable courseTable;
	private JTextField newPasswordField;
	private JScrollPane scrollPane;
	public static InstituteManagerBLService instituteManagerBL;
	private AdminBLService adminBLService;
	private String ID;

	// private String password;

	// 测试main方法
	public static void main(String[] args) {
		new InstituteManagerMainFrame("2001","1",new InstituteManagerBL(), new AdminBL());
	}

	/*
	 * 院系教务处老师主界面构造函数
	 */
//	public InstituteManagerMainFrame(){
	public InstituteManagerMainFrame(String ID,String password,InstituteManagerBLService instituteManagerBL,AdminBLService adminBLService) {
		this.instituteManagerBL = instituteManagerBL;
		this.adminBLService = adminBLService;
		this.ID = ID;
		// this.password = password;

		InstituteManagerFrame = new JFrame();
		InstituteManagerFrame.setSize(800, 500);
		InstituteManagerFrame.setLocation(300, 100);
		InstituteManagerFrame.setIconImage(Toolkit.getDefaultToolkit()
				.getImage("教务员.jpg"));
		InstituteManagerFrame.setTitle("院系管理员主界面");
		InstituteManagerFrame.getContentPane().setLayout(null);
		InstituteManagerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		InstituteManagerFrame.setVisible(true);

		panel_2 = new MyPanel();
		panel_2.setBackground(Color.white);
		panel_2.setBounds(0, 0, 80, 80);
		InstituteManagerFrame.getContentPane().add(panel_2);

		panel = new JPanel();
		panel.setBackground(new Color(199, 0, 133));
		// panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 0, 820, 70);
		InstituteManagerFrame.getContentPane().add(panel);
		panel.setVisible(true);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("欢迎" + instituteManagerBL.getSelfInfor(ID)[3] + instituteManagerBL.getSelfInfor(ID)[1] + "管理员！");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(Color.white);
		lblNewLabel.setFont(new Font("德彪钢笔行书字库", Font.BOLD, 24));
		lblNewLabel.setBounds(80, 10, 425, 45);
		panel.add(lblNewLabel);
		lblNewLabel.setVisible(true);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(199, 0, 133));
		panel_1.setForeground(Color.WHITE);
		// panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(0, 70, 170, 400);
		InstituteManagerFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(true);

		btnNewButton = new JButton("查看学院教学计划");
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 16));
		btnNewButton.setBounds(10, 25, 150, 35);
		btnNewButton.setBorder(new LineBorder(new Color(199, 0, 133)));
		btnNewButton.setBackground(new Color(199, 0, 133));
		btnNewButton.setForeground(Color.white);
		btnNewButton.setVisible(true);
		btnNewButton.addActionListener(new CheckPlanListener());
		panel_1.add(btnNewButton);

		btnNewButton_1 = new JButton("查看本院课程");
		btnNewButton_1.setFont(new Font("微软雅黑", Font.BOLD, 16));
		btnNewButton_1.setBounds(10, 75, 150, 35);
		btnNewButton_1.setBorder(new LineBorder(new Color(199, 0, 133)));
		btnNewButton_1.setBackground(new Color(199, 0, 133));
		btnNewButton_1.setForeground(Color.white);
		btnNewButton_1.addActionListener(new CheckAllCourseListener());
		panel_1.add(btnNewButton_1);
		btnNewButton_1.setVisible(true);

		btnNewButton_2 = new JButton("查看本院学生成绩");
		btnNewButton_2.setFont(new Font("微软雅黑", Font.BOLD, 16));
		btnNewButton_2.setBounds(10, 125, 150, 35);
		btnNewButton_2.setBorder(new LineBorder(new Color(199, 0, 133)));
		btnNewButton_2.setBackground(new Color(199, 0, 133));
		btnNewButton_2.setForeground(Color.white);
		btnNewButton_2.setVisible(true);
		btnNewButton_2.addActionListener(new CheckScoreListener());
		panel_1.add(btnNewButton_2);

		btnNewButton_3 = new JButton("查看课程成绩");
		btnNewButton_3.setFont(new Font("微软雅黑", Font.BOLD, 16));
		btnNewButton_3.setBounds(10, 175, 150, 35);
		btnNewButton_3.setBorder(new LineBorder(new Color(199, 0, 133)));
		btnNewButton_3.setBackground(new Color(199, 0, 133));
		btnNewButton_3.setForeground(Color.white);
		btnNewButton_3.setVisible(true);
		btnNewButton_3.addActionListener(new CheckScoreDistributionListener());
		panel_1.add(btnNewButton_3);

		btnNewButton_4 = new JButton("修改密码");
		btnNewButton_4.setFont(new Font("微软雅黑", Font.BOLD, 16));
		btnNewButton_4.setBounds(10, 225, 150, 35);
		btnNewButton_4.setBorder(new LineBorder(new Color(199, 0, 133)));
		btnNewButton_4.setBackground(new Color(199, 0, 133));
		btnNewButton_4.setForeground(Color.white);
		btnNewButton_4.setVisible(true);
		btnNewButton_4.addActionListener(new ChangePasswordListener());
		panel_1.add(btnNewButton_4);

		btnNewButton_5 = new JButton("注销");
		btnNewButton_5.setFont(new Font("微软雅黑", Font.BOLD, 16));
		btnNewButton_5.setBounds(10, 275, 150, 35);
		btnNewButton_5.setBorder(new LineBorder(new Color(199, 0, 133)));
		btnNewButton_5.setBackground(new Color(199, 0, 133));
		btnNewButton_5.setForeground(Color.white);
		btnNewButton_5.setVisible(true);
		btnNewButton_5.addActionListener(new LogoutListener());
		panel_1.add(btnNewButton_5);

		panelNow = new XPanel();
		panelNow.setBackground(Color.white);
		// panelNow.setBackground(new Color(255 ,255, 224 ));
		// panelNow.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelNow.setBounds(170, 70, 614, 400);
		InstituteManagerFrame.getContentPane().add(panelNow);
		panelNow.setVisible(true);

		InstituteManagerFrame.repaint();
	}

	/*
	 * 查看教学计划事件监听
	 */
	class CheckPlanListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
				InstituteManagerFrame.remove(panelNow);
				InstituteManagerFrame.setTitle("院系管理员——查看教学计划");
				Panel = new JPanel();
				Panel.setSize(614, 400);
				Panel.setLocation(170, 70);
				Panel.setBackground(Color.white);
				Panel.setVisible(true);
				Panel.setLayout(null);

				JLabel lblNewLabel_1 = new JLabel(
						"第一学年所需学分");
				lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 14));
				lblNewLabel_1.setBounds(60, 55, 130, 30);
				lblNewLabel_1.setVisible(true);
				Panel.add(lblNewLabel_1);

				JLabel lblNewLabel_2 = new JLabel(
						"第二学年所需学分");
				lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 14));
				lblNewLabel_2.setBounds(60, 105, 130, 30);
				lblNewLabel_2.setVisible(true);
				Panel.add(lblNewLabel_2);

				JLabel lblNewLabel_3 = new JLabel(
						"第三学年所需学分");
				lblNewLabel_3.setFont(new Font("微软雅黑", Font.BOLD, 14));
				lblNewLabel_3.setBounds(60, 155, 130, 30);
				lblNewLabel_3.setVisible(true);
				Panel.add(lblNewLabel_3);

				JLabel lblNewLabel_4 = new JLabel(
						"第四学年所需学分");
				lblNewLabel_4.setFont(new Font("微软雅黑", Font.BOLD, 14));
				lblNewLabel_4.setBounds(60, 205, 130, 30);
				lblNewLabel_4.setVisible(true);
				Panel.add(lblNewLabel_4);

				textField_3 = new JTextField();
				textField_3.setBounds(200, 60, 76, 21);
				textField_3.setColumns(10);
				textField_3.setVisible(true);
				Panel.add(textField_3);

				textField_4 = new JTextField();
				textField_4.setBounds(200, 110, 76, 21);
				Panel.add(textField_4);
				textField_4.setColumns(10);
				textField_4.setVisible(true);

				textField_5 = new JTextField();
				textField_5.setBounds(200, 160, 76, 21);
				textField_5.setColumns(10);
				textField_5.setVisible(true);
				Panel.add(textField_5);

				textField_6 = new JTextField();
				textField_6.setBounds(200, 210, 76, 21);
				textField_6.setColumns(10);
				textField_6.setVisible(true);
				Panel.add(textField_6);

				JLabel label_2 = new JLabel(
						"准入所需学分");
				label_2.setFont(new Font("微软雅黑", Font.BOLD, 14));
				label_2.setBounds(340, 105, 130, 30);
				label_2.setVisible(true);
				Panel.add(label_2);

				JLabel lblNewLabel_5 = new JLabel(
						"准出所需学分");
				lblNewLabel_5.setFont(new Font("微软雅黑", Font.BOLD, 14));
				lblNewLabel_5.setBounds(340, 155, 130, 30);
				lblNewLabel_5.setVisible(true);
				Panel.add(lblNewLabel_5);

				textField_7 = new JTextField();
				textField_7.setBounds(450, 110, 76, 21);
				textField_7.setColumns(10);
				textField_7.setVisible(true);
				Panel.add(textField_7);

				textField_8 = new JTextField();
				textField_8.setBounds(450, 160, 76, 21);
				textField_8.setColumns(10);
				textField_8.setVisible(true);
				Panel.add(textField_8);

				 String[]point= instituteManagerBL.checkInstitutePoint(instituteManagerBL.getSelfInfor(ID)[3]);//查看院系教学计划	
		 		   if(point==null){
		 			  textField_3.setText("");
			 		    textField_4.setText("");
			 		    textField_5.setText("");
			 		    textField_6.setText("");
			 		    textField_7.setText("");
			 		    textField_8.setText("");	

		 		   }
		 		   else{
		 		    textField_3.setText(point[1]);
		 		    textField_4.setText(point[2]);
		 		    textField_5.setText(point[3]);
		 		    textField_6.setText(point[4]);
		 		    textField_7.setText(point[5]);
		 		    textField_8.setText(point[6]);	
		 		   }
				InstituteManagerFrame.setLayout(null);
				panelNow = Panel;
				InstituteManagerFrame.add(panelNow);
				InstituteManagerFrame.repaint();

		}

	}

	/*
	 * 查看本院课程事件监听
	 */
	class CheckAllCourseListener implements ActionListener{
    	JTextArea textArea = new JTextArea();
	    public void actionPerformed(ActionEvent e){
	    	InstituteManagerFrame.remove(panelNow);
	    	InstituteManagerFrame.setTitle("院系管理员——查看学院课程");
			Panel = new JPanel();
			Panel.setSize(614, 400);
			Panel.setLocation(170, 70);
			Panel.setBackground(Color.white);
			Panel.setVisible(true);
 			Panel.setLayout(null);
	    	
 			JLabel label = new JLabel("备注：");
 			label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
 			label.setBounds(37, 270, 100, 30);
 			Panel.add(label);
 			label.setVisible(true);
 			
 			JLabel label2 = new JLabel("双击表项以查看额外信息！");
 			label2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
 			label2.setHorizontalAlignment(JLabel.RIGHT);
 			label2.setForeground(new Color(199, 0, 133 ));
 			label2.setBounds(400, 270, 170, 30);
 			Panel.add(label2);
 			label2.setVisible(true);

			textArea = new JTextArea();
			textArea.setBounds(37,300,530,70);
			textArea.setLineWrap(true);
			textArea.setEditable(false);
			textArea.setFont(new Font("微软雅黑", Font.PLAIN, 14));
			textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
			Panel.add(textArea);
			textArea.setVisible(true);

 			String [] columnNames = {"课程类别","课程号","课程名","学分","开设学期","时间","教室","教师名、工号"};
  
  			
  			String[][]temp=instituteManagerBL.checkColist(instituteManagerBL.getSelfInfor(ID)[3]);
			for(int i=0;i<temp.length;i++)
				for(int j=2;j<8;j++){
					temp[i][j] = temp[i][j+1];
				}
			courseTable  = new MyTable(temp,columnNames,InstituteManagerFrame,544,250,false);	
			courseTable.setComponent(textArea, 4);
  			
  		    scrollPane = courseTable.getScrollPane();
  		    scrollPane.setBounds(37,10, 544, 250);
  		    scrollPane.setVisible(true);
  			Panel.add(scrollPane);
			
			InstituteManagerFrame.setLayout(null);
			panelNow = Panel;
			InstituteManagerFrame.add(panelNow);
			InstituteManagerFrame.repaint();
	    }
	    
	    /*
	     * 查看院系课程确定按钮事件监听
	     */
	    class CheckInstituteCourseOKButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				
				String[]temp=instituteManagerBL.checkCoInfro((String)textField.getText());
				
				if(temp==null){
					new NoticePanel(new String[]{"该课程不存在！"},null,InstituteManagerFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
			    }
				else{
					panelNow.remove(textArea);
					String infor = Arrays.toString(instituteManagerBL.checkCoInfro((String)textField.getText()));
					textArea = new JTextArea(infor);
					textArea.setBounds(50,320,530,50);
					textArea.setLineWrap(true);
					textArea.setEditable(false);
					textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
					panelNow.add(textArea);
					InstituteManagerFrame.repaint();
				}
			}
	    }
    } 

	/*
	 * 查看课程成绩事件监听
	 */

	class CheckScoreDistributionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			InstituteManagerFrame.remove(panelNow);
			InstituteManagerFrame.setTitle("院系管理员——查看课程成绩");
            String courseNo="10001";       
			int [] temp = instituteManagerBL
					.checkScoreDistribution(courseNo);
			
			DefaultPieDataset dataset = new DefaultPieDataset();
			dataset.setValue("60以下", temp[0]);
			dataset.setValue("60-69", temp[1]);
			dataset.setValue("70-79", temp[2]);
			dataset.setValue("80-89", temp[3]);
			dataset.setValue("90-100", temp[4]);			
			JFreeChart chart = ChartFactory.createPieChart3D("成绩分布", dataset,
					true, false, false);

			chart.setBackgroundPaint(new GradientPaint(new Point(0, 0),
					Color.WHITE, new Point(400, 200), Color.WHITE));

			// 设置百分比
			PiePlot pieplot = (PiePlot) chart.getPlot();
			DecimalFormat df = new DecimalFormat("0.00%");// 获得一个DecimalFormat对象，主要是设置小数问题
			NumberFormat nf = NumberFormat.getNumberInstance();// 获得一个NumberFormat对象
			StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator(
					"{0}  {2}", nf, df);// 获得StandardPieSectionLabelGenerator对象
			pieplot.setLabelGenerator(sp1);// 设置饼图显示百分比

			// 没有数据的时候显示的内容
			pieplot.setNoDataMessage("无数据显示");
			pieplot.setCircular(false);
			pieplot.setLabelGap(0.02D);
			pieplot.setBackgroundPaint(null);
			pieplot.setOutlineVisible(false);
			pieplot.setLabelLinkPaint(Color.darkGray);
			pieplot.setLabelLinkStroke(new BasicStroke(1.0f));
			pieplot.setLabelOutlineStroke(null);
			pieplot.setLabelPaint(Color.darkGray);
			pieplot.setLabelBackgroundPaint(Color.WHITE);
			pieplot.setIgnoreNullValues(true);// 设置不显示空值
			pieplot.setIgnoreZeroValues(true);// 设置不显示负值

			chart.getTitle().setFont(new Font("宋体", Font.BOLD, 20));// 设置标题字体
			PiePlot piePlot = (PiePlot) chart.getPlot();// 获取图表区域对象
			piePlot.setLabelFont(new Font("微软雅黑", Font.BOLD, 14));// 解决乱码
			chart.getLegend().setItemFont(new Font("微软雅黑", Font.BOLD, 10));

			chartPanel = new ChartPanel(chart);
			chartPanel.setSize(620, 390);
			chartPanel.setLocation(170, 70);
			chartPanel.setBackground(Color.white);
			chartPanel.setVisible(true);
			chartPanel.setLayout(null);
			chartPanel.setFillZoomRectangle(true);
			chartPanel.setMouseWheelEnabled(true);
			chartPanel.setPreferredSize(new Dimension(250, 250));

			InstituteManagerFrame.setLayout(null);
			panelNow = chartPanel;
			InstituteManagerFrame.add(panelNow);
			InstituteManagerFrame.repaint();
		}
	}

	/*
	 * 查看本院学生成绩事件监听
	 */
	class CheckScoreListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			InstituteManagerFrame.remove(panelNow);
			InstituteManagerFrame.setTitle("院系管理员——查看本院学生成绩");

			double[] temp = instituteManagerBL
					.checkInstituteScore(instituteManagerBL.getSelfInfor(ID)[3]);
			
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			dataset.addValue(temp[0]*100, "平均分", "大一");
			dataset.addValue(temp[1]*100, "挂科率", "大一");
			dataset.addValue(temp[2]*100, "平均分", "大二");
			dataset.addValue(temp[3]*100, "挂科率", "大二");
			dataset.addValue(temp[4]*100, "平均分", "大三");
			dataset.addValue(temp[5]*100, "挂科率", "大三");
			dataset.addValue(temp[6]*100, "平均分", "大四");
			dataset.addValue(temp[7]*100, "挂科率", "大四");

			JFreeChart chart = ChartFactory.createBarChart3D("成绩", // 图表标题
					"年级", // 目录轴的显示标签
					"得分 / 挂科率", // 数值轴的显示标签
					dataset, // 数据集
					PlotOrientation.VERTICAL, // 图表方向：水平、垂直
					true, // 是否显示图例(对于简单的柱状图必须是false)
					false, // 是否生成工具
					false // 是否生成URL链接
					);

			// 从这里开始
			CategoryPlot plot = chart.getCategoryPlot();// 获取图表区域对象
			CategoryAxis domainAxis = plot.getDomainAxis(); // 水平底部列表
			domainAxis.setLabelFont(new Font("微软雅黑", Font.BOLD, 14)); // 水平底部标题
			domainAxis.setTickLabelFont(new Font("微软雅黑", Font.BOLD, 12)); // 垂直标题
			ValueAxis rangeAxis = plot.getRangeAxis();// 获取柱状
			rangeAxis.setLabelFont(new Font("微软雅黑", Font.BOLD, 15));
			chart.getLegend().setItemFont(new Font("微软雅黑", Font.BOLD, 15));
			chart.getTitle().setFont(new Font("宋体", Font.BOLD, 20));// 设置标题字体
			// 到这里结束，虽然代码有点多，但只为一个目的，解决汉字乱码问题 chartPanel = new

			chartPanel = new ChartPanel(chart);
			chartPanel.setSize(620, 390);
			chartPanel.setLocation(170, 70);
			chartPanel.setBackground(Color.white);
			chartPanel.setVisible(true);
			chartPanel.setLayout(null);
			chartPanel.setFillZoomRectangle(true);
			chartPanel.setMouseWheelEnabled(true);
			chartPanel.setPreferredSize(new Dimension(250, 250));

			InstituteManagerFrame.setLayout(null);
			panelNow = chartPanel;
			InstituteManagerFrame.add(panelNow);
			InstituteManagerFrame.repaint();
		}
	}

	/*
	 * 修改密码事件监听
	 */
	class ChangePasswordListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			InstituteManagerFrame.remove(panelNow);
			InstituteManagerFrame.setTitle("院系管理员——更改密码");
			JPanel Panel = new YPanel();
			Panel.setSize(614, 400);
			Panel.setLocation(170, 70);
			Panel.setBackground(Color.white);
			Panel.setVisible(true);
			Panel.setLayout(null);

			JLabel label = new JLabel("新密码");
			label.setFont(new Font("微软雅黑", Font.BOLD, 16));
			label.setBounds(10, 10, 100, 30);
			Panel.add(label);
			label.setVisible(true);

			newPasswordField = new JTextField();
			newPasswordField.setBounds(130, 10, 160, 30);
			Panel.add(newPasswordField);
			newPasswordField.setVisible(true);

			InstituteManagerFrame.setLayout(null);
			panelNow = Panel;
			InstituteManagerFrame.add(panelNow);
			InstituteManagerFrame.repaint();

			JButton OkButton = new JButton("确定");
			OkButton.setFont(new Font("微软雅黑", Font.BOLD, 12));
			OkButton.setBounds(450, 10, 70, 30);
			OkButton.addActionListener(new changePasswordOkButtonListener());
			Panel.add(OkButton);
			OkButton.setVisible(true);
		}

		/*
		 * 修改密码确定按钮事件监听
		 */
		class changePasswordOkButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if (!newPasswordField.getText().equals("")) {
					instituteManagerBL.changePassword(ID,
							newPasswordField.getText());
					JOptionPane.showMessageDialog(null, "更改成功！");
				} else {
					JOptionPane.showMessageDialog(null, "密码不能为空！");
				}
			}

		}
	}

	/*
	 * 注销事件监听
	 */
	class LogoutListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			InstituteManagerFrame.dispose();
			new LoginFrame(new LoginBL());
		}
	}

}
