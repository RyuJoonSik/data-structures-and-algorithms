"use strict";
class 분할_배열 {
    constructor(배열) {
        this.배열 = 배열;
    }
    분할(왼쪽_포인터 = 0, 오른쪽_포인터 = this.배열.length - 1) {
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
            }
            else {
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
}
const $분할_배열 = new 분할_배열([0, 5, 2, 1, 6, 3]);
console.log($분할_배열.분할());
