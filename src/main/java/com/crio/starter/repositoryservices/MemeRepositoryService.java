package com.crio.starter.repositoryservices;

import com.crio.starter.dto.Meme;
import com.crio.starter.exchange.PostMemeRequestDto;
import java.util.List;


public interface MemeRepositoryService {
    
    List<Meme> findHundredLatestMemes();

    Meme findMemesById(String id);

    String storeMeme(PostMemeRequestDto postEntity);
    
}
