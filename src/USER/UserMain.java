package USER;

import java.util.List;
import java.util.Scanner;

public class UserMain {
    public static void main(String[] args) {
        menuSelect();
    }

    public static void menuSelect() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("===== [관리자 Table 조회] =====");
            System.out.print("메뉴를 선택 하세요 [1]영화 조회, [2]영화 검색 [3]평점 남기기 [4] 평점 삭제 [5]EXIT : ");
            int sel = sc.nextInt();
            switch(sel) {
                case 1:
                    MovieDAO select2 = new MovieDAO();
                    List<MovieVO> list2 = select2.Movielist();
                    select2.printMovieSelect(list2);
                    break;

                case 2:
                    Search search1 = new Search();
                    List<MovieVO> mList = search1.search();
                    search1.printMovieSelect(mList);
                    break;


                case 3 :
                    GradeDAO insert = new GradeDAO();
                    insert.GradeInsert();
                    break;
                case 4 :
                    GradeDAO delete = new GradeDAO();
                    delete.GradeDelete();
                    break;
                case 5:
                    System.out.println("메뉴를 종료 합니다");
                    return;
            }
        }
    }
}

