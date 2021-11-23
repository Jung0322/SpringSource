package com.company.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.company.domain.BoardDTO;

@Repository
public class BoardDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// ����
	public boolean insert(BoardDTO dto) {

		String sql = "insert into spring_board(bno,title,content,writer) values(seq_board.nextval,?,?,?)";
		// update(sql,object...args) : ������ ������ �������� ���� �ܿ�
		int result = jdbcTemplate.update(sql, dto.getTitle(), dto.getContent(), dto.getWriter());

		return result > 0 ? true : false;
	}

	public List<BoardDTO> list() {
		String sql = "select * from spring_board";
		return jdbcTemplate.query(sql, new BoardRowMapper());
	}

	// Ư�� �Խù� ��������
	public BoardDTO getRow(int bno) {
		String sql = " select * from spring_board where bno = ?";
		return jdbcTemplate.queryForObject(sql, new BoardRowMapper(), bno);
	}

	// �Խù� ������Ʈ
	public boolean update(BoardDTO dto) {
		String sql = "update spring_board set title=?,content=?,updatedate=sysdate where bno=?";
		int result = jdbcTemplate.update(sql, dto.getTitle(), dto.getContent(), dto.getBno());
		return result > 0 ? true : false;
	}

	// �Խù� ����
	public boolean delete(int bno) {
		String sql = "delete from spring_board where bno=?";
		int result = jdbcTemplate.update(sql, bno);
		return result > 0 ? true : false;
	}
}
