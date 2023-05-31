package com.crio.starter.repository;

import com.crio.starter.models.MemeEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MemeRepository extends MongoRepository<MemeEntity,String> {

 @Query(value = "{}")
 Optional<List<MemeEntity>> findLatest100Memes(Pageable pageable);

Optional<MemeEntity> findMemesById(String memeId);//since we giving different id name

boolean existsByNameIgnoreCaseAndUrlIgnoreCaseAndCaptionIgnoreCase(String name, String url,
        String caption);
}