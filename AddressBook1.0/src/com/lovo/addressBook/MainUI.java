package com.lovo.addressBook;

import java.util.Scanner;

public class MainUI {

	public MainUI() {
		System.out.println("\t\t  ----通讯录----\n");
	    System.out.println("\t\t【1：添加用户】 ");
	    System.out.println("\t\t【2：用户查询】");
	    System.out.println("\t\t【3：信息修改】");
	    System.out.println("\t\t【4：退出系统】\n");

        Scanner sc = new Scanner(System.in);
        InfoBean infoBean = new InfoBean();
	    while(true){
	         System.out.print("\n选择要执行的操作:");
	         switch(sc.nextInt()){
	             case 1:  infoBean.add();break;
	             case 2:  infoBean.query();break;
	             case 3:  infoBean.modify();break;
	             case 4:  System.exit(0);
	             default:System.out.print("输入有误,请输入1-4的整数");
	        }
	  }
  }
}
