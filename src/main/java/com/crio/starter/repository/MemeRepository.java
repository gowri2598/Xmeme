package com.crio.starter.repository;
import java.util.List;
import java.util.Optional;
//import com.crio.starter.dto.Meme;
import com.crio.starter.models.MemeEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemeRepository extends PagingAndSortingRepository<MemeEntity,String> {

    List<MemeEntity> findBottom100ByOrderByIdAsc();

    Optional<MemeEntity> findMemesById(String memeId);//since we giving different id name

    boolean existsByNameIgnoreCaseAndUrlIgnoreCaseAndCaptionIgnoreCase(String name, String url,
            String caption);

}