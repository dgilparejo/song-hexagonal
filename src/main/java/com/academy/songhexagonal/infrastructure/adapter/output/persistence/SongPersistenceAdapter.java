package com.academy.songhexagonal.infrastructure.adapter.output.persistence;

import com.academy.songhexagonal.application.port.output.SongOutputPort;
import com.academy.songhexagonal.domain.model.Song;
import com.academy.songhexagonal.infrastructure.adapter.output.persistence.entity.SongEntity;
import com.academy.songhexagonal.infrastructure.adapter.output.persistence.mapper.SongPersistanceMapper;
import com.academy.songhexagonal.infrastructure.adapter.output.persistence.repository.SongRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class SongPersistenceAdapter implements SongOutputPort {

    private final SongRepository songRepository;

    private final SongPersistanceMapper songPersistanceMapper;

    @Override
    public Song saveSong(Song song) {
        SongEntity songEntity = this.songPersistanceMapper.toSongEntity(song);//Mapping to entity
        songEntity = this.songRepository.save(songEntity);//Save in DB
        song = this.songPersistanceMapper.toSong(songEntity);//Mapping to song
        return song;//Return
    }

    @Override
    public Optional<Song> getProductById(Long id) {
        final Optional<SongEntity> songEntity = this.songRepository.findById(id);//Get from DB

        if(songEntity.isEmpty()){//Check if exists
            return Optional.empty();
        }

        final Song song = this.songPersistanceMapper.toSong(songEntity.get());//Mapping to song
        return Optional.of(song);//Return
    }

    @Override
    public List<Song> getAllSong() {
        final List<SongEntity> songEntities = this.songRepository.findAll();//Get all from DB
        final List<Song> songs = this.songPersistanceMapper.toSongList(songEntities);//Mapping to song list
        return songs;//Return
    }
}
