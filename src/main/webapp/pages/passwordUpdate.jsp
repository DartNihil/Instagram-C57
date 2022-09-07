<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>passwordUpdate</title>
</head>
<style>
    body {
        background: url(https://funart.pro/uploads/posts/2022-08/thumbs/1659682470_5-funart-pro-p-odnotonnii-fon-dlya-instagram-krasivo-5.jpg);
        background-size: 100%;
    }

    body {
        margin: 0;
        padding: 0;
        font-family: sans-serif;


    }

    .box {
        width: 300px;
        padding: 40px;
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        border-radius: 14px;
        background: url(https://funart.pro/uploads/posts/2022-08/1659728572_56-funart-pro-p-fon-dlya-teksta-v-instagramme-krasivo-58.jpg);
        background-size: 146%;
        text-align: center;
    }

    .box h1 {
        color: black;
        text-transform: uppercase;
        font-weight: 500;
    }

    .box input[type = "text"], .box input[type = "password"] {
        border: 0;
        background: none;
        display: block;
        margin: 20px auto;
        text-align: center;
        border: 3px solid #3498db;
        padding: 14px 10px;
        width: 200px;
        outline: none;
        color: black;
        border-radius: 24px;
        transition: 0.25s;
    }

    .box input[type = "text"]:focus, .box input[type = "password"]:focus {
        width: 280px;
        border-color: violet;
    }

    .box input[type = "submit"] {
        border: 0;
        background: none;
        display: block;
        margin: 20px auto;
        text-align: center;
        border: 4px solid violet;
        padding: 14px 40px;
        outline: none;
        color: black;
        border-radius: 24px;
        transition: 0.25s;
        cursor: pointer;
    }

    .box input[type = "submit"]:hover {
        background: violet;
    }
</style>
<body>
<div>
    <p style="font-family:'Comic Sans MS', cursive">${sessionScope.currentUser.nickname}</p>
    <form class="box" method="post">
        <h1 style="font-family:'Comic Sans MS', cursive"> Password change</h1>
        <br>
        <label for="userPassword" style="font-family:'Comic Sans MS', cursive">Current password:</label>
        <input id="userPassword" type="password" pattern="[(A-Za-z0-9)]{8,}" title="Enter your current password"
               required>
        <br>
        <label for="newPassword" style="font-family:'Comic Sans MS', cursive">New password:</label>
        <input id="newPassword" type="password" pattern="[(A-Za-z0-9)]{8,}"
               title="Must contain numbers, uppercase and lowercase letters, and at least 8 characters" required>
        <br>
        <label for="confirmNewPassword" style="font-family:'Comic Sans MS', cursive">Confirm new password:</label>
        <input id="confirmNewPassword" type="password" pattern="[(A-Za-z0-9)]{8,}" title="Repeat new password" required>
        <br>
        <input type="submit" style="font-family:'Comic Sans MS', cursive" name="" value="Submit">
    </form>
</div>
</body>
</html>
