public class Movie {
    private String movieName;
    private String movieDesc;
    private Genre movieGenre;
    private int movieRuntime;
    Movie(){}
    Movie(String movieName, String MovieDesc, Genre movieGenre, int movieRuntime){
        this.movieName = movieName;
        this.movieDesc = MovieDesc;
        this.movieGenre = movieGenre;
        this.movieRuntime = movieRuntime;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getMovieDesc() {
        return movieDesc;
    }

    public Genre getMovieGenre() {
        return movieGenre;
    }

    public int getMovieRuntime() {
        return movieRuntime;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setMovieDesc(String movieDesc) {
        this.movieDesc = movieDesc;
    }

    public void setMovieGenre(Genre movieGenre) {
        this.movieGenre = movieGenre;
    }

    public void setMovieRuntime(int movieRuntime) {
        this.movieRuntime = movieRuntime;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieName='" + movieName + '\'' +
                ", movieDesc='" + movieDesc + '\'' +
                ", movieGenre=" + movieGenre +
                ", movieRuntime=" + movieRuntime +
                '}';
    }
}
