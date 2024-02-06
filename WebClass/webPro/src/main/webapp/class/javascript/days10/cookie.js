/**
 * cookie.js
 */

// 쿠키생성 
function setCookie(cName,cValue,cPath ,expiresDays ) { // 함수호출할 때 넘겨 받겠지? 

	let now = new Date(); 
	now.setDate(now.getDate()+expiresDays); 
	let expire = now.toUTCString(); 
	
	document.cookie = `${cName}=${cValue}; expires=${expire}; path=${cPath}`;
	
}

// 모든 쿠키 정보 얻기 
function getAllCookie() {
	let cookies = document.cookie ; 
	return cookies;
}

// 쿠키 조회
function getCookie(cName) {
	let cValue; 
	let cookies = document.cookie; 
	
	let cookieArr = cookies.split(/;\s/); 	
	cookieArr.forEach(function(elt, i, array) {
		let cnv = elt.split("=");
		if(cnv[0] == cName){
			cValue = unescape( cnv[1]) ;
		}
	})// foreach 
	
	if(cValue){
		return cValue
	}else{ 
		return null; 
	}
} // getCookie()

// 쿠키삭제
function delCookie(cName , cPath) {

	let now = new Date(); 
	now.setDate(now.getDate()-10); 
	let expire = now.toUTCString(); 
	
	document.cookie = `${cName}=; expires=${expire}; path=${cPath}`;
} // delCookie


