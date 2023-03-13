function solution(s) {
 let answer = [];
    let s_list = s.split(' '); // 공백을 기준으로 배열 생성
    s_list.forEach(function(val){ // s_list의 단어들을 꺼내오기
        answer.push(val.slice(0,1).toUpperCase()+val.slice(1).toLowerCase()); // 첫번째 글자는 대console.log(val)
    })
    return answer.join(' '); // 배열을 합친다
}

/*
if (!Character.isDigit(e.charAt(0))) {
                        return String.valueOf(e.charAt(0)).toUpperCase() + e.substring(1).toLowerCase();
                    }
                    return e.charAt(0) + e.substring(1).toLowerCase();
*/