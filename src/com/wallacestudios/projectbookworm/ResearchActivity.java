package com.wallacestudios.projectbookworm;

import com.wallacestudios.projectbookworm.LocationsActivity.LocationsFragment;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class ResearchActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setTitle("Research");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_research);
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new ResearchFragment()).commit();
		}
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.research, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class ResearchFragment extends Fragment {

		private static final String ARG_SECTION_NUMBER = "section_number";

		public static ResearchFragment newInstance() {
			ResearchFragment fragment = new ResearchFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, 2);
			fragment.setArguments(args);
			return fragment;
		}

		public ResearchFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_research,
					container, false);
			return rootView;
		}
	}
}
