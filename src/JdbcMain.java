import dao.FBDAO;
import dao.MyPageDAO;
import vo.FreeBoardReplyVO;
import vo.FreeBoardVO;
import vo.UserInfoVO;

import java.util.List;
import java.util.Scanner;

public class JdbcMain {
    public static void main(String[] args) {
        menuSelect();

    }
        public static void menuSelect() {
            Scanner sc = new Scanner(System.in);
            FBDAO dao = new FBDAO();
            MyPageDAO dao2 = new MyPageDAO();
            while(true) {
                System.out.println("===== [MOVIE COMMUNITY] =====");
                System.out.println("=====   메뉴를 선택 하세요   =====");
                System.out.print("[1]게시글 조회 [2]게시글 작성 [3]게시글 검색 [4]마이페이지 [5]종료 : ");
                int sel = sc.nextInt();
                switch(sel) {
                    case 1:
                        System.out.print("[1]게시글 전체 조회 [2]게시글 선택 조회 : ");
                        int num = sc.nextInt();
                        if (num == 1) {
                            List<FreeBoardVO> list = dao.listFB();
                            dao.printFBSelect(list);
                        } else if (num == 2) {
                            System.out.print("[1]선택 게시글 조회 [2]댓글 작성 : ");
                            int num2 = sc.nextInt();
                            if (num2 == 1) {
                                List<FreeBoardVO> list = dao.FBSelectDAO2();
                                dao.printFBSelect(list);
                            } else if (num2 == 2) {
                                dao.reInsert();
                            }
                        }
                        break;
                    case 2:
                        dao.fbInsert();
                        break;
                    case 3:
                        List<FreeBoardVO> list = dao.FBSelectDAO2();
                        dao.printFBSelect(list);
                        break;
                    case 4:
                        System.out.println();
                        System.out.print("[1]내 정보 [2]내가 쓴 글 [3]내가 쓴 댓글 : ");
                        int num3 = sc.nextInt();
                        if (num3 == 1) {
                            List<UserInfoVO> myPageVOList = dao2.listMP();
                            dao2.printMPSelect(myPageVOList);
                        } else if (num3 == 2) {
                            List<FreeBoardVO> myPageVOList = dao.listSelectB();
                            dao.printFBSelect(myPageVOList);
                            System.out.print("[1]수정 [2]삭제 : ");
                            int num3_1 = sc.nextInt();
                            if (num3_1 == 1) {
                                dao.fbUpdate();
                                List<FreeBoardVO> uList = dao.listFB();
                                dao.printFBSelect(uList);
                                System.out.println("게시글 수정 완료");
                            } else if (num3_1 == 2) {
                                dao.fbDelete();
                                System.out.println("게시글 삭제 완료");
                            }
                        } else if (num3 == 3) {
                            List<FreeBoardReplyVO> rList = dao.listSelectR();
                            dao.printRSelect(rList);
                            System.out.print("[1]수정 [2]삭제 : ");
                            int num3_2 = sc.nextInt();
                            if (num3_2 == 1) {
                                dao.reUpdate();
                                List<FreeBoardReplyVO> uList = dao.listRe();
                                dao.printRSelect(uList);
                                System.out.println("댓글 수정 완료");
                            } else if (num3_2 == 2) {
                                dao.reDelete();
                                System.out.println("댓글 삭제 완료");
                            }
                        }
                        break;
                    case 5:
                        System.out.println("메뉴를 종료 합니다");
                        return;

            }
        }
    }
}
