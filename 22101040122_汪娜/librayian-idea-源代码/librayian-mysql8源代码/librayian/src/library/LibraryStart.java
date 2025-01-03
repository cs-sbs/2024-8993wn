package library;




import javax.swing.JFrame;
import javax.swing.UIManager;




public class LibraryStart {
	public static void main(String args[]) {
		 try {
	            JFrame.setDefaultLookAndFeelDecorated(true);
	            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");//Æ¤·ô°ü
		 }
	        catch (Exception ex) {
	            ex.printStackTrace();
	        }
	     	new menu(null);
	}
}