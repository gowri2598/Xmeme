package com.crio.starter.repositoryservices;

import com.crio.starter.dto.Meme;
import com.crio.starter.exception.DuplicatePostException;
import com.crio.starter.exception.IdNotFoundException;
import com.crio.starter.exchange.PostMemeRequestDto;
import com.crio.starter.models.MemeEntity;
import com.crio.starter.repository.MemeRepository;
import com.crio.starter.service.SequenceGeneratorService;
// import com.mongodb.internal.inject.Provider;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Provider;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class MemeRepositoryServiceImpl implements MemeRepositoryService {

@Autowired
private Provider<ModelMapper> modelMapperProvider;

@Autowired
private MemeRepository memeRepository;

@Override
public List<Meme> findHundredLatestMemes() {
    // TODO Auto-generated method stub
    Pageable pageable = PageRequest.of(0, 100, Sort.by("_id").descending());
    List<MemeEntity> memesEntities = memeRepository.findLatest100Memes(pageable).
    orElse(new ArrayList<MemeEntity>());
        
    //List<MemeEntity> memesEntities=memeRepository.findAllMemes();   
    //log.fatal("================ MEME SIZE=========="+memesEntities.size());                                       
    return modelMapperProvider.get().map(memesEntities, new TypeToken<List<Meme>>() {}.getType());
}

@Override
public Meme findMemesById(String id) {
    // TODO Auto-generated method stub
    //camel case {entity-name}{id-name}
    MemeEntity memesEntities = memeRepository.findMemesById(id).orElse(null);//.orElseThrow(() -> new IdNotFoundException("id not found"));
    //{"memes":[{"memeId":null,"name":null,"url":null,"caption":null}]}-if exception not handled
    
    if(memesEntities == null){
        throw new IdNotFoundException("id not found");
    }
    
    return modelMapperProvider.get().map(memesEntities,Meme.class);
}

@Override
public String storeMeme(PostMemeRequestDto postEntity) {
    // TODO Auto-generated method stub

    boolean isExists = memeRepository.existsByNameIgnoreCaseAndUrlIgnoreCaseAndCaptionIgnoreCase(postEntity.getName(), 
    postEntity.getUrl(),postEntity.getCaption());

    MemeEntity meme = new MemeEntity();
    if (!isExists) {            
        meme.setId(SequenceGeneratorService.generateSequence(MemeEntity.SEQUENCE_NAME));
        meme.setName(postEntity.getName());
        meme.setUrl(postEntity.getUrl());
        meme.setCaption(postEntity.getCaption());
        memeRepository.save(meme);
    } 
    
    else {
        throw new DuplicatePostException("This is a duplicate post,insert unique record");
    }    

    return meme.getId();
}  
}