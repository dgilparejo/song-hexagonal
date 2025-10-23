package com.academy.songhexagonal.application.port.input;

import com.academy.songhexagonal.domain.model.Song;

public interface CreateSongInputPort {

    Song createSong(Song song);
}
