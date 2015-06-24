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

// �����ϸ��Ϣ�ĵ�����
@SuppressWarnings("serial")
public class JumpPanel extends Dialog{
	private static final int DISTANCE = 50;
	private static final int OVER = 20;
	private static final Font FONT = new Font("΢���ź�", Font.PLAIN, 15);
	// Ƕ��Panel��ȣ��߶�
	MyButton ok;
	// ȷ�ϰ�ť
	JFrame frame;
	// ��ǰ����
	
	public JumpPanel(String[] details, String[] names, JFrame frame, JScrollPane panel,int w, int h) {
		super(frame,"",true);
		// ����֪ͨPanel��Bounds
		int length = details.length;
		int height = DISTANCE * 2 + length * OVER;
		int width = w / 3 * 2;
		int extra = 1;
		this.frame = frame;
		// ����Ĳ���
		
		//���
		if (height > h) {
			height = h / 3 * 2;
			width = height * 2;
		}
				
		// ��������
		this.setSize(width,height);
		this.setBackground(Color.WHITE);
		this.setUndecorated(true);
		this.setLocationRelativeTo(panel);
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;
		this.setLayout(gbl);
		
		// ������Ϣͷ
		JLabel title = new JLabel("������Ϣ");
		title.setFont(FONT);
		title.setOpaque(true);
		title.setBackground(new Color(199, 0, 133 ));
		title.setForeground(Color.WHITE);
		title.setHorizontalAlignment(JLabel.CENTER);
		gbc.gridwidth = 3;
		makeLabel(title,gbl,gbc,this);
		gbc.gridwidth = 1;
		
		// ������ʾ����Ϣ
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
			
			// �����ǰ����ʾ��������ȫ���Ͷ������һ��Label����ʾ��Ϣ
			if (label.getPreferredSize().getWidth() > width / 3 * 2) {
				int number = (int) label.getPreferredSize().getWidth() / (width / 3 * 2) + 1;
				// �ܹ�Ҫ�ֳɶ��ٶ�
				String info = label.getText();
				// Ҫ�ֿ�����Ϣ
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
				// ���һ��
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
			// �ָ�
		}
		
		// ȷ�ϰ�ť
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
	
	// GridBagLayout����JLabel
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

