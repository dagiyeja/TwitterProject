package com.sist;

import twitter4j.FilterQuery;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
//Twitter => ������ �˻�: ���Ͽ� ����
//���Ƚ��=>����
//���嵥����=>R=>�׷���
public class TwitterMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			TwitterStream ts=new TwitterStreamFactory().getInstance();
			String[] data={"������","��ö��","ȫ��ǥ","�ɻ���","���¹�", "�ڱ���","�ּ���","�����"};
			FilterQuery fq=new FilterQuery(); //�����͸� �ѹ��� ��� ó��
			fq.track(data);
			TwitterListener list=new TwitterListener();
			ts.addListener(list);
			ts.filter(fq);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}

}
