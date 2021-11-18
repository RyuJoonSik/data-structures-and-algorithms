/* 
built in object
var letters = [];
var word = 'freeCodeCamp';
var rword = '';

for(let i = 0; i < word.length; i++){
    letters.push(word[i]);
}

for(let i = 0; i < word.length; i++){
    rword += letters.pop();
}

if(rword === word){
    console.log(word + " is a palindrome.");
}
else{
    console.log(word + " is not a palindrome.");
} 
 */
function Stack(){
    this.count = 0;
    this.storage = {};

    this.push = function(value){
        this.storage[this.count] = value;
        this.count++;
    }

    this.pop = function(){
        if(this.count === 0){
            return undefined;
        }

        this.count--;
        var result = this.storage[this.count];
        delete this.storage[this.count];
        return result;
    }

    this.size = function(){
        return this.count;
    }

    this.peek = function(){
        return this.storage[this.count-1];
    }

}

var myStack = new Stack();

myStack.push(1);
myStack.push(2);
console.log(myStack.peek());
console.log(myStack.storage);
console.log(myStack.pop());
console.log(myStack.storage);
console.log(myStack.peek());
console.log(myStack.storage);
