package com.crio.starter.repository;
import java.util.List;
import java.util.Optional;
//import com.crio.starter.dto.Meme;
import com.crio.starter.models.MemeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemeRepository extends PagingAndSortingRepository<MemeEntity,String> {
    Optional<MemeEntity> findMemesById(String memeId);//since we giving different id name

    boolean existsByNameIgnoreCaseAndUrlIgnoreCaseAndCaptionIgnoreCase(String name, String url,
            String caption);

    //@Query("select * from MemeEntity m order by id desc limit 10")
    //List<User> findFirst10ByLastname(String lastname, Sort sort);
    //List<MemeEntity> findTop10ById();

}