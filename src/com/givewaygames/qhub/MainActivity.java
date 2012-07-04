package com.givewaygames.qhub;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

import com.givewaygames.q.QHub;


public class MainActivity extends Activity {
	QHub qHub = new QHub(this);
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		qHub.onCreate();
		
		qHub.startRequestActivity();
	};
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		qHub.onActivityResult(requestCode, resultCode, data);
		
//		new Thread() {
//			public void run() {
//				int itr = 0;
//				while(true) {
//					try { Thread.sleep(2000); } catch (InterruptedException e) {}
//					if (qHub != null) qHub.sendMessage(""+itr);
//					itr++;
//				}
//			};
//		}.start();
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (qHub != null) qHub.sendMotionEvent(event);
		return super.onTouchEvent(event);
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		qHub.onStart();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		qHub.onResume();
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		qHub.onDestroy();
	}
}
