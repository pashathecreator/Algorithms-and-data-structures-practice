#include <cassert>
#include <iostream>

class Fibonacci {
 public:
  static int get_last_digit(int n) {
    assert(n >= 1);
    int a = 1;
    int b = 1;
    int c;
    for (int i = 2; i < n; i++) {
        c = (a + b) % 10;
        a = b;
        b = c;
    }

    return c;
  }
};

int main(void) {
  int n;
  std::cin >> n;
  std::cout << Fibonacci::get_last_digit(n) << std::endl;
  return 0;
}