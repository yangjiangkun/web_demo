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
	//controller 调 service 层
	@Autowired
	@Qualifier("BookServiceImpl")
	private BookService bookService;

	//查询全部的书籍，并且返回到一个书籍展示页面
	@RequestMapping("/allBook")
	public String list(Model model) {
		List<Books> list = bookService.queryAllBook();

		model.addAttribute("list", list);
		return "allBook";
	}

	//跳转到增加书籍页面
	@RequestMapping("/toAddBook")
	public String toAddPaper() {


		return "addBook";
	}

	//添加书籍的请求
	@RequestMapping("/addBook")
	public String addBool(Books books) {
		System.out.println("addBook=>" + books);
		bookService.addBook(books);
		return "redirect:/book/allBook"; //重定向到我们的@RequestMapping("/allBook")请求
	}

	//跳转到修改页面
	@RequestMapping("/toUpdateBook")
	public String toUpdateBook(Model model, int id) {
		Books books = bookService.queryBookById(id);
		System.out.println(books);
		model.addAttribute("book", books);
		return "updateBook";
	}

	//修改书籍
	@RequestMapping("/updateBook")
	public String updateBook(Model model, Books book) {
		System.out.println(book);
		bookService.updateBook(book);
		Books books = bookService.queryBookById(book.getBookID());
		model.addAttribute("books", books);
		return "redirect:/book/allBook";

	}

	//删除书籍
	@RequestMapping("/del/{bookId}")
	public String deleteBook(@PathVariable("bookId") int id) {
		bookService.deleteBookById(id);
		return "redirect:/book/allBook";

	}

	//查询书籍
	@RequestMapping("/queryBook")
	public String queryBook(String queryBookName, Model model){
		Books books = bookService.queryBookByNames(queryBookName);
		System.err.println("queryBook=>"+books);
		List<Books> list = new ArrayList<Books>();
		list.add(books);

		if(books==null){
			list = bookService.queryAllBook();
			model.addAttribute("error","未查到");
		}

		model.addAttribute("list",list);

		return "allBook";
	}

}
