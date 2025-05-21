import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        FileService fs = new FileService();
        DBService ds = new DBService();
        Movie movie = new Movie("Scream", "2 Guys kill some people", Genre.HORROR, 126);

        try {
            fs.getMoviesFromFile("movies.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            ds.insertMovie(movie);
            for(Movie m : ds.getAllMovies()){
                System.out.println(m);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
