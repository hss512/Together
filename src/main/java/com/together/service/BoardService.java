package com.together.service;

import com.together.domain.entity.Board;
import com.together.domain.entity.Category;
import com.together.domain.entity.Member;
import com.together.dto.request.CreateBoardRequest;
import com.together.dto.request.UpdateBoardRequest;
import com.together.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class BoardService {

    private final BoardRepository repository;

    public void createBoard(CreateBoardRequest boardRequest, Member member, Category category){
        if(boardRequest == null){
            throw new NullPointerException("board == null");
        }else{
            try{
                repository.save(boardRequest.toBoardEntity(member, category));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void updateBoard(Long boardId, UpdateBoardRequest boardRequest){
        Optional<Board> findBoard = repository.findById(boardId);

        findBoard.ifPresentOrElse(
                board -> board.updateBoard(boardRequest.getTitle(), boardRequest.getContent()),
                () -> log.error("findBoard is null"));
    }

    public void deleteBoard(Long boardId, Member member){
        if(repository.findByIdAndMemberId(boardId, member.getId()) == null){
            log.info("없는 게시물입니다");
        }else{
            try {
                Board findBoard = repository.findByIdAndMemberId(boardId, member.getId());
                repository.delete(findBoard);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
