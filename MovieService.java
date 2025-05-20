import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieService {
    public void getMoviesFromFile(String filename) throws FileNotFoundException {
        File file = new File(filename);
        ArrayList<Movie> movies = new ArrayList<>();
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNext()){
            Movie movie = new Movie();
            movie.setMovieName(fileScanner.nextLine());
            movie.setMovieDesc(fileScanner.nextLine());
            movie.setMovieGenre(Genre.valueOf(fileScanner.nextLine()));
            movie.setMovieRuntime(Integer.parseInt(fileScanner.nextLine()));
            movies.add(movie);
            fileScanner.nextLine();
        }
        for (Movie movie : movies){
            System.out.println(movie.toString());
        }
    }
}
