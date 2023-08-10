<<<<<<< HEAD
package dev.cubric.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class BoardController {
    @GetMapping("/")
    public String list(){
        return "list";
    }
    @GetMapping("/board")
    public String board(@RequestParam("id") int id){
        System.out.println("id : " + id);
        return "board";
    }

   @GetMapping("/writeForm")
   public String writeForm(HttpSession session, Model model){
       // 로그인한 사용자만 글을 써야한다.
       // 세션에서 로그인한 정보를 읽어들인다. 로그인을 하지 않았다면 리스트보기로 자동 이동 시킨다.
       LoginInfo loginInfo = (LoginInfo)session.getAttribute("loginInfo");
       if(loginInfo == null){ // 세션에 로그인 정보가 없으면 /loginform으로 redirect
           return "redirect:/loginform";
       }

       model.addAttribute("loginInfo", loginInfo);

       return "writeForm";
   }

   @PostMapping("/write")
   public String write(
           @RequestParam("title") String title,
           @RequestParam("content") String content,
           HttpSession session
   ){
       LoginInfo loginInfo = (LoginInfo)session.getAttribute("loginInfo");
       if(loginInfo == null){ // 세션에 로그인 정보가 없으면 /loginform으로 redirect
           return "redirect:/loginform";
       }
       // 로그인한 사용자만 글을 써야한다.
       // 세션에서 로그인한 정보를 읽어들인다. 로그인을 하지 않았다면 리스트보기로 자동 이동 시킨다.
       System.out.println("title : " + title);
       // 로그인 한 회원 정보 + 제목, 내용을 저장한다.System.out.println("content : " + content);

       boardService.addBoard(loginInfo.getUserId(), title, content);

       return "redirect:/"; // 리스트 보기로 리다이렉트한다.
   }

}
=======
package dev.cubric.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class BoardController {
    @GetMapping("/")
    public String list(){
        return "list";
    }
    @GetMapping("/board")
    public String board(@RequestParam("id") int id){
        System.out.println("id : " + id);
        return "board";
    }

//    @GetMapping("/writeForm")
//    public String writeForm(HttpSession session, Model model){
//        // 로그인한 사용자만 글을 써야한다.
//        // 세션에서 로그인한 정보를 읽어들인다. 로그인을 하지 않았다면 리스트보기로 자동 이동 시킨다.
//        LoginInfo loginInfo = (LoginInfo)session.getAttribute("loginInfo");
//        if(loginInfo == null){ // 세션에 로그인 정보가 없으면 /loginform으로 redirect
//            return "redirect:/loginform";
//        }
//
//        model.addAttribute("loginInfo", loginInfo);
//
//        return "writeForm";
//    }
//
//    @PostMapping("/write")
//    public String write(
//            @RequestParam("title") String title,
//            @RequestParam("content") String content,
//            HttpSession session
//    ){
//        LoginInfo loginInfo = (LoginInfo)session.getAttribute("loginInfo");
//        if(loginInfo == null){ // 세션에 로그인 정보가 없으면 /loginform으로 redirect
//            return "redirect:/loginform";
//        }
//        // 로그인한 사용자만 글을 써야한다.
//        // 세션에서 로그인한 정보를 읽어들인다. 로그인을 하지 않았다면 리스트보기로 자동 이동 시킨다.
//        System.out.println("title : " + title);
//        // 로그인 한 회원 정보 + 제목, 내용을 저장한다.System.out.println("content : " + content);
//
//        boardService.addBoard(loginInfo.getUserId(), title, content);
//
//        return "redirect:/"; // 리스트 보기로 리다이렉트한다.
//    }

}
>>>>>>> 2228d333951df43849bd2342a99dbca952e77062
