package com.academy.songhexagonal.infrastructure.adapter.input.rest;

import com.academy.songhexagonal.application.port.input.GetSongInputPort;
import com.academy.songhexagonal.domain.model.Song;
import com.academy.songhexagonal.infrastructure.adapter.input.rest.data.mapper.SongRestMapper;
import com.academy.songhexagonal.infrastructure.adapter.input.rest.data.response.SongQueryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/songs")
@RequiredArgsConstructor
public class GetSongRestAdapter {

    private final GetSongInputPort getSongInputPort;

    private final SongRestMapper songRestMapper;

    @GetMapping(value = "/{id}")
    public ResponseEntity<SongQueryResponse> getSong(@PathVariable final Long id){
        final Song song = this.getSongInputPort.getSongById(id);//Get song
        SongQueryResponse songQueryResponse = this.songRestMapper.toSongQueryResponse(song);//Mapping to response
        return ResponseEntity.ok(songQueryResponse);//Return
    }
}
