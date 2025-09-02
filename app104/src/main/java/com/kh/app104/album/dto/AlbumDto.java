package com.kh.app104.album.dto;

import com.kh.app104.album.entity.AlbumEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class AlbumDto {

    private Long no;
    private String title;
    private int releaseYear;
    private Long playlistNo;
    private String delYn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static AlbumDto from(AlbumEntity entity) {
        AlbumDto dto = new AlbumDto();
        dto.no = entity.getNo();
        dto.title = entity.getTitle();
        dto.releaseYear = entity.getReleaseYear();
        dto.playlistNo = entity.getPlaylist().getNo();
        dto.delYn = entity.getDelYn();
        dto.createdAt = entity.getCreatedAt();
        dto.updatedAt = entity.getUpdatedAt();
        return dto;
    }
}
