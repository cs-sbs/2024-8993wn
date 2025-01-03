package library;

import javax.swing.*;

import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import java.awt.Window.Type;
public class menu extends JFrame implements ActionListener {

	JLabel lblLogo;
	JPanel jPanel;
	JMenuBar menubar=new JMenuBar();
	
	JMenu m1=new JMenu("ϵͳ����");
	JMenu m2=new JMenu("��ѯͼ����Ϣ");
	JMenu m3=new JMenu("����");
	JMenuItem item11=new JMenuItem("�û���¼",new ImageIcon("image/login.jpg"));
	JMenuItem item12=new JMenuItem("����Ա��¼",new ImageIcon("image/login.jpg"));
	JMenuItem item13=new JMenuItem("ע��",new ImageIcon("image/key.jpg"));
	JMenuItem item21=new JMenuItem("��ѯͼ����Ϣ",new ImageIcon("image/query.jpg"));
	JMenuItem item31=new JMenuItem("����",new ImageIcon("image/help.jpg"));
	
	private Container contentPane;
	static Dimension deSize;
	static Toolkit toolkit=Toolkit.getDefaultToolkit();
	JPanel cardPanel=new JPanel();	
	String namep=null;
	 
	 String sql="";
	 connectdt jdbc = new connectdt();//�������ݿ���
		Connection conn = jdbc.conn;
		Statement stmt = jdbc.stmt;
	/**
	 * @param p1
	 */
	public menu(String p1) {
		setResizable(false);
		
		namep=p1;
		init();
		
	
		deSize=toolkit.getScreenSize();//��ȡ��Ļ��С
		setLocation(deSize.width/3-getWidth()/2, 
			deSize.height/4-getHeight()/2);
		setVisible(true);
		setSize(400, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void init() {
//	    cardPanel.setLayout(card);//���񲼾�
		setTitle("ͼ�����ϵͳ");
		//���ù���
		Container c=getContentPane();
		c.add(menubar);
		menubar.add(m1);
		menubar.add(m2);
		menubar.add(m3);
		
		
		//��һ�ַ���
		
		//ϵͳ����˵���
		m1.add(item11);
		m1.add(item12);
		m1.add(item13);
		item11.addActionListener(this);
		item12.addActionListener(this);
		item13.addActionListener(this);
		//���˹���˵���
		m2.add(item21);
		item21.addActionListener(this);
		//����˵���
		m3.add(item31);
		item31.addActionListener(this);
		//��������˵���		
		m2.setEnabled(true);
		m3.setEnabled(true);

		
		setJMenuBar(menubar);
		lblLogo=new JLabel(new ImageIcon("image\\main.jpg"));//����
		getContentPane().add(lblLogo);
		
	
	}

	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource()==item11) {//�û���¼
				new login("readers","name","code","�û���¼");
				dispose();
			} else if(e.getSource()==item13){//ע��
				new user_regist();
			}else if(e.getSource()==item12){//��̨������Ա��
				new login("admindt","username","password","����Ա��¼");
				dispose();
			}
			else if (e.getSource()==item21) {//����ͼ��
				new select_borrow(namep);
			} 

			else if(e.getSource()==item31){//����
				new menu_help();
			}

		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}
}