package com.academy.songhexagonal.infrastructure.adapter.input.rest.data.mapper;

import com.academy.songhexagonal.domain.model.Song;
import com.academy.songhexagonal.infrastructure.adapter.input.rest.data.request.CreateSongRequest;
import com.academy.songhexagonal.infrastructure.adapter.input.rest.data.response.CreateSongResponse;
import com.academy.songhexagonal.infrastructure.adapter.input.rest.data.response.SongQueryResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SongRestMapper {

    Song toSong(CreateSongRequest createSongRequest);

    CreateSongResponse toCreateSongResponse(Song song);

    SongQueryResponse toSongQueryResponse(Song song);

    List<SongQueryResponse> toSongQueryResponse(List<Song> songs);
}
