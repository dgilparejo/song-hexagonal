package com.academy.songhexagonal.infrastructure.adapter.input.rest;

import com.academy.songhexagonal.application.port.input.GetAllSongInputPort;
import com.academy.songhexagonal.domain.model.Song;
import com.academy.songhexagonal.infrastructure.adapter.input.rest.data.mapper.SongRestMapper;
import com.academy.songhexagonal.infrastructure.adapter.input.rest.data.response.SongQueryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/songs")
@RequiredArgsConstructor
public class GetAllSongRestAdapter {

    private final GetAllSongInputPort getAllSongInputPort;

    private final SongRestMapper songRestMapper;

    @GetMapping
    public ResponseEntity<List<SongQueryResponse>> getAllSongs() {
        final List<Song> songs = this.getAllSongInputPort.getAllSongs();//Get all songs
        List<SongQueryResponse> resp = this.songRestMapper.toSongQueryResponse(songs);//Mapping to response
        return ResponseEntity.ok(resp);//Return
    }
}
