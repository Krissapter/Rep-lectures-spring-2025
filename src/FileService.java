import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class FileService {
    public void getMoviesFromFile(String filename) throws FileNotFoundException{
        DBService dbService = new DBService();
        File file = new File(filename);
        Scanner fs = new Scanner(file);
        while(fs.hasNext()){
            Movie movie = new Movie();
            movie.setMovieName(fs.nextLine());
            movie.setMovieDesc(fs.nextLine());
            movie.setGenre(Genre.valueOf(fs.nextLine()));
            movie.setMovieRuntime(Integer.parseInt(fs.nextLine()));
            try{
                dbService.insertMovie(movie);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
