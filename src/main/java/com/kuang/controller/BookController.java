package com.kuang.controller;

import com.kuang.pojo.Books;
import com.kuang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
	//controller �� service ��
	@Autowired
	@Qualifier("BookServiceImpl")
	private BookService bookService;

	//��ѯȫ�����鼮�����ҷ��ص�һ���鼮չʾҳ��
	@RequestMapping("/allBook")
	public String list(Model model) {
		List<Books> list = bookService.queryAllBook();

		model.addAttribute("list", list);
		return "allBook";
	}

	//��ת�������鼮ҳ��
	@RequestMapping("/toAddBook")
	public String toAddPaper() {


		return "addBook";
	}

	//����鼮������
	@RequestMapping("/addBook")
	public String addBool(Books books) {
		System.out.println("addBook=>" + books);
		bookService.addBook(books);
		return "redirect:/book/allBook"; //�ض������ǵ�@RequestMapping("/allBook")����
	}

	//��ת���޸�ҳ��
	@RequestMapping("/toUpdateBook")
	public String toUpdateBook(Model model, int id) {
		Books books = bookService.queryBookById(id);
		System.out.println(books);
		model.addAttribute("book", books);
		return "updateBook";
	}

	//�޸��鼮
	@RequestMapping("/updateBook")
	public String updateBook(Model model, Books book) {
		System.out.println(book);
		bookService.updateBook(book);
		Books books = bookService.queryBookById(book.getBookID());
		model.addAttribute("books", books);
		return "redirect:/book/allBook";

	}

	//ɾ���鼮
	@RequestMapping("/del/{bookId}")
	public String deleteBook(@PathVariable("bookId") int id) {
		bookService.deleteBookById(id);
		return "redirect:/book/allBook";

	}

	//��ѯ�鼮
	@RequestMapping("/queryBook")
	public String queryBook(String queryBookName, Model model){
		Books books = bookService.queryBookByNames(queryBookName);
		System.err.println("queryBook=>"+books);
		List<Books> list = new ArrayList<Books>();
		list.add(books);

		if(books==null){
			list = bookService.queryAllBook();
			model.addAttribute("error","δ�鵽");
		}

		model.addAttribute("list",list);

		return "allBook";
	}

}
