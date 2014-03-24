package com.opendevsolutions.stories;

import com.opendevsolutions.braingain.R;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class StoryThreeFragmentActivity extends Activity implements
		OnClickListener {

	private int displayChild;
	private int childCount;
	private ViewFlipper flipper;
	
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

	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_story_three);

		ImageView left = (ImageView) findViewById(R.id.arrow_left);
		ImageView right = (ImageView) findViewById(R.id.arrow_right);
		ImageView home = (ImageView) findViewById(R.id.home_button);

		flipper = (ViewFlipper) findViewById(R.id.storyFlipperThree);
		childCount = flipper.getChildCount();

		left.setOnClickListener(this);
		right.setOnClickListener(this);
		home.setOnClickListener(this);
		
		sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
		click = sp.load(this, R.raw.click, 1);
	}

	@Override
	public void onClick(View mView) {
		switch (mView.getId()) {
		case R.id.arrow_left:
			sp.play(click, 1, 1, 0, 0, 1);
			displayChild = flipper.getDisplayedChild();
			if (displayChild == 0) {
				flipper.stopFlipping();
			} else {
				flipper.setInAnimation(inFromLeftAnimation());
				flipper.setOutAnimation(outToRightAnimation());
				flipper.showPrevious();
			}
			break;
		case R.id.arrow_right:
			sp.play(click, 1, 1, 0, 0, 1);
			displayChild = flipper.getDisplayedChild();
			if (displayChild == childCount - 1) {
				flipper.stopFlipping();
			} else {
				flipper.setInAnimation(inFromRightAnimation());
				flipper.setOutAnimation(outToLeftAnimation());
				flipper.showNext();
			}
			break;
		case R.id.home_button:
			sp.play(click, 1, 1, 0, 0, 1);
			this.finish();
			break;
		}
	}

}
