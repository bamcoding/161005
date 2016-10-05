package net.gondor.support;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface QueryResult extends Query {
	public Object makeObject(ResultSet rs) throws SQLException;
}
