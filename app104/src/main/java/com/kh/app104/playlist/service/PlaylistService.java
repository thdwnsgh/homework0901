package com.kh.app104.playlist.service;

import com.kh.app104.playlist.dto.PlaylistDto;
import com.kh.app104.playlist.entity.PlaylistEntity;
import com.kh.app104.playlist.repository.PlaylistRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PlaylistService {

    private final PlaylistRepository repository;

    public Long insert(PlaylistDto dto) {
        PlaylistEntity entity = PlaylistEntity.from(dto);
        repository.insert(entity);
        return entity.getNo();
    }

    public PlaylistDto findPlaylistByNo(Long no) {
        return PlaylistDto.from(repository.findPlaylistByNo(no));
    }

    public List<PlaylistDto> findPlaylistAll() {
        return repository.findPlaylistAll()
                .stream().map(PlaylistDto::from).toList();
    }

    public void update(PlaylistDto dto) {
        PlaylistEntity entity = repository.findPlaylistByNo(dto.getNo());
        entity.update(dto);
    }

    public void delete(Long no) {
        PlaylistEntity entity = repository.findPlaylistByNo(no);
        entity.delete();
    }
}
