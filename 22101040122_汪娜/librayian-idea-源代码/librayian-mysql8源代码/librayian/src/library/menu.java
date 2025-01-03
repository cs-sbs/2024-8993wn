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
	
	JMenu m1=new JMenu("系统管理");
	JMenu m2=new JMenu("查询图书信息");
	JMenu m3=new JMenu("帮助");
	JMenuItem item11=new JMenuItem("用户登录",new ImageIcon("image/login.jpg"));
	JMenuItem item12=new JMenuItem("管理员登录",new ImageIcon("image/login.jpg"));
	JMenuItem item13=new JMenuItem("注册",new ImageIcon("image/key.jpg"));
	JMenuItem item21=new JMenuItem("查询图书信息",new ImageIcon("image/query.jpg"));
	JMenuItem item31=new JMenuItem("帮助",new ImageIcon("image/help.jpg"));
	
	private Container contentPane;
	static Dimension deSize;
	static Toolkit toolkit=Toolkit.getDefaultToolkit();
	JPanel cardPanel=new JPanel();	
	String namep=null;
	 
	 String sql="";
	 connectdt jdbc = new connectdt();//连接数据库类
		Connection conn = jdbc.conn;
		Statement stmt = jdbc.stmt;
	/**
	 * @param p1
	 */
	public menu(String p1) {
		setResizable(false);
		
		namep=p1;
		init();
		
	
		deSize=toolkit.getScreenSize();//获取屏幕大小
		setLocation(deSize.width/3-getWidth()/2, 
			deSize.height/4-getHeight()/2);
		setVisible(true);
		setSize(400, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void init() {
//	    cardPanel.setLayout(card);//网格布局
		setTitle("图书管理系统");
		//常用功能
		Container c=getContentPane();
		c.add(menubar);
		menubar.add(m1);
		menubar.add(m2);
		menubar.add(m3);
		
		
		//第一种方法
		
		//系统管理菜单项
		m1.add(item11);
		m1.add(item12);
		m1.add(item13);
		item11.addActionListener(this);
		item12.addActionListener(this);
		item13.addActionListener(this);
		//个人管理菜单项
		m2.add(item21);
		item21.addActionListener(this);
		//管理菜单项
		m3.add(item31);
		item31.addActionListener(this);
		//帮助管理菜单项		
		m2.setEnabled(true);
		m3.setEnabled(true);

		
		setJMenuBar(menubar);
		lblLogo=new JLabel(new ImageIcon("image\\main.jpg"));//背景
		getContentPane().add(lblLogo);
		
	
	}

	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource()==item11) {//用户登录
				new login("readers","name","code","用户登录");
				dispose();
			} else if(e.getSource()==item13){//注册
				new user_regist();
			}else if(e.getSource()==item12){//后台（管理员）
				new login("admindt","username","password","管理员登录");
				dispose();
			}
			else if (e.getSource()==item21) {//查找图书
				new select_borrow(namep);
			} 

			else if(e.getSource()==item31){//帮助
				new menu_help();
			}

		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}
}