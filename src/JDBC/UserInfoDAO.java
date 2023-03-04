package JDBC;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    public class UserInfoDAO {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        static Scanner sc = new Scanner(System.in);
        String checkID = null;

        public List<UserInfoVO> userSelect() {
            List<UserInfoVO> list = new ArrayList<>();
            try {
                conn = Common.getConnection();
                stmt = conn.createStatement();
                String sql = "SELECT * FROM USERINFO";
                rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    String id = rs.getString("LOGIN_ID");
                    String pw = rs.getString("LOGIN_PW");
                    String nick = rs.getString("NICKNAME");
                    String email = rs.getString("EMAIL");
                    String phone = rs.getString("PHONE");
                    UserInfoVO vo = new UserInfoVO(id, pw, nick, email, phone);
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
        void printUserInfoSelect(List<UserInfoVO> list) {
            for (UserInfoVO e : list) {
                System.out.print(e.getId() + " ");
                System.out.print(e.getPw() + " ");
                System.out.print(e.getNick() + " ");
                System.out.print(e.getEmail() + " ");
                System.out.print(e.getPhone() + " ");
                System.out.println();

            }
        }
}
