/**
 * 
 */
 
 
 window.addEventListener('DOMContentLoaded', () => {
	// 각각의 버튼 클릭했을 때 이벤트
	const myRbtn = document.getElementById('rBtn');
	myRbtn.addEventListener('click', function() {
        submitPick('바위');
    });
    const mySbtn = document.getElementById('sBtn');
    mySbtn.addEventListener('click', function() {
        submitPick('가위');
    });
    const myPbtn = document.getElementById('pBtn');
    myPbtn.addEventListener('click', function() {
        submitPick('보');
    });
    // 내가 클릭한 버튼: 공통 이벤트(색변화)
    const myButtons = [myRbtn, mySbtn, myPbtn];
    myButtons.forEach(button => {
		button.addEventListener('click', function() {
                myButtons.forEach(btn => btn.classList.remove('selected')); 
                button.classList.add('selected');
        });
	});
    
    // 클릭했을 때 컴퓨터가 랜덤숫자 뽑아서, 뽑은 값과 가위바위보 결과를 알려줌.
	function submitPick(pick){
		axios.post('/myPick', pick, {
			headers: { 'Content-Type': 'text/plain' },
		})
		.then(response => {
			updateResult(response.data);
        })
		.catch(err => {alert(err+"!!!!");
        });
	}
	
	
	// 게임 결과 화면 업데이트와 컴퓨터가 뽑은 값 색변화
	function updateResult(data){
		const computerPick = data[0];
		const gameResult = data[1];
		
		// computerDiv내의 모든 버튼 찾고 해당하는 값에 css만 변경해줌
		const computerDiv = document.querySelector('#computerDiv');
		const computerButtons = computerDiv.querySelectorAll('input');
		computerButtons.forEach(input => {
			if(input.value === computerPick) input.classList.add('selected');
			else input.classList.remove('selected');
		});
		
		// 게임 결과 표시해줌
		const resultDiv = document.querySelector("#resultDiv");
		let str = '';
		str += '<span>게임 결과: ' + gameResult + '</span>'
		resultDiv.innerHTML = str;
	}
});