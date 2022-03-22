def solution(food_times, k):
    total_time = 0
    
    for time in food_times:
        total_time += time
    
    if total_time <= k:
        return -1
    
    foods = []
    
    for i in range(len(food_times)):
        foods.append((food_times[i], i + 1))
    
    foods.sort()
    current_total_time = 0
    prev_total_time = 0
    
    for i in range(len(foods)):
        food_time = foods[i][0]
        rest_foods_length = (len(foods) - i)
        total_food_time = (food_time - prev_total_time) * rest_foods_length
        current_total_time += total_food_time
        prev_total_time = food_time
        
        if current_total_time > k:
            current_total_time -= total_food_time
            
            rest_foods = foods[i:]
            rest_foods.sort(key = lambda x: x[1])
            
            return rest_foods[(k - current_total_time) % rest_foods_length][1]