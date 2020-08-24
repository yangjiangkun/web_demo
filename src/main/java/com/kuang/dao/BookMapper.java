package com.kuang.dao;

import com.kuang.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.awt.print.Book;
import java.util.List;

public interface BookMapper {

	//����һ����
	int addBook(Books books);

	//ɾ��һ����
	int deleteBookById(@Param("bookId")int id);

	//����һ����
	int updateBook(Books books);

	//��ѯһ����
	Books queryBookById(@Param("bookId") int id);

	//��ѯȫ������
	List<Books> queryAllBook();

	Books queryBookByName(@Param("bookName") String bookName);

}
