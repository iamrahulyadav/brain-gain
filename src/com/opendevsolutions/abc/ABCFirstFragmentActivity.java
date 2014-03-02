package com.opendevsolutions.abc;

import android.app.Activity;
import android.content.Intent;
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

public class ABCFirstFragmentActivity extends Activity implements
		OnClickListener {

	private int displayChild;
	private int childCount;
	private ViewFlipper flipper;
	public static int display;
	SoundPool sp;
	int a, b, c, d, e, f, g, h, i, j, k, l, m = 0;
	private static View textViews;
	private static String alpha_first = "alphabet_first.xml";

	private static ABCQuizActivity quiz_act = new ABCQuizActivity();

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

		setContentView(R.layout.activity_fragment_alphabet_one);

		sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
		a = sp.load(this, R.raw.a, 1);
		b = sp.load(this, R.raw.b, 1);
		c = sp.load(this, R.raw.c, 1);
		d = sp.load(this, R.raw.d, 1);
		e = sp.load(this, R.raw.e, 1);
		f = sp.load(this, R.raw.f, 1);
		g = sp.load(this, R.raw.g, 1);
		h = sp.load(this, R.raw.h, 1);
		i = sp.load(this, R.raw.i, 1);
		j = sp.load(this, R.raw.j, 1);
		k = sp.load(this, R.raw.k, 1);
		l = sp.load(this, R.raw.l, 1);
		m = sp.load(this, R.raw.m, 1);

		TextView lesson = (TextView) findViewById(R.id.alphabetTitle);
		Typeface typeface = Typeface.createFromAsset(getAssets(),
				"fonts/NuevaStd.ttf");
		lesson.setTypeface(typeface);

		flipper = (ViewFlipper) findViewById(R.id.abcFlipperOne);

		childCount = flipper.getChildCount();

		ImageView next = (ImageView) findViewById(R.id.arrow_right);
		ImageView left = (ImageView) findViewById(R.id.arrow_left);
		ImageView back = (ImageView) findViewById(R.id.back_button);

		ImageView a = (ImageView) findViewById(R.id.letter_a);
		ImageView b = (ImageView) findViewById(R.id.letter_b);
		ImageView c = (ImageView) findViewById(R.id.letter_c);
		ImageView d = (ImageView) findViewById(R.id.letter_d);
		ImageView e = (ImageView) findViewById(R.id.letter_e);
		ImageView f = (ImageView) findViewById(R.id.letter_f);
		ImageView g = (ImageView) findViewById(R.id.letter_g);
		ImageView h = (ImageView) findViewById(R.id.letter_h);
		ImageView i = (ImageView) findViewById(R.id.letter_i);
		ImageView j = (ImageView) findViewById(R.id.letter_j);
		ImageView k = (ImageView) findViewById(R.id.letter_k);
		ImageView l = (ImageView) findViewById(R.id.letter_l);
		ImageView m = (ImageView) findViewById(R.id.letter_m);

		TextView yes = (TextView) findViewById(R.id.yes);
		TextView no = (TextView) findViewById(R.id.no);

		next.setOnClickListener(this);
		left.setOnClickListener(this);
		back.setOnClickListener(this);

		yes.setOnClickListener(this);
		no.setOnClickListener(this);

		a.setOnClickListener(this);
		b.setOnClickListener(this);
		c.setOnClickListener(this);
		d.setOnClickListener(this);
		e.setOnClickListener(this);
		f.setOnClickListener(this);
		g.setOnClickListener(this);
		h.setOnClickListener(this);
		i.setOnClickListener(this);
		j.setOnClickListener(this);
		k.setOnClickListener(this);
		l.setOnClickListener(this);
		m.setOnClickListener(this);

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
		case R.id.letter_a:
			sp.play(a, 1, 1, 0, 0, 1);
			break;
		case R.id.letter_b:
			sp.play(b, 1, 1, 0, 0, 1);
			break;
		case R.id.letter_c:
			sp.play(c, 1, 1, 0, 0, 1);
			break;
		case R.id.letter_d:
			sp.play(d, 1, 1, 0, 0, 1);
			break;
		case R.id.letter_e:
			sp.play(e, 1, 1, 0, 0, 1);
			break;
		case R.id.letter_f:
			sp.play(f, 1, 1, 0, 0, 1);
			break;
		case R.id.letter_g:
			sp.play(g, 1, 1, 0, 0, 1);
			break;
		case R.id.letter_h:
			sp.play(h, 1, 1, 0, 0, 1);
			break;
		case R.id.letter_i:
			sp.play(i, 1, 1, 0, 0, 1);
			break;
		case R.id.letter_j:
			sp.play(j, 1, 1, 0, 0, 1);
			break;
		case R.id.letter_k:
			sp.play(k, 1, 1, 0, 0, 1);
			break;
		case R.id.letter_l:
			sp.play(l, 1, 1, 0, 0, 1);
			break;
		case R.id.letter_m:
			sp.play(m, 1, 1, 0, 0, 1);
			break;
		case R.id.yes:
			changeTextBG(mView);
			quiz_act.setFileName(alpha_first);
			Intent quiz = new Intent(this, ABCQuizActivity.class);
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
		case R.id.back_button:
			super.onBackPressed();
			break;
		}
	}

}
