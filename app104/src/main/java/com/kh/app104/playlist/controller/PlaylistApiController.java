package com.kh.app104.playlist.controller;

import com.kh.app104.playlist.dto.PlaylistDto;
import com.kh.app104.playlist.service.PlaylistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/playlist")
@RequiredArgsConstructor
public class PlaylistApiController {

    private final PlaylistService service;

    @PostMapping
    public Long insert(@RequestBody PlaylistDto dto) {
        return service.insert(dto);
    }

    @GetMapping("{no}")
    public PlaylistDto findPlaylistByNo(@PathVariable Long no) {
        return service.findPlaylistByNo(no);
    }

    @GetMapping
    public List<PlaylistDto> findPlaylistAll() {
        return service.findPlaylistAll();
    }

    @PutMapping("{no}")
    public void update(@PathVariable Long no, @RequestBody PlaylistDto dto) {
        dto.setNo(no);
        service.update(dto);
    }

    @DeleteMapping("{no}")
    public void delete(@PathVariable Long no) {
        service.delete(no);
    }
}

