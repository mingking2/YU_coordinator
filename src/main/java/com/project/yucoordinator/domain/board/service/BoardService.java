package com.project.yucoordinator.domain.board.service;

import com.project.yucoordinator.domain.board.dto.BoardDTO;
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

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    @Transactional
    public void createBoard(UserDetails userDetails, CreateReq req) {
        UserEntity userEntity = userRepository.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("해당 멤버가 없습니다."));

        BoardEntity newBoardEntity = BoardEntity.builder()
                .title(req.getTitle())
                .content(req.getContent())
                .url(req.getUrl())
                .userEntity(userEntity)
                .build();

        boardRepository.save(newBoardEntity);
    }

    @Transactional(readOnly = true)
    public List<BoardDTO> findAllBoards(UserDetails userDetails) {
        int i = 1;
        List<BoardDTO> boardDTOList = new ArrayList<>();
        List<BoardEntity> boardEntity = boardRepository.findByUserEntityUsername(userDetails.getUsername());
        for(BoardEntity board : boardEntity) {
            BoardDTO boardDTO = BoardDTO.makeBoardDTO(board);
            boardDTO.setDisplayId(i++);
            boardDTOList.add(boardDTO);
        }
        return boardDTOList;
    }

    @Transactional(readOnly = true)
    public BoardDTO findBoardById(Long id) {
        BoardEntity boardEntity = boardRepository.findById(id).orElseThrow();
        return BoardDTO.makeBoardDTO(boardEntity);
    }

    @Transactional
    public void updateBoard(UserDetails userDetails, Long id, UpdateReq req) {
        UserEntity userEntity = userRepository.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("해당 멤버가 없습니다."));

        BoardEntity boardEntity = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        if (!boardEntity.getUserEntity().getId().equals(userEntity.getId())) {
            throw new IllegalArgumentException("사용자가 일치하지 않는다.");
        }

        boardEntity.update(req.getTitle(), req.getContent(), req.getUrl());
        boardRepository.save(boardEntity);
    }

    @Transactional
    public void deleteBoard(Long id) {
        BoardEntity boardEntity = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        boardRepository.delete(boardEntity);
    }

}
