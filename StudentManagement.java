//package src;
import java.sql.*;
import java.util.*;
public class StudentManagement {
static final String URL="jdbc:mysql://localhost:3306/StudentManagement";
static final String USER="root";
static final String PASSWORD="@14122006siri";
static Scanner sc=new Scanner(System.in);
public static void main(String [] args){
while(true){
System.out.println("\n====STUDENT MANAGEMENT SYSTEM====");
System.out.println("1.Add Students");
System.out.println("2. View All Students"); 
System.out.println("3. Search Students"); 
System.out.println("4.update Students"); 
System.out.println("5.Delete Students");
System.out.println("6.Exit Students");
System.out.println("Enter your choice");
int choice=sc.nextInt();
switch(choice){
case 1:
addStudent();
break;
case 2:
viewStudent();
break;
case 3:
searchStudent();
break;
case 4:
updateStudent();
break;
case 5:
deleteStudent();
break;
case 6:
System.out.println("Thanku You!");
System.exit(0);
default:
System.out.println("Inavalid choice!");
}
 }
   }
static void addStudent(){
System.out.println("Enter Student Id:");
int id=sc.nextInt();
sc.nextLine();
System.out.println("Enter name:");
String name=sc.nextLine();
System.out.println("Enter Age:");
int age=sc.nextInt();
sc.nextLine();
System.out.println("Enter Course:");
String course=sc.nextLine();
System.out.println("Enter Email:");
String email=sc.nextLine();
String sql="INSERT INTO student VALUES(?,?,?,?,?)";
try(Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
PreparedStatement ps=con.prepareStatement(sql)){
ps.setInt(1,id);
ps.setString(2,name);
ps.setInt(3,age);
ps.setString(4,course);
ps.setString(5,email);
int rows=ps.executeUpdate();
if(rows>0)
 {
     System.out.println("Student added successfully!");  
    }
  }
catch(SQLException e){
System.out.println("error:"+e.getMessage()); 
  }
}
static void viewStudent(){
String sql="SELECT * FROM student";
try(Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
Statement st=con.createStatement();
ResultSet rs=st.executeQuery(sql)){
System.out.println("\nID\tName\tAge\tCourse\tEmail");
System.out.println("___________");
while(rs.next()){
System.out.println(
rs.getInt(1)+"/t"+
rs.getString(2)+"/t"+
rs.getInt(3)+"/t"+
rs.getString(4)+"/t"+
rs.getString(5));
 } 
}
catch(SQLException e){
System.out.println("Error:"+e.getMessage());}}
static void searchStudent(){
System.out.println("Enter Student ID:");
int id=sc.nextInt();
String sql="SELECT * FROM student WHERE id=?";
try(Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
PreparedStatement ps=con.prepareStatement(sql)){
ps.setInt(1,id);
ResultSet rs=ps.executeQuery();
if(rs.next()){
System.out.println("ID:"+rs.getInt(1));
System.out.println("Name:"+rs.getString(2));
System.out.println("Age:"+rs.getInt(3));
System.out.println("Course:"+rs.getString(4));
System.out.println(" Email:"+rs.getString(5));
}
else{
System.out.println("Student not Found!"); 
  }
}
catch(SQLException e){
System.out.println("Error:"+e.getMessage());
  }
}
static void updateStudent(){
System.out.println("enter Student ID to update:");
int id=sc.nextInt();
System.out.println("Enter new Name:");
String name=sc.nextLine();
System.out.println("Enter new Age:");
int age=sc.nextInt();
sc.nextLine();
System.out.println("Enter new Course:");
String course=sc.nextLine();
System.out.println("Enter new Email:");
String email=sc.nextLine();
String SQL="UPDATE student set name=?,age=?,course=?,email=?,where id=?";
try(Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
PreparedStatement ps=con.prepareStatement(SQL)){
ps.setString(1,name); 
ps.setInt(2,age);
ps.setString(3,course);
ps.setString(4,email);
ps.setInt(5,id); 
int rows=ps.executeUpdate();
if(rows>0){
 System.out.println("student update successfully");
 }     
 else
{
     System.out.println("student ID not found!");
   }
}
catch(SQLException e){
System.out.println("Error:"+e.getMessage());  
    }
 }
static void deleteStudent(){
System.out.println("Enter student ID to delete");
 int id=sc.nextInt();
String sql="DELETE FROM student where id=?";
try(Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
PreparedStatement ps=con.prepareStatement(sql)){
ps.setInt(1,id);
 int rows=ps.executeUpdate();
   if(rows>0){
          System.out.println("Student deleted successfully");
   }else{
        System.out.println("Student ID not found!");
      }
   }
    catch(SQLException e){
     System.out.println("ERROR:"+e.getMessage());
            }
      }
   }                              