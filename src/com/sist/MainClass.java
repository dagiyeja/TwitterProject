package com.sist;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainClass {
	//[^A-Za-z] ->A�� ���� ���� ��, a���� z����
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] data={"������","��ö��","ȫ��ǥ","�ɻ���","���¹�", "�ڱ���","�ּ���","�����"};
		Pattern[] p=new Pattern[data.length];
		for(int i=0; i<p.length; i++){
			p[i]=Pattern.compile(data[i]); 
		}
		try{
			String temp="";
			FileReader fr=new FileReader("C:\\webDev\\twitter.txt");
			int i=0;
			while((i=fr.read())!=-1){
				temp+=String.valueOf((char)i); //read�� ��ȯ���� int
			}
			fr.close();
			String[] strData=temp.split("\n"); //������ ����´���, ���پ� ����
			Matcher[] m=new Matcher[data.length];
			int[] count=new int[data.length];
 			for(int j=0; j<strData.length; j++)
			{
				for(int k=0; k<m.length; k++)
				{
					m[k]=p[k].matcher(strData[j]); //���ڿ��� p[i]�� ���ԵǾ� ������ m[i]�� ����´�
					if(m[k].find()) //�ܾ ���Ե��ִٸ� 
					{
						count[k]++;
					}
				}
			}
 			String csv="";
			//reader writer �ѱ� ���� ���°ɷ� ����
 			for(int k=0; k<data.length; k++)
 			{
 				System.out.println(data[k]+":"+count[k]);
 				csv+=data[k]+" "+count[k]+"\n";
 			}
 			FileWriter fw=new FileWriter("c:\\webDev\\data.txt");
 			fw.write(csv);
 			fw.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}

}
