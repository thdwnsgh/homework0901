package com.kh.app104.album.entity;

import com.kh.app104.album.dto.AlbumDto;
import com.kh.app104.playlist.entity.PlaylistEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "ALBUM")
@Getter
public class AlbumEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(nullable = false)
    private String title;

    private int releaseYear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "playlist_no", nullable = false)
    private PlaylistEntity playlist;

    private String delYn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public AlbumEntity() {
        this.delYn = "N";
        this.createdAt = LocalDateTime.now();
    }

    public static AlbumEntity from(AlbumDto dto, PlaylistEntity playlist) {
        AlbumEntity entity = new AlbumEntity();
        entity.title = dto.getTitle();
        entity.releaseYear = dto.getReleaseYear();
        entity.playlist = playlist;
        return entity;
    }

    public void update(AlbumDto dto, PlaylistEntity playlist) {
        this.title = dto.getTitle();
        this.releaseYear = dto.getReleaseYear();
        this.playlist = playlist;
        this.updatedAt = LocalDateTime.now();
    }

    public void delete() {
        this.delYn = "Y";
        this.updatedAt = LocalDateTime.now();
    }
}
