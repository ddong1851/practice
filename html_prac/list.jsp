<%@ page language="java" contentype="text/html"; charset=UTF-8
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content_Type" content="text/html"; charset="UTF-8">
        <title>쉬운 게시판</title>
    </head>

    <body>
        <fieldset>
            <legend>게시판</legend>
            <h1>글쓰기</h1>
            <ul>
                <li>아이디:<input type="text"></li>
                <li>제목:<input type="text"></li>

                <li>내용:<textarea rows="20" cols="30"></textarea>
                    <br><input type="submit" value="글쓰기">
                    <input type="reset" value="취소">
                </li>
            </ul>
        </fieldset>
    </body>
</html>