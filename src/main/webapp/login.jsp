<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Admin Login</title>
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,200;0,400;0,600;0,700;1,600&display=swap"
    rel="stylesheet">
  <link rel="stylesheet" href="./styles/login.css">
</head>

<body>
  <main>
    <header>
      <div id="form-head">
        <h2>Login</h2>
      </div>
    </header>

    <section id="form-body">
      <form action="login" method="post">
        <div class="form-group">
          <label for="userName">Username</label>
          <input id="userName" class="form-control" type="text" name="userName" placeholder="john_smith123" required>
        </div>

        <div class="form-group">
          <label for="password">Password</label>
          <input id="password" class="form-control" type="password" name="password" required>
        </div>

        <button type="submit" class="btn">Login</button>
      </form>
    </section>
  </main>
</body>

</html>