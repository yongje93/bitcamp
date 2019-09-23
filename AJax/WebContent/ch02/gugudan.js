var xhr = null;
function startMethod() {
	var dan = document.inputForm.dan.value;
	
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = resultProcess;
	xhr.open("POST", "getGugudan.jsp", true);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("dan="+dan);
}

function resultProcess() {
	if(xhr.readyState == 4) {
		if(xhr.status == 200) {
			document.getElementById("displayArea").innerHTML = xhr.responseText;
			document.getElementById("displayArea").style.display="block";
		}
	}
}