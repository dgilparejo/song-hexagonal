package com.academy.songhexagonal.infrastructure.adapter.input.rest.data.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SongQueryResponse {

    private Long id;

    private String name;

    private String artist;
}
