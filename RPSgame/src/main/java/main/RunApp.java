package main;

import java.util.Scanner;

import basicGame.BasicGame;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RunApp {

    private static final BasicGame basicGame = new BasicGame();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        boolean continueRun = true;
        while(run) {
            System.out.println("가위, 바위, 보 중 하나를 입력하세요: ");
            String input = sc.nextLine();
            
            if (!basicGame.rpsModel.contains(input)) {
                System.out.println("잘못된 입력입니다. '가위', '바위', '보'만 사용할 수 있습니다.");
                continue;
            }
            
            System.out.println("결과: " + basicGame.game(input));
            
            while(continueRun) {
                System.out.println("계속 진행하시겠습니까?(y/n)");
                String continueResult = sc.nextLine();
                if (continueResult.equals("y")) {
                    run = true;
                    break;
                } else if (continueResult.equals("n")) {
                    System.out.println("게임이 종료되었습니다.");
                    run = false;
                    sc.close();
                    break;
                } else {
                    System.out.println("잘못된 입력입니다. 'y' 또는 'n'만 입력하세요.");
                }
            }
        }
        
    }
}
