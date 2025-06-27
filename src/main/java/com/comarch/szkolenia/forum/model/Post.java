package com.comarch.szkolenia.forum.model;

import lombok.*;

import java.security.PrivateKey;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Post {
    private int id;
    private String author;
    private String content;
    private String topic;
    private String createdAt;
}
