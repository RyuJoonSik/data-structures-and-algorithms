class 분할_배열 {
  constructor(private 배열: number[]) {}

  분할(왼쪽_포인터: number = 0, 오른쪽_포인터: number = this.배열.length - 1) {
    const 피벗_인덱스 = 오른쪽_포인터;
    const 피벗 = this.배열[피벗_인덱스];

    오른쪽_포인터--;

    while (true) {
      while (this.배열[왼쪽_포인터] < 피벗) {
        왼쪽_포인터++;
      }

      while (this.배열[오른쪽_포인터] > 피벗) {
        오른쪽_포인터--;
      }

      if (왼쪽_포인터 >= 오른쪽_포인터) {
        break;
      } else {
        const 임시_변수 = this.배열[오른쪽_포인터];
        this.배열[오른쪽_포인터] = this.배열[왼쪽_포인터];
        this.배열[왼쪽_포인터] = 임시_변수;

        왼쪽_포인터++;
      }
    }

    const 임시_변수 = this.배열[피벗_인덱스];
    this.배열[피벗_인덱스] = this.배열[왼쪽_포인터];
    this.배열[왼쪽_포인터] = 임시_변수;

    return 왼쪽_포인터;
  }

  퀵_정렬(
    왼쪽_인덱스: number = 0,
    오른쪽_인덱스: number = this.배열.length - 1
  ) {
    if (오른쪽_인덱스 - 왼쪽_인덱스 <= 0) {
      return;
    }

    const 피벗_인덱스 = this.분할(왼쪽_인덱스, 오른쪽_인덱스);

    this.퀵_정렬(왼쪽_인덱스, 피벗_인덱스 - 1);
    this.퀵_정렬(피벗_인덱스 + 1, 오른쪽_인덱스);
  }
}

const 퀵_정렬_배열 = [0, 5, 2, 1, 6, 3];
const $분할_배열 = new 분할_배열(퀵_정렬_배열);

$분할_배열.퀵_정렬();
console.log(퀵_정렬_배열);
