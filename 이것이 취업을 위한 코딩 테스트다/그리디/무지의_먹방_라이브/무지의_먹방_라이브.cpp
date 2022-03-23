#include <iostream>
#include <string>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

bool compare(pair<int, int>a, pair<int, int>b) {
  return a.second < b.second;
}

int solution(vector<int> food_times, long long k) {
  long long summary = 0;

  for (int i = 0; i < food_times.size(); i++) {
    summary += food_times[i];
  }

  if (summary <= k) return -1;

  priority_queue<pair<int, int>> pq;

  for (int i = 0; i < food_times.size(); i++) {
    pq.push({-food_times[i], i + 1});
  }

  summary = 0;
  long long previous = 0;
  long long length = food_times.size();

  while (summary + ((-pq.top().first - previous) * length) <= k) {
    int now = -pq.top().first;
    pq.pop();
    summary += (now - previous) * length--;
    previous = now;
  }

  vector<pair<int, int>> result;

  while (!pq.empty()) {
    int food_time = -pq.top().first;
    int num = pq.top().second;
    pq.pop();
    result.push_back({food_time, num});
  }

  sort(result.begin(), result.end(), compare);

  return result[(k - summary) % length].second;
}

// #include <iostream>
// #include <string>
// #include <vector>
// #include <algorithm>

// using namespace std;

// int getTotalFoodTimes(vector<int> food_times);
// bool compare(pair<int, int>a, pair<int, int>b);
// bool compare1(pair<int, int>a, pair<int, int>b);
// vector<pair<int, int>> getRestFoods(vector<pair<int, int>> foods, int order);

// int solution(vector<int> food_times, long long k) {
//     long long total_food_time = getTotalFoodTimes(food_times);
    
//     if (total_food_time <= k) {
//         return -1;
//     }

//     // cout << total_food_time << endl;
    
//     vector<pair<int, int>> foods;
    
//     for (int i = 0; i < food_times.size(); i++) {
//         foods.push_back({food_times[i], i + 1});
//     }
    
//     sort(foods.begin(), foods.end(), compare1);
    
//     long long current_total_time = 0;
//     long long previous_food_time = 0;
//     long long previous_total_time = 0;
//     long long size = foods.size();
    
//     for (int i = 0; i < foods.size(); i++) {
//         cout << foods[i].first << ' ' << foods[i].second << endl;
//     }
    
//     // while (true) {
//         long long food_time = foods.back().first;
//         foods.pop_back();
//         previous_total_time = (food_time - previous_food_time) * (size--);
//         current_total_time += previous_total_time;
//         previous_food_time = food_time;
        
//             cout << current_total_time;
//             cout << k;
//             cout << (current_total_time > k);
//         if (current_total_time > k == 1) {
//             cout << "s";
//             current_total_time -= previous_total_time;
//             sort(foods.begin(), foods.end(), compare);
            
//             return foods[(k - current_total_time) % foods.size()].second;
//         }
//     // }
// }

// int getTotalFoodTimes(vector<int> food_times) {
//     long long total = 0;
    
//     for (int i = 0; i < food_times.size(); i++) {
//         total += food_times[i];    
//     }
    
//     return total;
// }


// bool compare(pair<int, int>a, pair<int, int>b) {
// 	return a.second < b.second;
// }

// bool compare1(pair<int, int>a, pair<int, int>b) {
// 	return a.first > b.first;
// }