package com.academy.songhexagonal.application.port.output;

import com.academy.songhexagonal.domain.model.Song;

import java.util.List;

public interface GetAllSongOutputPort {
    List<Song> getAllSong();
}
