package com.mybookcorner.mybookcornerbackend.repository;


import com.mybookcorner.mybookcornerbackend.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    // Permet de récupérer les commentaires d'un livre spécifique
    List<CommentEntity> findByGoogleBookId(String googleBookId);
}