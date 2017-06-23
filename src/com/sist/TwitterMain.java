package com.sist;

import twitter4j.FilterQuery;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
//Twitter => 데이터 검색: 파일에 저장
//언급횟수=>저장
//저장데이터=>R=>그래프
public class TwitterMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			TwitterStream ts=new TwitterStreamFactory().getInstance();
			String[] data={"문재인","안철수","홍준표","심상정","유승민", "박근혜","최순실","백원우"};
			FilterQuery fq=new FilterQuery(); //데이터를 한번에 묶어서 처리
			fq.track(data);
			TwitterListener list=new TwitterListener();
			ts.addListener(list);
			ts.filter(fq);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}

}
