package com.example.keremkucuk.lapitchat;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by keremkucuk on 12.11.17.
 */

class SectionsPagerAdapter extends FragmentPagerAdapter{

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            //case 0:
                //RequestsFragment requestsFragment = new RequestsFragment();
                //return  requestsFragment;

            case 0:
                ChatsFragment chatsFragment = new ChatsFragment();
                return chatsFragment;

            case 1:
                FriendsFragment friendsFragment = new FriendsFragment();
                return friendsFragment;

            case 2:
                MapsFragment mapsFragment = new MapsFragment();
                return  mapsFragment;
            case 3:
                CalendarFragment calendarFragment = new CalendarFragment();
                return calendarFragment;

        }
        return null;
    }

    @Override
    public int getCount() {
        return 4 ;
    }

    public CharSequence getPageTitle(int position){

        switch (position){
            //case 0:
                //return "Anfragen";
            case 0:
                return "Chats";
            case 1:
                return "Freunde";
            case 2:
                return "Maps";
            case 3:
                return "Events";

            default:
                return null;
        }
    }
}
