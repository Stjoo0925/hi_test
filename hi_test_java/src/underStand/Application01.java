package underStand;

import underStand.auth.impl.GoogleAuth;
import underStand.auth.impl.KakaoAuth;
import underStand.auth.impl.NaverAuth;
import underStand.dto.MemberDTO;
import underStand.service.MemberService;

import java.util.Scanner;

public class Application01 {

    public static void main(String[] args) {

        MemberService memberService;
        Scanner scanner = new Scanner(System.in);
        do {
            MemberDTO memberDTO;

            System.out.println("-----로그인 프로그램 시작-----");
            System.out.println("9. 프로그램 종료");
            System.out.print("로그인 할 인증 수단을 선택해주세요: ");
            int choice = scanner.nextInt();
            System.out.print("아이디를 입력해주세요: ");
            String id = scanner.next();
            System.out.print("비밀번호를 입력해주세요: ");
            String pwd = scanner.next();
            memberDTO = new MemberDTO(id, pwd);
            String result;

            switch (choice) {
                case 1:
                    memberService = new MemberService(new GoogleAuth());
                    result = memberService.loginMember(memberDTO);
                    break;
                case 2:
                    memberService = new MemberService(new NaverAuth());
                    result = memberService.loginMember(memberDTO);
                    break;
                case 3:
                    memberService = new MemberService(new KakaoAuth());
                    result = memberService.loginMember(memberDTO);
                    break;
                default:
                    result = "로그인 실패";
                    break;
            }
            System.out.println(result);
        } while (true);
    }
}

// 동적 바인딩이 문제라면, MemberService 클래스가 Auth 인터페이스를 통해 동적으로 인증 객체를 받아야 하는데,
// 이를 제대로 처리하지 못하고 있을 가능성이 있습니다. 이를 해결하기 위해 Auth 인터페이스와 이를 구현하는
// GoogleAuth, NaverAuth, KakaoAuth 클래스가 올바르게 정의되어 있는지 확인해야 합니다.

