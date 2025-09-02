package com.kh.app104.album.controller;

import com.kh.app104.album.dto.AlbumDto;
import com.kh.app104.album.service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/album")
@RequiredArgsConstructor
public class AlbumApiController {

    private final AlbumService service;

    @PostMapping
    public Long insert(@RequestBody AlbumDto dto) {
        return service.insert(dto);
    }

    @GetMapping
    public List<AlbumDto> findAlbumAll() {
        return service.findAlbumAll();
    }

    @GetMapping("/{no}")
    public AlbumDto findAlbumByNo(@PathVariable Long no) {
        return service.findAlbumByNo(no);
    }

    @PutMapping("{no}")
    public void update(@PathVariable Long no,@RequestBody AlbumDto dto) {
        dto.setNo(no);
        service.update(dto);
    }

    @DeleteMapping("/{no}")
    public void delete(@PathVariable Long no) {
        service.delete(no);
    }
}
