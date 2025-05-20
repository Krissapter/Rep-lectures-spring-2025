import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        FileService ms = new FileService();
        try {
            ms.getMoviesFromFile("files/movies.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        DBService dbService = new DBService();
        try{
            dbService.getAllMovies();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
