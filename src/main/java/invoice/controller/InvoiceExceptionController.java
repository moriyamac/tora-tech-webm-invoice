package invoice.controller;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class InvoiceExceptionController extends ResponseEntityExceptionHandler {

//    // 自分で定義したMyExceptionをキャッチする
//    @ExceptionHandler(MyException.class)
//    public ResponseEntity<Object> handleMyException(MyException ex, WebRequest request) {
//        return super.handleExceptionInternal(ex, "handleMyException", null, HttpStatus.BAD_REQUEST, request);
//    }
//
//    // SpringBoot内で用意されている例外については、ResponseEntityExceptionHandlerクラスで例外ごとに
//    // 専用のメソッドが用意されているのでそれをオーバーライドする
//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        return super.handleExceptionInternal(ex, "MethodArgumentNotValidException", null, HttpStatus.INTERNAL_SERVER_ERROR, request);
//    }
//
//    // すべての例外をキャッチする
//    // どこにもキャッチされなかったらこれが呼ばれる
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
//        return super.handleExceptionInternal(ex, "handleAllException", null, HttpStatus.INTERNAL_SERVER_ERROR, request);
//    }
//
//    // すべてのハンドリングに共通する処理を挟みたい場合はオーバーライドする
//    // ex) ログを吐くなど
//    @Override
//    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
//
//        // 任意の処理
//
//        return super.handleExceptionInternal(ex, body, headers, status, request);
//    }
}
