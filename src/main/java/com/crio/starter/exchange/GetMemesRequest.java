package com.crio.starter.exchange;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

//deserialize the incoming query params from REST API clients.
@Data
@NoArgsConstructor
public class GetMemesRequest {

    @NonNull
    private String id;
    public GetMemesRequest(String id) {
        this.id=id;
    }
}