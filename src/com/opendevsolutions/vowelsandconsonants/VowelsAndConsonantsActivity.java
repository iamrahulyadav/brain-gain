package com.opendevsolutions.vowelsandconsonants;

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

public class VowelsAndConsonantsActivity extends Activity implements
		OnClickListener {

	private static SoundPool sp;
	private static int click = 0;
	
	@Override
	public void onBackPressed() {

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vowcon);
		TextView lesson = (TextView) findViewById(R.id.alphabetTitle);
		TextView vowel = (TextView) findViewById(R.id.vowels);
		TextView consonant = (TextView) findViewById(R.id.consonants);

		Typeface lessonTypeface = Typeface.createFromAsset(getAssets(),
				"fonts/NuevaStd.ttf");
		Typeface vowelTypeface = Typeface.createFromAsset(getAssets(),
				"fonts/MarkerFelt.ttf");
		Typeface consonantTypeface = Typeface.createFromAsset(getAssets(),
				"fonts/MarkerFelt.ttf");

		lesson.setTypeface(lessonTypeface);
		vowel.setTypeface(vowelTypeface);
		consonant.setTypeface(consonantTypeface);

		ImageView back = (ImageView) findViewById(R.id.back_button);
		back.setOnClickListener(this);
		vowel.setOnClickListener(this);
		consonant.setOnClickListener(this);
		
		sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
		click = sp.load(this, R.raw.click, 1);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.vowels:
			sp.play(click, 1, 1, 0, 0, 1);
			Intent vowel = new Intent(this, VowelFragmentActivity.class);
			startActivity(vowel);
			break;
		case R.id.consonants:
			sp.play(click, 1, 1, 0, 0, 1);
			Intent consonant = new Intent(this, ConsonantFragmentActivity.class);
			startActivity(consonant);
			break;
		case R.id.back_button:
			sp.play(click, 1, 1, 0, 0, 1);
			super.onBackPressed();
			break;
		}
	}

}
