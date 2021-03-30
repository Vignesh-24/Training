package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Set;

public class UserDAOImpl implements UserDAO,Cloneable{
	private static UserDAOImpl userdaoimpl;
	private Properties prop;
	private UserDAOImpl(Properties prop) {
		this.prop=prop;
	}
	
	synchronized public static UserDAOImpl getUserDAOImpl(Properties prop) {
		
		if(userdaoimpl==null) {
			userdaoimpl=new UserDAOImpl(prop);
			return userdaoimpl;
		}
		else {
			return userdaoimpl.createClone();
		}
	}
	
	
	public UserDAOImpl createClone() {
		try {
			return (UserDAOImpl)super.clone();
		}catch(Exception e) {
			return null;
		}
	}
	
	@Override
	public UserDTO getUserDTO(int uid) {
		try {
			UserDTO userDTO=new UserDTO();
			Connection con=DBUtility.getConnection(prop);
			PreparedStatement ps=con.prepareStatement("select * from user where uid=?");
			ps.setInt(1, uid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				userDTO.setUid(rs.getInt(1));
				userDTO.setUname(rs.getString(2));
				userDTO.setUpass(rs.getString(3));
				userDTO.setFlag(rs.getInt(4));
			}
			DBUtility.closeConnection(null);
			return userDTO;
		}catch(Exception e) {
			DBUtility.closeConnection(e);
			return null;
		}
	}

	@Override
	public Set<UserDTO> getAllUserDTO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteUser(int uid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(UserDTO userDTO) {
		try {
			
			Connection con=DBUtility.getConnection(prop);
			PreparedStatement ps=con.prepareStatement("update user set uname=?,upass=?,flag=? where uid=?");
			ps.setString(1, userDTO.getUname());
			ps.setString(2, userDTO.getUpass());
			ps.setInt(3, userDTO.getFlag());
			ps.setInt(4, userDTO.getUid());
			int count=ps.executeUpdate();
			DBUtility.closeConnection(null);
			return count;
		}catch(Exception e) {
			DBUtility.closeConnection(e);
			return 0;
		}
	}

	@Override
	public int insertUser(UserDTO userDTO) {
		try {
			
			Connection con=DBUtility.getConnection(prop);
			PreparedStatement ps=con.prepareStatement("insert into user values (null,?,?,?)");
			ps.setString(1, userDTO.getUname());
			ps.setString(2, userDTO.getUpass());
			ps.setInt(3, userDTO.getFlag());
			int count=ps.executeUpdate();
			DBUtility.closeConnection(null);
			return count;
		}catch(Exception e) {
			DBUtility.closeConnection(e);
			return 0;
		}
	}


	@Override
	public UserDTO getUserByName(String uname) {
		try {
			UserDTO userDTO=new UserDTO();
			Connection con=DBUtility.getConnection(prop);
			PreparedStatement ps=con.prepareStatement("select * from user where uname=?");
			ps.setString(1, uname);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				userDTO.setUid(rs.getInt(1));
				userDTO.setUname(rs.getString(2));
				userDTO.setUpass(rs.getString(3));
				userDTO.setFlag(rs.getInt(4));
			}
			DBUtility.closeConnection(null);
			return userDTO;
		}catch(Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return null;
		}
	}
	

	
}
