package com.snrtqi.buy.service.impl;

import com.snrtqi.buy.exception.AddBookException;
import com.snrtqi.buy.exception.FindBookException;
import com.snrtqi.buy.mapper.BookMapper;
import com.snrtqi.buy.mapper.BookMapperCustom;
import com.snrtqi.buy.pojo.Book;
import com.snrtqi.buy.pojo.BookCustom;
import com.snrtqi.buy.pojo.BookQueryVo;
import com.snrtqi.buy.service.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Gumo on 2016/11/19.
 */
public class BookServiceImpl implements BookService {

    //  Book接口
    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookMapperCustom bookMapperCustom;

    /**
     * 查询图书列表
     *
     * @return
     * @throws Exception
     * @aram bookQueryVo
     */
    public List<BookCustom> findBookList(BookQueryVo bookQueryVo) throws Exception {
        List<BookCustom> bookList = bookMapperCustom.findBookList(bookQueryVo);
        if (bookList.size() == 0) throw new FindBookException("暂无图书！");
        return bookList;
    }

    /**
     * 加载图书
     *
     * @param bid
     * @return
     * @throws Exception
     */
    public BookCustom loadBook(String bid) throws Exception {
        Book book = bookMapper.selectByPrimaryKey(bid);
        if (book != null) {
            BookCustom bookCustom = new BookCustom();
            BeanUtils.copyProperties(book, bookCustom);
            return bookCustom;
        }
        return null;
    }

    /**
     * 添加图书
     *
     * @param bookQueryVo
     * @throws Exception
     */
    public void addBook(String bname, BookQueryVo bookQueryVo) throws Exception {
        BookCustom findBook = bookMapperCustom.findBookByBname(bname);
        if (findBook != null) {
            throw new AddBookException("图书名已存在");
        }
        Book book = new Book();
        BeanUtils.copyProperties(bookQueryVo.getBookCustom(), book);
        bookMapper.insert(book);
    }

    public List<BookCustom> findBookListByCid(String cid) throws Exception {
        List<BookCustom> bookList = bookMapperCustom.findBookListByCid(cid);
        if (bookList == null) throw new FindBookException("暂无图书！");
        return bookList;
    }

    public List<BookCustom> findBooksByBnameOrAuthor(String bname, String author) throws Exception {
        if (bname != null) {
            List<BookCustom> bookList = bookMapperCustom.findBooksByBname(bname);
            if (bookList.size() == 0) throw new FindBookException("暂无图书！");
            return bookList;
        } else if (author != null) {
            List<BookCustom> bookList = bookMapperCustom.findBooksByAuthor(author);
            if (bookList.size() == 0) throw new FindBookException("暂无图书！");
            return bookList;
        } else {
            throw new FindBookException("暂无图书！");
        }
    }

    public void delete(String bid) throws Exception {
        bookMapperCustom.delete(bid);
    }

    public void updateBook(BookCustom bookCustom) {
        bookMapper.updateByPrimaryKeySelective(bookCustom);
    }
}
