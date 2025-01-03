package library;

import javax.swing.*;

import java.awt.Container;
import java.awt.event.*;

public class manager extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	
	String readername;	
	
	
	JMenuBar menubar = new JMenuBar();
	JMenu m1=new JMenu("图书管理");
	JMenu m2=new JMenu("账户中心");
	JMenu m3=new JMenu("帮助菜单");
	JMenuItem item11=new JMenuItem("增加图书",new ImageIcon("image/login.jpg"));
	JMenuItem item12=new JMenuItem("删除图书",new ImageIcon("image/login.jpg"));
	JMenuItem item21=new JMenuItem("注册新管理员",new ImageIcon("image/key.jpg"));
	JMenuItem item22=new JMenuItem("删除管理员",new ImageIcon("image/query.jpg"));
	JMenuItem item23=new JMenuItem("删除用户",new ImageIcon("image/help.jpg"));
	JMenuItem item31=new JMenuItem("帮助",new ImageIcon("image/help.jpg"));

	
	
	
	/*JMenu meArray[] = { new JMenu("图书管理"), new JMenu("账户中心"), new JMenu("帮助") };
	JMenuItem item[] = { new JMenuItem("增加图书"), new JMenuItem("删除图书"),new JMenuItem("注册新管理员"),
			new JMenuItem("删除管理员"), new JMenuItem("删除用户"), new JMenuItem("帮助信息") };*/
	gaintb jsp;//表格类，从数据库获取表格
	JScrollPane JSP;//带滚动条的列表框，用来存放jsp类里获取的表格然后添加到容器
	

	public manager() {//构造函数
		init();//初始化
		jsp = new gaintb("books");
		JSP = jsp.rjsp();
		JSP.setBounds(0, 0, 800, 550);
		this.add(JSP);
	
		setLocation(250, 70);
		setVisible(true);
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
	}

	public void init() {
		setLayout(null);//格式布局为空
		Container c=getContentPane();
		c.add(menubar);
		menubar.add(m1);
		menubar.add(m2);
		menubar.add(m3);
		setTitle("后台管理中心");//设置标题
		m1.add(item11);
		m1.add(item12);
		item11.addActionListener(this);
		item12.addActionListener(this);
		m2.add(item21);
		m2.add(item22);
		m2.add(item23);
		item21.addActionListener(this);
		item22.addActionListener(this);
		item23.addActionListener(this);
		m3.add(item31);
		item31.addActionListener(this);
		/*meArray[0].add(item[0]);//菜单添加部件
		meArray[0].add(item[1]);
		meArray[1].add(item[2]);
		meArray[1].add(item[3]);
		meArray[1].add(item[4]);
		meArray[2].add(item[5]);
		for (int i = 0; i < meArray.length; i++) {
			menubar.add(meArray[i]);//将以上部件加入菜单条
		}*/
		setJMenuBar(menubar);//将菜单条放入布局里
//		addListener();//添加监听的函数
	}

/*	public void addListener() {
		for (int i = 0; i < item.length; i++) {
			item[i].addActionListener(this);//依次给菜单部件加监听
		}
	}*/

	public void actionPerformed(ActionEvent e) {
		try {//e.getSource()为响应事件，以下语句为当响应事件为菜单的哪一个部件
			if (e.getSource() == item11) {//增加图书
				new addook();
			} else if (e.getSource() == item12) {//删除图书
				new delete("books");
			} else if (e.getSource() == item21) {//注册新管理员
				new register();
			} else if (e.getSource() == item22) {//删除管理员
				new delete("admindt");
			}else if(e.getSource()==item23){//删除用户
				new delete("readers");
			}
			else if(e.getSource()==item31){//帮助
				new adm_help();
			}
		} catch (Exception ee) {
			ee.printStackTrace();//抛出异常
		}
	}
}