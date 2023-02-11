package com.crio.starter.dto;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*serialization
  {
    "name": "MS Dhoni",
    "url": "https://images.pexels.com/photos/3573382/pexels-photo-3573382.jpeg",
    "caption": "Meme for my place"

  }
*/

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Meme {
    @JsonIgnore
    private String id;
    private String name;
    private String url;
    private String caption;
}