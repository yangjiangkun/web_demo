package com.kuang.service;

import com.kuang.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {

	//����һ����
	int addBook(Books books);

	//ɾ��һ����
	int deleteBookById(int id);

	//����һ����
	int updateBook(Books books);

	//��ѯһ����
	Books queryBookById(int id);

	//��ѯȫ������
	List<Books> queryAllBook();


	Books queryBookByNames(String bookName);
}
