package com.project.yucoordinator.domain.board.service;

import com.project.yucoordinator.domain.board.entity.BoardEntity;
import com.project.yucoordinator.domain.user.entity.UserEntity;
import com.project.yucoordinator.domain.user.repository.UserRepository;
import com.project.yucoordinator.domain.board.dto.CreateReq;
import com.project.yucoordinator.domain.board.dto.UpdateReq;
import com.project.yucoordinator.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    @Transactional
    public BoardEntity createBoard(UserDetails userDetails, CreateReq req) {
        UserEntity userEntity = userRepository.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("해당 멤버가 없습니다."));

        BoardEntity newBoardEntity = BoardEntity.builder()
                .title(req.getTitle())
                .content(req.getContent())
                .url(req.getUrl())
                .userEntity(userEntity)
                .build();

        return boardRepository.save(newBoardEntity);
    }

    @Transactional(readOnly = true)
    public List<BoardEntity> findAllBoards(UserDetails userDetails) {
        return boardRepository.findByUserEntityUsername(userDetails.getUsername());
    }

    @Transactional(readOnly = true)
    public Optional<BoardEntity> findBoardById(Long id) {
        return boardRepository.findById(id);
    }

    @Transactional
    public BoardEntity updateBoard(UserDetails userDetails, Long id, UpdateReq req) {
        UserEntity userEntity = userRepository.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("해당 멤버가 없습니다."));

        BoardEntity boardEntity = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        if (!boardEntity.getUserEntity().getId().equals(userEntity.getId())) {
            throw new IllegalArgumentException("사용자가 일치하지 않는다.");
        }

        boardEntity.update(req.getTitle(), req.getContent(), req.getUrl());
        return boardRepository.save(boardEntity);
    }

    @Transactional
    public void deleteBoard(Long id) {
        BoardEntity boardEntity = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        boardRepository.delete(boardEntity);
    }

}
