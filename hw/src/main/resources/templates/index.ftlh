<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Microgram </title>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body class="no-scroll" onload="addingAllPosts()">>
<div class="container">
    <div class="row justify-content-center">
        <div class="col col-lg-7 posts-container" id="posts">
            <button onclick="showSplashScreen()"> Show splash screen</button>
            <button onclick="addPost()"> Add new post </button>
            <hr>
            <form id="postForm" class="postForm formStyle" enctype="multipart/form-data" action="/demo" method="post">
                <div>
                    <input type="hidden" id="user_id" name="user_id" value="777" />
                    <input type="text" placeholder="description" name="description" id="description">
                    <hr>
                    <input type='file' id="image" name="image" accept='image/*'>
                    <hr>
                    <button type="button" id="btnSubmit"> POST! </button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Splash screen -->
    <section id="page-splash" class="page-splash">
        <div class="card" id="registration-form">
            <div class="card-body">
                <h3 class="h3">Зарегистрируйтесь</h3>
                <button onclick="hideSplashScreen()" id="login_button"> Войти </button>
            </div>
        </div>
    </section>

</body>
</html>
<script src="/js/script.js"></script>