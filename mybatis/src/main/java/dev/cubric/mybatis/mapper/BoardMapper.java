package dev.cubric.mybatis.mapper;

import dev.cubric.mybatis.dto.BoardDto;

public interface BoardMapper {
    int createBoard(BoardDto dto);
}
