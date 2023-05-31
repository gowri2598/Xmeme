package com.crio.starter.service;

import com.crio.starter.dto.Meme;
import com.crio.starter.exchange.MemesDto;
import com.crio.starter.exchange.PostMemeRequestDto;
import java.util.List;

public interface MemeService {

    List<Meme> getHundredLatestMemes();

    Meme getMemesUsingId(String id);

    MemesDto postMeme(PostMemeRequestDto memeEntity);
    
}