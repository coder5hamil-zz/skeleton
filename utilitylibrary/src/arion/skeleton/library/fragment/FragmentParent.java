package arion.skeleton.library.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import arion.skeleton.library.R;
import arion.skeleton.library.utils.Logger;

abstract public class FragmentParent extends Fragment {

	private final int ILLEGAL_ID = Integer.MIN_VALUE;

	private int fragmentHolderId = ILLEGAL_ID;

	public void initialize(int layoutId) {

		if (layoutId == ILLEGAL_ID) {

			throw new IllegalArgumentException("Invalid View Layout ID");
		}

		this.fragmentHolderId = layoutId;
	}

	public void addFragment(FragmentNested destination) {

		if (this.fragmentHolderId == ILLEGAL_ID) {
			throw new IllegalStateException(
					"Did not set view layout for fragment transition.");
		}

		destination.setParent(this);

		FragmentManager transaction = getChildFragmentManager();
		String className = destination.getClass().getName();

		if (transaction.getBackStackEntryCount() > 0) {

			transaction
					.beginTransaction()
					.setCustomAnimations(R.anim.slide_in_right,
							R.anim.slide_out_left,
							R.anim.slide_in_left,
							R.anim.slide_out_right)
					.replace(this.fragmentHolderId, destination)
					.addToBackStack(className).commit();
		} else {

			transaction.beginTransaction()
					.add(this.fragmentHolderId, destination, className)
					.addToBackStack(className).commit();
		}
	}

	public boolean onBackEvent() {

		FragmentManager transaction = getChildFragmentManager();

		Logger.i(this.getClass().getSimpleName(),
				"Count " + transaction.getBackStackEntryCount());
		Logger.i(this.getClass().getSimpleName(),
				"Backevent");

		if (transaction.getBackStackEntryCount() > 1) {
			transaction.popBackStack();
			return false;
		} else {
			transaction.popBackStack();
			return true;
		}
	}

	public void backtoTransiton(String destination) {

		FragmentManager transaction = getChildFragmentManager();

		Logger.i(this.getClass().getSimpleName(),
				"Count " + transaction.getBackStackEntryCount());
		
		transaction.popBackStack(destination, 0);
	}
}
