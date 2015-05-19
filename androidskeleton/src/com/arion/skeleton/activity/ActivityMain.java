package com.arion.skeleton.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

import com.arion.skeleton.R;
import com.arion.skeleton.activity.fragment.FragmentParent1;
import com.arion.skeleton.activity.fragment.FragmentParent2;
import com.arion.skeleton.activity.fragment.FragmentParent3;

public class ActivityMain extends ParentActivity {
    
	private FragmentManager fragmentManager;
	private FragmentTransaction fragmentTransaction;
	private Fragment fragmentParent1, fragmentParent2, fragmentParent3;
	private Fragment currentFragment, newFragment;
	private int currentFragmentID;
	
	public ActivityMain() {
		super(R.string.app_name);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		setSlidingActionBarEnabled(false);

		fragmentParent1 = new FragmentParent1();
		fragmentParent2 = new FragmentParent2();
		fragmentParent3 = new FragmentParent3();

		fragmentManager = ActivityMain.this.getSupportFragmentManager();
		fragmentTransaction = fragmentManager.beginTransaction();
		fragmentTransaction.add(R.id.content, fragmentParent1,
				fragmentParent1.getClass().getName());
		fragmentTransaction.add(R.id.content, fragmentParent2,
				fragmentParent2.getClass().getName());
		fragmentTransaction.add(R.id.content, fragmentParent3,
				fragmentParent3.getClass().getName());
		fragmentTransaction.commit();

		fragmentManager.beginTransaction().hide(fragmentParent1).commit();
		fragmentManager.beginTransaction().hide(fragmentParent2).commit();
		fragmentManager.beginTransaction().hide(fragmentParent3).commit();
		
		fragmentManager.beginTransaction().show(fragmentParent1).commit();
		currentFragment = fragmentParent1;
		currentFragmentID = 1;
	}

	@Override
	public void onSlideMenuClick(int position) {
		Toast.makeText(getApplicationContext(), "Clicked on item at position: " + position, Toast.LENGTH_SHORT).show();
		if(position % 3 == 0 && currentFragmentID != 1) {
			newFragment = fragmentParent1;
			currentFragmentID = 1;
		} else if(position % 3 == 1 && currentFragmentID != 2) {
			newFragment = fragmentParent2;
			currentFragmentID = 2;
		} else if(position % 3 == 2 && currentFragmentID != 3) {
			newFragment = fragmentParent3;
			currentFragmentID = 3;
		} 

		fragmentManager.beginTransaction().hide(currentFragment)
				.show(newFragment).commit();
		currentFragment = newFragment;
		slidemenu.toggle();
	}
}
