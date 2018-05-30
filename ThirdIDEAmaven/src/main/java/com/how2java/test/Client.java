package com.how2java.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.how2java.bean.Student;
import com.how2java.service.StudentService;

public class Client {
    public static void main(String[] args) {
        Student stu = new Student();//遇到个新学生
        //stu.setId(2);
        stu.setQqnumber("88888888");
        stu.setsNAME("李明浩IDEA");
        stu.setTime("2020-01-01");;
        stu.setSchool("西南大学");;
        stu.setLink("sina");
        stu.setHope("天天学习");
        stu.setLeader("百度");

        StudentService ss = new StudentService();
        ss.add(stu);//将新学生的信息存入数据库

        //对数据库中的数据进行各种操作
        // System.out.println(ss.delete("aa"));
        // System.out.println(ss.update("bb"));
        //Student stuF = ss.find("mimi");//将叫做mimi的学生的信息放入stuF中，下面再将stu类中信息显示出来
        //System.out.println(stuF.getsNAME() + " " + stuF.getSchool()
          //      + " " + stuF.getQqnumber() + " " + stuF.getHope()
            //    + " " + stuF.getLink());

		/*Set<Student> set = new HashSet<Student>();
		set = ss.findAll();//将所有学生信息都放入了set这个文件夹中，下面再一个一个显示出来
		Iterator<Student> iterator = set.iterator();
		while (iterator.hasNext()) {
			Student student = (Student) iterator.next();
			System.out.println(student.getsNAME() + " " + student.getSchool()
					+ " " + student.getQqnumber() + " " + student.getHope()
					+ " " + student.getLink());
		}*/
    }
}
