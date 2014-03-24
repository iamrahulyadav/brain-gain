package com.opendevsolutions.braingain;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.opendevsolutions.abc.ABCFragmentActivity;
import com.opendevsolutions.directions.DirectionsFragmentActivity;
import com.opendevsolutions.emotions.EmotionsFragmentActivity;
import com.opendevsolutions.help.HelpFragmentActivity;
import com.opendevsolutions.stories.StoriesActivity;
import com.opendevsolutions.vowelsandconsonants.VowelsAndConsonantsActivity;

public class MainActivity extends Activity implements OnClickListener {

	private AlertDialog exitDialog;
	private AlertDialog.Builder exitBuilder;
	public static MediaPlayer bgMusic;
	private static SoundPool sp;
	private static int click = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView lesson = (TextView) findViewById(R.id.lessonText);
		Typeface typeface = Typeface.createFromAsset(getAssets(),
				"fonts/NuevaStd.ttf");
		lesson.setTypeface(typeface);

		ImageView abc = (ImageView) findViewById(R.id.abc);
		ImageView vowels = (ImageView) findViewById(R.id.vowels);
		ImageView emotion = (ImageView) findViewById(R.id.emotion);
		ImageView direction = (ImageView) findViewById(R.id.direction);
		ImageView stories = (ImageView) findViewById(R.id.stories);
		ImageView help = (ImageView) findViewById(R.id.help);

		abc.setOnClickListener(this);
		vowels.setOnClickListener(this);
		emotion.setOnClickListener(this);
		direction.setOnClickListener(this);
		stories.setOnClickListener(this);
		help.setOnClickListener(this);

		sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
		click = sp.load(this, R.raw.click, 1);

		bgMusic = MediaPlayer.create(this, R.raw.bg_track);
		bgMusic.setVolume(1, 1f);

		exitBuilder = new AlertDialog.Builder(this);
		exitBuilder.setTitle("BrainGain");
		exitBuilder.setMessage("Do you want to exit?");
		exitBuilder.setIcon(R.drawable.ic_launcher);
		exitBuilder.setPositiveButton("Yes",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						sp.play(click, 1, 1, 0, 0, 1);
						exitDialog.dismiss();
						MainActivity.this.finish();
					}
				}).setNegativeButton("No",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						sp.play(click, 1, 1, 0, 0, 1);
						exitDialog.dismiss();
					}
				});

		exitDialog = exitBuilder.create();

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (bgMusic.isPlaying()) {
			bgMusic.stop();
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		if (bgMusic.isPlaying()) {
			bgMusic.setLooping(true);
		} else {
			bgMusic.start();
			bgMusic.setLooping(true);
		}
	}

	@Override
	public void onBackPressed() {
		exitDialog.show();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.abc:
			sp.play(click, 1, 1, 0, 0, 1);
			Intent abc = new Intent(this, ABCFragmentActivity.class);
			startActivity(abc);
			break;
		case R.id.vowels:
			sp.play(click, 1, 1, 0, 0, 1);
			Intent vowcon = new Intent(this, VowelsAndConsonantsActivity.class);
			startActivity(vowcon);
			break;
		case R.id.emotion:
			sp.play(click, 1, 1, 0, 0, 1);
			Intent emotion = new Intent(this, EmotionsFragmentActivity.class);
			startActivity(emotion);
			break;
		case R.id.direction:
			sp.play(click, 1, 1, 0, 0, 1);
			Intent direction = new Intent(this,
					DirectionsFragmentActivity.class);
			startActivity(direction);
			break;
		case R.id.stories:
			sp.play(click, 1, 1, 0, 0, 1);
			Intent stories = new Intent(this, StoriesActivity.class);
			startActivity(stories);
			break;
		case R.id.help:
			sp.play(click, 1, 1, 0, 0, 1);
			Intent help = new Intent(this, HelpFragmentActivity.class);
			startActivity(help);
			break;
		}
	}

}
