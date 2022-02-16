function 팩토리얼_하향식(숫자: number): number {
  if (숫자 === 1) {
    return 1;
  } else {
    return 숫자 * 팩토리얼_하향식(숫자 - 1);
  }
}

console.log(팩토리얼_하향식(6)); // 720

function 팩토리얼_상향식(
  숫자: number,
  i: number = 1,
  결과: number = 1
): number {
  if (i > 숫자) {
    return 결과;
  }

  return 팩토리얼_상향식(숫자, i + 1, 결과 * i);
}

console.log(팩토리얼_상향식(6)); // 720
