package com.academy.songhexagonal.infrastructure.adapter.input.rest.data.response;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateSongResponse {

    private Long id;

    private String name;

    private String artist;
}
