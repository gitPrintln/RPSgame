package basicGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BasicGame {

    private Map<String, Integer> rpsMap = new HashMap<>();
    
    public List<String> rpsModel = Arrays.asList("가위", "바위", "보");
    
    private void addMap() {
        rpsMap.put("가위", 3);
        rpsMap.put("바위", 2);
        rpsMap.put("보", 1);
    }
    
    // 필요한 기능 작성(랜덤 뽑기)
    public List<String> game(String rps) {
        log.info("servicegame() {}", rps);
        // game setting
        addMap();
        // 내가 뽑은 가위: 3, 바위: 2, 보: 1
        Integer me = rpsMap.get(rps);
        
        // map의 keySet을 List로 변환
        List<String> keys = new ArrayList<>(rpsMap.keySet());
        // 랜덤 숫자 뽑기(0, 1, 2) > 뽑은 숫자로 키를 뽑음
        Random random = new Random(System.nanoTime());
        int randomIndex = random.nextInt(3);  // 0, 1, 2 중 하나
        // 랜덤 숫자로 선택된 key
        String computerValue = keys.get(randomIndex);
        // 해당 key에 대한 value
        Integer computer = rpsMap.get(computerValue);
        
        // 게임 결과는? returnvalue는 짐, 이김, 비김 중 하나
        String returnvalue = computer == me ? "비김" : (me % 3 + 1) == computer ? "이김" : "짐";
    
        // 결과 출력
        if(!returnvalue.equals("비김")) {
            System.out.println("내가 뽑은 " + rps + ", 컴퓨터가 뽑은 " + computerValue + ": 내가 " + returnvalue);
        } else {
            System.out.println("내가 뽑은 " + rps + ", 컴퓨터가 뽑은 " + computerValue + ": " + returnvalue);
        }
        
        // list[0]: 컴퓨터가 뽑은 값, list[1]: 게임 결과값을 전달
        List<String> computerReturn = new ArrayList<>();
        computerReturn.add(computerValue);
        computerReturn.add(returnvalue);
        return computerReturn;
    }
}
