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
		//트위터에서 한줄 읽을때마다 자동으로 호출하는 메서드
		String id=status.getUser().getScreenName(); //글쓴 사람 아이디 읽어옴
		String data=status.getText();
		System.out.println("@"+id+":"+data);
		try{
			FileWriter fw=new FileWriter("c:\\webDev\\twitter.txt",true); //true->밑에 계속 붙여서(append Mode)
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
