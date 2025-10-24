package com.academy.songhexagonal.infrastructure.adapter.input.rest;

import com.academy.songhexagonal.application.port.input.CreateSongInputPort;
import com.academy.songhexagonal.domain.model.Song;
import com.academy.songhexagonal.infrastructure.adapter.input.rest.data.mapper.SongRestMapper;
import com.academy.songhexagonal.infrastructure.adapter.input.rest.data.request.CreateSongRequest;
import com.academy.songhexagonal.infrastructure.adapter.input.rest.data.response.CreateSongResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/songs")
@RequiredArgsConstructor
public class CreateSongRestAdapter {

    private final CreateSongInputPort createSongInputPort;

    private final SongRestMapper songRestMapper;

    @PostMapping
    public ResponseEntity<CreateSongResponse> createSong(@RequestBody @Valid CreateSongRequest createSongRequest) {
        Song song = this.songRestMapper.toSong(createSongRequest);//Mapping to model
        song = this.createSongInputPort.createSong(song);//Create song
        CreateSongResponse createSongResponse= this.songRestMapper.toCreateSongResponse(song);//Mapping to response
        return ResponseEntity.created(URI.create("/songs/" + song.getId())).body(createSongResponse);
    }
}
