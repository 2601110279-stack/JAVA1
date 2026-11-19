package Book_Management.repository;

import Book_Management.domain.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookRepository {
    ArrayList<Book> bookList;

    public ArrayList<Book> select(String searchWord, int selectedIndex) {
        bookList = new ArrayList<Book>();
        Connection con = JDBCConnector.getConnection();
        String[] columnName = {"name", "publish_name", "author"};
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select ISBN, name, author, price, inventory, category_name, publish_name from book b, category c, publish p " +
                "where b.category_id = c.category_id and b.publish_id = p.publish_id " +
                "and " + columnName[selectedIndex] + " like ? order by ISBN";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "%" + searchWord + "%");

            rs = pstmt.executeQuery(); // 2. 중복 실행 제거 후 바로 ResultSet에 담기

            Book book = null;
            while (rs.next()) {
                book = new Book();
                book.setIsbn(rs.getString("ISBN"));
                book.setName(rs.getString("name"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getInt("price"));
                book.setInventory(rs.getInt("inventory"));
                book.setCategory_name(rs.getString("category_name"));
                book.setPublish_name(rs.getString("publish_name"));
                bookList.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null) rs.close();       // 안전한 자원 반납
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return bookList;
    }
    public void insert(Book book) {
        Connection con = JDBCConnector.getConnection();
        PreparedStatement pstmt = null;
        String sql =  "insert into book values (?, ?, ?, ?, ?, ?, ?)";
//        출판사명을 id 정수값으로 변경
        int publish_id = 0;
        switch (book.getPublish_name()) {
            case "한빛아카데미":
                publish_id = 1;
                break;
            case "생능출판사":
                publish_id = 2;
                break;
            case "민음사":
                publish_id = 3;
                break;
            case "해냄출판사":
                publish_id = 4;
                break;
        }
//        카테고리를 id 정수값으로 변경
        int category_id = 0;
        switch (book.getCategory_name()) {
            case "IT도서":
                category_id = 10;
                break;
            case "소설":
                category_id = 20;
                break;
            case "수필":
                category_id = 30;
                break;
            case "시":
                category_id = 40;
                break;
        }

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, book.getIsbn());
            pstmt.setString(2, book.getName());
            pstmt.setString(3, book.getAuthor());
            pstmt.setInt(4, book.getPrice());
            pstmt.setInt(5, book.getInventory());
            pstmt.setInt(6, category_id);
            pstmt.setInt(7, publish_id);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            try{
                pstmt.close();
                con.close();
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }
}