package com.lovo.addressBook;

import java.util.Scanner;

public class MainUI {

	public MainUI() {
		System.out.println("\t\t  ----ͨѶ¼----\n");
	    System.out.println("\t\t��1������û��� ");
	    System.out.println("\t\t��2���û���ѯ��");
	    System.out.println("\t\t��3����Ϣ�޸ġ�");
	    System.out.println("\t\t��4���˳�ϵͳ��\n");

        Scanner sc = new Scanner(System.in);
        InfoBean infoBean = new InfoBean();
	    while(true){
	         System.out.print("\nѡ��Ҫִ�еĲ���:");
	         switch(sc.nextInt()){
	             case 1:  infoBean.add();break;
	             case 2:  infoBean.query();break;
	             case 3:  infoBean.modify();break;
	             case 4:  System.exit(0);
	             default:System.out.print("��������,������1-4������");
	        }
	  }
  }
}
