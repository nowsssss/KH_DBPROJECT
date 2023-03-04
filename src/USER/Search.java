package USER;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Search {
    public List<MovieVO> search() {
        Scanner sc = new Scanner(System.in);
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;

        List<MovieVO> mList = new ArrayList<>();

        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String query = "SELECT * FROM MOVIE WHERE TITLE LIKE ? OR CAST LIKE ? OR GENRE LIKE? OR DIRECTOR LIKE?";
            pStmt = conn.prepareStatement(query);
            System.out.print("검색 : ");
            String search = sc.nextLine();
            pStmt.setString(1, "%" + search + "%");
            pStmt.setString(2, "%" + search + "%");
            pStmt.setString(3, "%" + search + "%");
            pStmt.setString(4, "%" + search + "%");
            rs = pStmt.executeQuery();

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

                mList.add(vo);
            }
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return mList;
    }
    void printMovieSelect(List<MovieVO> MovieList2) {
        for (MovieVO e : MovieList2) {
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

