package com.arion.skeleton.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import arion.skeleton.library.manager.SlidemenuClickListener;

import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.arion.skeleton.R;
import com.arion.skeleton.activity.fragment.SampleListFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public abstract class ParentActivity extends SlidingFragmentActivity implements SlidemenuClickListener {

	private int mTitleRes;
	protected ListFragment menuFragment;
	protected SlidingMenu slidemenu;

	public ParentActivity(int titleRes) {
		mTitleRes = titleRes;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle(mTitleRes);

		setBehindContentView(R.layout.slidemenu_layout);
		if (savedInstanceState == null) {
			FragmentTransaction transaction = this.getSupportFragmentManager().beginTransaction();
			menuFragment = new SampleListFragment(this);
			transaction.replace(R.id.menu_frame, menuFragment);
			transaction.commit();
		} else {
			menuFragment = (ListFragment)this.getSupportFragmentManager().findFragmentById(R.id.menu_frame);
		}
		
		slidemenu = getSlidingMenu();
		slidemenu.setShadowWidthRes(R.dimen.shadow_width);
		slidemenu.setShadowDrawable(R.drawable.shadow);
		slidemenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		slidemenu.setFadeDegree(0.35f);
		slidemenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			toggle();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getSupportMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public abstract void onSlideMenuClick(int position);
}
