package com.yingxs.service;

import com.yingxs.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;

@Service
public class BookService {

//    @Qualifier("bookDao")
    @Autowired(required = false)
    private BookDao bookDao2;

    public void print(){
        System.out.println(bookDao2);
    }

    @Override
    public String toString() {
        return "BookService{" +
                "bookDao=" + bookDao2 +
                '}';
    }
}
