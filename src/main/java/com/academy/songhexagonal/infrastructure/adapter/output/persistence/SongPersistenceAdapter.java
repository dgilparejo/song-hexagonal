package com.academy.songhexagonal.infrastructure.adapter.output.persistence;

import com.academy.songhexagonal.application.port.output.SongOutputPort;
import com.academy.songhexagonal.domain.model.Song;
import com.academy.songhexagonal.infrastructure.adapter.output.persistence.entity.SongEntity;
import com.academy.songhexagonal.infrastructure.adapter.output.persistence.mapper.SongPersistanceMapper;
import com.academy.songhexagonal.infrastructure.adapter.output.persistence.repository.SongRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SongPersistenceAdapter implements SongOutputPort {

    private final SongRepository songRepository;

    private final SongPersistanceMapper songPersistanceMapper;

    @Override
    public Song saveSong(Song song) {
        SongEntity songEntity = this.songPersistanceMapper.toSongEntity(song);//Mapping to entity
        songEntity = this.songRepository.save(songEntity);//Save in DB
        song = this.songPersistanceMapper.toSong(songEntity);//Mapping to song
        return song;
    }
}
