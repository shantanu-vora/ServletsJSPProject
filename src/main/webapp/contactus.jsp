<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Contact Us</title>
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,200;0,400;0,600;0,700;1,600&display=swap"
    rel="stylesheet">
  <link rel="stylesheet" href="./styles/app.css">
</head>

<body>
  <main>
    <header>
      <div id="form-head">
        <h2>Contact Us</h2>
        <p>Please fill this form in a decent manner</p>
      </div>
    </header>

    <section id="form-body">
      <form action="contactus" method="post">
        <div class="form-group">
          <label for="fullName">Full Name</label>
          <input id="fullName" class="form-control" type="text" name="fullName" placeholder="John Smith" required>
        </div>

        <div class="form-group">
          <label for="email">Email</label>
          <input id="email" class="form-control" type="email" name="email" placeholder="example@abc.com" required>
        </div>

        <div class="form-group">
          <label for="message">Message</label>
          <textarea name="message" id="message" class="form-control" rows="500" required></textarea>
        </div>

        <button type="submit" class="btn">Submit</button>
      </form>
    </section>
  </main>
</body>

</html>