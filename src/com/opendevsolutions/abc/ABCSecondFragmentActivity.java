package com.opendevsolutions.abc;

import java.io.IOException;

import com.opendevsolutions.braingain.MainActivity;
import com.opendevsolutions.braingain.R;
import com.opendevsolutions.quiz.lib.QuizActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class ABCSecondFragmentActivity extends Activity implements
		OnClickListener {
	QuizActivity quiz_act = new QuizActivity();
	private int displayChild;
	private int childCount;
	private ViewFlipper flipper;
	public static int display;
	SoundPool sp;
	int n, o, p, q, r, s, t, u, v, w, x, y, z = 0;
	private static View textViews;
	private static String alpha_second = "alphabet_second.xml";
	private static String QName = "ABC Part 2";
	
	private MainActivity main = new MainActivity();

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
	protected void onDestroy() {
		super.onDestroy();
		AssetFileDescriptor afd = this.getResources().openRawResourceFd(
				R.raw.bg_track);
		try {
			main.bgMusic.reset();
			main.bgMusic.setDataSource(afd.getFileDescriptor(),
					afd.getStartOffset(), afd.getDeclaredLength());
			main.bgMusic.prepare();
			main.bgMusic.setLooping(true);
			main.bgMusic.start();
			afd.close();
		} catch (IllegalArgumentException e) {
			Log.e("error: ",
					"Unable to play audio queue do to exception: "
							+ e.getMessage(), e);
		} catch (IllegalStateException e) {
			Log.e("error: ",
					"Unable to play audio queue do to exception: "
							+ e.getMessage(), e);
		} catch (IOException e) {
			Log.e("error: ",
					"Unable to play audio queue do to exception: "
							+ e.getMessage(), e);
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		
		if(main.bgMusic.isPlaying()){
			main.bgMusic.stop();
		}
	}

	@Override
	public void onBackPressed() {
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment_alphabet_two);

		sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
		n = sp.load(this, R.raw.n, 1);
		o = sp.load(this, R.raw.o, 1);
		p = sp.load(this, R.raw.p, 1);
		q = sp.load(this, R.raw.q, 1);
		r = sp.load(this, R.raw.r, 1);
		s = sp.load(this, R.raw.s, 1);
		t = sp.load(this, R.raw.t, 1);
		u = sp.load(this, R.raw.u, 1);
		v = sp.load(this, R.raw.v, 1);
		w = sp.load(this, R.raw.w, 1);
		x = sp.load(this, R.raw.x, 1);
		y = sp.load(this, R.raw.y, 1);
		z = sp.load(this, R.raw.z, 1);

		TextView lesson = (TextView) findViewById(R.id.alphabetTitle);
		Typeface typeface = Typeface.createFromAsset(getAssets(),
				"fonts/NuevaStd.ttf");
		lesson.setTypeface(typeface);

		flipper = (ViewFlipper) findViewById(R.id.abcFlipperTwo);

		childCount = flipper.getChildCount();

		ImageView next = (ImageView) findViewById(R.id.arrow_right);
		ImageView left = (ImageView) findViewById(R.id.arrow_left);
		ImageView back = (ImageView) findViewById(R.id.back_button);

		ImageView n = (ImageView) findViewById(R.id.letter_n);
		ImageView o = (ImageView) findViewById(R.id.letter_o);
		ImageView p = (ImageView) findViewById(R.id.letter_p);
		ImageView q = (ImageView) findViewById(R.id.letter_q);
		ImageView r = (ImageView) findViewById(R.id.letter_r);
		ImageView s = (ImageView) findViewById(R.id.letter_s);
		ImageView t = (ImageView) findViewById(R.id.letter_t);
		ImageView u = (ImageView) findViewById(R.id.letter_u);
		ImageView v = (ImageView) findViewById(R.id.letter_v);
		ImageView w = (ImageView) findViewById(R.id.letter_w);
		ImageView x = (ImageView) findViewById(R.id.letter_x);
		ImageView y = (ImageView) findViewById(R.id.letter_y);
		ImageView z = (ImageView) findViewById(R.id.letter_z);

		TextView yes = (TextView) findViewById(R.id.yes);
		TextView no = (TextView) findViewById(R.id.no);

		next.setOnClickListener(this);
		left.setOnClickListener(this);
		back.setOnClickListener(this);

		yes.setOnClickListener(this);
		no.setOnClickListener(this);

		n.setOnClickListener(this);
		o.setOnClickListener(this);
		p.setOnClickListener(this);
		q.setOnClickListener(this);
		r.setOnClickListener(this);
		s.setOnClickListener(this);
		t.setOnClickListener(this);
		u.setOnClickListener(this);
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
	
	public void changeTextBG(View text){
		text.setBackgroundColor(getResources().getColor(R.color.lessonText));
	}

	@Override
	public void onClick(View mView) {
		switch (mView.getId()) {

		case R.id.letter_n:
			sp.play(n, 1, 1, 0, 0, 1);
			break;
		case R.id.letter_o:
			sp.play(o, 1, 1, 0, 0, 1);
			break;
		case R.id.letter_p:
			sp.play(p, 1, 1, 0, 0, 1);
			break;
		case R.id.letter_q:
			sp.play(q, 1, 1, 0, 0, 1);
			break;
		case R.id.letter_r:
			sp.play(r, 1, 1, 0, 0, 1);
			break;
		case R.id.letter_s:
			sp.play(s, 1, 1, 0, 0, 1);
			break;
		case R.id.letter_t:
			sp.play(t, 1, 1, 0, 0, 1);
			break;
		case R.id.letter_u:
			sp.play(u, 1, 1, 0, 0, 1);
			break;
		case R.id.letter_v:
			sp.play(v, 1, 1, 0, 0, 1);
			break;
		case R.id.letter_w:
			sp.play(w, 1, 1, 0, 0, 1);
			break;
		case R.id.letter_x:
			sp.play(x, 1, 1, 0, 0, 1);
			break;
		case R.id.letter_y:
			sp.play(y, 1, 1, 0, 0, 1);
			break;
		case R.id.letter_z:
			sp.play(z, 1, 1, 0, 0, 1);
			break;
		case R.id.yes:
			changeTextBG(mView);
			quiz_act.setFileName(alpha_second);
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
