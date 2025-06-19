package com.advjava.bugapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.advjava.bugapp.model.Bug;

public interface BugDao {

	void insertBug(Bug bug) throws SQLException;

	Bug selectBug(long bugId);

	List<Bug> selectAllBugs();

	boolean deleteBug(int id) throws SQLException;

	boolean updateBug(Bug bug) throws SQLException;

}