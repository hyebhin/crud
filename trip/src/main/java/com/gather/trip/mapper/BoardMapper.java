package com.gather.trip.mapper;

import com.gather.trip.domain.BoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    void create(BoardVO bvo);

    BoardVO getBoard(int num);

    List<BoardVO> getList();

    void delete(int num);

    void modify(BoardVO bvo);
}
