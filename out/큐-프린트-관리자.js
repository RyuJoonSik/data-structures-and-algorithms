class 큐 {
    constructor() {
        this.배열 = [];
    }
    인큐(요소) {
        this.배열.push(요소);
    }
    디큐() {
        return this.배열.shift();
    }
    읽기() {
        return this.배열[0];
    }
}
class 프린트_관리자 {
    constructor() {
        this.$큐 = new 큐();
    }
    프린트_작업_추가(문서) {
        this.$큐.인큐(문서);
    }
    프린트_실행() {
        while (this.$큐.읽기()) {
            console.log(this.$큐.디큐());
        }
    }
}
const $프린트_관리자 = new 프린트_관리자();
$프린트_관리자.프린트_작업_추가("First Document");
$프린트_관리자.프린트_작업_추가("Second Document");
$프린트_관리자.프린트_작업_추가("Third Document");
$프린트_관리자.프린트_실행();
