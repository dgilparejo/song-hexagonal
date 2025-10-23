package com.academy.songhexagonal.application.port.output;

import com.academy.songhexagonal.domain.model.Song;

import java.util.List;
import java.util.Optional;

public interface SongOutputPort {

    Song saveSong(Song song);

    Optional<Song> getProductById(Long id);

    List<Song> getAllSong();
}
