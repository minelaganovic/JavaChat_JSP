/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function startchating(){
    var uname=document.getElementById('uname');
    if(uname.value==='')
    {
        alert('Please login to continue!');
        return false;
    }
    var xmlhttp;
    xmlhttp=new XMLHttpRequest();
    xmlhttp.open("POST","userlogin?uname="+uname.value,true);
    xmlhttp.onreadystatechange=function(){
        if(xmlhttp.readyState==4 && xmlhttp.status==200){
            if(xmlhttp.responseText.indexOf('Incorrect') !== -1){
                document.getElementById("greska").innerHTML = "<h4 style='color:red'>" + xmlhttp.responseText + "<h4>";
            }
            else{
                window.location.replace('http://localhost:8080/JSPChatProject/chat.jsp');                
            }
        }
    }
    xmlhttp.send(null);
}
function addText(){
    var username = document.getElementById('u').value;
    var msg = document.getElementById('h').value;
    getchatlistdiv=document.getElementById('list');
    newrow=document.createElement('p');
    newrow.innerHTML = username + "- <g>" + msg + "</g>";
    contentdiv = document.getElementById('content');
    contentdiv.appendChild(newrow);
    getchatlistdiv.scrollTop = getchatlistdiv.scrollHeight;
    document.getElementById('h').value = '';
    
    var xmlhttp;
    xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST", "chatting?uname=" + username + "&msg=" + msg, true);
    xmlhttp.onreadystatechange = function(){
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200){
            document.getElementById("result").innerHTML = 'sent';
            document.getElementById("result").innerHTML = '';
        }
    }
    xmlhttp.send(null);
}

function reloaddata(){
    var xmlhttp;
    xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST", "reloaddata", true);
    xmlhttp.onreadystatechange = function(){
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200){
            document.getElementById("content").innerHTML = xmlhttp.responseText;
            olist = document.getElementById('list');
            olist.scrollTop = olist.scrollHeight;
        }
    }
    xmlhttp.send(null);
}