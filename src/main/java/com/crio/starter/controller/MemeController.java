package com.crio.starter.controller;

import lombok.extern.log4j.Log4j2;
import java.util.List;
import javax.validation.Valid;
import com.crio.starter.dto.Meme;
import com.crio.starter.exchange.GetMemesResponse;
import com.crio.starter.exchange.MemesDto;
import com.crio.starter.models.MemeEntity;
import com.crio.starter.service.MemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2

public class MemeController {
    public static final String MEME_API_ENDPOINT = "/memes";
    public static final String MEMES_API = "/id";

    @Autowired
    private MemeService memeService;

    @GetMapping(MEME_API_ENDPOINT)
    public ResponseEntity<List<Meme>> getLatestMemes() {
          
        log.info("getLatestMemes called");
        List<Meme> getMemesResponse;
  
        //CHECKSTYLE:OFF
        getMemesResponse = memeService.getHundredLatestMemes();
        log.info("getHundredLatestMemes returned {}", getMemesResponse);
        //CHECKSTYLE:ON
        System.out.print("The response  is "+getMemesResponse);
      return ResponseEntity.ok().body(getMemesResponse);
    }

    @GetMapping("/memes/{id}")
    //@ResponseBody
    public ResponseEntity<List<Meme>> getMeme(@PathVariable
         String id) {
          System.out.print("in get");
        log.info("getMemes called with {}", id);                                                                                                              
        List<Meme> getMemesResponse;
  
        //CHECKSTYLE:OFF
        getMemesResponse = memeService.getMemesUsingId(id);
        log.info("getMemes returned {}", getMemesResponse);
        //CHECKSTYLE:ON
        System.out.print("The response  is "+getMemesResponse);
      return ResponseEntity.ok().body(getMemesResponse);
    }
 
    @PostMapping("/memes")
    
    public MemesDto postMeme(@Valid @RequestBody MemeEntity memeEntity){
      log.info("postMemes called with {}", memeEntity);
      return memeService.postMeme(memeEntity);
    }
  }