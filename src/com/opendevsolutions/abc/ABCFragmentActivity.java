package com.opendevsolutions.abc;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.opendevsolutions.braingain.R;

public class ABCFragmentActivity extends Activity implements OnClickListener {

	private int displayChild;
	private int childCount;
	private ViewFlipper flipper;
	public static int display;
	private int counter;
	View[] alphabet;

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
	
	public void loadChild(){
		
		LayoutInflater inflater = getLayoutInflater();
		
		/*View a = inflater.inflate(R.layout.activity_alphabet_a, null);
		View b = inflater.inflate(R.layout.activity_alphabet_b, null);
		View c = inflater.inflate(R.layout.activity_alphabet_c, null);
		View d = inflater.inflate(R.layout.activity_alphabet_d, null);
		View e = inflater.inflate(R.layout.activity_alphabet_e, null);
		View f = inflater.inflate(R.layout.activity_alphabet_f, null);
		View g = inflater.inflate(R.layout.activity_alphabet_g, null);
		View h = inflater.inflate(R.layout.activity_alphabet_h, null);
		View i = inflater.inflate(R.layout.activity_alphabet_i, null);
		View j = inflater.inflate(R.layout.activity_alphabet_j, null);
		View k = inflater.inflate(R.layout.activity_alphabet_k, null);
		View l = inflater.inflate(R.layout.activity_alphabet_l, null);
		View m = inflater.inflate(R.layout.activity_alphabet_m, null);
		View n = inflater.inflate(R.layout.activity_alphabet_n, null);
		View o = inflater.inflate(R.layout.activity_alphabet_o, null);
		View p = inflater.inflate(R.layout.activity_alphabet_p, null);
		View q = inflater.inflate(R.layout.activity_alphabet_q, null);
		View r = inflater.inflate(R.layout.activity_alphabet_r, null);
		View s = inflater.inflate(R.layout.activity_alphabet_s, null);
		View t = inflater.inflate(R.layout.activity_alphabet_t, null);
		View u = inflater.inflate(R.layout.activity_alphabet_u, null);
		View v = inflater.inflate(R.layout.activity_alphabet_v, null);
		View w = inflater.inflate(R.layout.activity_alphabet_w, null);
		View x = inflater.inflate(R.layout.activity_alphabet_x, null);
		View y = inflater.inflate(R.layout.activity_alphabet_y, null);
		View z = inflater.inflate(R.layout.activity_alphabet_z, null);
		
		flipper.addView(a, 0);
		flipper.addView(b, 1);
		flipper.addView(c, 2);
		flipper.addView(d, 3);
		flipper.addView(e, 4);
		flipper.addView(f, 5);
		flipper.addView(g, 6);
		flipper.addView(h, 7);
		flipper.addView(i, 8);
		flipper.addView(j, 9);
		flipper.addView(k, 10);
		flipper.addView(l, 11);
		flipper.addView(m, 12);
		flipper.addView(n, 13);
		flipper.addView(o, 14);
		flipper.addView(p, 15);
		flipper.addView(q, 16);
		flipper.addView(r, 17);
		flipper.addView(s, 18);
		flipper.addView(t, 19);
		flipper.addView(u, 20);
		flipper.addView(v, 21);
		flipper.addView(w, 22);
		flipper.addView(x, 23);
		flipper.addView(y, 24);
		flipper.addView(z, 25);*/
		
		alphabet = new View[] {
				inflater.inflate(R.layout.activity_alphabet_a, null),
				inflater.inflate(R.layout.activity_alphabet_b, null),
				inflater.inflate(R.layout.activity_alphabet_c, null),
				inflater.inflate(R.layout.activity_alphabet_d, null),
				inflater.inflate(R.layout.activity_alphabet_e, null),
				inflater.inflate(R.layout.activity_alphabet_f, null),
				inflater.inflate(R.layout.activity_alphabet_g, null),
				inflater.inflate(R.layout.activity_alphabet_h, null),
				inflater.inflate(R.layout.activity_alphabet_i, null),
				inflater.inflate(R.layout.activity_alphabet_j, null),
				inflater.inflate(R.layout.activity_alphabet_k, null),
				inflater.inflate(R.layout.activity_alphabet_l, null),
				inflater.inflate(R.layout.activity_alphabet_m, null),
				inflater.inflate(R.layout.activity_alphabet_n, null),
				inflater.inflate(R.layout.activity_alphabet_o, null),
				inflater.inflate(R.layout.activity_alphabet_p, null),
				inflater.inflate(R.layout.activity_alphabet_q, null),
				inflater.inflate(R.layout.activity_alphabet_r, null),
				inflater.inflate(R.layout.activity_alphabet_s, null),
				inflater.inflate(R.layout.activity_alphabet_t, null),
				inflater.inflate(R.layout.activity_alphabet_u, null),
				inflater.inflate(R.layout.activity_alphabet_v, null),
				inflater.inflate(R.layout.activity_alphabet_w, null),
				inflater.inflate(R.layout.activity_alphabet_x, null),
				inflater.inflate(R.layout.activity_alphabet_y, null),
				inflater.inflate(R.layout.activity_alphabet_z, null),
				};
	}

	@Override
	public void onBackPressed() {
		
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment_alphabet);

		TextView lesson = (TextView) findViewById(R.id.alphabetTitle);
		Typeface typeface = Typeface.createFromAsset(getAssets(),
				"fonts/NuevaStd.ttf");
		lesson.setTypeface(typeface);

		flipper = (ViewFlipper) findViewById(R.id.abcFlipper);

		childCount = flipper.getChildCount();

		ImageView next = (ImageView) findViewById(R.id.arrow_right);
		ImageView left = (ImageView) findViewById(R.id.arrow_left);
		ImageView back = (ImageView) findViewById(R.id.back_button);
		
		next.setOnClickListener(this);
		left.setOnClickListener(this);
		back.setOnClickListener(this);
		
		//loadChild();

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
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
