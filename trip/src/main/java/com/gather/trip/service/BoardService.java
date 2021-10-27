package com.gather.trip.service;


import com.gather.trip.domain.BoardVO;

import java.util.List;

public interface BoardService {
    void insert(BoardVO bvo);

    BoardVO read(int num);

    List<BoardVO> list();

    void remove(int num);

    void update(int num, BoardVO bvo);
}
