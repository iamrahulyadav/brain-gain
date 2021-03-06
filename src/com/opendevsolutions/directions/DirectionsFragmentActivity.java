package com.opendevsolutions.directions;

import android.app.Activity;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.opendevsolutions.braingain.R;

public class DirectionsFragmentActivity extends Activity implements
		OnClickListener {

	private int displayChild;
	private ViewFlipper flipper;
	public static int display;
	private static SoundPool sp;
	private static int click = 0;

	private Animation inFromRightAnimation() {

		Animation inFromRight = new TranslateAnimation(
				Animation.RELATIVE_TO_PARENT, +1.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f);
		inFromRight.setDuration(300);
		inFromRight.setInterpolator(new AccelerateInterpolator());
		return inFromRight;
	}

	private Animation outToLeftAnimation() {
		Animation outtoLeft = new TranslateAnimation(
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, -1.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f);
		outtoLeft.setDuration(300);
		outtoLeft.setInterpolator(new AccelerateInterpolator());
		return outtoLeft;
	}

	private Animation inFromLeftAnimation() {
		Animation inFromLeft = new TranslateAnimation(
				Animation.RELATIVE_TO_PARENT, -1.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f);
		inFromLeft.setDuration(300);
		inFromLeft.setInterpolator(new AccelerateInterpolator());
		return inFromLeft;
	}

	private Animation outToRightAnimation() {
		Animation outtoRight = new TranslateAnimation(
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, +1.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f);
		outtoRight.setDuration(300);
		outtoRight.setInterpolator(new AccelerateInterpolator());
		return outtoRight;
	}

	private Animation inFromUpAnimation() {
		Animation infromUp = new TranslateAnimation(
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, +1.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f);
		infromUp.setDuration(300);
		infromUp.setInterpolator(new AccelerateInterpolator());
		return infromUp;
	}

	private Animation outToUpAnimation() {
		Animation outtoUp = new TranslateAnimation(
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, +1.0f);
		outtoUp.setDuration(300);
		outtoUp.setInterpolator(new AccelerateInterpolator());
		return outtoUp;
	}

	private Animation inFromDownAnimation() {
		Animation infromDown = new TranslateAnimation(
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, -1.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f);
		infromDown.setDuration(300);
		infromDown.setInterpolator(new AccelerateInterpolator());
		return infromDown;
	}

	private Animation outToDownAnimation() {
		Animation outtoDown = new TranslateAnimation(
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, -1.0f);
		outtoDown.setDuration(300);
		outtoDown.setInterpolator(new AccelerateInterpolator());
		return outtoDown;
	}

	@Override
	public void onBackPressed() {
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment_directions);

		TextView lesson = (TextView) findViewById(R.id.alphabetTitle);
		Typeface typeface = Typeface.createFromAsset(getAssets(),
				"fonts/NuevaStd.ttf");
		lesson.setTypeface(typeface);

		flipper = (ViewFlipper) findViewById(R.id.directionFlipper);

		ImageView up = (ImageView) findViewById(R.id.directionUp);
		ImageView down = (ImageView) findViewById(R.id.directionDown);
		ImageView left = (ImageView) findViewById(R.id.directionLeft);
		ImageView right = (ImageView) findViewById(R.id.directionRight);
		ImageView back = (ImageView) findViewById(R.id.back_button);
		ImageView home_l = (ImageView) findViewById(R.id.home_button_left);
		ImageView home_r = (ImageView) findViewById(R.id.home_button_right);
		ImageView home_u = (ImageView) findViewById(R.id.home_button_up);
		ImageView home_d = (ImageView) findViewById(R.id.home_button_down);

		up.setOnClickListener(this);
		down.setOnClickListener(this);
		left.setOnClickListener(this);
		right.setOnClickListener(this);
		back.setOnClickListener(this);
		home_l.setOnClickListener(this);
		home_r.setOnClickListener(this);
		home_u.setOnClickListener(this);
		home_d.setOnClickListener(this);
		
		sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
		click = sp.load(this, R.raw.click, 1);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.directionUp:
			sp.play(click, 1, 1, 0, 0, 1);
			flipper.setInAnimation(inFromUpAnimation());
			flipper.setOutAnimation(outToDownAnimation());
			flipper.setDisplayedChild(1);
			break;
		case R.id.directionLeft:
			sp.play(click, 1, 1, 0, 0, 1);
			flipper.setInAnimation(inFromLeftAnimation());
			flipper.setOutAnimation(outToRightAnimation());
			flipper.setDisplayedChild(2);
			break;
		case R.id.directionRight:
			sp.play(click, 1, 1, 0, 0, 1);
			flipper.setInAnimation(inFromRightAnimation());
			flipper.setOutAnimation(outToLeftAnimation());
			flipper.setDisplayedChild(3);
			break;
		case R.id.directionDown:
			sp.play(click, 1, 1, 0, 0, 1);
			flipper.setInAnimation(inFromDownAnimation());
			flipper.setOutAnimation(outToUpAnimation());
			flipper.setDisplayedChild(4);
			break;
		case R.id.home_button_right:
			sp.play(click, 1, 1, 0, 0, 1);
			flipper.setInAnimation(inFromLeftAnimation());
			flipper.setOutAnimation(outToRightAnimation());
			flipper.setDisplayedChild(0);
			break;
		case R.id.home_button_left:
			sp.play(click, 1, 1, 0, 0, 1);
			flipper.setInAnimation(inFromRightAnimation());
			flipper.setOutAnimation(outToLeftAnimation());
			flipper.setDisplayedChild(0);
			break;
		case R.id.home_button_up:
			sp.play(click, 1, 1, 0, 0, 1);
			flipper.setInAnimation(inFromDownAnimation());
			flipper.setOutAnimation(outToUpAnimation());
			flipper.setDisplayedChild(0);
			break;
		case R.id.home_button_down:
			sp.play(click, 1, 1, 0, 0, 1);
			flipper.setInAnimation(inFromUpAnimation());
			flipper.setOutAnimation(outToDownAnimation());
			flipper.setDisplayedChild(0);
			break;
		case R.id.back_button:
			sp.play(click, 1, 1, 0, 0, 1);
			super.onBackPressed();
			break;
		}
	}
}
