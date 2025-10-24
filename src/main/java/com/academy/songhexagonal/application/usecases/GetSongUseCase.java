package com.academy.songhexagonal.application.usecases;

import com.academy.songhexagonal.application.port.input.GetSongInputPort;
import com.academy.songhexagonal.application.port.output.GetSongOutputPort;
import com.academy.songhexagonal.domain.model.Song;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GetSongUseCase implements GetSongInputPort {

    private final GetSongOutputPort getSongOutPutPort;

    @Override
    public Song getSongById(Long id) {
        return this.getSongOutPutPort.getSongById(id)
                .orElseThrow(() -> new RuntimeException("Song not found with id: " + id));
    }
}
