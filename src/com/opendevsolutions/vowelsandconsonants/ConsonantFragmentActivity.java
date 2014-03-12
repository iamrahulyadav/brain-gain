package com.opendevsolutions.vowelsandconsonants;

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
import com.opendevsolutions.quiz.lib.QuizActivity;

public class ConsonantFragmentActivity extends Activity implements
		OnClickListener {

	private int displayChild;
	private int childCount;
	private ViewFlipper flipper;

	SoundPool sp;
	int b, c, d, f, g, h, j, k, l, m, n, p, q, r, s, t, v, w, x, y, z = 0;

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

		sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
		b = sp.load(this, R.raw.cb, 1);
		c = sp.load(this, R.raw.cc, 1);
		d = sp.load(this, R.raw.cd, 1);
		f = sp.load(this, R.raw.cf, 1);
		g = sp.load(this, R.raw.cg, 1);
		h = sp.load(this, R.raw.ch, 1);
		j = sp.load(this, R.raw.cj, 1);
		k = sp.load(this, R.raw.ck, 1);
		l = sp.load(this, R.raw.cl, 1);
		m = sp.load(this, R.raw.cm, 1);
		n = sp.load(this, R.raw.cn, 1);
		p = sp.load(this, R.raw.cp, 1);
		q = sp.load(this, R.raw.cq, 1);
		r = sp.load(this, R.raw.cr, 1);
		s = sp.load(this, R.raw.cs, 1);
		t = sp.load(this, R.raw.ct, 1);
		v = sp.load(this, R.raw.cv, 1);
		w = sp.load(this, R.raw.cw, 1);
		x = sp.load(this, R.raw.cx, 1);
		y = sp.load(this, R.raw.cy, 1);
		z = sp.load(this, R.raw.cz, 1);

		TextView lesson = (TextView) findViewById(R.id.alphabetTitle);
		Typeface typeface = Typeface.createFromAsset(getAssets(),
				"fonts/NuevaStd.ttf");
		lesson.setTypeface(typeface);

		flipper = (ViewFlipper) findViewById(R.id.consonantFlipper);

		childCount = flipper.getChildCount();

		ImageView next = (ImageView) findViewById(R.id.arrow_right);
		ImageView left = (ImageView) findViewById(R.id.arrow_left);
		ImageView back = (ImageView) findViewById(R.id.back_button);

		ImageView b = (ImageView) findViewById(R.id.cb);
		ImageView c = (ImageView) findViewById(R.id.cc);
		ImageView d = (ImageView) findViewById(R.id.cd);
		ImageView f = (ImageView) findViewById(R.id.cf);
		ImageView g = (ImageView) findViewById(R.id.cg);
		ImageView h = (ImageView) findViewById(R.id.ch);
		ImageView j = (ImageView) findViewById(R.id.cj);
		ImageView k = (ImageView) findViewById(R.id.ck);
		ImageView l = (ImageView) findViewById(R.id.cl);
		ImageView m = (ImageView) findViewById(R.id.cm);
		ImageView n = (ImageView) findViewById(R.id.cn);
		ImageView p = (ImageView) findViewById(R.id.cp);
		ImageView q = (ImageView) findViewById(R.id.cq);
		ImageView r = (ImageView) findViewById(R.id.cr);
		ImageView s = (ImageView) findViewById(R.id.cs);
		ImageView t = (ImageView) findViewById(R.id.ct);
		ImageView v = (ImageView) findViewById(R.id.cv);
		ImageView w = (ImageView) findViewById(R.id.cdu);
		ImageView x = (ImageView) findViewById(R.id.cx);
		ImageView y = (ImageView) findViewById(R.id.cy);
		ImageView z = (ImageView) findViewById(R.id.cz);

		TextView yes = (TextView) findViewById(R.id.yes);
		TextView no = (TextView) findViewById(R.id.no);

		next.setOnClickListener(this);
		left.setOnClickListener(this);
		back.setOnClickListener(this);

		yes.setOnClickListener(this);
		no.setOnClickListener(this);

		b.setOnClickListener(this);
		c.setOnClickListener(this);
		d.setOnClickListener(this);
		f.setOnClickListener(this);
		g.setOnClickListener(this);
		h.setOnClickListener(this);
		j.setOnClickListener(this);
		k.setOnClickListener(this);
		l.setOnClickListener(this);
		m.setOnClickListener(this);
		n.setOnClickListener(this);
		p.setOnClickListener(this);
		q.setOnClickListener(this);
		r.setOnClickListener(this);
		s.setOnClickListener(this);
		t.setOnClickListener(this);
		v.setOnClickListener(this);
		w.setOnClickListener(this);
		x.setOnClickListener(this);
		y.setOnClickListener(this);
		z.setOnClickListener(this);

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

		case R.id.cb:
			sp.play(b, 1, 1, 0, 0, 1);
			break;
		case R.id.cc:
			sp.play(c, 1, 1, 0, 0, 1);
			break;
		case R.id.cd:
			sp.play(d, 1, 1, 0, 0, 1);
			break;
		case R.id.cf:
			sp.play(f, 1, 1, 0, 0, 1);
			break;
		case R.id.cg:
			sp.play(g, 1, 1, 0, 0, 1);
			break;
		case R.id.ch:
			sp.play(h, 1, 1, 0, 0, 1);
			break;
		case R.id.cj:
			sp.play(j, 1, 1, 0, 0, 1);
			break;
		case R.id.ck:
			sp.play(k, 1, 1, 0, 0, 1);
			break;
		case R.id.cl:
			sp.play(l, 1, 1, 0, 0, 1);
			break;
		case R.id.cm:
			sp.play(m, 1, 1, 0, 0, 1);
			break;
		case R.id.cn:
			sp.play(n, 1, 1, 0, 0, 1);
			break;
		case R.id.cp:
			sp.play(p, 1, 1, 0, 0, 1);
			break;
		case R.id.cq:
			sp.play(q, 1, 1, 0, 0, 1);
			break;
		case R.id.cr:
			sp.play(r, 1, 1, 0, 0, 1);
			break;
		case R.id.cs:
			sp.play(s, 1, 1, 0, 0, 1);
			break;
		case R.id.ct:
			sp.play(t, 1, 1, 0, 0, 1);
			break;
		case R.id.cv:
			sp.play(v, 1, 1, 0, 0, 1);
			break;
		case R.id.cdu:
			sp.play(w, 1, 1, 0, 0, 1);
			break;
		case R.id.cx:
			sp.play(x, 1, 1, 0, 0, 1);
			break;
		case R.id.cy:
			sp.play(y, 1, 1, 0, 0, 1);
			break;
		case R.id.cz:
			sp.play(z, 1, 1, 0, 0, 1);
			break;
		case R.id.back_button:
			super.onBackPressed();
			break;
		}
	}

}
