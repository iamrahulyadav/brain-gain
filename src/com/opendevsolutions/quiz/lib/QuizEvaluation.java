package com.opendevsolutions.quiz.lib;

import android.util.Log;

public class QuizEvaluation {
	private double percentage = 0;
	
	public String evaluate( int correct, int items ) {
		this.percentage = (50 * (double) correct / (double) items) + 50;
		return this.percentageToString(this.percentage);
	}
	
	private String percentageToString( double p ) {
		Log.i("PERCENTAGE", "" + p);
		if (p >= 100) {
			Log.i("PERCENTAGE", "" + "EXCEL");
			return "Excellent";
		} else if (p >= 90) {
			Log.i("PERCENTAGE", "" + "VERYG");
			return "Very Good";
		} else if (p >= 80) {
			Log.i("PERCENTAGE", "" + "GOOD");
			return "Good";
		} else if (p >= 75) {
			Log.i("PERCENTAGE", "" + "FAIR");
			return "Good";
		}
		Log.i("PERCENTAGE", "" + "FAIL");
		return "Fair";
	}
	
}
