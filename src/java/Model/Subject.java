/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Dal.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

/**
 *
 * @author minh
 */
public class Subject {

    String name, semester, classes, courseID, courseName;
    int slot, day;

    public Subject() {
        connect();
    }
    
    public Subject(String name, int day, int slot) {
        this.name = name;
        this.day = day;
        this.slot = slot;
        connect();
    }

    public Subject(String name, int day, String semester, String classes, String courseID, int slot) {
        this.name = name;
        this.day = day;
        this.semester = semester;
        this.classes = classes;
        this.courseID = courseID;
        this.slot = slot;
        connect();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    

    //Khai bao cac thanh phan xu ly database
    Connection cnn; //ket noi
    Statement stm; //Thuc thi cac cau lenh sql
    ResultSet rs; //Luu tru va xu ly du lieu
    PreparedStatement pstm;

    private void connect() {
        try {
            cnn = (new DBContext()).connection;
            if (cnn != null) {
                System.out.println("Connect success");
            } else {
                System.out.println("Connect fail!");
            }
        } catch (Exception e) {
        }
    }

    public void setSubject(String name) {
        try {
            String strSelect = "select * from Subject where Name= '" + name + "' ";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {
                this.setName(name);
                this.setDay(rs.getInt(2) - 1);
                this.setSlot(rs.getInt(3) - 1);
                this.setCourseID(rs.getString(4));
                this.setSemester(rs.getString(5));
                this.setClasses(rs.getString(6));
            }
        } catch (Exception e) {
            System.out.println("GetListStudent" + e.getMessage());
        }
    }

    public void setSubject(int day, int slot) {
        try {
            String courseID="1", semester="1";
            String strSelect = "select * from Subject where slot='" + slot + "' and  day='" + day + "'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {
                this.setName(rs.getString(1));
                this.setDay(day);
                this.setSlot(slot);
                courseID =rs.getString(4);
                semester = rs.getString(5);
                this.setSemester(rs.getString(5));
                this.setClasses(rs.getString(6));
            }
            strSelect = "select distinct Name from Course where courseID='" + courseID + "' and semester='" +semester+ "'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);
             while (rs.next()) {
                 this.setCourseName(rs.getString(1));
             }
        } catch (Exception e) {
            System.out.println("GetListStudent" + e.getMessage());
        }
    }

}
