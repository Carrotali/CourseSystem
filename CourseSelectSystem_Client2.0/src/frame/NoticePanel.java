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

// �����ϸ��Ϣ�ĵ�����
@SuppressWarnings("serial")
public class NoticePanel extends Dialog{
	private static final int DISTANCE = 40;
	private static final int OVER = 20;
	private static final Font FONT = new Font("΢���ź�", Font.PLAIN, 15);
	// Ƕ��Panel��ȣ��߶�
	MyButton ok;
	// ȷ�ϰ�ť
	JFrame frame;
	// ��ǰ����
	
	public NoticePanel(String[] details, String[] names, JFrame frame, JPanel panel,int w, int h) {
		super(frame,"",true);
		// ����֪ͨPanel��Bounds
		int length = details.length;
		int height = DISTANCE * 2 + length * OVER;
		int width = w * 2 / 5;
		this.frame = frame;
		// ����Ĳ���
				
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
		title.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, new Color(199,0,133)));
		title.setForeground(Color.WHITE);
		title.setHorizontalAlignment(JLabel.CENTER);
		gbc.gridwidth = 3;
		makeLabel(title,gbl,gbc,this);
		gbc.gridwidth = 1;
		
		// ������ʾ����Ϣ
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
		
		// ȷ�ϰ�ť
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
	
	// GridBagLayout����JLabel
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

