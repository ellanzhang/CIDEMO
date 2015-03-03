package  com.lovo.addressBook;


/**
 * 通讯录程序
 *
 * @author Gong
 * @version 0.90 2008/2/23
 * 显示欢迎界面与登录提示
 * *
 * 本类调用了类Login
 */
 
public class AddressBook {
    
    public static void main(String[] args) {
    	
    	// 显示欢迎界面
    	System.out.println();
    	System.out.println("\t\t*************************************");
        System.out.println("\t\t\t          欢迎使用通讯录");
        System.out.println("\t\t制作人：Gong");
        System.out.println("\t\t版    本：0.90");
        System.out.println("\t\t时    间：2008-2-23");
        System.out.println("\t\t*************************************");
        
        //显示登录提示
        new Login();
    }
}
