package USER;

import USER.GradeVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GradeDAO {
    public List<GradeVO> list(){
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;

        List<GradeVO> list = new ArrayList<>();

        try{
            conn = Grade.Common.getConnection();
            stmt = conn.createStatement();
            String query = "SELECT * FROM MOVIE_GRADE";
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                int movieID = rs.getInt("MOVIE_ID");
                int grade = rs.getInt("GRADE");
                String comment = rs.getString("COMMENT_1");
                String nickname = rs.getString("NICKNAME");

                GradeVO mgv = new GradeVO(movieID, grade, comment, nickname);
                mgv.setMovieID(movieID);
                mgv.setGrade(grade);
                mgv.setComment(comment);
                mgv.setNickname(nickname);

                list.add(mgv);
            }
            Grade.Common.close(rs);
            Grade.Common.close(stmt);
            Grade.Common.close(conn);

        } catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    void MovieGradeSelect(List<GradeVO> list){
        for(GradeVO e : list){
            System.out.print(e.getMovieID()+" ");
            System.out.print(e.getGrade()+" ");
            System.out.print(e.getComment()+" ");
            System.out.print(e.getNickname()+" ");
            System.out.println();
        }
    }
    public void GradeInsert() {
        Connection conn = null;
        PreparedStatement pStmt = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("MOVIE_GRADE Table에 입력할 정보를 입력 하세요.");
        System.out.print("영화번호 : ");
        int movieID = sc.nextInt();
        System.out.print("평점 : ");
        int grade = sc.nextInt();
        System.out.print("한줄평 : ");
        String comment = sc.next();
        System.out.print("닉네임 : ");
        String nickname = sc.next();

        String query = "INSERT INTO MOVIE_GRADE(MOVIE_ID, GRADE, COMMENT_1, NICKNAME) VALUES(?,?,?,?)";

        try {
            conn = JDBC.Common.getConnection();
            pStmt = conn.prepareStatement(query);
            pStmt.setInt(1, movieID);
            pStmt.setInt(2, grade);
            pStmt.setString(3, comment);
            pStmt.setString(4, nickname);
            pStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Grade.Common.close(pStmt);
        Grade.Common.close(conn);
    }
    public void GradeDelete(){
        Connection conn = null;
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("삭제할 영화 번호를 입력 하세요 : ");
        int movieID = sc.nextInt();

        String query = "DELETE FROM MOVIE_GRADE WHERE MOVIE_ID = "+movieID;

        try{
            conn = Grade.Common.getConnection();
            stmt = conn.createStatement();
            int ret = stmt.executeUpdate(query);
            System.out.println("Return : "+ret);
        } catch(Exception e){
            e.printStackTrace();
        }
        Grade.Common.close(stmt);
        Grade.Common.close(conn);
    }
}
