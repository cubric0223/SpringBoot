package dev.cubric.controllerdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("view")
public class SampleController {
    private static final Logger logger
            = LoggerFactory.getLogger(SampleController.class);

    @GetMapping("/sample-jsp")
    public String sampleJsp(Model model){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setView(); 모델을 사용하는 다양한 방법

        logger.info("in sample jsp");
        List<SamplePayload> profiles = new ArrayList<>(); // 오류가 날 수 있으니 인터페이스를 활용하자
        profiles.add(new SamplePayload("Adam", 22, "Student"));
        profiles.add(new SamplePayload("Jameson", 27, "Accountant"));
        profiles.add(new SamplePayload("George", 32, "Developer"));

        model.addAttribute("profiles", profiles);
        return "view-jsp";
    }

    @GetMapping("/sample-thyme")
    public ModelAndView sampleThyme(){
        logger.info("in sample jsp");
        ModelAndView modelAndView = new ModelAndView();
        List<SamplePayload> profiles = new ArrayList<>();
        profiles.add(new SamplePayload("Adam", 22, "Student"));
        profiles.add(new SamplePayload("Jameson", 27, "Accountant"));
        profiles.add(new SamplePayload("George", 32, "Developer"));

        modelAndView.addObject("profiles", profiles);
        modelAndView.setViewName("view-thyme");
        return modelAndView;
    }


//    @RequestMapping(
//            value = "hello",
//            method = RequestMethod.GET
//    )
//
//    public String hello(@RequestParam( // URL에서 query내용을 가져옴
//            name = "id", required = false, defaultValue = ""
//    ) String id){
//        logger.info("Path: Hello");
//        logger.info("Query Param id: " + id);
//        return "/hello.html";
//    }
//
//    @GetMapping(
//            value = "hello/{id}" // 경로상 내용
//    )
//    public String helloPath(@PathVariable("id") String id){
//        logger.info("Path Variable is : " + id);
//        return "/hello.html";
//    }
//
//    @GetMapping(
//            "/get-profile"
//    )
//    public @ResponseBody SamplePayload getProfile(){
//        return new SamplePayload("cubric", 10, "Developer");
//    }
}
