package com.academy.songhexagonal.application.port.output;

import com.academy.songhexagonal.domain.model.Song;

import java.util.Optional;

public interface GetSongOutputPort {
    Optional<Song> getSongById(Long id);
}
