function validateSignUp(){
	var userName= document.getElementById("userName").value;
	var userPassWord = document.getElementById("userPassWord").value;
	
	//kiểm tra dộ dài mật khẩu
	if(userPassWord.length < 6){
		alert("Độ dài mật khẩu tối thiểu 6 kí tự");
	}
	
	//kiểm tra tên tài khoản
	var userNamePattern = /^[a-zA-Z0-9]+$/;
	if (!userNamePattern.test(userName)) {
        alert("Tên tài khoản chỉ được chứa các ký tự chữ cái và số, không có khoảng trắng và dấu");
    } 
    
	return (userPassWord.length >= 6 && userNamePattern.test(userName));
}