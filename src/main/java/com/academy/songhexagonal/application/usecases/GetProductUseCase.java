package com.academy.songhexagonal.application.usecases;

import com.academy.songhexagonal.application.port.input.GetSongInputPort;
import com.academy.songhexagonal.application.port.output.SongOutputPort;
import com.academy.songhexagonal.domain.model.Song;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetProductUseCase implements GetSongInputPort {

    private final SongOutputPort songOutputPort;

    @Override
    public Song getSongById(Long id) {
        return this.songOutputPort.getProductById(id)
                .orElseThrow(() -> new RuntimeException("Song not found with id: " + id));
    }
}
