package com.opendevsolutions.sql.lib;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.opendevsolutions.braingain.R;

public class SQLViewActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sql_layout);
		
		TextView lesson = (TextView) findViewById(R.id.alphabetTitle);
		Typeface typeface = Typeface.createFromAsset(getAssets(),
				"fonts/NuevaStd.ttf");
		lesson.setTypeface(typeface);
		
		ImageView back = (ImageView) findViewById(R.id.back_button);
		
		back.setOnClickListener(this);
		
		TextView tvData = (TextView)findViewById(R.id.tvData);
		
		SQLSaveData info = new SQLSaveData(this);
		info.open();
		String data = info.getData();
		info.close();
		tvData.setText(data);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.back_button:
			super.onBackPressed();
			break;
		}
	}
	
}
