package com.lovo.addressBook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class InfoBean {
	String file = "config/telephone.properties";
	Properties  propTel = new Properties();
	Scanner sc = new Scanner(System.in);
	/**
	 * 添加用户
	 */
	public void add(){
		try {
			propTel.load(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//输入用户信息
		System.out.print("\n输入用户名:");
		String uName = sc.next().trim();
		System.out.print("\n输入电话号码:");
		String uPhone = sc.next().trim();
		System.out.print("\n输入年龄:");
		String uAge = sc.next().trim();
		System.out.print("\n输入性别(M/F):");
		String uSex = sc.next().trim();
		
		//设置
		propTel.setProperty(uName+".name", uName);
		propTel.setProperty(uName+".phone",uPhone);
		propTel.setProperty(uName+".age",uAge);
		propTel.setProperty(uName+".sex",uSex);
		
		//保存
		try {
			propTel.store(new FileOutputStream(file), null);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("\n添加信息成功");
	}
	
	/**
	 * 信息查询
	 */
	public void query(){
		try {
			propTel.load(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.print("\n输入要查询的用户名:");
		String uName = sc.next().trim();
		
		//查询
		if(propTel.containsKey(uName+".name")){
			System.out.println("姓名\t\t\t性别\t年龄\t电话");
			System.out.println(uName+"\t"
			       		        +propTel.getProperty(uName+".sex")+"\t"
			       		        +propTel.getProperty(uName+".age")+"\t"
			       		        +propTel.getProperty(uName+".phone")+"\t"
			                );
		}else{
			System.out.println("查询-查无此用户");
		}
	}
	
	/**
	 * 修改用户信息
	 */
	public void modify(){
		try {
			propTel.load(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.print("\n输入要修改的用户:");
		String uName = sc.next().trim();
		
		//修改控制
		if(propTel.containsKey(uName+".name")){
			 System.out.println("\t【1:修改性别】 ");
			 System.out.println("\t【2:修改年龄】 ");
			 System.out.println("\t【3:修改电话】 ");
			 System.out.println("\t【4:退       出】 ");
			 
			 while(true){
			      System.out.print("\n输入要修改的属性: ");
			      int option = sc.nextInt();
			      switch(option){
			           case 1:update(uName+".sex");break;
			           case 2:update(uName+".age");break;
			           case 3:update(uName+".phone");break;
			           case 4:return;
			           default:System.out.print("输入有误,请输入1-4的整数");
			      }
			 }
		}else{
			System.out.println("修改-查无此用户");
		}
    }
	//修改用户信息单个属性值
	private void update(String attribute){
		try {
			propTel.load(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//接收用户输入
		System.out.print("\n请输入新值:");
		String input = sc.next();
		
		propTel.setProperty(attribute, input);
		
		try {
			propTel.store(new FileOutputStream(file), null);
			System.out.println("修改成功");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
