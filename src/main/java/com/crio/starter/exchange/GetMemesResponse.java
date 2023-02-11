package com.crio.starter.exchange;

import com.crio.starter.dto.Meme;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
public class GetMemesResponse {
    List<Meme> memes;//given in slides
    public GetMemesResponse(List<Meme> latestMemes) {
        memes=latestMemes;
    }
}