package com.academy.songhexagonal.domain.model;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Song {

    private Long id;

    private String name;

    private String artist;
}
