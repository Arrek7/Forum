package com.comarch.szkolenia.forum.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Post {
    private int id;
    private int topicId;
    private String author;
    private String content;
    private String createdAt;
}
