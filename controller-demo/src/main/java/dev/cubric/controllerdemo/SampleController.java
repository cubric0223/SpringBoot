package dev.cubric.controllerdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SampleController {
    private static final Logger logger
            = LoggerFactory.getLogger(SampleController.class);

    @RequestMapping(
            value = "hello",
            method = RequestMethod.GET
    )

    public String hello(@RequestParam( // URL에서 query내용을 가져옴
            name = "id", required = false, defaultValue = ""
    ) String id){
        logger.info("Path: Hello");
        logger.info("Query Param id: " + id);
        return "/hello.html";
    }

    @GetMapping(
            value = "hello/{id}" // 경로상 내용
    )
    public String helloPath(@PathVariable("id") String id){
        logger.info("Path Variable is : " + id);
        return "/hello.html";
    }

    @GetMapping(
            "/get-profile"
    )
    public @ResponseBody SamplePayload getProfile(){
        return new SamplePayload("cubric", 10, "Developer");
    }
}
