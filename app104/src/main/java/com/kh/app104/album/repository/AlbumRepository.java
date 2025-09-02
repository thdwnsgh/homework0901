package com.kh.app104.album.repository;

import com.kh.app104.album.entity.AlbumEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AlbumRepository {

    private final EntityManager em;

    public void insert(AlbumEntity entity) {
        em.persist(entity);
    }

    public List<AlbumEntity> findAlbumAll() {
        String jpql = """
                SELECT a FROM AlbumEntity a
                WHERE a.delYn = 'N'
                ORDER BY a.no DESC
                """;
        return em.createQuery(jpql, AlbumEntity.class)
                .getResultList();
    }

    public AlbumEntity findAlbumByNo(Long no) {
        return em.find(AlbumEntity.class, no);
    }
}
