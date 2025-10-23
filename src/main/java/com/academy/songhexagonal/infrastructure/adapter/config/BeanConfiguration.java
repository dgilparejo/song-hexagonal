package com.academy.songhexagonal.infrastructure.adapter.config;

import com.academy.songhexagonal.application.port.input.CreateSongInputPort;
import com.academy.songhexagonal.application.port.output.SongOutputPort;
import com.academy.songhexagonal.application.usecases.CreateSongUseCase;
import com.academy.songhexagonal.infrastructure.adapter.output.persistence.SongPersistenceAdapter;
import com.academy.songhexagonal.infrastructure.adapter.output.persistence.mapper.SongPersistanceMapper;
import com.academy.songhexagonal.infrastructure.adapter.output.persistence.repository.SongRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public SongOutputPort songOutputPort(SongRepository songRepository, SongPersistanceMapper songPersistanceMapper) {
        return new SongPersistenceAdapter(songRepository, songPersistanceMapper);
    }

    @Bean
    public CreateSongInputPort createSongInputPort(SongOutputPort songOutputPort) {
        return new CreateSongUseCase(songOutputPort);
    }
}
