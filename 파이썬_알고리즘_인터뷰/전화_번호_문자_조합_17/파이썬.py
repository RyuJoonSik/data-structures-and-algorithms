class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return []
        
        dic = {
            "2": "abc",
            "3": "def",
            "4": "ghi",
            "5": "jkl",
            "6": "mno",
            "7": "pqrs",
            "8": "tuv",
            "9": "wxyz",
        }
        result =[]
        
        def dfs(index, path):
            if len(path) == len(digits):
                result.append(path)
                
                return
            
            for i in range(index, len(digits)):
                print(i)
                for j in dic[digits[i]]:
                    dfs(i + 1, path + j)
        
        dfs(0, '')
        
        return result