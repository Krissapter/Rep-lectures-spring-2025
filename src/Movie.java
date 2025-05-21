public class Movie {
    private String movieName;
    private String movieDesc;
    private Genre genre;
    private int movieRuntime;

    public String getMovieName() {
        return movieName;
    }

    public String getMovieDesc() {
        return movieDesc;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getMovieRuntime() {
        return movieRuntime;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    public void setMovieDesc(String movieDesc){
        this.movieDesc = movieDesc;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setMovieRuntime(int movieRuntime) {
        this.movieRuntime = movieRuntime;
    }
}
