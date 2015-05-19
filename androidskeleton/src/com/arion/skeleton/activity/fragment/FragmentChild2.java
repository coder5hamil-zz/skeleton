package com.arion.skeleton.activity.fragment;

import com.arion.skeleton.R;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import arion.skeleton.library.fragment.FragmentNested;

public class FragmentChild2 extends FragmentNested {

	public void transactionInitiate() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_child_2, container, false);
		return view;
	}
}
