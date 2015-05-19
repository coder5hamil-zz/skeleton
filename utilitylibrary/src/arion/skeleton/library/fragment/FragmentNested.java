package arion.skeleton.library.fragment;

import android.support.v4.app.Fragment;

public class FragmentNested extends Fragment {
	
	private FragmentParent parent;
	
	public FragmentParent getParent() {
		return parent;
	}

	public void setParent(FragmentParent parent) {
		this.parent = parent;
	}

	public void gotoFragment(FragmentNested destination){
		this.parent.addFragment(destination);
	}
	
	public void backtoFragment(String destinationFragment) {
		this.parent.backtoTransiton(destinationFragment);
	}
}
