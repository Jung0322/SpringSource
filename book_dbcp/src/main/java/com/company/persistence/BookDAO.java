package com.company.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.company.domain.*;

import static com.company.persistence.JdbcUtil.*;

@Repository //(데이터베이스에서 사용) == @Component 
public class BookDAO {

	@Autowired
	private DataSource ds;
	
	
	
	//insert
	public boolean insert(BookDTO insertDto) {
		String sql = "insert into BookTBL values(?,?,?,?)";
		boolean insertFlag = false;
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, insertDto.getCode());
			pstmt.setString(2, insertDto.getTitle());
			pstmt.setString(3, insertDto.getWriter());
			pstmt.setInt(4, insertDto.getPrice());
			
			int result = pstmt.executeUpdate();
			if(result>0) {
				insertFlag=true;
//				commit(con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return insertFlag;
	}
	//delete
	public boolean detele(String code) {
		boolean deleteFlag = false;
		PreparedStatement pstmt= null;
		Connection con = null;
		try {
			con = ds.getConnection();
			String sql = "delete from BookTBL where code = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, code);
			int result = pstmt.executeUpdate();
			if(result>0) {
				deleteFlag =true;
//				commit(con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return deleteFlag;
	}
	
	//update
	public boolean update(String code, int price) {
		boolean updateFlag = false;
		PreparedStatement pstmt= null;
		Connection con = null;
		try {
			con = ds.getConnection();
			String sql = "update BookTBL set price = ? where code= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, price);
			pstmt.setString(2, code);
			int result = pstmt.executeUpdate();
			if(result>0) {
				updateFlag = true;
//				commit(con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return updateFlag;
	}
	
	//select
	public List<BookDTO> list(){
		List<BookDTO> booklist = new ArrayList<BookDTO>();
		
		PreparedStatement pstmt = null;
		ResultSet rs =  null;
		Connection con = null;
		try {
			con = ds.getConnection();
			String sql = "select * from BookTBL";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BookDTO dto = new BookDTO();
				dto.setCode(rs.getString("code"));
				dto.setPrice(rs.getInt("price"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				booklist.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return booklist;
	}
	
	//ㄴㄴ
	public List<BookDTO> search(String criteria,String keyword){
		List<BookDTO> list = new ArrayList<BookDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = ds.getConnection();
			String sql = "select * from bookTBL where "+criteria+"=?"; 
			pstmt =con.prepareStatement(sql);
			pstmt.setString(1, keyword);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BookDTO dto =  new BookDTO();
				dto.setCode(rs.getString("code"));
				dto.setPrice(rs.getInt("price"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				list.add(dto);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}
	
}
