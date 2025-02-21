# form
1. 사용자로부터 정보를 입력 받을 때 사용하는 태그
2. 주요속성
    * action : 정보를 받아서 어디서 처리할 것인지 처리할 장소(위치, 경로)를 지정
    * method : 정보를 전달하는 방식
        - get :	default, 정보를 header에 포함시켜서 보냄 정보가 노출됨(보안 처리가 안됨) 빠름 (ex: 검색)            
        - post : 정보를 body에 포함시켜서 보냄 정보가 보안처리됨 느림(ex:회원가입, 로그인)
        - enctype : 파일 업로드 할때 사용
# input
1. 속성
     * text - 문자를 입력받음
     * passward - 문자를 숨심처리 하여 입력받음
     * email - 메일 형식을 입력 받음
     * tel - 전화번호를 입력받음
     * number - 숫자만 입력
     * date - 날짜 입력
     * time - 시간 입력
     * file - 파일 첨부
     * range - 진행바
     * color - 색상표
     * checkbox - 체크 박스를 생성하며 중복 선택가능
     * radio - 라디오 버튼을 생성하며 중복 선택불가
     * button - 일반 버튼
     * submit - 전송 버튼
     * hidden - 숨김처리
     * reset - 입력하던 값 초기화
     * image - 이미지 주소로 생성

