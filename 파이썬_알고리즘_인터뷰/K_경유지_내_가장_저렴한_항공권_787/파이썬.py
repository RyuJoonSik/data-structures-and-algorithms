class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, K: int) -> int:
        graph = {}
        d = {}
        
        for [u, v, w] in flights:
            if u not in graph:
                graph[u] = []
                
            graph[u].append((v, w))
            
        Q = [(0, src, K)]
        
        while Q:
            price, node, k = heapq.heappop(Q)
            d[node] = k
            print(d)
            if node == dst:
                return price
            
            if k < 0:
                continue
                
            if node in graph:
                for v, w, in graph[node]:
                    if v not in d or d[v] < k - 1:
                        heapq.heappush(Q, (price + w, v, k - 1))
                    
        
        return -1