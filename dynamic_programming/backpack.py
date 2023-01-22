def knapsack(W, c):
    d = []
    n = len(c)
    for i in range(n+1):
        d.append([0] * (W + 1))
    for i in range(1, n+1):
        for w in range(1, W+1):
            d[i][w] = d[i-1][w]
            if c[i-1] <= w:
                d[i][w] = max(d[i][w], d[i-1][w-c[i-1]] + c[i-1])
    return d[n][W]


if __name__ == '__main__':
    W, n = [int(i) for i in input().split()]
    weights = [int(i) for i in input().split()]
    print(knapsack(W, weights))