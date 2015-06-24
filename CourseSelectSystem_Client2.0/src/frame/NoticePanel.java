package frame;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// 获得详细信息的弹出框
@SuppressWarnings("serial")
public class NoticePanel extends Dialog{
	private static final int DISTANCE = 40;
	private static final int OVER = 20;
	private static final Font FONT = new Font("微软雅黑", Font.PLAIN, 15);
	// 嵌入Panel宽度，高度
	MyButton ok;
	// 确认按钮
	JFrame frame;
	// 当前界面
	
	public NoticePanel(String[] details, String[] names, JFrame frame, JPanel panel,int w, int h) {
		super(frame,"",true);
		// 计算通知Panel的Bounds
		int length = details.length;
		int height = DISTANCE * 2 + length * OVER;
		int width = w * 2 / 5;
		this.frame = frame;
		// 额外的补充
				
		// 基本设置
		this.setSize(width,height);
		this.setBackground(Color.WHITE);
		this.setUndecorated(true);
		this.setLocationRelativeTo(panel);
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;
		this.setLayout(gbl);
		
		// 加入信息头
		JLabel title = new JLabel("额外信息");
		title.setFont(FONT);
		title.setOpaque(true);
		title.setBackground(new Color(199, 0, 133 ));
		title.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, new Color(199,0,133)));
		title.setForeground(Color.WHITE);
		title.setHorizontalAlignment(JLabel.CENTER);
		gbc.gridwidth = 3;
		makeLabel(title,gbl,gbc,this);
		gbc.gridwidth = 1;
		
		// 加入显示的信息
		JLabel info = new JLabel(details[0]);
		info.setFont(FONT);
		info.setBackground(Color.WHITE);
		info.setHorizontalAlignment(JLabel.CENTER);
		info.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, new Color(199,0,133)));
		gbc.gridwidth = 3;
		gbc.gridx = 0;
		gbc.gridy = 1;
		makeLabel(info,gbl,gbc,this);
		gbc.gridwidth = 1;
		
		// 确认按钮
		JPanel back = new JPanel();
		back.setBackground(Color.WHITE);
		back.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, new Color(199,0,133)));
		back.setLayout(new FlowLayout());
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.BOTH;
		gbl.setConstraints(back, gbc);
		this.add(back);
		ok = new MyButton("OK");
		ok.addActionListener(new BackAction());
		back.add(ok);
//		gbc.gridx = 0;
//		gbc.gridy = length + extra;
//		gbc.gridwidth = 3;
//		gbc.fill = GridBagConstraints.RELATIVE;
//		gbl.setConstraints(ok, gbc);
//		this.add(ok);
		this.setVisible(true);
	}
	
	// GridBagLayout加入JLabel
	public void makeLabel(JLabel label, GridBagLayout gbl, GridBagConstraints c, Dialog panel) {
		c.fill = GridBagConstraints.BOTH;
		gbl.setConstraints(label, c);
		panel.add(label);
	}
	
	// ActionListener to no button
	class BackAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			frame.repaint();
		}
	}
}

