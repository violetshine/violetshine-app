<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ page import="net.violetshine.app.service.BirthdayReminderService" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Violetshine</title>

  <%@ include file="/WEB-INF/jspf/head.jspf" %>
</head>
<body>
  <div class="app">
    <div class="main-container">
      <% if (BirthdayReminderService.INSTANCE.shouldDisplayBirthday()) { %>
        <div class="card margin-bottom">
          <p class="text">🎉 Today is 1 July (UTC) meaning that it's Violet's birthday! Wish them a happy birthday! 🎉</p>
        </div>
      <% } %>
      <main class="card">
        <h1 class="heading">Violetshine</h1>
        <p class="text">G'day! I'm Violet and this is my personal website that I'm currently building. There isn't anything interesting here quite yet as I still need to decide what I want to have here.</p>
      </main>
    </div>
    <div class="purple-gradient-background"></div>
  </div>
</body>
</html>
