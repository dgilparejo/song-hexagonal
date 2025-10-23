package com.academy.songhexagonal.infrastructure.adapter.input.rest;

import com.academy.songhexagonal.application.port.input.CreateSongInputPort;
import com.academy.songhexagonal.application.port.input.GetAllSongInputPort;
import com.academy.songhexagonal.application.port.input.GetSongInputPort;
import com.academy.songhexagonal.domain.model.Song;
import com.academy.songhexagonal.infrastructure.adapter.input.rest.data.mapper.SongRestMapper;
import com.academy.songhexagonal.infrastructure.adapter.input.rest.data.request.CreateSongRequest;
import com.academy.songhexagonal.infrastructure.adapter.input.rest.data.response.CreateSongResponse;
import com.academy.songhexagonal.infrastructure.adapter.input.rest.data.response.SongQueryResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
@RequiredArgsConstructor
public class SongRestAdapter {

    private final CreateSongInputPort createSongInputPort;

    private final GetSongInputPort getSongInputPort;

    private final GetAllSongInputPort getAllSongInputPort;

    private final SongRestMapper songRestMapper;

    @PostMapping
    public ResponseEntity<CreateSongResponse> createSong(@RequestBody @Valid CreateSongRequest createSongRequest) {
        Song song = this.songRestMapper.toSong(createSongRequest);//Mapping to model
        song = this.createSongInputPort.createSong(song);//Create song
        CreateSongResponse createSongResponse= this.songRestMapper.toCreateSongResponse(song);//Mapping to response
        return ResponseEntity.ok(createSongResponse);//Return
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SongQueryResponse> getSong(@PathVariable final Long id){
        final Song song = this.getSongInputPort.getSongById(id);//Get song
        SongQueryResponse songQueryResponse = this.songRestMapper.toSongQueryResponse(song);//Mapping to response
        return ResponseEntity.ok(songQueryResponse);//Return
    }

    @GetMapping
    public ResponseEntity<List<SongQueryResponse>> getAllSongs() {
        final List<Song> songs = this.getAllSongInputPort.getAllSongs();//Get all songs
        List<SongQueryResponse> resp = this.songRestMapper.toSongQueryResponse(songs);//Mapping to response
        return ResponseEntity.ok(resp);//Return
    }
}
