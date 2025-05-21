import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        FileService fs = new FileService();

        try {
            fs.getMoviesFromFile("movies.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
