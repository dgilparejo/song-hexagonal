package com.academy.songhexagonal.infrastructure.adapter.input.rest.data.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateSongRequest {

    @NotEmpty(message = "Name may not be empty")
    private String name;

    @NotEmpty(message = "Artist may not be empty")
    private String artist;
}
