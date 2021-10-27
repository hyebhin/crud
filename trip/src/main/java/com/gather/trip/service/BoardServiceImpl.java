package com.gather.trip.service;

import com.gather.trip.domain.BoardVO;
import com.gather.trip.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardMapper bmapper;

    @Autowired
    public BoardServiceImpl(BoardMapper bmapper) {
        this.bmapper = bmapper;
    }

    @Override
    public void insert(BoardVO bvo) {
        bmapper.create(bvo);
    }

    @Override
    public BoardVO read(int num) {
        return bmapper.getBoard(num);
    }

    @Override
    public List<BoardVO> list() {
        return bmapper.getList();
    }

    @Override
    public void remove(int num) {
        bmapper.delete(num);
    }

    @Override
    public void update(int num, BoardVO bvo) {
        bvo.setNum(num);
        bmapper.modify(bvo);
    }
}
