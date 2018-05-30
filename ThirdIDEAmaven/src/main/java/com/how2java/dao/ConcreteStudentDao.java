package com.how2java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;


import com.how2java.bean.Student;
import com.how2java.utils.JDBCUtils;



public class ConcreteStudentDao implements StudentDAO{  //分离interface和impl

    //增加一个学生
    public int addStudent(Student student)
    {
        Connection con = null ;
        PreparedStatement ps = null ;
        int i = 0 ;
        try
        {
            con = JDBCUtils.getConnection();
            String sql = "insert into student(qqnumber,sNAME,time,school,link,hope,leader) values(?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);

            //ps.setInt(1, student.getId());
            ps.setString(1, student.getQqnumber());
            ps.setString(2, student.getsNAME());
            ps.setString(3, student.getTime());
            ps.setString(4, student.getSchool());
            ps.setString(5, student.getLink());
            ps.setString(6,student.getHope());
            ps.setString(7, student.getLeader());

            i = ps.executeUpdate() ;

        }
        catch(SQLException e)
        {
            throw new DAOException(e.getMessage(),e);
        }
        finally
        {
            JDBCUtils.free(null, ps, con);
        }
        return i;
    }

    //删除一个学生  ，根据名字删除一个学生
    public int deleteStudent(String name)
    {
        Connection con = null ;
        PreparedStatement ps = null ;
        int i = 0 ;
        try
        {
            con = JDBCUtils.getConnection();
            String sql = "delete from student where sNAME =?";
            ps = con.prepareStatement(sql);
            ps.setString(1, name);

            i = ps.executeUpdate() ;

        }
        catch(SQLException e)
        {
            throw new DAOException(e.getMessage(),e);
        }
        finally
        {
            JDBCUtils.free(null, ps, con);
        }

        return i;
    }

    //修改一个学生  ,将对应名字的学生的qq号码更改了
    public int updateStudent(String name)
    {
        Connection con = null ;
        PreparedStatement ps = null ;
        int i = 0 ;
        try
        {
            con = JDBCUtils.getConnection();
            String sql = "update student set qqnumber=999  where sNAME =?";
            ps = con.prepareStatement(sql);
            ps.setString(1, name);

            i = ps.executeUpdate() ;

        }
        catch(SQLException e)
        {
            throw new DAOException(e.getMessage(),e);
        }
        finally
        {
            JDBCUtils.free(null, ps, con);
        }

        return i;
    }
    //查询一行  ，根据名字查找一个学生
    public Student findStudent(String name)
    {
        Connection con = null ;
        PreparedStatement ps = null ;
        Student stu = null ;
        ResultSet rs = null;
        try
        {
            con = JDBCUtils.getConnection();
            String sql = "select* from student where sNAME =?";
            ps = con.prepareStatement(sql);
            ps.setString(1, name);

            rs = ps.executeQuery() ;
            stu = new Student();
            while(rs.next())
            {
                stu.setId(rs.getInt(1));
                stu.setQqnumber(rs.getString(2));
                stu.setsNAME(rs.getString(3));
                stu.setTime(rs.getString(4));
                stu.setSchool(rs.getString(5));
                stu.setLink(rs.getString(6));
                stu.setHope(rs.getString(7));
                stu.setLeader(rs.getString(8));
            }

        }
        catch(SQLException e)
        {
            throw new DAOException(e.getMessage(),e);
        }
        finally
        {
            JDBCUtils.free(rs, ps, con);
        }

        return stu;
    }

    //查询所有
    public Set<Student> findAll()
    {
        Connection con = null ;
        PreparedStatement ps = null ;
        Student stu = null ;
        ResultSet rs = null;
        Set<Student> set = null ;
        try
        {
            con = JDBCUtils.getConnection();
            String sql = "select* from student";
            ps = con.prepareStatement(sql);

            set = new HashSet<Student>() ;
            rs = ps.executeQuery() ;

            while(rs.next())
            {
                stu = new Student();

                stu.setId(rs.getInt(1));
                stu.setQqnumber(rs.getString(2));
                stu.setsNAME(rs.getString(3));
                stu.setTime(rs.getString(4));
                stu.setSchool(rs.getString(5));
                stu.setLink(rs.getString(6));
                stu.setHope(rs.getString(7));
                stu.setLeader(rs.getString(8));

                set.add(stu);
            }

        }
        catch(SQLException e)
        {
            throw new DAOException(e.getMessage(),e);
        }
        finally
        {
            JDBCUtils.free(rs, ps, con);
        }

        return set;
    }

}
