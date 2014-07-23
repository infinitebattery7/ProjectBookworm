package com.wallacestudios.projectbookworm;

import java.util.Locale;

import com.wallacestudios.projectbookworm.LocationsActivity.LocationsFragment;
import com.wallacestudios.projectbookworm.NewsEventsActivity.NewsEventsFragment;
import com.wallacestudios.projectbookworm.ResearchActivity.ResearchFragment;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import android.support.v4.app.FragmentActivity;
import android.app.Activity;
import android.util.Log;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.content.Intent;
import android.support.v13.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.content.Intent;

public class HomeActivity extends FragmentActivity {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a {@link FragmentPagerAdapter}
	 * derivative, which will keep every loaded fragment in memory. If this
	 * becomes too memory intensive, it may be best to switch to a
	 * {@link android.support.v13.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;
	
	ExpandableListAdapter expListAdapter;
	ExpandableListView expListView;
	List<String> listDataHeader;
	HashMap<String, List<String>> listDataChild;
	ImageButton calendarButton, newsHighlightsButton, specialCollectionsButton, specialServicesButton, favoritesButton, loginWithAmazon;
	ImageView dplCaller;
	Button searchButton;
	EditText searchBox;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the activity.
		mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);
		setContentView(R.layout.fragment_home);
		calendarButton = (ImageButton)findViewById(R.id.calendarButton);
		newsHighlightsButton = (ImageButton)findViewById(R.id.newsHighlightsButton);
		specialCollectionsButton = (ImageButton)findViewById(R.id.specialCollectionsButton);
		specialServicesButton = (ImageButton)findViewById(R.id.specialServicesButton);
		favoritesButton = (ImageButton)findViewById(R.id.favoritesButton);
		searchButton = (Button)findViewById(R.id.searchButton);
		searchBox = (EditText)findViewById(R.id.searchBox);
		loginWithAmazon = (ImageButton)findViewById(R.id.loginwithamazon);
		dplCaller = (ImageView)findViewById(R.id.dplCall);
		
		dplCaller.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
					
				  Intent callIntent = new Intent(Intent.ACTION_CALL);
				    callIntent.setData(Uri.parse("tel:3134811300"));
				    startActivity(callIntent);		
			}}
		);		
		
		
		searchButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				
				String str = searchBox.getText().toString();
				str = str.replace(" ", "+");
				searchBox.setText("");
				
				Intent searchIntent = new Intent(v.getContext(), WebPanelActivity.newInstance("http://dplopac.detroitpubliclibrary.org/uhtbin/cgisirsi/x/0/0/57/5?user_id=webserver&searchdata1=" + str + "&srchfield1=GENERAL%5ESUBJECT%5EGENERAL%5E%5Ewords+or+phrase&sort_by=-PBYR&user_id=WEBSERVER&password=guest&Submit+now.").getClass());
				searchIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(searchIntent);			
			}}
		);
		
		loginWithAmazon.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				
				String str = searchBox.getText().toString();
				str = str.replace(" ", "+");
				searchBox.setText("");
				
				Intent amazonLoginIntent = new Intent(v.getContext(), AmazonLoginActivity.class);
				amazonLoginIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(amazonLoginIntent);			
			}}
		);
		
		
		
		calendarButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent calendarIntent = new Intent(v.getContext(), CalendarActivity.class);
				calendarIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(calendarIntent);			
			}}
		);
		
		newsHighlightsButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent newsHighlightsIntent = new Intent(v.getContext(), WebPanelActivity.newInstance("http://www.detroitpubliclibrary.org/news").getClass());
				newsHighlightsIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(newsHighlightsIntent);			
			}}
		);
		
		specialCollectionsButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent specialCollectionsIntent = new Intent(v.getContext(), WebPanelActivity.newInstance("http://www.detroitpubliclibrary.org/special-collections").getClass());
				specialCollectionsIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(specialCollectionsIntent);			
			}}
		);
		
		specialServicesButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent specialServicesIntent = new Intent(v.getContext(), WebPanelActivity.newInstance("http://www.detroitpubliclibrary.org/special-services").getClass());
				specialServicesIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(specialServicesIntent);			
			}}
		);
		
		favoritesButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent favoritesIntent = new Intent(v.getContext(), WebPanelActivity.newInstance("http://www.detroitpubliclibrary.org/research-resources").getClass());
				favoritesIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(favoritesIntent);			
			}}
		);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
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
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			
			Fragment fragmentToSet;
			
			switch (position)
			{
			case 0:	fragmentToSet = PlaceholderFragment.newInstance(position + 1); break;
			case 1: fragmentToSet = LocationsFragment.newInstance(); break;
			case 2: fragmentToSet = ResearchFragment.newInstance(); break;
			case 3: fragmentToSet = NewsEventsFragment.newInstance(); break;
			default: 	fragmentToSet = PlaceholderFragment.newInstance(position + 1);
						break;
			
			}
			
			return fragmentToSet;
		}

		@Override
		public int getCount() {
			return 3;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.app_name);
			case 1:
				return getString(R.string.title_activity_locations);
			case 2:
				return getString(R.string.title_activity_news_events);
			case 3:
				return getString(R.string.title_activity_research);
				default: return " ";
			}
			
		}
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		private static final String ARG_SECTION_NUMBER = "section_number";
		ImageButton calendarButton, newsHighlightsButton, specialCollectionsButton, specialServicesButton, favoritesButton;

		/**
		 * Returns a new instance of this fragment for the given section number.
		 */
		public static PlaceholderFragment newInstance(int sectionNumber) {
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_home, container,
					false);
			super.onCreate(savedInstanceState);
			//getActivity().setContentView(R.layout.fragment_home);
			
			//calendarButton = (Button)getActivity().findViewById(R.id.calendarButton);
			
//			calendarButton.setOnClickListener(new View.OnClickListener(){
//				@Override
//				public void onClick(View v) {
//					Intent calendarIntent = new Intent(v.getContext(), CalendarActivity.class);
//					calendarIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//					startActivity(calendarIntent);			
//				}}
//			);
//						
			
			
			return rootView;
		}
	}
	

}
