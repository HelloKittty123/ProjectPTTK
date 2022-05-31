<?php

$fullname = $email = $msg = $role_id = '';

if(!empty($_POST)) {
	$email = getPost('email');
	$pwd = getPost('password');
	// $pwd = getSecurityMD5($pwd);

	$sql = "select * from user where email = '$email' and password = '$pwd' and role_id = 5";
	$userExist = executeResult ($sql,true);
		
	if($userExist == null) {
		$msg ='Đăng nhập không thành công, vui lòng kiểm tra lại email hoặc mật khẩu!!';
	} else {
		header("Location: ../../screen_user/index.php?user_id=".$userExist['id']."");
	}

}