package com.opendevsolutions.abc;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.opendevsolutions.braingain.R;
import com.opendevsolutions.quiz.lib.QuizEvaluation;
import com.opendevsolutions.quiz.lib.QuizItems;
import com.opendevsolutions.quiz.lib.XmlParser;

public class ABCQuizActivity extends Activity implements OnClickListener {

	public QuizItems qis = new QuizItems();
	public QuizEvaluation eval = new QuizEvaluation();
	public static int currentItem = 0;
	public ArrayList<String> choices = new ArrayList<String>();

	final Context context = this;

	public RadioButton[] rbtn;
	public RadioGroup rgrp;
	public TextView tvQ;

	private static String filename;
	private static String dialogTitle = "Alpabhet Quiz Results";
	int itemsLimit = 5;
	int correctAnswers = 0;

	public AlertDialog resultDialog;
	public AlertDialog.Builder resultBuilder;

	@Override
	public void onBackPressed() {

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_abc_quiz_layout);

		rgrp = (RadioGroup) findViewById(R.id.quiz_rgrp);
		setQuestions();
		tvQ = (TextView) findViewById(R.id.quizQuestion);
		setLayout();
	}

	@Override
	public void onClick(View v) {
		Toast.makeText(this, "Please finish the Quiz first.", Toast.LENGTH_LONG)
				.show();
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
		choices = (ArrayList<String>) qis.getItemChoices(currentItem);
		rbtn = new RadioButton[choices.size()];
		for (int i = 0; i < choices.size(); i++) {
			rbtn[i] = new RadioButton(this);
			rgrp.addView(rbtn[i]);
			rbtn[i].setText(choices.get(i));
		}
	}

	public void setQuestions() {
		XmlParser parser = new XmlParser();
		String xml = parser.getXmlFromAssets(filename, getApplicationContext());
		Document doc = parser.getDomElement(xml);
		NodeList nl = doc.getElementsByTagName("question");
		for (int i = 0; i < nl.getLength(); i++) {
			Element e = (Element) nl.item(i);
			String question = parser.getValue(e, "text");
			ArrayList<String> choices = parser.getAllValues(e, "choice");
			String answer = parser.getValue(e, "answer");
			qis.addItem(question, choices, answer);
		}
		qis.setNumberOfItems(itemsLimit);
		qis.shuffle();
	}

	private void setLayout() {
		tvQ.setText((currentItem + 1) + ") " + qis.getQuestion(currentItem));
		this.addRadioButtons();
	}

	public void showResult() {
		resultBuilder = new AlertDialog.Builder(this);
		resultBuilder.setTitle("SCORE");
		resultBuilder.setIcon(R.drawable.ic_launcher);
		resultBuilder.setMessage("Score: " + correctAnswers + "/" + itemsLimit
				+ "\n" + eval.evaluate(correctAnswers, itemsLimit));
		resultBuilder.setPositiveButton("OK",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						
					}
				});

	}

	public static String getFileName() {
		return filename;
	}

	public void setFileName(String name) {
		filename = "questions/";
		filename = filename + name;
	}

}
