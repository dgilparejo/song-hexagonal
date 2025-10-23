package com.academy.songhexagonal.infrastructure.adapter.output.persistence.mapper;

import com.academy.songhexagonal.domain.model.Song;
import com.academy.songhexagonal.infrastructure.adapter.output.persistence.entity.SongEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SongPersistanceMapper {

    SongEntity toSongEntity(Song song);

    Song toSong(SongEntity songEntity);

    List<Song> toSongList(List<SongEntity> songs);
}
