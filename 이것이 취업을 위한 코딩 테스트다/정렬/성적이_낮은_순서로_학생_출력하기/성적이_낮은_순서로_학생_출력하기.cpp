#include <iostream>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

class Student {
  public:
    string name;
    int score;
    Student(string name, int score) {
      this->name = name;
      this->score = score;
    }

    bool operator <(Student &other) {
      return this-> score < other.score;
    }
};

int main() {
  int n;
  cin >> n;
  vector<Student>students;
  string name;
  int score;

  for(int i = 0; i < n; i++) {
    cin >> name >> score;
    students.push_back(Student(name, score));
  }

  sort(students.begin(), students.end());

  for(int i = 0; i < students.size(); i++) {
    cout << students[i].name << " ";
  }

  return 0;
}