package com.crio.starter.service;

import com.crio.starter.exchange.GetMemesResponse;
import com.crio.starter.exchange.MemesDto;
import com.crio.starter.models.MemeEntity;

public interface MemeService {
    GetMemesResponse getHundredLatestMemes();
    GetMemesResponse getMemesUsingId(String id);
    MemesDto postMeme(MemeEntity memeEntity);
}