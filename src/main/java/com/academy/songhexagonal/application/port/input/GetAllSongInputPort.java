package com.academy.songhexagonal.application.port.input;

import com.academy.songhexagonal.domain.model.Song;

import java.util.List;

public interface GetAllSongInputPort {

    List<Song> getAllSongs();
}
