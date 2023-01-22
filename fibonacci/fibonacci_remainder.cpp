#include <iostream>
#include <vector>


int main()
{
    long long n = 0;
    long long m = 0;
    std::cin >> n >> m;
    std::vector<long long> fib(2);
    fib[0] = 0;
    fib[1] = 1;
    long long t = 0;
    // for (long long j = 2; j < n; ++j) {
    for (long long j = 2; j < m*m+1; ++j) {
        fib.push_back((fib[j - 1] + fib[j - 2]) % m);
        ++t;
        if ((fib[j] == 1) && (fib[j - 1] == 0)) break;
    }

    std::cout << fib[(n % t)] << std::endl;
    return 0;
}