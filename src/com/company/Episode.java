package com.company;

public class Episode {

    private final String episodeName;
    private final String episodeSummery;
    private final String episodeReleaseDate;

    public Episode(String episodeName, String episodeSummery, String episodeReleaseDate){
        this.episodeName = episodeName;
        this.episodeSummery = episodeSummery;
        this.episodeReleaseDate = episodeReleaseDate;
    }

    public void printEpisodeDetails(){
        System.out.println(episodeName+", "+episodeSummery+", released at "+episodeReleaseDate);
    }

    public String getEpisodeName() {
        return episodeName;
    }
    public String getEpisodeSummery() { return episodeSummery; }
    public String getEpisodeReleaseDate() { return episodeReleaseDate; }


}
