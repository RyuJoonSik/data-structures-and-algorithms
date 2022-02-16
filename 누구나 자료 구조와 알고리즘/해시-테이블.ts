function 부분집합_인지(배열_1: number[], 배열_2: number[]) {
  let [큰_배열, 작은_배열] =
    배열_1.length > 배열_2.length ? [배열_1, 배열_2] : [배열_2, 배열_1];

  for (
    let 작은_배열_인덱스 = 0;
    작은_배열_인덱스 < 작은_배열.length;
    작은_배열_인덱스++
  ) {
    let 같은_값이_있는지 = false;

    for (
      let 큰_배열_인덱스 = 0;
      큰_배열_인덱스 < 큰_배열.length;
      큰_배열_인덱스++
    ) {
      if (작은_배열[작은_배열_인덱스] === 큰_배열[큰_배열_인덱스]) {
        같은_값이_있는지 = true;

        break;
      }
    }

    if (같은_값이_있는지 === false) {
      return false;
    }
  }

  return true;
}

console.log(부분집합_인지([1, 2, 3], [1, 2])); // true

function 부분집합_인지_해시(배열_1: number[], 배열_2: number[]) {
  let [큰_배열, 작은_배열] =
    배열_1.length > 배열_2.length ? [배열_1, 배열_2] : [배열_2, 배열_1];
  let 해시_테이블: { [키: number]: boolean } = {};

  for (let 숫자 of 큰_배열) {
    해시_테이블[숫자] = true;
  }

  for (let 숫자 of 작은_배열) {
    if (!해시_테이블[숫자]) {
      return false;
    }
  }

  return true;
}

console.log(부분집합_인지_해시([1, 2, 3], [1, 2])); // true
