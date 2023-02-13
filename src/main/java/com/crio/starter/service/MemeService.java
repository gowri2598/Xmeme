package com.crio.starter.service;

import java.util.List;
import com.crio.starter.dto.Meme;
import com.crio.starter.exchange.GetMemesResponse;
import com.crio.starter.exchange.MemesDto;
import com.crio.starter.models.MemeEntity;

public interface MemeService {
    List<Meme> getHundredLatestMemes();
    Meme getMemesUsingId(String id);
    MemesDto postMeme(MemeEntity memeEntity);
}