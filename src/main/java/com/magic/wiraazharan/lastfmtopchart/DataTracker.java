package com.magic.wiraazharan.lastfmtopchart;

/**
 * Created by wiraazharan on 7/17/15.
 */
public class DataTracker {

    String trackname;
    String trackplaycount;
    String artistname;

    public DataTracker(String name , String playcount ,String  artist)
    {
        this.trackname = name;
        this.trackplaycount = playcount;
        this.artistname = artist;
    }

    public void setTrackname(String trackname) {
        this.trackname = trackname;
    }

    public void setTrackplaycount(String trackplaycount) {
        this.trackplaycount = trackplaycount;
    }

    public void setArtistname(String artistname) {
        this.artistname = artistname;
    }

    public String getTrackname() {
        return trackname;
    }

    public String getTrackplaycount() {
        return trackplaycount;
    }

    public String getArtistname() {
        return artistname;
    }
}
