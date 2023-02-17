package com.crio.starter.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;

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
    //@JsonIgnore-id is not passed in the request body because we would be auto-generating that in the backend
    @JsonIgnore
    @Id
    private String _id;
    
    @NotNull 
    private String id;

    @NotBlank 
    @NotNull 
    @NotEmpty
    private String name;

    @NotBlank
    @NotNull 
    @NotEmpty
    private String url;
    
    @NotBlank 
    @NotNull
    @NotEmpty
    private String caption;
}