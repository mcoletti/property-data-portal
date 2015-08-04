package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.DAOQueries;
import com.codeitek.pdp.dal.DAOTableRef;
import com.codeitek.pdp.dal.SpringJdbcSupport;
import com.codeitek.pdp.dal.exceptions.DataBaseJdbcException;
import com.codeitek.pdp.dal.interfaces.AuthorityDao;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import com.codeitek.pdp.model.Authority;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class AuthorityJdbcDao extends SpringJdbcSupport implements ParameterizedRowMapper<Authority>, AuthorityDao
{
	

	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return AuthoritiesPk
	 */
	public String insert(Authority dto)
	{
		dto.setUuid(UUID.randomUUID().toString());
        getJdbcTemplate().update(DAOQueries.I_AUTHORITY,dto.getAuthority(),dto.getEnabled(),dto.getApiUrl(),dto.getApiAuthToken(),dto.isDeleteInd());
		return dto.getUuid();
	}

	/** 
	 * Updates a single row in the AUTHORITIES table.
	 */
	public void update(String pk, Authority dto) throws DataBaseJdbcException
	{
		getJdbcTemplate().update(DAOQueries.U_AUTHORITY,dto.getUuid(),dto.getAuthority(),dto.getEnabled(),dto.getApiUrl(),dto.getApiAuthToken(),pk);
	}

	/** 
	 * Deletes a single row in the AUTHORITIES table.
	 */
	public void delete(String pk) throws DataBaseJdbcException
	{
		getJdbcTemplate().update(DAOQueries.D_AUTHORITY,pk);
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws java.sql.SQLException
	 * @return Authorities
	 */
	public Authority mapRow(ResultSet rs, int row) throws SQLException
	{
		Authority dto = new Authority();
		dto.setUuid( rs.getString( 1 ) );
		dto.setAuthority(rs.getString(2));
		dto.setEnabled(rs.getBoolean(3));
		dto.setApiUrl(rs.getString(4));
		dto.setApiAuthToken(rs.getString(5));
		dto.setDeleteInd(rs.getBoolean(6));
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return DAOTableRef.AUTHORITY;
	}

	/** 
	 * Returns all rows from the AUTHORITIES table that match the criteria 'ID = :id'.
	 */
	public Authority findByPrimaryKey(String uuid) throws DataBaseJdbcException
	{
		try {
			List<Authority> list = getJdbcTemplate().query(DAOQueries.S_AUTHORITY + " WHERE UUID = ?", this,uuid);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the AUTHORITIES table that match the criteria ''.
	 */
	public List<Authority> findAll() throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.S_AUTHORITY + " ORDER BY AUTHORITY", this);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}



    /**
	 * Returns all rows from the AUTHORITIES table that match the criteria 'AUTHORITY = :authority'.
	 */
	public List<Authority> findWhereAuthorityEquals(String authority) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.S_AUTHORITY + " WHERE AUTHORITY = ? ORDER BY AUTHORITY", this,authority);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the AUTHORITIES table that match the criteria 'ENABLED = :enabled'.
	 */
	public List<Authority> findWhereEnabledEquals(boolean enabled) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.S_AUTHORITY + " WHERE ENABLED = ?", this,enabled);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

    @Override
    public List<Authority> findWhereDeleteIndEquals(boolean deleteInd) throws DataBaseJdbcException {
        try {
            return getJdbcTemplate().query(DAOQueries.S_AUTHORITY + " WHERE DELETE_IND = ?", this,deleteInd);
        }
        catch (Exception e) {
            throw new DataBaseJdbcException("Query failed", e);
        }
    }



	/** 
	 * Returns all rows from the AUTHORITIES table that match the criteria 'API__AUTH_TOKEN = :apiAuthToken'.
	 */
	public List<Authority> findWhereApiAuthTokenEquals(String apiAuthToken) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.S_AUTHORITY + " WHERE API__AUTH_TOKEN = ? ORDER BY API__AUTH_TOKEN", this,apiAuthToken);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}



}
