package com.mybookcorner.mybookcornerbackend.controller;

import com.mybookcorner.mybookcornerbackend.dto.CommentDTO;
import com.mybookcorner.mybookcornerbackend.service.CommentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/comments")
@CrossOrigin(origins = "*") // Autorise Angular à appeler le backend
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public CommentDTO createComment(@RequestBody CommentDTO dto) {
        return commentService.addComment(dto);
    }

    @GetMapping("/{googleBookId}")
    public List<CommentDTO> getComments(@PathVariable String googleBookId) {
        return commentService.getCommentsByBook(googleBookId);
    }
}