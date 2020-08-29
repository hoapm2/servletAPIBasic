package maper;

import java.sql.ResultSet;

public interface RowMaper <T> {
		T mapRow(ResultSet resultSet );
}
