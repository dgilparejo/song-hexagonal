package com.academy.songhexagonal.application.port.input;

import com.academy.songhexagonal.domain.model.Song;

public interface GetSongInputPort {

    Song getSongById(Long id);
}
