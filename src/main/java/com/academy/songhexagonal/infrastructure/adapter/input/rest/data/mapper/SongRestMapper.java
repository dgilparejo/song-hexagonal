package com.academy.songhexagonal.infrastructure.adapter.input.rest.data.mapper;

import com.academy.songhexagonal.domain.model.Song;
import com.academy.songhexagonal.infrastructure.adapter.input.rest.data.request.CreateSongRequest;
import com.academy.songhexagonal.infrastructure.adapter.input.rest.data.response.CreateSongResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SongRestMapper {

    Song toSong(CreateSongRequest createSongRequest);

    CreateSongResponse toCreateSongResponse(Song song);
}
