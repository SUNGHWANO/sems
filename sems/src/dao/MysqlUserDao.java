package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import annotation.Component;
import vo.UserVo;


@Component
public class MysqlUserDao implements UserDao {
	DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
	  this.dataSource = dataSource;
  }
	
	@Override
	public void insert(UserVo user) throws Throwable {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = dataSource.getConnection();
			stmt = con.prepareStatement(
					"insert SE_USERS(EMAIL,"
												+ "PWD,"
												+ "NAME,"
												+ "TEL,"
												+ "FAX,"
												+ "POSTNO,"
												+ "ADDR,"
												+ "PHOT_PATH) values(?, ?, ?, ?, ?, ?, ?, ? )");
			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getName());
			stmt.setString(4, user.getTel());
			stmt.setString(5, user.getFax());
			stmt.setString(6, user.getPostNo());
			stmt.setString(7, user.getAddress());
			stmt.setString(8, user.getPhotoPath()); //처리!photoPath받지않기.
			
			
			stmt.executeUpdate();
		} catch (Throwable e) {
			throw e;
		} finally { 
			try {stmt.close();} catch (Throwable e2) {}
			try{con.close();}catch(Throwable e){}
		}
	}

	@Override
	public List<UserVo> list(int pageNo, int pageSize) throws Throwable {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			stmt = con.prepareStatement(
					"select UNO, EMAIL, NAME from SE_USERS"
							+ " order by UNO desc"
							+ " limit ?, ?");
			stmt.setInt(1, (pageNo - 1) * pageSize);
			stmt.setInt(2, pageSize);
			rs = stmt.executeQuery();
			
			ArrayList<UserVo> list = new ArrayList<UserVo>();
			while(rs.next()) {
				list.add(new UserVo()
											.setNo(rs.getInt("UNO"))
											.setEmail(rs.getString("EMAIL"))
											.setName(rs.getString("NAME")));				
				
			}
			return list;
		} catch (Throwable e) {
			throw e;
		} finally { 
			try {rs.close();} catch (Throwable e2) {}
			try {stmt.close();} catch (Throwable e2) {}
			try{con.close();}catch(Throwable e){}
		}
	}

	@Override
	public UserVo detail(int no) throws Throwable {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			stmt = con.prepareStatement(
					"select UNO, EMAIL, PWD, NAME, TEL, FAX, POSTNO, ADDR, "
					+ "PHOT_PATH from SE_USERS" + " where UNO=?");
			stmt.setInt(1, no);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				return new UserVo()
										.setNo(rs.getInt("UNO"))
										.setEmail(rs.getString("EMAIL"))
										.setPassword(rs.getString("PWD"))
										.setName(rs.getString("NAME"))
										.setTel(rs.getString("TEL"))
										.setFax(rs.getString("FAX"))
										.setPostNo(rs.getString("POSTNO"))
										.setAddress(rs.getString("ADDR"))
										.setPhotoPath(rs.getString("PHOT_PATH"));
			} else {
				throw new Exception("해당 사용자 찾을 수 없습니다.");
			}
		} catch (Throwable e) {
			throw e;
		} finally { 
			try {rs.close();} catch (Throwable e2) {}
			try {stmt.close();} catch (Throwable e2) {}
			try{con.close();}catch(Throwable e){}
		}
	}

	@Override
	public void update(UserVo user) throws Throwable {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = dataSource.getConnection();
			stmt = con.prepareStatement(
								"update SE_USERS set"
												+ " EMAIL=?"
												+ ", PWD=?"
												+ ", NAME=?"
												+ ", TEL=?"
												+ ", FAX=?"
												+ ", POSTNO=?"
												+ ", ADDR=?"
												+ ", PHOT_PATH=?"
												+ " where UNO=?");
			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getName());
			stmt.setString(4, user.getTel());
			stmt.setString(5, user.getFax());
			stmt.setString(6, user.getPostNo());
			stmt.setString(7, user.getAddress());
			stmt.setString(8, user.getPhotoPath());
			stmt.setInt(9, user.getNo());
			stmt.executeUpdate();
		} catch (Throwable e) {
			throw new DaoException(e);
		} finally { 
			try {stmt.close();} catch (Throwable e2) {}
			try{con.close();}catch(Throwable e){}
		}

	}

	@Override
	public void delete(int no) throws Throwable {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = dataSource.getConnection();
			stmt = con.prepareStatement(
					"delete from SE_USERS where UNO=?"	);
			stmt.setInt(1, no);
			stmt.executeUpdate();
		} catch (Throwable e) {
			throw new DaoException(e);
		} finally { 
			try {stmt.close();} catch (Throwable e2) {}
			try{con.close();}catch(Throwable e){}
		}
	}

	@Override
  public UserVo getUser(String email, String password) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			con = dataSource.getConnection();
			stmt = con.prepareStatement(
					"select UNO, EMAIL, PWD, NAME, TEL"
					+ " from SE_USERS" 
					+ " where EMAIL=? and PWD=?");
			stmt.setString(1, email);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				return new UserVo()
										.setNo(rs.getInt("UNO"))
										.setEmail(rs.getString("EMAIL"))
										.setPassword(rs.getString("PWD"))
										.setName(rs.getString("NAME"))
										.setTel(rs.getString("TEL"));
			} else {
				throw new Exception("아이디와 암호가 일치하는 사용자가 없습니다.");
			}
		}catch(Throwable e){
			throw new DaoException(e);
		}finally{
			try{rs.close();}catch(Throwable e){}
			try{stmt.close();}catch(Throwable e){}
			try{con.close();}catch(Throwable e){}
		}
  }
}
