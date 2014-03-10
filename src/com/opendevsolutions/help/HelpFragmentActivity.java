package com.opendevsolutions.help;

import android.app.Activity;
import android.os.Bundle;

import com.opendevsolutions.braingain.R;

public class HelpFragmentActivity extends Activity {

	
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_help);
	}

}
