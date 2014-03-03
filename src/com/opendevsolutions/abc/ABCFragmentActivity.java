package com.opendevsolutions.abc;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.opendevsolutions.braingain.R;
import com.opendevsolutions.sql.lib.SQLViewActivity;

public class ABCFragmentActivity extends Activity implements OnClickListener {

	@Override
	public void onBackPressed() {

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alphabet);

		TextView lesson = (TextView) findViewById(R.id.alphabetTitle);
		TextView part_1 = (TextView) findViewById(R.id.part_1);
		TextView part_2 = (TextView) findViewById(R.id.part_2);
		ImageView back = (ImageView) findViewById(R.id.back_button);
		ImageView quiz = (ImageView) findViewById(R.id.quizResults);

		Typeface typeface = Typeface.createFromAsset(getAssets(),
				"fonts/NuevaStd.ttf");
		Typeface partTypeface = Typeface.createFromAsset(getAssets(),
				"fonts/MarkerFelt.ttf");

		lesson.setTypeface(typeface);
		part_1.setTypeface(partTypeface);
		part_2.setTypeface(partTypeface);

		part_1.setOnClickListener(this);
		part_2.setOnClickListener(this);
		back.setOnClickListener(this);
		quiz.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.part_1:
			Intent part_1 = new Intent(this, ABCFirstFragmentActivity.class);
			startActivity(part_1);
			break;
		case R.id.part_2:
			Intent part_2 = new Intent(this, ABCSecondFragmentActivity.class);
			startActivity(part_2);
			break;
		case R.id.quizResults:
			Intent quizResult = new Intent(this, SQLViewActivity.class);
			startActivity(quizResult);
			break;
		case R.id.back_button:
			super.onBackPressed();
			break;
		}
	}

}
