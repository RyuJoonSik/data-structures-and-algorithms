function 배열_합_구하기(배열) {
    if (배열.length === 1) {
        return 배열[0];
    }
    return 배열[0] + 배열_합_구하기(배열.slice(1));
}
console.log(배열_합_구하기([2, 3, 4, 5])); // 14
function 문자열_뒤집기(문자열) {
    if (문자열.length === 1) {
        return 문자열[0];
    }
    return 문자열_뒤집기(문자열.slice(1)) + 문자열[0];
}
console.log(문자열_뒤집기("abcde")); // 'edcba'
function X_세기(문자열) {
    if (문자열.length === 0) {
        return 0;
    }
    return 문자열[0] === "x"
        ? 1 + X_세기(문자열.slice(1))
        : X_세기(문자열.slice(1));
}
console.log(X_세기("xbxcxa")); // 3
function 계단_경로_수_세기(계단_수) {
    if (계단_수 < 0) {
        return 0;
    }
    else if (계단_수 === 1 || 계단_수 === 0) {
        return 1;
    }
    return (계단_경로_수_세기(계단_수 - 1) +
        계단_경로_수_세기(계단_수 - 2) +
        계단_경로_수_세기(계단_수 - 3));
}
console.log(계단_경로_수_세기(4)); // 7
function 에너그램_생성(문자열) {
    if (문자열.length === 1) {
        return [문자열[0]];
    }
    const 에너그램_배열 = [];
    const 부분_에너그램_배열 = 에너그램_생성(문자열.slice(1));
    for (const 부분_에너그램 of 부분_에너그램_배열) {
        for (let 인덱스 = 0; 인덱스 <= 부분_에너그램.length; 인덱스++) {
            const 부분_에너그램_임시_배열 = [...부분_에너그램];
            부분_에너그램_임시_배열.splice(인덱스, 0, 문자열[0]);
            에너그램_배열.push(부분_에너그램_임시_배열.join(""));
        }
    }
    return 에너그램_배열;
}
console.log(에너그램_생성("abc")); // [ 'abc', 'bac', 'bca', 'acb', 'cab', 'cba' ]
function 최대_수_구하기(배열) {
    if (배열.length === 1) {
        return 배열[0];
    }
    if (배열[0] > 최대_수_구하기(배열.slice(1))) {
        return 배열[0];
    }
    else {
        return 최대_수_구하기(배열.slice(1));
    }
}
console.log(최대_수_구하기([1, 2, 3, 4])); // 4
function 최대_수_구하기_개선(배열) {
    if (배열.length === 1) {
        return 배열[0];
    }
    const 나머지_최대_수 = 최대_수_구하기_개선(배열.slice(1));
    if (배열[0] > 나머지_최대_수) {
        return 배열[0];
    }
    else {
        return 나머지_최대_수;
    }
}
console.log(최대_수_구하기_개선([1, 2, 3, 4])); // 4
