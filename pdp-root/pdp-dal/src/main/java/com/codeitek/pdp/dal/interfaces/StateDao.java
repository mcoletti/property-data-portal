package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.dal.exceptions.StateDaoException;
import com.codeitek.pdp.model.State;
import com.codeitek.pdp.model.StatePk;

import java.util.List;

public interface StateDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return StatePk
	 */
	public StatePk insert(State dto);

	/** 
	 * Updates a single row in the STATE table.
	 */
	public StatePk update(StatePk pk, State dto) throws StateDaoException;

	/** 
	 * Deletes a single row in the STATE table.
	 */
	public void delete(StatePk pk) throws StateDaoException;

	/** 
	 * Returns all rows from the STATE table that match the criteria 'ID = :id'.
	 */
	public State findByPrimaryKey(int id) throws StateDaoException;

	/** 
	 * Returns all rows from the STATE table that match the criteria ''.
	 */
	public List<State> findAll() throws StateDaoException;

	/** 
	 * Returns all rows from the STATE table that match the criteria 'ID = :id'.
	 */
	public List<State> findWhereIdEquals(int id) throws StateDaoException;

	/** 
	 * Returns all rows from the STATE table that match the criteria 'STATE = :stateName'.
	 */
	public List<State> findWhereStateEquals(String state) throws StateDaoException;

	/** 
	 * Returns all rows from the STATE table that match the criteria 'FULL_NAME = :fullName'.
	 */
	public List<State> findWhereFullNameEquals(String fullName) throws StateDaoException;

	/** 
	 * Returns the rows from the STATE table that matches the specified primary-key value.
	 */
	public State findByPrimaryKey(StatePk pk) throws StateDaoException;

}
