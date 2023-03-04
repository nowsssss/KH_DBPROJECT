package USER;

import USER.Common;
import USER.MovieVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {
    public List<MovieVO> Movielist() {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;

        List<MovieVO> MovieList = new ArrayList<>();
        try {
            System.out.print("DB에 접속 중입니다.");
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String query = "SELECT * FROM MOVIE";
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                int movieID = rs.getInt("MOVIE_ID");
                String title = rs.getString("TITLE");
                Date date = rs.getDate("OPEN_DATE");
                int runtime = rs.getInt("RUNTIME");
                String genre = rs.getString("GENRE");
                String director = rs.getString("DIRECTOR");
                String cast = rs.getString("CAST");

                MovieVO vo = new MovieVO(movieID, title, date, runtime, genre, director, cast);
                vo.setMovieID(movieID);
                vo.setTitle(title);
                vo.setDate(date);
                vo.setRuntime(runtime);
                vo.setGenre(genre);
                vo.setDirector(director);
                vo.setCast(cast);

                MovieList.add(vo);
            }
            JDBC.Common.close(rs);
            JDBC.Common.close(stmt);
            Common.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return MovieList;
    }

    void printMovieSelect(List<MovieVO> MovieList) {
        for (MovieVO e : MovieList) {
            System.out.print(e.getMovieID() + " ");
            System.out.print(e.getTitle() + " ");
            System.out.print(e.getDate() + " ");
            System.out.print(e.getRuntime() + " ");
            System.out.print(e.getGenre() + " ");
            System.out.print(e.getDirector() + " ");
            System.out.print(e.getCast() + " ");
            System.out.println();

        }
    }
}
