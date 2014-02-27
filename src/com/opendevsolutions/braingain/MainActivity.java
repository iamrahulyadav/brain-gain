package com.opendevsolutions.braingain;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.opendevsolutions.abc.ABCFragmentActivity;
import com.opendevsolutions.emotions.EmotionsFragmentActivity;
import com.opendevsolutions.vowelsandconsonants.VowelsAndConsonantsActivity;

public class MainActivity extends Activity implements OnClickListener {

	private AlertDialog exitDialog;
	private AlertDialog.Builder exitBuilder;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView lesson = (TextView)findViewById(R.id.lessonText);
		Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/NuevaStd.ttf");
		lesson.setTypeface(typeface);
		
		ImageView abc = (ImageView)findViewById(R.id.abc);
		ImageView vowels = (ImageView)findViewById(R.id.vowels);
		ImageView emotion = (ImageView)findViewById(R.id.emotion);
		ImageView direction = (ImageView)findViewById(R.id.direction);
		ImageView stories = (ImageView)findViewById(R.id.stories);
		ImageView help = (ImageView)findViewById(R.id.help);
		
		abc.setOnClickListener(this);
		vowels.setOnClickListener(this);
		emotion.setOnClickListener(this);
		direction.setOnClickListener(this);
		stories.setOnClickListener(this);
		help.setOnClickListener(this);
		
		exitBuilder = new AlertDialog.Builder(this);
		exitBuilder.setTitle("BrainGain");
		exitBuilder.setMessage("Do you want to exit?");
		exitBuilder.setIcon(R.drawable.ic_launcher);
		exitBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				exitDialog.dismiss();
				MainActivity.this.finish();
			}
		}).setNegativeButton("No", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				exitDialog.dismiss();
			}
		});
		
		exitDialog = exitBuilder.create();
	}
	
	@Override
	public void onBackPressed() {
		exitDialog.show();
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.abc:
			Intent abc = new Intent(this, ABCFragmentActivity.class);
			startActivity(abc);
			break;
		case R.id.vowels:
			Intent vowcon = new Intent(this, VowelsAndConsonantsActivity.class);
			startActivity(vowcon);
			break;
		case R.id.emotion:
			Intent emotion = new Intent(this, EmotionsFragmentActivity.class);
			startActivity(emotion);
			break;
		case R.id.direction:
			Toast.makeText(this, "Directions is currently not available!", Toast.LENGTH_SHORT).show();
			break;
		case R.id.stories:
			Toast.makeText(this, "Stories is currently not available!", Toast.LENGTH_SHORT).show();
			break;
		case R.id.help:
			Toast.makeText(this, "Help is currently not available!", Toast.LENGTH_SHORT).show();
			break;
		}
	}

}
