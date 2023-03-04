package JDBC;

import USER.GradeDAO;

import java.util.List;
import java.util.Scanner;

public class MainMgr {
    public static void main(String[] args) {
        menuSelect();
    }

    public static void menuSelect() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("===== [관리자 Table 조회] =====");
            System.out.print("메뉴를 선택 하세요 [1]회원정보, [2]영화 조회 [3]영화 추가 [4]영화 삭제 [5]EXIT : ");
            int sel = sc.nextInt();
            switch(sel) {
                case 1:
                    UserInfoDAO select = new UserInfoDAO();
                    List<UserInfoVO> list = select.userSelect();
                    select.printUserInfoSelect(list);
                    break;

                case 2:
                    MovieDAO select2 = new MovieDAO();
                    List<MovieVO> list2 = select2.Movielist();
                    select2.printMovieSelect(list2);
                    break;
                case 3 :
                    MovieDAO insert = new MovieDAO();
                    insert.MovieInsert();
                    break;
                case 4 :
                    MovieDAO delete = new MovieDAO();
                    delete.MovieDelete();
                    break;
                case 5:
                    System.out.println("메뉴를 종료 합니다");
                    return;
            }
        }
    }
}
