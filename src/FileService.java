import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class FileService {
    public void getMoviesFromFile(String filename) throws FileNotFoundException {
        File file = new File(filename);
        DBService dbService = new DBService();
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNext()){
            Movie movie = new Movie();
            movie.setMovieName(fileScanner.nextLine());
            movie.setMovieDesc(fileScanner.nextLine());
            movie.setMovieGenre(Genre.valueOf(fileScanner.nextLine()));
            movie.setMovieRuntime(Integer.parseInt(fileScanner.nextLine()));
            try {
                dbService.InsertMovie(movie);
            } catch (SQLException e) {
                System.out.println("An error occurred while writing to database\n" + e);
            }
            fileScanner.nextLine();
        }

    }
}
