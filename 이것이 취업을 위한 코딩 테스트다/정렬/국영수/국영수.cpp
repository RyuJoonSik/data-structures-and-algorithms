#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

struct Student {
  string name;
  int kor;
  int eng;
  int m;

  Student(string name, int kor, int eng, int m) {
    this->name = name;
    this->kor = kor;
    this->eng = eng;
    this->m = m;
  }

  bool operator < (Student &other) {
    if (this->kor == other.kor && this->eng == other.eng && this->m == other.m) {
      return this->name < other.name;
    }
    if (this->kor == other.kor && this->eng == other.eng) {
      return this->m > other.m;
    }
    if (this->kor == other.kor) {
      return this->eng < other.eng;
    }
    return this->kor > other.kor;
  }
};

int n;
vector<Student> v;

int main(void) {
  cin >> n;
  for (int i = 0; i < n; i += 1) {
    string name;
    int kor;
    int eng;
    int m;
    cin >> name >> kor >> eng >> m;
    v.push_back(Student(name, kor, eng, m));
  }

  sort(v.begin(), v.end());

  for (int i = 0; i < n; i += 1) {
    cout << v[i].name << endl;
  }
}