import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        MovieService ms = new MovieService();
        try {
            ms.getMoviesFromFile("files/movies.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
