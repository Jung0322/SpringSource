package com.company.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.company.domain.*;


@Repository // (데이터베이스에서 사용) == @Component
public class BookDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// insert
	public boolean insert(BookDTO insertDto) {
		String sql = "insert into BookTBL values(?,?,?,?)";
		int result = jdbcTemplate.update(sql, insertDto.getCode(), insertDto.getTitle(), insertDto.getWriter(),
				insertDto.getPrice());

		return result > 0 ? true : false;
	}

	// delete
	public boolean detele(String code) {

		String sql = "delete from BookTBL where code = ?";
		int result = jdbcTemplate.update(sql, code);

		return result > 0 ? true : false;
	}

	// update
	public boolean update(String code, int price) {

		String sql = "update BookTBL set price = ? where code= ?";

		int result = jdbcTemplate.update(sql, price, code);
		return result > 0 ? true : false;
	}

	// select
	public List<BookDTO> list() {
		List<BookDTO> booklist = new ArrayList<BookDTO>();

			String sql = "select * from BookTBL";
		
		return jdbcTemplate.query(sql, new BookRowMapper());
	}

	// 검색
	public List<BookDTO> search(String criteria, String keyword) {
	
			String sql = "select * from bookTBL where " + criteria + "=?";
			return jdbcTemplate.query(sql, new BookRowMapper(),keyword);
		

	}

}
