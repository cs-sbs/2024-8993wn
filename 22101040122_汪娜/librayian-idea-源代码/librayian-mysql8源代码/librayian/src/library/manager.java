package library;

import javax.swing.*;

import java.awt.Container;
import java.awt.event.*;

public class manager extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	
	String readername;	
	
	
	JMenuBar menubar = new JMenuBar();
	JMenu m1=new JMenu("ͼ�����");
	JMenu m2=new JMenu("�˻�����");
	JMenu m3=new JMenu("�����˵�");
	JMenuItem item11=new JMenuItem("����ͼ��",new ImageIcon("image/login.jpg"));
	JMenuItem item12=new JMenuItem("ɾ��ͼ��",new ImageIcon("image/login.jpg"));
	JMenuItem item21=new JMenuItem("ע���¹���Ա",new ImageIcon("image/key.jpg"));
	JMenuItem item22=new JMenuItem("ɾ������Ա",new ImageIcon("image/query.jpg"));
	JMenuItem item23=new JMenuItem("ɾ���û�",new ImageIcon("image/help.jpg"));
	JMenuItem item31=new JMenuItem("����",new ImageIcon("image/help.jpg"));

	
	
	
	/*JMenu meArray[] = { new JMenu("ͼ�����"), new JMenu("�˻�����"), new JMenu("����") };
	JMenuItem item[] = { new JMenuItem("����ͼ��"), new JMenuItem("ɾ��ͼ��"),new JMenuItem("ע���¹���Ա"),
			new JMenuItem("ɾ������Ա"), new JMenuItem("ɾ���û�"), new JMenuItem("������Ϣ") };*/
	gaintb jsp;//����࣬�����ݿ��ȡ���
	JScrollPane JSP;//�����������б���������jsp�����ȡ�ı��Ȼ����ӵ�����
	

	public manager() {//���캯��
		init();//��ʼ��
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
		setLayout(null);//��ʽ����Ϊ��
		Container c=getContentPane();
		c.add(menubar);
		menubar.add(m1);
		menubar.add(m2);
		menubar.add(m3);
		setTitle("��̨��������");//���ñ���
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
		/*meArray[0].add(item[0]);//�˵���Ӳ���
		meArray[0].add(item[1]);
		meArray[1].add(item[2]);
		meArray[1].add(item[3]);
		meArray[1].add(item[4]);
		meArray[2].add(item[5]);
		for (int i = 0; i < meArray.length; i++) {
			menubar.add(meArray[i]);//�����ϲ�������˵���
		}*/
		setJMenuBar(menubar);//���˵������벼����
//		addListener();//��Ӽ����ĺ���
	}

/*	public void addListener() {
		for (int i = 0; i < item.length; i++) {
			item[i].addActionListener(this);//���θ��˵������Ӽ���
		}
	}*/

	public void actionPerformed(ActionEvent e) {
		try {//e.getSource()Ϊ��Ӧ�¼����������Ϊ����Ӧ�¼�Ϊ�˵�����һ������
			if (e.getSource() == item11) {//����ͼ��
				new addook();
			} else if (e.getSource() == item12) {//ɾ��ͼ��
				new delete("books");
			} else if (e.getSource() == item21) {//ע���¹���Ա
				new register();
			} else if (e.getSource() == item22) {//ɾ������Ա
				new delete("admindt");
			}else if(e.getSource()==item23){//ɾ���û�
				new delete("readers");
			}
			else if(e.getSource()==item31){//����
				new adm_help();
			}
		} catch (Exception ee) {
			ee.printStackTrace();//�׳��쳣
		}
	}
}