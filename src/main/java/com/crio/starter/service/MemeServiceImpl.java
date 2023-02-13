package com.crio.starter.service;

import java.util.List;
import com.crio.starter.dto.Meme;
import com.crio.starter.exchange.MemesDto;
import com.crio.starter.models.MemeEntity;
import com.crio.starter.repositoryservices.MemeRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemeServiceImpl implements MemeService{

    @Autowired
    private MemeRepositoryService memeRepositoryService;
    
    @Override
    //public GetMemesResponse getHundredLatestMemes() {
    public List<Meme> getHundredLatestMemes() {
        // TODO Auto-generated method stub
        
        List<Meme> hundredLatestMemes = memeRepositoryService.findHundredLatestMemes();
        return hundredLatestMemes;
        //return new GetMemesResponse(hundredLatestMemes);
    }

    @Override
    public Meme getMemesUsingId(String id) {
        // TODO Auto-generated method stub
        Meme selectedMeme = memeRepositoryService.findMemesById(id);
        return selectedMeme;
    }

    @Override
    public MemesDto postMeme(MemeEntity memeEntity) {
        // TODO Auto-generated method stub
        String id= memeRepositoryService.storeMeme(memeEntity);
        return new MemesDto(id);
        
    }
}