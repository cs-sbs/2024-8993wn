package library;



import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Return_Book extends JFrame implements ActionListener{
		private static final long serialVersionUID = 1L;
		//JPanel myp=new JPanel();
		JTable jtable;
		JScrollPane JSP;
		CardLayout card=new CardLayout();
		JLabel titback=new JLabel("选择还书名称");
		JButton suback=new JButton("还书");
		JTextField bid=new JTextField();
		//JPanel cardPanel=new JPanel();
		String namep=null;
		JPanel jpl;
		Vector<Object> coldata = new Vector<Object>(1);
		Vector<Object> rowdata = new Vector<Object>(1);
		String sql,nm;
		int fine=0;
		public Return_Book(String p1){
			namep=p1;
			//init();
		//	add(cardPanel);
			//jsp = new gaintb("books");
			//JSP = jsp.rjsp();
			//JSP.setBounds(0, 0, 800, 550);
			//cardPanel.add(JSP,"browse");
			if(namep!=null){
				zone cp6=new zone(namep);
				jpl=cp6.gainpl();
				suback.setBounds(580, 440, 80, 30);
				titback.setBounds(400, 440, 100, 30);
				bid.setBounds(500, 440, 50, 30);
				jpl.add(suback);
				jpl.add(titback);
				jpl.add(bid);
				suback.addActionListener(this);
				bid.addActionListener(this);
				//cardPanel.add(jpl,"zone");
				//card.show(cardPanel,"zone");
				if(cp6.gainfine()>0){
					JOptionPane.showMessageDialog(null, "请先交纳罚款");
					return;
				}
			}
			setLocation(150, 150);
			setVisible(true);
			setSize(5, 5);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setResizable(false);

		}
//		public JPanel gainpl(){
//			//init();
//			return myp;
//		}
		public int gainfine(){
			return fine;
		}

	JTextField idField = new JTextField();
	JButton submit = new JButton("删除");
	connectdt jdbc = new connectdt();
	Connection conn = jdbc.conn;
	Statement stmt = jdbc.stmt;
	gaintb jsp;

	public void init() {
		 //cardPanel.setLayout(card);//网格布局
		
			//常用功能
			//Container c=getContentPane();

	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
		if(e.getSource()==suback){//还书
			
			String temp=bid.getText();
			if(temp.equals("")){
				JOptionPane.showMessageDialog(null, "输入不能为空");
				return;
			}
			sql="select * from borrow where book='"+temp+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if(!rs.next()){
				JOptionPane.showMessageDialog(null, "输入不存在");
				return;
			}
			sql="delete from borrow where book='"+temp+"'";
			stmt.executeUpdate(sql);
			sql="update books set STOCK=STOCK+1 where TITLE='"+temp+"';";
			stmt.executeUpdate(sql);
			sql="";
			JOptionPane.showMessageDialog(null, "还书成功");
		}
		
	} catch (Exception ee) {
		ee.printStackTrace();
	}
	}
}


