/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Dal.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author minh
 */
public class User {

    String name, ID, semester, classes, gender, email, password, facility, dob;

    public User() {
        connect();
    }

    //object student
    public User(String name, String ID, String semester, String classes, String gender, String email, String password, String dob, String facility) {
        this.name = name;
        this.ID = ID;
        this.semester = semester;
        this.classes = classes;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.facility = facility;
        connect();
    }

    //object teacher
    public User(String name, String ID, String classes, String gender, String email, String password, String dob, String facility) {
        this.name = name;
        this.ID = ID;
        this.classes = classes;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.facility = facility;
        connect();
    }

    //object student/teacher/admin (used for checking user in database)
    public User(String email, String password, String facility) {
        this.email = email;
        this.password = password;
        this.facility = facility;
        connect();
    }

    //object admin
    public User(String name, String password) {
        this.name = name;
        this.password = password;
        connect();
    }

    public User(String id) {
        this.ID = id;
        connect();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
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

    public boolean checkUserExist(int mode) {
        boolean check = false;
        try {
            String strSelect = "";
            if (mode == 1) {
                strSelect = "Select * from Admin where email=? and Password=? and Facility=?";
            } else if (mode == 2) {
                strSelect = "Select * from Student where email=? and Password=? and Facility=?";
            } else {
                strSelect = "Select * from Teacher where email=? and Password=? and Facility=?";
            }

            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, email);
            pstm.setString(2, password);
            pstm.setString(3, facility);
            rs = pstm.executeQuery();

            if (rs.next()) {
                check = true;
            }
        } catch (Exception e) {
            System.out.println("User: " + e.getMessage());
        }
        return check;
    }

    public void getUser(int mode) {
        try {
            String strSelect = "";
            if (mode == 2) {
                strSelect = "Select * from Student where email=? and Password=? and Facility=?";
            }
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, email);
            pstm.setString(2, password);
            pstm.setString(3, facility);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                this.setID(id);
            }

        } catch (Exception e) {
            System.out.println("User: " + e.getMessage());
        }
    }

    public ArrayList<User> getListStudent() {
        ArrayList<User> student = new ArrayList<>();
        try {
            String strSelect = "select * from Student";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String password = rs.getString(3);
                String email = rs.getString(4);
                String dob = "";
                if (rs.getDate(5) != null) {
                    SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
                    dob = f.format(rs.getDate(5));
                }
                String gender = rs.getString(6);
                String classes = rs.getString(7);
                String facility = rs.getString(8);
                String semester = rs.getString(9);

                student.add(new User(name, id, semester, classes, gender, email, password, dob, facility));
            }

        } catch (Exception e) {
            System.out.println("GetListStudent" + e.getMessage());
        }
        return student;
    }

    //Add to the data base based on the mode(student/teacher)
    public void addUser(int mode) {
        String strAdd = "";
        //add to the teacher table in the database
        if (mode == 1) {
            strAdd += "Insert into Teacher values(?, ?, ?, ?, ?, ?, ?, ?);";
            try {
                pstm = cnn.prepareStatement(strAdd);
                pstm.setString(1, email);
                pstm.setString(2, password);
                pstm.setString(3, facility);
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }

        } //add to the student table in the database
        else {
            strAdd += "Insert into Student values(?, ?, ?, ?, ?, ?, ?, ?, ?);";
            try {
                pstm = cnn.prepareStatement(strAdd);
                pstm.setString(1, ID);
                pstm.setString(2, name);
                pstm.setString(3, password);
                pstm.setString(4, email);
                pstm.setString(5, dob);
                pstm.setString(6, gender);
                pstm.setString(7, classes);
                pstm.setString(8, facility);
                pstm.setString(9, semester);
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            rs = pstm.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteUser(int mode, String id) {
        try {
            String strDelete;
            if (mode == 1) {
                strDelete = "delete from Student where StudentID = '" + id + "' ";
            } else {
                strDelete = "delete from Teacher where TeacherID = '" + id + "' ";
            }
            pstm = cnn.prepareStatement(strDelete);
            pstm.execute();
        } catch (Exception E) {
            System.out.println("Delete: " + E.getMessage());
        }
    }

    public String[][] setSubject() {
        String[][] subject = new String[7][4];
        String id = this.getID();
        String strSelect;
        String name;
        int slot, day;
        try {
            strSelect = "select subject.name, day, slot from Subject "
                    + "join Student on Student.Class=Subject.Class where Student.StudentID = '" + id + "' ";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {
                name = rs.getString(1);
                day = Integer.parseInt(rs.getString(2));
                slot = Integer.parseInt(rs.getString(3));
                subject[day - 1][slot - 1] = name;
            }
            //Set the un-registered value as " "
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 4; j++) {
                    if (subject[i][j] != null) {
                        continue;
                    } else {
                        subject[i][j] = "";
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subject;
    }

    //to be called upon from post method of UpdateUSer.java
    public void updateStudent(String id) {
        try {
            String strUpdate = "update Student set Name=?, Password=? , Email=?,"
                    + " dob=?, gender=?, class=?, facility=?, semester=? "
                    + "where StudentID=?";
            pstm = cnn.prepareStatement(strUpdate);
            pstm.setString(1, name);
            pstm.setString(2, password);
            pstm.setString(3, email);
            pstm.setString(4, dob);
            pstm.setString(5, gender);
            pstm.setString(6, classes);
            pstm.setString(7, facility);
            pstm.setString(8, semester);
            pstm.setString(9, id);
            pstm.execute();
            

        } catch (Exception E) {
            System.out.println("Update: " + E.getMessage());
        }
    }

    public boolean searchStudent(String id) {
        boolean check = false;
        try {
            String strSelect = "select from Student where StudentID = '" + id + "' ";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);
            if (rs.next()) {
                check = true;
            }
        } catch (Exception E) {
            System.out.println("Search: " + E.getMessage());
        }
        return check;
    }

    //Get a student info based on their id
    public void setUser(String id) {
        try {
            String strSelect = "select * from Student where StudentID= '" + id + "' ";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {
                this.setName(rs.getString(2));
                this.setPassword(rs.getString(3));
                this.setEmail(rs.getString(4));
//                this.setDob("");
//                if (rs.getDate(5) != null) {
//                    SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
//                    this.setEmail(f.format(rs.getDate(5)));
//                }
//            this.gender = rs.getString(6);
                this.setClasses(rs.getString(7));
                this.setSemester(rs.getString(9));
//            this.facility = rs.getString(9);
            }

        } catch (Exception e) {
            System.out.println("GetListStudent" + e.getMessage());
        }
    }

}
