package frame;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

// 获得详细信息的弹出框
@SuppressWarnings("serial")
public class JumpPanel extends Dialog{
	private static final int DISTANCE = 50;
	private static final int OVER = 20;
	private static final Font FONT = new Font("微软雅黑", Font.PLAIN, 15);
	// 嵌入Panel宽度，高度
	MyButton ok;
	// 确认按钮
	JFrame frame;
	// 当前界面
	
	public JumpPanel(String[] details, String[] names, JFrame frame, JScrollPane panel,int w, int h) {
		super(frame,"",true);
		// 计算通知Panel的Bounds
		int length = details.length;
		int height = DISTANCE * 2 + length * OVER;
		int width = w / 3 * 2;
		int extra = 1;
		this.frame = frame;
		// 额外的补充
		
		//规格化
		if (height > h) {
			height = h / 3 * 2;
			width = height * 2;
		}
				
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
		title.setForeground(Color.WHITE);
		title.setHorizontalAlignment(JLabel.CENTER);
		gbc.gridwidth = 3;
		makeLabel(title,gbl,gbc,this);
		gbc.gridwidth = 1;
		
		// 加入显示的信息
		for (int i = 0; i < length; i++) {
			JLabel name = new JLabel();
			name.setText(names[i]);
			name.setFont(FONT);
			name.setHorizontalAlignment(JLabel.CENTER);
			gbc.gridx = 0;
			gbc.gridy = i + extra;
			makeLabel(name,gbl,gbc,this);
	
			JLabel label = new JLabel();
			label.setFont(FONT);
			label.setText(details[i]);
			label.setHorizontalAlignment(JLabel.CENTER);
			gbc.gridx = 1;
			gbc.gridy = i + extra;
			gbc.gridwidth = 2;
			makeLabel(label,gbl,gbc,this);
			gbc.gridwidth = 1;
			
			// 如果当前的显示不足以完全，就额外添加一个Label来显示信息
			if (label.getPreferredSize().getWidth() > width / 3 * 2) {
				int number = (int) label.getPreferredSize().getWidth() / (width / 3 * 2) + 1;
				// 总共要分成多少段
				String info = label.getText();
				// 要分开的信息
				int infoLen = info.length();
				int cutLen = info.length() / number;
				
				label.setText(info.substring(0, cutLen));
				for (int j = 2; j < number; j++) {
					JLabel labelExtra = new JLabel();
					labelExtra.setFont(FONT);
					labelExtra.setText(info.substring(cutLen * (j - 1), cutLen * j));
					labelExtra.setHorizontalAlignment(JLabel.CENTER);
					gbc.gridx = 1;
					gbc.gridy = i + ++extra;
					gbc.gridwidth = 2;
					makeLabel(labelExtra,gbl,gbc,this);
					gbc.gridwidth = 1;
				}
				// 最后一个
				JLabel labelExtra = new JLabel();
				labelExtra.setFont(FONT);
				labelExtra.setText(info.substring(cutLen * (number - 1), infoLen));
				labelExtra.setHorizontalAlignment(JLabel.CENTER);
				gbc.gridx = 1;
				gbc.gridy = i + ++extra;
				gbc.gridwidth = 2;
				makeLabel(labelExtra,gbl,gbc,this);
				gbc.gridwidth = 1;
			}
			
			gbc.gridwidth = 1;
			// 恢复
		}
		
		// 确认按钮
		ok = new MyButton("OK");
		ok.addActionListener(new ReturnAction());
		gbc.gridx = 0;
		gbc.gridy = length + extra;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.RELATIVE;
		gbl.setConstraints(ok, gbc);
		this.add(ok);
		this.setVisible(true);
	}
	
	// GridBagLayout加入JLabel
	public void makeLabel(JLabel label, GridBagLayout gbl, GridBagConstraints c, Dialog panel) {
		c.fill = GridBagConstraints.BOTH;
		gbl.setConstraints(label, c);
		panel.add(label);
	}
	
	// ActionListener to no button
	class ReturnAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			frame.repaint();
		}
	}
}

