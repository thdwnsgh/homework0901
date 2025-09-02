package com.kh.app104.album.service;

import com.kh.app104.album.dto.AlbumDto;
import com.kh.app104.album.entity.AlbumEntity;
import com.kh.app104.album.repository.AlbumRepository;
import com.kh.app104.playlist.entity.PlaylistEntity;
import com.kh.app104.playlist.repository.PlaylistRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AlbumService {

    private final AlbumRepository repository;
    private final PlaylistRepository playlistRepository;

    public Long insert(AlbumDto dto) {
        PlaylistEntity playlist = playlistRepository.findPlaylistByNo(dto.getPlaylistNo());
        AlbumEntity entity = AlbumEntity.from(dto, playlist);
        repository.insert(entity);
        return entity.getNo();
    }

    public List<AlbumDto> findAlbumAll() {
        List<AlbumEntity> entityList = repository.findAlbumAll();
        return entityList.stream()
                .map(AlbumDto::from)
                .toList();
    }

    public AlbumDto findAlbumByNo(Long no) {
        AlbumEntity entity = repository.findAlbumByNo(no);
        return AlbumDto.from(entity);
    }

    public void update(AlbumDto dto) {
        AlbumEntity entity = repository.findAlbumByNo(dto.getNo());
        PlaylistEntity playlist = playlistRepository.findPlaylistByNo(dto.getPlaylistNo());
        entity.update(dto, playlist);
    }

    public void delete(Long no) {
        AlbumEntity entity = repository.findAlbumByNo(no);
        entity.delete();
    }
}
