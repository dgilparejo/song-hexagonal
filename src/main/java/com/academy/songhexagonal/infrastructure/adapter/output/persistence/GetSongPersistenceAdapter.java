package com.academy.songhexagonal.infrastructure.adapter.output.persistence;

import com.academy.songhexagonal.application.port.output.GetSongOutputPort;
import com.academy.songhexagonal.domain.model.Song;
import com.academy.songhexagonal.infrastructure.adapter.output.persistence.entity.SongEntity;
import com.academy.songhexagonal.infrastructure.adapter.output.persistence.mapper.SongPersistanceMapper;
import com.academy.songhexagonal.infrastructure.adapter.output.persistence.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class GetSongPersistenceAdapter implements GetSongOutputPort {

    private final SongRepository songRepository;

    private final SongPersistanceMapper songPersistanceMapper;

    @Override
    public Optional<Song> getSongById(Long id) {
        final Optional<SongEntity> songEntity = this.songRepository.findById(id);//Get from DB

        if(songEntity.isEmpty()){//Check if exists
            return Optional.empty();
        }

        final Song song = this.songPersistanceMapper.toSong(songEntity.get());//Mapping to song
        return Optional.of(song);//Return
    }
}
