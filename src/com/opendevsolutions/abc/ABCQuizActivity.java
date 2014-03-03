package com.opendevsolutions.abc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.opendevsolutions.braingain.R;
import com.opendevsolutions.quiz.lib.QuizEvaluation;
import com.opendevsolutions.quiz.lib.QuizItems;
import com.opendevsolutions.quiz.lib.XmlParser;
import com.opendevsolutions.sql.lib.SQLSaveData;

public class ABCQuizActivity extends Activity implements OnClickListener {

	public QuizItems quiz = new QuizItems();
	public QuizEvaluation eval = new QuizEvaluation();
	public static int itemIndex = 0;
	public ArrayList<String> choice = new ArrayList<String>();

	final Context context = this;

	public RadioButton[] rbtn;
	public RadioGroup rgrp;
	public TextView tvQ;

	private static String filename;
	int itemLimit = 5;
	int cAnswers = 0;

	public AlertDialog resultDialog;
	public AlertDialog.Builder resultBuilder;

	private static final String quizName = "Alphabet Part 1";

	@Override
	public void onBackPressed() {
		Toast.makeText(this, "Please Complete the Quiz", Toast.LENGTH_SHORT)
				.show();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_abc_quiz_layout);

		rgrp = (RadioGroup) findViewById(R.id.quiz_rgrp);
		setQuestions();
		tvQ = (TextView) findViewById(R.id.quizQuestion);
		setLayout();
		Button ok = (Button) findViewById(R.id.btn_next);
		ok.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_next:
			String selected = getChoiceFromRadioButton();
			String answer = quiz.getAnswer(itemIndex);

			if (selected.equals(answer)) {
				cAnswers++;
			}

			if ((itemIndex + 1) < itemLimit) {
				rgrp.removeAllViews();
				itemIndex++;
				setLayout();
			} else {
				showResult();
			}
		}
	}

	private String getChoiceFromRadioButton() {
		for (int i = 0; i < rbtn.length; i++) {
			if (rbtn[i].isChecked()) {
				return rbtn[i].getText().toString();
			}
		}
		return "";
	}

	@SuppressWarnings("unchecked")
	private void addRadioButtons() {
		choice = (ArrayList<String>) quiz.getItemChoices(itemIndex);
		rbtn = new RadioButton[choice.size()];
		for (int i = 0; i < choice.size(); i++) {
			rbtn[i] = new RadioButton(this);
			rgrp.addView(rbtn[i]);
			rbtn[i].setText(choice.get(i));
		}
	}

	public void setQuestions() {
		XmlParser parser = new XmlParser();
		String xml = parser.getXmlFromAssets(getFileName(),
				getApplicationContext());
		Document doc = parser.getDomElement(xml);
		NodeList nl = doc.getElementsByTagName("question");
		for (int i = 0; i < nl.getLength(); i++) {
			Element e = (Element) nl.item(i);
			String question = parser.getValue(e, "text");
			ArrayList<String> choices = parser.getAllValues(e, "choice");
			String answer = parser.getValue(e, "answer");
			quiz.addItem(question, choices, answer);
		}
		quiz.setNumberOfItems(itemLimit);
		quiz.shuffle();
	}

	private void setLayout() {
		tvQ.setText((itemIndex + 1) + ") " + quiz.getQuestion(itemIndex));
		this.addRadioButtons();
	}

	public void backToMenu() {
		super.onBackPressed();
	}

	public void saveDataToDB(String q, int cScore){
		boolean didItWork = true;
		try{
			String score = String.valueOf(cScore);
			Calendar c = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("MM:dd:yy");
			String s = sdf.format(c.getTime());
			
			SQLSaveData save = new SQLSaveData(ABCQuizActivity.this);
			save.open();
			save.createData(q, score, (String) s );
			save.close();
		}catch(Exception e){
			didItWork = false;
			String error = e.toString();
			Log.e("Error ",error);
		}finally{
			if(didItWork){
				//Toast.makeText(this, "Yes, it worked", Toast.LENGTH_SHORT).show();
			}else{
				//Toast.makeText(this, "No, it failed", Toast.LENGTH_SHORT).show();
			}
		}
	}

	public void showResult() {
		resultBuilder = new AlertDialog.Builder(this);
		resultBuilder.setTitle("SCORE");
		resultBuilder.setIcon(R.drawable.ic_launcher);
		resultBuilder.setMessage("Score: " + cAnswers + "/" + itemLimit + "\n"
				+ eval.evaluate(cAnswers, itemLimit));
		resultBuilder.setPositiveButton("OK",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						resultDialog.dismiss();
						saveDataToDB(quizName, cAnswers);
						backToMenu();
						cAnswers = 0;
						ABCQuizActivity.this.finish();
					}
				});
		resultDialog = resultBuilder.create();
		resultDialog.show();
	}

	public static String getFileName() {
		return filename;
	}

	public void setFileName(String name) {
		filename = "questions/";
		filename = filename + name;
	}

}
