package com.kh.app104.playlist.dto;

import com.kh.app104.playlist.entity.PlaylistEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class PlaylistDto {

    private Long no;
    private String name;
    private String delYn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static PlaylistDto from(PlaylistEntity entity) {
        PlaylistDto dto = new PlaylistDto();
        dto.no = entity.getNo();
        dto.name = entity.getName();
        dto.delYn = entity.getDelYn();
        dto.createdAt = entity.getCreatedAt();
        dto.updatedAt = entity.getUpdatedAt();
        return dto;
    }
}
