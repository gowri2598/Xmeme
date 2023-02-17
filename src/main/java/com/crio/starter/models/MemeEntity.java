package com.crio.starter.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

// Java class that maps to Mongo collection.
@Data
@Document(collection = "memes")
@NoArgsConstructor
@AllArgsConstructor
public class MemeEntity {

    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    private String _id;//mongo default id
    @NotNull
    private String id;
    @NotNull
    private String name;
    @NotNull
    private String url;
    @NotNull
    private String caption;
    
}