import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileService {
    public void getMoviesFromFile(String filename) throws FileNotFoundException{
        ArrayList<Movie> movies = new ArrayList<>();
        File file = new File(filename);
        Scanner fs = new Scanner(file);
        while(fs.hasNext()){
            Movie movie = new Movie();
            movie.setMovieName(fs.nextLine());
            movie.setMovieDesc(fs.nextLine());
            movie.setGenre(Genre.valueOf(fs.nextLine()));
            movie.setMovieRuntime(Integer.parseInt(fs.nextLine()));
            movies.add(movie);
        }
        for (Movie m : movies){
            System.out.println(m);
        }
    }
}
