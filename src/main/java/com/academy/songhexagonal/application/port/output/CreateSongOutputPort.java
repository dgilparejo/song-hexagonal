package com.academy.songhexagonal.application.port.output;

import com.academy.songhexagonal.domain.model.Song;

public interface CreateSongOutputPort {
    Song saveSong(Song song);
}
