<%@page import="com.bookstore.dao.ReplyDao"%>
<%@page import="com.bookstore.vo.Reply"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	int boardNo = Integer.parseInt(request.getParameter("boardno"));
	
	Reply reply = new Reply();
	reply.setWriter(writer);
	reply.setContent(content);
	reply.setBoardNo(boardNo);
	
	ReplyDao replyDao = new ReplyDao();
	replyDao.insertReply(reply);
	
	response.sendRedirect("detail.jsp?boardno=" + boardNo);
%>