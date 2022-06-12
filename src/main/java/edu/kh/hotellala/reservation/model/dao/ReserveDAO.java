package edu.kh.hotellala.reservation.model.dao;

import static edu.kh.hotellala.common.JDBCTemplate.*;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.jsp.jstl.sql.Result;

public class ReserveDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private Result rs;
	
	private Properties prop;
	
}
