package com.example.keremkucuk.lapitchat;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalendarFragment extends Fragment {

    private static final String TAG = "CalendarFragment";

    View myView;

    private CalendarView mCalendarView;

    private FloatingActionButton fab;

    protected String date;

   /* public CalendarFragment() {
        // Required empty public constructor
    }
*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myView = inflater.inflate(R.layout.fragment_calendar, container, false);
        mCalendarView = myView.findViewById(R.id.calendarView);

        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                //i2 = Tag, i1+1 = Monat, i = Jahr
            date = i2 + "." + (i1+1) + "." + i;
            }
        });

        fab = myView.findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), AddEventActivity.class);
                i.putExtra("date", date);
                startActivity(i);
            }
        });
        // Inflate the layout for this fragment
        return myView;
    }

}
