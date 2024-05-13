package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class userDao {
	String result="";
	
	public String signupuser(String username , String password , Connection con)
	{
		try {
			String sql = "insert into management values(?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			int row = ps.executeUpdate();
			if(row==1)
			{
				result = "inserted";
				System.out.println("Inserted");
			}
			else
			{
				result="not inserted";
				System.out.println("Not inserted");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		finally
		{
			return result;
		}
		
	}
	
	public String loginuser(String username, String password , Connection con)
	{
		try {
			String sql = "select * from management where username=? and password = ?";
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			int count=0;
			while(rs.next())
			{
				count++;
			}
			if(count==1)
			{
				result="exists";
				System.out.println("yes");
			}
			else
			{
				result="not exists";
				System.out.println("no");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		finally {
			return result;
		}
	}

}
