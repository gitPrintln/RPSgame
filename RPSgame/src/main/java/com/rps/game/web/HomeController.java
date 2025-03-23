package com.rps.game.web;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rps.game.service.GameService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final GameService gameService;
    
    @GetMapping("/")
    public String home() {
        log.info("home()");
        return "home";
    }
    
    @GetMapping("/game")
    public String game() {
        log.info("game()");
        return "game";
    }
    
    /**
     * "가위", "바위", "보" 중에서 내가 뽑은 string을 service 게임에 넣어 승패 결과를 알려준다.
     * @param str 내가 뽑은 것
     * @return
     */
    @PostMapping("/myPick")
    @ResponseBody
    public ResponseEntity<List<String>> gameResult(@RequestBody String str) {
        log.info("gameResult(), str={}", str);
        List<String> temp = gameService.game(str);
        return ResponseEntity.ok().body(temp);
    }
}
