package JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            Common.close(rs);
            Common.close(stmt);
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

    public void MovieInsert() {
        Connection conn = null;
        PreparedStatement pStmt = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("MOVIE TABLE에 입력할 정보를 입력 하세요");
        String movieID = "SEQUENCE MOVIE_ID";
        System.out.print("영화제목 : ");
        String title = sc.nextLine();
        System.out.print("개봉일 : ");
        //SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String date = sc.next();
        System.out.print("상영시간 : ");
        int runtime = sc.nextInt();
        System.out.print("장르 : ");
        String genre = sc.next();
        System.out.print("감독 : ");
        String director = sc.next();
        System.out.print("출연배우 : ");
        String cast = sc.next();

        String query = "INSERT INTO MOVIE(MOVIE_ID, TITLE, OPEN_DATE, RUNTIME, GENRE, DIRECTOR, CAST) VALUES(MOVIE_ID.NEXTVAL, ?, ?, ?, ?, ?, ?)";

        try {
            conn = Common.getConnection();
            pStmt = conn.prepareStatement(query);
            pStmt.setString(1, title);
            pStmt.setString(2, date);
            pStmt.setInt(3, runtime );
            pStmt.setString(4, genre);
            pStmt.setString(5, director);
            pStmt.setString(6, cast);
            pStmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        Common.close(pStmt);
        Common.close(conn);
    }



    public void MovieDelete() {
        Connection conn = null;
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("삭제할 영화 번호 입력 하세요 : ");
        String movieID = sc.next();

        String query = "DELETE FROM MOVIE WHERE MOVIE_ID = " + "'" + movieID + "'";

        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            int ret = stmt.executeUpdate(query);
            System.out.println("Return : " + ret);

        } catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(stmt);
        Common.close(conn);

    }
}