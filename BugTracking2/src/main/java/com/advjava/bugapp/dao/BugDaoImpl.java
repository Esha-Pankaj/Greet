package com.advjava.bugapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.advjava.bugapp.model.Bug;
import com.advjava.bugapp.utils.JDBCUtils;


public class BugDaoImpl implements BugDao {

	private static final String INSERT_BUGS_SQL = "INSERT INTO bugs"
			+ "  (title, username, userassign, target_date,  is_done) VALUES " + " (?, ?, ?, ?, ?);";

	private static final String SELECT_BUG_BY_ID = "select id,title,username,userassign,target_date,is_done from bugs where id = ?";
	private static final String SELECT_ALL_BUGS = "select * from bugs";
	private static final String DELETE_BUG_BY_ID = "delete from bugs where id = ?;";
	private static final String UPDATE_BUG = "update bugs set title = ?, username= ?, userassign =?, target_date =?, is_done = ? where id = ?;";

	public BugDaoImpl() {
	}

	@Override
	public void insertBug(Bug bug) throws SQLException {
		System.out.println(INSERT_BUGS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BUGS_SQL)) {
			preparedStatement.setString(1, bug.getTitle());
			preparedStatement.setString(2, bug.getUsername());
			preparedStatement.setString(3, bug.getuserassign());
			preparedStatement.setDate(4, JDBCUtils.getSQLDate(bug.getTargetDate()));
			preparedStatement.setString(5, bug.getStatus());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}
	}

	@Override
	public Bug selectBug(long bugId) {
		
		Bug bug = null;
		// Step 1: Establishing a Connection
		try (Connection connection = JDBCUtils.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BUG_BY_ID);) {
			preparedStatement.setLong(1, bugId);
			System.out.println("BugId"+bugId);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				long id = rs.getLong("id");
				String title = rs.getString("title");
				String username = rs.getString("username");
				String userassign = rs.getString("userassign");
				LocalDate targetDate = rs.getDate("target_date").toLocalDate();
				String isDone = rs.getString("is_done");
				bug = new Bug(id, title, username, userassign, targetDate, isDone);
			}
		} catch (SQLException exception) {
			System.out.println("Error is here ");
			JDBCUtils.printSQLException(exception);
		}
		return bug;
	}

	@Override
	public List<Bug> selectAllBugs() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Bug> bugs = new ArrayList<>();

		// Step 1: Establishing a Connection
		try (Connection connection = JDBCUtils.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BUGS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				long id = rs.getLong("id");
				String title = rs.getString("title");
				String username = rs.getString("username");
				String userassign = rs.getString("userassign");
				LocalDate targetDate = rs.getDate("target_date").toLocalDate();
				String isDone = rs.getString("is_done");
				bugs.add(new Bug(id, title, username, userassign, targetDate, isDone));
			}
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}
		return bugs;
	}

	@Override
	public boolean deleteBug(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_BUG_BY_ID);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	@Override
	public boolean updateBug(Bug bug) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_BUG);) {
			statement.setString(1, bug.getTitle());
			statement.setString(2, bug.getUsername());
			statement.setString(3, bug.getuserassign());
			statement.setDate(4, JDBCUtils.getSQLDate(bug.getTargetDate()));
			statement.setString(5, bug.getStatus());
			statement.setLong(6, bug.getId());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
}
