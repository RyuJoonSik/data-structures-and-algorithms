function 피보나치(숫자: number): number {
  if (숫자 === 0 || 숫자 === 1) {
    return 숫자;
  }

  return 피보나치(숫자 - 2) + 피보나치(숫자 - 1);
}

console.log(피보나치(7)); // 13

function 피보나치_메모제이션(
  숫자: number,
  메모: { [키: number]: number } = {}
): number {
  if (숫자 === 0 || 숫자 === 1) {
    return 숫자;
  }

  if (!메모[숫자]) {
    메모[숫자] =
      피보나치_메모제이션(숫자 - 2, 메모) + 피보나치_메모제이션(숫자 - 1, 메모);
  }

  return 메모[숫자];
}

console.log(피보나치_메모제이션(7)); // 13

function 피보나치_상향식(숫자: number): number {
  if (숫자 === 0) {
    return 0;
  }

  let [첫번째_숫자, 두번째_숫자] = [0, 1];

  for (let i = 1; i < 숫자; i++) {
    [첫번째_숫자, 두번째_숫자] = [두번째_숫자, 첫번째_숫자 + 두번째_숫자];
  }

  return 두번째_숫자;
}

console.log(피보나치_상향식(7)); // 13
