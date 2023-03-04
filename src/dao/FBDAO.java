package dao;

import util.Common;
import vo.FreeBoardReplyVO;
import vo.FreeBoardVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FBDAO {
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Scanner sc = new Scanner(System.in);

    public List<FreeBoardVO> listFB() {
        List<FreeBoardVO> list = new ArrayList<>();
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String query = "SELECT * FROM FREEBOARD ORDER BY WRITE_NUM DESC";
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                int writeNum = rs.getInt("WRITE_NUM");
                String nickname = rs.getString("NICKNAME");
                String writeTitle = rs.getString("WRITE_TITLE");
                String writeContents = rs.getString("WRITE_CONTENTS");
                Date regDate = rs.getDate("REG_DATE");

                FreeBoardVO vo = new FreeBoardVO();
                vo.setWriteNum(writeNum);
                vo.setNickname(nickname);
                vo.setWriteTitle(writeTitle);
                vo.setWriteContents(writeContents);
                vo.setRegDate(regDate);

                list.add(vo);
            }
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<FreeBoardVO> FBSelectDAO2() {
        List<FreeBoardVO> list = new ArrayList<>();
        try {
            conn = Common.getConnection();

            String query = "SELECT * FROM FREEBOARD WHERE WRITE_TITLE LIKE ? OR WRITE_CONTENTS LIKE ?\n" +
                    "OR NICKNAME LIKE ?";
            pstmt = conn.prepareStatement(query);
            System.out.print("검색 : ");
            String search = sc.nextLine();
//            sc.nextLine();
            pstmt.setString(1, "%" + search + "%");
            pstmt.setString(2, "%" + search + "%");
            pstmt.setString(3, "%" + search + "%");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int writeNum = rs.getInt("WRITE_NUM");
                String nickname = rs.getString("NICKNAME");
                String writeTitle = rs.getString("WRITE_TITLE");
                String writeContents = rs.getString("WRITE_CONTENTS");
                Date regDate = rs.getDate("REG_DATE");

                FreeBoardVO vo = new FreeBoardVO(writeNum, nickname, writeTitle, writeContents, regDate);
                list.add(vo);
            }
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<FreeBoardVO> listSelectB() {
        List<FreeBoardVO> list = new ArrayList<>();
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String query = "SELECT * FROM FREEBOARD WHERE NICKNAME = '민지'";
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                int writeNum = rs.getInt("WRITE_NUM");
                String nickname = rs.getString("NICKNAME");
                String writeTitle = rs.getString("WRITE_TITLE");
                String writeContents = rs.getString("WRITE_CONTENTS");
                Date regDate = rs.getDate("REG_DATE");

                FreeBoardVO vo = new FreeBoardVO();
                vo.setWriteNum(writeNum);
                vo.setNickname(nickname);
                vo.setWriteTitle(writeTitle);
                vo.setWriteContents(writeContents);
                vo.setRegDate(regDate);

                list.add(vo);
            }
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<FreeBoardReplyVO> listRe() {
        List<FreeBoardReplyVO> list = new ArrayList<>();
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String query = "SELECT * FROM FREEBOARD_REPLY ORDER BY REPLY_NUM ASC";
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                int writeNum = rs.getInt("WRITE_NUM");
                int replyNum = rs.getInt("REPLY_NUM");
                String nickname = rs.getString("NICKNAME");
                String replyWrite = rs.getString("REPLY_WRITE");
                Date regDate = rs.getDate("REG_DATE");

                FreeBoardReplyVO vo = new FreeBoardReplyVO(writeNum, replyNum, nickname, replyWrite, regDate);
                list.add(vo);
            }
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<FreeBoardReplyVO> listSelectR() {
        List<FreeBoardReplyVO> list = new ArrayList<>();
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String query = "SELECT * FROM FREEBOARD_REPLY WHERE NICKNAME = '해린'";
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                int writeNum = rs.getInt("WRITE_NUM");
                int replyNum = rs.getInt("REPLY_NUM");
                String nickname = rs.getString("NICKNAME");
                String replyWrite = rs.getString("REPLY_WRITE");
                Date regDate = rs.getDate("REG_DATE");

                FreeBoardReplyVO vo = new FreeBoardReplyVO(writeNum, replyNum, nickname, replyWrite, regDate);
                list.add(vo);
            }
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    public void printFBSelect(List<FreeBoardVO> list) {
        System.out.println("==================================================================================");
        for (FreeBoardVO e : list) {
            System.out.print(e.getWriteNum() + "  ");
            System.out.print(e.getNickname() + "  [");
            System.out.print(e.getWriteTitle() + "]  ");
            System.out.print(e.getWriteContents() + "  /");
            System.out.print(e.getRegDate() + "  ");
            System.out.println();
        }
        System.out.println("==================================================================================");
    }

    public void printRSelect(List<FreeBoardReplyVO> list) {
        System.out.println("==================================================================================");
        for (FreeBoardReplyVO e : list) {
            System.out.print(e.getWriteNum() + "  ");
            System.out.print(e.getReplyNum() + "  ");
            System.out.print(e.getNickname() + "  ");
            System.out.print(e.getReplyWrite() + "  /");
            System.out.print(e.getRegDate() + "  ");
            System.out.println();
        }
        System.out.println("==================================================================================");
    }

    public void fbInsert() {
        System.out.println("FREEBOARD Table에 정보를 입력하세요");
        System.out.print("닉네임 : ");
        String nickname = sc.nextLine();
        sc.nextLine();
        System.out.print("글제목 : ");
        String writeTitle = sc.nextLine();
        sc.nextLine();
        System.out.print("글내용 : ");
        String writeContents = sc.nextLine();

        String query = "INSERT INTO FREEBOARD(WRITE_NUM, NICKNAME, WRITE_TITLE, WRITE_CONTENTS, REG_DATE) " +
                "VALUES(WRITE_NUM.NEXTVAL,?,?,?,SYSDATE)";

        try {
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, nickname);
            pstmt.setString(2, writeTitle);
            pstmt.setString(3, writeContents);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(pstmt);
        Common.close(conn);
    }

    public void fbUpdate() {
        System.out.println("수정할 정보를 입력하세요");
        System.out.print("수정할 게시글 번호 : ");
        int listNum = sc.nextInt();
        System.out.print("글제목 : ");
        String writeTitle = sc.next();
        sc.nextLine();
        System.out.print("글내용 : ");
        String writeContents = sc.nextLine();

        String query = "UPDATE FREEBOARD SET WRITE_TITLE = ?, " +
                "WRITE_CONTENTS = ? " +
                "WHERE NICKNAME = '민지' AND WRITE_NUM = ?";

        try {
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, writeTitle);
            pstmt.setString(2, writeContents);
            pstmt.setInt(3, listNum);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(pstmt);
        Common.close(conn);
    }

    public void fbDelete() {
        System.out.println("삭제할 정보를 입력하세요");
        System.out.print("삭제할 게시글 번호 : ");
        int dNum = sc.nextInt();

        String query = "DELETE FROM FREEBOARD\n" +
                "    WHERE WRITE_NUM = ?";
        try {
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, dNum);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(pstmt);
        Common.close(conn);
    }

    public void reInsert() {
        System.out.println("FREEBOARD_REPLY Table에 정보를 입력하세요");
        System.out.print("글번호 : ");
        int writeNum = sc.nextInt();
        System.out.print("닉네임 : ");
        String nickname = sc.nextLine();
        sc.nextLine();
        System.out.print("댓글내용 : ");
        String replyWrite = sc.nextLine();


        String query = "INSERT INTO FREEBOARD_REPLY(WRITE_NUM, REPLY_NUM, NICKNAME, REPLY_WRITE, REG_DATE) " +
                "VALUES(?,REPLY_NUM.NEXTVAL,?,?,SYSDATE)";

        try {
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, writeNum);
            pstmt.setString(2, nickname);
            pstmt.setString(3, replyWrite);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(pstmt);
        Common.close(conn);
    }


    public void reUpdate() {
        System.out.println("수정할 정보를 입력하세요");
//        System.out.print("수정할 댓글 번호 : ");
//        int listNum = sc.nextInt();
        System.out.print("댓글 내용 : ");
        String replyWrite = sc.nextLine();

        String query = "UPDATE FREEBOARD_REPLY SET REPLY_WRITE = ? WHERE NICKNAME = '해린'";

        try {
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, replyWrite);
//            pstmt.setInt(3, listNum);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(pstmt);
        Common.close(conn);
    }

    public void reDelete() {
        System.out.println("삭제할 정보를 입력하세요");
        System.out.print("삭제할 댓글 번호 : ");
        int dNum = sc.nextInt();

        String query = "DELETE FROM FREEBOARD_REPLY WHERE REPLY_NUM = ?";
        try {
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, dNum);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(pstmt);
        Common.close(conn);
    }
}