class 트라이_노드 {
  public 자식_배열: { [알파벳: string]: 트라이_노드 } = {};
}

class 트라이 {
  private 루트 = new 트라이_노드();

  검색(단어: string) {
    let 현재_노드 = this.루트;

    for (const 문자 of 단어) {
      if (현재_노드.자식_배열[문자]) {
        현재_노드 = 현재_노드.자식_배열[문자];
      } else {
        return null;
      }
    }
    return 현재_노드;
  }

  삽입(단어: string) {
    let 현재_노드 = this.루트;

    for (const 문자 of 단어) {
      if (현재_노드.자식_배열[문자]) {
        현재_노드 = 현재_노드.자식_배열[문자];
      } else {
        const 새_노드 = new 트라이_노드();
        현재_노드.자식_배열[문자] = 새_노드;
        현재_노드 = 새_노드;
      }
    }

    현재_노드.자식_배열['*'] = null;
  }

  자동_완성하기(접두사: string) {
    let 현재_노드 = this.검색(접두사);

    if (!현재_노드) {
      return null;
    }

    return this.모든_단어_나열하기(현재_노드, 접두사);
  }

  자동_정정하기(단어: string) {
    let 지금까지_찾은_단어 = '';
    let 현재_노드 = this.루트;

    for (const 문자 of 단어) {
      if (현재_노드.자식_배열[문자]) {
        지금까지_찾은_단어 += 문자;
        현재_노드 = 현재_노드.자식_배열[문자];
      } else {
        return 지금까지_찾은_단어 + this.모든_단어_나열하기(현재_노드)[0];
      }
    }

    return 단어;
  }

  모든_단어_나열하기(노드: 트라이_노드 = null, 단어: string = '', 단어_배열: string[] = []) {
    let 현재_노드 = 노드 || this.루트;

    for (const [알파벳, 자식_노드] of Object.entries(현재_노드.자식_배열)) {
      if (알파벳 === '*') {
        단어_배열.push(단어);
      } else {
        this.모든_단어_나열하기(자식_노드, 단어 + 알파벳, 단어_배열);
      }
    }

    return 단어_배열;
  }
}

const $트라이 = new 트라이();
$트라이.삽입('ace');
$트라이.삽입('act');
$트라이.삽입('bad');
$트라이.삽입('bake');
$트라이.삽입('bat');
$트라이.삽입('batter');
$트라이.삽입('can');
$트라이.삽입('cab');
$트라이.삽입('cat');
$트라이.삽입('catnap');
$트라이.삽입('catnip');

console.log($트라이.검색('cab')); // 트라이_노드 { '자식_배열': { '*': null } }
console.log($트라이.모든_단어_나열하기()); // ['ace','act','bad','bake','bat','batter','can','cab','cat','catnap','catnip']
console.log($트라이.자동_완성하기('a')); // [ 'ace', 'act' ]
console.log($트라이.자동_완성하기('ca')); // [ 'can', 'cab', 'cat', 'catnap', 'catnip' ]
console.log($트라이.자동_정정하기('catnip')); // can
