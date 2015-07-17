package com.magic.wiraazharan.lastfmtopchart;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class LastFMTopChart extends Activity {

    private Button gettoptrack;
    private ListView trackllist;
    private ArrayList<DataTracker> tracks;
    private LayoutInflater layoutInflator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_fmtop_chart);


        gettoptrack = (Button)findViewById(R.id.get_top_track);
        trackllist = (ListView)findViewById(R.id.tracklisst);
        layoutInflator = LayoutInflater.from(this);


        gettoptrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                APITask lfmTask = new APITask(LastFMTopChart.this);
                try {

                    lfmTask.execute();
                }
                catch (Exception e)
                {
                    lfmTask.cancel(true);
                    alert (getResources().getString(R.string.no_tracks));
                }


            }
        });





    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_last_fmtop_chart, menu);
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

    public void alert(String s) {

        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }


    public void setTracks(ArrayList<DataTracker> trackdata) {

        this.tracks = trackdata;
        this.trackllist.setAdapter(new TopChartListviewAdapter(this,this.layoutInflator, this.tracks));
    }


    public static class ViewHolder
    {
        public TextView tname;
        public TextView playcount;
        public TextView artistn;
        public DataTracker t;
    }


}

