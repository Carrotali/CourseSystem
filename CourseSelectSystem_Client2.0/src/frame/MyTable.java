package frame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Enumeration;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class MyTable extends JTable {
	private static final long serialVersionUID = 32L;
	// id
	private JScrollPane pane;
	private JFrame frame;
	// ����table��ScrollPane
	private int HEIGHT;
	private int WIDTH;
	private int SIZE = 4;
	private static final int SCROLLSIZE = 15;
	private static final Font FONT = new Font("΢���ź�",Font.PLAIN,13);
	
	private JComponent component = null;
	private int sign;
	// ������ǰ���ĸ��û�
	private boolean special = false;
	// �Ƿ����⴦���������¼������
	
	public MyTable(String[][] data, String[] columnName, JFrame frame, int w, int h, int size) {
		super(data,columnName);
		// ����table
		this.frame = frame;
		this.HEIGHT = h;
		this.WIDTH = w;
		this.SIZE = size;
		// ��ʼ��
		init(data,columnName);
	}
	
	public MyTable(String[][] data, String[] columnName,JFrame frame, int w, int h, boolean special) {
		super(data,columnName);
		// ����table
		this.frame = frame;
		this.HEIGHT = h;
		this.WIDTH = w;
		this.special = special;
		// ��ʼ��
		init(data,columnName);
	}
	
	// ��ʼ��
	public void init(String[][] data, String[] columnName) {
		// �õ���ʾ
		makeface(this);
		FitTableColumns(this);
		makeHeader(this);
		// �Զ���ScrollPane
		this.addMouseListener(new Info(this,columnName,data));
		// ����˫���͵����¼�
		pane = new JScrollPane(this);//�������������
		pane.setSize(new Dimension(WIDTH,HEIGHT));
		pane.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));
		pane.getVerticalScrollBar().setUI(new MyScrollBarUI());
		pane.getHorizontalScrollBar().setUI(new MyScrollBarUI());
		pane.setBackground(Color.WHITE);
		pane.setWheelScrollingEnabled(true);
		pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	}
	
	// ���ScrollPane
	public JScrollPane getScrollPane() {
		return pane;
	}
	
	// �����޸�
	public boolean isCellEditable(int row, int column) {
		if (special && column == 3) {
			// ��ǰ�����пɱ༭
			return true;
		}
		return false;
	}
	
	// �µ�ScrollPane������
	class MyScrollBarUI extends BasicScrollBarUI {
        @Override
        protected JButton createDecreaseButton(int orientation) {
            return new MyArrowButton(orientation, //���Լ��ļ�ͷ���Ĭ�ϵ�
                    UIManager.getColor("ScrollBar.thumb"),
                    UIManager.getColor("ScrollBar.thumbShadow"),
                    UIManager.getColor("ScrollBar.thumbDarkShadow"),
                    UIManager.getColor("ScrollBar.thumbHighlight"));
        }
        
        @Override
        protected JButton createIncreaseButton(int orientation) {
            return new MyArrowButton(orientation, //���Լ��ļ�ͷ���Ĭ�ϵ�
                    UIManager.getColor("ScrollBar.thumb"), 
                    UIManager.getColor("ScrollBar.thumbShadow"), 
                    UIManager.getColor("ScrollBar.thumbDarkShadow"), 
                    UIManager.getColor("ScrollBar.thumbHighlight"));
        }
        
        //���ǻ����϶����Ĳ���
        @Override
        protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
            //super.paintThumb(g, c, thumbBounds);
            //����ԭ�����϶����ѿ�������д���g�����������ػ���һ������
            g.setColor(Color.LIGHT_GRAY);
           // g.setColor(Color.black);
            g.fillRoundRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height,10,10);
//            g.setColor(Color.GRAY);
//            g.drawRoundRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height-1,10,10);
            g.setColor(Color.WHITE);
            g.drawRoundRect(thumbBounds.x+1, thumbBounds.y+1, thumbBounds.width-3, thumbBounds.height-3,10,10);
        }
        
        // ���ƹ������µı���
        protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds)
        {
            g.setColor(Color.WHITE);
            g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);

            if(trackHighlight == DECREASE_HIGHLIGHT)        {
                paintDecreaseHighlight(g);
            }
            else if(trackHighlight == INCREASE_HIGHLIGHT)           {
                paintIncreaseHighlight(g);
            }
        }
    }
    
    //��д��ͷ��ť����Ĭ�ϴ�С��Ϊ0
    class MyArrowButton extends BasicArrowButton {
        private static final long serialVersionUID = 1L;
        public MyArrowButton(int direction, Color background, Color shadow,
                Color darkShadow, Color highlight) {
            super(direction, background, shadow, darkShadow, highlight);
        }
        
        @Override
        public Dimension getPreferredSize() {//����ͷĬ�ϴ�С���0
            return new Dimension(0, 0);
        }
        
        @Override
        public Dimension getMinimumSize() {//����ͷ��С��С���0
            return new Dimension(0, 0);
        }
    }
	
	// ����table
	public void makeface(JTable table) {
    	// �п����
    	table.setRowHeight(20);   	
    	table.setFont(new Font("΢���ź�",Font.PLAIN,15));
		table.setShowGrid(false);
    	
    	table.getTableHeader().setReorderingAllowed(false);// ����JTableÿ���ֶε�˳�򲻿��Ըı�
    	try {
    		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
				private static final long serialVersionUID = 33L;

				public Component getTableCellRendererComponent(JTable table,
    					Object value, boolean isSelected, boolean hasFocus,
    						int row, int column) {
    				if (row % 2 == 0) {
    					setBackground(Color.white); // ���������е�ɫ
    				}
    				else if (row % 2 == 1)
    					setBackground(new Color(206, 231, 255)); // ����ż���е�ɫ
    				return super.getTableCellRendererComponent(table, value,
	        isSelected, hasFocus, row, column);
    			}
    		};
    		for (int i = 0; i < table.getColumnCount(); i++) {
    			table.getColumn(table.getColumnName(i)).setCellRenderer(tcr);
    		}
    		tcr.setHorizontalAlignment(JLabel.CENTER);
    		table.setDefaultRenderer(Object.class,tcr);
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
	}
	
	// ����Ӧ�п�
	public void FitTableColumns(JTable myTable){
		if (myTable.getColumnCount() < SIZE) {
			SIZE = myTable.getColumnCount();
		}
		// �ȹ涨��size��С���滻��
		
		int sumLess = 0;
		// ���������Ŀ��
	    JTableHeader header = myTable.getTableHeader();	
	    int rowCount = myTable.getRowCount();
	    
	    Enumeration<?> columns = myTable.getColumnModel().getColumns();
	    while(columns.hasMoreElements()){	    	
	        TableColumn column = (TableColumn)columns.nextElement();
	        int col = header.getColumnModel().getColumnIndex(column.getIdentifier());
	        int width = (int)myTable.getTableHeader().getDefaultRenderer()
	                .getTableCellRendererComponent(myTable, column.getIdentifier()
	                        , false, false, -1, col).getPreferredSize().getWidth();
	        for(int row = 0; row<rowCount; row++){
	            int preferedWidth = (int)myTable.getCellRenderer(row, col).getTableCellRendererComponent(myTable,
	              myTable.getValueAt(row, col), false, false, row, col).getPreferredSize().getWidth();
	            width = Math.max(width, preferedWidth);
	        } 
	        header.setResizingColumn(column); // ���к���Ҫ
	        column.setWidth(width+myTable.getIntercellSpacing().width);
	    }
	    
		// ���ص�4��֮���������
    	DefaultTableColumnModel dtcm = (DefaultTableColumnModel) myTable.getColumnModel();
    	for (int i = SIZE; i < myTable.getColumnCount(); i++) {
    		dtcm.getColumn(i).setMinWidth(0);
    		dtcm.getColumn(i).setMaxWidth(0);
    	}
    	
	    // �������¶�����ľ���
	    for(int col = 0; col < SIZE; col++){
	    	sumLess += myTable.getColumnModel().getColumn(col).getWidth();
        }
	    int extra = WIDTH - sumLess - SCROLLSIZE;
	    extra = extra / SIZE;
	    for(int col = 0; col<myTable.getColumnCount(); col++){
	    	TableColumn columnnew = myTable.getColumnModel().getColumn(col);
	    	columnnew.setWidth(columnnew.getWidth() + extra);
	    }
	}
	
	public void makeHeader(JTable table) {
		JLabel[] headers = new JLabel[SIZE];
		for (int i = 0; i < SIZE; i++) {
			headers[i] = new JLabel("");
			headers[i].setText(table.getColumnModel().getColumn(i).getHeaderValue().toString());
			headers[i].setBackground(new Color(199, 0, 133));
			headers[i].setForeground(Color.WHITE);
			headers[i].setOpaque(true);
			headers[i].setHorizontalAlignment(JLabel.CENTER);
			headers[i].setFont(FONT);
			headers[i].setBorder(BorderFactory.createEmptyBorder());
		}
		
		// ����HeaderΪ�Զ����Header
		CustomTableHeader cth = new CustomTableHeader();
		TableColumnModel tcm = table.getColumnModel();
		for(int i = 0; i< SIZE; i++){  
			//����ÿһ�е���Ⱦ����Ȼ��Ϊ�������¸�ֵ  
	        tcm.getColumn(i).setHeaderRenderer(cth);  
	        tcm.getColumn(i).setHeaderValue(headers[i]);  
	    }  
	}
	
	// �Զ���HeaderΪһ��Label
	class CustomTableHeader implements TableCellRenderer {
	  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,   
	      boolean hasFocus, int row, int column) {   
			return (JLabel)value;//��������Ԫ�ص�����ΪJLabel��ֱ�ӷ��ؼ���
	  }   
	}

	// ����table��˫��
	class Info extends MouseAdapter {
		JTable thisTable;
		String[] names;
		String[][] infos;
		
		public Info(JTable t, String[] n, String[][] i) {
			super();
			this.thisTable = t;
			this.names = n;
			this.infos = i;
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2) {
				// ˫���¼�,��ʾ������Ϣ
				// ��ö�����Ϣ
				String[] extraNames = null;
				String[] extraInfo = null;
				if (thisTable.getColumnCount() > SIZE) {
					int size = thisTable.getColumnCount() - SIZE;
					extraNames = new String[size];
					extraInfo = new String[size];
					for (int i = 0; i < size; i++) {
						extraNames[i] = names[i + SIZE];
						extraInfo[i] = infos[((JTable)e.getSource()).rowAtPoint(e.getPoint())][i + SIZE];
						if (extraInfo[i].equals("")) {
							extraInfo[i] = "��";
						}
					}
				} else {
					// û�ж�����Ϣ
					extraNames = new String[]{"No"};
					extraInfo = new String[]{"Information"};
				}
				new JumpPanel(extraInfo,extraNames,frame,pane,pane.getWidth(),pane.getHeight());
			} else {
				if (component != null) {
					switch(sign) { 
					case 0:
						((JTextArea) component).setText(Arrays.toString(StudentMainFrame.studentBL.checkSchoolCourse(
								infos[((JTable)e.getSource()).rowAtPoint(e.getPoint())][1])));
						break;
					case 1:
						((JTextArea) component).setText(Arrays.toString(SchoolTeacherMainFrame.schoolTeacherBL.checkSchoolCourse(
								infos[((JTable)e.getSource()).rowAtPoint(e.getPoint())][1])));
						break;
					case 2:
						((JTextArea) component).setText(Arrays.toString(InstituteTeacherMainFrame.instituteTeacherBL.checkCoInfro(
								infos[((JTable)e.getSource()).rowAtPoint(e.getPoint())][1])));
						break;
					case 3:
						((JTextArea) component).setText(Arrays.toString(TeacherMainFrame.teacherBL.getCourseInfor(
								infos[((JTable)e.getSource()).rowAtPoint(e.getPoint())][1])));
						TeacherMainFrame.selectedNo = infos[((JTable)e.getSource()).rowAtPoint(e.getPoint())][1];
						break;
					case 4:
						((JTextArea) component).setText(Arrays.toString(InstituteManagerMainFrame.instituteManagerBL.checkCoInfro(
								infos[((JTable)e.getSource()).rowAtPoint(e.getPoint())][1])));
						break;
					}
				}
			}
		}
	}
	
	// �������
	public void setComponent(JComponent c, int sign) {
		this.component = c;
		this.sign = sign;
	}
	
	// ����size
	public void setSize(int size) {
		this.SIZE = size;
	}
}
