const doBox = document.querySelector(".do-box");
const sigunguBox = document.querySelector(".sigungu-box");
const campsiteContainer = document.querySelector("#camp-list-container");

	/* CSS 한번에 셋팅 */
	Element.prototype.setStyle = function(styles) {
    	for (var k in styles) this.style[k] = styles[k];
    	return this;
	};

	/** 페이지 로드시 도 이름 불러오기 */
	/** 페이지 로드시 전체 목록 10개 출력, 원래 데이터가 있다면 지우고 출력  */
	window.addEventListener("load",function(){
		getDoNm(doBox);
		getAllCampList("1");
	})
	/**첫 페이지 접속 시 캠핑장 리스트 불러오기  */
	function getAllCampList(pageNo){
		axios({
			method:'POST',
			url:'/camp/all',
			data:'pageNo=' + pageNo
		})
		.then(response =>{
			//console.log(response.data);
			campsiteContainer.innerHTML = response.data;
		})
		.catch(error => {
			console.log(error.response.data);
		})
	}
	/** 도 DB 가져와서 HTML 출력 */	
	function getDoNm(){
		axios({
			method:'POST',
			url : '/camp/donm',
			data: {}
		})	
		.then(response => {
			doBox.innerHTML = response.data;
		})
		.catch(error =>{
			console.log(error);
		})
	}
	
	/** 도 출력 박스 선택 이벤트, 로컬 스토리지 저장 */
	function getSigungu(value){
		var doBox = document.querySelector('.do-box');
		
		/** 도 이름 클릭 시 이벤트 */
		doBox.onclick = function(e){
			
			if(e.target.nodeName != "INPUT") return;
			
			/** 도 이름 가져오기 */
			var doNm = value;
			
			/** 도 이름 로컬스토리지에 저장 */
			localStorage.setItem('doNm',doNm);
			
			/** DB접근 및 HTMl 출력 */
			useDoSigungu(doNm);
		}
	}
	
	/** 시군구 DB 접근 및 HTML 출력  */
	function useDoSigungu(doNm){
		axios({
			method:'POST',
			url : '/camp/sigungu',
			data : 'doNm=' + doNm
		})
		.then(response => {
			sigunguBox.innerHTML = response.data;
		})
		.catch(error => {
			console.log(error);
		})
	}
	
	/** 도,시에 맞는 캠핑장 데이터 불러오기 */
	function getDoSiCampsite(value){
		//로컬스토리지에 저장된 doNm 가져오기
		var doNm = localStorage.getItem('doNm');
		
		sigunguBox.onclick = function(e){
			const json = JSON.stringify({
				'doNm' : doNm,
				'sigungu' : value
			})
			
			if(e.target.nodeName != "INPUT") return;
			
			axios({
				method:'POST',
				url : '/camp/search/ds',
				headers : {
					'Content-Type' : 'application/json'
				},
				data : json
			})
			.then(response => {
				campsiteContainer.innerHTML = response.data;
			})
			.catch(error => {
				console.log(error.response.data);
			})
		}
	}

/** 상세보기 */
/*수정*********************************************/
function detail(campsiteNo){
	location.href = "/camp/detail?campsiteNo=" + campsiteNo;
}

	
	
