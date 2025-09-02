package com.kh.app104.playlist.repository;

import com.kh.app104.playlist.entity.PlaylistEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PlaylistRepository {

    private final EntityManager em;

    public void insert(PlaylistEntity entity) {
        em.persist(entity);
    }

    public PlaylistEntity findPlaylistByNo(Long no) {
        return em.find(PlaylistEntity.class, no);
    }

    public List<PlaylistEntity> findPlaylistAll() {
        String jpql = """
                SELECT p FROM PlaylistEntity p
                WHERE p.delYn = 'N'
                ORDER BY p.no DESC
                """;
        return em.createQuery(jpql, PlaylistEntity.class).getResultList();
    }
}

