package com.academy.songhexagonal.application.usecases;

import com.academy.songhexagonal.application.port.input.CreateSongInputPort;
import com.academy.songhexagonal.application.port.output.SongOutputPort;
import com.academy.songhexagonal.domain.model.Song;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
public class CreateSongUseCase implements CreateSongInputPort {

    private final SongOutputPort songOutputPort;

    @Override
    public Song createSong(Song song) {
        song = this.songOutputPort.saveSong(song);//Save in DB
        return song;
    }
}
