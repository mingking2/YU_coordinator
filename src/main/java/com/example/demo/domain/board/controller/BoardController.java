package com.example.demo.domain.board.controller;

import com.example.demo.domain.board.dto.CreateReq;
import com.example.demo.domain.board.dto.UpdateReq;
import com.example.demo.domain.board.entity.BoardEntity;
import com.example.demo.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/create")
    public String createForm(@ModelAttribute("board")CreateReq req) {
        return "create";
    }

    @PostMapping("/create")
    public String createBoard(@AuthenticationPrincipal UserDetails userDetails, @ModelAttribute CreateReq req) {
        System.out.println("req = " + req);
        System.out.println(userDetails.getUsername());
        boardService.createBoard(userDetails, req);
        return "home";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        BoardEntity boardEntity = boardService.findBoardById(id).orElseThrow();
        UpdateReq req = new UpdateReq(boardEntity.getId(), boardEntity.getTitle(), boardEntity.getContent(), boardEntity.getUrl());
        model.addAttribute("board", req);
        return "update";
    }

    @PostMapping("/update/{id}")
    public String updateBoard(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails, @ModelAttribute UpdateReq req) {
        boardService.updateBoard(userDetails, id, req);
        return "redirect:/board/{id}";
    }

    @GetMapping("/list")
    public String viewBoard(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        List<BoardEntity> allBoardEntity = boardService.findAllBoards(userDetails);
        model.addAttribute("boardList", allBoardEntity);
        return "list";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model) {
        BoardEntity boardEntity = boardService.findBoardById(id).orElseThrow();
        model.addAttribute("board", boardEntity);
        return "detail";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        boardService.deleteBoard(id);
        return "redirect:/board/list";
    }



}
