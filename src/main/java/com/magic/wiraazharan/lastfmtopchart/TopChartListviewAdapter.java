package com.magic.wiraazharan.lastfmtopchart;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by wiraazharan on 7/17/15.
 */
public class TopChartListviewAdapter extends BaseAdapter{



        private static final String debugTag = "TrackDataAdapter";
        private LastFMTopChart activity;

        private LayoutInflater layoutInflater;
        private ArrayList<DataTracker> tracks;


        public TopChartListviewAdapter (LastFMTopChart a,  LayoutInflater l, ArrayList<DataTracker> data)
        {
            this.activity = a;
            this.layoutInflater = l;
            this.tracks = data;
        }

        @Override
        public int getCount() {
            return this.tracks.size();
        }

        @Override
        public boolean areAllItemsEnabled ()
        {
            return true;
        }

        @Override
        public Object getItem(int arg0) {
            return null;
        }

        @Override
        public long getItemId(int pos) {
            return pos;
        }

        @Override
        public View getView(int pos, View convertView, ViewGroup parent) {
            LastFMTopChart.ViewHolder holder;
            if (convertView == null) {
                convertView = layoutInflater.inflate (R.layout.eachrow, parent, false);
                holder = new LastFMTopChart.ViewHolder();
                holder.tname = (TextView) convertView.findViewById(R.id.tracker_name);
                holder.playcount = (TextView) convertView.findViewById(R.id.play_count);
                holder.artistn = (TextView) convertView.findViewById(R.id.artister_name);
                convertView.setTag(holder);
            }
            else {
                holder = (LastFMTopChart.ViewHolder) convertView.getTag();
            }

            //convertView.setOnClickListener(this);

            DataTracker track = tracks.get(pos);
            holder.t = track;
            holder.tname.setText("TRACK NAME : " + track.getTrackname());
            holder.playcount.setText("PLAY COUNT : " + track.getTrackplaycount());
            holder.artistn.setText("ARTIST NAME : " + track.getArtistname());
//            holder.trackButton.setOnClickListener(this);
//            if(track.getImageUrl() != null) {
//                holder.icon.setTag(track.getImageUrl());
//                Drawable dr = imgFetcher.loadImage(this, holder.icon);
//                if(dr != null) {
//                    holder.icon.setImageDrawable(dr);
//                }
//            } else {
//                holder.icon.setImageResource(R.drawable.filler_icon);
//            }

            return convertView;
        }

//        @Override
//        public void onClick(View v) {
//            MyViewHolder holder = (MyViewHolder) v.getTag();
//            if (v instanceof Button) {
//
//                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
//                        Uri.parse(holder.track.getArtistUrl()));
//                this.activity.startActivity(intent);
//
//            } else if (v instanceof View) {
//                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
//                        Uri.parse(holder.track.getTrackUrl()));
//                this.activity.startActivity(intent);
//            }
//            Log.d(debugTag, "OnClick pressed.");
//
//        }


}
