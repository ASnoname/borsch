//package ftc.shift.sample.api;
//
//import services.BookService;
//import ftc.shift.sample.models.Book;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Collection;
//
//@RestController
//public class BooksController {
//
//    private static final String BOOKS_PATH = Resources.API_PREFIX + "books";
//
//    @Autowired
//    private BookService service;
//
//
//    @GetMapping(BOOKS_PATH + "/{id}")
//    public @ResponseBody
//    BaseResponse<Book> readBook(@PathVariable String id,final HttpServletRequest request) {
//        BaseResponse<Book> response = new BaseResponse<>();
//        Book book = service.provideBook(id);
//
//        if (null == book) {
//            response.setStatus("BOOK_NOT_EXIST");  //для статусов  можно сделать отдельные Enum-ы или вынести как строковые константы
//            response.setMessage("Книга не найдена!");
//        } else {
//            response.setData(book);
//        }
//        return response;
//    }
//
//    @GetMapping(BOOKS_PATH)
//    public @ResponseBody
//    BaseResponse<Collection<Book>> listBooks() {
//        BaseResponse<Collection<Book>> response = new BaseResponse<>();
//        Collection<Book> result = service.provideBooks();
//        response.setData(result);
//        return response;
//    }
//
//    @PostMapping(BOOKS_PATH)
//    public @ResponseBody
//    BaseResponse<Book> createBook(@RequestBody Book book) {
//        BaseResponse<Book> response = new BaseResponse<>();
//        Book result = service.createBook(book);
//        response.setData(result);
//        return response;
//    }
//
//    @DeleteMapping(BOOKS_PATH + "/{id}")
//    public @ResponseBody
//    BaseResponse deleteBook(@PathVariable String id) {
//        service.deleteBook(id);
//        return new BaseResponse(); //нет тела, только статус
//    }
//
//    @PatchMapping(BOOKS_PATH + "/{id}")
//    public @ResponseBody
//    BaseResponse<Book> updateBook(@PathVariable String id, @RequestBody Book book) {
//        BaseResponse<Book> response = new BaseResponse<>();
//        Book result = service.updateBook(book);
//        response.setData(result);
//        return response;
//    }
//}