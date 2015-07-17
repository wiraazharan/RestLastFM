package com.magic.wiraazharan.lastfmtopchart;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by wiraazharan on 7/17/15.
 */
public class APITask extends AsyncTask<String, Integer, String> {

    private ProgressDialog progDialog;
    private Context context;
    private LastFMTopChart activity;
    private static final String debugTag = "LastFMWebAPITask";

    /**
     * Construct a task
     * @param activity
     */
    public APITask(LastFMTopChart activity) {
        super();
        this.activity = activity;
        this.context = this.activity.getApplicationContext();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progDialog = ProgressDialog.show(this.activity, "Search", this.context.getResources().getString(R.string.looking_for_tracks) , true, false);
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            Log.d(debugTag, "Background:" + Thread.currentThread().getName());
            String result = HelperClass.downloadFromServer();
            return result;
        } catch (Exception e) {
            return new String();
        }
    }

    @Override
    protected void onPostExecute(String result)
    {

        ArrayList<DataTracker> trackdata = new ArrayList<DataTracker>();

        progDialog.dismiss();
        if (result.length() == 0) {
            this.activity.alert ("Unable to find track data. Try again later.");
            return;
        }

        try {
            JSONObject respObj = new JSONObject(result);
            JSONObject topTracksObj = respObj.getJSONObject("tracks");
            JSONArray tracks = topTracksObj.getJSONArray("track");
            for(int i=0; i<tracks.length(); i++) {
                JSONObject track = tracks.getJSONObject(i);
                String trackname = track.getString("name");
                String trackplaycount = track.getString("playcount");
                JSONObject artistObj = track.getJSONObject("artist");
                String artistname = artistObj.getString("name");



                trackdata.add(new DataTracker(trackname,trackplaycount, artistname));
            }

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        this.activity.setTracks(trackdata);

    }
}