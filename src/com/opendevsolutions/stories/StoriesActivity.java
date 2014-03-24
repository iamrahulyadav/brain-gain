package com.opendevsolutions.stories;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.opendevsolutions.braingain.R;

public class StoriesActivity extends Activity implements OnClickListener {

	private static SoundPool sp;
	private static int click = 0;

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

		sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
		click = sp.load(this, R.raw.click, 1);
	}

	@Override
	public void onClick(View mView) {
		switch (mView.getId()) {
		case R.id.ag:
			sp.play(click, 1, 1, 0, 0, 1);
			Intent ag = new Intent(this, StoryOneFragmentActivity.class);
			startActivity(ag);
			break;
		case R.id.heart:
			sp.play(click, 1, 1, 0, 0, 1);
			Intent heart = new Intent(this, StoryTwoFragmentActivity.class);
			startActivity(heart);
			break;
		case R.id.pencil:
			sp.play(click, 1, 1, 0, 0, 1);
			Intent pencil = new Intent(this, StoryThreeFragmentActivity.class);
			startActivity(pencil);
			break;
		case R.id.back_button:
			sp.play(click, 1, 1, 0, 0, 1);
			super.onBackPressed();
			break;

		}
	}

}
