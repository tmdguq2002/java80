/* 주제: 파일업로드와 HTTP 요청 프로토콜 */
package step04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step04/servlet18")
public class Servlet18 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(
      HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.printf("요청 method => %s\n", request.getMethod());

    request.setCharacterEncoding("UTF-8");
    
    out.printf("name => %s\n", request.getParameter("name"));
    out.printf("email => %s\n", request.getParameter("email"));
    out.printf("tel => %s\n", request.getParameter("tel"));
    out.printf("photo => %s\n", request.getParameter("photo"));
  }
}

/*
# 파일 업로드
=> 웹 브라우저에서 파일을 업로드 하려면,"POST + 멀티파트"로 지정해야 한다.
=> 예)
   <form action="..." method="post" enctype="multipart/form-data">...</form>
=> form 태그의 enctype 속성의 기본 값은 다음과 같다.
   "application/x-www-form-urlencoded"
 
# 멀티파트로 파일 업로드하는 HTTP 요청 프로토콜 예)
POST http://localhost:8080/web02/step04/servlet18 HTTP/1.1
Host: localhost:8080
Connection: keep-alive
Content-Length: 7605
Cache-Control: max-age=0
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,...
Origin: http://localhost:8080
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.94 Safari/537.36
Content-Type: multipart/form-data; boundary=----WebKitFormBoundary6Dm2L0hx8OdbY8UJ
Referer: http://localhost:8080/web02/step04/upload.html
Accept-Encoding: gzip, deflate
Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4

------WebKitFormBoundary6Dm2L0hx8OdbY8UJ
Content-Disposition: form-data; name="name"

가각간
------WebKitFormBoundary6Dm2L0hx8OdbY8UJ
Content-Disposition: form-data; name="email"

kang@test.com
------WebKitFormBoundary6Dm2L0hx8OdbY8UJ
Content-Disposition: form-data; name="tel"

111-2222
------WebKitFormBoundary6Dm2L0hx8OdbY8UJ
Content-Disposition: form-data; name="photo"; filename="p1.jpg"
Content-Type: image/jpeg

.....
------WebKitFormBoundary6Dm2L0hx8OdbY8UJ--

 */

















