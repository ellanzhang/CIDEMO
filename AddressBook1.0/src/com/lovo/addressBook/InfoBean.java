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
	 * ����û�
	 */
	public void add(){
		try {
			propTel.load(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//�����û���Ϣ
		System.out.print("\n�����û���:");
		String uName = sc.next().trim();
		System.out.print("\n����绰����:");
		String uPhone = sc.next().trim();
		System.out.print("\n��������:");
		String uAge = sc.next().trim();
		System.out.print("\n�����Ա�(M/F):");
		String uSex = sc.next().trim();
		
		//����
		propTel.setProperty(uName+".name", uName);
		propTel.setProperty(uName+".phone",uPhone);
		propTel.setProperty(uName+".age",uAge);
		propTel.setProperty(uName+".sex",uSex);
		
		//����
		try {
			propTel.store(new FileOutputStream(file), null);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("\n�����Ϣ�ɹ�");
	}
	
	/**
	 * ��Ϣ��ѯ
	 */
	public void query(){
		try {
			propTel.load(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.print("\n����Ҫ��ѯ���û���:");
		String uName = sc.next().trim();
		
		//��ѯ
		if(propTel.containsKey(uName+".name")){
			System.out.println("����\t\t\t�Ա�\t����\t�绰");
			System.out.println(uName+"\t"
			       		        +propTel.getProperty(uName+".sex")+"\t"
			       		        +propTel.getProperty(uName+".age")+"\t"
			       		        +propTel.getProperty(uName+".phone")+"\t"
			                );
		}else{
			System.out.println("��ѯ-���޴��û�");
		}
	}
	
	/**
	 * �޸��û���Ϣ
	 */
	public void modify(){
		try {
			propTel.load(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.print("\n����Ҫ�޸ĵ��û�:");
		String uName = sc.next().trim();
		
		//�޸Ŀ���
		if(propTel.containsKey(uName+".name")){
			 System.out.println("\t��1:�޸��Ա� ");
			 System.out.println("\t��2:�޸����䡿 ");
			 System.out.println("\t��3:�޸ĵ绰�� ");
			 System.out.println("\t��4:��       ���� ");
			 
			 while(true){
			      System.out.print("\n����Ҫ�޸ĵ�����: ");
			      int option = sc.nextInt();
			      switch(option){
			           case 1:update(uName+".sex");break;
			           case 2:update(uName+".age");break;
			           case 3:update(uName+".phone");break;
			           case 4:return;
			           default:System.out.print("��������,������1-4������");
			      }
			 }
		}else{
			System.out.println("�޸�-���޴��û�");
		}
    }
	//�޸��û���Ϣ��������ֵ
	private void update(String attribute){
		try {
			propTel.load(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//�����û�����
		System.out.print("\n��������ֵ:");
		String input = sc.next();
		
		propTel.setProperty(attribute, input);
		
		try {
			propTel.store(new FileOutputStream(file), null);
			System.out.println("�޸ĳɹ�");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
