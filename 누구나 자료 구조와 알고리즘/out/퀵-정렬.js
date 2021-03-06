class 분할_배열 {
    배열;
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
    퀵_셀렉트(찾는_값의_인덱스, 왼쪽_인덱스 = 0, 오른쪽_인덱스 = this.배열.length - 1) {
        if (오른쪽_인덱스 - 왼쪽_인덱스 <= 0) {
            return this.배열[왼쪽_인덱스];
        }
        const 피벗_인덱스 = this.분할(왼쪽_인덱스, 오른쪽_인덱스);
        if (찾는_값의_인덱스 < 피벗_인덱스) {
            return this.퀵_셀렉트(찾는_값의_인덱스, 왼쪽_인덱스, 피벗_인덱스 - 1);
        }
        else if (찾는_값의_인덱스 > 피벗_인덱스) {
            return this.퀵_셀렉트(찾는_값의_인덱스, 피벗_인덱스 + 1, 오른쪽_인덱스);
        }
        else {
            return this.배열[피벗_인덱스];
        }
    }
    퀵_정렬(왼쪽_인덱스 = 0, 오른쪽_인덱스 = this.배열.length - 1) {
        if (오른쪽_인덱스 - 왼쪽_인덱스 <= 0) {
            return;
        }
        const 피벗_인덱스 = this.분할(왼쪽_인덱스, 오른쪽_인덱스);
        this.퀵_정렬(왼쪽_인덱스, 피벗_인덱스 - 1);
        this.퀵_정렬(피벗_인덱스 + 1, 오른쪽_인덱스);
    }
}
const 퀵_정렬_배열 = [0, 5, 2, 1, 6, 3];
const $분할_배열_1 = new 분할_배열(퀵_정렬_배열);
$분할_배열_1.퀵_정렬();
console.log(퀵_정렬_배열); // [ 0, 1, 2, 3, 5, 6 ]
const 퀵_셀렉트_배열 = [0, 50, 20, 10, 60, 30];
const $분할_배열_2 = new 분할_배열(퀵_셀렉트_배열);
console.log($분할_배열_2.퀵_셀렉트(4)); // 50
