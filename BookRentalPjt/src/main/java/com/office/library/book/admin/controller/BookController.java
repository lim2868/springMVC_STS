package com.office.library.book.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.office.library.book.admin.mo.vo.BookVo;
import com.office.library.book.admin.mo.vo.RentalBookVo;
import com.office.library.book.admin.service.BookService;
import com.office.library.book.util.UploadFileService;

@Controller
@RequestMapping("/book/admin")
public class BookController {
  
  private String nextPage = "";
  
  @Autowired
  BookService bookService;
  
  @Autowired
  UploadFileService uploadFileService;
  
  @GetMapping("/registerBookForm")
  public String registerBookForm() {
    System.out.println("[BookController] registerBookForm()");
    nextPage = "admin/book/register_book_form";
    return nextPage;
  }
  
  @PostMapping("/registerBookConfirm")
  public String registerBookConfirm(BookVo bookVo,
                    @RequestParam("file") MultipartFile file) {
    System.out.println("[BookController] registerBookConfirm()");
    
    nextPage = "admin/book/register_book_ok";
    
    String savedFileName = uploadFileService.upload(file);
    
    if(savedFileName !=null) {
      bookVo.setB_thumbnail(savedFileName);
      int result = bookService.registerBookConfirm(bookVo);
      
      if(result <=0) {
        nextPage="admin/book/register_book_ng";
      }  
    }else {
      nextPage = "admin/book/register_book_ng";
    }
    return nextPage;
  }
  
  @GetMapping("/searchBookConfirm")
  public String searchBookConfirm(BookVo bookVo, Model model) {
	  System.out.println("[UserBookController] searchBookCongfirm()");
	  
	  nextPage = "admin/book/search_book";
	  
	  List<BookVo> bookVos = bookService.searchBookConfirm(bookVo);
	  
	  model.addAttribute("bookVos", bookVos);
	  return nextPage;
  }
  
  @GetMapping("/bookDetail")
  public String bookDetail(@RequestParam("b_no") int b_no, Model model) {
	  System.out.println("[BookController] bookDetail()");
	  
	  nextPage = "admin/book/book_detail";
	  
	  BookVo bookVo = bookService.bookDetail(b_no);
	  
	  model.addAttribute("bookVo", bookVo);
	  return nextPage;
  }
  
  @GetMapping("/modifyBookForm")
  public String modifyBookForm(@RequestParam("b_no") int b_no, Model model) {
	  System.out.println("[Bookcontroller] bookDetail()");
	  
	  nextPage = "admin/book/modify_book_form";
	  
	  BookVo bookVo = bookService.modifyBookForm(b_no);
	  
	  model.addAttribute("bookVo", bookVo);
	  
	  return nextPage;
  }
  
  @PostMapping("/modifyBookConfirm")
  public String modifyBookConfirm(BookVo bookVo,
		  							@RequestParam("file") MultipartFile file) {
	  System.out.println("[BookController] modifyBookConfirm()");
	  
	  nextPage = "admin/book/modify_book_ok";
	  
	  if(!file.getOriginalFilename().equals("")) {
		  String savedFileName = uploadFileService.upload(file);
		  if(savedFileName != null) {
			  bookVo.setB_thumbnail(savedFileName);
		  }
	  }
	  int result = bookService.modifyBookConfirm(bookVo);
	  
	  if(result <= 0) {
		  nextPage = "admin/book/modify_book_ng";
	  }
	  return nextPage;
  }
  
  @GetMapping("/deleteBookConfirm")
  public String deleteBookConfirm(@RequestParam("b_no") int b_no) {
	  System.out.println("[BookController] deleteBookConfirm()");
	  
	  nextPage = "admin/book/delete_book_ok";
	  
	  int result = bookService.deleteBookConfirm(b_no);
	  
	  if(result <= 0) {
		  nextPage = "admin/book/delete_book_ng";
	  }
	  
	  return nextPage;
  }
  
  @GetMapping("/getRentalBooks")
  public String getRentalBooks(Model model) {
	  System.out.println("[BookController] getRentalBooks()");
	  
	  String nextPage = "admin/book/rental_books";
			  
	  List<RentalBookVo> rentalBookVos = bookService.getRentalBooks();
	  
	  model.addAttribute("rentalBookVos", rentalBookVos);
	  
	  return nextPage;
  }
 
  @GetMapping("/returnBookConfirm")
  public String returnBookConfirm(@RequestParam("b_no") int b_no,
		  							@RequestParam("rb_no") int rb_no) {
	  System.out.println("[BookController] returnBookConfirm()");
	  
	  String nextPage = "admin/book/return_book_ok";
	  
	  int result = bookService.returnBookConfirm(b_no, rb_no);
	  
	  if(result <= 0) {
		  nextPage = "admin/book/return_book_ng";
	  }
	  return nextPage;
  }
}