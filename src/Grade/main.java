package Grade;

import USER.GradeDAO;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        menuSelect();
    }

    public static void menuSelect() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("===== [Grade Table 조회] =====");
            System.out.print("메뉴를 선택 하세요 [1]SELECT, [2]INSERT [3]DELETE [4]EXIT : ");
            int sel = sc.nextInt();
            switch(sel) {
//                case 1:
//                    GradeDAO select = new GradeDAO();
//                    List<GradeVO> list = select.list();
//                    select.MovieGradeSelect(list);
//                    break;
                case 2 :
                    GradeDAO insert = new GradeDAO();
                    insert.GradeInsert();
                    break;
                case 3 :
                    GradeDAO delete = new GradeDAO();
                    delete.GradeDelete();
                    break;
                case 4:
                    System.out.println("메뉴를 종료 합니다");
                    return;
            }
        }
    }
}
