class 린터 {
    constructor() {
        this.스택 = [];
    }
    린트(문자열) {
        for (let 문자 of [...문자열]) {
            if (this.여는_괄호인지(문자)) {
                this.스택.push(문자);
            }
            else if (this.닫는_괄호인지(문자)) {
                let 스택_꼭대기_값 = this.스택.pop();
                if (!스택_꼭대기_값) {
                    return `${문자}의 여는 괄호가 없습니다.`;
                }
                if (!this.일치하는지(스택_꼭대기_값, 문자)) {
                    return `${문자}의 일치하는 여는 괄호가 없습니다.`;
                }
            }
        }
        if (this.스택.length) {
            return `${this.스택[this.스택.length - 1]}의 일치하는 여는 괄호가 없습니다.`;
        }
        return true;
    }
    여는_괄호인지(문자) {
        return ["(", "[", "{"].includes(문자);
    }
    닫는_괄호인지(문자) {
        return [")", "]", "}"].includes(문자);
    }
    일치하는지(여는_괄호, 닫는_괄호) {
        let 해시 = {
            "(": ")",
            "[": "]",
            "{": "}",
        };
        return 해시[여는_괄호] === 닫는_괄호;
    }
}
let $린터 = new 린터();
console.log($린터.린트("(var x = { y: [1, 2, 3] })")); // true
console.log($린터.린트("var x = { y: [1, 2, 3] })")); // false
