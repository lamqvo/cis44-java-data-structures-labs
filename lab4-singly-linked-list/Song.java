public class Song {
    private String title;       // Song title
    private String artist;      // Song artist
    // Constructor Song
    public Song(String title, String artist){
        this.title = title;
        this.artist = artist;
    }
    // returns  title of the song
    public String getTitle() {
        return title;
    }
    // return artist of the song
    public String getArtist(){
        return artist;
    }
    // Override toString() to return format of the song:  title by artist
    @Override
    public String toString() {
        return "'" + title + "' by " + artist;
    }
}
