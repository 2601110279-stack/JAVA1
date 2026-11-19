package Book_Management.controller;

import Book_Management.domain.Book;
import Book_Management.repository.BookRepository;
import Book_Management.view.BookInsertPan;
import Book_Management.view.BookSearchPan;
import Book_Management.view.CenterFrame.SetFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BookController extends JFrame {
    JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
    BookRepository repository;
    ArrayList<Book> bookList;
    JComboBox<String> combo;
    BookSearchPan searchPane;
    BookInsertPan insertPan;


    public BookController() {
        searchPane = new BookSearchPan();
        combo = searchPane.getCombo();
        repository = new BookRepository();
        bookList = repository.select(searchPane.getSearchWord(), combo.getSelectedIndex());
        searchPane.setBookList(bookList);
        searchPane.initView();
        searchPane.putSearchResult();

        insertPan = new BookInsertPan();
        insertPan.setBookList(bookList);
        insertPan.initView();

        JButton btnSearch = searchPane.getBtnSearch();
        btnSearch.addActionListener(btnSearchListener);

        JButton btnInsert = insertPan.getBtnInsert();
        btnInsert.addActionListener(btnInsertListener);

        tabbedPane.add("도서 검색", searchPane);
        tabbedPane.add("도서 추가", insertPan);
        add(tabbedPane);

        SetFrame.setFrame(this, "도서관리 시스템", 700, 600);
    }

    ActionListener btnSearchListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            bookList = repository.select(searchPane.getSearchWord(), combo.getSelectedIndex());
            searchPane.setBookList(bookList);
            searchPane.putSearchResult();
        }
    };

    ActionListener btnInsertListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Book book = insertPan.getBook();
            repository.insert(book);
            ArrayList<Book> insertbookList = new ArrayList<Book>();
            insertbookList = repository.select("", 0);
            insertPan.setBookList(insertbookList);
            insertPan.putSearchResult();
        }
    };

    public static void main(String[] args) {
        new BookController();
    }
}