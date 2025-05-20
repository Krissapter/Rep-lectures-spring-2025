import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class Program {
    FileService ms = new FileService();
    DBService dbService = new DBService();
    public void run(){
        int choice = 0;
        Scanner input = new Scanner(System.in);
        while(choice != 5){
            System.out.println(
                    """
                            Choose an option by typing in one of the numbers below and pressing enter.
                               1) Make a new movie entry to the Database
                               2) List all movies in the Database
                               3) Search for movies by name
                               4) Search for movies by genre
                               5) Exit""");
            switch (input.nextInt()){
                case 1:
                    newEntry();
                    break;
                case 2:
                    getAllMovies();
                    break;
                case 3:
                    System.out.println("Please enter the name of the movie:");
                    getMovieByName();
                    break;
                case 4:
                    System.out.println("Please enter the genre:");
                    getMovieByGenre();
                    break;
                case 5:
                    choice = 5;
                default:
                    System.out.println("Please pick a valid option");
            }
        }


        try {
            ms.getMoviesFromFile("files/movies.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
    public void newEntry(){
        System.out.println("Not supported yet");
    }
    public void getAllMovies(){
        try{
            for(Movie m : dbService.getAllMovies()){
                System.out.println(m);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void getMovieByName(){
        try{
            Scanner input = new Scanner(System.in);
            String name = input.nextLine();
            for(Movie m : dbService.getMovieByName(name)){
                System.out.println(m);
            }
        } catch (SQLException e) {
            System.out.println("No movies with that name was found");
        }
    }
    public void getMovieByGenre(){
        try{
            Scanner input = new Scanner(System.in);
            String genre = input.nextLine();
            for(Movie m : dbService.getMovieByGenre(genre)){
                System.out.println(m);
            }
        } catch (SQLException e) {
            System.out.println("No move with that genre was found");
        }
    }
}
