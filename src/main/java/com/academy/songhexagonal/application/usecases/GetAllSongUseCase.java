package com.academy.songhexagonal.application.usecases;

import com.academy.songhexagonal.application.port.input.GetAllSongInputPort;
import com.academy.songhexagonal.application.port.output.SongOutputPort;
import com.academy.songhexagonal.domain.model.Song;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class GetAllSongUseCase implements GetAllSongInputPort {

    private final SongOutputPort songOutputPort;

    @Override
    public List<Song> getAllSongs() {
        return this.songOutputPort.getAllSong();
    }
}
