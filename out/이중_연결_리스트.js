class 이중_연결_리스트_노드 {
    constructor(데이터) {
        this.데이터 = 데이터;
    }
}
class 이중_연결_리스트 {
    constructor(헤드 = null, 테일 = null) {
        this.헤드 = 헤드;
        this.테일 = 테일;
    }
    테일_삽입(값) {
        const $새_노드 = new 이중_연결_리스트_노드(값);
        if (!this.헤드) {
            this.헤드 = $새_노드;
            this.테일 = $새_노드;
        }
        else {
            $새_노드.이전_노드 = this.테일;
            this.테일 = $새_노드;
        }
    }
    헤드_삭제() {
        const 삭제한_노드 = this.헤드;
        this.헤드 = this.헤드.다음_노드;
        return 삭제한_노드;
    }
}
class 이중_연결_리스트_큐 {
    constructor() {
        this.$이중_연결_리스트 = new 이중_연결_리스트();
    }
    인큐(요소) {
        this.$이중_연결_리스트.테일_삽입(요소);
    }
    디큐() {
        const 삭제_노드 = this.$이중_연결_리스트.헤드_삭제();
        return 삭제_노드;
    }
    읽기() {
        if (!this.$이중_연결_리스트.헤드) {
            return null;
        }
        else {
            return this.$이중_연결_리스트.헤드;
        }
    }
}
