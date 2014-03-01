package com.opendevsolutions.abc;

import com.opendevsolutions.braingain.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class ABCQuizActivity extends Activity implements OnClickListener {

	public boolean part;
	
	public boolean getPart(){
		return part;
	}
	
	public void setPart(boolean aPart){
		part = aPart;
	}
	
	@Override
	public void onBackPressed() {
				
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if(getPart()){
			setContentView(R.layout.activity_abc_quiz_one);
		}else{
			setContentView(R.layout.activity_abc_quiz_two);
		}
	}

	@Override
	public void onClick(View v) {

	}

}
