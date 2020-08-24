package com.kuang.service;

import com.kuang.dao.BookMapper;
import com.kuang.pojo.Books;

import java.util.List;

public class BookServiceImpl implements BookService {

	//service µ÷ dao²ã£¬×éºÏDao
	private BookMapper bookMapper;
	public void setBookMapper(BookMapper bookMapper){
		this.bookMapper = bookMapper;
	}

	public int addBook(Books books) {
		return bookMapper.addBook(books);
	}

	public int deleteBookById(int id) {
		return bookMapper.deleteBookById(id);
	}

	public int updateBook(Books books) {
		return bookMapper.updateBook(books);
	}

	public Books queryBookById(int id) {
		return bookMapper.queryBookById(id);
	}

	public List<Books> queryAllBook() {
		return bookMapper.queryAllBook();
	}

	public Books queryBookByNames(String bookName) {
		return bookMapper.queryBookByName(bookName);
	}
}
