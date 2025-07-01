package com.comarch.szkolenia.forum.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Topic {
    private int id;
    private String title;
    private String author;
    private String creationDate;
    private List<Post> posts;

}
