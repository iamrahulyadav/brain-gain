package com.opendevsolutions.braingain;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

public class SplashActivity extends Activity {

	private ProgressBar mProgress;
	private int mProgressStatus = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);

		mProgress = (ProgressBar) findViewById(R.id.loadingProgress);

		new Thread(myThread).start();
	}
	
	private Runnable myThread = new Runnable(){
		@Override
		public void run(){
			while(mProgressStatus <= 5){
				try{
					mHandler.sendMessage(mHandler.obtainMessage());
					Thread.sleep(1000);
				}catch(Throwable t){
					
				}
				if(mProgressStatus == 5){
					Intent i = new Intent(SplashActivity.this, MainActivity.class);
					startActivity(i);
					finish();
				}
			}	
		}
		
		@SuppressLint("HandlerLeak")
		private Handler mHandler = new Handler(){
			@Override
			public void handleMessage(Message msg){
				mProgressStatus++;
				mProgress.setProgress(mProgressStatus);
			}
		};
	};
}
