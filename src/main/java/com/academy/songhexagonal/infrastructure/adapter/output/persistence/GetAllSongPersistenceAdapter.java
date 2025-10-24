package com.academy.songhexagonal.infrastructure.adapter.output.persistence;

import com.academy.songhexagonal.application.port.output.GetAllSongOutputPort;
import com.academy.songhexagonal.domain.model.Song;
import com.academy.songhexagonal.infrastructure.adapter.output.persistence.entity.SongEntity;
import com.academy.songhexagonal.infrastructure.adapter.output.persistence.mapper.SongPersistanceMapper;
import com.academy.songhexagonal.infrastructure.adapter.output.persistence.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class GetAllSongPersistenceAdapter implements GetAllSongOutputPort {

    private final SongRepository songRepository;

    private final SongPersistanceMapper songPersistanceMapper;

    @Override
    public List<Song> getAllSong() {
        final List<SongEntity> songEntities = this.songRepository.findAll();//Get all from DB
        final List<Song> songs = this.songPersistanceMapper.toSongList(songEntities);//Mapping to song list
        return songs;//Return
    }
}
