public class Song {
    private String name;
    private String artist;
    private String album;

    public Song(String name, String artist, String album) {
        this.name = name;
        this.artist = artist;
        this.album = album;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Song other = (Song) o;

        if (name.equals(other.getName())
                && artist.equals(other.getArtist())
                && album.equals(other.getAlbum())) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return name + " - " + artist + " (" + album + ")";
    }
}
