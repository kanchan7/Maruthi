<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
    $("button").click(function(){
        $.ajax({url: "fbLogin.jsp", success: function(result){
            $("#div1").html(result);
        }});
    });
});
</script>
</head>
<body>
<h3>Search Products...</h3>
<div id="div1"><h2>Before Ajax</h2></div>

<button>Fetch FB Login</button>

</body>
</html>