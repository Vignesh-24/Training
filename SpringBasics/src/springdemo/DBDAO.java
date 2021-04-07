package springdemo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class DBDAO {
	
	private DataSource dataSource;
	JdbcTemplate jdbcTemplate;
	public final DataSource getDataSource() {
		return dataSource;
	}

	public final void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@SuppressWarnings("deprecation")
	public void firstTest() {
		
		jdbcTemplate=new JdbcTemplate(dataSource);
		int rows=jdbcTemplate.queryForInt("select count(*) from user");
		System.out.println("Number of rows: "+rows);
		
	}
	
	public void secondTest() {
		
		List<UserDTO> actors=jdbcTemplate.query("select * from user", new RowMapper<UserDTO>() {

			@Override
			public UserDTO mapRow(ResultSet res, int row) throws SQLException {
				UserDTO dto=new UserDTO();
				dto.setUname(res.getString(2));
				dto.setUpass(res.getString(3));
				return dto;
			}
			
		});
		
		System.out.println(actors.toString());
		
	}

}
