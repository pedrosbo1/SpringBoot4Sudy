function myFunction() {
    var request = new XMLHttpRequest();
    request.open('GET','http://localhost:8080/sw/people');
    request.onload = function(){
        var ourData = JSON.parse(request.responseText);
        document.getElementById("demo").innerHTML = ourData.name;
    };
    request.send();
}
function getTweet() {
    var request = new XMLHttpRequest();
    request.open('GET','http://localhost:8080/tw/gettweet?name=@DaitanCareers');
    request.onload = function(){
        var ourData = JSON.parse(request.responseText);
        document.getElementById("demo").innerHTML = ourData[1].text;
    };
    request.send();
}