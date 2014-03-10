package com.opendevsolutions.vowelsandconsonants;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
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
import com.opendevsolutions.quiz.lib.QuizActivity;

public class ConsonantFragmentActivity extends Activity implements
		OnClickListener {

	private int displayChild;
	private int childCount;
	private ViewFlipper flipper;

	private static View textViews;
	private static String quiz_name = "consonants.xml";
	private static String QName = "Consonants";

	private static QuizActivity quiz_act = new QuizActivity();

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
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment_consonant);

		TextView lesson = (TextView) findViewById(R.id.alphabetTitle);
		Typeface typeface = Typeface.createFromAsset(getAssets(),
				"fonts/NuevaStd.ttf");
		lesson.setTypeface(typeface);

		flipper = (ViewFlipper) findViewById(R.id.consonantFlipper);

		childCount = flipper.getChildCount();

		ImageView next = (ImageView) findViewById(R.id.arrow_right);
		ImageView left = (ImageView) findViewById(R.id.arrow_left);
		ImageView back = (ImageView) findViewById(R.id.back_button);

		TextView yes = (TextView) findViewById(R.id.yes);
		TextView no = (TextView) findViewById(R.id.no);

		next.setOnClickListener(this);
		left.setOnClickListener(this);
		back.setOnClickListener(this);

		yes.setOnClickListener(this);
		no.setOnClickListener(this);

	}

	private Runnable myThread = new Runnable() {
		@Override
		public void run() {
			try {
				Thread.sleep(2000);
				changeToDefaultBG(textViews);
			} catch (Throwable t) {

			}
		}
	};

	public static View getDefaultBG() {
		return textViews;
	}

	public void changeToDefaultBG(View text) {
		text.setBackgroundColor(getResources().getColor(R.color.white));
	}

	public void changeTextBG(View text) {
		text.setBackgroundColor(getResources().getColor(R.color.lessonText));
	}

	@Override
	public void onClick(View mView) {
		switch (mView.getId()) {
		case R.id.arrow_left:
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
			displayChild = flipper.getDisplayedChild();
			if (displayChild == childCount - 1) {
				flipper.stopFlipping();
			} else {
				flipper.setInAnimation(inFromRightAnimation());
				flipper.setOutAnimation(outToLeftAnimation());
				flipper.showNext();
			}
			break;

		case R.id.yes:
			changeTextBG(mView);
			quiz_act.setFileName(quiz_name);
			quiz_act.setQuizName(QName);
			Intent quiz = new Intent(this, QuizActivity.class);
			startActivity(quiz);
			this.finish();
			break;
		case R.id.no:
			textViews = mView;
			changeTextBG(mView);
			new Thread(myThread).start();
			flipper.setInAnimation(inFromLeftAnimation());
			flipper.setOutAnimation(outToRightAnimation());
			flipper.setDisplayedChild(0);
			break;
		case R.id.back_button:
			super.onBackPressed();
			break;
		}
	}

}
