<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cupcake shop</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/bootstrap.min.js"></script>
</head>
<body>

<%= session.getAttribute("username") %>
<%= session.getAttribute("balance") %>

<div class="container">
    <div class="col-xs-12">
        <form method="POST">
            <h1>Log in</h1>
            <div class="form-group row">
                <div class="col-sm-2">
                    <label for="username">Username</label>
                </div>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="username" name="username">
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-2">
                    <label for="password">Name</label>
                </div>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="password" name="password">
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-2">
                </div>
                <div class="col-sm-10">
                    <button class="btn btn-primary">Log in</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
