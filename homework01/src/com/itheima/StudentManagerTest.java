package com.itheima;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * �����ҵ�ѧ������ϵͳ������
 * 
 * �������£�
 * A:����ѧ����
 * B:ѧ������ϵͳ��������Ĵ����д
 * C:ѧ������ϵͳ�Ĳ鿴����ѧ���Ĵ����д
 * D:ѧ������ϵͳ�����ѧ���Ĵ����д
 * E:ѧ������ϵͳ��ɾ��ѧ���Ĵ����д
 * F:ѧ������ϵͳ���޸�ѧ���Ĵ����д
 */
public class StudentManagerTest {
	public static void main(String[] args) throws IOException{
		//�����ļ�·��
		String fileName = "students.txt";
		
		//Ϊ���ó����ܹ��ص�������������ʹ��ѭ��
		while(true) {
			//����ѧ������ϵͳ��������
			System.out.println("--------��ӭ����ѧ���ɼ�����ϵͳ--------");
			System.out.println("1 �鿴����ѧ���ɼ�");
			System.out.println("2 ���ѧ���ɼ�");
			System.out.println("3 ɾ��ѧ���ɼ�");
			System.out.println("4 �޸�ѧ���ɼ�");
			System.out.println("5 �˳�");
			System.out.println("���������ѡ��");
			//��������¼�����
			Scanner sc = new Scanner(System.in);
			String choiceString = sc.nextLine();
			//��switch���ʵ��ѡ��
			switch(choiceString) {
			case "1":
				//�鿴����ѧ��
				findAllStudent(fileName);
				break;
			case "2":
				//���ѧ��
				addStudent(fileName);
				break;
			case "3":
				//ɾ��ѧ��
				deleteStudent(fileName);
				break;
			case "4":
				//�޸�ѧ��
				updateStudent(fileName);
				break;
			case "5":
			default:
				System.out.println("лл���ʹ��");
				System.exit(0); //JVM�˳�
				break;
			}
		}
	}
	
	//���ļ��ж����ݵ�����
	public static void readData(String fileName,ArrayList<Student> array) throws IOException {
		//�������뻺��������
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		String line;
		while((line=br.readLine())!=null) {
			String[] datas = line.split(",");
			Student s = new Student();
			s.setId(datas[0]);
			s.setName(datas[1]);
			s.setClassRoom(datas[2]);
			s.setSubject(datas[3]);
			s.setResult( Float.parseFloat(datas[4]));
			array.add(s);
		}
		
		br.close();
	}
	
	//�Ѽ����е�����д���ļ�
	public static void writeData(String fileName,ArrayList<Student> array) throws IOException {
		//�����������������
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		
		for(int x=0; x<array.size(); x++) {
			Student s = array.get(x);
			StringBuilder sb = new StringBuilder();
			//sb.append(s.getId()).append(",").append(s.getName()).append(",").append(s.getClassRoom()).append(",").append(s.getSubject//()).append(",").append(s.getResult());
                                                //����15
                                                sb.append(s.getId()).append(",").append(s.getName()).append(",").append(s.getClassRoom())
                                                             .append(",").append(s.getSubject()).append(",").append(s.getResult());
			bw.write(sb.toString());
			bw.newLine();
			bw.flush();
		}
		
		bw.close();
	}
	
	//�޸�ѧ��
	public static void updateStudent(String fileName) throws IOException {
		//�������϶���
		ArrayList<Student> array = new ArrayList<Student>();
		//���ļ��а����ݶ�ȡ��������
		readData(fileName, array);
		
		//�޸�ѧ����˼·������¼��һ��ѧ�ţ���������ȥ���ң����Ƿ���ѧ��ʹ�õ��Ǹ�ѧ�ţ�����о��޸ĸ�ѧ��
		//��������¼�����
		Scanner sc = new Scanner(System.in);
		System.out.println("��������Ҫ�޸ĵ�ѧ����ѧ�ţ�");
		String id = sc.nextLine();
		
		//����һ������
		int index = -1;
		
		//��������
		for(int x=0; x<array.size(); x++) {
			//��ȡÿһ��ѧ������
			Student s = array.get(x);
			//��ѧ�������ѧ�źͼ���¼���ѧ�Ž��бȽ�
			if(s.getId().equals(id)) {
				index = x;
				break;
			}
		}
		
		if(index == -1) {
			System.out.println("������˼,��Ҫ�޸ĵ�ѧ�Ŷ�Ӧ��ѧ����Ϣ������,���ȥ�������ѡ��");
		}else {
			System.out.println("������ѧ����������");
			String name = sc.nextLine();
			System.out.println("������ѧ���°༶��");
			String classRoom = sc.nextLine();
			System.out.println("������ѧ���¿��Կ�Ŀ��");
			String subject = sc.nextLine();
			System.out.println("������ѧ���³ɼ���");
			String result = sc.nextLine();
			//����ѧ������
			Student s = new Student();
			s.setId(id);
			s.setName(name);
			s.setClassRoom(subject);
			s.setSubject(subject);
			s.setResult(Float.parseFloat(result));
			
			//�޸ļ����е�ѧ������
			array.set(index, s);
			//�Ѽ����е���������д�ص��ļ�
			writeData(fileName, array);
			//������ʾ
			System.out.println("�޸�ѧ���ɼ��ɹ�");
		}
	}
	
	//ɾ��ѧ��
	public static void deleteStudent(String fileName) throws IOException {
		//�������϶���
		ArrayList<Student> array = new ArrayList<Student>();
		//���ļ��а����ݶ�ȡ��������
		readData(fileName, array);
		
		//ɾ��ѧ����˼·������¼��һ��ѧ�ţ���������ȥ���ң����Ƿ���ѧ��ʹ�õ��Ǹ�ѧ�ţ�����о�ɾ����ѧ��
		//��������¼�����
		Scanner sc = new Scanner(System.in);
		System.out.println("��������Ҫɾ����ѧ����ѧ�ţ�");
		String id = sc.nextLine();
		
		//���Ǳ������ѧ�Ų����ڵ�ʱ�����ʾ
		
		//����һ������
		int index = -1;
		
		//��������
		for(int x=0; x<array.size(); x++) {
			//��ȡ��ÿһ��ѧ������
			Student s = array.get(x);
			//�����ѧ�������ѧ�źͼ���¼���ѧ�Ž��бȽ�
			if(s.getId().equals(id)) {
				index = x;
				break;
			}
		}
		
		if(index == -1) {
			System.out.println("������˼,��Ҫɾ����ѧ�Ŷ�Ӧ��ѧ����Ϣ������,���ȥ�������ѡ��");
		}else {
			array.remove(index);
			//�Ѽ����е���������д�ص��ļ�
			writeData(fileName, array);
			System.out.println("ɾ��ѧ���ɹ�");
		}
		
	}
	
	//���ѧ��
	public static void addStudent(String fileName) throws IOException {
		//�������϶���
		ArrayList<Student> array = new ArrayList<Student>();
		//���ļ��а����ݶ�ȡ��������
		readData(fileName, array);
				
		//��������¼�����
		Scanner sc = new Scanner(System.in);
		
		//Ϊ����id�ܹ������ʵ������ǾͰ�id��������ѭ��������
		String id;
		
		//Ϊ���ô����ܹ��ص������ѭ��
		while(true) {
			System.out.println("������ѧ��ѧ�ţ�");
			//String id = sc.nextLine();
			id = sc.nextLine();
			
			//�ж�ѧ����û�б���ռ��
			//������
			boolean flag = false;
			//�������ϣ��õ�ÿһ��ѧ��
			for(int x=0; x<array.size(); x++) {
				Student s = array.get(x);
				//��ȡ��ѧ����ѧ�ţ��ͼ���¼���ѧ�Ž��бȽ�
				if(s.getId().equals(id)) {
					flag = true; //˵��ѧ�ű�ռ����
					break;
				}
			}
			
			if(flag) {
				System.out.println("�������ѧ���Ѿ���ռ��,����������");
			}else {
				break; //����ѭ��
			}
		}
		
		
		System.out.println("������ѧ��������");
		String name = sc.nextLine();
		System.out.println("������ѧ���༶��");
		String classRoom = sc.nextLine();
		System.out.println("������ѧ�����Կ��Կ�Ŀ��");
		String subject = sc.nextLine();
		System.out.println("������ѧ�����Գɼ���");
		String result = sc.nextLine();
		
		//����ѧ������
		Student s = new Student();
		s.setId(id);
		s.setName(name);
		s.setClassRoom(classRoom);;
		s.setSubject(subject);
		s.setResult(Float.parseFloat(result));
		//��ѧ��������ΪԪ����ӵ�����
		array.add(s);
		//�Ѽ����е���������д�ص��ļ�
		writeData(fileName, array);
		
		//������ʾ
		System.out.println("���ѧ���ɹ�");
	}
	
	//�鿴����ѧ��
	public static void findAllStudent(String fileName) throws IOException {
		//�������϶���
		ArrayList<Student> array = new ArrayList<Student>();
		//���ļ��а����ݶ�ȡ��������
		readData(fileName, array);
		
		//�������жϼ������Ƿ������ݣ����û�����ݣ��͸�����ʾ�����ø÷�������������ִ��
		if(array.size() == 0) {
			System.out.println("������˼,Ŀǰû��ѧ���ɼ���Ϣ�ɹ���ѯ,���ȥ����ѡ����Ĳ���");
			return;
		}
		
		//\t ��ʵ����һ��tab����λ��
		System.out.println("ѧ��\t����\t�༶\t��Ŀ\t�ɼ�");
		for(int x=0; x<array.size(); x++) {
			Student s = array.get(x);
			System.out.println(s.getId()+"\t"+s.getName()+"\t"+s.getClassRoom()+"\t"+s.getSubject()+"\t"+s.getResult());
		}
	}
}
