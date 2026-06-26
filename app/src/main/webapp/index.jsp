<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ page import="net.violetshine.app.service.BirthdayReminderService" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Violetshine</title>

  <%@ include file="/WEB-INF/includes/head.jspf" %>
</head>
<body>
  <div class="relative">
    <div class="w-full flex flex-col items-center pt-4">
      <% if (BirthdayReminderService.INSTANCE.shouldDisplayBirthday()) { %>
        <div class="w-full max-w-lg p-4 bg-neutral-800 text-white z-10 rounded-2xl mb-2">
          <p class="font-['Inter'] font-normal text-xs">🎉 Today is 1 July (UTC) meaning that it's Violet's birthday! Wish them a happy birthday! 🎉</p>
        </div>
      <% } %>
      <main class="w-full max-w-lg p-4 bg-neutral-800 text-white z-10 rounded-2xl">
        <h1 class="font-['Inter'] font-bold text-xl">Violetshine</h1>
        <p class="font-['Inter'] font-normal text-xs">G'day! I'm Violet and this is my personal website that I'm currently building. There isn't anything interesting here quite yet as I still need to decide what I want to have here.</p>
      </main>
    </div>
    <div class="fixed top-0 left-0 w-screen h-screen z-[-1] bg-linear-to-br from-[#3a005b] to-[#370493] select-none"></div>
  </div>
</body>
</html>
