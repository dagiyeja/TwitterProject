package com.sist;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import java.io.*;
public class TwitterListener implements StatusListener{

	@Override
	public void onException(Exception ex) {
		// TODO Auto-generated method stub
		System.out.println(ex.getMessage());
	}

	@Override
	public void onDeletionNotice(StatusDeletionNotice arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onScrubGeo(long arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStallWarning(StallWarning arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatus(Status status) {
		//Ʈ���Ϳ��� ���� ���������� �ڵ����� ȣ���ϴ� �޼���
		String id=status.getUser().getScreenName(); //�۾� ��� ���̵� �о��
		String data=status.getText();
		System.out.println("@"+id+":"+data);
		try{
			FileWriter fw=new FileWriter("c:\\webDev\\twitter.txt",true); //true->�ؿ� ��� �ٿ���(append Mode)
			fw.write(data);
			fw.close();
		}catch(Exception ex){
			
		}
	}

	@Override
	public void onTrackLimitationNotice(int arg0) {
		// TODO Auto-generated method stub
		
	}

}
