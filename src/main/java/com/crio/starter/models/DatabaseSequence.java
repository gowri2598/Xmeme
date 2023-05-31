package com.crio.starter.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "db_collection")
public class DatabaseSequence {

 @Id
 private String id;

 private int seqNo = 1;

 public int getSeq() {
    return seqNo;
 }

}