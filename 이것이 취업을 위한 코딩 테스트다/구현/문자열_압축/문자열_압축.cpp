#include <string>
#include <vector>

using namespace std;

int solution(string s) {
    int answer = s.size();
    int max_offset = answer / 2 + 1;

    for (int offset = 1; offset < max_offset; offset += 1) {
      string current_word = s.substr(0, offset);
      string result = "";
      int count = 1;
      
      for (int i = offset; i < s.size(); i += offset) {
        string next_word = s.substr(i, offset);

        if (current_word == next_word) {
          count += 1;
        } else {
          result += (count > 1) ? (to_string(count)) + current_word : current_word;
          count = 1;
          current_word = next_word;
        }

      }
      result += (count > 1) ? (to_string(count)) + current_word: current_word;

      answer = min(int(result.size()), answer);
    }

    return answer;
}