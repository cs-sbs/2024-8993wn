package library;


import javax.swing.*;

import java.awt.event.*;
import java.sql.*;
import java.awt.*;
public class UserMain extends JFrame implements ActionListener {
	gaintb jsp;
	JScrollPane JSP;
	JPanel jpl;
	String namep=null;
	 CardLayout card=new CardLayout();
	 JPanel cardPanel=new JPanel();
	 static Dimension deSize;
	 static Toolkit toolkit=Toolkit.getDefaultToolkit();
	 JLabel backgroud;
	 JButton jb=new JButton("����");
	JMenuBar menubar=new JMenuBar();
	JMenu m1=new JMenu("���˿ռ�");
	JMenu m2=new JMenu("����ϵͳ");
	JMenu m3=new JMenu("�����˵�");
	JMenuItem item11=new JMenuItem("������Ϣ",new ImageIcon("image/login.jpg"));
	JMenuItem item21=new JMenuItem("����",new ImageIcon("image/key.jpg"));
	JMenuItem item22=new JMenuItem("����",new ImageIcon("image/query.jpg"));
	JMenuItem item31=new JMenuItem("����",new ImageIcon("image/help.jpg"));
	private Container contentPane;

	 String sql="";
	 connectdt jdbc = new connectdt();//�������ݿ���
		Connection conn = jdbc.conn;
		Statement stmt = jdbc.stmt;
	public UserMain(String	p1) {

		namep=p1;
		init();
		deSize=toolkit.getScreenSize();//��ȡ��Ļ��С
		setLocation(deSize.width/3-getWidth()/2, 
		deSize.height/4-getHeight()/2);
		setVisible(true);
		setSize(700, 550);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
	}
	
	
	
	
	public void init(){
			backgroud=new JLabel(new ImageIcon("image/usermain.jpg"));
			
			backgroud.add(jb);
			jb.setOpaque(false);
			cardPanel.setLayout(card);
			setTitle("��������");//���ñ���
			//���ù���
			Container c=getContentPane();
			c.add(menubar);
			c.add(jb);
			c.add(backgroud);
			
			menubar.add(m1);
			menubar.add(m2);
			menubar.add(m3);
			
			setJMenuBar(menubar);
			setVisible(true);
			//��һ�ַ���
			
			//ϵͳ����˵���
			m1.add(item11);


			item11.addActionListener(this);


			//���˹���˵���
			m2.add(item21);
			m2.add(item22);
			item21.addActionListener(this);
			item22.addActionListener(this);
			//����˵���
			m3.add(item31);
			item31.addActionListener(this);
			//��������˵���		
			m2.setEnabled(true);
			m3.setEnabled(true);

			
				
			
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {

		try{
			
			if (e.getSource()==item11) {//���˿ռ�
				new zone(namep);
			}else if(e.getSource()==item21){//����
				new select_borrow(namep);
			}
			else if(e.getSource()==item22){//����
			
			 new Return_Book(namep);
			}
			else if(e.getSource()==item31){
				new menu_help();
			}
			

	} catch (Exception ee) {
		ee.printStackTrace();
	}
}
}		

