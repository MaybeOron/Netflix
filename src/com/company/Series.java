package com.company;

public class Series {

    private final String seriesName;
    private final Episode[] episodes;

    public String getSeriesName() {
        return seriesName;
    }
    public Episode[] getEpisodes() { return episodes; }

    public Series(String seriesName, Episode[] episodes) {
        this.seriesName = seriesName;
        this.episodes = episodes;
    }

}
