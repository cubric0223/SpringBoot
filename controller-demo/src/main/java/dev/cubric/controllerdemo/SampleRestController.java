package dev.cubric.controllerdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.io.InputStream;

@RestController // Controller + ResponseBody
@RequestMapping("/rest")

public class SampleRestController {
    private static final Logger logger = LoggerFactory.getLogger(SampleRestController.class);
    @GetMapping("/sample-payload")
    public SamplePayload samplepayload(){
        return new SamplePayload("cubric", 10, "Developer");
    }

    @GetMapping(value = "/sample-image", produces = MediaType.IMAGE_PNG_VALUE)

    public byte[] sampleImage() throws IOException{
        InputStream inputStream = getClass().getResourceAsStream("/static/img.png");

        return inputStream.readAllBytes();
    }
}
