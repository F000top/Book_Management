/*
time:2022年5-15-22:15:19
programmer:yjx
goal:book_management
 */

import java.sql.*;
import java.lang.ClassNotFoundException;

public class main {
    private static String url="jdbc:mysql://localhost:3306/图书馆书籍管理";
    private static String user="root";
    private static String password="m4a1123";

    public static void main(String[] args) {
        System.out.println("=====================================");
        System.out.println("==========图书管理系统=================");
        System.out.println("=====================================");
        System.out.println("=====copyright@yjx===================");
        System.out.println("=====================================\n");
        System.out.println("目前书籍存在有：");

        //调用查询函数,查询借阅的书籍
        select();



    }


    //查询函数，静态方法,可以直接调用
    public static void select(){
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        Connection conn=null;
        Statement stat=null;
        ResultSet rs=null;
        //获取连接
        try {
            conn=DriverManager.getConnection(url,user,password);

            String sql="SELECT *FROM book_information";

            stat=conn.createStatement();

            rs = stat.executeQuery(sql);

            while (rs.next()){
                String book_id = rs.getString("book_id");
                String book_name = rs.getString("book_name");
                String time_left = rs.getString("time_left");

                //Integer.parseInt()的作用是转换类型，把string变成Integer

                book b=new book(Integer.parseInt(book_id),Integer.parseInt(time_left),book_name);
//               备份一个正确的写法，这几个换位置了就会报错，估计是数据类型不批匹配的原因
//               book b=new book(Integer.parseInt(book_id),Integer.parseInt(time_left),book_name);
                System.out.println(b);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {

            //关闭conn
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            //关闭stat
            try {
                stat.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            //关闭rs
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

    }


        //删除的函数，参数是删除哪一本书book
        public static void delete(book b){
        //copy上面那个select函数，连接JDBC的过程是一样的
            try {
                //加载驱动
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }


            Connection conn=null;
            Statement stat=null;


            //获取连接
            try {
                conn=DriverManager.getConnection(url,user,password);
                /*
                PreparedStatement介绍
            表示预编译的SQL语句的对象。
            SQL语句已预编译并存储在PreparedStatement对象中。 然后可以使用该对象多次有效地执行此语句。
                 */
//               sql语句 DELETE FROM book_information WHERE book_id=4;
                String sql ="DELETE FROM book_information WHERE book_id=?";
                PreparedStatement ps=conn.prepareStatement(sql);
                ps.setInt(1,b.getBook_id());
                ps.executeUpdate();


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {

                //关闭conn
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                //关闭stat
                try {
                    stat.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }



            }

        }




}
