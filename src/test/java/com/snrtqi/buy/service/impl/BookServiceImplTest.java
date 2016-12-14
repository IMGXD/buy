package com.snrtqi.buy.service.impl;

import com.snrtqi.buy.pojo.BookCustom;
import com.snrtqi.buy.pojo.BookQueryVo;
import com.snrtqi.buy.service.BookService;
import com.snrtqi.buy.util.CommonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.math.BigDecimal;

/**
 * Created by Gumo on 2016/12/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = { "classpath*:spring/applicationContext-*.xml" } )
@TransactionConfiguration( transactionManager = "transactionManager", defaultRollback = true )
@Transactional
public class BookServiceImplTest {

    @Inject
    BookService bookService;

    @Test
    public void addBook() throws Exception {
        BookCustom book = new BookCustom();
        book.setBid(CommonUtils.uuid());
        book.setBname("生命之源");
        BigDecimal bigDecimal = new BigDecimal("200");
        book.setPrice(bigDecimal);
        book.setAuthor("屈星");
        String cid = "1";
        book.setCid(cid);
        book.setDel(false);
        BookQueryVo bookQueryVo = new BookQueryVo();
        bookQueryVo.setBookCustom(book);
        bookService.addBook(book.getBname(), bookQueryVo);
    }


    @Test
    public void findBooksByBnameOrAuthor() throws Exception {
        String bname = "s";
        bookService.findBooksByBnameOrAuthor(bname, null);
    }

    @Test
    public void delete() throws Exception {
        String bid = "1";
        bookService.delete(bid);
    }

    @Test
    public void updateBook() throws Exception {
        BookCustom book = new BookCustom();
        book.setBid(CommonUtils.uuid());
        book.setBname("生命之源");
        BigDecimal bigDecimal = new BigDecimal("200");
        book.setPrice(bigDecimal);
        book.setAuthor("屈星");
        String cid = "1";
        book.setCid(cid);
        book.setDel(false);
        bookService.updateBook(book);
    }

}