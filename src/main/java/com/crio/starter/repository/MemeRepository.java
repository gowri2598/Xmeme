package com.crio.starter.repository;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;
import com.crio.starter.dto.Meme;
//import com.crio.starter.dto.Meme;
import com.crio.starter.models.MemeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MemeRepository extends MongoRepository<MemeEntity, String> {
    Optional<MemeEntity> findMemesById(String memeId);//since we giving different id name
    //findTopByOrderByCreatedDesc();

    boolean existsByNameIgnoreCaseAndUrlIgnoreCaseAndCaptionIgnoreCase(String name, String url,
            String caption);
}