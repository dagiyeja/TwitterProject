package com.sist;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainClass {
	//[^A-Za-z] ->A는 빼고 영어 다, a부터 z까지
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] data={"문재인","안철수","홍준표","심상정","유승민", "박근혜","최순실","백원우"};
		Pattern[] p=new Pattern[data.length];
		for(int i=0; i<p.length; i++){
			p[i]=Pattern.compile(data[i]); 
		}
		try{
			String temp="";
			FileReader fr=new FileReader("C:\\webDev\\twitter.txt");
			int i=0;
			while((i=fr.read())!=-1){
				temp+=String.valueOf((char)i); //read의 반환형이 int
			}
			fr.close();
			String[] strData=temp.split("\n"); //데이터 갖고온다음, 한줄씩 나눔
			Matcher[] m=new Matcher[data.length];
			int[] count=new int[data.length];
 			for(int j=0; j<strData.length; j++)
			{
				for(int k=0; k<m.length; k++)
				{
					m[k]=p[k].matcher(strData[j]); //문자열에 p[i]가 포함되어 있으면 m[i]에 갖고온다
					if(m[k].find()) //단어가 포함되있다면 
					{
						count[k]++;
					}
				}
			}
 			String csv="";
			//reader writer 한글 들어가면 쓰는걸로 생각
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
