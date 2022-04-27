class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        print('recursive start')
        print('string : ', s)
        print('set(s) : ',set(s))
        print('sorted(set(s)) : ', sorted(set(s)))
        for char in sorted(set(s)):
            suffix = s[s.index(char):]
            print('suffix : ', suffix)
            print('set(suffix) : ', set(suffix))
            
            if set(s) == set(suffix):
                return char + self.removeDuplicateLetters(suffix.replace(char, ''))
        
        return ''

class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        counter, seen, stack = collections.Counter(s), set(), []
        # print('counter : ', counter)
        # print('seen : ', seen)
        # print('stack : ', stack)
        
        for char in s:
            # print('loop start')
            # print('string : ', s)
            # print('char : ', char)
            counter[char] -= 1
            # print(counter)
            
            if char in seen:
                continue
            
            while stack and char < stack[-1] and counter[stack[-1]] > 0:
                seen.remove(stack.pop())
            
            stack.append(char)
            # print('stack : ', stack)
            seen.add(char)
            # print('seen : ', seen)
            
        return ''.join(stack)