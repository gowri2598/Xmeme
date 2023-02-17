package com.crio.starter.repositoryservices;

import java.util.List;
import com.crio.starter.dto.Meme;
import com.crio.starter.exchange.PostMemeRequestDto;
import com.crio.starter.models.MemeEntity;

public interface MemeRepositoryService {
    List<Meme> findHundredLatestMemes();
    Meme findMemesById(String id);
    String storeMeme(PostMemeRequestDto postEntity);
}
