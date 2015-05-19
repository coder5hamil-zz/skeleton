package com.arion.skeleton.activity.fragment;

import com.arion.skeleton.R;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import arion.skeleton.library.fragment.FragmentParent;

public class FragmentParent2 extends FragmentParent {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_parent_2, container, false);
		initialize(R.id.fragment_parent_2);
		addFragment(new FragmentChild2());

		return view;
	}
}
