package com.opendevsolutions.quiz.lib;

import java.util.ArrayList;
import java.util.Random;

import android.util.Log;
import android.widget.ImageView;

public class QuizItems {
	private ArrayList<Object> list_of_choices = new ArrayList<Object>();
	private ArrayList<Object> list_of_items = new ArrayList<Object>();
	private ArrayList<Integer> list_of_indexes = new ArrayList<Integer>();
	private int myImage;

	// list or dynamic array
	// number, title, questiontext, choices, answer
	public int currentItemIndex = 0;
	private int number_of_items = 0;

	public int addItem(String questiontext, ArrayList<String> choices,
			String answer) {
		ArrayList<String> newItem = new ArrayList<String>();
		newItem.add(questiontext); // index = 0
		newItem.add(answer); // index = 1
		list_of_items.add(newItem);

		list_of_choices.add(choices);
		list_of_indexes.add(list_of_indexes.size());
		this.number_of_items = list_of_indexes.size();

		return 1;
	}

	public int getLength() {
		return list_of_items.size();
	}

	public int getImage() {
		return myImage;
	}

	public void setImage(int aImage) {
		myImage = aImage;
	}

	@SuppressWarnings("unchecked")
	public String getAnswer(int itemIndex) {
		ArrayList<String> nn = new ArrayList<String>();
		nn = (ArrayList<String>) list_of_items.get(list_of_indexes
				.get(itemIndex));
		return nn.get(1);
	}

	@SuppressWarnings("unchecked")
	public String getQuestion(int itemIndex) {
		ArrayList<String> nn = new ArrayList<String>();
		nn = (ArrayList<String>) list_of_items.get(list_of_indexes
				.get(itemIndex));
		return nn.get(0);
	}

	public Object getItem(int itemIndex) {
		currentItemIndex = itemIndex;
		return list_of_items.get(list_of_indexes.get(itemIndex));
	}

	public Object getItemChoices(int itemIndex) {
		return list_of_choices.get(list_of_indexes.get(itemIndex));
	}

	public boolean shuffle() {
		Log.i("prev order", list_of_indexes.toString());
		Random r = new Random();
		for (int h = 0; h < 2; h++) {
			for (int i = 0; i < this.list_of_indexes.size() - 1; i++) {
				int num1, num2, otherIndex;
				num1 = list_of_indexes.get(i);
				if (r.nextInt() > 0) {
					otherIndex = 0;
					num2 = list_of_indexes.get(otherIndex);
				} else {
					otherIndex = list_of_indexes.size() - 1;
					num2 = list_of_indexes.get(otherIndex);
				}
				// swap
				list_of_indexes.set(i, num2);
				list_of_indexes.set(otherIndex, num1);
			}
		}
		Log.i("curr order", list_of_indexes.toString());

		return true;
	}

	public void setNumberOfItems(int items) {
		if (items == 0)
			items = this.getLength();
		this.number_of_items = items;
	}

	public int getNumberOfItems() {
		return this.number_of_items;
	}
}
