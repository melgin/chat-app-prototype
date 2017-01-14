package com.example.melgin.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.melgin.myfirstapp.call.CallItemFragment;
import com.example.melgin.myfirstapp.contact.ContactItemFragment;
import com.example.melgin.myfirstapp.content.ContentItem;
import com.example.melgin.myfirstapp.listener.OnListFragmentInteractionListener;
import com.example.melgin.myfirstapp.message.MessageItemFragment;
import com.example.melgin.myfirstapp.util.Commons;
import com.example.melgin.myfirstapp.util.LoggerUtil;

public class WhatsAppChat extends AppCompatActivity implements OnListFragmentInteractionListener {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    private Menu menu;

    private static final LoggerUtil logger = LoggerUtil.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whats_app_chat);

        boolean loggerCreated = logger.init(this);
        if(loggerCreated){
            Toast.makeText(this, "Ready!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Failed to create logger!", Toast.LENGTH_LONG).show();
        }


        logger.error("A new activity created.");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        mViewPager.setCurrentItem(1);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                logger.error("User navigated to tab " + tab.getPosition());
                mViewPager.setCurrentItem(tab.getPosition());

                if (menu.getItem(1) != null) {
                    switch (tab.getPosition()) {
                        case 0:
                            menu.getItem(1).setIcon(R.drawable.ic_action_new_call);
                            break;
                        case 1:
                            menu.getItem(1).setIcon(R.drawable.ic_action_message);
                            break;
                        case 2:
                            menu.getItem(1).setIcon(R.drawable.ic_action_add_person);
                            break;
                        default:
                    }
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_whats_app_chat, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onListFragmentInteraction(ContentItem item) {
        logger.error("User clicked on \"" + item.name + "\"");

        Intent intent = new Intent(this, ChatActivity.class);
        intent.putExtra(Commons.EXTRA_ITEM_NAME, item.name);
        intent.putExtra(Commons.EXTRA_ITEM_ID, item.id);
        intent.putExtra(Commons.EXTRA_ITEM_QUOTE, item.quote);

        Bundle data = new Bundle();
        data.putInt(Commons.CURRENT_TAB, mViewPager.getCurrentItem());
        intent.putExtras(data);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        logger.error("User returned back from chat UI");

        if(requestCode == 1) {
            if(resultCode == RESULT_OK) {
                Bundle data = getIntent().getExtras();
                if(data != null){
                    Integer currentTab = data.getInt(Commons.CURRENT_TAB);
                    if(currentTab != null) {
                        mViewPager.setCurrentItem(currentTab);
                    }
                }
            }
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new CallItemFragment();
                case 1:
                    return new MessageItemFragment();
                case 2:
                    return new ContactItemFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Calls";
                case 1:
                    return "Chats";
                case 2:
                    return "Contacts";
            }
            return null;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        logger.error("Activity destroyed.");
        LoggerUtil.destroy();
    }
}
