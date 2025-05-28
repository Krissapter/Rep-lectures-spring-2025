import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBService {
    private final static String GET_ALL_MOVIES = "SELECT * FROM movie";
    private final static String GET_MOVIES_BY_NAME = "SELECT * FROM movie WHERE MovieName = ?";
    private final static String GET_MOVIES_BY_GENRE = "SELECT * FROM movie WHERE MovieGenre = ?";

    private final static String INSERT_MOVIE = "INSERT INTO movie VALUES (?, ?, ?, ?)";

    private final MysqlDataSource movieDS;
    public DBService(){
        movieDS = new MysqlDataSource();
        movieDS.setServerName(PropertyProvider.PROPS.getProperty("DB_SOURCE"));
        movieDS.setPortNumber(Integer.parseInt(PropertyProvider.PROPS.getProperty("DB_PORT")));
        movieDS.setDatabaseName(PropertyProvider.PROPS.getProperty("DB_NAME"));
        movieDS.setUser(PropertyProvider.PROPS.getProperty("DB_USR"));
        movieDS.setPassword(PropertyProvider.PROPS.getProperty("DB_PSWRD"));
    }
    public List<Movie> getAllMovies() throws SQLException{

        return processQuery(GET_ALL_MOVIES, null);
    }
    public List<Movie> getMovieByName(String name)throws SQLException{
        return processQuery(GET_MOVIES_BY_NAME, name);
    }
    public List<Movie> getMoviesByGenre(String genre) throws SQLException{
        return processQuery(GET_MOVIES_BY_GENRE, genre);
    }
    public void insertMovie(Movie movie)throws SQLException{
        try (Connection conn = movieDS.getConnection();
        PreparedStatement stmt = conn.prepareStatement(INSERT_MOVIE)
        ){
         stmt.setString(1, movie.getMovieName());
         stmt.setString(2, movie.getMovieDesc());
         stmt.setString(3, String.valueOf(movie.getGenre()));
         stmt.setInt(4, movie.getMovieRuntime());
         stmt.executeUpdate();
        }
    }
    public List<Movie> processQuery(String query, String column)throws SQLException{
        List<Movie> movies = new ArrayList<>();
        try(Connection conn = movieDS.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)

        ){
            if (column != null){
                stmt.setString(1, column);
            }
            try(ResultSet rs = stmt.executeQuery()){
                while (rs.next()){
                    movies.add(new Movie(
                            rs.getString("MovieName"),
                            rs.getString("MovieDescription"),
                            Genre.valueOf(rs.getString("MovieGenre")),
                            rs.getInt("MovieRuntime")));
                }
            }
        }
        return movies;
    }
}
