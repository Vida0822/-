/**
 * ex14_message 
	=> 함수 내보내기 
		(이 파일안에서 하나의 기본 내보내기만 할 수 있다 )
 */
/* 모듈화*/ 

const message = function(){
	const name = "홍길동"; 
	const age = 30; 
	return name +"/"+age; 
}; 


export default message ;  // 함수 
// 다른 파일에서 사용할 수 있도록 이 함수를 내보낼거임 