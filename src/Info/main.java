package Info;

import JDBC.MovieDAO;
import JDBC.MovieVO;

import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
            menuSelect();
        }

        public static void menuSelect() {
            Scanner sc = new Scanner(System.in);
            while(true) {
                System.out.println("===== [MOVIE Table 조회] =====");
                System.out.print("메뉴를 선택 하세요 [1]SELECT, [2]INSERT, [3]DELETE, [4]EXIT : ");
                int sel = sc.nextInt();
                switch(sel) {
//                    case 1:
//                        MovieDAO select = new MovieDAO();
//                        List<MovieVO> list = select.list();
//                        select.printMovieSelect(list);
//                        break;
                    case 2 :
                        MovieDAO insert = new MovieDAO();
                        insert.MovieInsert();
                        break;
                    case 3 :
                        MovieDAO delete = new MovieDAO();
                        delete.MovieDelete();
                        break;
                    case 4:
                        System.out.println("메뉴를 종료 합니다");
                        return;
                }
            }
        }
    }
