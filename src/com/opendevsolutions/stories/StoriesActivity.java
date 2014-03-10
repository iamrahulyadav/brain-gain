package com.opendevsolutions.stories;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.opendevsolutions.braingain.R;

public class StoriesActivity extends Activity implements
		OnClickListener {

	@Override
	public void onBackPressed() {
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_story);

		TextView lesson = (TextView) findViewById(R.id.alphabetTitle);
		ImageView back = (ImageView) findViewById(R.id.back_button);
		ImageView ag = (ImageView) findViewById(R.id.ag);
		ImageView heart = (ImageView) findViewById(R.id.heart);
		ImageView pencil = (ImageView) findViewById(R.id.pencil);

		Typeface typeface = Typeface.createFromAsset(getAssets(),
				"fonts/NuevaStd.ttf");

		lesson.setTypeface(typeface);

		back.setOnClickListener(this);
		ag.setOnClickListener(this);
		heart.setOnClickListener(this);
		pencil.setOnClickListener(this);
	}

	@Override
	public void onClick(View mView) {
		switch (mView.getId()) {
		case R.id.ag:
			Intent ag = new Intent(this, StoryOneFragmentActivity.class);
			startActivity(ag);
			break;
		case R.id.heart:
			Intent heart = new Intent(this,StoryTwoFragmentActivity.class);
			startActivity(heart);
			break;
		case R.id.pencil:
			Intent pencil = new Intent(this, StoryThreeFragmentActivity.class);
			startActivity(pencil);
			break;
		case R.id.back_button:
			super.onBackPressed();
			break;

		}
	}

}
