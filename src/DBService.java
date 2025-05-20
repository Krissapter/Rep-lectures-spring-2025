import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBService {

    private final static String GET_ALL_MOVIES_SQL = "SELECT * FROM movies";
    private final static String GET_MOVIES_BY_NAME = "SELECT * FROM movies WHERE MovieName=";
    private final static String GET_MOVIES_BY_GENRE = "SELECT * FROM movies WHERE MovieGenre=";

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
        List<Movie> movies = new ArrayList<>();
        try(Connection conn = movieDS.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(GET_ALL_MOVIES_SQL);
        ){
            while (rs.next()) {
                movies.add(new Movie(
                        rs.getString("MovieName"),
                        rs.getString("MovieDesc"),
                        Genre.valueOf(rs.getString("MovieGenre")),
                        rs.getInt("MovieRuntime")
                ));
            }
        }
        return movies;
    }


}
