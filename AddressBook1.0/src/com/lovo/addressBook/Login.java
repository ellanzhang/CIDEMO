package  com.lovo.addressBook;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 *����ʵ���û���¼��Ϣ��У��*
 *�����������MainUI*
 *
 * ��ʾ�û������û���,�����3��Ϊ��*
 * ��ȷ�����û�������ʾ�������,�����3��Ϊ��*
 * ��ȷ�����������������MainUI*
 * By ��
 */
public class Login {
	/**
	 * ���췽��
	 */
	public  Login() {
		//�����û������ļ�
		Properties propAdmin = new Properties();	
		try{
			propAdmin.load(new FileInputStream("config/admin.properties"));
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		int i=3;//�����û�������Ϊ��
		String inputName=null;//������û���
		boolean checked = false;//��������ȷ,У��ͨ��:checked = true
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while(i > 0){
			    //��������û���,�˳�ѭ��
			    //�û�����ȷ,��������ο���,�˳�ѭ��
			    //�û�����ȷ,������ȷ,У��ͨ��,�˳�ѭ��
			    if(checked){
					break;
				 }
			    System.out.print("\n�������û���:");
		        try {
					inputName = bf.readLine().trim();
				} catch (IOException e) {
					e.printStackTrace();
				}
				//����û�����ȷ,���������
				if(inputName.equals(propAdmin.getProperty(inputName+".name"))){
					int j=3;//�����������Ϊ��
					String inputPwd = null;//����Ŀ���
					while(true){
						 if(j == 0){//������ο���
							i=0;//��iΪ0,ʹ�ϲ�ѭ����ֹ
							break;
						 }
					     System.out.print("\n���������:");
					     try {
							inputPwd = bf.readLine().trim();
						 } catch (IOException e) {
							e.printStackTrace();
						 }
						if(inputPwd.equals(propAdmin.getProperty(inputName+".password")))
							{
								checked = true;//У��ͨ��
								break;
							}else{
								System.out.print("�����ȷ");	
							    j--;
						   }
					}
				}else{
					System.out.print("���û�������");	
					i--;
				}
	    }	
		//У��ͨ��
		if(checked){
			new MainUI();
		}
		
	}
}
