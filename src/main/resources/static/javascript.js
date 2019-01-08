function myFunction() {
    var request = new XMLHttpRequest();
    request.open('GET','http://localhost:8080/User/Users');
    request.onload = function(){
        var ourData = JSON.parse(request.responseText);
        document.getElementById("demo").innerHTML = ourData[0].name;
    };
    request.send();
}