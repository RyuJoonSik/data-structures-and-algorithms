class Solution {
  public int solution(String s) {
    int answer = s.length();
    int max_offset = answer / 2 + 1;

    for (int offset = 1; offset < max_offset; offset += 1) {
      String current_word = s.substring(0, offset);
      String result = "";
      int count = 1;

      for (int i = offset; i < s.length(); i += offset) {
        String next_word = "";
        for (int next_word_i = i; next_word_i < i + offset; next_word_i += 1) {
          if (next_word_i < s.length()) {
            next_word += s.charAt(next_word_i);
          }
        }

        if (current_word.equals(next_word)) {
          count += 1;
        } else {
          result += count > 1 ? (count + current_word) : current_word;
          count = 1;
          current_word = next_word;
        }
      }

      result += count > 1 ? (count + current_word) : current_word;
      answer = Math.min(answer, result.length());
    }

    return answer;
  }
}