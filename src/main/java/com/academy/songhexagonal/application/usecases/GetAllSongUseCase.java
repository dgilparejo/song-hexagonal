package com.academy.songhexagonal.application.usecases;

import com.academy.songhexagonal.application.port.input.GetAllSongInputPort;
import com.academy.songhexagonal.application.port.output.GetAllSongOutputPort;
import com.academy.songhexagonal.domain.model.Song;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class GetAllSongUseCase implements GetAllSongInputPort {

    private final GetAllSongOutputPort getAllSongOutputPort;

    @Override
    public List<Song> getAllSongs() {
        return this.getAllSongOutputPort.getAllSong();
    }
}
