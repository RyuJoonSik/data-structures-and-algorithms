function 두_수의_합_구하기(배열) {
    for (let 기준_인덱스 = 0; 기준_인덱스 < 배열.length; 기준_인덱스++) {
        for (let 비교_인덱스 = 0; 비교_인덱스 < 배열.length; 비교_인덱스++) {
            if (기준_인덱스 !== 비교_인덱스 && 배열[기준_인덱스] + 배열[비교_인덱스] === 10) {
                return true;
            }
        }
    }
    return false;
}
function 최적화_두_수의_합_구하기(배열) {
    let 해시_테이블 = {};
    for (let 기준_인덱스 = 0; 기준_인덱스 < 배열.length; 기준_인덱스++) {
        if (해시_테이블[10 - 배열[기준_인덱스]]) {
            return true;
        }
        해시_테이블[배열[기준_인덱스]] = true;
    }
    return false;
}
console.log(두_수의_합_구하기([2, 0, 4, 1, 7, 9])); // true
console.log(최적화_두_수의_합_구하기([2, 0, 4, 1, 7, 9])); // true
function 동전_게임_승자_찾기(동전_개수, 현재_플레이어 = 'you') {
    if (동전_개수 <= 0) {
        return 현재_플레이어;
    }
    let 다음_플레이어 = '';
    if (현재_플레이어 === 'you') {
        다음_플레이어 = 'them';
    }
    else {
        다음_플레이어 = 'you';
    }
    if (동전_게임_승자_찾기(동전_개수 - 1, 다음_플레이어) === 현재_플레이어 ||
        동전_게임_승자_찾기(동전_개수 - 2, 다음_플레이어) === 현재_플레이어) {
        return 현재_플레이어;
    }
    else {
        return 다음_플레이어;
    }
}
console.log(동전_게임_승자_찾기(1)); // them
console.log(동전_게임_승자_찾기(2)); // you
console.log(동전_게임_승자_찾기(3)); // you
console.log(동전_게임_승자_찾기(4)); // them
console.log(동전_게임_승자_찾기(5)); // you
console.log(동전_게임_승자_찾기(6)); // you
console.log(동전_게임_승자_찾기(7)); // them
console.log(동전_게임_승자_찾기(8)); // you
console.log(동전_게임_승자_찾기(9)); // you
console.log(동전_게임_승자_찾기(10)); // them
function 최적화_동전_게임_승자_찾기(동전_개수) {
    if ((동전_개수 - 1) % 3 === 0) {
        return 'them';
    }
    else {
        return 'you';
    }
}
console.log(최적화_동전_게임_승자_찾기(1)); // them
console.log(최적화_동전_게임_승자_찾기(2)); // you
console.log(최적화_동전_게임_승자_찾기(3)); // you
console.log(최적화_동전_게임_승자_찾기(4)); // them
console.log(최적화_동전_게임_승자_찾기(5)); // you
console.log(최적화_동전_게임_승자_찾기(6)); // you
console.log(최적화_동전_게임_승자_찾기(7)); // them
console.log(최적화_동전_게임_승자_찾기(8)); // you
console.log(최적화_동전_게임_승자_찾기(9)); // you
console.log(최적화_동전_게임_승자_찾기(10)); // them
function 합_교환하기(배열1, 배열2) {
    const 해시_테이블 = {};
    let 배열1_합 = 0, 배열2_합 = 0;
    for (let 인덱스 = 0; 인덱스 < 배열1.length; 인덱스++) {
        배열1_합 += 배열1[인덱스];
        해시_테이블[배열1[인덱스]] = 인덱스;
    }
    for (let 인덱스 = 0; 인덱스 < 배열2.length; 인덱스++) {
        배열2_합 += 배열2[인덱스];
    }
    const 변해야하는_값 = (배열1_합 - 배열2_합) / 2;
    for (let 인덱스 = 0; 인덱스 < 배열2.length; 인덱스++) {
        if (해시_테이블[배열2[인덱스] + 변해야하는_값]) {
            return [해시_테이블[배열2[인덱스] + 변해야하는_값], 인덱스];
        }
    }
    return null;
}
console.log(합_교환하기([5, 3, 3, 7], [4, 1, 1, 6])); // [ 3, 0 ]
function 최대_부분_합_구하기(배열) {
    let 현재_합 = 0;
    let 최대_합 = 0;
    for (const 숫자 of 배열) {
        if (현재_합 + 숫자 < 0) {
            현재_합 = 0;
        }
        else {
            현재_합 += 숫자;
            최대_합 = Math.max(최대_합, 현재_합);
        }
    }
    return 최대_합;
}
console.log(최대_부분_합_구하기([3, -4, 4, -3, 5, -9])); // 6
function 상승세_주가_찾기(배열) {
    let 낮은_가격 = 배열[0];
    let 중간_가격 = Infinity;
    for (const 주가 of 배열) {
        if (주가 <= 낮은_가격) {
            낮은_가격 = 주가;
        }
        else if (주가 <= 중간_가격) {
            중간_가격 = 주가;
        }
        else {
            return true;
        }
    }
    return false;
}
console.log(상승세_주가_찾기([5, 2, 8, 4, 3, 7])); // true
console.log(상승세_주가_찾기([8, 9, 7, 10])); // true
function 애너그램인지(단어_1, 단어_2) {
    const 단어_해시_테이블 = {};
    const 단어_2_해시_테이블 = {};
    for (const 문자 of 단어_1) {
        단어_해시_테이블[문자] ? 단어_해시_테이블[문자]++ : (단어_해시_테이블[문자] = 1);
    }
    for (const 문자 of 단어_2) {
        if (단어_해시_테이블[문자]) {
            단어_해시_테이블[문자]--;
        }
        else {
            return false;
        }
    }
    return Object.values(단어_해시_테이블).every((cnt) => cnt === 0);
}
console.log(애너그램인지('rattles', 'startle')); // true
function 그룹_정렬하기(배열) {
    const 해시_테이블 = {};
    const 새_배열 = [];
    for (const 문자 of 배열) {
        해시_테이블[문자] ? 해시_테이블[문자]++ : (해시_테이블[문자] = 1);
    }
    for (const [문자, 횟수] of Object.entries(해시_테이블)) {
        새_배열.push(...문자.repeat(횟수));
    }
    return 새_배열;
}
console.log(그룹_정렬하기(['a', 'c', 'd', 'b', 'b', 'c', 'a', 'd', 'c', 'b', 'a', 'd']));
