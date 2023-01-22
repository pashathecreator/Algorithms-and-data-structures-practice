/* 
*/


#include <iostream>


using namespace std;

int fib(int n) {
    int numbers[n];
    numbers[0] = 1;
    numbers[1] = 1;
    for (int i = 2; i < n; i++) {
        numbers[i] = numbers[i - 1] + numbers[i - 2];
    }

    return numbers[n - 1];
}

int main() {
    int n;
    cin >> n;
    cout << fib(n);
}
