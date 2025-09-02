package com.kh.app104.playlist.entity;

import com.kh.app104.playlist.dto.PlaylistDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "PLAYLIST")
@Getter
public class PlaylistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(nullable = false)
    private String name;

    private String delYn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public PlaylistEntity() {
        this.delYn = "N";
        this.createdAt = LocalDateTime.now();
    }

    public static PlaylistEntity from(PlaylistDto dto) {
        PlaylistEntity entity = new PlaylistEntity();
        entity.name = dto.getName();
        return entity;
    }

    public void update(PlaylistDto dto) {
        this.name = dto.getName();
        this.updatedAt = LocalDateTime.now();
    }

    public void delete() {
        this.delYn = "Y";
        this.updatedAt = LocalDateTime.now();
    }
}

