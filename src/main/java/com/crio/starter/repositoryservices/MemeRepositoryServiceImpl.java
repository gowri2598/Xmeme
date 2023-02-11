package com.crio.starter.repositoryservices;

import lombok.extern.log4j.Log4j2;
import java.util.List;
import com.crio.starter.dto.Meme;
import com.crio.starter.exception.DuplicatePostException;
import com.crio.starter.exception.IdNotFoundException;
import com.crio.starter.models.MemeEntity;
import com.crio.starter.repository.MemeRepository;
import com.crio.starter.service.SequenceGeneratorService;
// import com.mongodb.internal.inject.Provider;
import javax.inject.Provider;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class MemeRepositoryServiceImpl implements MemeRepositoryService{

    @Autowired
    private Provider<ModelMapper> modelMapperProvider;


    @Autowired
    private MemeRepository memeRepository;
    
    @Override
    public List<Meme> findHundredLatestMemes() {
        // TODO Auto-generated method stub

        List<MemeEntity> memesEntities=memeRepository.findAll();   
        // List<MemeEntity> memesEntities=memeRepository.findAllMemes();   
        //log.fatal("================ MEME SIZE=========="+memesEntities.size());                                       
        return modelMapperProvider.get().map(memesEntities, new TypeToken<List<Meme>>() {}.getType());
    }

    @Override
    public Meme findMemesById(String id) {
        // TODO Auto-generated method stub
        //camel case {entity-name}{id-name}
        MemeEntity memesEntities=memeRepository.findMemesById(id).orElse(new MemeEntity());
        //{"memes":[{"memeId":null,"name":null,"url":null,"caption":null}]}-if exception not handled
        if(memesEntities.equals(new MemeEntity())){
            //log.fatal("================ id not found==========");
             throw new IdNotFoundException("id not found");
        }     
               
        return modelMapperProvider.get().map(memesEntities,Meme.class);
    }

    @Override
    public String storeMeme(MemeEntity memeEntity){
        // TODO Auto-generated method stub
    
    
        boolean isExists = memeRepository.existsByNameIgnoreCaseAndUrlIgnoreCaseAndCaptionIgnoreCase(memeEntity.getName(), 
                           memeEntity.getUrl(),memeEntity.getCaption());

        MemeEntity meme = new MemeEntity();
        if (!isExists) {            
            meme.setId(SequenceGeneratorService.generateSequence(MemeEntity.SEQUENCE_NAME));
            meme.setName(memeEntity.getName());
            meme.setUrl(memeEntity.getUrl());
            meme.setCaption(memeEntity.getCaption());
            memeRepository.save(meme);
        } 
        else{
            throw new DuplicatePostException("This is a duplicate post,insert unique record");
        }      
        return meme.getId();
    }  
}